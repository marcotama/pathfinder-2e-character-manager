package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class JoustingWeaponTraitEnum(private val value: String) : WeaponTraitEnum {
    JOUSTING_D6(String.format("jousting_%s", DieEnum.D6));

    companion object {
        private val CONSTANTS: MutableMap<String, JoustingWeaponTraitEnum> = HashMap()
        @JsonCreator
        fun fromValue(value: String?): JoustingWeaponTraitEnum {
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