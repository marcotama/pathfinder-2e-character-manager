package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class ThrownWeaponTraitEnum(private val value: Int) : WeaponTraitEnum {
    THROWN_10FT(10), THROWN_20FT(20);

    companion object {
        private val CONSTANTS: MutableMap<Int, ThrownWeaponTraitEnum> = HashMap()

        @JsonCreator
        fun fromValue(value: Int): ThrownWeaponTraitEnum {
            val constant = CONSTANTS[value]
            return constant ?: throw IllegalArgumentException(value.toString())
        }

        init {
            for (c in values()) {
                CONSTANTS[c.value] = c
            }
        }
    }

    override fun toString(): String {
        return String.format("Thrown %d feet", value)
    }

    @JsonValue
    fun value(): Int {
        return value
    }

}