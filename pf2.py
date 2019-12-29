from __future__ import annotations
from enum import Enum, IntEnum

from base import *


# ----- Constants -----

class AbilityScoreEnum(Enum):
    STR = 'str'
    DEX = 'dex'
    CON = 'con'
    INT = 'int'
    WIS = 'wis'
    CHA = 'cha'


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


class DamageType(Enum, PhysicalDamageType, MagicDamageType):
    pass
    

class Currency(IntEnum):
    PP = 1000
    GP = 100
    SP = 10
    CP = 1


class ProficiencyLevel(Enum):
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


class AttackProficiencyEnum(Enum, MeleeWeaponGroupEnum, RangedWeaponGroupEnum):
    UNARMED_ATTACKS = 'unarmed_attacks'
    SIMPLE_WEAPONS = 'simple_weapons'
    MARTIAL_WEAPONS = 'martial_weapons'
    ALCHEMICAL_BOMBS = 'alchemical_bombs'


# ----- Classes ----


class Amount:
    value_in_cp: int

    def __init__(self, amount: List[Tuple[int, Currency]]):
        self.value_in_cp = sum(am * curr.value for am, curr in amount)

    def get_normalised(self):
        v = self.value_in_cp
        amount = []
        # noinspection PyTypeChecker
        for curr in sorted(Currency, reverse=True):
            am = v // curr.value
            if am > 0:
                amount.append((am, curr))
            v %= curr.value


class Armor(Thing):
    category: ItemCategory
    price: Amount
    ac_bonus: int
    dex_cap: int
    check_penalty: int
    speed_penalty: int
    strength: int
    bulk: int
    group: ArmorGroup
    traits: List[ArmorTraitEnum]


class Shield(Thing):
    category: ItemCategory
    price: Amount
    ac_bonus: int
    speed_penalty: int
    bulk: int
    hardness: int
    hit_points: int
    broken_threshold: int


class Damage:
    amount: Dict[Die, Tuple[int, PhysicalDamageType]]


class Weapon(Thing):
    category: ItemCategory
    price: Amount
    damage: Damage
    bulk: int
    hands: int
    traits: List[WeaponTraitEnum]


class MeleeWeapon(Weapon):
    group: MeleeWeaponGroupEnum


class RangedWeapon(Weapon):
    range: int
    reload: int
    group: RangedWeaponGroupEnum


class AbilityScore(Component):
    value: Optional[int]

    def __init__(self, code: str, name: str):
        self.code = code
        self.name = name
        self.fields = {
            "score": Field(code="score", name="Score", type=int, value=None)
        }
        self.value = None

    def set_value(self, new_value: int):
        if new_value < 1 or new_value > 20:
            raise Exception(f"Value {new_value} is out of range [1, 20].")
        self.value = new_value

    def get_modifier(self) -> int:
        return (self.value - 10) // 2


class Proficiency(Component):
    value: Optional[ProficiencyLevel]

    def __init__(self, code: str, name: str):
        self.code = code
        self.name = name
        self.fields = {
            "proficiency": Field(code="proficiency", name="Proficiency", type=int, value=None)
        }
        self.value = None

    def set_value(self, new_value: ProficiencyLevel):
        self.value = new_value

    def get_modifier(self) -> int:
        return self.value.get_modifier() if self.value is not None else 0


class ProficiencyBasedRoll(Component):
    proficiency: Proficiency
    ref_ability_score: AbilityScoreEnum
    character: Character

    def __init__(
            self,
            code: str,
            name: str,
            ref_ability_score: AbilityScoreEnum,
            character: Character
    ):
        self.code = code
        self.name = name
        self.ref_ability_score = ref_ability_score
        self.character = character
        self.proficiency = Proficiency(code="proficiency", name="Proficiency")

    def get_item_modifier(self):
        return 0 # TODO

    def get_modifier(self) -> int:
        return self.proficiency.get_modifier() +\
               self.character.ability_scores[self.ref_ability_score].get_modifier() +\
               self.get_item_modifier()


class SavingThrow(ProficiencyBasedRoll):
    pass


class Perception(ProficiencyBasedRoll):
    pass


class Skill(ProficiencyBasedRoll):
    def get_armor_modifier(self):
        if self.ref_ability_score.code in [AbilityScoreEnum.DEX, AbilityScoreEnum.STR]:
            if self.character.ability_scores[AbilityScoreEnum.STR].value >= self.character.armor.strength:
                return 0
            else:
                return -self.character.armor.check_penalty
        else:
            return 0

    def get_modifier(self) -> int:
        return super().get_modifier() + self.get_armor_modifier()


class Character(Hero):
    ability_scores: Dict[AbilityScoreEnum, AbilityScore]
    skills: Dict[SkillEnum, Skill]
    saving_throws: Dict[SavingThrowEnum, SavingThrow]
    perception: Perception
    equipment: List[Union[Armor, Shield, Weapon]]
    max_hit_points: int
    current_hit_points: int
    temporary_hit_points: int
    speed :int
    resistances: List[DamageType]
    immunities: List[DamageType]
    conditions: List[DamageType]
    attack_proficiencies: Dict[AttackProficiencyEnum, Proficiency]
    defense_proficiencies: Dict[DefenseProficiencyEnum, Proficiency]
    
    def __init__(self, code: str, name: str):
        self.code = code
        self.name = name
        self.armor = None
        self.shields = []
        self.weapons = []
        self.max_hit_points = 0
        self.current_hit_points = 0
        self.temporary_hit_points = 0
        self.speed = 0
        self.resistances = []
        self.immunities = []
        self.conditions = []
        self.ability_scores = {
            AbilityScoreEnum.STR: AbilityScore(code=str(AbilityScoreEnum.STR), name="Strength"),
            AbilityScoreEnum.DEX: AbilityScore(code=str(AbilityScoreEnum.DEX), name="Dexterity"),
            AbilityScoreEnum.CON: AbilityScore(code=str(AbilityScoreEnum.CON), name="Constitution"),
            AbilityScoreEnum.INT: AbilityScore(code=str(AbilityScoreEnum.INT), name="Intelligence"),
            AbilityScoreEnum.WIS: AbilityScore(code=str(AbilityScoreEnum.WIS), name="Wisdom"),
            AbilityScoreEnum.CHA: AbilityScore(code=str(AbilityScoreEnum.CHA), name="Charisma")
        }
        self.skills = {
            SkillEnum.ACROBATICS: Skill(code=str(SkillEnum.ACROBATICS), name="Acrobatics", ref_ability_score=AbilityScoreEnum.DEX, character=self),
            SkillEnum.ARCANA: Skill(code=str(SkillEnum.ARCANA), name="Arcana", ref_ability_score=AbilityScoreEnum.INT, character=self),
            SkillEnum.ATHLETICS: Skill(code=str(SkillEnum.ATHLETICS), name="Athletics", ref_ability_score=AbilityScoreEnum.STR, character=self),
            SkillEnum.CRAFTING: Skill(code=str(SkillEnum.CRAFTING), name="Crafting", ref_ability_score=AbilityScoreEnum.INT, character=self),
            SkillEnum.DECEPTION: Skill(code=str(SkillEnum.DECEPTION), name="Deception", ref_ability_score=AbilityScoreEnum.CHA, character=self),
            SkillEnum.DIPLOMACY: Skill(code=str(SkillEnum.DIPLOMACY), name="Diplomacy", ref_ability_score=AbilityScoreEnum.CHA, character=self),
            SkillEnum.INTIMIDATION: Skill(code=str(SkillEnum.INTIMIDATION), name="Intimidation", ref_ability_score=AbilityScoreEnum.CHA, character=self),
            SkillEnum.MEDICINE: Skill(code=str(SkillEnum.MEDICINE), name="Medicine", ref_ability_score=AbilityScoreEnum.WIS, character=self),
            SkillEnum.NATURE: Skill(code=str(SkillEnum.NATURE), name="Nature", ref_ability_score=AbilityScoreEnum.WIS, character=self),
            SkillEnum.OCCULTISM: Skill(code=str(SkillEnum.OCCULTISM), name="Occultism", ref_ability_score=AbilityScoreEnum.INT, character=self),
            SkillEnum.PERFORMANCE: Skill(code=str(SkillEnum.PERFORMANCE), name="Performance", ref_ability_score=AbilityScoreEnum.CHA, character=self),
            SkillEnum.RELIGION: Skill(code=str(SkillEnum.RELIGION), name="Religion", ref_ability_score=AbilityScoreEnum.WIS, character=self),
            SkillEnum.SOCIETY: Skill(code=str(SkillEnum.SOCIETY), name="Society", ref_ability_score=AbilityScoreEnum.INT, character=self),
            SkillEnum.STEALTH: Skill(code=str(SkillEnum.STEALTH), name="Stealth", ref_ability_score=AbilityScoreEnum.DEX, character=self),
            SkillEnum.SURVIVAL: Skill(code=str(SkillEnum.SURVIVAL), name="Survival", ref_ability_score=AbilityScoreEnum.WIS, character=self),
            SkillEnum.THIEVERY: Skill(code=str(SkillEnum.THIEVERY), name="Thievery", ref_ability_score=AbilityScoreEnum.DEX, character=self),
        }
        self.saving_throws = {
            SavingThrowEnum.FORTITUDE: SavingThrow(code=str(SavingThrowEnum.FORTITUDE), name="Fortitude", ref_ability_score=AbilityScoreEnum.CON, character=self),
            SavingThrowEnum.REFLEX: SavingThrow(code=str(SavingThrowEnum.REFLEX), name="Reflex", ref_ability_score=AbilityScoreEnum.DEX, character=self),
            SavingThrowEnum.WILL: SavingThrow(code=str(SavingThrowEnum.WILL), name="Will", ref_ability_score=AbilityScoreEnum.WIS, character=self),
        }
        self.attack_proficiencies = {
            AttackProficiencyEnum.UNARMED_ATTACKS: Proficiency(code=str(AttackProficiencyEnum.UNARMED_ATTACKS), name="unarmed_attacks"),
            AttackProficiencyEnum.SIMPLE_WEAPONS: Proficiency(code=str(AttackProficiencyEnum.SIMPLE_WEAPONS), name="simple_weapons"),
            AttackProficiencyEnum.MARTIAL_WEAPONS: Proficiency(code=str(AttackProficiencyEnum.MARTIAL_WEAPONS), name="martial_weapons"),
            AttackProficiencyEnum.ALCHEMICAL_BOMBS: Proficiency(code=str(AttackProficiencyEnum.ALCHEMICAL_BOMBS), name="alchemical_bombs"),
            
            AttackProficiencyEnum.SWORD: Proficiency(code=str(AttackProficiencyEnum.SWORD), name="sword"),
            AttackProficiencyEnum.SPEAR: Proficiency(code=str(AttackProficiencyEnum.SPEAR), name="spear"),
            AttackProficiencyEnum.HAMMER: Proficiency(code=str(AttackProficiencyEnum.HAMMER), name="hammer"),
            AttackProficiencyEnum.POLEARM: Proficiency(code=str(AttackProficiencyEnum.POLEARM), name="polearm"),
            AttackProficiencyEnum.KNIFE: Proficiency(code=str(AttackProficiencyEnum.KNIFE), name="knife"),
            AttackProficiencyEnum.CLUB: Proficiency(code=str(AttackProficiencyEnum.CLUB), name="club"),
            AttackProficiencyEnum.FLAIL: Proficiency(code=str(AttackProficiencyEnum.FLAIL), name="flail"),
            AttackProficiencyEnum.BRAWLING: Proficiency(code=str(AttackProficiencyEnum.BRAWLING), name="brawling"),
            AttackProficiencyEnum.AXE: Proficiency(code=str(AttackProficiencyEnum.AXE), name="axe"),
            AttackProficiencyEnum.PICK: Proficiency(code=str(AttackProficiencyEnum.PICK), name="pick"),
            AttackProficiencyEnum.SHIELD: Proficiency(code=str(AttackProficiencyEnum.SHIELD), name="shield"),
            AttackProficiencyEnum.WHIP: Proficiency(code=str(AttackProficiencyEnum.WHIP), name="whip"),
        }
        self.defense_proficiencies = {
            DefenseProficiencyEnum.UNARMORED_DEFENSE: Proficiency(code=str(DefenseProficiencyEnum.UNARMORED_DEFENSE), name="unarmored_defense"),
            DefenseProficiencyEnum.LIGHT_ARMO: Proficiency(code=str(DefenseProficiencyEnum.LIGHT_ARMO), name="light_armo"),
            DefenseProficiencyEnum.MEDIUM_ARMOR: Proficiency(code=str(DefenseProficiencyEnum.MEDIUM_ARMOR), name="medium_armor"),
            DefenseProficiencyEnum.HEAVY_ARMOR: Proficiency(code=str(DefenseProficiencyEnum.HEAVY_ARMOR), name="heavy_armor"),
        }
        self.components = {**self.ability_scores, **self.skills, **self.saving_throws, **self.attack_proficiencies, **self.defense_proficiencies}
        self.value = None


    def get_all_sheet_fields(self):
        return {
            **{f"{ability_score}-modifier": self.ability_scores[ability_score].get_modifier() for ability_score in AbilityScoreEnum},
            **{f"{ability_score}-score": self.ability_scores[ability_score].value for ability_score in AbilityScoreEnum},

            **{f"{skill}-modifier": self.skills[skill].get_modifier() for skill in SkillEnum},
            **{f"{skill}-proficiency": str(self.skills[skill].proficiency.value) for skill in SkillEnum},
            **{f"{skill}-proficiency-modifier": self.skills[skill].proficiency.get_modifier() for skill in SkillEnum},
            **{f"{skill}-item-modifier": self.skills[skill].get_item_modifier() for skill in SkillEnum},
            **{f"{skill}-armor-modifier": self.skills[skill].get_armor_modifier() for skill in SkillEnum if self.skills[skill].ref_ability_score in [AbilityScoreEnum.DEX, AbilityScoreEnum.STR]},

            **{f"{saving_throw}-modifier": self.saving_throws[saving_throw].get_modifier() for saving_throw in SavingThrowEnum},
            **{f"{saving_throw}-proficiency": str(self.saving_throws[saving_throw].proficiency.value) for saving_throw in SavingThrowEnum},
            **{f"{saving_throw}-proficiency-modifier": self.saving_throws[saving_throw].proficiency.get_modifier() for saving_throw in SavingThrowEnum},
            **{f"{saving_throw}-item-modifier": self.saving_throws[saving_throw].get_item_modifier() for saving_throw in SavingThrowEnum},

            **{
                "perception-modifier": self.perception.get_modifier(),
                "perception-proficiency": str(self.perception.proficiency.value),
                "perception-proficiency-modifier": self.perception.proficiency.get_modifier(),
                "perception-item-modifier": self.perception.get_item_modifier()
            },

            **{f"{defense_proficiency}-proficiency": str(self.defense_proficiencies[defense_proficiency].value) for defense_proficiency in DefenseProficiencyEnum},
            **{f"{attack_proficiency}-proficiency": str(self.attack_proficiencies[attack_proficiency].value) for attack_proficiency in AttackProficiencyEnum},

        }
