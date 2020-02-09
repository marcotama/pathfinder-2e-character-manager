package ai.ragu.charactermanager.content.classes.alchemist.choices;

import ai.ragu.charactermanager.dto.CharacterDto;
import ai.ragu.charactermanager.dto.Choice;
import ai.ragu.charactermanager.dto.ProficiencyModifierDto;
import ai.ragu.charactermanager.enumeration.ProficiencyLevelEnum;
import ai.ragu.charactermanager.enumeration.SkillEnum;

import java.util.List;

public class AlchemistFormulaeChoice extends Choice {
    private int numAnswers;
    public AlchemistFormulaeChoice(String suffix, String description, List<String> options, int numAnswers) {
        this.code = AlchemistFormulaeChoice.class.getName() + suffix;
        this.numAnswers = numAnswers;
        this.description = description;
        this.options = options;
    }

    @Override
    public int getNumAnswers(CharacterDto characterDto) {
        return this.numAnswers;
    }

    @Override
    public List<Choice> callback(CharacterDto characterDto) {
        characterDto.clearSkillsModifiersGrantedBy(code);
        for (String answerStr : answers) {
            SkillEnum skillEnum = SkillEnum.fromValue(answerStr);
            ProficiencyModifierDto newModifier = new ProficiencyModifierDto(
                    code,
                    ProficiencyLevelEnum.TRAINED,
                    0
            );
            characterDto.getSkills().get(skillEnum).getProficiency().getModifiers().add(newModifier);
        }
        return List.of();
    }
}
