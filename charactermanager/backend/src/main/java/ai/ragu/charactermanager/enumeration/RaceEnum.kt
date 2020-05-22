package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class RaceEnum(private val value: String) : WeaponTraitEnum {
    DWARF("dwarf"),
    ELF("elf"),
    GNOME("gnome"),
    GOBLIN("goblin"),
    HALFLING("halfling"),
    HUMAN("human");

    companion object {
        private val CONSTANTS: MutableMap<String, RaceEnum> = HashMap()

        @JsonCreator
        fun fromValue(value: String?): RaceEnum {
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