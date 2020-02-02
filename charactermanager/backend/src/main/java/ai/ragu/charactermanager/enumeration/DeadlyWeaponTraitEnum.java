package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum DeadlyWeaponTraitEnum implements WeaponTraitEnum {
    DEADLY_D6(String.format("deadly_%s", DieEnum.D6)),
    DEADLY_D8(String.format("deadly_%s", DieEnum.D8)),
    DEADLY_D10(String.format("deadly_%s", DieEnum.D10));

    private final String value;
    private final static Map<String, DeadlyWeaponTraitEnum> CONSTANTS = new HashMap<>();

    static {
        for (DeadlyWeaponTraitEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    DeadlyWeaponTraitEnum(String value) {
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
    public static DeadlyWeaponTraitEnum fromValue(String value) {
        DeadlyWeaponTraitEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
