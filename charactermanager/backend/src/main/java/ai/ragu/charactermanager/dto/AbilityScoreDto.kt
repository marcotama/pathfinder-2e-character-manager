package ai.ragu.charactermanager.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import lombok.Data
import lombok.NoArgsConstructor
import java.util.*

@Data
@NoArgsConstructor
class AbilityScoreDto {
    @JsonProperty("baseValue")
    @JsonPropertyDescription("The base value of this ability score")
    var baseValue = 0
    @JsonProperty("modifiers")
    @JsonPropertyDescription("The modifiers of this ability score")
    var modifiers: // @Nonnull
            List<AbilityScoreModifierDto> = ArrayList()

    fun calcModifier(): Int {
        return (calcScore() - 10) / 2
    }

    fun calcScore(): Int {
        return baseValue + modifiers.stream()
                .mapToInt { obj: AbilityScoreModifierDto -> obj.getDelta() }
                .sum()
    }
}