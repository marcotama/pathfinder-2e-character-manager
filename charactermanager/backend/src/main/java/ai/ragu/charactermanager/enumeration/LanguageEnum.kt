package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class LanguageEnum(private val value: String) {
    AQUAN("aquan"), BOGGARD("boggard"), COMMON("common"), CELESTIAL("celestial"), DWARVEN("dwarven"), DRACONIC("draconic"), ELVEN("elven"), GNOMISH("gnomish"), GNOLL("gnoll"), GOBLIN("goblin"), HALFLING("halfling"), IRUXI("iruxi"), JOTUN("jotun"), ORCISH("orcish"), SYLVAN("sylvan"), TERRAN("terran"), UNDERCOMMON("undercommon");

    companion object {
        private val CONSTANTS: MutableMap<String, LanguageEnum> = HashMap()
        @JsonCreator
        fun fromValue(value: String?): LanguageEnum {
            val constant = CONSTANTS[value]
            return constant ?: throw IllegalArgumentException(value)
        }

        init {
            for (c in values()) {
                CONSTANTS[ai.ragu.charactermanager.enumeration.c.value] = ai.ragu.charactermanager.enumeration.c
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