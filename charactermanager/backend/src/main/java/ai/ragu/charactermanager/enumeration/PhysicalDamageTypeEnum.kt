package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class PhysicalDamageTypeEnum(private val value: String) : DamageTypeEnum {
    BLUDGEONING("bludgeoning"),
    PIERCING("piercing"),
    SLASHING("slashing");

    companion object {
        private val CONSTANTS: MutableMap<String, PhysicalDamageTypeEnum> = HashMap()

        @JsonCreator
        fun fromValue(value: String?): PhysicalDamageTypeEnum {
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