package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum DieEnum {
    D4(4),
    D6(6),
    D8(8),
    D10(10),
    D12(12),
    D20(20),
    D100(100);

    private final Integer value;
    private final static Map<Integer, DieEnum> CONSTANTS = new HashMap<>();

    static {
        for (DieEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    DieEnum(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("D%d", this.value);
    }

    @JsonValue
    public Integer value() {
        return this.value;
    }

    @JsonCreator
    public static DieEnum fromValue(Integer value) {
        DieEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value.toString());
        } else {
            return constant;
        }
    }
}
