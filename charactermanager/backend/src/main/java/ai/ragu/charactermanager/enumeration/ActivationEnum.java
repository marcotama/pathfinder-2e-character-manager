package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum ActivationEnum {
    INTERACT("interact"),
    STRIKE("strike"),
    ONE_ACTION("oneAction"),
    ONE_OR_MORE_DAYS("oneOrMoreDays"),
    BULWARK("bulwark");

    private final String value;
    private final static Map<String, ActivationEnum> CONSTANTS = new HashMap<>();

    static {
        for (ActivationEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    ActivationEnum(String value) {
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
    public static ActivationEnum fromValue(String value) {
        ActivationEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
