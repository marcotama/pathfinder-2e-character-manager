package ai.ragu.charactermanager.sheet;

import ai.ragu.charactermanager.enumeration.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.Nonnull;
import java.util.Map;

@Data
@AllArgsConstructor
public class CharacterSheet {

    @JsonProperty("code")
    @JsonPropertyDescription("A unique identifier for this character")
    // @Nonnull
    String code;

    @JsonProperty("name")
    @JsonPropertyDescription("The name of this character")
    @Nonnull
    String name;

    @JsonProperty("abilityScores")
    @JsonPropertyDescription("The ability scores of this character")
    // @Nonnull
    Map<AbilityScoreEnum, AbilityScoreSheetEntry> abilityScores;

    @JsonProperty("skills")
    @JsonPropertyDescription("The skills of this character")
    // @Nonnull
    Map<SkillEnum, ProficiencyBasedRollSheetEntry> skills;

    @JsonProperty("savingThrows")
    @JsonPropertyDescription("The saving throws of this character")
    // @Nonnull
    Map<SavingThrowEnum, ProficiencyBasedRollSheetEntry> savingThrows;

    @JsonProperty("perception")
    @JsonPropertyDescription("The perception of this character")
    ProficiencyBasedRollSheetEntry perception;

    @JsonProperty("classDC")
    @JsonPropertyDescription("The class DC of this character")
    ProficiencyBasedRollSheetEntry classDC;

    @JsonProperty("spellAttackRoll")
    @JsonPropertyDescription("The spell attack roll of this character")
    ProficiencyBasedRollSheetEntry spellAttackRoll;

    @JsonProperty("spellDC")
    @JsonPropertyDescription("The spell DC of this character")
    ProficiencyBasedRollSheetEntry spellDC;

    @JsonProperty("attackProficiencies")
    @JsonPropertyDescription("The attack proficiencies of this character")
    Map<AttackProficiencyEnum, ProficiencyLevelEnum> attackProficiencies;

    @JsonProperty("defenseProficiencies")
    @JsonPropertyDescription("The defense proficiencies of this character")
    Map<DefenseProficiencyEnum, ProficiencyLevelEnum> defenseProficiencies;
}
