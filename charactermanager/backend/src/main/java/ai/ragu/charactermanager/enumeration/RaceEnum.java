package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum RaceEnum implements WeaponTraitEnum {
    DWARF("dwarf"),
    ELF("elf"),
    GNOME("gnome"),
    GOBLIN("goblin"),
    HALFLING("halfling"),
    HUMAN("human");

    private final String value;
    private final static Map<String, RaceEnum> CONSTANTS = new HashMap<>();

    static {
        for (RaceEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    RaceEnum(String value) {
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
    public static RaceEnum fromValue(String value) {
        RaceEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
