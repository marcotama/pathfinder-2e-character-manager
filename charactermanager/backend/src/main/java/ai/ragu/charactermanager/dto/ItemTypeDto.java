package ai.ragu.charactermanager.dto;

import ai.ragu.charactermanager.enumeration.CurrencyEnum;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

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
public class ItemTypeDto implements Equipment {

    @JsonProperty("code")
    @JsonPropertyDescription("A unique identifier for this item type")
    @ToString.Include
    @EqualsAndHashCode.Include
    private String code;

    @JsonProperty("type")
    @JsonPropertyDescription("The name of this item type")
    private String type;

    @JsonProperty("description")
    @JsonPropertyDescription("The description of this item type")
    private String description;

    @JsonProperty("level")
    @JsonPropertyDescription("The level for this item type")
    private int level;

    @JsonProperty("price")
    @JsonPropertyDescription("The price of this item type")
    private Map<CurrencyEnum, Integer> price;
}
