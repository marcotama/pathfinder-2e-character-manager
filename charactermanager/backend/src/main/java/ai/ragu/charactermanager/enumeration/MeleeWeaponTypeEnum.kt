package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class MeleeWeaponTypeEnum(private val value: String) : AttackProficiencyEnum {
    SWORD("sword"), SPEAR("spear"), HAMMER("hammer"), POLEARM("polearm"), KNIFE("knife"), CLUB("club"), FLAIL("flail"), BRAWLING("brawling"), AXE("axe"), PICK("pick"), SHIELD("shield"), WHIP("whip");

    companion object {
        private val CONSTANTS: MutableMap<String, MeleeWeaponTypeEnum> = HashMap()
        @JsonCreator
        fun fromValue(value: String?): MeleeWeaponTypeEnum {
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