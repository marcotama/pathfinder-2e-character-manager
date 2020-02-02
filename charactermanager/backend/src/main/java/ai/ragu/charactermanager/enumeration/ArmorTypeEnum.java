package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum ArmorTypeEnum {
    LEATHER("leather"),
    COMPOSITE("composite"),
    CHAIN("chain"),
    PLATE("plate");

    private final String value;
    private final static Map<String, ArmorTypeEnum> CONSTANTS = new HashMap<>();

    static {
        for (ArmorTypeEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    ArmorTypeEnum(String value) {
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
    public static ArmorTypeEnum fromValue(String value) {
        ArmorTypeEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
