package ai.ragu.charactermanager.content.classes.alchemist;

import ai.ragu.charactermanager.content.classes.alchemist.choices.ResearchFieldChoice;
import ai.ragu.charactermanager.content.classes.alchemist.choices.TrainedSkillChoice;
import ai.ragu.charactermanager.dto.Choice;
import ai.ragu.charactermanager.dto.ClazzDto;
import ai.ragu.charactermanager.enumeration.*;

import java.util.List;
import java.util.Map;

public class ClazzAlchemist extends ClazzDto {

    public ClazzAlchemist() {
        super("Class:Alchemist", "Alchemist");
        this.baseHitPointsIncrease = 8;
        this.keyAbilityScore = AbilityScoreEnum.INT;
        this.perception = ProficiencyLevelEnum.TRAINED;
        this.savingThrows = Map.ofEntries(
                Map.entry(SavingThrowEnum.FORTITUDE, ProficiencyLevelEnum.EXPERT),
                Map.entry(SavingThrowEnum.REFLEX, ProficiencyLevelEnum.EXPERT),
                Map.entry(SavingThrowEnum.WILL, ProficiencyLevelEnum.TRAINED)
        );
        this.skills = Map.ofEntries(
                Map.entry(SkillEnum.CRAFTING, ProficiencyLevelEnum.TRAINED)
        );
        this.attacks = Map.ofEntries(
                Map.entry(OtherAttackWeaponTypeEnum.SIMPLE_WEAPONS, ProficiencyLevelEnum.TRAINED),
                Map.entry(OtherAttackWeaponTypeEnum.ALCHEMICAL_BOMBS, ProficiencyLevelEnum.TRAINED),
                Map.entry(OtherAttackWeaponTypeEnum.UNARMED_ATTACKS, ProficiencyLevelEnum.TRAINED)
        );
        this.defenses = Map.ofEntries(
                Map.entry(DefenseProficiencyEnum.LIGHT_ARMOR, ProficiencyLevelEnum.TRAINED),
                Map.entry(DefenseProficiencyEnum.UNARMORED_DEFENSE, ProficiencyLevelEnum.TRAINED)
        );
        this.src = SourceEnum.CORE_RULEBOOK;
        this.url = "https://glasstopgames.com/pathfinder2/class/alchemist.html";
    }

    @Override
    public List<Choice> getChoices(int level) {
        if (level == 1) {
            return List.of(
                    new TrainedSkillChoice(),
                    new ResearchFieldChoice()
            );
        } else {
            throw new UnsupportedOperationException(String.format("Level not supported in the alchemist class: %d", level));
        }
    }

}
