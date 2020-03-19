package ai.ragu.charactermanager.dto

import ai.ragu.charactermanager.enumeration.AbilityScoreEnum
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
class ProficiencyBasedRollDto(@Nonnull refAbilityScore: AbilityScoreEnum?) {
    @JsonProperty("proficiency")
    @JsonPropertyDescription("The proficiency of this roll") // @Nonnull
    private var proficiency = ProficiencyDto()
    @JsonProperty("refAbilityScore")
    @JsonPropertyDescription("The ability score used in this roll - if null, the reference ability score of the character is used")
    private val refAbilityScore: AbilityScoreEnum? = null

    fun calcItemModifier(): Int {
        return 0 // TODO
    }

    fun calcRefAbilityScore(character: CharacterDto): AbilityScoreEnum? {
        return if (refAbilityScore != null) {
            refAbilityScore
        } else {
            val clazzDto = character.clazz
            clazzDto?.getKeyAbilityScore()
        }
    }

    fun calcAttributeModifier(character: CharacterDto): Int {
        val refAbilityScore = calcRefAbilityScore(character)
        val abilityScoreDto = character.getAbilityScores()[refAbilityScore]
        return abilityScoreDto?.calcModifier() ?: 0
    }

    fun calcArmorModifier(character: CharacterDto): Int {
        return if (character.armor == null) {
            0
        } else {
            if (refAbilityScore == AbilityScoreEnum.DEX || refAbilityScore == AbilityScoreEnum.STR) {
                if (character.abilityScores[AbilityScoreEnum.STR]!!.baseValue >= character.armor.getStrength()) {
                    0
                } else {
                    -character.armor.getCheckPenalty()
                }
            } else {
                0
            }
        }
    }

    fun calcValue(character: CharacterDto): Int {
        return character.level +
                proficiency.calcProficiency().modifier +
                calcAttributeModifier(character) +
                calcItemModifier() +
                calcArmorModifier(character)
    }

    init {
        proficiency = ProficiencyDto()
        this.refAbilityScore = refAbilityScore
    }
}