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
    tags: Array<String>;
    usage: Array<String>;
    activate: ItemActivationEnum;
    num_actions: number;
    bulk: ItemBulkEnum;
    description: String;
    types: Array<InventoryItemTypeData>;
}

import alchemicalItemsJson from "./alchemical_items.json";
import {plainToClass} from "class-transformer";
import {Amount} from "./structures";
let alchemicalItemsData = plainToClass(InventoryItemData, alchemicalItemsJson);