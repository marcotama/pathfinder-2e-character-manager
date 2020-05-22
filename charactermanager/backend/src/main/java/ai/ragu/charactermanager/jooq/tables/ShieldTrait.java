/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables;


import ai.ragu.charactermanager.jooq.Keys;
import ai.ragu.charactermanager.jooq.Public;
import ai.ragu.charactermanager.jooq.tables.records.ShieldTraitRecord;

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
public class ShieldTrait extends TableImpl<ShieldTraitRecord> {

    private static final long serialVersionUID = 1541145718;

    /**
     * The reference instance of <code>public.shield_trait</code>
     */
    public static final ShieldTrait SHIELD_TRAIT = new ShieldTrait();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ShieldTraitRecord> getRecordType() {
        return ShieldTraitRecord.class;
    }

    /**
     * The column <code>public.shield_trait.shield_id</code>.
     */
    public final TableField<ShieldTraitRecord, String> SHIELD_ID = createField(DSL.name("shield_id"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.shield_trait.trait</code>.
     */
    public final TableField<ShieldTraitRecord, String> TRAIT = createField(DSL.name("trait"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * Create a <code>public.shield_trait</code> table reference
     */
    public ShieldTrait() {
        this(DSL.name("shield_trait"), null);
    }

    /**
     * Create an aliased <code>public.shield_trait</code> table reference
     */
    public ShieldTrait(String alias) {
        this(DSL.name(alias), SHIELD_TRAIT);
    }

    /**
     * Create an aliased <code>public.shield_trait</code> table reference
     */
    public ShieldTrait(Name alias) {
        this(alias, SHIELD_TRAIT);
    }

    private ShieldTrait(Name alias, Table<ShieldTraitRecord> aliased) {
        this(alias, aliased, null);
    }

    private ShieldTrait(Name alias, Table<ShieldTraitRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> ShieldTrait(Table<O> child, ForeignKey<O, ShieldTraitRecord> key) {
        super(child, key, SHIELD_TRAIT);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<ShieldTraitRecord> getPrimaryKey() {
        return Keys.SHIELD_TRAIT_PKEY;
    }

    @Override
    public List<UniqueKey<ShieldTraitRecord>> getKeys() {
        return Arrays.<UniqueKey<ShieldTraitRecord>>asList(Keys.SHIELD_TRAIT_PKEY);
    }

    @Override
    public List<ForeignKey<ShieldTraitRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ShieldTraitRecord, ?>>asList(Keys.SHIELD_TRAIT__SHIELD_TRAIT_SHIELD_ID_FKEY);
    }

    public Shield shield() {
        return new Shield(this, Keys.SHIELD_TRAIT__SHIELD_TRAIT_SHIELD_ID_FKEY);
    }

    @Override
    public ShieldTrait as(String alias) {
        return new ShieldTrait(DSL.name(alias), this);
    }

    @Override
    public ShieldTrait as(Name alias) {
        return new ShieldTrait(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ShieldTrait rename(String name) {
        return new ShieldTrait(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ShieldTrait rename(Name name) {
        return new ShieldTrait(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
