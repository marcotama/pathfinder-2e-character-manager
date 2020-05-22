/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables;


import ai.ragu.charactermanager.jooq.Keys;
import ai.ragu.charactermanager.jooq.Public;
import ai.ragu.charactermanager.jooq.tables.records.WearableItemRecord;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row17;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class WearableItem extends TableImpl<WearableItemRecord> {

    private static final long serialVersionUID = 685543908;

    /**
     * The reference instance of <code>public.wearable_item</code>
     */
    public static final WearableItem WEARABLE_ITEM = new WearableItem();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<WearableItemRecord> getRecordType() {
        return WearableItemRecord.class;
    }

    /**
     * The column <code>public.wearable_item.id</code>.
     */
    public final TableField<WearableItemRecord, String> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.wearable_item.name</code>.
     */
    public final TableField<WearableItemRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.wearable_item.level</code>.
     */
    public final TableField<WearableItemRecord, String> LEVEL = createField(DSL.name("level"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.wearable_item.actions</code>.
     */
    public final TableField<WearableItemRecord, String> ACTIONS = createField(DSL.name("actions"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.wearable_item.price</code>.
     */
    public final TableField<WearableItemRecord, BigDecimal> PRICE = createField(DSL.name("price"), org.jooq.impl.SQLDataType.NUMERIC(8, 2), this, "");

    /**
     * The column <code>public.wearable_item.hands</code>.
     */
    public final TableField<WearableItemRecord, String> HANDS = createField(DSL.name("hands"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.wearable_item.bulk</code>.
     */
    public final TableField<WearableItemRecord, String> BULK = createField(DSL.name("bulk"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.wearable_item.contains</code>.
     */
    public final TableField<WearableItemRecord, String> CONTAINS = createField(DSL.name("contains"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.wearable_item.usage</code>.
     */
    public final TableField<WearableItemRecord, String> USAGE = createField(DSL.name("usage"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.wearable_item.amount</code>.
     */
    public final TableField<WearableItemRecord, String> AMOUNT = createField(DSL.name("amount"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.wearable_item.action0</code>.
     */
    public final TableField<WearableItemRecord, String> ACTION0 = createField(DSL.name("action0"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.wearable_item.action0desc</code>.
     */
    public final TableField<WearableItemRecord, String> ACTION0DESC = createField(DSL.name("action0desc"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.wearable_item.action1</code>.
     */
    public final TableField<WearableItemRecord, String> ACTION1 = createField(DSL.name("action1"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.wearable_item.action1desc</code>.
     */
    public final TableField<WearableItemRecord, String> ACTION1DESC = createField(DSL.name("action1desc"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.wearable_item.description</code>.
     */
    public final TableField<WearableItemRecord, String> DESCRIPTION = createField(DSL.name("description"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.wearable_item.src</code>.
     */
    public final TableField<WearableItemRecord, String> SRC = createField(DSL.name("src"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.wearable_item.url</code>.
     */
    public final TableField<WearableItemRecord, String> URL = createField(DSL.name("url"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * Create a <code>public.wearable_item</code> table reference
     */
    public WearableItem() {
        this(DSL.name("wearable_item"), null);
    }

    /**
     * Create an aliased <code>public.wearable_item</code> table reference
     */
    public WearableItem(String alias) {
        this(DSL.name(alias), WEARABLE_ITEM);
    }

    /**
     * Create an aliased <code>public.wearable_item</code> table reference
     */
    public WearableItem(Name alias) {
        this(alias, WEARABLE_ITEM);
    }

    private WearableItem(Name alias, Table<WearableItemRecord> aliased) {
        this(alias, aliased, null);
    }

    private WearableItem(Name alias, Table<WearableItemRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> WearableItem(Table<O> child, ForeignKey<O, WearableItemRecord> key) {
        super(child, key, WEARABLE_ITEM);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<WearableItemRecord> getPrimaryKey() {
        return Keys.WEARABLE_ITEM_PKEY;
    }

    @Override
    public List<UniqueKey<WearableItemRecord>> getKeys() {
        return Arrays.<UniqueKey<WearableItemRecord>>asList(Keys.WEARABLE_ITEM_PKEY);
    }

    @Override
    public List<ForeignKey<WearableItemRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<WearableItemRecord, ?>>asList(Keys.WEARABLE_ITEM__WEARABLE_ITEM_SRC_FKEY);
    }

    public RulesSource rulesSource() {
        return new RulesSource(this, Keys.WEARABLE_ITEM__WEARABLE_ITEM_SRC_FKEY);
    }

    @Override
    public WearableItem as(String alias) {
        return new WearableItem(DSL.name(alias), this);
    }

    @Override
    public WearableItem as(Name alias) {
        return new WearableItem(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public WearableItem rename(String name) {
        return new WearableItem(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public WearableItem rename(Name name) {
        return new WearableItem(name, null);
    }

    // -------------------------------------------------------------------------
    // Row17 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row17<String, String, String, String, BigDecimal, String, String, String, String, String, String, String, String, String, String, String, String> fieldsRow() {
        return (Row17) super.fieldsRow();
    }
}