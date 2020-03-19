package ai.ragu.charactermanager.content.ancestries

import ai.ragu.charactermanager.dto.AncestryDto
import ai.ragu.charactermanager.enumeration.AbilityScoreEnum
import ai.ragu.charactermanager.enumeration.CreatureSizeEnum
import ai.ragu.charactermanager.enumeration.LanguageEnum
import ai.ragu.charactermanager.enumeration.SourceEnum

class AncestryGnome : AncestryDto(
        "Ancestry:Gnome",
        "Gnome",
        8,
        Set.of(AbilityScoreEnum.CON, AbilityScoreEnum.CHA),
        1,
        Set.of(AbilityScoreEnum.STR),
        List.of<Int>(1, 5, 9, 13, 17),
        "Gnome Feat",
        "Gnome Heritage",
        "Always hungry for new experiences, gnomes constantly wander both mentally and physically, attempting to stave off a terrible ailment that threatens all of their people. This affliction—the Bleaching—strikes gnomes who fail to dream, innovate, and take in new experiences, in the gnomes’ absence of crucial magical essence from the First World. Gnomes latch onto a source of localized magic where they live, typically primal magic, as befits their fey lineage, but this isn’t enough to avoid the Bleaching unless they supplement this magic with new experiences. The Bleaching slowly drains the color—literally—from gnomes, and it plunges those affected into states of deep depression that eventually claim their lives. Very few gnomes survive this scourge, becoming deeply morose and wise survivors known as bleachlings.",
        List.of(LanguageEnum.COMMON, LanguageEnum.GNOMISH, LanguageEnum.SYLVAN),
        0,
        List.of<String>(),
        List.of<String>("Low-Light Vision"),
        List.of<String>("Gnome", "Humanoid"),
        CreatureSizeEnum.SMALL,
        25,
        SourceEnum.CORE_RULEBOOK,
        "https://glasstopgames.com/pathfinder2/ancestry/gnome.html"
)