package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum JoustingWeaponTraitEnum implements WeaponTraitEnum {
    JOUSTING_D6(String.format("jousting_%s", DieEnum.D6));

    private final String value;
    private final static Map<String, JoustingWeaponTraitEnum> CONSTANTS = new HashMap<>();

    static {
        for (JoustingWeaponTraitEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    JoustingWeaponTraitEnum(String value) {
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
    public static JoustingWeaponTraitEnum fromValue(String value) {
        JoustingWeaponTraitEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
