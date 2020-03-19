package ai.ragu.charactermanager.content.ancestries

import ai.ragu.charactermanager.dto.AncestryDto
import ai.ragu.charactermanager.enumeration.AbilityScoreEnum
import ai.ragu.charactermanager.enumeration.CreatureSizeEnum
import ai.ragu.charactermanager.enumeration.LanguageEnum
import ai.ragu.charactermanager.enumeration.SourceEnum

class AncestryGoblin : AncestryDto(
        "Ancestry:Goblin",
        "Goblin",
        6,
        Set.of(AbilityScoreEnum.DEX, AbilityScoreEnum.CHA),
        1,
        Set.of(AbilityScoreEnum.WIS),
        List.of<Int>(1, 5, 9, 13, 17),
        "Goblin Feat",
        "Goblin Heritage",
        "Goblins have a reputation as simple creatures who love songs, fire, and eating disgusting things and who hate reading, dogs, and horses—and there are a great many for whom this description fits perfectly. However, great changes have come to goblinkind, and more and more goblins resist conformity to these stereotypes. Even among goblins that are more worldly, many still exemplify their old ways in some small manner, just to a more sensible degree. Some goblins remain deeply fascinated with fire or fearlessly devour a meal that might turn others’ stomachs. Others are endless tinkerers and view their companions’ trash as the components of gadgets yet to be made.\n\nThough goblins’ culture has splintered radically, their reputation has changed little. As such, goblins who travel to larger cities are frequently subjected to derision, and many work twice as hard at proving their worth.",
        List.of(LanguageEnum.COMMON, LanguageEnum.GOBLIN),
        0,
        List.of<String>(),
        List.of<String>("Darkvision"),
        List.of<String>("Goblin", "Humanoid"),
        CreatureSizeEnum.SMALL,
        25,
        SourceEnum.CORE_RULEBOOK,
        "https://glasstopgames.com/pathfinder2/ancestry/goblin.html"
)