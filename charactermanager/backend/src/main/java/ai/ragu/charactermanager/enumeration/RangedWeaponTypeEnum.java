package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum RangedWeaponTypeEnum implements AttackProficiencyEnum {
    DART("dart"),
    BOW("bow");

    private final String value;
    private final static Map<String, RangedWeaponTypeEnum> CONSTANTS = new HashMap<>();

    static {
        for (RangedWeaponTypeEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    RangedWeaponTypeEnum(String value) {
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
    public static RangedWeaponTypeEnum fromValue(String value) {
        RangedWeaponTypeEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
