package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class SourceEnum(private val value: String) : WeaponTraitEnum {
    CORE_RULEBOOK("coreRulebook"), LOST_OMENS("lostOmensCharacterGuide");

    companion object {
        private val CONSTANTS: MutableMap<String, SourceEnum> = HashMap()
        @JsonCreator
        fun fromValue(value: String?): SourceEnum {
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