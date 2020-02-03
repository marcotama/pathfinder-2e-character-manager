package ai.ragu.charactermanager.mapper;

import ai.ragu.charactermanager.dto.CharacterDto;
import ai.ragu.charactermanager.dto.ProficiencyBasedRollDto;
import ai.ragu.charactermanager.sheet.ProficiencyBasedRollSheetEntry;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public class ProficiencyBasedRollMapper {
    public static final ProficiencyBasedRollMapper INSTANCE = Mappers.getMapper(ProficiencyBasedRollMapper.class);

    public ProficiencyBasedRollSheetEntry map(ProficiencyBasedRollDto proficiencyBasedRollDto, CharacterDto characterDto) {
        return new ProficiencyBasedRollSheetEntry(
                proficiencyBasedRollDto.getRefAbilityScore(),
                proficiencyBasedRollDto.calcAttributeModifier(characterDto),
                proficiencyBasedRollDto.getProficiency().calcProficiency(),
                proficiencyBasedRollDto.getProficiency().calcProficiency().getModifier(),
                proficiencyBasedRollDto.calcItemModifier(),
                proficiencyBasedRollDto.calcArmorModifier(characterDto),
                proficiencyBasedRollDto.calcValue(characterDto)
        );
    }
}
