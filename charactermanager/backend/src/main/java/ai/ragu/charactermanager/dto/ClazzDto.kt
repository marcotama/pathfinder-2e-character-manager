package ai.ragu.charactermanager.dto

import ai.ragu.charactermanager.enumeration.*
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator
import lombok.AllArgsConstructor
import lombok.Data
import lombok.EqualsAndHashCode
import lombok.ToString

@Data
@AllArgsConstructor
@JsonIdentityInfo(generator = PropertyGenerator::class, property = "code")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
abstract class ClazzDto(@field:Include @field:Include @field:JsonPropertyDescription("A unique identifier for this character") @field:JsonProperty("code") protected var code: String, @field:JsonPropertyDescription("The name of this character") @field:JsonProperty("name") protected var name: String) {
    @JsonProperty("keyAbilityScore")
    @JsonPropertyDescription("The key ability score of this class")
    protected var keyAbilityScore: AbilityScoreEnum? = null
    @JsonProperty("perception")
    @JsonPropertyDescription("The perception proficiency of this class")
    protected var perception: ProficiencyLevelEnum? = null
    @JsonProperty("savingThrows")
    @JsonPropertyDescription("The saving throws of this class")
    protected var savingThrows: Map<SavingThrowEnum, ProficiencyLevelEnum>? = null
    @JsonProperty("skills")
    @JsonPropertyDescription("The skills of this class")
    protected var skills: Map<SkillEnum, ProficiencyLevelEnum>? = null
    @JsonProperty("attacks")
    @JsonPropertyDescription("The attacks of this class")
    protected var attacks: Map<AttackProficiencyEnum, ProficiencyLevelEnum>? = null
    @JsonProperty("defenses")
    @JsonPropertyDescription("The defenses of this class")
    protected var defenses: Map<DefenseProficiencyEnum, ProficiencyLevelEnum>? = null
    @JsonProperty("baseHitPointsIncrease")
    @JsonPropertyDescription("The base hit points increase of this class")
    protected var baseHitPointsIncrease: Int? = null
    @JsonProperty("src")
    @JsonPropertyDescription("The source of this class")
    @Nonnull
    protected var src: SourceEnum? = null
    @JsonProperty("url")
    @JsonPropertyDescription("The url where to find more details about this class")
    @Nonnull
    protected var url: String? = null

    fun calcHitPointsIncrease(character: CharacterDto): Int {
        return baseHitPointsIncrease!! + character.abilityScores[AbilityScoreEnum.CON]!!.calcModifier()
    }

    abstract fun getChoices(level: Int): List<Choice?>?

}