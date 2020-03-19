package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class MagicalDamageTypeEnum(private val value: String) : DamageTypeEnum {
    ACID("acid"), AIR("air"), COLD("cold"), EARTH("earth"), ELECTRICITY("electricity"), FIRE("fire"), WATER("water");

    companion object {
        private val CONSTANTS: MutableMap<String, MagicalDamageTypeEnum> = HashMap()
        @JsonCreator
        fun fromValue(value: String?): MagicalDamageTypeEnum {
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