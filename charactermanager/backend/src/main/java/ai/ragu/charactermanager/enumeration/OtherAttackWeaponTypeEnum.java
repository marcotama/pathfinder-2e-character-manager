package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum OtherAttackWeaponTypeEnum implements AttackProficiencyEnum {
    UNARMED_ATTACKS("unarmedAttacks"),
    SIMPLE_WEAPONS("simpleWeapons"),
    MARTIAL_WEAPONS("martialWeapons"),
    ALCHEMICAL_BOMBS("alchemicalBombs");

    private final String value;
    private final static Map<String, OtherAttackWeaponTypeEnum> CONSTANTS = new HashMap<>();

    static {
        for (OtherAttackWeaponTypeEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    OtherAttackWeaponTypeEnum(String value) {
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
    public static OtherAttackWeaponTypeEnum fromValue(String value) {
        OtherAttackWeaponTypeEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
