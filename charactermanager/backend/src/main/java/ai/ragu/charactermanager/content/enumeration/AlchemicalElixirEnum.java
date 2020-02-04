package ai.ragu.charactermanager.content.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum AlchemicalElixirEnum implements AlchemicalItemEnum {
    // Level 1
    ANTIDOTE_LESSER("antidote_lesser"),
    ANTIPLAGUE_LESSER("antiplague_lesser"),
    BESTIAL_MUTAGEN_LESSER("bestial_mutagen_lesser"),
    CHEETAH_S_ELIXIR_LESSER("cheetah_s_elixir_lesser"),
    COGNITIVE_MUTAGEN_LESSER("cognitive_mutagen_lesser"),
    EAGLE_EYE_ELIXIR_LESSER("eagle_eye_elixir_lesser"),
    ELIXIR_OF_LIFE_MINOR("elixir_of_life_minor"),
    JUGGERNAUT_MUTAGEN_LESSER("juggernaut_mutagen_lesser"),
    LEAPER_S_ELIXIR_LESSER("leaper_s_elixir_lesser"),
    QUICKSILVER_MUTAGEN_LESSER("quicksilver_mutagen_lesser"),
    SERENE_MUTAGEN_LESSER("serene_mutagen_lesser"),
    SILVERTONGUE_MUTAGEN_LESSER("silvertongue_mutagen_lesser"),

    // Level 2
    BRAVO_S_BREW_LESSER("bravo_s_brew_lesser"),
    CAT_S_EYE_ELIXIR_LESSER("cat_s_eye_elixir_lesser"),
    COMPREHENSION_ELIXIR_LESSER("comprehension_elixir_lesser"),
    DARKVISION_ELIXIR_LESSER("darkvision_elixir_lesser"),
    INFILTRATOR_S_ELIXIR_LESSER("infiltrator_s_elixir_lesser"),

    // Level 3
    BESTIAL_MUTAGEN_MODERATE("bestial_mutagen_moderate"),
    COGNITIVE_MUTAGEN_MODERATE("cognitive_mutagen_moderate"),
    JUGGERNAUT_MUTAGEN_MODERATE("juggernaut_mutagen_moderate"),
    QUICKSILVER_MUTAGEN_MODERATE("quicksilver_mutagen_moderate"),
    SERENE_MUTAGEN_MODERATE("serene_mutagen_moderate"),
    SILVERTONGUE_MUTAGEN_MODERATE("silvertongue_mutagen_moderate"),

    // Level 4
    BOMBER_S_EYE_ELIXIR_LESSER("bomber_s_eye_elixir_lesser"),
    DARKVISION_ELIXIR_MODERATE("darkvision_elixir_moderate"),
    MISTFORM_ELIXIR_LESSER("mistform_elixir_lesser"),
    SALAMANDER_ELIXIR_LESSER("salamander_elixir_lesser"),
    STONE_FIST_ELIXIR("stone_fist_elixir"),
    WINTER_WOLF_ELIXIR_LESSER("winter_wolf_elixir_lesser"),

    // Level 5
    CHEETAH_S_ELIXIR_MODERATE("cheetah_s_elixir_moderate"),
    EAGLE_EYE_ELIXIR_MODERATE("eagle_eye_elixir_moderate"),
    ELIXIR_OF_LIFE_LESSER("elixir_of_life_lesser"),
    SEA_TOUCH_ELIXIR_LESSER("sea_touch_elixir_lesser"),

    // Level 6
    ANTIDOTE_MODERATE("antidote_moderate"),
    ANTIPLAGUE_MODERATE("antiplague_moderate"),
    MISTFORM_ELIXIR_MODERATE("mistform_elixir_moderate"),
    GIANT_SCORPION_VENOM("giant_scorpion_venom"),

    // Level 7
    COMPREHENSION_ELIXIR_GREATER("comprehension_elixir_greater"),
    LEAPER_S_ELIXIR_GREATER("leaper_s_elixir_greater"),

    // Level 8
    DARKVISION_ELIXIR_GREATER("darkvision_elixir_greater"),

    // Level 9
    CHEETAH_S_ELIXIR_GREATER("cheetah_s_elixir_greater"),
    ELIXIR_OF_LIFE_MODERATE("elixir_of_life_moderate"),

    // Level 10
    ANTIDOTE_GREATER("antidote_greater"),
    ANTIPLAGUE_GREATER("antiplague_greater"),
    BRAVO_S_BREW_MODERATE("bravo_s_brew_moderate"),
    EAGLE_EYE_ELIXIR_GREATER("eagle_eye_elixir_greater"),
    MISTFORM_ELIXIR_GREATER("mistform_elixir_greater"),

    // Level 11
    BESTIAL_MUTAGEN_GREATER("bestial_mutagen_greater"),
    COGNITIVE_MUTAGEN_GREATER("cognitive_mutagen_greater"),
    JUGGERNAUT_MUTAGEN_GREATER("juggernaut_mutagen_greater"),
    QUICKSILVER_MUTAGEN_GREATER("quicksilver_mutagen_greater"),
    SERENE_MUTAGEN_GREATER("serene_mutagen_greater"),
    SILVERTONGUE_MUTAGEN_GREATER("silvertongue_mutagen_greater"),

    // Level 12
    SALAMANDER_ELIXIR_MODERATE("salamander_elixir_moderate"),
    SEA_TOUCH_ELIXIR_MODERATE("sea_touch_elixir_moderate"),
    WINTER_WOLF_ELIXIR_MODERATE("winter_wolf_elixir_moderate"),

    // Level 13
    ELIXIR_OF_LIFE_GREATER("elixir_of_life_greater"),

    // Level 14
    ANTIDOTE_MAJOR("antidote_major"),
    ANTIPLAGUE_MAJOR("antiplague_major"),
    BOMBER_S_EYE_ELIXIR_GREATER("bomber_s_eye_elixir_greater"),

    // Level 15
    BRAVO_S_BREW_GREATER("bravo_s_brew_greater"),
    ELIXIR_OF_LIFE_MAJOR("elixir_of_life_major"),
    SEA_TOUCH_ELIXIR_GREATER("sea_touch_elixir_greater"),

    // Level 16
    EAGLE_EYE_ELIXIR_MAJOR("eagle_eye_elixir_major"),
    SALAMANDER_ELIXIR_GREATER("salamander_elixir_greater"),
    WINTER_WOLF_ELIXIR_GREATER("winter_wolf_elixir_greater"),

    // Level 17
    BESTIAL_MUTAGEN_MAJOR("bestial_mutagen_major"),
    COGNITIVE_MUTAGEN_MAJOR("cognitive_mutagen_major"),
    JUGGERNAUT_MUTAGEN_MAJOR("juggernaut_mutagen_major"),
    QUICKSILVER_MUTAGEN_MAJOR("quicksilver_mutagen_major"),
    SERENE_MUTAGEN_MAJOR("serene_mutagen_major"),
    SILVERTONGUE_MUTAGEN_MAJOR("silvertongue_mutagen_major"),

    // Level 19
    ELIXIR_OF_LIFE_TRUE("elixir_of_life_true"),

    // Level 20
    ELIXIR_OF_REJUVENATION("elixir_of_rejuvenation");

    private final String value;
    private final static Map<String, AlchemicalElixirEnum> CONSTANTS = new HashMap<>();

    static {
        for (AlchemicalElixirEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    AlchemicalElixirEnum(String value) {
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
    public static AlchemicalElixirEnum fromValue(String value) {
        AlchemicalElixirEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
