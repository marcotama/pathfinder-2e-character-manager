/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables;


import ai.ragu.charactermanager.jooq.Keys;
import ai.ragu.charactermanager.jooq.Public;
import ai.ragu.charactermanager.jooq.tables.records.ArmorMaterialRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row11;
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
public class ArmorMaterial extends TableImpl<ArmorMaterialRecord> {

    private static final long serialVersionUID = -1110640691;

    /**
     * The reference instance of <code>public.armor_material</code>
     */
    public static final ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ArmorMaterialRecord> getRecordType() {
        return ArmorMaterialRecord.class;
    }

    /**
     * The column <code>public.armor_material.id</code>.
     */
    public final TableField<ArmorMaterialRecord, String> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.armor_material.name</code>.
     */
    public final TableField<ArmorMaterialRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.armor_material.level</code>.
     */
    public final TableField<ArmorMaterialRecord, Integer> LEVEL = createField(DSL.name("level"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.armor_material.reduces_bulk</code>.
     */
    public final TableField<ArmorMaterialRecord, String> REDUCES_BULK = createField(DSL.name("reduces_bulk"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.armor_material.strength_adj</code>.
     */
    public final TableField<ArmorMaterialRecord, String> STRENGTH_ADJ = createField(DSL.name("strength_adj"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.armor_material.speed</code>.
     */
    public final TableField<ArmorMaterialRecord, String> SPEED = createField(DSL.name("speed"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.armor_material.ac</code>.
     */
    public final TableField<ArmorMaterialRecord, String> AC = createField(DSL.name("ac"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.armor_material.base</code>.
     */
    public final TableField<ArmorMaterialRecord, Integer> BASE = createField(DSL.name("base"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.armor_material.description</code>.
     */
    public final TableField<ArmorMaterialRecord, String> DESCRIPTION = createField(DSL.name("description"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.armor_material.src</code>.
     */
    public final TableField<ArmorMaterialRecord, String> SRC = createField(DSL.name("src"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.armor_material.url</code>.
     */
    public final TableField<ArmorMaterialRecord, String> URL = createField(DSL.name("url"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * Create a <code>public.armor_material</code> table reference
     */
    public ArmorMaterial() {
        this(DSL.name("armor_material"), null);
    }

    /**
     * Create an aliased <code>public.armor_material</code> table reference
     */
    public ArmorMaterial(String alias) {
        this(DSL.name(alias), ARMOR_MATERIAL);
    }

    /**
     * Create an aliased <code>public.armor_material</code> table reference
     */
    public ArmorMaterial(Name alias) {
        this(alias, ARMOR_MATERIAL);
    }

    private ArmorMaterial(Name alias, Table<ArmorMaterialRecord> aliased) {
        this(alias, aliased, null);
    }

    private ArmorMaterial(Name alias, Table<ArmorMaterialRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> ArmorMaterial(Table<O> child, ForeignKey<O, ArmorMaterialRecord> key) {
        super(child, key, ARMOR_MATERIAL);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<ArmorMaterialRecord> getPrimaryKey() {
        return Keys.ARMOR_MATERIAL_PKEY;
    }

    @Override
    public List<UniqueKey<ArmorMaterialRecord>> getKeys() {
        return Arrays.<UniqueKey<ArmorMaterialRecord>>asList(Keys.ARMOR_MATERIAL_PKEY);
    }

    @Override
    public List<ForeignKey<ArmorMaterialRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ArmorMaterialRecord, ?>>asList(Keys.ARMOR_MATERIAL__ARMOR_MATERIAL_SRC_FKEY);
    }

    public RulesSource rulesSource() {
        return new RulesSource(this, Keys.ARMOR_MATERIAL__ARMOR_MATERIAL_SRC_FKEY);
    }

    @Override
    public ArmorMaterial as(String alias) {
        return new ArmorMaterial(DSL.name(alias), this);
    }

    @Override
    public ArmorMaterial as(Name alias) {
        return new ArmorMaterial(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ArmorMaterial rename(String name) {
        return new ArmorMaterial(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ArmorMaterial rename(Name name) {
        return new ArmorMaterial(name, null);
    }

    // -------------------------------------------------------------------------
    // Row11 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row11<String, String, Integer, String, String, String, String, Integer, String, String, String> fieldsRow() {
        return (Row11) super.fieldsRow();
    }
}