package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum OtherWeaponTraitEnum implements WeaponTraitEnum {
    AGILE("agile"),
    FINESSE("finesse"),
    FREE_HAND("freeHand"),
    SHOVE("shove"),
    REACH("reach"),
    TRIP("trip"),
    PARRY("parry"),
    SWEEP("sweep"),
    FORCEFUL("forceful"),
    BACKSWING("backswing"),
    NONLETHAL("nonlethal"),
    ATTACHED_TO_SHIELD("attachedToShield"),
    BACKSTABBER("backstabber"),
    TWIN("twin");

    private final String value;
    private final static Map<String, OtherWeaponTraitEnum> CONSTANTS = new HashMap<>();

    static {
        for (OtherWeaponTraitEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    OtherWeaponTraitEnum(String value) {
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
    public static OtherWeaponTraitEnum fromValue(String value) {
        OtherWeaponTraitEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
