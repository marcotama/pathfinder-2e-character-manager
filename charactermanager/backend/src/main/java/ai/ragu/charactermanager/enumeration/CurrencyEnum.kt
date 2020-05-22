package ai.ragu.charactermanager.enumeration

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import java.util.*

enum class CurrencyEnum(private val value: String) {
    CP("cp"),
    SP("sp"),
    GP("gp"),
    PP("pp");

    companion object {
        private val CONSTANTS: MutableMap<String, CurrencyEnum> = HashMap()

        @JsonCreator
        fun fromValue(value: String?): CurrencyEnum {
            val constant = CONSTANTS[value]
            return constant ?: throw IllegalArgumentException(value)
        }

        fun getValueInCP(currency: CurrencyEnum): Int {
            return when (currency) {
                CP -> 1
                SP -> 10
                GP -> 100
                PP -> 1000
            }
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