package ai.ragu.charactermanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class AbilityScoreDto {

    @JsonProperty("baseValue")
    @JsonPropertyDescription("The base value of this ability score")
    Integer baseValue = 0;

    @JsonProperty("modifiers")
    @JsonPropertyDescription("The modifiers of this ability score")
    // @Nonnull
    List<AbilityScoreModifierDto> modifiers = new ArrayList<>();



    public int calcModifier() {
        return (calcScore() - 10) / 2;
    }

    public int calcScore() {
        return this.baseValue + this.modifiers.stream()
                .mapToInt(AbilityScoreModifierDto::getDelta)
                .sum();
    }
}
