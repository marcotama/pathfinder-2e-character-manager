package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class FatalWeaponTraitEnum(private val value: String) : WeaponTraitEnum {
    FATAL_D8(String.format("fatal_%s", DieEnum.D8)), FATAL_D10(String.format("fatal_%s", DieEnum.D10)), FATAL_D12(String.format("fatal_%s", DieEnum.D12));

    companion object {
        private val CONSTANTS: MutableMap<String, FatalWeaponTraitEnum> = HashMap()
        @JsonCreator
        fun fromValue(value: String?): FatalWeaponTraitEnum {
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