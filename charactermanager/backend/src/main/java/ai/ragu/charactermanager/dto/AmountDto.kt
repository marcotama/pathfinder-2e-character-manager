package ai.ragu.charactermanager.dto

import ai.ragu.charactermanager.enumeration.CurrencyEnum
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import lombok.Data
import lombok.EqualsAndHashCode
import lombok.ToString
import java.util.*
import java.util.stream.Collectors

@Data
class AmountDto(subAmounts: Map<CurrencyEnum, Int>) {
    @JsonProperty("code")
    @JsonPropertyDescription("A unique representation for this amount")
    @ToString.Include
    @EqualsAndHashCode.Include
    private val code: String
    @JsonProperty("subAmounts")
    @JsonPropertyDescription("The amounts in each currency")
    private val subAmounts: Map<CurrencyEnum, Int>

    override fun toString(): String {
        return code.replace("\\+".toRegex(), " + ")
    }

    companion object {
        private fun calcValueInCP(subAmounts: Map<CurrencyEnum, Int>): Int {
            var valueInCp = 0
            for ((currency, units) in subAmounts) {
                valueInCp += units * CurrencyEnum.Companion.getValueInCP(currency)
            }
            return valueInCp
        }

        private fun calcNormalisedSubAmounts(valueInCP: Int): Map<CurrencyEnum, Int> {
            var v = valueInCP
            val amounts: MutableMap<CurrencyEnum, Int> = HashMap()
            for (currency in CurrencyEnum.Companion.getSortedValues()) {
                val units = v // curr.value
                if (units > 0) {
                    amounts[currency] = units
                }
                v %= CurrencyEnum.Companion.getValueInCP(currency)
            }
            return amounts
        }
    }

    init {
        val valueInCp = calcValueInCP(subAmounts)
        val normalisedSubAmounts = calcNormalisedSubAmounts(valueInCp)
        this.subAmounts = Collections.unmodifiableMap(normalisedSubAmounts)
        code = normalisedSubAmounts.entries.stream()
                .map { entry: Map.Entry<CurrencyEnum, Int> -> String.format("%d %s", entry.value, entry.key) }
                .collect(Collectors.joining("+"))
    }
}