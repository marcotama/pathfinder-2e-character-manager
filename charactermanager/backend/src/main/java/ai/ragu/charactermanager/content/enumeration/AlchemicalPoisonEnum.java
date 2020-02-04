package ai.ragu.charactermanager.content.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum AlchemicalPoisonEnum implements AlchemicalItemEnum {
    // Level 1
    ARSENIC("arsenic"),
    GIANT_CENTIPEDE_VENOM("giant_centipede_venom"),

    // Level 2
    BELLADONNA("belladonna"),
    BLACK_ADDER_VENOM("black_adder_venom"),
    LETHARGY_POISON("lethargy_poison"),

    // Level 3
    CYTILLESH_OIL("cytillesh_oil"),
    GRAVEROOT("graveroot"),

    // Level 5
    HUNTING_SPIDER_VENOM("hunting_spider_venom"),

    // Level 6
    GIANT_SCORPION_VENOM("giant_scorpion_venom"),

    // Level 7
    GIANT_WASP_VENOM("giant_wasp_venom"),
    MALYASS_ROOT_PASTE("malyass_root_paste"),

    // Level 8
    NETTLEWEED_RESIDUE("nettleweed_residue"),
    WYVERN_POISON("wyvern_poison"),

    // Level 9
    LICH_DUST("lich_dust"),
    SPIDER_ROOT("spider_root"),

    // Level 10
    SHADOW_ESSENCE("shadow_essence"),
    WOLFSBANE("wolfsbane"),

    // Level 11
    BLIGHTBURN_RESIN("blightburn_resin"),

    // Level 12
    SLUMBER_WINE("slumber_wine"),

    // Level 13
    DEATHCAP_POWDER("deathcap_powder"),
    PURPLE_WORM_VENOM("purple_worm_venom"),

    // Level 15
    DRAGON_BILE("dragon_bile"),
    MINDFOG_MIST("mindfog_mist"),

    // Level 16
    BRIMSTONE_FUMES("brimstone_fumes"),
    NIGHTMARE_VAPOR("nightmare_vapor"),

    // Level 17
    HEMLOCK("hemlock"),

    // Level 18
    KING_S_SLEEP("king_s_sleep"),
    // Level 19
    BLACK_LOTUS_EXTRACT("black_lotus_extract"),

    // Level 20
    TEARS_OF_DEATH("tears_of_death");

    private final String value;
    private final static Map<String, AlchemicalPoisonEnum> CONSTANTS = new HashMap<>();

    static {
        for (AlchemicalPoisonEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    AlchemicalPoisonEnum(String value) {
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
    public static AlchemicalPoisonEnum fromValue(String value) {
        AlchemicalPoisonEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
