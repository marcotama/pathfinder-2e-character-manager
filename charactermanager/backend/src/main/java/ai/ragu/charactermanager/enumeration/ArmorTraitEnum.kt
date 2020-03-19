package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class ArmorTraitEnum(private val value: String) {
    COMFORT("comfort"), FLEXIBLE("flexible"), NOISY("noisy"), BULWARK("bulwark");

    companion object {
        private val CONSTANTS: MutableMap<String, ArmorTraitEnum> = HashMap()
        @JsonCreator
        fun fromValue(value: String?): ArmorTraitEnum {
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