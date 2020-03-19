package ai.ragu.charactermanager.content.classes.alchemist.choices

import ai.ragu.charactermanager.dto.CharacterDto
import ai.ragu.charactermanager.dto.Choice
import ai.ragu.charactermanager.dto.ProficiencyModifierDto
import ai.ragu.charactermanager.enumeration.ProficiencyLevelEnum
import ai.ragu.charactermanager.enumeration.SkillEnum

class AlchemistFormulaeChoice(suffix: String, description: String?, options: List<String?>?, numAnswers: Int) : Choice() {
    private val numAnswers: Int
    override fun getNumAnswers(characterDto: CharacterDto): Int {
        return numAnswers
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
        code = AlchemistFormulaeChoice::class.java.name + suffix
        this.numAnswers = numAnswers
        this.description = description
        this.options = options
    }
}