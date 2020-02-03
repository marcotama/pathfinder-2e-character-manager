package ai.ragu.charactermanager.dto;

import ai.ragu.charactermanager.enumeration.AbilityScoreEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProficiencyBasedRollDto {

    @JsonProperty("proficiency")
    @JsonPropertyDescription("The proficiency of this roll")
    // @Nonnull
    private ProficiencyDto proficiency = new ProficiencyDto();

    @JsonProperty("refAbilityScore")
    @JsonPropertyDescription("The ability score used in this roll - if null, the reference ability score of the character is used")
    @Nullable
    private AbilityScoreEnum refAbilityScore = null;

    public ProficiencyBasedRollDto(@Nonnull AbilityScoreEnum refAbilityScore) {
        this.proficiency = new ProficiencyDto();
        this.refAbilityScore = refAbilityScore;
    }

    public int calcItemModifier() {
        return 0; // TODO
    }

    public AbilityScoreEnum calcRefAbilityScore(CharacterDto character) {
        if (this.refAbilityScore != null) {
            return this.refAbilityScore;
        } else {
            ClazzDto clazzDto = character.getClazz();
            if (clazzDto != null) {
                return clazzDto.getKeyAbilityScore();
            } else {
                return null;
            }
        }
    }

    public int calcAttributeModifier(CharacterDto character) {
        AbilityScoreEnum refAbilityScore = calcRefAbilityScore(character);
        AbilityScoreDto abilityScoreDto = character.getAbilityScores().get(refAbilityScore);
        if (abilityScoreDto != null) {
            return abilityScoreDto.calcModifier();
        } else {
            return 0;
        }
    }

    public int calcArmorModifier(CharacterDto character) {
        if (character.getArmor() == null) {
            return 0;
        } else {
            if (this.refAbilityScore == AbilityScoreEnum.DEX || this.refAbilityScore == AbilityScoreEnum.STR) {
                if (character.abilityScores.get(AbilityScoreEnum.STR).baseValue >= character.getArmor().getStrength()) {
                    return 0;
                } else {
                    return -character.getArmor().getCheckPenalty();
                }
            } else {
                return 0;
            }
        }
    }

    public int calcValue(CharacterDto character) {
        return character.getLevel() +
                this.proficiency.calcProficiency().getModifier() +
                this.calcAttributeModifier(character) +
                this.calcItemModifier() +
                this.calcArmorModifier(character);
    }
}
