package ai.ragu.charactermanager.dto;

import ai.ragu.charactermanager.enumeration.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.annotation.Nonnull;
import java.util.Map;


/**
 * An armor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "code")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClazzDto {

    @JsonProperty("code")
    @JsonPropertyDescription("A unique identifier for this character")
    @ToString.Include
    @EqualsAndHashCode.Include
    @Nonnull
    private String code;

    @JsonProperty("name")
    @JsonPropertyDescription("The name of this character")
    @Nonnull
    private String name;
    @JsonProperty("keyAbilityScore")
    @JsonPropertyDescription("The key ability score of this class")
    private AbilityScoreEnum keyAbilityScore;

    @JsonProperty("perception")
    @JsonPropertyDescription("The perception proficiency of this class")
    private ProficiencyLevelEnum perception;

    @JsonProperty("savingThrows")
    @JsonPropertyDescription("The saving throws of this class")
    private Map<SavingThrowEnum, ProficiencyLevelEnum> savingThrows;

    @JsonProperty("skills")
    @JsonPropertyDescription("The skills of this class")
    private Map<SkillEnum, ProficiencyLevelEnum> skills;

    @JsonProperty("attacks")
    @JsonPropertyDescription("The attacks of this class")
    private Map<AttackProficiencyEnum, ProficiencyLevelEnum> attacks;

    @JsonProperty("defenses")
    @JsonPropertyDescription("The defenses of this class")
    private Map<DefenseProficiencyEnum, ProficiencyLevelEnum> defenses;

    @JsonProperty("baseHitPointsIncrease")
    @JsonPropertyDescription("The base hit points increase of this class")
    private Integer baseHitPointsIncrease;

    public int calcHitPointsIncrease(CharacterDto character) {
        return this.baseHitPointsIncrease + character.abilityScores.get(AbilityScoreEnum.CON).calcModifier();
    }

}
