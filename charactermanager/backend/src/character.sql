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
    "damage_taken" SMALLINT,
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


-- should we add level? for spontaneous spell casters
CREATE TABLE IF NOT EXISTS "character_known_spell" (
    "character_id" INTEGER,
    "spell_id" VARCHAR,
    FOREIGN KEY ("character_id") REFERENCES "character"("id"),
    FOREIGN KEY ("spell_id") REFERENCES "spell"("id"),
    PRIMARY KEY ("character_id","spell_id")
);


CREATE TABLE IF NOT EXISTS "character_ability_boost" (
    "character_id" INTEGER,
    "level" SMALLINT,
    "ability_score_id" VARCHAR,
    FOREIGN KEY ("character_id") REFERENCES "character"("id"),
    FOREIGN KEY ("ability_score_id") REFERENCES "ability_score"("id"),
    UNIQUE ("character_id", "level"),
    PRIMARY KEY ("character_id", "level", "ability_score_id")
);


CREATE TABLE IF NOT EXISTS "character_free_ability_boost" (
    "character_id" INTEGER,
    "level" SMALLINT,
    "ability_score_id" VARCHAR,
    FOREIGN KEY ("character_id") REFERENCES "character"("id"),
    FOREIGN KEY ("ability_score_id") REFERENCES "ability_score"("id"),
    UNIQUE ("character_id", "level"),
    PRIMARY KEY ("character_id", "level", "ability_score_id")
);


CREATE TABLE IF NOT EXISTS "character_skill_increase" (
    "character_id" INTEGER,
    "level" SMALLINT,
    "ability_score_id" VARCHAR,
    FOREIGN KEY ("character_id") REFERENCES "character"("id"),
    FOREIGN KEY ("ability_score_id") REFERENCES "ability_score"("id"),
    UNIQUE ("character_id", "level"),
    PRIMARY KEY ("character_id", "level", "ability_score_id")
);


CREATE TABLE IF NOT EXISTS "character_signature_spell" (
    "character_id" INTEGER,
    "level" SMALLINT,
    "spell_id" VARCHAR,
    FOREIGN KEY ("character_id") REFERENCES "character"("id"),
    FOREIGN KEY ("spell_id") REFERENCES "spell"("id"),
    UNIQUE ("character_id", "level"),
    PRIMARY KEY ("character_id", "level", "spell_id")
);


CREATE TABLE IF NOT EXISTS "character_spell_slot" (
    "character_id" INTEGER,
    "spell_level" SMALLINT,
    "num_slots_available" SMALLINT,
    FOREIGN KEY ("character_id") REFERENCES "character"("id"),
    PRIMARY KEY ("character_id", "spell_level")
);



-- special selection -> special category -> special information
HashMap<String, HashMap<String, String>> specialSelections = new HashMap<>();
HashMap<String, List<String>> trainedOnlySkillChoices = new HashMap<>();

HashMap<Integer, HashMap<String, String>> additionalLores = new HashMap<>();
HashMap<String, HashMap<Integer, Integer>> bonusSpellSlots = new HashMap<>();
HashMap<String, EquipmentContainer> equipmentContainers = new HashMap<>();
HashMap<String, Integer> formulaBook = new HashMap<>();
HashMap<String, PetData> petData = new HashMap<>();

List<String> listCustomLores = new List<>();
List<String> listSpentSpellSlots = new List<>();

-- How many skill increases are allowed by level
HashMap<Integer, Integer> customSkillIncreases = new HashMap<>();
HashMap<String, Integer> activeCustomBuffs = new HashMap<>();
HashMap<String, FeatChoice> customFeatChoices = new HashMap<>();

-- Some day
boolean allowHalfHeritages = false;
int backgroundBoostLimitedSelection = 4;
int backgroundBoostFreeSelection = 0;
String[] dialects = new String[6];

-- Custom stuff
HashMap<String, PlayerSpell> playerSpells = new HashMap<>();
List<PlayerEquipment> listPlayerEquipment = new List<>();
List<PlayerWeapon> listPlayerWeapons = new List<>();
List<PlayerArmor> listStowedPlayerArmor = new List<>();
List<PlayerShield> listStowedPlayerShields = new List<>();