package ai.ragu.charactermanager.dto

import ai.ragu.charactermanager.enumeration.*
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator
import lombok.*
import org.apache.commons.lang3.tuple.Pair

/**
 * An armor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = PropertyGenerator::class, property = "code")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
class RangedWeaponDto {
    @JsonProperty("code")
    @JsonPropertyDescription("A unique identifier for this weapon")
    @ToString.Include
    @EqualsAndHashCode.Include // @Nonnull
    var code: String? = null

    @JsonProperty("name")
    @JsonPropertyDescription("The name for this weapon") // @Nonnull
    var name: String? = null

    @JsonProperty("category")
    @JsonPropertyDescription("The category of this weapon") // @Nonnull
    var category: ItemCategoryEnum? = null

    @JsonProperty("price")
    @JsonPropertyDescription("The price of this weapon") // @Nonnull
    var price: AmountDto? = null

    @JsonProperty("damage")
    @JsonPropertyDescription("The damage of this weapon") // @Nonnull
    var damage: Map<DieEnum, Pair<DamageTypeEnum, Int>>? = null

    @JsonProperty("bulk")
    @JsonPropertyDescription("The bulk of this weapon") // @Nonnull
    var bulk = 0

    @JsonProperty("hands")
    @JsonPropertyDescription("The hands required to use this weapon") // @Nonnull
    var hands = 0

    @JsonProperty("traits")
    @JsonPropertyDescription("The traits of this weapon") // @Nonnull
    var traits: List<WeaponTraitEnum>? = null

    @JsonProperty("range")
    @JsonPropertyDescription("The range of this weapon") // @Nonnull
    var range = 0

    @JsonProperty("reload")
    @JsonPropertyDescription("The reload rate of this weapon (number of actions for reload)") // @Nonnull
    var reload = 0

    @JsonProperty("type")
    @JsonPropertyDescription("The type of this weapon") // @Nonnull
    var type: RangedWeaponTypeEnum? = null
}