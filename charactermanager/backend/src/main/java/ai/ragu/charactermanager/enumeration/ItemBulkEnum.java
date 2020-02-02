package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum ItemBulkEnum implements WeaponTraitEnum {
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large"),
    TWO("2");

    private final String value;
    private final static Map<String, ItemBulkEnum> CONSTANTS = new HashMap<>();

    static {
        for (ItemBulkEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    ItemBulkEnum(String value) {
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
    public static ItemBulkEnum fromValue(String value) {
        ItemBulkEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
