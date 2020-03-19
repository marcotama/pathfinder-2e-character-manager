package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class ClassEnum(private val value: String) : WeaponTraitEnum {
    ALCHEMIST("alchemist"), BARBARIAN("barbarian"), BARD("bard"), CHAMPION("champion"), CLERIC("cleric"), DRUID("druid"), FIGHTER("fighter"), MONK("monk"), RANGER("ranger"), ROGUE("rogue"), SORCERER("sorcerer"), WIZARD("wizard");

    companion object {
        private val CONSTANTS: MutableMap<String, ClassEnum> = HashMap()
        @JsonCreator
        fun fromValue(value: String?): ClassEnum {
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