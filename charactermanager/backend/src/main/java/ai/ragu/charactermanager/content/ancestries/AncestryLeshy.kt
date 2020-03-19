package ai.ragu.charactermanager.content.ancestries

import ai.ragu.charactermanager.dto.AncestryDto
import ai.ragu.charactermanager.enumeration.AbilityScoreEnum
import ai.ragu.charactermanager.enumeration.CreatureSizeEnum
import ai.ragu.charactermanager.enumeration.LanguageEnum
import ai.ragu.charactermanager.enumeration.SourceEnum

class AncestryLeshy : AncestryDto(
        "Ancestry:Leshy",
        "Leshy",
        8,
        Set.of(AbilityScoreEnum.CON, AbilityScoreEnum.WIS),
        1,
        Set.of(AbilityScoreEnum.INT),
        List.of<Int>(1, 5, 9, 13, 17),
        "Leshy Feat",
        "Leshy Heritage",
        "Leshies are “born” when a skilled druid or other master of primal magic conducts a ritual to create a suitable vessel, and then a spirit chooses that vessel to be their temporary home. Leshies are self-sufficient from the moment the ritual ends, and so they do not depend upon these druids for care, though it is not uncommon for leshies to maintain lifelong bonds with their creators.\n\nNot all leshies have a strong enough spirit to strike off completely on their own, however. Weaker nature spirits can form only tenuous bonds that are just strong enough to animate Tiny bodies. These spirits become leshy familiars, acting as companions to their druid creators. Independent leshies are often protective of such leshy familiars, advocating for them to be treated with dignity and respect.",
        List.of(LanguageEnum.COMMON, LanguageEnum.SYLVAN),
        2,
        List.of<String>(),
        List.of<String>("Low-Light Vision", "Plant Nourishment"),
        List.of<String>("Leshy", "Plant", "Small"),
        CreatureSizeEnum.SMALL,
        25,
        SourceEnum.LOST_OMENS,
        "https://glasstopgames.com/pathfinder2/ancestry/leshy.html"
)