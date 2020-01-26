import {
    AbilityScoreEnum,
    ProficiencyLevelEnum,
    SavingThrowEnum,
    DefenseProficiencyEnum,
    AttackProficiencyEnum,
    SkillEnum,
    AlchemicalItemCategoryEnum,
    OtherAttackProficiencyEnum,
    AlchemicalBombEnum,
    AlchemicalElixirEnum,
    AlchemicalPoisonEnum,
    AlchemicalToolEnum
} from "../enums"
import {
    Clazz,
    Character,
    Choice
} from "../structures"



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
                Alchemist.getTrainedSkillsChoice(character)
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
            if (choice == AlchemistResearchFieldEnum.BOMBER) {
                newChoices.push(new Choice(
                    "Choose two 1st-level alchemical bombs to add to your formula book",
                    Array.from(Object.values(AlchemicalBombEnum)),
                    1,
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
