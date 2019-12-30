from enum import Enum, IntEnum


class SkillEnum(Enum):
    ACROBATICS = 'acrobatics'
    ARCANA = 'arcana'
    ATHLETICS = 'athletics'
    CRAFTING = 'crafting'
    DECEPTION = 'deception'
    DIPLOMACY = 'diplomacy'
    INTIMIDATION = 'intimidation'
    MEDICINE = 'medicine'
    NATURE = 'nature'
    OCCULTISM = 'occultism'
    PERFORMANCE = 'performance'
    RELIGION = 'religion'
    SOCIETY = 'society'
    STEALTH = 'stealth'
    SURVIVAL = 'survival'
    THIEVERY = 'thievery'
    LORE = 'lore'


class SavingThrowEnum(Enum):
    FORTITUDE = 'fortitude'
    REFLEX = 'reflex'
    WILL = 'will'


class ItemCategory(Enum):
    LIGHT = 'light'
    MEDIUM = 'medium'
    HEAVY = 'heavy'


class ArmorGroup(Enum):
    LEATHER = 'leather'
    COMPOSITE = 'composite'
    CHAIN = 'chain'
    PLATE = 'plate'


class Trait(Enum):
    COMFORT = 'comfort'
    FLEXIBLE = 'flexible'
    NOISY = 'noisy'
    BULWARK = 'bulwark'


class Die(Enum):
    D4 = 4
    D6 = 6
    D8 = 8
    D10 = 10
    D12 = 12
    D20 = 20
    D100 = 100


class PhysicalDamageType(Enum):
    BLUDGEONING = 'bludgeoning'
    PIERCING = 'piercing'
    SLASHING = 'slashing'


class MagicDamageType(Enum):
    ACID = 'acid'
    AIR = 'air'
    COLD = 'cold'
    EARTH = 'earth'
    ELECTRICITY = 'electricity'
    FIRE = 'fire'
    WATER = 'water'


class DamageType(PhysicalDamageType, MagicDamageType, Enum):
    pass


class Currency(IntEnum):
    PP = 1000
    GP = 100
    SP = 10
    CP = 1


class ProficiencyLevelEnum(Enum):
    UNTRAINED = 0
    TRAINED = 1
    EXPERT = 2
    MASTER = 3
    LEGENDARY = 4

    def get_modifier(self) -> int:
        return self.value * 2 if self.value is not None else 0


class ArmorTraitEnum(Enum):
    COMFORT = 'comfort'
    FLEXIBLE = 'flexible'
    NOISY = 'noisy'
    BULWARK = 'bulwark'


class MeleeWeaponGroupEnum(Enum):
    SWORD = 'sword'
    SPEAR = 'spear'
    HAMMER = 'hammer'
    POLEARM = 'polearm'
    KNIFE = 'knife'
    CLUB = 'club'
    FLAIL = 'flail'
    BRAWLING = 'brawling'
    AXE = 'axe'
    PICK = 'pick'
    SHIELD = 'shield'
    WHIP = 'whip'


class RangedWeaponGroupEnum(Enum):
    DART = 'dart'
    BOW = 'bow'


class ThrownWeaponTraitEnum(Enum):
    THROWN_10FT = 10
    THROWN_20FT = 20


class VersatileWeaponTraitEnum(Enum):
    VERSATILE_S = PhysicalDamageType.SLASHING
    VERSATILE_P = PhysicalDamageType.PIERCING
    VERSATILE_B = PhysicalDamageType.BLUDGEONING


class TwoHandWeaponTraitEnum(Enum):
    TWO_HAND_D8 = Die.D8
    TWO_HAND_D10 = Die.D10
    TWO_HAND_D12 = Die.D12


class DeadlyWeaponTraitEnum(Enum):
    DEADLY_D6 = Die.D6
    DEADLY_D8 = Die.D8
    DEADLY_D10 = Die.D10


class JoustingWeaponTraitEnum(Enum):
    JOUSTING_D6 = Die.D6


class FatalWeaponTraitEnum(Enum):
    FATAL_D8 = Die.D8
    FATAL_D10 = Die.D10
    FATAL_D12 = Die.D12


class ClassEnum(Enum):
    MONK = 'monk'


class RaceEnum(Enum):
    DWARF = 'dwarf'
    GOBLIN = 'goblin'
    ELF = 'elf'
    HALFLING = 'halfling'
    GNOME = 'gnome'
    ORC = 'orc'


class WeaponTraitEnum(
    Enum,
    ThrownWeaponTraitEnum,
    VersatileWeaponTraitEnum,
    DeadlyWeaponTraitEnum,
    JoustingWeaponTraitEnum,
    FatalWeaponTraitEnum,
    ClassEnum,
    RaceEnum
):
    AGILE = 'agile'
    FINESSE = 'finesse'
    FREE_HAND = 'free_hand'
    SHOVE = 'shove'
    REACH = 'reach'
    TRIP = 'trip'
    PARRY = 'parry'
    SWEEP = 'sweep'
    FORCEFUL = 'forceful'
    BACKSWING = 'backswing'
    NONLETHAL = 'nonlethal'
    ATTACHED_TO_SHIELD = 'attached_to_shield'
    BACKSTABBER = 'backstabber'
    TWIN = 'twin'


class DefenseProficiencyEnum(Enum):
    UNARMORED_DEFENSE = 'unarmored_defense'
    LIGHT_ARMOR = 'light_armor'
    MEDIUM_ARMOR = 'medium_armor'
    HEAVY_ARMOR = 'heavy_armor'


class AttackProficiencyEnum(MeleeWeaponGroupEnum, RangedWeaponGroupEnum, Enum):
    UNARMED_ATTACKS = 'unarmed_attacks'
    SIMPLE_WEAPONS = 'simple_weapons'
    MARTIAL_WEAPONS = 'martial_weapons'
    ALCHEMICAL_BOMBS = 'alchemical_bombs'


class AbilityScoreEnum(Enum):
    STR = 'str'
    DEX = 'dex'
    CON = 'con'
    INT = 'int'
    WIS = 'wis'
    CHA = 'cha'