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
    @Nonnull
    private ProficiencyDto proficiency = new ProficiencyDto();

    @JsonProperty("refAbilityScore")
    @JsonPropertyDescription("The ability score used in this roll - if null, the reference ability score of the character is used")
    @Nullable
    private AbilityScoreEnum refAbilityScore = null;

    public ProficiencyBasedRollDto(@Nonnull AbilityScoreEnum refAbilityScore) {
        this.proficiency = new ProficiencyDto();
        this.refAbilityScore = refAbilityScore;
    }

    public int getItemModifier() {
        return 0; // TODO
    }

    public AbilityScoreEnum getRefAbilityScore(CharacterDto character) {
        return this.refAbilityScore == null ? character.getClazz().getKeyAbilityScore() : this.refAbilityScore;
    }

    public int getAttributeModifier(CharacterDto character) {
        AbilityScoreEnum refAbilityScore = getRefAbilityScore(character);
        return character.getAbilityScores().get(refAbilityScore).calcModifier();
    }

    public int getArmorModifier(CharacterDto character) {
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

    public int getValue(CharacterDto character) {
        return character.getLevel() +
                this.proficiency.calcProficiency().getModifier() +
                this.getAttributeModifier(character) +
                this.getItemModifier() +
                this.getArmorModifier(character);
    }
}
