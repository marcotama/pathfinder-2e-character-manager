package ai.ragu.charactermanager.dto

import ai.ragu.charactermanager.enumeration.ItemBulkEnum
import ai.ragu.charactermanager.enumeration.ItemCategoryEnum
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator
import lombok.*

/**
 * An armor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = PropertyGenerator::class, property = "code")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
class ShieldDto : Equipment {
    @JsonProperty("code")
    @JsonPropertyDescription("A unique identifier for this shield")
    @ToString.Include
    @EqualsAndHashCode.Include // @Nonnull
    private val code: String? = null
    @JsonProperty("name")
    @JsonPropertyDescription("The name for this shield") // @Nonnull
    private val name: String? = null
    @JsonProperty("category")
    @JsonPropertyDescription("The category of this shield") // @Nonnull
    private val category: ItemCategoryEnum? = null
    @JsonProperty("price")
    @JsonPropertyDescription("The price of this shield") // @Nonnull
    private val price: AmountDto? = null
    @JsonProperty("acBonus")
    @JsonPropertyDescription("The AC bonus of this shield") // @Nonnull
    private val acBonus: Int? = null
    @JsonProperty("speedPenalty")
    @JsonPropertyDescription("The speed penalty of this shield") // @Nonnull
    private val speedPenalty: Int? = null
    @JsonProperty("bulk")
    @JsonPropertyDescription("The bulk of this shield") // @Nonnull
    private val bulk: ItemBulkEnum? = null
    @JsonProperty("hardness")
    @JsonPropertyDescription("The hardness of this shield") // @Nonnull
    private val hardness: Int? = null
    @JsonProperty("hitPoints")
    @JsonPropertyDescription("The hit points of this shield") // @Nonnull
    private val hitPoints: Int? = null
    @JsonProperty("brokenThreshold")
    @JsonPropertyDescription("The broken threshold of this shield") // @Nonnull
    private val brokenThreshold: Int? = null
}