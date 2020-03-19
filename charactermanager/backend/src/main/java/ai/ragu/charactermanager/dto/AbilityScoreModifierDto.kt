package ai.ragu.charactermanager.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
class AbilityScoreModifierDto {
    @JsonProperty("granter")
    @JsonPropertyDescription("The identifier of the rule that grants this modifier")
    var granter: // @Nonnull
            String? = null
    @JsonProperty("delta")
    @JsonPropertyDescription("The delta set by this modifier")
    var delta: // @Nonnull
            Int? = null
}