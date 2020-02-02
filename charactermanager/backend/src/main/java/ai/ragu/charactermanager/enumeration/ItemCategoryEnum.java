package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum ItemCategoryEnum {
    LIGHT("light"),
    MEDIUM("medium"),
    HEAVY("heavy");

    private final String value;
    private final static Map<String, ItemCategoryEnum> CONSTANTS = new HashMap<>();

    static {
        for (ItemCategoryEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    ItemCategoryEnum(String value) {
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
    public static ItemCategoryEnum fromValue(String value) {
        ItemCategoryEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
