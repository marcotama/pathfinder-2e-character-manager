package ai.ragu.charactermanager.mapper;

import ai.ragu.charactermanager.dto.AbilityScoreDto;
import ai.ragu.charactermanager.dto.CharacterDto;
import ai.ragu.charactermanager.dto.ProficiencyBasedRollDto;
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
public class ProficiencyBasedRollMapper {
    public static final ProficiencyBasedRollMapper INSTANCE = Mappers.getMapper(ProficiencyBasedRollMapper.class);

    public ProficiencyBasedRollSheetEntry map(ProficiencyBasedRollDto proficiencyBasedRollDto, CharacterDto characterDto) {
        return new ProficiencyBasedRollSheetEntry(
                proficiencyBasedRollDto.getRefAbilityScore(),
                proficiencyBasedRollDto.getAttributeModifier(characterDto),
                proficiencyBasedRollDto.getProficiency().calcProficiency(),
                proficiencyBasedRollDto.getProficiency().calcProficiency().getModifier(),
                proficiencyBasedRollDto.getItemModifier(),
                proficiencyBasedRollDto.getArmorModifier(characterDto),
                proficiencyBasedRollDto.getValue(characterDto)
        );
    }
}
