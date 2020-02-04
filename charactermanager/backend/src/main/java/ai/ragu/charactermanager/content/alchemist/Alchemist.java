package ai.ragu.charactermanager.content.alchemist;

import ai.ragu.charactermanager.content.alchemist.choices.ResearchFieldChoice;
import ai.ragu.charactermanager.content.alchemist.choices.TrainedSkillChoice;
import ai.ragu.charactermanager.dto.CharacterDto;
import ai.ragu.charactermanager.dto.Choice;
import ai.ragu.charactermanager.dto.ClazzDto;
import ai.ragu.charactermanager.enumeration.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Alchemist extends ClazzDto {

    public enum AlchemistResearchFieldEnum {
        BOMBER("bomber"),
        CHIRURGEON("chirurgeon"),
        MUTAGENIST("mutagenist");

        private final String value;
        private final static Map<String, AlchemistResearchFieldEnum> CONSTANTS = new HashMap<>();

        static {
            for (AlchemistResearchFieldEnum c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        AlchemistResearchFieldEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static AlchemistResearchFieldEnum fromValue(String value) {
            AlchemistResearchFieldEnum constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }
    }

    public Alchemist() {
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
    }

    public int calcHitPointsIncrease(CharacterDto character) {
        return 8 + character.getAbilityScores().get(AbilityScoreEnum.CON).calcModifier();
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
