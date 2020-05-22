package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class CreatureSizeEnum(private val value: String) : WeaponTraitEnum {
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large");

    companion object {
        private val CONSTANTS: MutableMap<String, CreatureSizeEnum> = HashMap()

        @JsonCreator
        fun fromValue(value: String?): CreatureSizeEnum {
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