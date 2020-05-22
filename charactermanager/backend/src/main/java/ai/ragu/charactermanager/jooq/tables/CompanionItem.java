/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables;


import ai.ragu.charactermanager.jooq.Keys;
import ai.ragu.charactermanager.jooq.Public;
import ai.ragu.charactermanager.jooq.tables.records.CompanionItemRecord;

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
public class CompanionItem extends TableImpl<CompanionItemRecord> {

    private static final long serialVersionUID = 5190369;

    /**
     * The reference instance of <code>public.companion_item</code>
     */
    public static final CompanionItem COMPANION_ITEM = new CompanionItem();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CompanionItemRecord> getRecordType() {
        return CompanionItemRecord.class;
    }

    /**
     * The column <code>public.companion_item.id</code>.
     */
    public final TableField<CompanionItemRecord, String> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.companion_item.name</code>.
     */
    public final TableField<CompanionItemRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.companion_item.level</code>.
     */
    public final TableField<CompanionItemRecord, String> LEVEL = createField(DSL.name("level"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.companion_item.actions</code>.
     */
    public final TableField<CompanionItemRecord, String> ACTIONS = createField(DSL.name("actions"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.companion_item.price</code>.
     */
    public final TableField<CompanionItemRecord, String> PRICE = createField(DSL.name("price"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.companion_item.hands</code>.
     */
    public final TableField<CompanionItemRecord, String> HANDS = createField(DSL.name("hands"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.companion_item.bulk</code>.
     */
    public final TableField<CompanionItemRecord, String> BULK = createField(DSL.name("bulk"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.companion_item.contains</code>.
     */
    public final TableField<CompanionItemRecord, String> CONTAINS = createField(DSL.name("contains"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.companion_item.usage</code>.
     */
    public final TableField<CompanionItemRecord, String> USAGE = createField(DSL.name("usage"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.companion_item.amount</code>.
     */
    public final TableField<CompanionItemRecord, String> AMOUNT = createField(DSL.name("amount"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.companion_item.action0</code>.
     */
    public final TableField<CompanionItemRecord, String> ACTION0 = createField(DSL.name("action0"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.companion_item.action0desc</code>.
     */
    public final TableField<CompanionItemRecord, String> ACTION0DESC = createField(DSL.name("action0desc"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.companion_item.action1</code>.
     */
    public final TableField<CompanionItemRecord, String> ACTION1 = createField(DSL.name("action1"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.companion_item.action1desc</code>.
     */
    public final TableField<CompanionItemRecord, String> ACTION1DESC = createField(DSL.name("action1desc"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.companion_item.description</code>.
     */
    public final TableField<CompanionItemRecord, String> DESCRIPTION = createField(DSL.name("description"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.companion_item.src</code>.
     */
    public final TableField<CompanionItemRecord, String> SRC = createField(DSL.name("src"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.companion_item.url</code>.
     */
    public final TableField<CompanionItemRecord, String> URL = createField(DSL.name("url"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.companion_item.speed</code>.
     */
    public final TableField<CompanionItemRecord, String> SPEED = createField(DSL.name("speed"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * Create a <code>public.companion_item</code> table reference
     */
    public CompanionItem() {
        this(DSL.name("companion_item"), null);
    }

    /**
     * Create an aliased <code>public.companion_item</code> table reference
     */
    public CompanionItem(String alias) {
        this(DSL.name(alias), COMPANION_ITEM);
    }

    /**
     * Create an aliased <code>public.companion_item</code> table reference
     */
    public CompanionItem(Name alias) {
        this(alias, COMPANION_ITEM);
    }

    private CompanionItem(Name alias, Table<CompanionItemRecord> aliased) {
        this(alias, aliased, null);
    }

    private CompanionItem(Name alias, Table<CompanionItemRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> CompanionItem(Table<O> child, ForeignKey<O, CompanionItemRecord> key) {
        super(child, key, COMPANION_ITEM);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<CompanionItemRecord> getPrimaryKey() {
        return Keys.COMPANION_ITEM_PKEY;
    }

    @Override
    public List<UniqueKey<CompanionItemRecord>> getKeys() {
        return Arrays.<UniqueKey<CompanionItemRecord>>asList(Keys.COMPANION_ITEM_PKEY);
    }

    @Override
    public List<ForeignKey<CompanionItemRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<CompanionItemRecord, ?>>asList(Keys.COMPANION_ITEM__COMPANION_ITEM_SRC_FKEY);
    }

    public RulesSource rulesSource() {
        return new RulesSource(this, Keys.COMPANION_ITEM__COMPANION_ITEM_SRC_FKEY);
    }

    @Override
    public CompanionItem as(String alias) {
        return new CompanionItem(DSL.name(alias), this);
    }

    @Override
    public CompanionItem as(Name alias) {
        return new CompanionItem(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public CompanionItem rename(String name) {
        return new CompanionItem(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public CompanionItem rename(Name name) {
        return new CompanionItem(name, null);
    }

    // -------------------------------------------------------------------------
    // Row18 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row18<String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String> fieldsRow() {
        return (Row18) super.fieldsRow();
    }
}
