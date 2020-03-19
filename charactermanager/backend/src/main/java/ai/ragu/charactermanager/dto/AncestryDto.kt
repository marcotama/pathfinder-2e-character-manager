package ai.ragu.charactermanager.dto

import ai.ragu.charactermanager.enumeration.AbilityScoreEnum
import ai.ragu.charactermanager.enumeration.CreatureSizeEnum
import ai.ragu.charactermanager.enumeration.LanguageEnum
import ai.ragu.charactermanager.enumeration.SourceEnum
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
@JsonIdentityInfo(generator = PropertyGenerator::class, property = "id")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
abstract class AncestryDto {
    @JsonProperty("id")
    @JsonPropertyDescription("A unique identifier for this ancestry")
    @EqualsAndHashCode.Include
    @Nonnull
    private val id: String? = null
    @JsonProperty("name")
    @JsonPropertyDescription("The name of this ancestry")
    @ToString.Include
    @Nonnull
    private val name: String? = null
    @JsonProperty("baseHitPoints")
    @JsonPropertyDescription("The number of hit points that this ancestry grants")
    @Nonnull
    var baseHitPoints: Int? = null
    @JsonProperty("abilityBoosts")
    @JsonPropertyDescription("The fixed ability boosts granted by this ancestry")
    @Nonnull
    var abilityBoosts: Set<AbilityScoreEnum>? = null
    @JsonProperty("numFreeAbilityBoosts")
    @JsonPropertyDescription("The number of free ability boosts granted by this class")
    @Nonnull
    var numFreeAbilityBoosts: Int? = null
    @JsonProperty("abilityFlaws")
    @JsonPropertyDescription("The fixed ability flaws caused by this ancestry")
    @Nonnull
    var abilityFlaws: Set<AbilityScoreEnum>? = null
    @JsonProperty("ancestryFeatLevels")
    @JsonPropertyDescription("The levels at which this ancestry grants an additional feat")
    @Nonnull
    var ancestryFeatLevels: List<Int>? = null
    // FIXME unsure
    @JsonProperty("ancestryFeatReference")
    @JsonPropertyDescription("The identifier of the feat granted by this ancestry")
    @Nonnull
    var ancestryFeatReference: String? = null
    // FIXME unsure
    @JsonProperty("ancestryHeritageReference")
    @JsonPropertyDescription("The identifier of the heritage granted by this ancestry")
    @Nonnull
    var ancestryHeritageReference: String? = null
    @JsonProperty("description")
    @JsonPropertyDescription("The description for this class")
    @Nonnull
    var description: String? = null
    @JsonProperty("languages")
    @JsonPropertyDescription("The fixed languages granted by this class")
    @Nonnull
    var languages: List<LanguageEnum>? = null
    @JsonProperty("numFreeLanguages")
    @JsonPropertyDescription("The number of free languages granted by this class")
    @Nonnull
    var numFreeLanguages: Int? = null
    @JsonProperty("grantedFeats")
    @JsonPropertyDescription("The identifiers of the feats granted by this class")
    @Nonnull
    var grantedFeats: List<String>? = null
    @JsonProperty("grantedSpecials")
    @JsonPropertyDescription("The identifiers of the specials granted by this class")
    @Nonnull
    var grantedSpecials: List<String>? = null
    @JsonProperty("traits")
    @JsonPropertyDescription("The traits of this class")
    @Nonnull
    var traits: List<String>? = null
    @JsonProperty("size")
    @JsonPropertyDescription("The size of characters of this ancestry")
    @Nonnull
    var size: CreatureSizeEnum? = null
    @JsonProperty("speed")
    @JsonPropertyDescription("The speed of characters of this ancestry")
    @Nonnull
    var speed: Int? = null
    @JsonProperty("src")
    @JsonPropertyDescription("The source of this ancestry")
    @Nonnull
    var src: SourceEnum? = null
    @JsonProperty("url")
    @JsonPropertyDescription("The url where to find more details about this ancestry")
    @Nonnull
    var url: String? = null

    fun activateAncestry(character: CharacterDto?) { // create choices for free languages and ability boosts
// apply fixed ability boosts
// apply fixed ability flaws
    }
}