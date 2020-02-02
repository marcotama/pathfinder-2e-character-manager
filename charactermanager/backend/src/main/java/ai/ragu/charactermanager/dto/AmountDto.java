package ai.ragu.charactermanager.dto;

import ai.ragu.charactermanager.enumeration.CurrencyEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class AmountDto {

    @JsonProperty("code")
    @JsonPropertyDescription("A unique representation for this amount")
    @ToString.Include
    @EqualsAndHashCode.Include
    private String code;

    @JsonProperty("subAmounts")
    @JsonPropertyDescription("The amounts in each currency")
    private Map<CurrencyEnum, Integer> subAmounts;

    public AmountDto(Map<CurrencyEnum, Integer> subAmounts) {
        int valueInCp = AmountDto.calcValueInCP(subAmounts);
        Map<CurrencyEnum, Integer> normalisedSubAmounts = calcNormalisedSubAmounts(valueInCp);
        this.subAmounts = Collections.unmodifiableMap(normalisedSubAmounts);
        this.code = normalisedSubAmounts.entrySet().stream()
                .map(entry -> String.format("%d %s", entry.getValue(), entry.getKey()))
                .collect(Collectors.joining("+"));
    }

    private static int calcValueInCP(Map<CurrencyEnum, Integer> subAmounts) {
        int valueInCp = 0;
        for (Map.Entry<CurrencyEnum, Integer> entry : subAmounts.entrySet()) {
            CurrencyEnum currency = entry.getKey();
            int units = entry.getValue();
            valueInCp += units * CurrencyEnum.getValueInCP(currency);
        }
        return valueInCp;
    }

    private static Map<CurrencyEnum, Integer> calcNormalisedSubAmounts(int valueInCP) {
        int v = valueInCP;
        Map<CurrencyEnum, Integer> amounts = new HashMap<>();
        for (CurrencyEnum currency : CurrencyEnum.getSortedValues()) {
            int units = v; // curr.value
            if (units > 0) {
                amounts.put(currency, units);
            }
            v %= CurrencyEnum.getValueInCP(currency);
        }
        return amounts;
    }

    public String toString() {
        return this.code.replaceAll("\\+", " + ");
    }
}
