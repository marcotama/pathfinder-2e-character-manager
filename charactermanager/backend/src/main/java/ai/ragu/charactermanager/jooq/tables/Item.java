/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables;


import ai.ragu.charactermanager.jooq.Keys;
import ai.ragu.charactermanager.jooq.Public;
import ai.ragu.charactermanager.jooq.tables.records.ItemRecord;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row18;
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
public class Item extends TableImpl<ItemRecord> {

    private static final long serialVersionUID = 2133372587;

    /**
     * The reference instance of <code>public.item</code>
     */
    public static final Item ITEM = new Item();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ItemRecord> getRecordType() {
        return ItemRecord.class;
    }

    /**
     * The column <code>public.item.id</code>.
     */
    public final TableField<ItemRecord, String> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.item.category</code>.
     */
    public final TableField<ItemRecord, String> CATEGORY = createField(DSL.name("category"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.item.name</code>.
     */
    public final TableField<ItemRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.item.level</code>.
     */
    public final TableField<ItemRecord, Short> LEVEL = createField(DSL.name("level"), org.jooq.impl.SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>public.item.actions</code>.
     */
    public final TableField<ItemRecord, Short> ACTIONS = createField(DSL.name("actions"), org.jooq.impl.SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>public.item.price</code>.
     */
    public final TableField<ItemRecord, BigDecimal> PRICE = createField(DSL.name("price"), org.jooq.impl.SQLDataType.NUMERIC(8, 2), this, "");

    /**
     * The column <code>public.item.hands</code>.
     */
    public final TableField<ItemRecord, String> HANDS = createField(DSL.name("hands"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.item.bulk</code>.
     */
    public final TableField<ItemRecord, String> BULK = createField(DSL.name("bulk"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.item.contains</code>.
     */
    public final TableField<ItemRecord, String> CONTAINS = createField(DSL.name("contains"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.item.usage</code>.
     */
    public final TableField<ItemRecord, String> USAGE = createField(DSL.name("usage"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.item.amount</code>.
     */
    public final TableField<ItemRecord, String> AMOUNT = createField(DSL.name("amount"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.item.action0</code>.
     */
    public final TableField<ItemRecord, String> ACTION0 = createField(DSL.name("action0"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.item.action0desc</code>.
     */
    public final TableField<ItemRecord, String> ACTION0DESC = createField(DSL.name("action0desc"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.item.action1</code>.
     */
    public final TableField<ItemRecord, String> ACTION1 = createField(DSL.name("action1"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.item.action1desc</code>.
     */
    public final TableField<ItemRecord, String> ACTION1DESC = createField(DSL.name("action1desc"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.item.description</code>.
     */
    public final TableField<ItemRecord, String> DESCRIPTION = createField(DSL.name("description"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.item.src</code>.
     */
    public final TableField<ItemRecord, String> SRC = createField(DSL.name("src"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.item.url</code>.
     */
    public final TableField<ItemRecord, String> URL = createField(DSL.name("url"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * Create a <code>public.item</code> table reference
     */
    public Item() {
        this(DSL.name("item"), null);
    }

    /**
     * Create an aliased <code>public.item</code> table reference
     */
    public Item(String alias) {
        this(DSL.name(alias), ITEM);
    }

    /**
     * Create an aliased <code>public.item</code> table reference
     */
    public Item(Name alias) {
        this(alias, ITEM);
    }

    private Item(Name alias, Table<ItemRecord> aliased) {
        this(alias, aliased, null);
    }

    private Item(Name alias, Table<ItemRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Item(Table<O> child, ForeignKey<O, ItemRecord> key) {
        super(child, key, ITEM);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<ItemRecord> getPrimaryKey() {
        return Keys.ITEM_PKEY;
    }

    @Override
    public List<UniqueKey<ItemRecord>> getKeys() {
        return Arrays.<UniqueKey<ItemRecord>>asList(Keys.ITEM_PKEY);
    }

    @Override
    public List<ForeignKey<ItemRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ItemRecord, ?>>asList(Keys.ITEM__ITEM_SRC_FKEY);
    }

    public RulesSource rulesSource() {
        return new RulesSource(this, Keys.ITEM__ITEM_SRC_FKEY);
    }

    @Override
    public Item as(String alias) {
        return new Item(DSL.name(alias), this);
    }

    @Override
    public Item as(Name alias) {
        return new Item(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Item rename(String name) {
        return new Item(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Item rename(Name name) {
        return new Item(name, null);
    }

    // -------------------------------------------------------------------------
    // Row18 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row18<String, String, String, Short, Short, BigDecimal, String, String, String, String, String, String, String, String, String, String, String, String> fieldsRow() {
        return (Row18) super.fieldsRow();
    }
}
