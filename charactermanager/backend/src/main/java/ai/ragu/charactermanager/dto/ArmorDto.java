package ai.ragu.charactermanager.dto;

import ai.ragu.charactermanager.enumeration.ArmorTraitEnum;
import ai.ragu.charactermanager.enumeration.ArmorTypeEnum;
import ai.ragu.charactermanager.enumeration.ItemCategoryEnum;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import java.util.List;


/**
 * An armor
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "code")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ArmorDto implements Equipment {

    @JsonProperty("code")
    @JsonPropertyDescription("A unique identifier for this armor")
    @ToString.Include
    @EqualsAndHashCode.Include
    private String code;

    @JsonProperty("name")
    @JsonPropertyDescription("The name for this armor")
    private String name;

    @JsonProperty("category")
    @JsonPropertyDescription("The category of this armor")
    private ItemCategoryEnum category;

    @JsonProperty("price")
    @JsonPropertyDescription("The price of this armor")
    private AmountDto price;

    @JsonProperty("acBonus")
    @JsonPropertyDescription("The AC bonus of this armor")
    private int acBonus;

    @JsonProperty("dexCap")
    @JsonPropertyDescription("The DEX cap of this armor")
    private int dexCap;

    @JsonProperty("checkPenalty")
    @JsonPropertyDescription("The check penalty of this armor")
    private int checkPenalty;

    @JsonProperty("speedPenalty")
    @JsonPropertyDescription("The speed penalty of this armor")
    private int speedPenalty;

    @JsonProperty("strength")
    @JsonPropertyDescription("The STR requirement of this armor")
    private int strength;

    @JsonProperty("bulk")
    @JsonPropertyDescription("The bulk of this armor")
    private int bulk;

    @JsonProperty("type")
    @JsonPropertyDescription("The type of this armor")
    private ArmorTypeEnum type;

    @JsonProperty("traits")
    @JsonPropertyDescription("The traits of this armor")
    private List<ArmorTraitEnum> traits;
}
