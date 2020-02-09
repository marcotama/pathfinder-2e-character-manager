package ai.ragu.charactermanager.content.classes.alchemist;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum AlchemistResearchFieldEnum {
    BOMBER("bomber"),
    CHIRURGEON("chirurgeon"),
    MUTAGENIST("mutagenist");

    private final String value;
    private final static Map<String, AlchemistResearchFieldEnum> CONSTANTS = new HashMap<>();

    static {
        for (AlchemistResearchFieldEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    AlchemistResearchFieldEnum(String value) {
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
    public static AlchemistResearchFieldEnum fromValue(String value) {
        AlchemistResearchFieldEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
