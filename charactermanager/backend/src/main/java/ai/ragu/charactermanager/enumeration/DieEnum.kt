package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class DieEnum(private val value: Int) {
    D4(4), D6(6), D8(8), D10(10), D12(12), D20(20), D100(100);

    companion object {
        private val CONSTANTS: MutableMap<Int, DieEnum> = HashMap()
        @JsonCreator
        fun fromValue(value: Int): DieEnum {
            val constant = CONSTANTS[value]
            return constant ?: throw IllegalArgumentException(value.toString())
        }

        init {
            for (c in values()) {
                CONSTANTS[ai.ragu.charactermanager.enumeration.c.value] = ai.ragu.charactermanager.enumeration.c
            }
        }
    }

    override fun toString(): String {
        return String.format("D%d", value)
    }

    @JsonValue
    fun value(): Int {
        return value
    }

}