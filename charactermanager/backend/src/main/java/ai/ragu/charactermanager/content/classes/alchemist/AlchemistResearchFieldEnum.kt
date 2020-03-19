package ai.ragu.charactermanager.content.classes.alchemist

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class AlchemistResearchFieldEnum(private val value: String) {
    BOMBER("bomber"), CHIRURGEON("chirurgeon"), MUTAGENIST("mutagenist");

    companion object {
        private val CONSTANTS: MutableMap<String, AlchemistResearchFieldEnum> = HashMap()
        @JsonCreator
        fun fromValue(value: String?): AlchemistResearchFieldEnum {
            val constant = CONSTANTS[value]
            return constant ?: throw IllegalArgumentException(value)
        }

        init {
            for (c in values()) {
                CONSTANTS[ai.ragu.charactermanager.content.classes.alchemist.c.value] = ai.ragu.charactermanager.content.classes.alchemist.c
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