import {
    AbilityScoreEnum,
    AlchemicalBombEnum,
    AlchemicalElixirEnum,
    AttackProficiencyEnum,
    DefenseProficiencyEnum,
    OtherAttackProficiencyEnum,
    ProficiencyLevelEnum,
    SavingThrowEnum,
    SkillEnum
} from "../enums"
import {Character, Choice, Clazz} from "../structures"
import {alchemicalItemsData} from "../data"


enum AlchemistResearchFieldEnum {
    BOMBER = 'bomber',
    CHIRURGEON = 'chirurgeon',
    MUTAGENIST = 'mutagenist',
}


class Alchemist extends Clazz {
    constructor(code: string, name: string) {
        super(code, name);
        this.keyAbilityScore = AbilityScoreEnum.INT;
        this.initialProficiencies = new Map<string, ProficiencyLevelEnum>();
        this.perception = ProficiencyLevelEnum.TRAINED;
        this.savingThrows = new Map<SavingThrowEnum, ProficiencyLevelEnum>([
            [SavingThrowEnum.FORTITUDE, ProficiencyLevelEnum.EXPERT],
            [SavingThrowEnum.REFLEX, ProficiencyLevelEnum.EXPERT],
            [SavingThrowEnum.WILL, ProficiencyLevelEnum.TRAINED],
        ]);
        this.skills = new Map<SkillEnum, ProficiencyLevelEnum>([
            [SkillEnum.CRAFTING, ProficiencyLevelEnum.TRAINED],
        ]);
        this.attacks = new Map<AttackProficiencyEnum, ProficiencyLevelEnum>([
            [OtherAttackProficiencyEnum.SIMPLE_WEAPONS, ProficiencyLevelEnum.TRAINED],
            [OtherAttackProficiencyEnum.ALCHEMICAL_BOMBS, ProficiencyLevelEnum.TRAINED],
            [OtherAttackProficiencyEnum.UNARMED_ATTACKS, ProficiencyLevelEnum.TRAINED],
        ]);
        this.defenses = new Map<DefenseProficiencyEnum, ProficiencyLevelEnum>([
            [DefenseProficiencyEnum.LIGHT_ARMOR, ProficiencyLevelEnum.TRAINED],
            [DefenseProficiencyEnum.UNARMORED_DEFENSE, ProficiencyLevelEnum.TRAINED],
        ]);
    }



    public calcHitPointsIncrease = (character: Character) => {
        return 8 + character.abilityScores.get(AbilityScoreEnum.CON).getValue();
    };


    public getChoices = (level: number, character: Character) => {
        if (level == 1)
            return [
                Alchemist.getTrainedSkillsChoice(character),
                Alchemist.getResearchFieldChoice(character),
            ];
    };

    public static getTrainedSkillsChoice = (character: Character): Choice => {
        let choiceIdentifier = 'alchemist-initial-proficiencies';
        let callback = (character: Character, choices: Array<SkillEnum>): Array<Choice> => {
            character.clearSkillsModifiersGrantedBy(choiceIdentifier);
            for (let choice of choices) {
                let newModifier: [string, string, ProficiencyLevelEnum, number] = [choiceIdentifier, "Alchemist class initial proficiencies", ProficiencyLevelEnum.TRAINED, 0];
                character.skills.get(choice).proficiency.modifiers.push(newModifier);
            }
            return [];
        };

        let total = 3 + character.abilityScores.get(AbilityScoreEnum.INT).getValue();
        return new Choice(
            `Become Trained in a number of additional skills equal to 3 plus your Intelligence modifier (total: {total})`,
            Array.from(character.skills.keys()).filter(skill => skill != SkillEnum.CRAFTING),
            3 + character.abilityScores.get(AbilityScoreEnum.INT).getValue(),
            callback
        );
    };


    public static getResearchFieldChoice = (character: Character): Choice => {
        let choice_identifier = 'alchemist-research-field';
        let callback = (character: Character, choices: Array<AlchemistResearchFieldEnum>): Array<Choice> => {
            character.clearItemsGrantedBy(choice_identifier);
            if (choices.length != 1) {
                throw new Error(`Only one choice is possible, but {len(choices)} were chosen: {choices}`);
            }
            let choice = choices[0];
            let newChoices = [];
            switch (choice) {
                case AlchemistResearchFieldEnum.BOMBER:
                    newChoices.push(new Choice(
                        "You specialize in explosions and other violent alchemical reactions. You start with the formulas for two 1st-level alchemical bombs in your formula book, in addition to your other formulas.\n" +
                        "When throwing an alchemical bomb with the splash trait, you can deal splash damage to only your primary target instead of the usual splash area.",
                        Array.from(alchemicalItemsData.values()).filter(item => item["tags"].indexOf("BOMB") >= 0).map(item => item["code"]),
                        2,
                        callback
                    ));
                    break;
                case AlchemistResearchFieldEnum.CHIRURGEON:
                    newChoices.push(new Choice(
                        "You concentrate on healing others with alchemy. You start with the formulas for two of the following in your formula book, in addition to your other formulas: lesser antidote, lesser antiplague, or lesser elixir of life.\n" +
                        "As long as your proficiency rank in Medicine is trained or better, you can attempt a Crafting check instead of a Medicine check for any of Medicine's untrained and trained uses.",
                        [AlchemicalElixirEnum.ANTIDOTE_LESSER, AlchemicalElixirEnum.ANTIPLAGUE_LESSER, AlchemicalElixirEnum.ELIXIR_OF_LIFE_MINOR],
                        2,
                        callback
                    ));
                    break;
                case AlchemistResearchFieldEnum.MUTAGENIST:
                    newChoices.push(new Choice(
                        "You focus on bizarre mutagenic transformations\n" +
                        "that sacrifice one aspect of a creature's physical\n" +
                        "or psychological being in order to strengthen another. You start with the formulas for two 1st-level mutagens in your formula book, in addition to your other formulas. You can gain the benefit of any mutagen, even if it wasn't specifically brewed for you.\n" +
                        "Whenever your proficiency rank for simple weapons increases, your proficiency rank for unarmed attacks increases to the same rank unless it's already better.",
                        Array.from(alchemicalItemsData.values()).filter(item => item["tags"].indexOf("MUTAGEN") >= 0).map(item => item["code"]),
                        2,
                        callback
                    ));
            }
            return newChoices;
        };

        return new Choice(
            "Choose a field of research",
            Array.from(Object.values(AlchemistResearchFieldEnum)),
            1,
            callback
        );
    };
}
