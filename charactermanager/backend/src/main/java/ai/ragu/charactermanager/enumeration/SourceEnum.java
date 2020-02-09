package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum SourceEnum implements WeaponTraitEnum {
    CORE_RULEBOOK("coreRulebook"),
    LOST_OMENS("lostOmensCharacterGuide");

    private final String value;
    private final static Map<String, SourceEnum> CONSTANTS = new HashMap<>();

    static {
        for (SourceEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    SourceEnum(String value) {
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
    public static SourceEnum fromValue(String value) {
        SourceEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
