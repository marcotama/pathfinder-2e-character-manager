package ai.ragu.charactermanager.enumeration;

import ai.ragu.charactermanager.dto.ItemDto;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class InventoryItemEnum {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final String JSON_PATH = "alchemicalItems.json";

    private final ItemDto value;
    private final static Map<String, ItemDto> CONSTANTS = new HashMap<>();

    static {
        try (InputStream fileStream = InventoryItemEnum.class.getClassLoader().getResourceAsStream(JSON_PATH)) {
            if (fileStream != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                ItemDto[] items = objectMapper.readValue(fileStream, ItemDto[].class);
                logger.info("Alchemical items JSON file loaded");
                for (ItemDto item : items) {
                    CONSTANTS.put(item.getCode(), item);
                }
            } else {
                throw new FileNotFoundException("Could not find alchemical items resource file");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(0);
        }
    }

    InventoryItemEnum(ItemDto value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value.getCode();
    }

    public static ItemDto[] values() {
        return new ArrayList<>(CONSTANTS.values()).toArray(new ItemDto[0]);
    }

    @JsonValue
    public ItemDto value() {
        return this.value;
    }

    @JsonCreator
    public static ItemDto fromValue(String value) {
        ItemDto constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
