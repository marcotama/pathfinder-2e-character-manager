from enum import Enum

from pf2.enums import AbilityScoreEnum, ProficiencyLevelEnum, SavingThrowEnum, DefenseProficiencyEnum, \
    AttackProficiencyEnum, SkillEnum, AlchemicalItemCategoryEnum, AlchemicalItemEnum
from pf2.structures import Clazz, Character, Choice

from typing import *


class AlchemistResearchFieldEnum(Enum):
    BOMBER = 'bomber'
    CHIRURGEON = 'chirurgeon'
    MUTAGENIST = 'mutagenist'


class Alchemist(Clazz):
    def __init__(self):
        self.key_ability_score = AbilityScoreEnum.INT
        self.initial_proficiencies = {}
        self.perception = ProficiencyLevelEnum.TRAINED
        self.saving_throws = {
            SavingThrowEnum.FORTITUDE: ProficiencyLevelEnum.EXPERT,
            SavingThrowEnum.REFLEX: ProficiencyLevelEnum.EXPERT,
            SavingThrowEnum.WILL: ProficiencyLevelEnum.TRAINED,
        }
        self.skills = {
            SkillEnum.CRAFTING: ProficiencyLevelEnum.TRAINED,
        }
        self.attacks = {
            AttackProficiencyEnum.SIMPLE_WEAPONS: ProficiencyLevelEnum.TRAINED,
            AttackProficiencyEnum.ALCHEMICAL_BOMBS: ProficiencyLevelEnum.TRAINED,
            AttackProficiencyEnum.UNARMED_ATTACKS: ProficiencyLevelEnum.TRAINED,
        }
        self.defenses = {
            DefenseProficiencyEnum.LIGHT_ARMOR: ProficiencyLevelEnum.TRAINED,
            DefenseProficiencyEnum.UNARMORED_DEFENSE: ProficiencyLevelEnum.TRAINED,
        }


    def calc_hit_points_increase(self, character: Character):
        return 8 + character.ability_scores[AbilityScoreEnum.CON].get_value()


    def get_choices(self, level: int, character: Character):
        if level == 1:
            return [
                self.get_trained_skills_choice(character)
            ]

        # elif level == 2:

    @staticmethod
    def get_trained_skills_choice(character: Character) -> Choice:
        choice_identifier = 'alchemist-initial-proficiencies'
        def callback(character: Character, choices: List[SkillEnum]) -> List[Choice]:
            character.clear_skills_modifiers_granted_by(choice_identifier)
            for choice in choices:
                new_modifier = (choice_identifier, "Alchemist class initial proficiencies", ProficiencyLevelEnum.TRAINED, 0)
                character.skills[choice].proficiency.modifiers.append(new_modifier)
            return []

        return Choice(
            description=f"Become Trained in a number of additional skills equal to 3 plus your Intelligence modifier (total: {3 + character.ability_scores[AbilityScoreEnum.INT].get_value()})",
            options=[skill for skill in AbilityScoreEnum if skill != SkillEnum.CRAFTING],
            num_choices=3 + character.ability_scores[AbilityScoreEnum.INT].get_value(),
            callback=callback
        )


    @staticmethod
    def get_research_field_choice(character: Character) -> Choice:
        choice_identifier = 'alchemist-research-field'
        def callback(character: Character, choices: List[SkillEnum]) -> List[Choice]:
            character.clear_items_granted_by(choice_identifier)
            if len(choices) != 1:
                raise ValueError(f"Only one choice is possible, but {len(choices)} were chosen: {choices}")
            choice = choices[0]
            new_choices = []
            if choice == AlchemistResearchFieldEnum.BOMBER:
                new_choices.append(Choice(
                    description="Choose two 1st-level alchemical bombs to add to your formula book",
                    options=[item for item in AlchemicalItemEnum if item.category == AlchemicalItemCategoryEnum.BOMB],
                    num_choices=1,
                    callback=callback
                ))
            return new_choices


        return Choice(
            description="Choose a field of research",
            options=[alchemist_research_field for alchemist_research_field in AlchemistResearchFieldEnum],
            num_choices=1,
            callback=callback
        )

