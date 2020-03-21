package ai.ragu.charactermanager.sheet

import ai.ragu.charactermanager.enumeration.*
import com.fasterxml.jackson.annotation.JsonPropertyDescription

class CharacterSheet {

    @JsonPropertyDescription("A unique identifier for this character")
    lateinit var code: String

    @JsonPropertyDescription("The name of this character")
    lateinit var name: String

    @JsonPropertyDescription("The ability scores of this character")
    lateinit var abilityScores: Map<AbilityScoreEnum, AbilityScoreSheetEntry>

    @JsonPropertyDescription("The skills of this character")
    lateinit var skills: Map<SkillEnum, ProficiencyBasedRollSheetEntry>

    @JsonPropertyDescription("The saving throws of this character")
    lateinit var savingThrows: Map<SavingThrowEnum, ProficiencyBasedRollSheetEntry>

    @JsonPropertyDescription("The perception of this character")
    lateinit var perception: ProficiencyBasedRollSheetEntry

    @JsonPropertyDescription("The class DC of this character")
    lateinit var classDC: ProficiencyBasedRollSheetEntry

    @JsonPropertyDescription("The spell attack roll of this character")
    lateinit var spellAttackRoll: ProficiencyBasedRollSheetEntry

    @JsonPropertyDescription("The spell DC of this character")
    lateinit var spellDC: ProficiencyBasedRollSheetEntry

    @JsonPropertyDescription("The attack proficiencies of this character")
    lateinit var attackProficiencies: Map<AttackProficiencyEnum, ProficiencyLevelEnum>

    @JsonPropertyDescription("The defense proficiencies of this character")
    lateinit var defenseProficiencies: Map<DefenseProficiencyEnum, ProficiencyLevelEnum>
}