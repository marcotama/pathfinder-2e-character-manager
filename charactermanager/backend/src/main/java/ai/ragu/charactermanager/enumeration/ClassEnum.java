package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum ClassEnum implements WeaponTraitEnum {
    ALCHEMIST("alchemist"),
    BARBARIAN("barbarian"),
    BARD("bard"),
    CHAMPION("champion"),
    CLERIC("cleric"),
    DRUID("druid"),
    FIGHTER("fighter"),
    MONK("monk"),
    RANGER("ranger"),
    ROGUE("rogue"),
    SORCERER("sorcerer"),
    WIZARD("wizard");

    private final String value;
    private final static Map<String, ClassEnum> CONSTANTS = new HashMap<>();

    static {
        for (ClassEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    ClassEnum(String value) {
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
    public static ClassEnum fromValue(String value) {
        ClassEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
