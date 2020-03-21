package ai.ragu.charactermanager.sheet

import ai.ragu.charactermanager.enumeration.AbilityScoreEnum
import ai.ragu.charactermanager.enumeration.ProficiencyLevelEnum
import com.fasterxml.jackson.annotation.JsonPropertyDescription

class ProficiencyBasedRollSheetEntry {

    @JsonPropertyDescription("The ability score that influences this entry")
    lateinit var refAbilityScore: AbilityScoreEnum

    @JsonPropertyDescription("The modifier given by the ability score")
    var refAbilityScoreModifier: Int = 0

    @JsonPropertyDescription("The proficiency level for this entry")
    lateinit var proficiencyLevel: ProficiencyLevelEnum

    @JsonPropertyDescription("The modifier given by the proficiency level")
    var proficiencyModifier: Int = 0

    @JsonPropertyDescription("The modifier given by items (null except for skills)")
    var itemModifier: Int = 0

    @JsonPropertyDescription("The modifier given by armor (null except for some skills)")
    var armorModifier: Int = 0

    @JsonPropertyDescription("The total modifier")
    var score: Int = 0
}