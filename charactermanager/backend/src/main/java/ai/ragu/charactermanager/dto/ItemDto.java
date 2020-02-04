package ai.ragu.charactermanager.dto;

import ai.ragu.charactermanager.enumeration.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import java.util.List;
import java.util.Map;


/**
 * An item
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "code")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemDto implements Equipment {

    @JsonProperty("code")
    @JsonPropertyDescription("A unique identifier for this item")
    @ToString.Include
    @EqualsAndHashCode.Include
    private String code;

    @JsonProperty("name")
    @JsonPropertyDescription("The name for this item")
    private String name;

    @JsonProperty("description")
    @JsonPropertyDescription("The description for this item")
    private String description;

    @JsonProperty("traits")
    @JsonPropertyDescription("The traits associated to this item")
    private List<String> traits;

    @JsonProperty("usage")
    @JsonPropertyDescription("The usage of this item")
    private String usage;

    @JsonProperty("numActions")
    @JsonPropertyDescription("The number of actions required to use this item")
    private String numActions;

    @JsonProperty("types")
    @JsonPropertyDescription("The types of this item")
    private List<ItemTypeDto> types;

    @JsonProperty("activation")
    @JsonPropertyDescription("The activation modes of this item")
    private List<ActivationEnum> activation;

    @JsonProperty("bulk")
    @JsonPropertyDescription("The bulk of this item")
    private ItemBulkEnum bulk;

    @JsonProperty("price")
    @JsonPropertyDescription("The price of this item")
    private Map<CurrencyEnum, Integer> price;

    @JsonProperty("level")
    @JsonPropertyDescription("The level for this item")
    private int level;

    @JsonProperty("craftRequirements")
    @JsonPropertyDescription("The craft requirements of this item type")
    private String craftRequirements;
}
