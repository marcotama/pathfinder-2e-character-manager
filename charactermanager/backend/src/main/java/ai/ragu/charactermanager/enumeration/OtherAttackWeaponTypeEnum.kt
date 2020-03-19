package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class OtherAttackWeaponTypeEnum(private val value: String) : AttackProficiencyEnum {
    UNARMED_ATTACKS("unarmedAttacks"), SIMPLE_WEAPONS("simpleWeapons"), MARTIAL_WEAPONS("martialWeapons"), ALCHEMICAL_BOMBS("alchemicalBombs");

    companion object {
        private val CONSTANTS: MutableMap<String, OtherAttackWeaponTypeEnum> = HashMap()
        @JsonCreator
        fun fromValue(value: String?): OtherAttackWeaponTypeEnum {
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