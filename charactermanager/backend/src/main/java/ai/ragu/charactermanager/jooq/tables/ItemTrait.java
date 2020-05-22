/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables;


import ai.ragu.charactermanager.jooq.Keys;
import ai.ragu.charactermanager.jooq.Public;
import ai.ragu.charactermanager.jooq.tables.records.ItemTraitRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
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
public class ItemTrait extends TableImpl<ItemTraitRecord> {

    private static final long serialVersionUID = -192286606;

    /**
     * The reference instance of <code>public.item_trait</code>
     */
    public static final ItemTrait ITEM_TRAIT = new ItemTrait();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ItemTraitRecord> getRecordType() {
        return ItemTraitRecord.class;
    }

    /**
     * The column <code>public.item_trait.item_id</code>.
     */
    public final TableField<ItemTraitRecord, String> ITEM_ID = createField(DSL.name("item_id"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.item_trait.trait</code>.
     */
    public final TableField<ItemTraitRecord, String> TRAIT = createField(DSL.name("trait"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * Create a <code>public.item_trait</code> table reference
     */
    public ItemTrait() {
        this(DSL.name("item_trait"), null);
    }

    /**
     * Create an aliased <code>public.item_trait</code> table reference
     */
    public ItemTrait(String alias) {
        this(DSL.name(alias), ITEM_TRAIT);
    }

    /**
     * Create an aliased <code>public.item_trait</code> table reference
     */
    public ItemTrait(Name alias) {
        this(alias, ITEM_TRAIT);
    }

    private ItemTrait(Name alias, Table<ItemTraitRecord> aliased) {
        this(alias, aliased, null);
    }

    private ItemTrait(Name alias, Table<ItemTraitRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> ItemTrait(Table<O> child, ForeignKey<O, ItemTraitRecord> key) {
        super(child, key, ITEM_TRAIT);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<ItemTraitRecord> getPrimaryKey() {
        return Keys.ITEM_TRAIT_PKEY;
    }

    @Override
    public List<UniqueKey<ItemTraitRecord>> getKeys() {
        return Arrays.<UniqueKey<ItemTraitRecord>>asList(Keys.ITEM_TRAIT_PKEY);
    }

    @Override
    public List<ForeignKey<ItemTraitRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ItemTraitRecord, ?>>asList(Keys.ITEM_TRAIT__ITEM_TRAIT_ITEM_ID_FKEY);
    }

    public Item item() {
        return new Item(this, Keys.ITEM_TRAIT__ITEM_TRAIT_ITEM_ID_FKEY);
    }

    @Override
    public ItemTrait as(String alias) {
        return new ItemTrait(DSL.name(alias), this);
    }

    @Override
    public ItemTrait as(Name alias) {
        return new ItemTrait(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ItemTrait rename(String name) {
        return new ItemTrait(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ItemTrait rename(Name name) {
        return new ItemTrait(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
