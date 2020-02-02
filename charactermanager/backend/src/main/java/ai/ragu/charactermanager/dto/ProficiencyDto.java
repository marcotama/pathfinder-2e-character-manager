package ai.ragu.charactermanager.dto;

import ai.ragu.charactermanager.enumeration.ProficiencyLevelEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Data;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
public class ProficiencyDto {

    @JsonProperty("modifiers")
    @JsonPropertyDescription("The modifiers of this ability score")
    @Nonnull
    List<ProficiencyModifierDto> modifiers;

    public ProficiencyDto() {
        modifiers = new ArrayList<>();
    }

    public ProficiencyLevelEnum calcProficiency() {
        if (this.modifiers.isEmpty()) {
            return ProficiencyLevelEnum.UNTRAINED;
        } else {
            int maxPriority = this.modifiers.stream()
                    .mapToInt(ProficiencyModifierDto::getPriority)
                    .max()
                    .orElseThrow();
            return this.modifiers.stream()
                    .filter(modifier -> modifier.getPriority() == maxPriority)
                    .map(ProficiencyModifierDto::getProficiencyLevel)
                    .max(Comparator.comparingInt(ProficiencyLevelEnum::getComparableValue))
                    .orElseThrow();
        }
    }
}
