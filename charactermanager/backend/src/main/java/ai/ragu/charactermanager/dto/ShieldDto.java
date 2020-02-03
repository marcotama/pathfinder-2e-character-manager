package ai.ragu.charactermanager.dto;

import ai.ragu.charactermanager.enumeration.ItemBulkEnum;
import ai.ragu.charactermanager.enumeration.ItemCategoryEnum;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.annotation.Nonnull;


/**
 * An armor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "code")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ShieldDto implements Equipment {

    @JsonProperty("code")
    @JsonPropertyDescription("A unique identifier for this shield")
    @ToString.Include
    @EqualsAndHashCode.Include
    // @Nonnull
    private String code;

    @JsonProperty("name")
    @JsonPropertyDescription("The name for this shield")
    // @Nonnull
    private String name;

    @JsonProperty("category")
    @JsonPropertyDescription("The category of this shield")
    // @Nonnull
    private ItemCategoryEnum category;

    @JsonProperty("price")
    @JsonPropertyDescription("The price of this shield")
    // @Nonnull
    private AmountDto price;

    @JsonProperty("acBonus")
    @JsonPropertyDescription("The AC bonus of this shield")
    // @Nonnull
    private Integer acBonus;

    @JsonProperty("speedPenalty")
    @JsonPropertyDescription("The speed penalty of this shield")
    // @Nonnull
    private Integer speedPenalty;

    @JsonProperty("bulk")
    @JsonPropertyDescription("The bulk of this shield")
    // @Nonnull
    private ItemBulkEnum bulk;

    @JsonProperty("hardness")
    @JsonPropertyDescription("The hardness of this shield")
    // @Nonnull
    private Integer hardness;

    @JsonProperty("hitPoints")
    @JsonPropertyDescription("The hit points of this shield")
    // @Nonnull
    private Integer hitPoints;

    @JsonProperty("brokenThreshold")
    @JsonPropertyDescription("The broken threshold of this shield")
    // @Nonnull
    private Integer brokenThreshold;
}
