package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class SkillEnum(private val value: String) {
    ACROBATICS("acrobatics"),
    ARCANA("arcana"),
    ATHLETICS("athletics"),
    CRAFTING("crafting"),
    DECEPTION("deception"),
    DIPLOMACY("diplomacy"),
    INTIMIDATION("intimidation"),
    MEDICINE("medicine"),
    NATURE("nature"),
    OCCULTISM("occultism"),
    PERFORMANCE("performance"),
    RELIGION("religion"),
    SOCIETY("society"),
    STEALTH("stealth"),
    SURVIVAL("survival"),
    THIEVERY("thievery"),
    LORE("lore");

    companion object {
        private val CONSTANTS: MutableMap<String, SkillEnum> = HashMap()

        @JsonCreator
        fun fromValue(value: String?): SkillEnum {
            val constant = CONSTANTS[value]
            return constant ?: throw IllegalArgumentException(value)
        }

        init {
            for (c in values()) {
                CONSTANTS[c.value] = c
            }
        }
    }

    override fun toString(): String {
        return value
    }

    @JsonValue
    fun value(): String {
        return value
    }

}