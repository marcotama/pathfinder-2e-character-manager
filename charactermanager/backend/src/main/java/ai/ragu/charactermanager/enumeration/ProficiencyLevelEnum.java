package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum ProficiencyLevelEnum {
    UNTRAINED("untrained"),
    TRAINED("trained"),
    EXPERT("expert"),
    MASTER("master"),
    LEGENDARY("legendary");

    private final String value;
    private final static Map<String, ProficiencyLevelEnum> CONSTANTS = new HashMap<>();

    static {
        for (ProficiencyLevelEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    ProficiencyLevelEnum(String value) {
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
    public static ProficiencyLevelEnum fromValue(String value) {
        ProficiencyLevelEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

    public int getComparableValue() {
        switch (this) {
            case UNTRAINED: return 0;
            case TRAINED: return 1;
            case EXPERT: return 2;
            case MASTER: return 3;
            case LEGENDARY: return 4;
            default: throw new IllegalArgumentException(String.format("Unknown proficiency level: %s", this));
        }
    }

    public int getModifier() {
        switch (this) {
            case UNTRAINED: return 0;
            case TRAINED: return 2;
            case EXPERT: return 4;
            case MASTER: return 6;
            case LEGENDARY: return 8;
            default: throw new IllegalArgumentException(String.format("Unknown proficiency level: %s", this));
        }
    }
}
