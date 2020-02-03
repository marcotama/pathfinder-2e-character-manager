package ai.ragu.charactermanager.sheet;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.Nonnull;

@Data
@AllArgsConstructor
public class AbilityScoreSheetEntry {

    @JsonProperty("score")
    @JsonPropertyDescription("The score of the ability")
    // @Nonnull
    Integer score;

    @JsonProperty("modifier")
    @JsonPropertyDescription("The modifier given by the ability score")
    // @Nonnull
    Integer modifier;
}
