package ai.ragu.charactermanager.sheet

import ai.ragu.charactermanager.enumeration.AbilityScoreEnum
import ai.ragu.charactermanager.enumeration.ProficiencyLevelEnum
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import lombok.AllArgsConstructor
import lombok.Data

@Data
@AllArgsConstructor
class ProficiencyBasedRollSheetEntry {
    @JsonProperty("refAbilityScore")
    @JsonPropertyDescription("The ability score that influences this entry")
    var refAbilityScore: // @Nonnull
            AbilityScoreEnum? = null
    @JsonProperty("refAbilityScoreModifier")
    @JsonPropertyDescription("The modifier given by the ability score")
    var refAbilityScoreModifier: // @Nonnull
            Int? = null
    @JsonProperty("proficiencyLevel")
    @JsonPropertyDescription("The proficiency level for this entry")
    var proficiencyLevel: // @Nonnull
            ProficiencyLevelEnum? = null
    @JsonProperty("proficiencyModifier")
    @JsonPropertyDescription("The modifier given by the proficiency level")
    var proficiencyModifier: // @Nonnull
            Int? = null
    @JsonProperty("itemModifier")
    @JsonPropertyDescription("The modifier given by items (null except for skills)")
    var itemModifier: // @Nonnull
            Int? = null
    @JsonProperty("armorModifier")
    @JsonPropertyDescription("The modifier given by armor (null except for some skills)")
    var armorModifier: // @Nonnull
            Int? = null
    @JsonProperty("totalModifier")
    @JsonPropertyDescription("The total modifier")
    var score: // @Nonnull
            Int? = null
}