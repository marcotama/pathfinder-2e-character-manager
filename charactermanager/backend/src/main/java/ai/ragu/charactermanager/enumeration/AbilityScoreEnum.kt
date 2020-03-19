package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class AbilityScoreEnum(private val value: String) : WeaponTraitEnum {
    STR("str"), DEX("dex"), CON("con"), INT("int"), WIS("wis"), CHA("cha");

    companion object {
        private val CONSTANTS: MutableMap<String, AbilityScoreEnum> = HashMap()
        @JsonCreator
        fun fromValue(value: String?): AbilityScoreEnum {
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