/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables.records;


import ai.ragu.charactermanager.jooq.tables.WearableItemTrait;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class WearableItemTraitRecord extends UpdatableRecordImpl<WearableItemTraitRecord> implements Record2<String, String> {

    private static final long serialVersionUID = -1381674261;

    /**
     * Setter for <code>public.wearable_item_trait.wearable_item_id</code>.
     */
    public void setWearableItemId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.wearable_item_trait.wearable_item_id</code>.
     */
    public String getWearableItemId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.wearable_item_trait.trait</code>.
     */
    public void setTrait(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.wearable_item_trait.trait</code>.
     */
    public String getTrait() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return WearableItemTrait.WEARABLE_ITEM_TRAIT.WEARABLE_ITEM_ID;
    }

    @Override
    public Field<String> field2() {
        return WearableItemTrait.WEARABLE_ITEM_TRAIT.TRAIT;
    }

    @Override
    public String component1() {
        return getWearableItemId();
    }

    @Override
    public String component2() {
        return getTrait();
    }

    @Override
    public String value1() {
        return getWearableItemId();
    }

    @Override
    public String value2() {
        return getTrait();
    }

    @Override
    public WearableItemTraitRecord value1(String value) {
        setWearableItemId(value);
        return this;
    }

    @Override
    public WearableItemTraitRecord value2(String value) {
        setTrait(value);
        return this;
    }

    @Override
    public WearableItemTraitRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached WearableItemTraitRecord
     */
    public WearableItemTraitRecord() {
        super(WearableItemTrait.WEARABLE_ITEM_TRAIT);
    }

    /**
     * Create a detached, initialised WearableItemTraitRecord
     */
    public WearableItemTraitRecord(String wearableItemId, String trait) {
        super(WearableItemTrait.WEARABLE_ITEM_TRAIT);

        set(0, wearableItemId);
        set(1, trait);
    }
}