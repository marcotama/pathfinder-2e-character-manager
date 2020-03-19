package ai.ragu.charactermanager.dto

import ai.ragu.charactermanager.enumeration.ProficiencyLevelEnum
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
class ProficiencyModifierDto {
    @JsonProperty("granter")
    @JsonPropertyDescription("The identifier of the rule that grants this modifier")
    var granter: // @Nonnull
            String? = null
    @JsonProperty("proficiencyLevel")
    @JsonPropertyDescription("The proficiency level set by this modifier")
    var proficiencyLevel: // @Nonnull
            ProficiencyLevelEnum? = null
    @JsonProperty("priority")
    @JsonPropertyDescription("The level set by this modifier")
    var priority: // @Nonnull
            Int? = null
}