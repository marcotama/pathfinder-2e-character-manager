from __future__ import annotations

from abc import abstractmethod

from base import *
from pf2.enums import SkillEnum, SavingThrowEnum, ItemCategory, ArmorGroup, Die, PhysicalDamageType, DamageType, \
    Currency, ProficiencyLevelEnum, ArmorTraitEnum, MeleeWeaponGroupEnum, RangedWeaponGroupEnum, WeaponTraitEnum, \
    DefenseProficiencyEnum, AttackProficiencyEnum, AbilityScoreEnum, InventoryItem


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
    base_value: Optional[int]
    modifiers: List[Tuple[str, int]] # (reason, delta)

    def __init__(self, code: str, name: str):
        self.code = code
        self.name = name
        self.fields = {
            "score": Field(code="score", name="Score", type=int, value=None)
        }
        self.base_value = None

    def set_value(self, new_value: int):
        if new_value < 1 or new_value > 20:
            raise Exception(f"Value {new_value} is out of range [1, 20].")
        self.base_value = new_value

    def get_value(self) -> int:
        return (self.base_value - 10) // 2


class Proficiency(Component):
    base_value: Optional[ProficiencyLevelEnum]
    modifiers: List[Tuple[str, str, ProficiencyLevelEnum, int]] # (identifier, reason, value, priority (higher takes priority))

    def __init__(self, code: str, name: str):
        self.code = code
        self.name = name
        self.fields = {
            "proficiency": Field(code="proficiency", name="Proficiency", type=int, value=None)
        }
        self.base_value = None

    def set_value(self, new_value: ProficiencyLevelEnum):
        self.base_value = new_value

    def get_value(self):
        if len(self.modifiers) == 0:
            return self.base_value
        else:
            max_priority = max(priority for identifier, reason, value, priority in self.modifiers)
            return max(value for identifier, reason, value, priority in self.modifiers if priority == max_priority)

    def get_modifier(self) -> int:
        return self.base_value.get_modifier() if self.base_value is not None else 0


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

    def get_attribute_modifier(self):
        return self.character.ability_scores[self.ref_ability_score].get_value()

    def get_value(self) -> int:
        return self.proficiency.get_modifier() + self.get_attribute_modifier() + self.get_item_modifier()


class SavingThrow(ProficiencyBasedRoll):
    pass


class Perception(ProficiencyBasedRoll):
    pass


class ProficiencyAndKeyAttributeBasedRoll(Component):
    proficiency: Proficiency
    character: Character

    def __init__(
            self,
            code: str,
            name: str,
            character: Character
    ):
        self.code = code
        self.name = name
        self.character = character
        self.proficiency = Proficiency(code="proficiency", name="Proficiency")

    def get_item_modifier(self):
        return 0 # TODO

    def get_attribute_modifier(self):
        key_ability_score = self.character.clazz.key_ability_score
        return self.character.ability_scores[key_ability_score].get_value()

    def get_value(self) -> int:
        return self.proficiency.get_modifier() + self.get_attribute_modifier() + self.get_item_modifier()


class ClassDC(ProficiencyAndKeyAttributeBasedRoll):
    pass


class SpellAttackRoll(ProficiencyAndKeyAttributeBasedRoll):
    pass


class SpellDC(ProficiencyAndKeyAttributeBasedRoll):
    pass


class Skill(ProficiencyBasedRoll):
    def get_armor_modifier(self):
        if self.ref_ability_score.code in [AbilityScoreEnum.DEX, AbilityScoreEnum.STR]:
            if self.character.ability_scores[AbilityScoreEnum.STR].base_value >= self.character.armor.strength:
                return 0
            else:
                return -self.character.armor.check_penalty
        else:
            return 0

    def get_value(self) -> int:
        return super().get_value() + self.get_armor_modifier()


class Clazz:
    key_ability_score: AbilityScoreEnum
    hit_points: int
    initial_proficiencies: Dict[str, ProficiencyLevelEnum] # FIXME str?
    perception: ProficiencyLevelEnum
    saving_throws: Dict[SavingThrowEnum, ProficiencyLevelEnum]
    skills: Dict[SkillEnum, ProficiencyLevelEnum]
    attacks: Dict[AttackProficiencyEnum, ProficiencyLevelEnum]
    defenses: Dict[DefenseProficiencyEnum, ProficiencyLevelEnum]

    @abstractmethod
    def calc_hit_points_increase(self, character: Character):
        pass



class Character(Hero):
    clazz: Clazz
    ability_scores: Dict[AbilityScoreEnum, AbilityScore]
    skills: Dict[SkillEnum, Skill]
    saving_throws: Dict[SavingThrowEnum, SavingThrow]
    perception: Perception
    class_dc: ClassDC
    spell_attack_roll: SpellAttackRoll
    spell_dc: SpellDC
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
    inventory: Dict[InventoryItem, Optional[Tuple[str, str]]] # why each item is present (identifier, description)
    
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
        self.perception = Perception(code="perception", name="Perception", character=self, ref_ability_score=AbilityScoreEnum.WIS)
        self.class_dc = ClassDC(code="class-dc", name="Class DC", character=self)
        self.spell_attack_roll = SpellAttackRoll(code="spell-attack-roll", name="Spell Attack Roll", character=self)
        self.spell_dc = SpellDC(code="spell-dc", name="Spell DC", character=self)
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
            **{f"{ability_score}-modifier": self.ability_scores[ability_score].get_value() for ability_score in AbilityScoreEnum},
            **{f"{ability_score}-score": self.ability_scores[ability_score].base_value for ability_score in AbilityScoreEnum},

            **{f"{skill}-value": self.skills[skill].get_value() for skill in SkillEnum},
            **{f"{skill}-attribute-modifier": self.skills[skill].get_attribute_modifier() for skill in SkillEnum},
            **{f"{skill}-proficiency": str(self.skills[skill].proficiency.base_value) for skill in SkillEnum},
            **{f"{skill}-proficiency-modifier": self.skills[skill].proficiency.get_modifier() for skill in SkillEnum},
            **{f"{skill}-item-modifier": self.skills[skill].get_item_modifier() for skill in SkillEnum},
            **{f"{skill}-armor-modifier": self.skills[skill].get_armor_modifier() for skill in SkillEnum if self.skills[skill].ref_ability_score in [AbilityScoreEnum.DEX, AbilityScoreEnum.STR]},

            **{f"{saving_throw}-value": self.saving_throws[saving_throw].get_value() for saving_throw in SavingThrowEnum},
            **{f"{saving_throw}-attribute-modifier": self.saving_throws[saving_throw].get_attribute_modifier() for saving_throw in SavingThrowEnum},
            **{f"{saving_throw}-proficiency": str(self.saving_throws[saving_throw].proficiency.base_value) for saving_throw in SavingThrowEnum},
            **{f"{saving_throw}-proficiency-modifier": self.saving_throws[saving_throw].proficiency.get_modifier() for saving_throw in SavingThrowEnum},
            **{f"{saving_throw}-item-modifier": self.saving_throws[saving_throw].get_item_modifier() for saving_throw in SavingThrowEnum},

            **{f"{defense_proficiency}-proficiency": str(self.defense_proficiencies[defense_proficiency].base_value) for defense_proficiency in DefenseProficiencyEnum},
            **{f"{attack_proficiency}-proficiency": str(self.attack_proficiencies[attack_proficiency].base_value) for attack_proficiency in AttackProficiencyEnum},

            **{
                "perception-value": self.perception.get_value(),
                "perception-attribute-modifier": self.perception.get_attribute_modifier(),
                "perception-proficiency": str(self.perception.proficiency.base_value),
                "perception-proficiency-modifier": self.perception.proficiency.get_modifier(),
                "perception-item-modifier": self.perception.get_item_modifier(),

                "class-dc-value": self.class_dc.get_value(),
                "class-dc-attribute-modifier": self.class_dc.get_attribute_modifier(),
                "class-dc-proficiency": str(self.class_dc.proficiency.base_value),
                "class-dc-proficiency-modifier": self.class_dc.proficiency.get_modifier(),
                "class-dc-item-modifier": self.class_dc.get_item_modifier(),

                "spell-attack-roll-value": self.spell_attack_roll.get_value(),
                "spell-attack-roll-attribute-modifier": self.spell_attack_roll.get_attribute_modifier(),
                "spell-attack-roll-proficiency": str(self.spell_attack_roll.proficiency.base_value),
                "spell-attack-roll-proficiency-modifier": self.spell_attack_roll.proficiency.get_modifier(),
                "spell-attack-roll-item-modifier": self.spell_attack_roll.get_item_modifier(),

                "spell-dc-value": self.spell_dc.get_value(),
                "spell-dc-attribute-modifier": self.spell_dc.get_attribute_modifier(),
                "spell-dc-proficiency": str(self.spell_dc.proficiency.base_value),
                "spell-dc-proficiency-modifier": self.spell_dc.proficiency.get_modifier(),
                "spell-dc-item-modifier": self.spell_dc.get_item_modifier()
            },
        }

    def clear_items_granted_by(self, identifier: str):
        for item, granted_by in self.inventory:
            if granted_by == identifier:
                del self.inventory[item]

    def clear_skills_modifiers_granted_by(self, identifier: str):
        for skill in self.skills.values():
            for modifier in skill.proficiency.modifiers:
                granted_by, reason, value, priority = modifier
                if granted_by == identifier:
                    skill.proficiency.modifiers.remove(modifier)


class Choice:
    description: str
    options: List[str]
    num_choices: int
    callback: Callable

    def __init__(self, description: str, options: List[str], num_choices: int, callback: Callable):
        self.description = description
        self.options = options
        self.num_choices = num_choices
        self.callback = callback