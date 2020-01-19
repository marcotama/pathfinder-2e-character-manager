import {Thing} from "../base"
import {
    SkillEnum,
    SavingThrowEnum,
    ItemCategory,
    ArmorGroup,
    Die,
    PhysicalDamageType,
    DamageType,
    Currency,
    ProficiencyLevelEnum,
    ArmorTraitEnum,
    MeleeWeaponGroupEnum,
    RangedWeaponGroupEnum,
    WeaponTraitEnum,
    DefenseProficiencyEnum,
    AttackProficiencyEnum,
    AbilityScoreEnum,
    InventoryItem,
    getProficiencyModifier,
    OtherAttackProficiencyEnum
} from "./enums";



class Amount {
    readonly valueIn_cp: number;

    constructor(amount: Array<[number, Currency]>) {
        this.valueIn_cp = 0;
        for (let entry of amount) {
            let [am, curr] = entry;
            this.valueIn_cp += am * curr;
        }
    }

    public get_normalised = () => {
        let v = this.valueIn_cp;
        let amount = [];
        for (let curr of Object.keys(Currency).reverse()) {
            let am = v; // curr.value
            if (am > 0) {
                amount.push([am, curr]);
            }
            v %= Currency[curr];
        }
    }
}


class Armor extends Thing {
    category: ItemCategory;
    price: Amount;
    ac_bonus: number;
    dex_cap: number;
    check_penalty: number;
    speed_penalty: number;
    strength: number;
    bulk: number;
    group: ArmorGroup;
    traits: Array<ArmorTraitEnum>;
}

class Shield extends Thing {
    category: ItemCategory;
    price: Amount;
    ac_bonus: number;
    speed_penalty: number;
    bulk: number;
    hardness: number;
    hit_points: number;
    broken_threshold: number;
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
        return this.character.abilityScores[this.refAbilityScore].getValue();
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
        return this.character.abilityScores[keyAbilityScore].getValue();
    };

    public get_value = () => {
        return this.proficiency.getModifier() + this.getAttributeModifier() + this.getItemModifier();
    };
}

class ClassDC extends ProficiencyAndKeyAttributeBasedRoll {}


class SpellAttackRoll extends ProficiencyAndKeyAttributeBasedRoll {}


class SpellDC extends ProficiencyAndKeyAttributeBasedRoll {}


class Skill extends ProficiencyBasedRoll {
    public getArmorModifier = () => {
        if (this.refAbilityScore.code in [AbilityScoreEnum.DEX, AbilityScoreEnum.STR]) {
            if (this.character.abilityScores[AbilityScoreEnum.string].baseValue >= this.character.armor.strength) {
                return 0;
            } else {
                return -this.character.armor.check_penalty;
            }
        } else {
            return 0;
        }
    };

    public getValue = () => {
        return super.getValue() + this.getArmorModifier()
    }
}

class Clazz {
    keyAbilityScore: AbilityScoreEnum;
    hit_points: number;
    initial_proficiencies: Map<string, ProficiencyLevelEnum>; // FIXME string?
    perception: ProficiencyLevelEnum;
    saving_throws: Map<SavingThrowEnum, ProficiencyLevelEnum>;
    skills: Map<SkillEnum, ProficiencyLevelEnum>;
    attacks: Map<AttackProficiencyEnum, ProficiencyLevelEnum>;
    defenses: Map<DefenseProficiencyEnum, ProficiencyLevelEnum>;

    public abstract calc_hit_pointsIncrease = (character: Character) => {};
}



class Character extends Hero {
    clazz: Clazz;
    armor: Armor;
    shields: Array<Shield>;
    weapons: Array<Weapon>;
    abilityScores: Map<AbilityScoreEnum, AbilityScore>;
    skills: Map<SkillEnum, Skill>;
    saving_throws: Map<SavingThrowEnum, SavingThrow>;
    perception: Perception;
    class_dc: ClassDC;
    spellAttack_roll: SpellAttackRoll;
    spell_dc: SpellDC;
    equipment: Array<Armor | Shield | Weapon>;
    max_hit_points: number;
    current_hit_points: number;
    temporary_hit_points: number;
    speed :number;
    resistances: Array<DamageType>;
    immunities: Array<DamageType>;
    conditions: Array<DamageType>;
    attack_proficiencies: Map<AttackProficiencyEnum, Proficiency>;
    defense_proficiencies: Map<DefenseProficiencyEnum, Proficiency>;
    inventory: Map<InventoryItem, [string, string] | null>; // why each item is present (identifier, description)
    
    constructor(code: string, name: string) {
        super(code, name);
        this.armor = null;
        this.shields = [];
        this.weapons = [];
        this.max_hit_points = 0;
        this.current_hit_points = 0;
        this.temporary_hit_points = 0;
        this.speed = 0;
        this.resistances = [];
        this.immunities = [];
        this.conditions = [];
        this.perception = new Perception("perception", "Perception", AbilityScoreEnum.WIS, this);
        this.class_dc = new ClassDC(code = "class-dc", name = "Class DC", this);
        this.spellAttack_roll = new SpellAttackRoll("spell-attack-roll", "Spell Attack Roll", this);
        this.spell_dc = new SpellDC("spell-dc", "Spell DC", this);

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

        this.saving_throws.set(SavingThrowEnum.FORTITUDE, new SavingThrow(SavingThrowEnum.FORTITUDE, "Fortitude", AbilityScoreEnum.CON, this));
        this.saving_throws.set(SavingThrowEnum.REFLEX, new SavingThrow(SavingThrowEnum.REFLEX, "Reflex", AbilityScoreEnum.DEX, this));
        this.saving_throws.set(SavingThrowEnum.WILL, new SavingThrow(SavingThrowEnum.WILL, "Will", AbilityScoreEnum.WIS, this));

        this.attack_proficiencies.set(OtherAttackProficiencyEnum.UNARMED_ATTACKS, new Proficiency(OtherAttackProficiencyEnum.UNARMED_ATTACKS, "Unarmed Attacks"));
        this.attack_proficiencies.set(OtherAttackProficiencyEnum.SIMPLE_WEAPONS, new Proficiency(OtherAttackProficiencyEnum.SIMPLE_WEAPONS, "Simple Weapons"));
        this.attack_proficiencies.set(OtherAttackProficiencyEnum.MARTIAL_WEAPONS, new Proficiency(OtherAttackProficiencyEnum.MARTIAL_WEAPONS, "Martial Weapons"));
        this.attack_proficiencies.set(OtherAttackProficiencyEnum.ALCHEMICAL_BOMBS, new Proficiency(OtherAttackProficiencyEnum.ALCHEMICAL_BOMBS, "Alchemical Bombs"));

        this.attack_proficiencies.set(MeleeWeaponGroupEnum.SWORD, new Proficiency(MeleeWeaponGroupEnum.SWORD, "Sword"));
        this.attack_proficiencies.set(MeleeWeaponGroupEnum.SPEAR, new Proficiency(MeleeWeaponGroupEnum.SPEAR, "Spear"));
        this.attack_proficiencies.set(MeleeWeaponGroupEnum.HAMMER, new Proficiency(MeleeWeaponGroupEnum.HAMMER, "Hammer"));
        this.attack_proficiencies.set(MeleeWeaponGroupEnum.POLEARM, new Proficiency(MeleeWeaponGroupEnum.POLEARM, "Polearm"));
        this.attack_proficiencies.set(MeleeWeaponGroupEnum.KNIFE, new Proficiency(MeleeWeaponGroupEnum.KNIFE, "Knife"));
        this.attack_proficiencies.set(MeleeWeaponGroupEnum.CLUB, new Proficiency(MeleeWeaponGroupEnum.CLUB, "Club"));
        this.attack_proficiencies.set(MeleeWeaponGroupEnum.FLAIL, new Proficiency(MeleeWeaponGroupEnum.FLAIL, "Flail"));
        this.attack_proficiencies.set(MeleeWeaponGroupEnum.BRAWLING, new Proficiency(MeleeWeaponGroupEnum.BRAWLING, "Brawling"));
        this.attack_proficiencies.set(MeleeWeaponGroupEnum.AXE, new Proficiency(MeleeWeaponGroupEnum.AXE, "Axe"));
        this.attack_proficiencies.set(MeleeWeaponGroupEnum.PICK, new Proficiency(MeleeWeaponGroupEnum.PICK, "Pick"));
        this.attack_proficiencies.set(MeleeWeaponGroupEnum.SHIELD, new Proficiency(MeleeWeaponGroupEnum.SHIELD, "Shield"));
        this.attack_proficiencies.set(MeleeWeaponGroupEnum.WHIP, new Proficiency(MeleeWeaponGroupEnum.WHIP, "Whip"));

        this.attack_proficiencies.set(RangedWeaponGroupEnum.DART, new Proficiency(RangedWeaponGroupEnum.DART, "Dart"));
        this.attack_proficiencies.set(RangedWeaponGroupEnum.BOW, new Proficiency(RangedWeaponGroupEnum.BOW, "Bow"));

        this.defense_proficiencies.set(DefenseProficiencyEnum.UNARMORED_DEFENSE, new Proficiency(DefenseProficiencyEnum.UNARMORED_DEFENSE, "Unarmored Defense"));
        this.defense_proficiencies.set(DefenseProficiencyEnum.LIGHT_ARMOR, new Proficiency(DefenseProficiencyEnum.LIGHT_ARMOR, "Light Armor"));
        this.defense_proficiencies.set(DefenseProficiencyEnum.MEDIUM_ARMOR, new Proficiency(DefenseProficiencyEnum.MEDIUM_ARMOR, "Medium Armor"));
        this.defense_proficiencies.set(DefenseProficiencyEnum.HEAVY_ARMOR, new Proficiency(DefenseProficiencyEnum.HEAVY_ARMOR, "Heavy Armor"));

        this.components = new Map<string, Component>([
            ...Array.from(this.abilityScores.entries()),
            ...Array.from(this.skills.entries()),
            ...Array.from(this.saving_throws.entries()),
            ...Array.from(this.attack_proficiencies.entries()),
            ...Array.from(this.defense_proficiencies.entries())
        ]);
    }


    public getAllSheetFields = () => {
        return new Map<string, any>([
            ...Array.from([...this.abilityScores.keys()].map((abilityScore) => [`{abilityScore}-modifier`, this.abilityScores.get(abilityScore)]),
            ...Array.from(this.abilityScores.keys().map(abilityScore => [`{abilityScore}-modifier`, this.abilityScores.get(abilityScore)])
            **{f"{abilityScore}-score": this.abilityScores[abilityScore].baseValue for abilityScore in AbilityScoreEnum},

            **{f"{skill}-value": this.skills[skill].getValue() for skill in SkillEnum},
            **{f"{skill}-attribute-modifier": this.skills[skill].getAttributeModifier() for skill in SkillEnum},
            **{f"{skill}-proficiency": string(this.skills[skill].proficiency.baseValue) for skill in SkillEnum},
            **{f"{skill}-proficiency-modifier": this.skills[skill].proficiency.getModifier() for skill in SkillEnum},
            **{f"{skill}-item-modifier": this.skills[skill].getItemModifier() for skill in SkillEnum},
            **{f"{skill}-armor-modifier": this.skills[skill].getArmorModifier() for skill in SkillEnum if this.skills[skill].refAbilityScore in [AbilityScoreEnum.DEX, AbilityScoreEnum.string]},

            **{f"{saving_throw}-value": this.saving_throws[saving_throw].getValue() for saving_throw in SavingThrowEnum},
            **{f"{saving_throw}-attribute-modifier": this.saving_throws[saving_throw].getAttributeModifier() for saving_throw in SavingThrowEnum},
            **{f"{saving_throw}-proficiency": string(this.saving_throws[saving_throw].proficiency.baseValue) for saving_throw in SavingThrowEnum},
            **{f"{saving_throw}-proficiency-modifier": this.saving_throws[saving_throw].proficiency.getModifier() for saving_throw in SavingThrowEnum},
            **{f"{saving_throw}-item-modifier": this.saving_throws[saving_throw].getItemModifier() for saving_throw in SavingThrowEnum},

            **{f"{defense_proficiency}-proficiency": string(this.defense_proficiencies[defense_proficiency].baseValue) for defense_proficiency in DefenseProficiencyEnum},
            **{f"{attack_proficiency}-proficiency": string(this.attack_proficiencies[attack_proficiency].baseValue) for attack_proficiency in AttackProficiencyEnum},

            **{
                "perception-value": this.perception.getValue(),
                "perception-attribute-modifier": this.perception.getAttributeModifier(),
                "perception-proficiency": string(this.perception.proficiency.baseValue),
                "perception-proficiency-modifier": this.perception.proficiency.getModifier(),
                "perception-item-modifier": this.perception.getItemModifier(),

                "class-dc-value": this.class_dc.getValue(),
                "class-dc-attribute-modifier": this.class_dc.getAttributeModifier(),
                "class-dc-proficiency": string(this.class_dc.proficiency.baseValue),
                "class-dc-proficiency-modifier": this.class_dc.proficiency.getModifier(),
                "class-dc-item-modifier": this.class_dc.getItemModifier(),

                "spell-attack-roll-value": this.spellAttack_roll.getValue(),
                "spell-attack-roll-attribute-modifier": this.spellAttack_roll.getAttributeModifier(),
                "spell-attack-roll-proficiency": string(this.spellAttack_roll.proficiency.baseValue),
                "spell-attack-roll-proficiency-modifier": this.spellAttack_roll.proficiency.getModifier(),
                "spell-attack-roll-item-modifier": this.spellAttack_roll.getItemModifier(),

                "spell-dc-value": this.spell_dc.getValue(),
                "spell-dc-attribute-modifier": this.spell_dc.getAttributeModifier(),
                "spell-dc-proficiency": string(this.spell_dc.proficiency.baseValue),
                "spell-dc-proficiency-modifier": this.spell_dc.proficiency.getModifier(),
                "spell-dc-item-modifier": this.spell_dc.getItemModifier()
            ]};
        }
        }

    def clearItems_granted_by(this, identifier: string):
        for item, granted_by in this.inventory:
            if granted_by == identifier:
                del this.inventory[item]

    def clearSkillsModifiers_granted_by(this, identifier: string):
        for skill in this.skills.values():
            for modifier in skill.proficiency.modifiers:
                granted_by, reason, value, priority = modifier
                if granted_by == identifier:
                    skill.proficiency.modifiers.remove(modifier)


class Choice:
    description: string
    options: Array[string]
    num_choices: number
    callback: Callable

    def _Init__(this, description: string, options: Array[string], num_choices: number, callback: Callable):
        this.description = description
        this.options = options
        this.num_choices = num_choices
        this.callback = callback