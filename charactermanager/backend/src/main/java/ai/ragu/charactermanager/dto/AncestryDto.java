package ai.ragu.charactermanager.dto;

import ai.ragu.charactermanager.enumeration.AbilityScoreEnum;
import ai.ragu.charactermanager.enumeration.CreatureSizeEnum;
import ai.ragu.charactermanager.enumeration.LanguageEnum;
import ai.ragu.charactermanager.enumeration.SourceEnum;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class AncestryDto {

    @JsonProperty("id")
    @JsonPropertyDescription("A unique identifier for this ancestry")
    @EqualsAndHashCode.Include
    @Nonnull private String id;

    @JsonProperty("name")
    @JsonPropertyDescription("The name of this ancestry")
    @ToString.Include
    @Nonnull private String name;

    @JsonProperty("baseHitPoints")
    @JsonPropertyDescription("The number of hit points that this ancestry grants")
    @Nonnull Integer baseHitPoints;


    @JsonProperty("abilityBoosts")
    @JsonPropertyDescription("The fixed ability boosts granted by this ancestry")
    @Nonnull Set<AbilityScoreEnum> abilityBoosts;

    @JsonProperty("numFreeAbilityBoosts")
    @JsonPropertyDescription("The number of free ability boosts granted by this class")
    @Nonnull Integer numFreeAbilityBoosts;

    @JsonProperty("abilityFlaws")
    @JsonPropertyDescription("The fixed ability flaws caused by this ancestry")
    @Nonnull Set<AbilityScoreEnum> abilityFlaws;

    @JsonProperty("ancestryFeatLevels")
    @JsonPropertyDescription("The levels at which this ancestry grants an additional feat")
    @Nonnull List<Integer> ancestryFeatLevels;

    // FIXME unsure
    @JsonProperty("ancestryFeatReference")
    @JsonPropertyDescription("The identifier of the feat granted by this ancestry")
    @Nonnull String ancestryFeatReference;

    // FIXME unsure
    @JsonProperty("ancestryHeritageReference")
    @JsonPropertyDescription("The identifier of the heritage granted by this ancestry")
    @Nonnull String ancestryHeritageReference;

    @JsonProperty("description")
    @JsonPropertyDescription("The description for this class")
    @Nonnull String description;

    @JsonProperty("languages")
    @JsonPropertyDescription("The fixed languages granted by this class")
    @Nonnull List<LanguageEnum> languages;

    @JsonProperty("numFreeLanguages")
    @JsonPropertyDescription("The number of free languages granted by this class")
    @Nonnull Integer numFreeLanguages;

    @JsonProperty("grantedFeats")
    @JsonPropertyDescription("The identifiers of the feats granted by this class")
    @Nonnull List<String> grantedFeats;

    @JsonProperty("grantedSpecials")
    @JsonPropertyDescription("The identifiers of the specials granted by this class")
    @Nonnull List<String> grantedSpecials;

    @JsonProperty("traits")
    @JsonPropertyDescription("The traits of this class")
    @Nonnull List<String> traits;

    @JsonProperty("size")
    @JsonPropertyDescription("The size of characters of this ancestry")
    @Nonnull CreatureSizeEnum size;

    @JsonProperty("speed")
    @JsonPropertyDescription("The speed of characters of this ancestry")
    @Nonnull Integer speed;

    @JsonProperty("src")
    @JsonPropertyDescription("The source of this ancestry")
    @Nonnull SourceEnum src;

    @JsonProperty("url")
    @JsonPropertyDescription("The url where to find more details about this ancestry")
    @Nonnull String url;


    public void activateAncestry(CharacterDto character) {
        // create choices for free languages and ability boosts
        // apply fixed ability boosts
        // apply fixed ability flaws
    }
}
