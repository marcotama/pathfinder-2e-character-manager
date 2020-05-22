package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class TwoHandWeaponTraitEnum(private val value: String) : WeaponTraitEnum {
    TWO_HAND_D8(String.format("twoHand_%s", DieEnum.D8)),
    TWO_HAND_D10(String.format("twoHand_%s", DieEnum.D10)),
    TWO_HAND_D12(String.format("twoHand_%s", DieEnum.D12));

    companion object {
        private val CONSTANTS: MutableMap<String, TwoHandWeaponTraitEnum> = HashMap()

        @JsonCreator
        fun fromValue(value: String?): TwoHandWeaponTraitEnum {
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