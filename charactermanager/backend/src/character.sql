\i populate.sql

CREATE TABLE IF NOT EXISTS "character" (
    "id" INTEGER,
    "name" VARCHAR,
    "age" INTEGER,
    "alignment" VARCHAR,
    "ancestry_id" VARCHAR,
    "background_id" VARCHAR,
    "class_id" VARCHAR,
    "level" SMALLINT,
    "savings_copper" INTEGER,
    "savings_silver" INTEGER,
    "savings_gold" INTEGER,
    "savings_platinum" INTEGER,
    "gender" VARCHAR,
    "exp" INTEGER,
    "hero_points" SMALLINT,
    "optional_flaw_id" VARCHAR,
    "shield_damage" SMALLINT,
    "num_spent_resonance" SMALLINT,
    "num_spent_spell_points" SMALLINT,
    "damageTaken" SMALLINT,
    "current_hp" SMALLINT,
    "num_temporary_hp" SMALLINT,
    "num_used_infused_reagents" SMALLINT,
    "notes" VARCHAR,
    "class_optional_trained_skill_id" VARCHAR,
    "armor_id" VARCHAR,
    "shield_id" VARCHAR,
    FOREIGN KEY ("ancestry_id") REFERENCES "ancestry"("id"),
    FOREIGN KEY ("background_id") REFERENCES "background"("id"),
    FOREIGN KEY ("optional_flaw_id") REFERENCES "ability_score"("id"),
    FOREIGN KEY ("class_optional_trained_skill_id") REFERENCES "skill"("id"),
    FOREIGN KEY ("armor_id") REFERENCES "armor"("id"),
    FOREIGN KEY ("shield_id") REFERENCES "shield"("id"),
    PRIMARY KEY ("id")
);


CREATE TABLE IF NOT EXISTS "character_ability_score_override" (
    "character_id" INTEGER,
    "ability_score_id" VARCHAR,
    "value" SMALLINT,
    FOREIGN KEY ("character_id") REFERENCES "character"("id"),
    FOREIGN KEY ("ability_score_id") REFERENCES "ability_score"("id"),
    PRIMARY KEY ("character_id","ability_score_id")
);


CREATE TABLE IF NOT EXISTS "character_language" (
    "character_id" INTEGER,
    "language_id" VARCHAR,
    FOREIGN KEY ("character_id") REFERENCES "character"("id"),
    FOREIGN KEY ("language_id") REFERENCES "language"("id"),
    PRIMARY KEY ("character_id","language_id")
);


CREATE TABLE IF NOT EXISTS "character_condition" (
    "character_id" INTEGER,
    "condition_id" VARCHAR,
    FOREIGN KEY ("character_id") REFERENCES "character"("id"),
    FOREIGN KEY ("condition_id") REFERENCES "condition"("id"),
    PRIMARY KEY ("character_id","condition_id")
);


CREATE TABLE IF NOT EXISTS "character_feat" (
    "character_id" INTEGER,
    "feat_id" VARCHAR,
    FOREIGN KEY ("character_id") REFERENCES "character"("id"),
    FOREIGN KEY ("feat_id") REFERENCES "feat"("id"),
    PRIMARY KEY ("character_id","feat_id")
);


CREATE TABLE IF NOT EXISTS "character_known_spell" (
    "character_id" INTEGER,
    "spell_id" VARCHAR,
    FOREIGN KEY ("character_id") REFERENCES "character"("id"),
    FOREIGN KEY ("spell_id") REFERENCES "spell"("id"),
    PRIMARY KEY ("character_id","spell_id")
);




boolean allowHalfHeritages = false;
int backgroundBoostLimitedSelection = 4;
int getBackgroundBoostFreeSelection = 0;
String[] dialects = new String[6];
HashMap<String, PlayerSpell> hashMapPlayerSpells = new HashMap<>();
HashMap<Integer, List<Integer>> hashMapAbilityBoosts = new HashMap<>();
HashMap<String, Integer> hashMapActiveCustomBuffs = new HashMap<>();
HashMap<Integer, HashMap<String, String>> hashMapAdditionalLores = new HashMap<>();
HashMap<Integer, Integer> hashMapAncestryFreeBoostSelections = new HashMap<>();
HashMap<String, HashMap<Integer, Integer>> hashMapBonusSpellSlots = new HashMap<>();
HashMap<String, FeatChoice> hashMapCustomFeatChoices = new HashMap<>();
HashMap<Integer, Integer> hashMapCustomSkillIncreases = new HashMap<>();
HashMap<String, EquipmentContainer> hashMapEquipmentContainers = new HashMap<>();
HashMap<String, Integer> hashMapFormulaBook = new HashMap<>();
HashMap<String, PetData> hashMapPetData = new HashMap<>();
HashMap<String, HashMap<Integer, String>> hashMapSignatureSpells = new HashMap<>();
HashMap<Integer, List<String>> hashMapSkillIncreases = new HashMap<>();
HashMap<String, HashMap<String, String>> hashMapSpecialSelections = new HashMap<>();
HashMap<String, HashMap<Integer, Integer>> hashMapSpontaneousSpellsCast = new HashMap<>();
HashMap<String, List<String>> hashMapTrainedOnlySkillChoices = new HashMap<>();
List<String> listCustomLores = new List<>();
List<PlayerEquipment> listPlayerEquipment = new List<>();
List<PlayerWeapon> listPlayerWeapons = new List<>();
List<String> listSpentSpellSlots = new List<>();
List<PlayerArmor> listStowedPlayerArmor = new List<>();
List<PlayerShield> listStowedPlayerShields = new List<>();