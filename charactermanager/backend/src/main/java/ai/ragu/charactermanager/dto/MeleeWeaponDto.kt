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
class MeleeWeaponDto {
    @JsonProperty("code")
    @JsonPropertyDescription("A unique identifier for this weapon")
    @ToString.Include
    @EqualsAndHashCode.Include
    private val code: String? = null
    @JsonProperty("name")
    @JsonPropertyDescription("The name for this weapon")
    private val name: String? = null
    @JsonProperty("category")
    @JsonPropertyDescription("The category of this weapon")
    private val category: ItemCategoryEnum? = null
    @JsonProperty("price")
    @JsonPropertyDescription("The price of this weapon")
    private val price: AmountDto? = null
    @JsonProperty("damage")
    @JsonPropertyDescription("The damage of this weapon")
    private val damage: Map<DieEnum, Pair<DamageTypeEnum, Int>>? = null
    @JsonProperty("bulk")
    @JsonPropertyDescription("The bulk of this weapon")
    private val bulk = 0
    @JsonProperty("hands")
    @JsonPropertyDescription("The hands required to use this weapon")
    private val hands = 0
    @JsonProperty("traits")
    @JsonPropertyDescription("The traits of this weapon")
    private val traits: List<WeaponTraitEnum>? = null
    @JsonProperty("type")
    @JsonPropertyDescription("The type of this weapon")
    private val type: MeleeWeaponTypeEnum? = null
}