package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum CreatureSizeEnum implements WeaponTraitEnum {
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large");

    private final String value;
    private final static Map<String, CreatureSizeEnum> CONSTANTS = new HashMap<>();

    static {
        for (CreatureSizeEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    CreatureSizeEnum(String value) {
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
    public static CreatureSizeEnum fromValue(String value) {
        CreatureSizeEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
