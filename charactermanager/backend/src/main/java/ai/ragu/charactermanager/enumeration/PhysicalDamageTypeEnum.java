package ai.ragu.charactermanager.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum PhysicalDamageTypeEnum implements DamageTypeEnum {
    BLUDGEONING("bludgeoning"),
    PIERCING("piercing"),
    SLASHING("slashing");

    private final String value;
    private final static Map<String, PhysicalDamageTypeEnum> CONSTANTS = new HashMap<>();

    static {
        for (PhysicalDamageTypeEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    PhysicalDamageTypeEnum(String value) {
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
    public static PhysicalDamageTypeEnum fromValue(String value) {
        PhysicalDamageTypeEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
