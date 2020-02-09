package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum LanguageEnum {
    AQUAN("aquan"),
    BOGGARD("boggard"),
    COMMON("common"),
    CELESTIAL("celestial"),
    DWARVEN("dwarven"),
    DRACONIC("draconic"),
    ELVEN("elven"),
    GNOMISH("gnomish"),
    GNOLL("gnoll"),
    GOBLIN("goblin"),
    HALFLING("halfling"),
    IRUXI("iruxi"),
    JOTUN("jotun"),
    ORCISH("orcish"),
    SYLVAN("sylvan"),
    TERRAN("terran"),
    UNDERCOMMON("undercommon");

    private final String value;
    private final static Map<String, LanguageEnum> CONSTANTS = new HashMap<>();

    static {
        for (LanguageEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    LanguageEnum(String value) {
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
    public static LanguageEnum fromValue(String value) {
        LanguageEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
