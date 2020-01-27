import {Component, Field, Hero, Thing} from "../base"

import {
    AbilityScoreEnum,
    ArmorGroup,
    ArmorTraitEnum,
    AttackProficiencyEnum,
    Currency,
    DamageType,
    DefenseProficiencyEnum,
    Die,
    getCurrencyValue,
    getProficiencyModifier,
    InventoryItemEnum,
    ItemCategory,
    MeleeWeaponGroupEnum,
    OtherAttackProficiencyEnum,
    PhysicalDamageType,
    ProficiencyLevelEnum,
    RangedWeaponGroupEnum,
    SavingThrowEnum,
    SkillEnum,
    WeaponTraitEnum
} from "./enums";


export class Amount {
    subAmounts: Map<Currency, number>;

    constructor(subAmounts: Map<Currency, number>) {
        this.subAmounts = subAmounts;
    }

    public getValueInCp = () => {
        let valueInCp = 0;
        for (let entry of this.subAmounts) {
            let [curr, am] = entry;
            valueInCp += am * getCurrencyValue(curr);
        }
        return valueInCp;
    };

    public getNormalised = () => {
        let v = this.getValueInCp();
        let amount = [];
        for (let curr of [Currency.CP, Currency.SP, Currency.GP, Currency.PP]) {
            let am = v; // curr.value
            if (am > 0) {
                amount.push([am, curr]);
            }
            v %= getCurrencyValue(curr);
        }
    }
}


class Armor extends Thing {
    category: ItemCategory;
    price: Amount;
    acBonus: number;
    dexCap: number;
    checkPenalty: number;
    speedPenalty: number;
    strength: number;
    bulk: number;
    group: ArmorGroup;
    traits: Array<ArmorTraitEnum>;
}

class Shield extends Thing {
    category: ItemCategory;
    price: Amount;
    acBonus: number;
    speedPenalty: number;
    bulk: number;
    hardness: number;
    hitPoints: number;
    brokenThreshold: number;
}

class Damage {
    amount: Map<Die, [number, PhysicalDamageType]>;
}


class Weapon extends Thing {
    category: ItemCategory;
    price: Amount;
    damage: Damage;
    bulk: number;
    hands: number;
    traits: Array<WeaponTraitEnum>;
}

class MeleeWeapon extends Weapon {
    group: MeleeWeaponGroupEnum
}


class RangedWeapon extends Weapon {
    range: number;
    reload: number;
    group: RangedWeaponGroupEnum;
}


class AbilityScore extends Component {
    baseValue: number | null;
    modifiers: Array<[string, number]>; // (reason, delta)

    constructor(code: string, name: string) {
        super(code, name);
        this.fields.set("score", new Field("score", "Score", null));
        this.baseValue = null;
    }

    public setValue = (newValue: number) => {
        if (newValue < 1 || newValue > 20) {
            throw new Error(`Value {newValue} is out of range [1, 20].`);
        }
        this.baseValue = newValue;
    };

    public getValue = () => {
        return Math.floor((this.baseValue - 10) / 2);
    };
}

class Proficiency extends Component {
    baseValue: ProficiencyLevelEnum | null;
    modifiers: Array<[string, string, ProficiencyLevelEnum, number]>; // (identifier, reason, value, priority (higher takes priority))

    private static getModifierValue(modifier: [string, string, ProficiencyLevelEnum, number]) {
        return modifier[0];
    }
    private static getModifierProficiencyLevel(modifier: [string, string, ProficiencyLevelEnum, number]) {
        return modifier[3];
    }
    private static getModifierPriority(modifier: [string, string, ProficiencyLevelEnum, number]) {
        return modifier[3];
    }

    constructor(code: string, name: string) {
        super(code, name);
        this.fields.set("proficiency", new Field("proficiency", "Proficiency", null));
        this.baseValue = null;
    }

    public setValue = (newValue: ProficiencyLevelEnum) => {
        this.baseValue = newValue;
    };

    public getValue = () => {
        if (this.modifiers.length == 0) {
            return this.baseValue;
        } else {
            let maxPriority = Math.max(...this.modifiers
                .map(Proficiency.getModifierPriority)
            );
            return Math.max(...this.modifiers
                .filter((modifier) => Proficiency.getModifierPriority(modifier) == maxPriority)
                .map(Proficiency.getModifierProficiencyLevel)
            );
        }
    };

    public getModifier = () => {
        return this.baseValue == null ? 0 : getProficiencyModifier(this.baseValue);
    }
}

class ProficiencyBasedRoll extends Component {
    proficiency: Proficiency;
    refAbilityScore: AbilityScoreEnum;
    character: Character;

    constructor(code: string, name: string, refAbilityScore: AbilityScoreEnum, character: Character) {
        super(code, name);
        this.refAbilityScore = refAbilityScore;
        this.character = character;
        this.proficiency = new Proficiency("proficiency", "Proficiency");
    }

    public getItemModifier = () => {
        return 0; // TODO
    };

    public getAttributeModifier = () => {
        return this.character.abilityScores.get(this.refAbilityScore).getValue();
    };

    public getValue = () => {
        return this.proficiency.getModifier() + this.getAttributeModifier() + this.getItemModifier();
    };
}

class SavingThrow extends ProficiencyBasedRoll {}


class Perception extends ProficiencyBasedRoll {}


class ProficiencyAndKeyAttributeBasedRoll extends Component {
    proficiency: Proficiency;
    character: Character;

    constructor(code: string, name: string, character: Character) {
        super(code, name);
        this.character = character;
        this.proficiency = new Proficiency("proficiency", "Proficiency");
    }

    public getItemModifier = () => {
        return 0; // TODO
    };

    public getAttributeModifier = () => {
        let keyAbilityScore = this.character.clazz.keyAbilityScore;
        return this.character.abilityScores.get(keyAbilityScore).getValue();
    };

    public getValue = () => {
        return this.proficiency.getModifier() + this.getAttributeModifier() + this.getItemModifier();
    };
}

class ClassDC extends ProficiencyAndKeyAttributeBasedRoll {}


class SpellAttackRoll extends ProficiencyAndKeyAttributeBasedRoll {}


class SpellDC extends ProficiencyAndKeyAttributeBasedRoll {}


class Skill extends ProficiencyBasedRoll {
    public getArmorModifier = () => {
        if (this.refAbilityScore in [AbilityScoreEnum.DEX, AbilityScoreEnum.STR]) {
            if (this.character.abilityScores.get(AbilityScoreEnum.STR).baseValue >= this.character.armor.strength) {
                return 0;
            } else {
                return -this.character.armor.checkPenalty;
            }
        } else {
            return 0;
        }
    };

    public getValue = () => {
        return super.getValue() + this.getArmorModifier()
    }
}

export abstract class Clazz extends Thing {
    keyAbilityScore: AbilityScoreEnum;
    hitPoints: number;
    initialProficiencies: Map<string, ProficiencyLevelEnum>; // FIXME string?
    perception: ProficiencyLevelEnum;
    savingThrows: Map<SavingThrowEnum, ProficiencyLevelEnum>;
    skills: Map<SkillEnum, ProficiencyLevelEnum>;
    attacks: Map<AttackProficiencyEnum, ProficiencyLevelEnum>;
    defenses: Map<DefenseProficiencyEnum, ProficiencyLevelEnum>;

    public abstract calcHitPointsIncrease = (character: Character) => {};
}



export class Character extends Hero {
    clazz: Clazz;
    armor: Armor;
    shields: Array<Shield>;
    weapons: Array<Weapon>;
    abilityScores: Map<AbilityScoreEnum, AbilityScore>;
    skills: Map<SkillEnum, Skill>;
    savingThrows: Map<SavingThrowEnum, SavingThrow>;
    perception: Perception;
    classDC: ClassDC;
    spellAttackRoll: SpellAttackRoll;
    spellDC: SpellDC;
    equipment: Array<Armor | Shield | Weapon>;
    maxHitPoints: number;
    currentHitPoints: number;
    temporaryHitPoints: number;
    speed: number;
    resistances: Array<DamageType>;
    immunities: Array<DamageType>;
    conditions: Array<DamageType>;
    attackProficiencies: Map<AttackProficiencyEnum, Proficiency>;
    defenseProficiencies: Map<DefenseProficiencyEnum, Proficiency>;
    inventory: Map<InventoryItemEnum, [string, string] | null>; // why each item is present (identifier, description)

    constructor(code: string, name: string) {
        super(code, name);
        this.armor = null;
        this.shields = [];
        this.weapons = [];
        this.maxHitPoints = 0;
        this.currentHitPoints = 0;
        this.temporaryHitPoints = 0;
        this.speed = 0;
        this.resistances = [];
        this.immunities = [];
        this.conditions = [];
        this.perception = new Perception("perception", "Perception", AbilityScoreEnum.WIS, this);
        this.classDC = new ClassDC(code = "class-dc", name = "Class DC", this);
        this.spellAttackRoll = new SpellAttackRoll("spell-attack-roll", "Spell Attack Roll", this);
        this.spellDC = new SpellDC("spell-dc", "Spell DC", this);

        this.abilityScores.set(AbilityScoreEnum.STR, new AbilityScore(AbilityScoreEnum.STR, "Strength"));
        this.abilityScores.set(AbilityScoreEnum.DEX, new AbilityScore(AbilityScoreEnum.DEX, "Dexterity"));
        this.abilityScores.set(AbilityScoreEnum.CON, new AbilityScore(AbilityScoreEnum.CON, "Constitution"));
        this.abilityScores.set(AbilityScoreEnum.INT, new AbilityScore(AbilityScoreEnum.INT, "Intelligence"));
        this.abilityScores.set(AbilityScoreEnum.WIS, new AbilityScore(AbilityScoreEnum.WIS, "Wisdom"));
        this.abilityScores.set(AbilityScoreEnum.CHA, new AbilityScore(AbilityScoreEnum.CHA, "Charisma"));


        this.skills.set(SkillEnum.ACROBATICS, new Skill(SkillEnum.ACROBATICS, "Acrobatics", AbilityScoreEnum.DEX, this));
        this.skills.set(SkillEnum.ARCANA, new Skill(SkillEnum.ARCANA, "Arcana", AbilityScoreEnum.INT, this));
        this.skills.set(SkillEnum.ATHLETICS, new Skill(SkillEnum.ATHLETICS, "Athletics", AbilityScoreEnum.INT, this));
        this.skills.set(SkillEnum.CRAFTING, new Skill(SkillEnum.CRAFTING, "Crafting", AbilityScoreEnum.INT, this));
        this.skills.set(SkillEnum.DECEPTION, new Skill(SkillEnum.DECEPTION, "Deception", AbilityScoreEnum.CHA, this));
        this.skills.set(SkillEnum.DIPLOMACY, new Skill(SkillEnum.DIPLOMACY, "Diplomacy", AbilityScoreEnum.CHA, this));
        this.skills.set(SkillEnum.INTIMIDATION, new Skill(SkillEnum.INTIMIDATION, "Intimidation", AbilityScoreEnum.CHA, this));
        this.skills.set(SkillEnum.MEDICINE, new Skill(SkillEnum.MEDICINE, "Medicine", AbilityScoreEnum.WIS, this));
        this.skills.set(SkillEnum.NATURE, new Skill(SkillEnum.NATURE, "Nature", AbilityScoreEnum.WIS, this));
        this.skills.set(SkillEnum.OCCULTISM, new Skill(SkillEnum.OCCULTISM, "Occultism", AbilityScoreEnum.INT, this));
        this.skills.set(SkillEnum.PERFORMANCE, new Skill(SkillEnum.PERFORMANCE, "Performance", AbilityScoreEnum.CHA, this));
        this.skills.set(SkillEnum.RELIGION, new Skill(SkillEnum.RELIGION, "Religion", AbilityScoreEnum.WIS, this));
        this.skills.set(SkillEnum.SOCIETY, new Skill(SkillEnum.SOCIETY, "Society", AbilityScoreEnum.INT, this));
        this.skills.set(SkillEnum.STEALTH, new Skill(SkillEnum.STEALTH, "Stealth", AbilityScoreEnum.DEX, this));
        this.skills.set(SkillEnum.SURVIVAL, new Skill(SkillEnum.SURVIVAL, "Survival", AbilityScoreEnum.WIS, this));
        this.skills.set(SkillEnum.THIEVERY, new Skill(SkillEnum.THIEVERY, "Thievery", AbilityScoreEnum.DEX, this));

        this.savingThrows.set(SavingThrowEnum.FORTITUDE, new SavingThrow(SavingThrowEnum.FORTITUDE, "Fortitude", AbilityScoreEnum.CON, this));
        this.savingThrows.set(SavingThrowEnum.REFLEX, new SavingThrow(SavingThrowEnum.REFLEX, "Reflex", AbilityScoreEnum.DEX, this));
        this.savingThrows.set(SavingThrowEnum.WILL, new SavingThrow(SavingThrowEnum.WILL, "Will", AbilityScoreEnum.WIS, this));

        this.attackProficiencies.set(OtherAttackProficiencyEnum.UNARMED_ATTACKS, new Proficiency(OtherAttackProficiencyEnum.UNARMED_ATTACKS, "Unarmed Attacks"));
        this.attackProficiencies.set(OtherAttackProficiencyEnum.SIMPLE_WEAPONS, new Proficiency(OtherAttackProficiencyEnum.SIMPLE_WEAPONS, "Simple Weapons"));
        this.attackProficiencies.set(OtherAttackProficiencyEnum.MARTIAL_WEAPONS, new Proficiency(OtherAttackProficiencyEnum.MARTIAL_WEAPONS, "Martial Weapons"));
        this.attackProficiencies.set(OtherAttackProficiencyEnum.ALCHEMICAL_BOMBS, new Proficiency(OtherAttackProficiencyEnum.ALCHEMICAL_BOMBS, "Alchemical Bombs"));

        this.attackProficiencies.set(MeleeWeaponGroupEnum.SWORD, new Proficiency(MeleeWeaponGroupEnum.SWORD, "Sword"));
        this.attackProficiencies.set(MeleeWeaponGroupEnum.SPEAR, new Proficiency(MeleeWeaponGroupEnum.SPEAR, "Spear"));
        this.attackProficiencies.set(MeleeWeaponGroupEnum.HAMMER, new Proficiency(MeleeWeaponGroupEnum.HAMMER, "Hammer"));
        this.attackProficiencies.set(MeleeWeaponGroupEnum.POLEARM, new Proficiency(MeleeWeaponGroupEnum.POLEARM, "Polearm"));
        this.attackProficiencies.set(MeleeWeaponGroupEnum.KNIFE, new Proficiency(MeleeWeaponGroupEnum.KNIFE, "Knife"));
        this.attackProficiencies.set(MeleeWeaponGroupEnum.CLUB, new Proficiency(MeleeWeaponGroupEnum.CLUB, "Club"));
        this.attackProficiencies.set(MeleeWeaponGroupEnum.FLAIL, new Proficiency(MeleeWeaponGroupEnum.FLAIL, "Flail"));
        this.attackProficiencies.set(MeleeWeaponGroupEnum.BRAWLING, new Proficiency(MeleeWeaponGroupEnum.BRAWLING, "Brawling"));
        this.attackProficiencies.set(MeleeWeaponGroupEnum.AXE, new Proficiency(MeleeWeaponGroupEnum.AXE, "Axe"));
        this.attackProficiencies.set(MeleeWeaponGroupEnum.PICK, new Proficiency(MeleeWeaponGroupEnum.PICK, "Pick"));
        this.attackProficiencies.set(MeleeWeaponGroupEnum.SHIELD, new Proficiency(MeleeWeaponGroupEnum.SHIELD, "Shield"));
        this.attackProficiencies.set(MeleeWeaponGroupEnum.WHIP, new Proficiency(MeleeWeaponGroupEnum.WHIP, "Whip"));

        this.attackProficiencies.set(RangedWeaponGroupEnum.DART, new Proficiency(RangedWeaponGroupEnum.DART, "Dart"));
        this.attackProficiencies.set(RangedWeaponGroupEnum.BOW, new Proficiency(RangedWeaponGroupEnum.BOW, "Bow"));

        this.defenseProficiencies.set(DefenseProficiencyEnum.UNARMORED_DEFENSE, new Proficiency(DefenseProficiencyEnum.UNARMORED_DEFENSE, "Unarmored Defense"));
        this.defenseProficiencies.set(DefenseProficiencyEnum.LIGHT_ARMOR, new Proficiency(DefenseProficiencyEnum.LIGHT_ARMOR, "Light Armor"));
        this.defenseProficiencies.set(DefenseProficiencyEnum.MEDIUM_ARMOR, new Proficiency(DefenseProficiencyEnum.MEDIUM_ARMOR, "Medium Armor"));
        this.defenseProficiencies.set(DefenseProficiencyEnum.HEAVY_ARMOR, new Proficiency(DefenseProficiencyEnum.HEAVY_ARMOR, "Heavy Armor"));

        this.components = new Map<string, Component>([
            ...Array.from(this.abilityScores.entries()),
            ...Array.from(this.skills.entries()),
            ...Array.from(this.savingThrows.entries()),
            ...Array.from(this.attackProficiencies.entries()),
            ...Array.from(this.defenseProficiencies.entries())
        ]);
    }

    public getAllSheetFields = () => {
        let out = new Map<string, any>();
        for (let abilityScoreEnum of this.abilityScores.keys()) {
            let abilityScore: AbilityScore = this.abilityScores.get(abilityScoreEnum);
            out.set(`{abilityScore}-modifier`, abilityScore.getValue());
            out.set(`{abilityScore}-score`, abilityScore.baseValue);
        }

        for (let skillEnum of this.skills.keys()) {
            let skill: Skill = this.skills.get(skillEnum);
            out.set(`{skill}-value`, skill.getValue());
            out.set(`{skill}-attribute-modifier`, skill.getAttributeModifier());
            out.set(`{skill}-proficiency`, skill.proficiency.baseValue);
            out.set(`{skill}-proficiency-modifier`, skill.proficiency.getModifier());
            out.set(`{skill}-item-modifier`, skill.getItemModifier());
            if (skill.refAbilityScore in [AbilityScoreEnum.DEX, AbilityScoreEnum.STR]) {
                out.set(`{skill}-armor-modifier`, skill.getArmorModifier());
            }
        }

        for (let savingThrowEnum of this.savingThrows.keys()) {
            let savingThrow: SavingThrow = this.savingThrows.get(savingThrowEnum);
            out.set(`{savingThrow}-value`, savingThrow.getValue());
            out.set(`{savingThrow}-attribute-modifier`, savingThrow.getAttributeModifier());
            out.set(`{savingThrow}-proficiency`, savingThrow.proficiency.baseValue);
            out.set(`{savingThrow}-proficiency-modifier`, savingThrow.proficiency.getModifier());
            out.set(`{savingThrow}-item-modifier`, savingThrow.getItemModifier());
        }

        for (let defenseProficiencyEnum of this.defenseProficiencies.keys()) {
            let defenseProficiency: Proficiency = this.defenseProficiencies.get(defenseProficiencyEnum);
            out.set(`{defenseProficiency}-proficiency`, defenseProficiency.baseValue);
        }

        for (let attackProficiencyEnum of this.attackProficiencies.keys()) {
            let attackProficiency: Proficiency = this.attackProficiencies.get(attackProficiencyEnum);
            out.set(`{attackProficiency}-proficiency`, attackProficiency.baseValue);
        }

        out.set("perception-value", this.perception.getValue());
        out.set("perception-attribute-modifier", this.perception.getAttributeModifier());
        out.set("perception-proficiency", this.perception.proficiency.baseValue);
        out.set("perception-proficiency-modifier", this.perception.proficiency.getModifier());
        out.set("perception-item-modifier", this.perception.getItemModifier());

        out.set("class-dc-value", this.classDC.getValue());
        out.set("class-dc-attribute-modifier", this.classDC.getAttributeModifier());
        out.set("class-dc-proficiency", this.classDC.proficiency.baseValue);
        out.set("class-dc-proficiency-modifier", this.classDC.proficiency.getModifier());
        out.set("class-dc-item-modifier", this.classDC.getItemModifier());

        out.set("spell-attack-roll-value", this.spellAttackRoll.getValue());
        out.set("spell-attack-roll-attribute-modifier", this.spellAttackRoll.getAttributeModifier());
        out.set("spell-attack-roll-proficiency", this.spellAttackRoll.proficiency.baseValue);
        out.set("spell-attack-roll-proficiency-modifier", this.spellAttackRoll.proficiency.getModifier());
        out.set("spell-attack-roll-item-modifier", this.spellAttackRoll.getItemModifier());

        out.set("spell-dc-value", this.spellDC.getValue());
        out.set("spell-dc-attribute-modifier", this.spellDC.getAttributeModifier());
        out.set("spell-dc-proficiency", this.spellDC.proficiency.baseValue);
        out.set("spell-dc-proficiency-modifier", this.spellDC.proficiency.getModifier());
        out.set("spell-dc-item-modifier", this.spellDC.getItemModifier());

    };

    public clearItemsGrantedBy = (identifier: string) => {
        for (let [key, [item, grantedBy]] of this.inventory.entries()) {
            if (grantedBy == identifier) {
                this.inventory.delete(key);
            }
        }
    };

    public clearSkillsModifiersGrantedBy = (identifier: string) => {
        for (let skill of this.skills.values()) {
            skill.proficiency.modifiers = skill.proficiency.modifiers
                .filter(([grantedBy, reason, value, priority]) => grantedBy != identifier);
        }
    };
}

export class Choice {
    description: string;
    options: Array<string>;
    numChoices: number;
    callback: (...args: any[]) => any;

    constructor(description: string, options: Array<string>, numChoices: number, callback: (...args: any[]) => any) {
        this.description = description;
        this.options = options;
        this.numChoices = numChoices;
        this.callback = callback;
    }
}