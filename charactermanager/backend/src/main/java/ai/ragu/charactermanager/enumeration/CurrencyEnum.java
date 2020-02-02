package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum CurrencyEnum implements Comparable<CurrencyEnum> {
    PP("pp"),
    GP("gp"),
    SP("sp"),
    CP("cp");

    private final String value;
    private final static Map<String, CurrencyEnum> CONSTANTS = new HashMap<>();

    static {
        for (CurrencyEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    CurrencyEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public static CurrencyEnum fromValue(String value) {
        CurrencyEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

    public static List<CurrencyEnum> getSortedValues() {
        return List.of(PP, GP, SP, CP);
    }

    public static int getValueInCP(CurrencyEnum currency) {
        switch (currency) {
            case CP: return 1;
            case SP: return 10;
            case GP: return 100;
            case PP: return 1000;
            default: throw new IllegalArgumentException(String.format("Unknown currency: %s", currency.toString()));
        }
    }
}
