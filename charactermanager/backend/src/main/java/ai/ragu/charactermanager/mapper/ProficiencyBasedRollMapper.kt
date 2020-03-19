package ai.ragu.charactermanager.mapper

import ai.ragu.charactermanager.dto.CharacterDto
import ai.ragu.charactermanager.dto.ProficiencyBasedRollDto
import ai.ragu.charactermanager.sheet.ProficiencyBasedRollSheetEntry
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
class ProficiencyBasedRollMapper {
    fun map(proficiencyBasedRollDto: ProficiencyBasedRollDto, characterDto: CharacterDto): ProficiencyBasedRollSheetEntry {
        return ProficiencyBasedRollSheetEntry(
                proficiencyBasedRollDto.refAbilityScore,
                proficiencyBasedRollDto.calcAttributeModifier(characterDto),
                proficiencyBasedRollDto.proficiency.calcProficiency(),
                proficiencyBasedRollDto.proficiency.calcProficiency().modifier,
                proficiencyBasedRollDto.calcItemModifier(),
                proficiencyBasedRollDto.calcArmorModifier(characterDto),
                proficiencyBasedRollDto.calcValue(characterDto)
        )
    }

    companion object {
        val INSTANCE = Mappers.getMapper(ProficiencyBasedRollMapper::class.java)
    }
}