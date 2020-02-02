package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum InventoryItemEnum {
    // TODO
    LEATHER("leather"),
    COMPOSITE("composite"),
    CHAIN("chain"),
    PLATE("plate");

    private final String value;
    private final static Map<String, InventoryItemEnum> CONSTANTS = new HashMap<>();

    static {
        for (InventoryItemEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    InventoryItemEnum(String value) {
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
    public static InventoryItemEnum fromValue(String value) {
        InventoryItemEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
