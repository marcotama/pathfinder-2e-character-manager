package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum AbilityScoreEnum implements WeaponTraitEnum {
    STR("str"),
    DEX("dex"),
    CON("con"),
    INT("int"),
    WIS("wis"),
    CHA("cha");

    private final String value;
    private final static Map<String, AbilityScoreEnum> CONSTANTS = new HashMap<>();

    static {
        for (AbilityScoreEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    AbilityScoreEnum(String value) {
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
    public static AbilityScoreEnum fromValue(String value) {
        AbilityScoreEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
