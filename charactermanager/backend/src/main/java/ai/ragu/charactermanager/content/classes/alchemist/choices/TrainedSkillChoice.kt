package ai.ragu.charactermanager.content.classes.alchemist.choices

import ai.ragu.charactermanager.dto.CharacterDto
import ai.ragu.charactermanager.dto.Choice
import ai.ragu.charactermanager.dto.ProficiencyModifierDto
import ai.ragu.charactermanager.enumeration.AbilityScoreEnum
import ai.ragu.charactermanager.enumeration.ProficiencyLevelEnum
import ai.ragu.charactermanager.enumeration.SkillEnum
import java.util.*
import java.util.stream.Collectors

class TrainedSkillChoice : Choice() {
    override fun getNumAnswers(characterDto: CharacterDto): Int {
        return 3 + characterDto.abilityScores[AbilityScoreEnum.INT].calcModifier()
    }

    override fun callback(characterDto: CharacterDto): List<Choice?> {
        characterDto.clearSkillsModifiersGrantedBy(code!!)
        for (answerStr in answers!!) {
            val skillEnum: SkillEnum = SkillEnum.Companion.fromValue(answerStr)
            val newModifier = ProficiencyModifierDto(
                    code,
                    ProficiencyLevelEnum.TRAINED,
                    0
            )
            characterDto.skills[skillEnum].getProficiency().modifiers.add(newModifier)
        }
        return java.util.List.of()
    }

    init {
        code = TrainedSkillChoice::class.java.name
        description = "Become Trained in a number of additional skills equal to 3 plus your Intelligence modifier"
        options = Arrays.stream(SkillEnum.values())
                .filter { skill: SkillEnum -> skill != SkillEnum.CRAFTING }
                .map { obj: SkillEnum -> obj.toString() }
                .collect(Collectors.toList())
    }
}