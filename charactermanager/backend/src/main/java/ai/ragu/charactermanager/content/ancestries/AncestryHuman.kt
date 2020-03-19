package ai.ragu.charactermanager.content.ancestries

import ai.ragu.charactermanager.dto.AncestryDto
import ai.ragu.charactermanager.enumeration.CreatureSizeEnum
import ai.ragu.charactermanager.enumeration.LanguageEnum
import ai.ragu.charactermanager.enumeration.SourceEnum

class AncestryHuman : AncestryDto(
        "Ancestry:Human",
        "Human",
        8,
        Set.of(),
        2,
        Set.of(),
        List.of<Int>(1, 5, 9, 13, 17),
        "Human Feat",
        "Human Heritage",
        "Humans’ ambition, versatility, and exceptional potential have led to their status as the world’s predominant ancestry. Their empires and nations are vast, sprawling things, and their citizens carve names for themselves with the strength of their sword arms and the power of their spells. Humanity is diverse and tumultuous, running the gamut from nomadic to imperial, sinister to saintly. Many of them venture forth to explore, to map the expanse of the multiverse, to search for long-lost treasure, or to lead mighty armies to conquer their neighbors—for no better reason than because they can.",
        List.of(LanguageEnum.COMMON),
        0,
        List.of<String>(),
        List.of<String>("Low-Light Vision", "Plant Nourishment"),
        List.of<String>("Human", "Humanoid"),
        CreatureSizeEnum.MEDIUM,
        25,
        SourceEnum.CORE_RULEBOOK,
        "https://glasstopgames.com/pathfinder2/ancestry/human.html"
)