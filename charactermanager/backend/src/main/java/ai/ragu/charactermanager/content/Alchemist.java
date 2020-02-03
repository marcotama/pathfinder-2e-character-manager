package ai.ragu.charactermanager.content;

import ai.ragu.charactermanager.content.Alchemist.AlchemistResearchFieldEnum;
import ai.ragu.charactermanager.dto.CharacterDto;
import ai.ragu.charactermanager.dto.Choice;
import ai.ragu.charactermanager.dto.ClazzDto;
import ai.ragu.charactermanager.dto.ProficiencyModifierDto;
import ai.ragu.charactermanager.enumeration.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Alchemist extends ClazzDto {

    public enum AlchemistResearchFieldEnum {
        BOMBER("bomber"),
        CHIRURGEON("chirurgeon"),
        MUTAGENIST("mutagenist");

        private final String value;
        private final static Map<String, AlchemistResearchFieldEnum> CONSTANTS = new HashMap<>();

        static {
            for (AlchemistResearchFieldEnum c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        AlchemistResearchFieldEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static AlchemistResearchFieldEnum fromValue(String value) {
            AlchemistResearchFieldEnum constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }
    }

    public Alchemist() {
        this.keyAbilityScore = AbilityScoreEnum.INT;
        this.perception = ProficiencyLevelEnum.TRAINED;
        this.savingThrows = Map.ofEntries(
                Map.entry(SavingThrowEnum.FORTITUDE, ProficiencyLevelEnum.EXPERT),
                Map.entry(SavingThrowEnum.REFLEX, ProficiencyLevelEnum.EXPERT),
                Map.entry(SavingThrowEnum.WILL, ProficiencyLevelEnum.TRAINED)
        );
        this.skills = Map.ofEntries(
                Map.entry(SkillEnum.CRAFTING, ProficiencyLevelEnum.TRAINED)
        );
        this.attacks = Map.ofEntries(
                Map.entry(OtherAttackWeaponTypeEnum.SIMPLE_WEAPONS, ProficiencyLevelEnum.TRAINED),
                Map.entry(OtherAttackWeaponTypeEnum.ALCHEMICAL_BOMBS, ProficiencyLevelEnum.TRAINED),
                Map.entry(OtherAttackWeaponTypeEnum.UNARMED_ATTACKS, ProficiencyLevelEnum.TRAINED)
        );
        this.defenses = Map.ofEntries(
                Map.entry(DefenseProficiencyEnum.LIGHT_ARMOR, ProficiencyLevelEnum.TRAINED),
                Map.entry(DefenseProficiencyEnum.UNARMORED_DEFENSE, ProficiencyLevelEnum.TRAINED)
        );
    }

    public int calcHitPointsIncrease(CharacterDto character) {
        return 8 + character.getAbilityScores().get(AbilityScoreEnum.CON).calcModifier();
    }

    public List<Choice> getChoices(int level, CharacterDto character) {
        if (level == 1) {
            return List.of(
                    new TrainedSkillChoice(character),
                    Alchemist.getResearchFieldChoice(character)
            );
        } else {
            throw new UnsupportedOperationException(String.format("Level not supported in the alchemist class: %d", level));
        }
    }

    private class TrainedSkillChoice extends Choice {
        public TrainedSkillChoice(CharacterDto character) {
            this.code = TrainedSkillChoice.class.getName();
            this.numChoices = 3 + character.getAbilityScores().get(AbilityScoreEnum.INT).calcModifier();
            this.description = String.format("Become Trained in a number of additional skills equal to 3 plus your Intelligence modifier (total: %d)", numChoices);
            this.options = character.getSkills().keySet().stream()
                    .filter(skill -> skill != SkillEnum.CRAFTING)
                    .collect(Collectors.toList());
        }

        @Override
        public List<Choice> callback(CharacterDto characterDto, List<Object> choices) {
            characterDto.clearSkillsModifiersGrantedBy(code);
            for (Object obj : choices) {
                SkillEnum skillEnum = (SkillEnum)obj;
                ProficiencyModifierDto newModifier = new ProficiencyModifierDto(
                        code,
                        ProficiencyLevelEnum.TRAINED,
                        0
                );
                characterDto.getSkills().get(skillEnum).getProficiency().getModifiers().add(newModifier);
            }
            return List.of();
        }
    }

//    private Choice getResearchFieldChoice(CharacterDto character) {
//        let choice_identifier = 'alchemist-research-field';
//        let callback = (character, choices) => {
//            character.clearItemsGrantedBy(choice_identifier);
//            if (choices.length != 1) {
//                throw new Error(`Only one choice is possible, but {len(choices)} were chosen: {choices}`);
//            }
//            let choice = choices[0];
//            let newChoices = [];
//            switch (choice) {
//                case AlchemistResearchFieldEnum.BOMBER:
//                    newChoices.push(new Choice("You specialize in explosions and other violent alchemical reactions. You start with the formulas for two 1st-level alchemical bombs in your formula book, in addition to your other formulas.\n" +
//                            "When throwing an alchemical bomb with the splash trait, you can deal splash damage to only your primary target instead of the usual splash area.", Array.from(alchemicalItemsData.values()).filter(item => item["tags"].indexOf("BOMB") >= 0).map(item => item["code"]), 2, callback));
//                    break;
//                case AlchemistResearchFieldEnum.CHIRURGEON:
//                    newChoices.push(new Choice("You concentrate on healing others with alchemy. You start with the formulas for two of the following in your formula book, in addition to your other formulas: lesser antidote, lesser antiplague, or lesser elixir of life.\n" +
//                            "As long as your proficiency rank in Medicine is trained or better, you can attempt a Crafting check instead of a Medicine check for any of Medicine's untrained and trained uses.", [AlchemicalElixirEnum.ANTIDOTE_LESSER, AlchemicalElixirEnum.ANTIPLAGUE_LESSER, AlchemicalElixirEnum.ELIXIR_OF_LIFE_MINOR], 2, callback));
//                    break;
//                case AlchemistResearchFieldEnum.MUTAGENIST:
//                    newChoices.push(new Choice("You focus on bizarre mutagenic transformations\n" +
//                            "that sacrifice one aspect of a creature's physical\n" +
//                            "or psychological being in order to strengthen another. You start with the formulas for two 1st-level mutagens in your formula book, in addition to your other formulas. You can gain the benefit of any mutagen, even if it wasn't specifically brewed for you.\n" +
//                            "Whenever your proficiency rank for simple weapons increases, your proficiency rank for unarmed attacks increases to the same rank unless it's already better.", Array.from(alchemicalItemsData.values()).filter(item => item["tags"].indexOf("MUTAGEN") >= 0).map(item => item["code"]), 2, callback));
//            }
//            return newChoices;
//        };
//        return new Choice("Choose a field of research", Array.from(Object.values(AlchemistResearchFieldEnum)), 1, callback);
//    };

}
