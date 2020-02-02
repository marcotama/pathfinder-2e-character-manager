package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum ThrownWeaponTraitEnum implements WeaponTraitEnum {
    THROWN_10FT(10),
    THROWN_20FT(20);

    private final Integer value;
    private final static Map<Integer, ThrownWeaponTraitEnum> CONSTANTS = new HashMap<>();

    static {
        for (ThrownWeaponTraitEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    ThrownWeaponTraitEnum(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("Thrown %d feet", this.value);
    }

    @JsonValue
    public Integer value() {
        return this.value;
    }

    @JsonCreator
    public static ThrownWeaponTraitEnum fromValue(Integer value) {
        ThrownWeaponTraitEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value.toString());
        } else {
            return constant;
        }
    }
}
