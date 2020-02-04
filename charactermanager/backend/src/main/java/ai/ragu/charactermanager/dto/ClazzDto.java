package ai.ragu.charactermanager.dto;

import ai.ragu.charactermanager.enumeration.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.Map;


/**
 * An armor
 */
@Data
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "code")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class ClazzDto {

    @JsonProperty("code")
    @JsonPropertyDescription("A unique identifier for this character")
    @ToString.Include
    @EqualsAndHashCode.Include
    protected String code;

    @JsonProperty("name")
    @JsonPropertyDescription("The name of this character")
    protected String name;

    @JsonProperty("keyAbilityScore")
    @JsonPropertyDescription("The key ability score of this class")
    protected AbilityScoreEnum keyAbilityScore;

    @JsonProperty("perception")
    @JsonPropertyDescription("The perception proficiency of this class")
    protected ProficiencyLevelEnum perception;

    @JsonProperty("savingThrows")
    @JsonPropertyDescription("The saving throws of this class")
    protected Map<SavingThrowEnum, ProficiencyLevelEnum> savingThrows;

    @JsonProperty("skills")
    @JsonPropertyDescription("The skills of this class")
    protected Map<SkillEnum, ProficiencyLevelEnum> skills;

    @JsonProperty("attacks")
    @JsonPropertyDescription("The attacks of this class")
    protected Map<AttackProficiencyEnum, ProficiencyLevelEnum> attacks;

    @JsonProperty("defenses")
    @JsonPropertyDescription("The defenses of this class")
    protected Map<DefenseProficiencyEnum, ProficiencyLevelEnum> defenses;

    @JsonProperty("baseHitPointsIncrease")
    @JsonPropertyDescription("The base hit points increase of this class")
    protected Integer baseHitPointsIncrease;

    public ClazzDto(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public int calcHitPointsIncrease(CharacterDto character) {
        return this.baseHitPointsIncrease + character.abilityScores.get(AbilityScoreEnum.CON).calcModifier();
    }

    public abstract List<Choice> getChoices(int level);

}
