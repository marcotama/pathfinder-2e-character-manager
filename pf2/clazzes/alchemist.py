from pf2.enums import AbilityScoreEnum, ProficiencyLevelEnum, SavingThrowEnum, DefenseProficiencyEnum, \
    AttackProficiencyEnum, SkillEnum
from pf2.structures import Clazz, Character, Choice

from typing import *


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
        return 8 + character.ability_scores[AbilityScoreEnum.CON].get_modifier()

    def get_additional_choices(self, character: Character):
        additional_choices = [
            Choice(
                description=f"Become Trained in a number of additional skills equal to 3 plus your Intelligence modifier (total: {3 + character.ability_scores[AbilityScoreEnum.INT].get_modifier()})",
                options=[skill for skill in AbilityScoreEnum if skill != SkillEnum.CRAFTING],
                num_choices=3 + character.ability_scores[AbilityScoreEnum.INT].get_modifier(),
                callback=lambda character, choices: character
            )

        ]
