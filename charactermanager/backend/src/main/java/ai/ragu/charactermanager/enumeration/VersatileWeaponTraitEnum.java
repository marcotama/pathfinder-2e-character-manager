package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum VersatileWeaponTraitEnum implements WeaponTraitEnum {
    VERSATILE_S(String.format("versatile_%s", PhysicalDamageTypeEnum.SLASHING)),
    VERSATILE_P(String.format("versatile_%s", PhysicalDamageTypeEnum.PIERCING)),
    VERSATILE_B(String.format("versatile_%s", PhysicalDamageTypeEnum.BLUDGEONING));

    private final String value;
    private final static Map<String, VersatileWeaponTraitEnum> CONSTANTS = new HashMap<>();

    static {
        for (VersatileWeaponTraitEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    VersatileWeaponTraitEnum(String value) {
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
    public static VersatileWeaponTraitEnum fromValue(String value) {
        VersatileWeaponTraitEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
