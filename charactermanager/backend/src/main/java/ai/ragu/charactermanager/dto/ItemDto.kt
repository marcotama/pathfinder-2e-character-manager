package ai.ragu.charactermanager.dto

import ai.ragu.charactermanager.enumeration.ActivationEnum
import ai.ragu.charactermanager.enumeration.CurrencyEnum
import ai.ragu.charactermanager.enumeration.ItemBulkEnum
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator
import lombok.*

/**
 * An item
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = PropertyGenerator::class, property = "code")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
class ItemDto : Equipment {
    @JsonProperty("code")
    @JsonPropertyDescription("A unique identifier for this item")
    @ToString.Include
    @EqualsAndHashCode.Include
    private val code: String? = null
    @JsonProperty("name")
    @JsonPropertyDescription("The name for this item")
    private val name: String? = null
    @JsonProperty("description")
    @JsonPropertyDescription("The description for this item")
    private val description: String? = null
    @JsonProperty("traits")
    @JsonPropertyDescription("The traits associated to this item")
    private val traits: List<String>? = null
    @JsonProperty("usage")
    @JsonPropertyDescription("The usage of this item")
    private val usage: String? = null
    @JsonProperty("numActions")
    @JsonPropertyDescription("The number of actions required to use this item")
    private val numActions: String? = null
    @JsonProperty("types")
    @JsonPropertyDescription("The types of this item")
    private val types: List<ItemTypeDto>? = null
    @JsonProperty("activation")
    @JsonPropertyDescription("The activation modes of this item")
    private val activation: List<ActivationEnum>? = null
    @JsonProperty("bulk")
    @JsonPropertyDescription("The bulk of this item")
    private val bulk: ItemBulkEnum? = null
    @JsonProperty("price")
    @JsonPropertyDescription("The price of this item")
    private val price: Map<CurrencyEnum, Int>? = null
    @JsonProperty("level")
    @JsonPropertyDescription("The level for this item")
    private val level = 0
    @JsonProperty("craftRequirements")
    @JsonPropertyDescription("The craft requirements of this item type")
    private val craftRequirements: String? = null
}