package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class CurrencyEnum(private val value: String) : Comparable<CurrencyEnum?> {
    PP("pp"), GP("gp"), SP("sp"), CP("cp");

    companion object {
        private val CONSTANTS: MutableMap<String, CurrencyEnum> = HashMap()
        @JsonCreator
        fun fromValue(value: String?): CurrencyEnum {
            val constant = CONSTANTS[value]
            return constant ?: throw IllegalArgumentException(value)
        }

        val sortedValues: List<CurrencyEnum>
            get() = java.util.List.of(PP, GP, SP, CP)

        fun getValueInCP(currency: CurrencyEnum): Int {
            return when (currency) {
                CP -> 1
                SP -> 10
                GP -> 100
                PP -> 1000
                else -> throw IllegalArgumentException(String.format("Unknown currency: %s", currency.toString()))
            }
        }

        init {
            for (c in values()) {
                CONSTANTS[ai.ragu.charactermanager.enumeration.c.value] = ai.ragu.charactermanager.enumeration.c
            }
        }
    }

    override fun toString(): String {
        return value
    }

    @JsonValue
    fun value(): String {
        return value
    }

}