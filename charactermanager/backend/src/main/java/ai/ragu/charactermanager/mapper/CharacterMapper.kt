package ai.ragu.charactermanager.mapper

import ai.ragu.charactermanager.dto.AbilityScoreDto
import ai.ragu.charactermanager.dto.CharacterDto
import ai.ragu.charactermanager.dto.ProficiencyBasedRollDto
import ai.ragu.charactermanager.dto.ProficiencyDto
import ai.ragu.charactermanager.enumeration.*
import ai.ragu.charactermanager.sheet.AbilityScoreSheetEntry
import ai.ragu.charactermanager.sheet.CharacterSheet
import ai.ragu.charactermanager.sheet.ProficiencyBasedRollSheetEntry
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers
import java.util.function.Function
import java.util.stream.Collectors

@Mapper
class CharacterMapper {
    fun map(characterDto: CharacterDto): CharacterSheet {
        val abilityScores: Map<AbilityScoreEnum, AbilityScoreSheetEntry> = characterDto
                .abilityScores
                .entries
                .stream()
                .collect(Collectors.toMap({ java.util.Map.Entry.key }
                ) { entry: Map.Entry<AbilityScoreEnum?, AbilityScoreDto> ->
                    val abilityScoreDto = entry.value
                    AbilityScoreSheetEntry(
                            abilityScoreDto.calcScore(),
                            abilityScoreDto.calcModifier()
                    )
                })
        val skills: Map<SkillEnum, ProficiencyBasedRollSheetEntry> = characterDto
                .skills
                .entries
                .stream()
                .collect(Collectors.toMap({ java.util.Map.Entry.key }
                ) { entry: Map.Entry<SkillEnum?, ProficiencyBasedRollDto> -> ProficiencyBasedRollMapper.Companion.INSTANCE.map(entry.value, characterDto) })
        val savingThrows: Map<SavingThrowEnum, ProficiencyBasedRollSheetEntry> = characterDto
                .savingThrows
                .entries
                .stream()
                .collect(Collectors.toMap({ java.util.Map.Entry.key }
                ) { entry: Map.Entry<SavingThrowEnum?, ProficiencyBasedRollDto> -> ProficiencyBasedRollMapper.Companion.INSTANCE.map(entry.value, characterDto) })
        val classDC: ProficiencyBasedRollSheetEntry = ProficiencyBasedRollMapper.Companion.INSTANCE.map(characterDto.classDC, characterDto)
        val perception: ProficiencyBasedRollSheetEntry = ProficiencyBasedRollMapper.Companion.INSTANCE.map(characterDto.perception, characterDto)
        val spellAttackRoll: ProficiencyBasedRollSheetEntry = ProficiencyBasedRollMapper.Companion.INSTANCE.map(characterDto.spellAttackRoll, characterDto)
        val spellDC: ProficiencyBasedRollSheetEntry = ProficiencyBasedRollMapper.Companion.INSTANCE.map(characterDto.spellDC, characterDto)
        val attackProficiencies: Map<AttackProficiencyEnum, ProficiencyLevelEnum> = characterDto
                .attackProficiencies
                .entries
                .stream()
                .collect(Collectors.toMap(Function<Map.Entry<AttackProficiencyEnum, ProficiencyDto>, AttackProficiencyEnum> { java.util.Map.Entry.key },
                        Function<Map.Entry<AttackProficiencyEnum?, ProficiencyDto>, ProficiencyLevelEnum?> { entry: Map.Entry<AttackProficiencyEnum?, ProficiencyDto> -> entry.value.calcProficiency() }
                ))
        val defenseProficiencies: Map<DefenseProficiencyEnum, ProficiencyLevelEnum> = characterDto
                .defenseProficiencies
                .entries
                .stream()
                .collect(Collectors.toMap(Function<Map.Entry<DefenseProficiencyEnum, ProficiencyDto>, DefenseProficiencyEnum> { java.util.Map.Entry.key },
                        Function<Map.Entry<DefenseProficiencyEnum?, ProficiencyDto>, ProficiencyLevelEnum?> { entry: Map.Entry<DefenseProficiencyEnum?, ProficiencyDto> -> entry.value.calcProficiency() }
                ))
        return CharacterSheet(
                characterDto.id.toString(),
                characterDto.name,
                abilityScores,
                skills,
                savingThrows,
                perception,
                classDC,
                spellAttackRoll,
                spellDC,
                attackProficiencies,
                defenseProficiencies
        )
    }

    companion object {
        val INSTANCE = Mappers.getMapper(CharacterMapper::class.java)
    }
}