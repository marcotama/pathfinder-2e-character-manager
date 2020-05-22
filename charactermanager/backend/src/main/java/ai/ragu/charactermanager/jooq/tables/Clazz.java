/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables;


import ai.ragu.charactermanager.jooq.Keys;
import ai.ragu.charactermanager.jooq.Public;
import ai.ragu.charactermanager.jooq.tables.records.ClazzRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
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
public class Clazz extends TableImpl<ClazzRecord> {

    private static final long serialVersionUID = 247278122;

    /**
     * The reference instance of <code>public.clazz</code>
     */
    public static final Clazz CLAZZ = new Clazz();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ClazzRecord> getRecordType() {
        return ClazzRecord.class;
    }

    /**
     * The column <code>public.clazz.id</code>.
     */
    public final TableField<ClazzRecord, String> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.clazz.name</code>.
     */
    public final TableField<ClazzRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.clazz.description</code>.
     */
    public final TableField<ClazzRecord, String> DESCRIPTION = createField(DSL.name("description"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.clazz.src</code>.
     */
    public final TableField<ClazzRecord, String> SRC = createField(DSL.name("src"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.clazz.url</code>.
     */
    public final TableField<ClazzRecord, String> URL = createField(DSL.name("url"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * Create a <code>public.clazz</code> table reference
     */
    public Clazz() {
        this(DSL.name("clazz"), null);
    }

    /**
     * Create an aliased <code>public.clazz</code> table reference
     */
    public Clazz(String alias) {
        this(DSL.name(alias), CLAZZ);
    }

    /**
     * Create an aliased <code>public.clazz</code> table reference
     */
    public Clazz(Name alias) {
        this(alias, CLAZZ);
    }

    private Clazz(Name alias, Table<ClazzRecord> aliased) {
        this(alias, aliased, null);
    }

    private Clazz(Name alias, Table<ClazzRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Clazz(Table<O> child, ForeignKey<O, ClazzRecord> key) {
        super(child, key, CLAZZ);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<ClazzRecord> getPrimaryKey() {
        return Keys.CLAZZ_PKEY;
    }

    @Override
    public List<UniqueKey<ClazzRecord>> getKeys() {
        return Arrays.<UniqueKey<ClazzRecord>>asList(Keys.CLAZZ_PKEY);
    }

    @Override
    public List<ForeignKey<ClazzRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ClazzRecord, ?>>asList(Keys.CLAZZ__CLAZZ_SRC_FKEY);
    }

    public RulesSource rulesSource() {
        return new RulesSource(this, Keys.CLAZZ__CLAZZ_SRC_FKEY);
    }

    @Override
    public Clazz as(String alias) {
        return new Clazz(DSL.name(alias), this);
    }

    @Override
    public Clazz as(Name alias) {
        return new Clazz(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Clazz rename(String name) {
        return new Clazz(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Clazz rename(Name name) {
        return new Clazz(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<String, String, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
