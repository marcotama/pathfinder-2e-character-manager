package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum DefenseProficiencyEnum {
    UNARMORED_DEFENSE("unarmored_defense"),
    LIGHT_ARMOR("light_armor"),
    MEDIUM_ARMOR("medium_armor"),
    HEAVY_ARMOR("heavy_armor");

    private final String value;
    private final static Map<String, DefenseProficiencyEnum> CONSTANTS = new HashMap<>();

    static {
        for (DefenseProficiencyEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    DefenseProficiencyEnum(String value) {
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
    public static DefenseProficiencyEnum fromValue(String value) {
        DefenseProficiencyEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
