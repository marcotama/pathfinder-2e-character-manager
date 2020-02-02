package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum SavingThrowEnum {
    FORTITUDE("fortitude"),
    REFLEX("reflex"),
    WILL("will");

    private final String value;
    private final static Map<String, SavingThrowEnum> CONSTANTS = new HashMap<>();

    static {
        for (SavingThrowEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    SavingThrowEnum(String value) {
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
    public static SavingThrowEnum fromValue(String value) {
        SavingThrowEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
