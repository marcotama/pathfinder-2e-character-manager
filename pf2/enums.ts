export enum SkillEnum {
    ACROBATICS = 'acrobatics',
    ARCANA = 'arcana',
    ATHLETICS = 'athletics',
    CRAFTING = 'crafting',
    DECEPTION = 'deception',
    DIPLOMACY = 'diplomacy',
    INTIMIDATION = 'intimidation',
    MEDICINE = 'medicine',
    NATURE = 'nature',
    OCCULTISM = 'occultism',
    PERFORMANCE = 'performance',
    RELIGION = 'religion',
    SOCIETY = 'society',
    STEALTH = 'stealth',
    SURVIVAL = 'survival',
    THIEVERY = 'thievery',
    LORE = 'lore',
}

export enum SavingThrowEnum {
    FORTITUDE = 'fortitude',
    REFLEX = 'reflex',
    WILL = 'will',
}

export enum ItemCategory {
    LIGHT = 'light',
    MEDIUM = 'medium',
    HEAVY = 'heavy',
}

export enum ArmorGroup {
    LEATHER = 'leather',
    COMPOSITE = 'composite',
    CHAIN = 'chain',
    PLATE = 'plate',
}

export enum Trait {
    COMFORT = 'comfort',
    FLEXIBLE = 'flexible',
    NOISY = 'noisy',
    BULWARK = 'bulwark',
}

export enum Die {
    D4 = 4,
    D6 = 6,
    D8 = 8,
    D10 = 10,
    D12 = 12,
    D20 = 20,
    D100 = 100,
}

export enum PhysicalDamageType {
    BLUDGEONING = 'bludgeoning',
    PIERCING = 'piercing',
    SLASHING = 'slashing',
}

export enum MagicDamageType {
    ACID = 'acid',
    AIR = 'air',
    COLD = 'cold',
    EARTH = 'earth',
    ELECTRICITY = 'electricity',
    FIRE = 'fire',
    WATER = 'water',
}

export type DamageType = PhysicalDamageType | MagicDamageType;

export enum Currency {
    PP = 'pp',
    GP = 'gp',
    SP = 'sp',
    CP = 'cp'
}

export function getCurrencyValue(currency: Currency): number {
    switch (currency) {
        case Currency.PP: return 1000;
        case Currency.GP: return 100;
        case Currency.SP: return 10;
        case Currency.CP: return 1;
    }
}


export enum ProficiencyLevelEnum {
    UNTRAINED = 0,
    TRAINED = 1,
    EXPERT = 2,
    MASTER = 3,
    LEGENDARY = 4,
}

export function getProficiencyModifier(proficiency: ProficiencyLevelEnum) {
    return proficiency == null ? 0 : proficiency * 2;
}

export enum ArmorTraitEnum {
    COMFORT = 'comfort',
    FLEXIBLE = 'flexible',
    NOISY = 'noisy',
    BULWARK = 'bulwark'
}

export enum MeleeWeaponGroupEnum {
    SWORD = 'sword',
    SPEAR = 'spear',
    HAMMER = 'hammer',
    POLEARM = 'polearm',
    KNIFE = 'knife',
    CLUB = 'club',
    FLAIL = 'flail',
    BRAWLING = 'brawling',
    AXE = 'axe',
    PICK = 'pick',
    SHIELD = 'shield',
    WHIP = 'whip',
}

export enum RangedWeaponGroupEnum {
    DART = 'dart',
    BOW = 'bow',
}

export enum ThrownWeaponTraitEnum {
    THROWN_10FT = 10,
    THROWN_20FT = 20
}

export enum VersatileWeaponTraitEnum {
    VERSATILE_S = PhysicalDamageType.SLASHING,
    VERSATILE_P = PhysicalDamageType.PIERCING,
    VERSATILE_B = PhysicalDamageType.BLUDGEONING,
}

export enum TwoHandWeaponTraitEnum {
    TWO_HAND_D8 = Die.D8,
    TWO_HAND_D10 = Die.D10,
    TWO_HAND_D12 = Die.D12,
}

export enum DeadlyWeaponTraitEnum {
    DEADLY_D6 = Die.D6,
    DEADLY_D8 = Die.D8,
    DEADLY_D10 = Die.D10,
}

export enum JoustingWeaponTraitEnum {
    JOUSTING_D6 = Die.D6
}

export enum FatalWeaponTraitEnum {
    FATAL_D8 = Die.D8,
    FATAL_D10 = Die.D10,
    FATAL_D12 = Die.D12,
}

export enum ClassEnum {
    MONK = 'monk',
}

export enum RaceEnum {
    DWARF = 'dwarf',
    GOBLIN = 'goblin',
    ELF = 'elf',
    HALFLING = 'halfling',
    GNOME = 'gnome',
    ORC = 'orc',
}

export enum OtherWeaponTrait {
    AGILE = 'agile',
    FINESSE = 'finesse',
    FREE_HAND = 'free_hand',
    SHOVE = 'shove',
    REACH = 'reach',
    TRIP = 'trip',
    PARRY = 'parry',
    SWEEP = 'sweep',
    FORCEFUL = 'forceful',
    BACKSWING = 'backswing',
    NONLETHAL = 'nonlethal',
    ATTACHED_TO_SHIELD = 'attached_to_shield',
    BACKSTABBER = 'backstabber',
    TWIN = 'twin',
}

export type WeaponTraitEnum =
    ThrownWeaponTraitEnum |
    VersatileWeaponTraitEnum |
    DeadlyWeaponTraitEnum |
    JoustingWeaponTraitEnum |
    FatalWeaponTraitEnum |
    ClassEnum |
    RaceEnum |
    OtherWeaponTrait;

export enum DefenseProficiencyEnum {
    UNARMORED_DEFENSE = 'unarmored_defense',
    LIGHT_ARMOR = 'light_armor',
    MEDIUM_ARMOR = 'medium_armor',
    HEAVY_ARMOR = 'heavy_armor',
}

export enum OtherAttackProficiencyEnum {
    UNARMED_ATTACKS = 'unarmed_attacks',
    SIMPLE_WEAPONS = 'simple_weapons',
    MARTIAL_WEAPONS = 'martial_weapons',
    ALCHEMICAL_BOMBS = 'alchemical_bombs',
}

export enum ItemBulkEnum {
    SMALL = 'small',
    MEDIUM = 'medium',
    LARGE = 'large',
}

export type AttackProficiencyEnum = MeleeWeaponGroupEnum | RangedWeaponGroupEnum | OtherAttackProficiencyEnum;

export enum AbilityScoreEnum {
    STR = 'str',
    DEX = 'dex',
    CON = 'con',
    INT = 'int',
    WIS = 'wis',
    CHA = 'cha',
}

export enum AlchemicalItemCategoryEnum {
    BOMB = 'bomb',
    ELIXIR = 'elixir',
    POISON = 'poison',
    TOOL = 'tool',
}

export enum AlchemicalBombEnum {
    // Level 1
    ACID_FLASK_LESSER = "acid_flask_lesser",
    ALCHEMIST_S_FIRE_LESSER = "alchemist_s_fire_lesser",
    BOTTLED_LIGHTNING_LESSER = "bottled_lightning_lesser",
    FROST_VIAL_LESSER = "frost_vial_lesser",
    TANGLEFOOT_BAG_LESSER = "tanglefoot_bag_lesser",
    THUNDERSTONE_LESSER = "thunderstone_lesser",

    // Level 3
    ACID_FLASK_MODERATE = "acid_flask_moderate",
    ALCHEMIST_S_FIRE_MODERATE = "alchemist_s_fire_moderate",
    BOTTLED_LIGHTNING_MODERATE = "bottled_lightning_moderate",
    FROST_VIAL_MODERATE = "frost_vial_moderate",
    TANGLEFOOT_BAG_MODERATE = "tanglefoot_bag_moderate",
    THUNDERSTONE_MODERATE = "thunderstone_moderate",

    // Level 11
    ACID_FLASK_GREATER = "acid_flask_greater",
    ALCHEMIST_S_FIRE_GREATER = "alchemist_s_fire_greater",
    BOTTLED_LIGHTNING_GREATER = "bottled_lightning_greater",
    FROST_VIAL_GREATER = "frost_vial_greater",
    TANGLEFOOT_BAG_GREATER = "tanglefoot_bag_greater",
    THUNDERSTONE_GREATER = "thunderstone_greater",

    // Level 17
    ACID_FLASK_MAJOR = "acid_flask_major",
    ALCHEMIST_S_FIRE_MAJOR = "alchemist_s_fire_major",
    BOTTLED_LIGHTNING_MAJOR = "bottled_lightning_major",
    FROST_VIAL_MAJOR = "frost_vial_major",
    TANGLEFOOT_BAG_MAJOR = "tanglefoot_bag_major",
    THUNDERSTONE_MAJOR = "thunderstone_major",
}

export enum AlchemicalElixirEnum {
    // Level 1
    ANTIDOTE_LESSER = "antidote_lesser",
    ANTIPLAGUE_LESSER = "antiplague_lesser",
    BESTIAL_MUTAGEN_LESSER = "bestial_mutagen_lesser",
    CHEETAH_S_ELIXIR_LESSER = "cheetah_s_elixir_lesser",
    COGNITIVE_MUTAGEN_LESSER = "cognitive_mutagen_lesser",
    EAGLE_EYE_ELIXIR_LESSER = "eagle-eye_elixir_lesser",
    ELIXIR_OF_LIFE_MINOR = "elixir_of_life_minor",
    JUGGERNAUT_MUTAGEN_LESSER = "juggernaut_mutagen_lesser",
    LEAPER_S_ELIXIR_LESSER = "leaper_s_elixir_lesser",
    QUICKSILVER_MUTAGEN_LESSER = "quicksilver_mutagen_lesser",
    SERENE_MUTAGEN_LESSER = "serene_mutagen_lesser",
    SILVERTONGUE_MUTAGEN_LESSER = "silvertongue_mutagen_lesser",

    // Level 2
    BRAVO_S_BREW_LESSER = "bravo_s_brew_lesser",
    CAT_S_EYE_ELIXIR_LESSER = "cat_s_eye_elixir_lesser",
    COMPREHENSION_ELIXIR_LESSER = "comprehension_elixir_lesser",
    DARKVISION_ELIXIR_LESSER = "darkvision_elixir_lesser",
    INFILTRATOR_S_ELIXIR_LESSER = "infiltrator_s_elixir_lesser",

    // Level 3
    BESTIAL_MUTAGEN_MODERATE = "bestial_mutagen_moderate",
    COGNITIVE_MUTAGEN_MODERATE = "cognitive_mutagen_moderate",
    JUGGERNAUT_MUTAGEN_MODERATE = "juggernaut_mutagen_moderate",
    QUICKSILVER_MUTAGEN_MODERATE = "quicksilver_mutagen_moderate",
    SERENE_MUTAGEN_MODERATE = "serene_mutagen_moderate",
    SILVERTONGUE_MUTAGEN_MODERATE = "silvertongue_mutagen_moderate",

    // Level 4
    BOMBER_S_EYE_ELIXIR_LESSER = "bomber_s_eye_elixir_lesser",
    DARKVISION_ELIXIR_MODERATE = "darkvision_elixir_moderate",
    MISTFORM_ELIXIR_LESSER = "mistform_elixir_lesser",
    SALAMANDER_ELIXIR_LESSER = "salamander_elixir_lesser",
    STONE_FIST_ELIXIR = "stone_fist_elixir",
    WINTER_WOLF_ELIXIR_LESSER = "winter_wolf_elixir_lesser",

    // Level 5
    CHEETAH_S_ELIXIR_MODERATE = "cheetah_s_elixir_moderate",
    EAGLE_EYE_ELIXIR_MODERATE = "eagle_eye_elixir_moderate",
    ELIXIR_OF_LIFE_LESSER = "elixir_of_life_lesser",
    SEA_TOUCH_ELIXIR_LESSER = "sea_touch_elixir_lesser",

    // Level 6
    ANTIDOTE_MODERATE = "antidote_moderate",
    ANTIPLAGUE_MODERATE = "antiplague_moderate",
    MISTFORM_ELIXIR_MODERATE = "mistform_elixir_moderate",
    GIANT_SCORPION_VENOM = "giant_scorpion_venom",

    // Level 7
    COMPREHENSION_ELIXIR_GREATER = "comprehension_elixir_greater",
    LEAPER_S_ELIXIR_GREATER = "leaper_s_elixir_greater",

    // Level 8
    DARKVISION_ELIXIR_GREATER = "darkvision_elixir_greater",

    // Level 9
    CHEETAH_S_ELIXIR_GREATER = "cheetah_s_elixir_greater",
    ELIXIR_OF_LIFE_MODERATE = "elixir_of_life_moderate",

    // Level 10
    ANTIDOTE_GREATER = "antidote_greater",
    ANTIPLAGUE_GREATER = "antiplague_greater",
    BRAVO_S_BREW_MODERATE = "bravo_s_brew_moderate",
    EAGLE_EYE_ELIXIR_GREATER = "eagle_eye_elixir_greater",
    MISTFORM_ELIXIR_GREATER = "mistform_elixir_greater",

    // Level 11
    BESTIAL_MUTAGEN_GREATER = "bestial_mutagen_greater",
    COGNITIVE_MUTAGEN_GREATER = "cognitive_mutagen_greater",
    JUGGERNAUT_MUTAGEN_GREATER = "juggernaut_mutagen_greater",
    QUICKSILVER_MUTAGEN_GREATER = "quicksilver_mutagen_greater",
    SERENE_MUTAGEN_GREATER = "serene_mutagen_greater",
    SILVERTONGUE_MUTAGEN_GREATER = "silvertongue_mutagen_greater",

    // Level 12
    SALAMANDER_ELIXIR_MODERATE = "salamander_elixir_moderate",
    SEA_TOUCH_ELIXIR_MODERATE = "sea_touch_elixir_moderate",
    WINTER_WOLF_ELIXIR_MODERATE = "winter_wolf_elixir_moderate",

    // Level 13
    ELIXIR_OF_LIFE_GREATER = "elixir_of_life_greater",

    // Level 14
    ANTIDOTE_MAJOR = "antidote_major",
    ANTIPLAGUE_MAJOR = "antiplague_major",
    BOMBER_S_EYE_ELIXIR_GREATER = "bomber_s_eye_elixir_greater",

    // Level 15
    BRAVO_S_BREW_GREATER = "bravo_s_brew_greater",
    ELIXIR_OF_LIFE_MAJOR = "elixir_of_life_major",
    SEA_TOUCH_ELIXIR_GREATER = "sea_touch_elixir_greater",

    // Level 16
    EAGLE_EYE_ELIXIR_MAJOR = "eagle_eye_elixir_major",
    SALAMANDER_ELIXIR_GREATER = "salamander_elixir_greater",
    WINTER_WOLF_ELIXIR_GREATER = "winter_wolf_elixir_greater",

    // Level 17
    BESTIAL_MUTAGEN_MAJOR = "bestial_mutagen_major",
    COGNITIVE_MUTAGEN_MAJOR = "cognitive_mutagen_major",
    JUGGERNAUT_MUTAGEN_MAJOR = "juggernaut_mutagen_major",
    QUICKSILVER_MUTAGEN_MAJOR = "quicksilver_mutagen_major",
    SERENE_MUTAGEN_MAJOR = "serene_mutagen_major",
    SILVERTONGUE_MUTAGEN_MAJOR = "silvertongue_mutagen_major",

    // Level 19
    ELIXIR_OF_LIFE_TRUE = "elixir_of_life_true",

    // Level 20
    ELIXIR_OF_REJUVENATION = "elixir_of_rejuvenation",
}

export enum AlchemicalPoisonEnum {
    // Level 1
    ARSENIC = "arsenic",
    GIANT_CENTIPEDE_VENOM = "giant_centipede_venom",

    // Level 2
    BELLADONNA = "belladonna",
    BLACK_ADDER_VENOM = "black_adder_venom",
    LETHARGY_POISON = "lethargy_poison",

    // Level 3
    CYTILLESH_OIL = "cytillesh_oil",
    GRAVEROOT = "graveroot",

    // Level 5
    HUNTING_SPIDER_VENOM = "hunting_spider_venom",

    // Level 6
    GIANT_SCORPION_VENOM = "giant_scorpion_venom",

    // Level 7
    GIANT_WASP_VENOM = "giant_wasp_venom",
    MALYASS_ROOT_PASTE = "malyass_root_paste",

    // Level 8
    NETTLEWEED_RESIDUE = "nettleweed_residue",
    WYVERN_POISON = "wyvern_poison",

    // Level 9
    LICH_DUST = "lich_dust",
    SPIDER_ROOT = "spider_root",

    // Level 10
    SHADOW_ESSENCE = "shadow_essence",
    WOLFSBANE = "wolfsbane",

    // Level 11
    BLIGHTBURN_RESIN = "blightburn_resin",

    // Level 12
    SLUMBER_WINE = "slumber_wine",

    // Level 13
    DEATHCAP_POWDER = "deathcap_powder",
    PURPLE_WORM_VENOM = "purple_worm_venom",

    // Level 15
    DRAGON_BILE = "dragon_bile",
    MINDFOG_MIST = "mindfog_mist",

    // Level 16
    BRIMSTONE_FUMES = "brimstone_fumes",
    NIGHTMARE_VAPOR = "nightmare_vapor",

    // Level 17
    HEMLOCK = "hemlock",

    // Level 18
    KING_S_SLEEP = "king_s_sleep",
    // Level 19
    BLACK_LOTUS_EXTRACT = "black_lotus_extract",

    // Level 20
    TEARS_OF_DEATH = "tears_of_death",
}

export enum AlchemicalToolEnum {
    // Level 1
    SMOKESTICK_LESSER = "smokestick_lesser",
    SNAKE_OIL = "snake_oil",
    SUNROD = "sunrod",
    TINDERTWIG = "tindertwig",

    // Level 2
    SILVERSHEEN = "silversheen",

    // Level 7
    SMOKESTICK_GREATER = "smokestick_greater",

    // Level 20
    PHILOSOPHER_S_STONE = "philosopher_s_stone",
}

export enum ItemActivationEnum {
    STRIKE = "strike"
}

export type AlchemicalItemEnum = AlchemicalBombEnum | AlchemicalElixirEnum | AlchemicalPoisonEnum | AlchemicalToolEnum;
export type InventoryItemCategory = AlchemicalItemCategoryEnum; // TODO add all other items
export type InventoryItemEnum = AlchemicalItemEnum; // TODO add all other items


