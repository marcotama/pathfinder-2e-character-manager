package ai.ragu.charactermanager.sheet;

import ai.ragu.charactermanager.enumeration.AbilityScoreEnum;
import ai.ragu.charactermanager.enumeration.ProficiencyLevelEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.Nonnull;

@Data
@AllArgsConstructor
public class ProficiencyBasedRollSheetEntry {

    @JsonProperty("refAbilityScore")
    @JsonPropertyDescription("The ability score that influences this entry")
    @Nonnull
    AbilityScoreEnum refAbilityScore;

    @JsonProperty("refAbilityScoreModifier")
    @JsonPropertyDescription("The modifier given by the ability score")
    @Nonnull
    Integer refAbilityScoreModifier;

    @JsonProperty("proficiencyLevel")
    @JsonPropertyDescription("The proficiency level for this entry")
    @Nonnull
    ProficiencyLevelEnum proficiencyLevel;

    @JsonProperty("proficiencyModifier")
    @JsonPropertyDescription("The modifier given by the proficiency level")
    @Nonnull
    Integer proficiencyModifier;

    @JsonProperty("itemModifier")
    @JsonPropertyDescription("The modifier given by items (null except for skills)")
    @Nonnull
    Integer itemModifier;

    @JsonProperty("armorModifier")
    @JsonPropertyDescription("The modifier given by armor (null except for some skills)")
    @Nonnull
    Integer armorModifier;

    @JsonProperty("totalModifier")
    @JsonPropertyDescription("The total modifier")
    @Nonnull
    Integer score;
}
