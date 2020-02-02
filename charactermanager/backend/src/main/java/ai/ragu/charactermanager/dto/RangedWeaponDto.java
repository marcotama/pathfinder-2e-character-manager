package ai.ragu.charactermanager.dto;

import ai.ragu.charactermanager.enumeration.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;


/**
 * An armor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "code")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RangedWeaponDto {

    @JsonProperty("code")
    @JsonPropertyDescription("A unique identifier for this weapon")
    @ToString.Include
    @EqualsAndHashCode.Include
    @Nonnull
    private String code;

    @JsonProperty("name")
    @JsonPropertyDescription("The name for this weapon")
    @Nonnull
    private String name;
    
    @JsonProperty("category")
    @JsonPropertyDescription("The category of this weapon")
    @Nonnull
    private ItemCategoryEnum category;

    @JsonProperty("price")
    @JsonPropertyDescription("The price of this weapon")
    @Nonnull
    private AmountDto price;

    @JsonProperty("damage")
    @JsonPropertyDescription("The damage of this weapon")
    @Nonnull
    private Map<DieEnum, Pair<DamageTypeEnum, Integer>> damage;

    @JsonProperty("bulk")
    @JsonPropertyDescription("The bulk of this weapon")
    @Nonnull
    private int bulk;

    @JsonProperty("hands")
    @JsonPropertyDescription("The hands required to use this weapon")
    @Nonnull
    private int hands;

    @JsonProperty("traits")
    @JsonPropertyDescription("The traits of this weapon")
    @Nonnull
    private List<WeaponTraitEnum> traits;

    @JsonProperty("range")
    @JsonPropertyDescription("The range of this weapon")
    @Nonnull
    private int range;

    @JsonProperty("reload")
    @JsonPropertyDescription("The reload rate of this weapon (number of actions for reload)")
    @Nonnull
    private int reload;

    @JsonProperty("type")
    @JsonPropertyDescription("The type of this weapon")
    @Nonnull
    private RangedWeaponTypeEnum type;
}
