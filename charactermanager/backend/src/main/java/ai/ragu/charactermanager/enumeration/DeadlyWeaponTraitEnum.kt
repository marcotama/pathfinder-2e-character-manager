package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class DeadlyWeaponTraitEnum(private val value: String) : WeaponTraitEnum {
    DEADLY_D6(String.format("deadly_%s", DieEnum.D6)), DEADLY_D8(String.format("deadly_%s", DieEnum.D8)), DEADLY_D10(String.format("deadly_%s", DieEnum.D10));

    companion object {
        private val CONSTANTS: MutableMap<String, DeadlyWeaponTraitEnum> = HashMap()
        @JsonCreator
        fun fromValue(value: String?): DeadlyWeaponTraitEnum {
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