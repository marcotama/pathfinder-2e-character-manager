package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class ActivationEnum(private val value: String) {
    INTERACT("interact"),
    STRIKE("strike"),
    ONE_ACTION("oneAction"),
    ONE_OR_MORE_DAYS("oneOrMoreDays"),
    BULWARK("bulwark");

    companion object {
        private val CONSTANTS: MutableMap<String, ActivationEnum> = HashMap()

        @JsonCreator
        fun fromValue(value: String?): ActivationEnum {
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