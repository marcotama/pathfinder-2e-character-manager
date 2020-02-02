package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum MagicalDamageTypeEnum implements DamageTypeEnum {
    ACID("acid"),
    AIR("air"),
    COLD("cold"),
    EARTH("earth"),
    ELECTRICITY("electricity"),
    FIRE("fire"),
    WATER("water");

    private final String value;
    private final static Map<String, MagicalDamageTypeEnum> CONSTANTS = new HashMap<>();

    static {
        for (MagicalDamageTypeEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    MagicalDamageTypeEnum(String value) {
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
    public static MagicalDamageTypeEnum fromValue(String value) {
        MagicalDamageTypeEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
