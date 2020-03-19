package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class ItemBulkEnum(private val value: String) : WeaponTraitEnum {
    SMALL("S"), MEDIUM("M"), LARGE("L"), TWO("2");

    companion object {
        private val CONSTANTS: MutableMap<String, ItemBulkEnum> = HashMap()
        @JsonCreator
        fun fromValue(value: String?): ItemBulkEnum {
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