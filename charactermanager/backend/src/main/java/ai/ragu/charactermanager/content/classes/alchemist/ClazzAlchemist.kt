package ai.ragu.charactermanager.content.classes.alchemist

import ai.ragu.charactermanager.content.classes.alchemist.choices.ResearchFieldChoice
import ai.ragu.charactermanager.content.classes.alchemist.choices.TrainedSkillChoice
import ai.ragu.charactermanager.dto.Choice
import ai.ragu.charactermanager.dto.ClazzDto
import ai.ragu.charactermanager.enumeration.*

class ClazzAlchemist : ClazzDto("Class:Alchemist", "Alchemist") {
    override fun getChoices(level: Int): List<Choice?>? {
        return if (level == 1) {
            java.util.List.of(
                    TrainedSkillChoice(),
                    ResearchFieldChoice()
            )
        } else {
            throw UnsupportedOperationException(String.format("Level not supported in the alchemist class: %d", level))
        }
    }

    init {
        baseHitPointsIncrease = 8
        keyAbilityScore = AbilityScoreEnum.INT
        perception = ProficiencyLevelEnum.TRAINED
        savingThrows = Map.ofEntries(
                Map.entry(SavingThrowEnum.FORTITUDE, ProficiencyLevelEnum.EXPERT),
                Map.entry(SavingThrowEnum.REFLEX, ProficiencyLevelEnum.EXPERT),
                Map.entry(SavingThrowEnum.WILL, ProficiencyLevelEnum.TRAINED)
        )
        skills = Map.ofEntries(
                Map.entry(SkillEnum.CRAFTING, ProficiencyLevelEnum.TRAINED)
        )
        attacks = Map.ofEntries(
                Map.entry(OtherAttackWeaponTypeEnum.SIMPLE_WEAPONS, ProficiencyLevelEnum.TRAINED),
                Map.entry(OtherAttackWeaponTypeEnum.ALCHEMICAL_BOMBS, ProficiencyLevelEnum.TRAINED),
                Map.entry(OtherAttackWeaponTypeEnum.UNARMED_ATTACKS, ProficiencyLevelEnum.TRAINED)
        )
        defenses = Map.ofEntries(
                Map.entry(DefenseProficiencyEnum.LIGHT_ARMOR, ProficiencyLevelEnum.TRAINED),
                Map.entry(DefenseProficiencyEnum.UNARMORED_DEFENSE, ProficiencyLevelEnum.TRAINED)
        )
        src = SourceEnum.CORE_RULEBOOK
        url = "https://glasstopgames.com/pathfinder2/class/alchemist.html"
    }
}