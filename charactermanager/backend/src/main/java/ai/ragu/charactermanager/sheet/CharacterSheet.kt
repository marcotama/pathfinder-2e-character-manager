package ai.ragu.charactermanager.sheet

import ai.ragu.charactermanager.enumeration.*
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import lombok.AllArgsConstructor
import lombok.Data

@Data
@AllArgsConstructor
class CharacterSheet {
    @JsonProperty("code")
    @JsonPropertyDescription("A unique identifier for this character")
    var code: // @Nonnull
            String? = null
    @JsonProperty("name")
    @JsonPropertyDescription("The name of this character")
    @Nonnull
    var name: String? = null
    @JsonProperty("abilityScores")
    @JsonPropertyDescription("The ability scores of this character")
    var abilityScores: // @Nonnull
            Map<AbilityScoreEnum, AbilityScoreSheetEntry>? = null
    @JsonProperty("skills")
    @JsonPropertyDescription("The skills of this character")
    var skills: // @Nonnull
            Map<SkillEnum, ProficiencyBasedRollSheetEntry>? = null
    @JsonProperty("savingThrows")
    @JsonPropertyDescription("The saving throws of this character")
    var savingThrows: // @Nonnull
            Map<SavingThrowEnum, ProficiencyBasedRollSheetEntry>? = null
    @JsonProperty("perception")
    @JsonPropertyDescription("The perception of this character")
    var perception: ProficiencyBasedRollSheetEntry? = null
    @JsonProperty("classDC")
    @JsonPropertyDescription("The class DC of this character")
    var classDC: ProficiencyBasedRollSheetEntry? = null
    @JsonProperty("spellAttackRoll")
    @JsonPropertyDescription("The spell attack roll of this character")
    var spellAttackRoll: ProficiencyBasedRollSheetEntry? = null
    @JsonProperty("spellDC")
    @JsonPropertyDescription("The spell DC of this character")
    var spellDC: ProficiencyBasedRollSheetEntry? = null
    @JsonProperty("attackProficiencies")
    @JsonPropertyDescription("The attack proficiencies of this character")
    var attackProficiencies: Map<AttackProficiencyEnum, ProficiencyLevelEnum>? = null
    @JsonProperty("defenseProficiencies")
    @JsonPropertyDescription("The defense proficiencies of this character")
    var defenseProficiencies: Map<DefenseProficiencyEnum, ProficiencyLevelEnum>? = null
}