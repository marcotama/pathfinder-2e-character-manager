package ai.ragu.charactermanager.dto

import ai.ragu.charactermanager.enumeration.ArmorTraitEnum
import ai.ragu.charactermanager.enumeration.ArmorTypeEnum
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
class ArmorDto : Equipment {
    @JsonProperty("code")
    @JsonPropertyDescription("A unique identifier for this armor")
    @ToString.Include
    @EqualsAndHashCode.Include
    private val code: String? = null
    @JsonProperty("name")
    @JsonPropertyDescription("The name for this armor")
    private val name: String? = null
    @JsonProperty("category")
    @JsonPropertyDescription("The category of this armor")
    private val category: ItemCategoryEnum? = null
    @JsonProperty("price")
    @JsonPropertyDescription("The price of this armor")
    private val price: AmountDto? = null
    @JsonProperty("acBonus")
    @JsonPropertyDescription("The AC bonus of this armor")
    private val acBonus = 0
    @JsonProperty("dexCap")
    @JsonPropertyDescription("The DEX cap of this armor")
    private val dexCap = 0
    @JsonProperty("checkPenalty")
    @JsonPropertyDescription("The check penalty of this armor")
    private val checkPenalty = 0
    @JsonProperty("speedPenalty")
    @JsonPropertyDescription("The speed penalty of this armor")
    private val speedPenalty = 0
    @JsonProperty("strength")
    @JsonPropertyDescription("The STR requirement of this armor")
    private val strength = 0
    @JsonProperty("bulk")
    @JsonPropertyDescription("The bulk of this armor")
    private val bulk = 0
    @JsonProperty("type")
    @JsonPropertyDescription("The type of this armor")
    private val type: ArmorTypeEnum? = null
    @JsonProperty("traits")
    @JsonPropertyDescription("The traits of this armor")
    private val traits: List<ArmorTraitEnum>? = null
}