package ai.ragu.charactermanager.content.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum AlchemicalToolEnum implements AlchemicalItemEnum {
    // Level 1
    SMOKESTICK_LESSER("smokestick_lesser"),
    SNAKE_OIL("snake_oil"),
    SUNROD("sunrod"),
    TINDERTWIG("tindertwig"),

    // Level 2
    SILVERSHEEN("silversheen"),

    // Level 7
    SMOKESTICK_GREATER("smokestick_greater"),

    // Level 20
    PHILOSOPHER_S_STONE("philosopher_s_stone");

    private final String value;
    private final static Map<String, AlchemicalToolEnum> CONSTANTS = new HashMap<>();

    static {
        for (AlchemicalToolEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    AlchemicalToolEnum(String value) {
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
    public static AlchemicalToolEnum fromValue(String value) {
        AlchemicalToolEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
