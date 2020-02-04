package ai.ragu.charactermanager.content.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum AlchemicalBombEnum implements AlchemicalItemEnum {
    // Level 1
    ACID_FLASK_LESSER("acid_flask_lesser"),
    ALCHEMIST_S_FIRE_LESSER("alchemist_s_fire_lesser"),
    BOTTLED_LIGHTNING_LESSER("bottled_lightning_lesser"),
    FROST_VIAL_LESSER("frost_vial_lesser"),
    TANGLEFOOT_BAG_LESSER("tanglefoot_bag_lesser"),
    THUNDERSTONE_LESSER("thunderstone_lesser"),

    // Level 3
    ACID_FLASK_MODERATE("acid_flask_moderate"),
    ALCHEMIST_S_FIRE_MODERATE("alchemist_s_fire_moderate"),
    BOTTLED_LIGHTNING_MODERATE("bottled_lightning_moderate"),
    FROST_VIAL_MODERATE("frost_vial_moderate"),
    TANGLEFOOT_BAG_MODERATE("tanglefoot_bag_moderate"),
    THUNDERSTONE_MODERATE("thunderstone_moderate"),

    // Level 11
    ACID_FLASK_GREATER("acid_flask_greater"),
    ALCHEMIST_S_FIRE_GREATER("alchemist_s_fire_greater"),
    BOTTLED_LIGHTNING_GREATER("bottled_lightning_greater"),
    FROST_VIAL_GREATER("frost_vial_greater"),
    TANGLEFOOT_BAG_GREATER("tanglefoot_bag_greater"),
    THUNDERSTONE_GREATER("thunderstone_greater"),

    // Level 17
    ACID_FLASK_MAJOR("acid_flask_major"),
    ALCHEMIST_S_FIRE_MAJOR("alchemist_s_fire_major"),
    BOTTLED_LIGHTNING_MAJOR("bottled_lightning_major"),
    FROST_VIAL_MAJOR("frost_vial_major"),
    TANGLEFOOT_BAG_MAJOR("tanglefoot_bag_major"),
    THUNDERSTONE_MAJOR("thunderstone_major");

    private final String value;
    private final static Map<String, AlchemicalBombEnum> CONSTANTS = new HashMap<>();

    static {
        for (AlchemicalBombEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    AlchemicalBombEnum(String value) {
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
    public static AlchemicalBombEnum fromValue(String value) {
        AlchemicalBombEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
