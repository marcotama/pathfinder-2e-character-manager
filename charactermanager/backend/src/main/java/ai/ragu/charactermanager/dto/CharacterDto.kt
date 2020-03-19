package ai.ragu.charactermanager.dto

import ai.ragu.charactermanager.enumeration.*
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator
import lombok.*
import java.util.*

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = PropertyGenerator::class, property = "id")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
class CharacterDto {
    @JsonProperty("id")
    @JsonPropertyDescription("A unique identifier for this character")
    @ToString.Include
    @EqualsAndHashCode.Include
    @Nonnull
    private val id: UUID? = null
    @JsonProperty("name")
    @JsonPropertyDescription("The name of this character")
    @Nonnull
    private val name: String? = null
    @JsonProperty("level")
    @JsonPropertyDescription("The level of this character")
    @Nonnull
    private val level = 1
    @JsonProperty("ancestry")
    @JsonPropertyDescription("The ancestry of this character")
    private val ancestry: AncestryDto? = null
    @JsonProperty("clazz")
    @JsonPropertyDescription("The class of this character")
    private val clazz: ClazzDto? = null
    @JsonProperty("armor")
    @JsonPropertyDescription("The armor of this character")
    private val armor: ArmorDto? = null
    @JsonProperty("shields")
    @JsonPropertyDescription("The shields of this character")
    @Nonnull
    private val shields: List<ShieldDto> = ArrayList()
    @JsonProperty("weapons")
    @JsonPropertyDescription("The weapons of this character")
    @Nonnull
    private val weapons: List<Weapon> = ArrayList()
    @JsonProperty("abilityScores")
    @JsonPropertyDescription("The ability scores of this character")
    @Nonnull
    var abilityScores = java.util.Map.ofEntries(
            java.util.Map.entry(AbilityScoreEnum.STR, AbilityScoreDto()),
            java.util.Map.entry(AbilityScoreEnum.DEX, AbilityScoreDto()),
            java.util.Map.entry(AbilityScoreEnum.CON, AbilityScoreDto()),
            java.util.Map.entry(AbilityScoreEnum.INT, AbilityScoreDto()),
            java.util.Map.entry(AbilityScoreEnum.WIS, AbilityScoreDto()),
            java.util.Map.entry(AbilityScoreEnum.CHA, AbilityScoreDto())
    )
    @JsonProperty("skills")
    @JsonPropertyDescription("The skills of this character")
    @Nonnull
    var skills = java.util.Map.ofEntries(
            java.util.Map.entry(SkillEnum.ACROBATICS, ProficiencyBasedRollDto(AbilityScoreEnum.DEX)),
            java.util.Map.entry(SkillEnum.ARCANA, ProficiencyBasedRollDto(AbilityScoreEnum.INT)),
            java.util.Map.entry(SkillEnum.ATHLETICS, ProficiencyBasedRollDto(AbilityScoreEnum.INT)),
            java.util.Map.entry(SkillEnum.CRAFTING, ProficiencyBasedRollDto(AbilityScoreEnum.INT)),
            java.util.Map.entry(SkillEnum.DECEPTION, ProficiencyBasedRollDto(AbilityScoreEnum.CHA)),
            java.util.Map.entry(SkillEnum.DIPLOMACY, ProficiencyBasedRollDto(AbilityScoreEnum.CHA)),
            java.util.Map.entry(SkillEnum.INTIMIDATION, ProficiencyBasedRollDto(AbilityScoreEnum.CHA)),
            java.util.Map.entry(SkillEnum.MEDICINE, ProficiencyBasedRollDto(AbilityScoreEnum.WIS)),
            java.util.Map.entry(SkillEnum.NATURE, ProficiencyBasedRollDto(AbilityScoreEnum.WIS)),
            java.util.Map.entry(SkillEnum.OCCULTISM, ProficiencyBasedRollDto(AbilityScoreEnum.INT)),
            java.util.Map.entry(SkillEnum.PERFORMANCE, ProficiencyBasedRollDto(AbilityScoreEnum.CHA)),
            java.util.Map.entry(SkillEnum.RELIGION, ProficiencyBasedRollDto(AbilityScoreEnum.WIS)),
            java.util.Map.entry(SkillEnum.SOCIETY, ProficiencyBasedRollDto(AbilityScoreEnum.INT)),
            java.util.Map.entry(SkillEnum.STEALTH, ProficiencyBasedRollDto(AbilityScoreEnum.DEX)),
            java.util.Map.entry(SkillEnum.SURVIVAL, ProficiencyBasedRollDto(AbilityScoreEnum.WIS)),
            java.util.Map.entry(SkillEnum.THIEVERY, ProficiencyBasedRollDto(AbilityScoreEnum.DEX))
    )
    @JsonProperty("savingThrows")
    @JsonPropertyDescription("The saving throws of this character")
    @Nonnull
    var savingThrows = java.util.Map.ofEntries(
            java.util.Map.entry(SavingThrowEnum.FORTITUDE, ProficiencyBasedRollDto(AbilityScoreEnum.CON)),
            java.util.Map.entry(SavingThrowEnum.REFLEX, ProficiencyBasedRollDto(AbilityScoreEnum.DEX)),
            java.util.Map.entry(SavingThrowEnum.WILL, ProficiencyBasedRollDto(AbilityScoreEnum.WIS))
    )
    @JsonProperty("perception")
    @JsonPropertyDescription("The perception of this character")
    private val perception = ProficiencyBasedRollDto(AbilityScoreEnum.WIS)
    @JsonProperty("classDC")
    @JsonPropertyDescription("The class DC of this character")
    private val classDC = ProficiencyBasedRollDto()
    @JsonProperty("spellAttackRoll")
    @JsonPropertyDescription("The spell attack roll of this character")
    private val spellAttackRoll = ProficiencyBasedRollDto()
    @JsonProperty("spellDC")
    @JsonPropertyDescription("The spell DC of this character")
    private val spellDC = ProficiencyBasedRollDto()
    @JsonProperty("equipment")
    @JsonPropertyDescription("The equipment of this character")
    var equipment: List<Equipment> = ArrayList()
    @JsonProperty("maxHitPoints")
    @JsonPropertyDescription("The maximum hit points of this character")
    private val maxHitPoints: Int? = null
    @JsonProperty("currentHitPoints")
    @JsonPropertyDescription("The current hit points of this character")
    private val currentHitPoints: Int? = null
    @JsonProperty("temporaryHitPoints")
    @JsonPropertyDescription("The temporary hit points of this character")
    private val temporaryHitPoints: Int? = null
    @JsonProperty("speed")
    @JsonPropertyDescription("The speed of this character")
    private val speed: Int? = null
    @JsonProperty("resistances")
    @JsonPropertyDescription("The resistances of this character")
    private val resistances: List<DamageTypeEnum> = ArrayList()
    @JsonProperty("immunities")
    @JsonPropertyDescription("The immunities of this character")
    private val immunities: List<DamageTypeEnum> = ArrayList()
    @JsonProperty("conditions")
    @JsonPropertyDescription("The conditions of this character")
    private val conditions: List<DamageTypeEnum> = ArrayList()
    @JsonProperty("attackProficiencies")
    @JsonPropertyDescription("The attack proficiencies of this character")
    var attackProficiencies: Map<AttackProficiencyEnum, ProficiencyDto> = java.util.Map.ofEntries(
            java.util.Map.entry(MeleeWeaponTypeEnum.SWORD, ProficiencyDto()),
            java.util.Map.entry(MeleeWeaponTypeEnum.SPEAR, ProficiencyDto()),
            java.util.Map.entry(MeleeWeaponTypeEnum.HAMMER, ProficiencyDto()),
            java.util.Map.entry(MeleeWeaponTypeEnum.POLEARM, ProficiencyDto()),
            java.util.Map.entry(MeleeWeaponTypeEnum.KNIFE, ProficiencyDto()),
            java.util.Map.entry(MeleeWeaponTypeEnum.CLUB, ProficiencyDto()),
            java.util.Map.entry(MeleeWeaponTypeEnum.FLAIL, ProficiencyDto()),
            java.util.Map.entry(MeleeWeaponTypeEnum.BRAWLING, ProficiencyDto()),
            java.util.Map.entry(MeleeWeaponTypeEnum.AXE, ProficiencyDto()),
            java.util.Map.entry(MeleeWeaponTypeEnum.PICK, ProficiencyDto()),
            java.util.Map.entry(MeleeWeaponTypeEnum.SHIELD, ProficiencyDto()),
            java.util.Map.entry(MeleeWeaponTypeEnum.WHIP, ProficiencyDto()),
            java.util.Map.entry(RangedWeaponTypeEnum.DART, ProficiencyDto()),
            java.util.Map.entry(RangedWeaponTypeEnum.BOW, ProficiencyDto()),
            java.util.Map.entry(OtherAttackWeaponTypeEnum.UNARMED_ATTACKS, ProficiencyDto()),
            java.util.Map.entry(OtherAttackWeaponTypeEnum.SIMPLE_WEAPONS, ProficiencyDto()),
            java.util.Map.entry(OtherAttackWeaponTypeEnum.MARTIAL_WEAPONS, ProficiencyDto()),
            java.util.Map.entry(OtherAttackWeaponTypeEnum.ALCHEMICAL_BOMBS, ProficiencyDto())
    )
    @JsonProperty("defenseProficiencies")
    @JsonPropertyDescription("The defense proficiencies of this character")
    var defenseProficiencies = java.util.Map.ofEntries(
            java.util.Map.entry(DefenseProficiencyEnum.UNARMORED_DEFENSE, ProficiencyDto()),
            java.util.Map.entry(DefenseProficiencyEnum.LIGHT_ARMOR, ProficiencyDto()),
            java.util.Map.entry(DefenseProficiencyEnum.MEDIUM_ARMOR, ProficiencyDto()),
            java.util.Map.entry(DefenseProficiencyEnum.HEAVY_ARMOR, ProficiencyDto())
    )
    @JsonProperty("inventory")
    @JsonPropertyDescription("The inventory of this character")
    var inventory: Map<InventoryItemEnum, String> = HashMap() // items annotated by the granter

    fun clearItemsGrantedBy(identifier: String) {
        val toRemove: MutableList<InventoryItemEnum> = ArrayList()
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