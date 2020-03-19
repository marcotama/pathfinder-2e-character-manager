package ai.ragu.charactermanager.enumeration

import ai.ragu.charactermanager.dto.ItemDto
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import java.io.FileNotFoundException
import java.lang.invoke.MethodHandles
import java.util.*

class InventoryItemEnum internal constructor(private val value: ItemDto) {

    companion object {
        private val logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass())
        private const val JSON_PATH = "alchemicalItems.json"
        private val CONSTANTS: MutableMap<String, ItemDto> = HashMap()
        fun values(): Array<ItemDto> {
            return ArrayList(CONSTANTS.values).toTypedArray()
        }

        @JsonCreator
        fun fromValue(value: String?): ItemDto {
            val constant = CONSTANTS[value]
            return constant ?: throw IllegalArgumentException(value)
        }

        init {
            try {
                InventoryItemEnum::class.java.classLoader.getResourceAsStream(JSON_PATH).use { fileStream ->
                    if (fileStream != null) {
                        val objectMapper = ObjectMapper()
                        val items: Array<ItemDto> = ai.ragu.charactermanager.enumeration.objectMapper.readValue(fileStream, Array<ItemDto>::class.java)
                        logger.info("Alchemical items JSON file loaded")
                        for (item in ai.ragu.charactermanager.enumeration.items) {
                            CONSTANTS[ai.ragu.charactermanager.enumeration.item.getCode()] = ai.ragu.charactermanager.enumeration.item
                        }
                    } else {
                        throw FileNotFoundException("Could not find alchemical items resource file")
                    }
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
                System.exit(0)
            }
        }
    }

    override fun toString(): String {
        return value.code
    }

    @JsonValue
    fun value(): ItemDto {
        return value
    }

}