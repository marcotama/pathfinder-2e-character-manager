package ai.ragu.charactermanager.pojo

import ai.ragu.charactermanager.enumeration.*
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator
import lombok.EqualsAndHashCode
import lombok.ToString
import java.util.*

@JsonIdentityInfo(generator = PropertyGenerator::class, property = "id")
class Character {
    @JsonPropertyDescription("A unique identifier for this character")
    @ToString.Include
    @EqualsAndHashCode.Include
    lateinit var id: UUID

    @JsonPropertyDescription("The name of this character")
    lateinit var name: String

    @JsonPropertyDescription("The level of this character")
    var level: Long = 0

    @JsonPropertyDescription("The ancestry of this character")
    lateinit var ancestry: Ancestry

    @JsonPropertyDescription("The class of this character")
    lateinit var clazz: ClazzDto

    @JsonPropertyDescription("The armor of this character")
    lateinit var armor: ArmorDto

    @JsonPropertyDescription("The shields of this character")
    lateinit var shields: List<ShieldDto> = ArrayList()

    @JsonPropertyDescription("The weapons of this character")
    lateinit var weapons: List<Weapon> = ArrayList()

    @JsonPropertyDescription("The ability scores of this character")
    var abilityScores = mapOf(
            AbilityScoreEnum.STR to AbilityScoreDto(),
            AbilityScoreEnum.DEX to AbilityScoreDto(),
            AbilityScoreEnum.CON to AbilityScoreDto(),
            AbilityScoreEnum.INT to AbilityScoreDto(),
            AbilityScoreEnum.WIS to AbilityScoreDto(),
            AbilityScoreEnum.CHA to AbilityScoreDto()
    )

    @JsonPropertyDescription("The skills of this character")
    var skills = mapOf(
            SkillEnum.ACROBATICS to ProficiencyBasedRollDto(AbilityScoreEnum.DEX),
            SkillEnum.ARCANA to ProficiencyBasedRollDto(AbilityScoreEnum.INT),
            SkillEnum.ATHLETICS to ProficiencyBasedRollDto(AbilityScoreEnum.INT),
            SkillEnum.CRAFTING to ProficiencyBasedRollDto(AbilityScoreEnum.INT),
            SkillEnum.DECEPTION to ProficiencyBasedRollDto(AbilityScoreEnum.CHA),
            SkillEnum.DIPLOMACY to ProficiencyBasedRollDto(AbilityScoreEnum.CHA),
            SkillEnum.INTIMIDATION to ProficiencyBasedRollDto(AbilityScoreEnum.CHA),
            SkillEnum.MEDICINE to ProficiencyBasedRollDto(AbilityScoreEnum.WIS),
            SkillEnum.NATURE to ProficiencyBasedRollDto(AbilityScoreEnum.WIS),
            SkillEnum.OCCULTISM to ProficiencyBasedRollDto(AbilityScoreEnum.INT),
            SkillEnum.PERFORMANCE to ProficiencyBasedRollDto(AbilityScoreEnum.CHA),
            SkillEnum.RELIGION to ProficiencyBasedRollDto(AbilityScoreEnum.WIS),
            SkillEnum.SOCIETY to ProficiencyBasedRollDto(AbilityScoreEnum.INT),
            SkillEnum.STEALTH to ProficiencyBasedRollDto(AbilityScoreEnum.DEX),
            SkillEnum.SURVIVAL to ProficiencyBasedRollDto(AbilityScoreEnum.WIS),
            SkillEnum.THIEVERY to ProficiencyBasedRollDto(AbilityScoreEnum.DEX)
    )

    @JsonPropertyDescription("The saving throws of this character")
    var savingThrows = mapOf(
            SavingThrowEnum.FORTITUDE to ProficiencyBasedRollDto(AbilityScoreEnum.CON),
            SavingThrowEnum.REFLEX to ProficiencyBasedRollDto(AbilityScoreEnum.DEX),
            SavingThrowEnum.WILL to ProficiencyBasedRollDto(AbilityScoreEnum.WIS)
    )

    @JsonPropertyDescription("The perception of this character")
    var perception = ProficiencyBasedRollDto(AbilityScoreEnum.WIS)

    @JsonPropertyDescription("The class DC of this character")
    var classDC = ProficiencyBasedRollDto()

    @JsonPropertyDescription("The spell attack roll of this character")
    var spellAttackRoll = ProficiencyBasedRollDto()

    @JsonPropertyDescription("The spell DC of this character")
    var spellDC = ProficiencyBasedRollDto()

    @JsonPropertyDescription("The equipment of this character")
    var equipment: List<Equipment> = ArrayList()

    @JsonPropertyDescription("The maximum hit points of this character")
    var maxHitPoints: Int = 0

    @JsonPropertyDescription("The current hit points of this character")
    var currentHitPoints: Int = 0

    @JsonPropertyDescription("The temporary hit points of this character")
    var temporaryHitPoints: Int = 0

    @JsonPropertyDescription("The speed of this character")
    var speed: Int = 0

    @JsonPropertyDescription("The resistances of this character")
    var resistances: List<DamageTypeEnum> = ArrayList()

    @JsonPropertyDescription("The immunities of this character")
    var immunities: List<DamageTypeEnum> = ArrayList()

    @JsonPropertyDescription("The conditions of this character")
    var conditions: List<DamageTypeEnum> = ArrayList()

    @JsonProperty("attackProficiencies")
    @JsonPropertyDescription("The attack proficiencies of this character")
    var attackProficiencies: Map<AttackProficiencyEnum, ProficiencyDto> = mapOf(
            MeleeWeaponTypeEnum.SWORD to ProficiencyDto(),
            MeleeWeaponTypeEnum.SPEAR to ProficiencyDto(),
            MeleeWeaponTypeEnum.HAMMER to ProficiencyDto(),
            MeleeWeaponTypeEnum.POLEARM to ProficiencyDto(),
            MeleeWeaponTypeEnum.KNIFE to ProficiencyDto(),
            MeleeWeaponTypeEnum.CLUB to ProficiencyDto(),
            MeleeWeaponTypeEnum.FLAIL to ProficiencyDto(),
            MeleeWeaponTypeEnum.BRAWLING to ProficiencyDto(),
            MeleeWeaponTypeEnum.AXE to ProficiencyDto(),
            MeleeWeaponTypeEnum.PICK to ProficiencyDto(),
            MeleeWeaponTypeEnum.SHIELD to ProficiencyDto(),
            MeleeWeaponTypeEnum.WHIP to ProficiencyDto(),
            RangedWeaponTypeEnum.DART to ProficiencyDto(),
            RangedWeaponTypeEnum.BOW to ProficiencyDto(),
            OtherAttackWeaponTypeEnum.UNARMED_ATTACKS to ProficiencyDto(),
            OtherAttackWeaponTypeEnum.SIMPLE_WEAPONS to ProficiencyDto(),
            OtherAttackWeaponTypeEnum.MARTIAL_WEAPONS to ProficiencyDto(),
            OtherAttackWeaponTypeEnum.ALCHEMICAL_BOMBS to ProficiencyDto()
    )

    @JsonProperty("defenseProficiencies")
    @JsonPropertyDescription("The defense proficiencies of this character")
    var defenseProficiencies = mapOf(
            DefenseProficiencyEnum.UNARMORED_DEFENSE to ProficiencyDto(),
            DefenseProficiencyEnum.LIGHT_ARMOR to ProficiencyDto(),
            DefenseProficiencyEnum.MEDIUM_ARMOR to ProficiencyDto(),
            DefenseProficiencyEnum.HEAVY_ARMOR to ProficiencyDto()
    )

    @JsonProperty("inventory")
    @JsonPropertyDescription("The inventory of this character")
    var inventory: HashMap<InventoryItemEnum, String> = HashMap() // items annotated by the granter

    fun clearItemsGrantedBy(identifier: String) {
        var toRemove: MutableList<InventoryItemEnum> = ArrayList()
        for ((key, grantedBy) in inventory) {
            if (grantedBy == identifier) {
                toRemove.add(key)
            }
        }
        for (itemEnum in toRemove) {
            inventory.remove(itemEnum)
        }
    }

    fun clearSkillsModifiersGrantedBy(identifier: String) {
        for ((_, skill) in skills) {
            skill.proficiency.modifiers.removeIf { proficiencyModifierDto: ProficiencyModifierDto -> proficiencyModifierDto.granter == identifier }
        }
    }
}