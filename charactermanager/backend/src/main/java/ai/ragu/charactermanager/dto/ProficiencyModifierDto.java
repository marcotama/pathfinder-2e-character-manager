package ai.ragu.charactermanager.dto;

import ai.ragu.charactermanager.enumeration.ProficiencyLevelEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.javatuples.Triplet;

import javax.annotation.Nonnull;
import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProficiencyModifierDto {

    @JsonProperty("granter")
    @JsonPropertyDescription("The identifier of the rule that grants this modifier")
    // @Nonnull
    String granter;

    @JsonProperty("proficiencyLevel")
    @JsonPropertyDescription("The proficiency level set by this modifier")
    // @Nonnull
    ProficiencyLevelEnum proficiencyLevel;

    @JsonProperty("priority")
    @JsonPropertyDescription("The level set by this modifier")
    // @Nonnull
    Integer priority;
}
