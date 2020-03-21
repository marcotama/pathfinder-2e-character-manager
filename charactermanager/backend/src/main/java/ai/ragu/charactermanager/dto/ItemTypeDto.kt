package ai.ragu.charactermanager.dto

import ai.ragu.charactermanager.enumeration.CurrencyEnum
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
class ItemTypeDto : Equipment {
    @JsonProperty("code")
    @JsonPropertyDescription("A unique identifier for this item type")
    @ToString.Include
    @EqualsAndHashCode.Include
    var code: String? = null

    @JsonProperty("type")
    @JsonPropertyDescription("The name of this item type")
    var type: String? = null

    @JsonProperty("description")
    @JsonPropertyDescription("The description of this item type")
    var description: String? = null

    @JsonProperty("level")
    @JsonPropertyDescription("The level for this item type")
    var level = 0

    @JsonProperty("price")
    @JsonPropertyDescription("The price of this item type")
    var price: Map<CurrencyEnum, Int>? = null
}