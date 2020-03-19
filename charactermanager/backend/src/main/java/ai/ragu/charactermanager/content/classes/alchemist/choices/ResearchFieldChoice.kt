package ai.ragu.charactermanager.content.classes.alchemist.choices

import ai.ragu.charactermanager.content.classes.alchemist.AlchemistResearchFieldEnum
import ai.ragu.charactermanager.dto.CharacterDto
import ai.ragu.charactermanager.dto.Choice
import ai.ragu.charactermanager.dto.ItemDto
import ai.ragu.charactermanager.enumeration.AbilityScoreEnum
import ai.ragu.charactermanager.enumeration.InventoryItemEnum
import ai.ragu.charactermanager.enumeration.SkillEnum
import java.util.*
import java.util.function.Function
import java.util.function.Predicate
import java.util.stream.Collectors

class ResearchFieldChoice : Choice() {
    override fun getNumAnswers(characterDto: CharacterDto): Int {
        return 3 + characterDto.abilityScores[AbilityScoreEnum.INT].calcModifier()
    }

    override fun callback(characterDto: CharacterDto): List<Choice?> {
        characterDto.clearSkillsModifiersGrantedBy(code!!)
        require(answers!!.size <= 1) { "Found multiple choices for the research field" }
        val answerStr = answers!!.stream().findFirst().orElseThrow()
        val alchemistResearchField: AlchemistResearchFieldEnum = AlchemistResearchFieldEnum.Companion.fromValue(answerStr)
        val description: String
        val choices: MutableList<String?> = ArrayList()
        val numAnswers: Int
        when (alchemistResearchField) {
            AlchemistResearchFieldEnum.BOMBER -> {
                description = "You specialize in explosions and other violent alchemical reactions. You start " +
                        "with the formulas for two 1st-level alchemical bombs in your formula book, in addition to " +
                        "your other formulas.\n" +
                        "When throwing an alchemical bomb with the splash trait, you can deal splash damage to only " +
                        "your primary target instead of the usual splash area."
                choices.addAll(Arrays.stream(InventoryItemEnum.Companion.values())
                        .filter(Predicate { item: ItemDto -> item.traits.contains("BOMB") })
                        .map(Function { obj: ItemDto -> obj.toString() })
                        .collect(Collectors.toList<String>())
                )
                numAnswers = 2
            }
            AlchemistResearchFieldEnum.CHIRURGEON -> {
                description = "You concentrate on healing others with alchemy. You start with the formulas for two " +
                        "of the following in your formula book, in addition to your other formulas: lesser antidote, " +
                        "lesser antiplague, or lesser elixir of life.\n" +
                        "As long as your proficiency rank in Medicine is trained or better, you can attempt a " +
                        "Crafting check instead of a Medicine check for any of Medicine's untrained and trained uses."
                choices.add(InventoryItemEnum.Companion.fromValue("ANTIDOTE_LESSER").getCode())
                choices.add(InventoryItemEnum.Companion.fromValue("ANTIPLAGUE_LESSER").getCode())
                choices.add(InventoryItemEnum.Companion.fromValue("ELIXIR_OF_LIFE_MINOR").getCode())
                numAnswers = 2
            }
            AlchemistResearchFieldEnum.MUTAGENIST -> {
                description = "You focus on bizarre mutagenic transformations that sacrifice one aspect of a " +
                        "creature's physical\n" +
                        "or psychological being in order to strengthen another. You start with the formulas for two " +
                        "1st-level mutagens in your formula book, in addition to your other formulas. You can gain the " +
                        "benefit of any mutagen, even if it wasn't specifically brewed for you.\n" +
                        "Whenever your proficiency rank for simple weapons increases, your proficiency rank for " +
                        "unarmed attacks increases to the same rank unless it's already better."
                choices.addAll(Arrays.stream(InventoryItemEnum.Companion.values())
                        .filter(Predicate { item: ItemDto -> item.traits.contains("MUTAGEN") })
                        .map(Function { obj: ItemDto -> obj.toString() })
                        .collect(Collectors.toList<String>())
                )
                numAnswers = 2
            }
            else -> throw IllegalArgumentException(String.format("Unknown alchemist research field: %s", alchemistResearchField))
        }
        return java.util.List.of(AlchemistFormulaeChoice("ResearchField", description, choices, numAnswers))
    }

    init {
        code = ResearchFieldChoice::class.java.name
        description = "Become Trained in a number of additional skills equal to 3 plus your Intelligence modifier"
        options = Arrays.stream(SkillEnum.values())
                .filter { skill: SkillEnum -> skill != SkillEnum.CRAFTING }
                .map { obj: SkillEnum -> obj.toString() }
                .collect(Collectors.toList())
    }
}