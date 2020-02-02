package ai.ragu.charactermanager.dto;

import ai.ragu.charactermanager.enumeration.ProficiencyLevelEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nonnull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbilityScoreModifierDto {

    @JsonProperty("granter")
    @JsonPropertyDescription("The identifier of the rule that grants this modifier")
    @Nonnull
    String granter;

    @JsonProperty("delta")
    @JsonPropertyDescription("The delta set by this modifier")
    @Nonnull
    Integer delta;
}
