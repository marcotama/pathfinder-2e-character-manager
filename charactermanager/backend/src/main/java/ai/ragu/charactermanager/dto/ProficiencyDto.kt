package ai.ragu.charactermanager.dto

import ai.ragu.charactermanager.enumeration.ProficiencyLevelEnum
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import lombok.Data
import java.util.*

@Data
class ProficiencyDto {
    @JsonProperty("modifiers")
    @JsonPropertyDescription("The modifiers of this ability score")
    var modifiers: // @Nonnull
            List<ProficiencyModifierDto>

    fun calcProficiency(): ProficiencyLevelEnum {
        return if (modifiers.isEmpty()) {
            ProficiencyLevelEnum.UNTRAINED
        } else {
            var maxPriority = modifiers.stream()
                    .mapToInt { obj: ProficiencyModifierDto -> obj.getPriority() }
                    .max()
                    .orElseThrow()
            modifiers.stream()
                    .filter { modifier: ProficiencyModifierDto -> modifier.getPriority() == maxPriority }
                    .map { obj: ProficiencyModifierDto -> obj.getProficiencyLevel() }
                    .max(Comparator.comparingInt { obj: ProficiencyLevelEnum -> obj.comparableValue })
                    .orElseThrow()
        }
    }

    init {
        modifiers = ArrayList()
    }
}