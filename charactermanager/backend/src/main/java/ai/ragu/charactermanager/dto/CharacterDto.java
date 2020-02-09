package ai.ragu.charactermanager.dto;

import ai.ragu.charactermanager.enumeration.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CharacterDto {

    @JsonProperty("id")
    @JsonPropertyDescription("A unique identifier for this character")
    @ToString.Include
    @EqualsAndHashCode.Include
    @Nonnull
    private UUID id;

    @JsonProperty("name")
    @JsonPropertyDescription("The name of this character")
    @Nonnull
    private String name;

    @JsonProperty("level")
    @JsonPropertyDescription("The level of this character")
    @Nonnull
    private Integer level = 1;

    @JsonProperty("ancestry")
    @JsonPropertyDescription("The ancestry of this character")
    @Nullable
    private AncestryDto ancestry;

    @JsonProperty("clazz")
    @JsonPropertyDescription("The class of this character")
    @Nullable
    private ClazzDto clazz;

    @JsonProperty("armor")
    @JsonPropertyDescription("The armor of this character")
    @Nullable
    private ArmorDto armor = null;

    @JsonProperty("shields")
    @JsonPropertyDescription("The shields of this character")
    @Nonnull
    private List<ShieldDto> shields = new ArrayList<>();

    @JsonProperty("weapons")
    @JsonPropertyDescription("The weapons of this character")
    @Nonnull
    private List<Weapon> weapons = new ArrayList<>();

    @JsonProperty("abilityScores")
    @JsonPropertyDescription("The ability scores of this character")
    @Nonnull
    Map<AbilityScoreEnum, AbilityScoreDto> abilityScores = Map.ofEntries(
            Map.entry(AbilityScoreEnum.STR, new AbilityScoreDto()),
            Map.entry(AbilityScoreEnum.DEX, new AbilityScoreDto()),
            Map.entry(AbilityScoreEnum.CON, new AbilityScoreDto()),
            Map.entry(AbilityScoreEnum.INT, new AbilityScoreDto()),
            Map.entry(AbilityScoreEnum.WIS, new AbilityScoreDto()),
            Map.entry(AbilityScoreEnum.CHA, new AbilityScoreDto())
    );

    @JsonProperty("skills")
    @JsonPropertyDescription("The skills of this character")
    @Nonnull
    Map<SkillEnum, ProficiencyBasedRollDto> skills = Map.ofEntries(
            Map.entry(SkillEnum.ACROBATICS, new ProficiencyBasedRollDto(AbilityScoreEnum.DEX)),
            Map.entry(SkillEnum.ARCANA, new ProficiencyBasedRollDto(AbilityScoreEnum.INT)),
            Map.entry(SkillEnum.ATHLETICS, new ProficiencyBasedRollDto(AbilityScoreEnum.INT)),
            Map.entry(SkillEnum.CRAFTING, new ProficiencyBasedRollDto(AbilityScoreEnum.INT)),
            Map.entry(SkillEnum.DECEPTION, new ProficiencyBasedRollDto(AbilityScoreEnum.CHA)),
            Map.entry(SkillEnum.DIPLOMACY, new ProficiencyBasedRollDto(AbilityScoreEnum.CHA)),
            Map.entry(SkillEnum.INTIMIDATION, new ProficiencyBasedRollDto(AbilityScoreEnum.CHA)),
            Map.entry(SkillEnum.MEDICINE, new ProficiencyBasedRollDto(AbilityScoreEnum.WIS)),
            Map.entry(SkillEnum.NATURE, new ProficiencyBasedRollDto(AbilityScoreEnum.WIS)),
            Map.entry(SkillEnum.OCCULTISM, new ProficiencyBasedRollDto(AbilityScoreEnum.INT)),
            Map.entry(SkillEnum.PERFORMANCE, new ProficiencyBasedRollDto(AbilityScoreEnum.CHA)),
            Map.entry(SkillEnum.RELIGION, new ProficiencyBasedRollDto(AbilityScoreEnum.WIS)),
            Map.entry(SkillEnum.SOCIETY, new ProficiencyBasedRollDto(AbilityScoreEnum.INT)),
            Map.entry(SkillEnum.STEALTH, new ProficiencyBasedRollDto(AbilityScoreEnum.DEX)),
            Map.entry(SkillEnum.SURVIVAL, new ProficiencyBasedRollDto(AbilityScoreEnum.WIS)),
            Map.entry(SkillEnum.THIEVERY, new ProficiencyBasedRollDto(AbilityScoreEnum.DEX))
    );

    @JsonProperty("savingThrows")
    @JsonPropertyDescription("The saving throws of this character")
    @Nonnull
    Map<SavingThrowEnum, ProficiencyBasedRollDto> savingThrows = Map.ofEntries(
            Map.entry(SavingThrowEnum.FORTITUDE, new ProficiencyBasedRollDto(AbilityScoreEnum.CON)),
            Map.entry(SavingThrowEnum.REFLEX, new ProficiencyBasedRollDto(AbilityScoreEnum.DEX)),
            Map.entry(SavingThrowEnum.WILL, new ProficiencyBasedRollDto(AbilityScoreEnum.WIS))
    );

    @JsonProperty("perception")
    @JsonPropertyDescription("The perception of this character")
    private ProficiencyBasedRollDto perception = new ProficiencyBasedRollDto(AbilityScoreEnum.WIS);

    @JsonProperty("classDC")
    @JsonPropertyDescription("The class DC of this character")
    private ProficiencyBasedRollDto classDC = new ProficiencyBasedRollDto();

    @JsonProperty("spellAttackRoll")
    @JsonPropertyDescription("The spell attack roll of this character")
    private ProficiencyBasedRollDto spellAttackRoll = new ProficiencyBasedRollDto();

    @JsonProperty("spellDC")
    @JsonPropertyDescription("The spell DC of this character")
    private ProficiencyBasedRollDto spellDC = new ProficiencyBasedRollDto();

    @JsonProperty("equipment")
    @JsonPropertyDescription("The equipment of this character")
    List<Equipment> equipment = new ArrayList<>();

    @JsonProperty("maxHitPoints")
    @JsonPropertyDescription("The maximum hit points of this character")
    private Integer maxHitPoints;

    @JsonProperty("currentHitPoints")
    @JsonPropertyDescription("The current hit points of this character")
    private Integer currentHitPoints;

    @JsonProperty("temporaryHitPoints")
    @JsonPropertyDescription("The temporary hit points of this character")
    private Integer temporaryHitPoints;

    @JsonProperty("speed")
    @JsonPropertyDescription("The speed of this character")
    private Integer speed;

    @JsonProperty("resistances")
    @JsonPropertyDescription("The resistances of this character")
    private List<DamageTypeEnum> resistances = new ArrayList<>();

    @JsonProperty("immunities")
    @JsonPropertyDescription("The immunities of this character")
    private List<DamageTypeEnum> immunities = new ArrayList<>();

    @JsonProperty("conditions")
    @JsonPropertyDescription("The conditions of this character")
    private List<DamageTypeEnum> conditions = new ArrayList<>();

    @JsonProperty("attackProficiencies")
    @JsonPropertyDescription("The attack proficiencies of this character")
    Map<AttackProficiencyEnum, ProficiencyDto> attackProficiencies = Map.ofEntries(
        Map.entry(MeleeWeaponTypeEnum.SWORD, new ProficiencyDto()),
        Map.entry(MeleeWeaponTypeEnum.SPEAR, new ProficiencyDto()),
        Map.entry(MeleeWeaponTypeEnum.HAMMER, new ProficiencyDto()),
        Map.entry(MeleeWeaponTypeEnum.POLEARM, new ProficiencyDto()),
        Map.entry(MeleeWeaponTypeEnum.KNIFE, new ProficiencyDto()),
        Map.entry(MeleeWeaponTypeEnum.CLUB, new ProficiencyDto()),
        Map.entry(MeleeWeaponTypeEnum.FLAIL, new ProficiencyDto()),
        Map.entry(MeleeWeaponTypeEnum.BRAWLING, new ProficiencyDto()),
        Map.entry(MeleeWeaponTypeEnum.AXE, new ProficiencyDto()),
        Map.entry(MeleeWeaponTypeEnum.PICK, new ProficiencyDto()),
        Map.entry(MeleeWeaponTypeEnum.SHIELD, new ProficiencyDto()),
        Map.entry(MeleeWeaponTypeEnum.WHIP, new ProficiencyDto()),
        Map.entry(RangedWeaponTypeEnum.DART, new ProficiencyDto()),
        Map.entry(RangedWeaponTypeEnum.BOW, new ProficiencyDto()),
        Map.entry(OtherAttackWeaponTypeEnum.UNARMED_ATTACKS, new ProficiencyDto()),
        Map.entry(OtherAttackWeaponTypeEnum.SIMPLE_WEAPONS, new ProficiencyDto()),
        Map.entry(OtherAttackWeaponTypeEnum.MARTIAL_WEAPONS, new ProficiencyDto()),
        Map.entry(OtherAttackWeaponTypeEnum.ALCHEMICAL_BOMBS, new ProficiencyDto())
    );

    @JsonProperty("defenseProficiencies")
    @JsonPropertyDescription("The defense proficiencies of this character")
    Map<DefenseProficiencyEnum, ProficiencyDto> defenseProficiencies = Map.ofEntries(
            Map.entry(DefenseProficiencyEnum.UNARMORED_DEFENSE, new ProficiencyDto()),
            Map.entry(DefenseProficiencyEnum.LIGHT_ARMOR, new ProficiencyDto()),
            Map.entry(DefenseProficiencyEnum.MEDIUM_ARMOR, new ProficiencyDto()),
            Map.entry(DefenseProficiencyEnum.HEAVY_ARMOR, new ProficiencyDto())
    );

    @JsonProperty("inventory")
    @JsonPropertyDescription("The inventory of this character")
    Map<InventoryItemEnum, String> inventory = new HashMap<>(); // items annotated by the granter

    public void clearItemsGrantedBy(String identifier) {
        List<InventoryItemEnum> toRemove = new ArrayList<>();
        for (Map.Entry<InventoryItemEnum, String> entry : this.inventory.entrySet()) {
            InventoryItemEnum key = entry.getKey();
            String grantedBy = entry.getValue();
            if (grantedBy.equals(identifier)) {
                toRemove.add(key);
            }
        }
        for (InventoryItemEnum itemEnum : toRemove) {
            this.inventory.remove(itemEnum);
        }
    }

    public void clearSkillsModifiersGrantedBy(String identifier) {
        for (Map.Entry<SkillEnum, ProficiencyBasedRollDto> entry : this.skills.entrySet()) {
            ProficiencyBasedRollDto skill = entry.getValue();
            skill.getProficiency().modifiers.removeIf(proficiencyModifierDto -> proficiencyModifierDto.granter.equals(identifier));
        }
    };
}
