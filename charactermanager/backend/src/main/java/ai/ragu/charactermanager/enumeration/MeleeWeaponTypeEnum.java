package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum MeleeWeaponTypeEnum implements AttackProficiencyEnum {
    SWORD("sword"),
    SPEAR("spear"),
    HAMMER("hammer"),
    POLEARM("polearm"),
    KNIFE("knife"),
    CLUB("club"),
    FLAIL("flail"),
    BRAWLING("brawling"),
    AXE("axe"),
    PICK("pick"),
    SHIELD("shield"),
    WHIP("whip");

    private final String value;
    private final static Map<String, MeleeWeaponTypeEnum> CONSTANTS = new HashMap<>();

    static {
        for (MeleeWeaponTypeEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    MeleeWeaponTypeEnum(String value) {
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
    public static MeleeWeaponTypeEnum fromValue(String value) {
        MeleeWeaponTypeEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
