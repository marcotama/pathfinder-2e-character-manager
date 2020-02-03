package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum TwoHandWeaponTraitEnum implements WeaponTraitEnum {
    TWO_HAND_D8(String.format("twoHand_%s", DieEnum.D8)),
    TWO_HAND_D10(String.format("twoHand_%s", DieEnum.D10)),
    TWO_HAND_D12(String.format("twoHand_%s", DieEnum.D12));

    private final String value;
    private final static Map<String, TwoHandWeaponTraitEnum> CONSTANTS = new HashMap<>();

    static {
        for (TwoHandWeaponTraitEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    TwoHandWeaponTraitEnum(String value) {
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
    public static TwoHandWeaponTraitEnum fromValue(String value) {
        TwoHandWeaponTraitEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
