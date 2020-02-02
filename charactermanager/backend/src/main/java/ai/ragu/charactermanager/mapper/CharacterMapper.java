package ai.ragu.charactermanager.mapper;

import ai.ragu.charactermanager.dto.AbilityScoreDto;
import ai.ragu.charactermanager.dto.CharacterDto;
import ai.ragu.charactermanager.enumeration.*;
import ai.ragu.charactermanager.sheet.AbilityScoreSheetEntry;
import ai.ragu.charactermanager.sheet.CharacterSheet;
import ai.ragu.charactermanager.sheet.ProficiencyBasedRollSheetEntry;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Mapper
public class CharacterMapper {
    public static final CharacterMapper INSTANCE = Mappers.getMapper(CharacterMapper.class);

    public CharacterSheet map(CharacterDto characterDto) {

        Map<AbilityScoreEnum, AbilityScoreSheetEntry> abilityScores = characterDto
                .getAbilityScores()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {
                            AbilityScoreDto abilityScoreDto = entry.getValue();
                            return new AbilityScoreSheetEntry(
                                    abilityScoreDto.calcScore(),
                                    abilityScoreDto.calcModifier()
                            );
                        }
                ));

        Map<SkillEnum, ProficiencyBasedRollSheetEntry> skills = characterDto
                .getSkills()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> ProficiencyBasedRollMapper.INSTANCE.map(entry.getValue(), characterDto)
                ));

        Map<SavingThrowEnum, ProficiencyBasedRollSheetEntry> savingThrows = characterDto
                .getSavingThrows()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> ProficiencyBasedRollMapper.INSTANCE.map(entry.getValue(), characterDto)
                ));

        ProficiencyBasedRollSheetEntry classDC = ProficiencyBasedRollMapper.INSTANCE.map(characterDto.getClassDC(), characterDto);
        ProficiencyBasedRollSheetEntry perception = ProficiencyBasedRollMapper.INSTANCE.map(characterDto.getPerception(), characterDto);
        ProficiencyBasedRollSheetEntry spellAttackRoll = ProficiencyBasedRollMapper.INSTANCE.map(characterDto.getSpellAttackRoll(), characterDto);
        ProficiencyBasedRollSheetEntry spellDC = ProficiencyBasedRollMapper.INSTANCE.map(characterDto.getSpellDC(), characterDto);

        Map<AttackProficiencyEnum, ProficiencyLevelEnum> attackProficiencies = characterDto
                .getAttackProficiencies()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().calcProficiency()
                ));
        Map<DefenseProficiencyEnum, ProficiencyLevelEnum> defenseProficiencies = characterDto
                .getDefenseProficiencies()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().calcProficiency()
                ));

        return new CharacterSheet(
                abilityScores,
                skills,
                savingThrows,
                perception,
                classDC,
                spellAttackRoll,
                spellDC,
                attackProficiencies,
                defenseProficiencies

        );
    }
}
