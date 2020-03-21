package ai.ragu.charactermanager.sheet

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription

class AbilityScoreSheetEntry {
    @JsonProperty("score")
    @JsonPropertyDescription("The score of the ability")
    var score: Int = 0

    @JsonProperty("modifier")
    @JsonPropertyDescription("The modifier given by the ability score")
    var modifier: Int = 0
}