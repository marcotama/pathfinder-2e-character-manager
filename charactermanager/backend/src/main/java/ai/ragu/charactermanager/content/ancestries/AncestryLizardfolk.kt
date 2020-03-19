package ai.ragu.charactermanager.content.ancestries

import ai.ragu.charactermanager.dto.AncestryDto
import ai.ragu.charactermanager.enumeration.AbilityScoreEnum
import ai.ragu.charactermanager.enumeration.CreatureSizeEnum
import ai.ragu.charactermanager.enumeration.LanguageEnum
import ai.ragu.charactermanager.enumeration.SourceEnum

class AncestryLizardfolk : AncestryDto(
        "Ancestry:Lizardfolk",
        "Lizardfolk",
        8,
        Set.of(AbilityScoreEnum.STR, AbilityScoreEnum.WIS),
        1,
        Set.of(AbilityScoreEnum.INT),
        List.of<Int>(1, 5, 9, 13, 17),
        "Lizardfolk Feat",
        "Lizardfolk Heritage",
        "Lizardfolk move through the societies of other humanoids with the steely reserve of born predators. They have a well-deserved reputation as outstanding rangers and unsentimental fighters. Though lizardfolk have adapted to many different environments, many of them still prefer to remain near bodies of water, using their ability to hold their breath to their advantage. As a result, lizardfolk usually prefer equipment that is not easily damaged by moisture, eschewing leather and metal for gear made of stone, ivory, glass, and bone.",
        List.of(LanguageEnum.COMMON, LanguageEnum.IRUXI),
        0,
        List.of<String>(),
        List.of<String>("Claws", "Aquatic Adaptation"),
        List.of<String>("Lizardfolk", "Humanoid"),
        CreatureSizeEnum.MEDIUM,
        25,
        SourceEnum.LOST_OMENS,
        "https://glasstopgames.com/pathfinder2/ancestry/lizardfolk.html"
)