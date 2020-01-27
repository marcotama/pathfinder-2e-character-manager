import {InventoryItemEnum, ItemActivationEnum, ItemBulkEnum} from "./enums";

export class InventoryItemTypeData {
    code: InventoryItemEnum;
    name: String;
    type: String;
    level: number;
    price: Amount;
    description: String;
}

export class InventoryItemData {
    code: String;
    name: String;
    usage: Array<String>;
    activate: ItemActivationEnum;
    bulk: ItemBulkEnum;
    tags: Array<String>;
    description: String;
    types: Array<InventoryItemTypeData>;
}

import alchemicalBombItemsJson from "./alchemical_items.json";
import {plainToClass} from "class-transformer";
import {Amount} from "./structures";
let alchemicalBombItemsData = plainToClass(InventoryItemData, alchemicalBombItemsJson);