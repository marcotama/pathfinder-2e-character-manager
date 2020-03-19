package ai.ragu.charactermanager.content.ancestries

import ai.ragu.charactermanager.dto.AncestryDto
import ai.ragu.charactermanager.enumeration.AbilityScoreEnum
import ai.ragu.charactermanager.enumeration.CreatureSizeEnum
import ai.ragu.charactermanager.enumeration.LanguageEnum
import ai.ragu.charactermanager.enumeration.SourceEnum

class AncestryHobgoblin : AncestryDto(
        "Ancestry:Hobgoblin",
        "Hobgoblin",
        8,
        Set.of(AbilityScoreEnum.CON, AbilityScoreEnum.INT),
        1,
        Set.of(AbilityScoreEnum.WIS),
        List.of<Int>(1, 5, 9, 13, 17),
        "Hobgoblin Feat",
        "Hobgoblin Heritage",
        "The reputation of hobgoblins in the Inner Sea region has been upended by Oprak, the hobgoblin nation established recently in the mountains between Nidal and Nirmathas. The Ironfang Legion that stormed through Molthune and Nirmathas only a few years ago made a calculated decision to cease fighting, claim Oprak as a new homeland, and seek peace with its neighbors. Now under strict orders to not start conflicts with other nations, the hobgoblins of Oprak have begun to cautiously investigate Avistan in the spirit of cooperation rather than conquest. Many people, especially those that suffered terrible cruelties under the Ironfang Legion, fear that this is simply a pause in aggression while Oprak gains enough strength to crush its rivals. Others hope these bold soldiers might prove to be allies against the endless hordes of the Whispering Tyrant.",
        List.of(LanguageEnum.COMMON, LanguageEnum.GOBLIN),
        0,
        List.of<String>(),
        List.of<String>("Darkvision"),
        List.of<String>("Goblin", "Humanoid"),
        CreatureSizeEnum.MEDIUM,
        25,
        SourceEnum.LOST_OMENS,
        "https://glasstopgames.com/pathfinder2/ancestry/hobgoblin.html"
)