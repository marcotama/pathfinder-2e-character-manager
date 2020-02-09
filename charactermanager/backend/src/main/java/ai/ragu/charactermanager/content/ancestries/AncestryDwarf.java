package ai.ragu.charactermanager.content.ancestries;

import ai.ragu.charactermanager.dto.AncestryDto;
import ai.ragu.charactermanager.enumeration.AbilityScoreEnum;
import ai.ragu.charactermanager.enumeration.CreatureSizeEnum;
import ai.ragu.charactermanager.enumeration.LanguageEnum;
import ai.ragu.charactermanager.enumeration.SourceEnum;

import java.util.List;
import java.util.Set;

public class AncestryDwarf extends AncestryDto {
   public AncestryDwarf() {
      super(
              "Ancestry:Dwarf",
              "Dwarf",
              10,
              Set.of(AbilityScoreEnum.CON, AbilityScoreEnum.WIS),
              1,
              Set.of(AbilityScoreEnum.CHA),
              List.of(1, 5, 9, 13, 17),
              "Dwarf Feat",
              "Dwarf Heritage",
              "Dwarves are slow to trust those outside their kin, but this wariness is not without reason. Dwarves have a long history of forced exile from ancestral holds and struggles against the depredations of savage foes, especially giants, goblinoids, orcs, and the horrors that dwell deep below the surface. While trust from a dwarf is hard-won, once gained it is as strong as iron.",
              List.of(LanguageEnum.COMMON, LanguageEnum.DWARVEN),
              2,
              List.of(),
              List.of("Darkvision"),
              List.of("Dwarf", "Humanoid"),
              CreatureSizeEnum.MEDIUM,
              20,
              SourceEnum.CORE_RULEBOOK,
              "https://glasstopgames.com/pathfinder2/ancestry/dwarf.html"
      );
   }
}
