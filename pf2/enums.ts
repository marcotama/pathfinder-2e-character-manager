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
    PP = 1000,
    GP = 100,
    SP = 10,
    CP = 1,
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

export enum AlchemicalItemEnum {
    ACID_FLASK_ITEM_1 = "acid_flask_item_1",
    ALCHEMIST_S_FIRE_ITEM_1 = "alchemist_s_fire_item_1",
    ANTIDOTE_ITEM_1 = "antidote_item_1",
    ANTIPLAGUE_ITEM_1 = "antiplague_item_1",
    ARSENIC_ITEM_1 = "arsenic_item_1",
    BELLADONNA_ITEM_2 = "belladonna_item_2",
    BESTIAL_MUTAGEN_ITEM_9 = "bestial_mutagen_item_9",
    BESTIAL_MUTAGEN_GREATER_ITEM_13 = "bestial_mutagen_greater_item_13",
    BESTIAL_MUTAGEN_LESSER_ITEM_5 = "bestial_mutagen_lesser_item_5",
    BESTIAL_MUTAGEN_TRUE_ITEM_17 = "bestial_mutagen_true_item_17",
    BLACK_ADDER_VENOM_ITEM_2 = "black_adder_venom_item_2",
    BLACK_LOTUS_EXTRACT_ITEM_19 = "black_lotus_extract_item_19",
    BLIGHTBURN_RESIN_ITEM_11 = "blightburn_resin_item_11",
    BOMBER_S_EYE_ELIXIR_ITEM_3 = "bomber_s_eye_elixir_item_3",
    BOTTLED_LIGHTNING_ITEM_1 = "bottled_lightning_item_1",
    BRAVO_S_BREW_ITEM_3 = "bravo_s_brew_item_3",
    BRIMSTONE_FUMES_ITEM_16 = "brimstone_fumes_item_16",
    BULLHEADED_MUTAGEN_ITEM_9 = "bullheaded_mutagen_item_9",
    BULLHEADED_MUTAGEN_GREATER_ITEM_13 = "bullheaded_mutagen_greater_item_13",
    BULLHEADED_MUTAGEN_LESSER_ITEM_5 = "bullheaded_mutagen_lesser_item_5",
    BULLHEADED_MUTAGEN_TRUE_ITEM_17 = "bullheaded_mutagen_true_item_17",
    CAT_S_EYE_ELIXIR_ITEM_3 = "cat_s_eye_elixir_item_3",
    CHEETAH_S_ELIXIR_ITEM_1 = "cheetah_s_elixir_item_1",
    CYTILLESH_OIL_ITEM_3 = "cytillesh_oil_item_3",
    COGNITIVE_MUTAGEN_ITEM_9 = "cognitive_mutagen_item_9",
    COGNITIVE_MUTAGEN_GREATER_ITEM_13 = "cognitive_mutagen_greater_item_13",
    COGNITIVE_MUTAGEN_LESSER_ITEM_5 = "cognitive_mutagen_lesser_item_5",
    COGNITIVE_MUTAGEN_TRUE_ITEM_17 = "cognitive_mutagen_true_item_17",
    COMPREHENSION_ELIXIR_ITEM_2 = "comprehension_elixir_item_2",
    DARKVISION_ELIXIR_ITEM_1 = "darkvision_elixir_item_1",
    DEATHCAP_POWDER_ITEM_13 = "deathcap_powder_item_13",
    DRAGON_BILE_ITEM_15 = "dragon_bile_item_15",
    EAGLE_EYE_ELIXIR_ITEM_1 = "eagle-eye_elixir_item_1",
    ELIXIR_OF_LIFE_ITEM_8 = "elixir_of_life_item_8",
    ELIXIR_OF_LIFE_GREATER_ITEM_12 = "elixir_of_life_greater_item_12",
    ELIXIR_OF_LIFE_LESSER_ITEM_4 = "elixir_of_life_lesser_item_4",
    ELIXIR_OF_LIFE_MINOR_ITEM_1 = "elixir_of_life_minor_item_1",
    ELIXIR_OF_LIFE_TRUE_ITEM_16 = "elixir_of_life_true_item_16",
    ELIXIR_OF_REJUVENATION_ITEM_20 = "elixir_of_rejuvenation_item_20",
    GIANT_CENTIPEDE_VENOM_ITEM_1 = "giant_centipede_venom_item_1",
    GIANT_SCORPION_VENOM_ITEM_6 = "giant_scorpion_venom_item_6",
    GIANT_WASP_VENOM_ITEM_7 = "giant_wasp_venom_item_7",
    GRAVEROOT_ITEM_3 = "graveroot_item_3",
    HEMLOCK_ITEM_17 = "hemlock_item_17",
    HUNTING_SPIDER_VENOM_ITEM_5 = "hunting_spider_venom_item_5",
    INFILTRATOR_S_ELIXIR_ITEM_2 = "infiltrator_s_elixir_item_2",
    INSANITY_MIST_ITEM_15 = "insanity_mist_item_15",
    JUGGERNAUT_MUTAGEN_ITEM_9 = "juggernaut_mutagen_item_9",
    JUGGERNAUT_MUTAGEN_GREATER_ITEM_13 = "juggernaut_mutagen_greater_item_13",
    JUGGERNAUT_MUTAGEN_TRUE_ITEM_17 = "juggernaut_mutagen_true_item_17",
    JUGGERNAUT_MUTAGEN_LESSER_ITEM_5 = "juggernaut_mutagen_lesser_item_5",
    KING_S_SLEEP_ITEM_18 = "king_s_sleep_item_18",
    LEAPER_S_ELIXIR_ITEM_1 = "leaper_s_elixir_item_1",
    LICH_DUST_ITEM_9 = "lich_dust_item_9",
    LIQUID_ICE_ITEM_1 = "liquid_ice_item_1",
    MALYASS_ROOT_PASTE_ITEM_7 = "malyass_root_paste_item_7",
    MISTFORM_ELIXIR_ITEM_3 = "mistform_elixir_item_3",
    NETTLEWEED_RESIDUE_ITEM_8 = "nettleweed_residue_item_8",
    NIGHTMARE_VAPOR_ITEM_16 = "nightmare_vapor_item_16",
    PHILOSOPHER_S_STONE_ITEM_20 = "philosopher_s_stone_item_20",
    PURPLE_WORM_VENOM_ITEM_13 = "purple_worm_venom_item_13",
    QUICKSILVER_MUTAGEN_ITEM_9 = "quicksilver_mutagen_item_9",
    QUICKSILVER_MUTAGEN_GREATER_ITEM_13 = "quicksilver_mutagen_greater_item_13",
    QUICKSILVER_MUTAGEN_LESSER_ITEM_5 = "quicksilver_mutagen_lesser_item_5",
    QUICKSILVER_MUTAGEN_TRUE_ITEM_17 = "quicksilver_mutagen_true_item_17",
    SALAMANDER_ELIXIR_ITEM_2 = "salamander_elixir_item_2",
    SEA_TOUCH_ELIXIR_ITEM_4 = "sea_touch_elixir_item_4",
    SHADOW_ESSENCE_ITEM_10 = "shadow_essence_item_10",
    SILVERSHEEN_ITEM_1 = "silversheen_item_1",
    SILVERTONGUE_MUTAGEN_ITEM_9 = "silvertongue_mutagen_item_9",
    SILVERTONGUE_MUTAGEN_GREATER_ITEM_13 = "silvertongue_mutagen_greater_item_13",
    SILVERTONGUE_MUTAGEN_LESSER_ITEM_5 = "silvertongue_mutagen_lesser_item_5",
    SILVERTONGUE_MUTAGEN_TRUE_ITEM_17 = "silvertongue_mutagen_true_item_17",
    SLEEP_POISON_ITEM_2 = "sleep_poison_item_2",
    SLUMBER_WINE_ITEM_12 = "slumber_wine_item_12",
    SMOKESTICK_ITEM_1 = "smokestick_item_1",
    SPIDER_ROOT_ITEM_9 = "spider_root_item_9",
    STONE_FIST_ELIXIR_ITEM_2 = "stone_fist_elixir_item_2",
    SUNROD_ITEM_1 = "sunrod_item_1",
    TANGLEFOOT_BAG_ITEM_1 = "tanglefoot_bag_item_1",
    TEARS_OF_DEATH_ITEM_20 = "tears_of_death_item_20",
    THUNDERSTONE_ITEM_1 = "thunderstone_item_1",
    TINDERTWIG_ITEM_1 = "tindertwig_item_1",
    WINTER_WOLF_ELIXIR_ITEM_2 = "winter_wolf_elixir_item_2",
    WOLFSBANE_ITEM_10 = "wolfsbane_item_10",
    WYVERN_POISON_ITEM_8 = "wyvern_poison_item_8",
}

export type InventoryItem = AlchemicalItemEnum; // TODO add all other items