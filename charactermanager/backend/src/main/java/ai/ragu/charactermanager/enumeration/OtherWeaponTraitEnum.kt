package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class OtherWeaponTraitEnum(private val value: String) : WeaponTraitEnum {
    AGILE("agile"), FINESSE("finesse"), FREE_HAND("freeHand"), SHOVE("shove"), REACH("reach"), TRIP("trip"), PARRY("parry"), SWEEP("sweep"), FORCEFUL("forceful"), BACKSWING("backswing"), NONLETHAL("nonlethal"), ATTACHED_TO_SHIELD("attachedToShield"), BACKSTABBER("backstabber"), TWIN("twin");

    companion object {
        private val CONSTANTS: MutableMap<String, OtherWeaponTraitEnum> = HashMap()
        @JsonCreator
        fun fromValue(value: String?): OtherWeaponTraitEnum {
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