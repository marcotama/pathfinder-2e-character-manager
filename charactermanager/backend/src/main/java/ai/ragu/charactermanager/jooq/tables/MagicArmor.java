/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables;


import ai.ragu.charactermanager.jooq.Keys;
import ai.ragu.charactermanager.jooq.Public;
import ai.ragu.charactermanager.jooq.tables.records.MagicArmorRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row15;
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
public class MagicArmor extends TableImpl<MagicArmorRecord> {

    private static final long serialVersionUID = 234751308;

    /**
     * The reference instance of <code>public.magic_armor</code>
     */
    public static final MagicArmor MAGIC_ARMOR = new MagicArmor();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MagicArmorRecord> getRecordType() {
        return MagicArmorRecord.class;
    }

    /**
     * The column <code>public.magic_armor.id</code>.
     */
    public final TableField<MagicArmorRecord, String> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.magic_armor.name</code>.
     */
    public final TableField<MagicArmorRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.magic_armor.level</code>.
     */
    public final TableField<MagicArmorRecord, Integer> LEVEL = createField(DSL.name("level"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.magic_armor.price</code>.
     */
    public final TableField<MagicArmorRecord, Integer> PRICE = createField(DSL.name("price"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.magic_armor.identity</code>.
     */
    public final TableField<MagicArmorRecord, String> IDENTITY = createField(DSL.name("identity"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.magic_armor.potency</code>.
     */
    public final TableField<MagicArmorRecord, Integer> POTENCY = createField(DSL.name("potency"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.magic_armor.resilient</code>.
     */
    public final TableField<MagicArmorRecord, Integer> RESILIENT = createField(DSL.name("resilient"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.magic_armor.action0</code>.
     */
    public final TableField<MagicArmorRecord, String> ACTION0 = createField(DSL.name("action0"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.magic_armor.action0desc</code>.
     */
    public final TableField<MagicArmorRecord, String> ACTION0DESC = createField(DSL.name("action0desc"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.magic_armor.action1</code>.
     */
    public final TableField<MagicArmorRecord, String> ACTION1 = createField(DSL.name("action1"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.magic_armor.action1desc</code>.
     */
    public final TableField<MagicArmorRecord, String> ACTION1DESC = createField(DSL.name("action1desc"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.magic_armor.rune</code>.
     */
    public final TableField<MagicArmorRecord, String> RUNE = createField(DSL.name("rune"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.magic_armor.description</code>.
     */
    public final TableField<MagicArmorRecord, String> DESCRIPTION = createField(DSL.name("description"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.magic_armor.src</code>.
     */
    public final TableField<MagicArmorRecord, String> SRC = createField(DSL.name("src"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.magic_armor.url</code>.
     */
    public final TableField<MagicArmorRecord, String> URL = createField(DSL.name("url"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * Create a <code>public.magic_armor</code> table reference
     */
    public MagicArmor() {
        this(DSL.name("magic_armor"), null);
    }

    /**
     * Create an aliased <code>public.magic_armor</code> table reference
     */
    public MagicArmor(String alias) {
        this(DSL.name(alias), MAGIC_ARMOR);
    }

    /**
     * Create an aliased <code>public.magic_armor</code> table reference
     */
    public MagicArmor(Name alias) {
        this(alias, MAGIC_ARMOR);
    }

    private MagicArmor(Name alias, Table<MagicArmorRecord> aliased) {
        this(alias, aliased, null);
    }

    private MagicArmor(Name alias, Table<MagicArmorRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> MagicArmor(Table<O> child, ForeignKey<O, MagicArmorRecord> key) {
        super(child, key, MAGIC_ARMOR);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<MagicArmorRecord> getPrimaryKey() {
        return Keys.MAGIC_ARMOR_PKEY;
    }

    @Override
    public List<UniqueKey<MagicArmorRecord>> getKeys() {
        return Arrays.<UniqueKey<MagicArmorRecord>>asList(Keys.MAGIC_ARMOR_PKEY);
    }

    @Override
    public List<ForeignKey<MagicArmorRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<MagicArmorRecord, ?>>asList(Keys.MAGIC_ARMOR__MAGIC_ARMOR_SRC_FKEY);
    }

    public RulesSource rulesSource() {
        return new RulesSource(this, Keys.MAGIC_ARMOR__MAGIC_ARMOR_SRC_FKEY);
    }

    @Override
    public MagicArmor as(String alias) {
        return new MagicArmor(DSL.name(alias), this);
    }

    @Override
    public MagicArmor as(Name alias) {
        return new MagicArmor(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public MagicArmor rename(String name) {
        return new MagicArmor(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public MagicArmor rename(Name name) {
        return new MagicArmor(name, null);
    }

    // -------------------------------------------------------------------------
    // Row15 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row15<String, String, Integer, Integer, String, Integer, Integer, String, String, String, String, String, String, String, String> fieldsRow() {
        return (Row15) super.fieldsRow();
    }
}