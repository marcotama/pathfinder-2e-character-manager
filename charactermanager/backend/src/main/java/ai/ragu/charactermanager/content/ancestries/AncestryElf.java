package ai.ragu.charactermanager.content.ancestries;

import ai.ragu.charactermanager.dto.AncestryDto;
import ai.ragu.charactermanager.enumeration.AbilityScoreEnum;
import ai.ragu.charactermanager.enumeration.CreatureSizeEnum;
import ai.ragu.charactermanager.enumeration.LanguageEnum;
import ai.ragu.charactermanager.enumeration.SourceEnum;

import java.util.List;
import java.util.Set;

public class AncestryElf extends AncestryDto {
   public AncestryElf() {
      super(
              "Ancestry:Elf",
              "Elf",
              6,
              Set.of(AbilityScoreEnum.DEX, AbilityScoreEnum.INT),
              1,
              Set.of(AbilityScoreEnum.CON),
              List.of(1, 5, 9, 13, 17),
              "Elf Feat",
              "Elf Heritage",
              "Elves combine otherworldly grace, sharp intellect, and mysterious charm in a way that is practically magnetic to members of other ancestries. They are often voraciously intellectual, though their studies delve into a level of detail that most shorter-lived peoples find excessive or inefficient. Valuing kindness and beauty, elves ever strive to improve their manners, appearance, and culture.\n\nElves are often rather private people, stepped in the secrets of their groves and kinship groups. They’re slow to build friendships outside their kinsfolk, but for a specific reason: they subtly and deeply attune to their environment and their companions. There’s a physical element to this attunement, but it isn’t only superficial. Elves who spend their lives among shorter-lived peoples often develop a skewed perception of their own mortality and tend to become morose after watching generation after generation of companions age and die. These elves are called the Forlorn.",
              List.of(LanguageEnum.COMMON, LanguageEnum.ELVEN),
              0,
              List.of(),
              List.of("Low-Light Vision"),
              List.of("Elf", "Humanoid"),
              CreatureSizeEnum.MEDIUM,
              30,
              SourceEnum.CORE_RULEBOOK,
              "https://glasstopgames.com/pathfinder2/ancestry/elf.html"
      );
   }
}
