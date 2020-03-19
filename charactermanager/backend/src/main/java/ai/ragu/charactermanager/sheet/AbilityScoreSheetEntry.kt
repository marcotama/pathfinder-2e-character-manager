package ai.ragu.charactermanager.sheet

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import lombok.AllArgsConstructor
import lombok.Data

@Data
@AllArgsConstructor
class AbilityScoreSheetEntry {
    @JsonProperty("score")
    @JsonPropertyDescription("The score of the ability")
    var score: // @Nonnull
            Int? = null
    @JsonProperty("modifier")
    @JsonPropertyDescription("The modifier given by the ability score")
    var modifier: // @Nonnull
            Int? = null
}