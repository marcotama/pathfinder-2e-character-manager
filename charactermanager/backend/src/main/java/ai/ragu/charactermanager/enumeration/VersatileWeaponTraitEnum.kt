package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class VersatileWeaponTraitEnum(private val value: String) : WeaponTraitEnum {
    VERSATILE_S(String.format("versatile_%s", PhysicalDamageTypeEnum.SLASHING)), VERSATILE_P(String.format("versatile_%s", PhysicalDamageTypeEnum.PIERCING)), VERSATILE_B(String.format("versatile_%s", PhysicalDamageTypeEnum.BLUDGEONING));

    companion object {
        private val CONSTANTS: MutableMap<String, VersatileWeaponTraitEnum> = HashMap()
        @JsonCreator
        fun fromValue(value: String?): VersatileWeaponTraitEnum {
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