package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class ItemCategoryEnum(private val value: String) {
    LIGHT("light"), MEDIUM("medium"), HEAVY("heavy");

    companion object {
        private val CONSTANTS: MutableMap<String, ItemCategoryEnum> = HashMap()
        @JsonCreator
        fun fromValue(value: String?): ItemCategoryEnum {
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