package ai.ragu.charactermanager.content.ancestries;

import ai.ragu.charactermanager.dto.AncestryDto;
import ai.ragu.charactermanager.enumeration.AbilityScoreEnum;
import ai.ragu.charactermanager.enumeration.CreatureSizeEnum;
import ai.ragu.charactermanager.enumeration.LanguageEnum;
import ai.ragu.charactermanager.enumeration.SourceEnum;

import java.util.List;
import java.util.Set;

public class AncestryHalfling extends AncestryDto {
   public AncestryHalfling() {
      super(
              "Ancestry:Halfling",
              "Halfling",
              6,
              Set.of(AbilityScoreEnum.DEX, AbilityScoreEnum.WIS),
              1,
              Set.of(AbilityScoreEnum.STR),
              List.of(1, 5, 9, 13, 17),
              "Halfling Feat",
              "Halfling Heritage",
              "Optimistic and cheerful, blessed with uncanny luck, and driven by powerful wanderlust, halflings make up for their short stature with an abundance of bravado and curiosity. At once excitable and easygoing, they are the best kind of opportunists, and their passions favor joy over violence. Even in the jaws of danger, halflings rarely lose their sense of humor.\n\nMany taller people dismiss halflings due to their size or, worse, treat them like children. Halflings use these prejudices and misconceptions to their advantage, gaining access to opportunities and performing deeds of daring mischief or heroism. A halfling’s curiosity is tempered by wisdom and caution, leading to calculated risks and narrow escapes.\n\nWhile their wanderlust and curiosity sometimes drive them toward adventure, halflings also carry strong ties to house and home, often spending above their means to achieve comfort in their homelife.",
              List.of(LanguageEnum.COMMON, LanguageEnum.HALFLING),
              0,
              List.of(),
              List.of("Keen Eyes"),
              List.of("Halfling", "Humanoid"),
              CreatureSizeEnum.SMALL,
              25,
              SourceEnum.CORE_RULEBOOK,
              "https://glasstopgames.com/pathfinder2/ancestry/halfling.html"
      );
   }
}
