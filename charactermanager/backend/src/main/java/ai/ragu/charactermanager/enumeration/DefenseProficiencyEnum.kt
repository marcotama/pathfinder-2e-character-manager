package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class DefenseProficiencyEnum(private val value: String) {
    UNARMORED_DEFENSE("unarmoredDefense"), LIGHT_ARMOR("lightArmor"), MEDIUM_ARMOR("mediumArmor"), HEAVY_ARMOR("heavyArmor");

    companion object {
        private val CONSTANTS: MutableMap<String, DefenseProficiencyEnum> = HashMap()
        @JsonCreator
        fun fromValue(value: String?): DefenseProficiencyEnum {
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