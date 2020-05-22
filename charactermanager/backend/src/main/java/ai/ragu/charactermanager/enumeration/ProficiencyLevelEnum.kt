package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class ProficiencyLevelEnum(private val value: String) {
    UNTRAINED("untrained"),
    TRAINED("trained"),
    EXPERT("expert"),
    MASTER("master"),
    LEGENDARY("legendary");

    companion object {
        private val CONSTANTS: MutableMap<String, ProficiencyLevelEnum> = HashMap()

        @JsonCreator
        fun fromValue(value: String?): ProficiencyLevelEnum {
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

    val comparableValue: Int
        get() = when (this) {
            UNTRAINED -> 0
            TRAINED -> 1
            EXPERT -> 2
            MASTER -> 3
            LEGENDARY -> 4
            else -> throw IllegalArgumentException(String.format("Unknown proficiency level: %s", this))
        }

    val modifier: Int
        get() = when (this) {
            UNTRAINED -> 0
            TRAINED -> 2
            EXPERT -> 4
            MASTER -> 6
            LEGENDARY -> 8
            else -> throw IllegalArgumentException(String.format("Unknown proficiency level: %s", this))
        }

}