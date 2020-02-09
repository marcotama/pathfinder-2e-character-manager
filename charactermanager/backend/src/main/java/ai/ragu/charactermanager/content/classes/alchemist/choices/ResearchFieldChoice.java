package ai.ragu.charactermanager.content.classes.alchemist.choices;

import ai.ragu.charactermanager.content.classes.alchemist.AlchemistResearchFieldEnum;
import ai.ragu.charactermanager.dto.CharacterDto;
import ai.ragu.charactermanager.dto.Choice;
import ai.ragu.charactermanager.dto.ItemDto;
import ai.ragu.charactermanager.enumeration.AbilityScoreEnum;
import ai.ragu.charactermanager.enumeration.InventoryItemEnum;
import ai.ragu.charactermanager.enumeration.SkillEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResearchFieldChoice extends Choice {
    public ResearchFieldChoice() {
        this.code = ResearchFieldChoice.class.getName();
        this.description = "Become Trained in a number of additional skills equal to 3 plus your Intelligence modifier";
        this.options = Arrays.stream(SkillEnum.values())
                .filter(skill -> skill != SkillEnum.CRAFTING)
                .map(SkillEnum::toString)
                .collect(Collectors.toList());
    }

    @Override
    public int getNumAnswers(CharacterDto characterDto) {
        return 3 + characterDto.getAbilityScores().get(AbilityScoreEnum.INT).calcModifier();
    }

    @Override
    public List<Choice> callback(CharacterDto characterDto) {
        characterDto.clearSkillsModifiersGrantedBy(code);
        if (answers.size() > 1) {
            throw new IllegalArgumentException("Found multiple choices for the research field");
        }
        String answerStr = answers.stream().findFirst().orElseThrow();
        AlchemistResearchFieldEnum alchemistResearchField = AlchemistResearchFieldEnum.fromValue(answerStr);
        String description;
        List<String> choices = new ArrayList<>();
        int numAnswers;
        switch (alchemistResearchField) {
            case BOMBER:
                description = "You specialize in explosions and other violent alchemical reactions. You start " +
                        "with the formulas for two 1st-level alchemical bombs in your formula book, in addition to " +
                        "your other formulas.\n" +
                        "When throwing an alchemical bomb with the splash trait, you can deal splash damage to only " +
                        "your primary target instead of the usual splash area.";
                choices.addAll(Arrays.stream(InventoryItemEnum.values())
                        .filter(item -> item.getTraits().contains("BOMB"))
                        .map(ItemDto::toString)
                        .collect(Collectors.toList())
                );
                numAnswers = 2;
                break;
            case CHIRURGEON:
                description = "You concentrate on healing others with alchemy. You start with the formulas for two " +
                        "of the following in your formula book, in addition to your other formulas: lesser antidote, " +
                        "lesser antiplague, or lesser elixir of life.\n" +
                        "As long as your proficiency rank in Medicine is trained or better, you can attempt a " +
                        "Crafting check instead of a Medicine check for any of Medicine's untrained and trained uses.";
                choices.add(InventoryItemEnum.fromValue("ANTIDOTE_LESSER").getCode());
                choices.add(InventoryItemEnum.fromValue("ANTIPLAGUE_LESSER").getCode());
                choices.add(InventoryItemEnum.fromValue("ELIXIR_OF_LIFE_MINOR").getCode());
                numAnswers = 2;
                break;
            case MUTAGENIST:
                description = "You focus on bizarre mutagenic transformations that sacrifice one aspect of a " +
                        "creature's physical\n" +
                        "or psychological being in order to strengthen another. You start with the formulas for two " +
                        "1st-level mutagens in your formula book, in addition to your other formulas. You can gain the " +
                        "benefit of any mutagen, even if it wasn't specifically brewed for you.\n" +
                        "Whenever your proficiency rank for simple weapons increases, your proficiency rank for " +
                        "unarmed attacks increases to the same rank unless it's already better.";
                choices.addAll(Arrays.stream(InventoryItemEnum.values())
                        .filter(item -> item.getTraits().contains("MUTAGEN"))
                        .map(ItemDto::toString)
                        .collect(Collectors.toList())
                );
                numAnswers = 2;
                break;
            default:
                throw new IllegalArgumentException(String.format("Unknown alchemist research field: %s", alchemistResearchField));
        }
        return List.of(new AlchemistFormulaeChoice("ResearchField", description, choices, numAnswers));
    }
}
