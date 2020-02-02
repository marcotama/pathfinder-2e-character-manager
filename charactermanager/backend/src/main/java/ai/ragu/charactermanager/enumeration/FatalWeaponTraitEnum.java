package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum FatalWeaponTraitEnum implements WeaponTraitEnum {
    FATAL_D8(String.format("fatal_%s", DieEnum.D8)),
    FATAL_D10(String.format("fatal_%s", DieEnum.D10)),
    FATAL_D12(String.format("fatal_%s", DieEnum.D12));

    private final String value;
    private final static Map<String, FatalWeaponTraitEnum> CONSTANTS = new HashMap<>();

    static {
        for (FatalWeaponTraitEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    FatalWeaponTraitEnum(String value) {
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
    public static FatalWeaponTraitEnum fromValue(String value) {
        FatalWeaponTraitEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
