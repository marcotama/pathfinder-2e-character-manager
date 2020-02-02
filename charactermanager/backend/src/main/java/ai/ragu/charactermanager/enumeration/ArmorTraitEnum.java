package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum ArmorTraitEnum {
    COMFORT("comfort"),
    FLEXIBLE("flexible"),
    NOISY("noisy"),
    BULWARK("bulwark");

    private final String value;
    private final static Map<String, ArmorTraitEnum> CONSTANTS = new HashMap<>();

    static {
        for (ArmorTraitEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    ArmorTraitEnum(String value) {
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
    public static ArmorTraitEnum fromValue(String value) {
        ArmorTraitEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
