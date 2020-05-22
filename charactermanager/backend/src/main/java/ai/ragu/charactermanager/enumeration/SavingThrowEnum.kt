package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class SavingThrowEnum(private val value: String) {
    FORTITUDE("fortitude"),
    REFLEX("reflex"),
    WILL("will");

    companion object {
        private val CONSTANTS: MutableMap<String, SavingThrowEnum> = HashMap()

        @JsonCreator
        fun fromValue(value: String?): SavingThrowEnum {
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