package ai.ragu.charactermanager.content.alchemist.choices;

import ai.ragu.charactermanager.dto.CharacterDto;
import ai.ragu.charactermanager.dto.Choice;
import ai.ragu.charactermanager.dto.ProficiencyModifierDto;
import ai.ragu.charactermanager.enumeration.AbilityScoreEnum;
import ai.ragu.charactermanager.enumeration.ProficiencyLevelEnum;
import ai.ragu.charactermanager.enumeration.SkillEnum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TrainedSkillChoice extends Choice {
    public TrainedSkillChoice() {
        this.code = TrainedSkillChoice.class.getName();
        this.description = "Become Trained in a number of additional skills equal to 3 plus your Intelligence modifier";
        this.options = Arrays.stream(SkillEnum.values())
                .filter(skill -> skill != SkillEnum.CRAFTING)
                .map(SkillEnum::toString)
                .collect(Collectors.toList());
    }

    @Override
    public int getNumAnswers(CharacterDto characterDto) {
        return 3 + characterDto.getAbilityScores().get(AbilityScoreEnum.INT).calcModifier();
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
