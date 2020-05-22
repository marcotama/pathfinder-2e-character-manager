/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables;


import ai.ragu.charactermanager.jooq.Keys;
import ai.ragu.charactermanager.jooq.Public;
import ai.ragu.charactermanager.jooq.tables.records.MagicWeaponRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row14;
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
public class MagicWeapon extends TableImpl<MagicWeaponRecord> {

    private static final long serialVersionUID = -2102949456;

    /**
     * The reference instance of <code>public.magic_weapon</code>
     */
    public static final MagicWeapon MAGIC_WEAPON = new MagicWeapon();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MagicWeaponRecord> getRecordType() {
        return MagicWeaponRecord.class;
    }

    /**
     * The column <code>public.magic_weapon.id</code>.
     */
    public final TableField<MagicWeaponRecord, String> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.magic_weapon.name</code>.
     */
    public final TableField<MagicWeaponRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.magic_weapon.level</code>.
     */
    public final TableField<MagicWeaponRecord, Integer> LEVEL = createField(DSL.name("level"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.magic_weapon.price</code>.
     */
    public final TableField<MagicWeaponRecord, Integer> PRICE = createField(DSL.name("price"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.magic_weapon.identity</code>.
     */
    public final TableField<MagicWeaponRecord, String> IDENTITY = createField(DSL.name("identity"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.magic_weapon.potency</code>.
     */
    public final TableField<MagicWeaponRecord, Integer> POTENCY = createField(DSL.name("potency"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.magic_weapon.striking</code>.
     */
    public final TableField<MagicWeaponRecord, Integer> STRIKING = createField(DSL.name("striking"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.magic_weapon.action0</code>.
     */
    public final TableField<MagicWeaponRecord, String> ACTION0 = createField(DSL.name("action0"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.magic_weapon.action0desc</code>.
     */
    public final TableField<MagicWeaponRecord, String> ACTION0DESC = createField(DSL.name("action0desc"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.magic_weapon.action1</code>.
     */
    public final TableField<MagicWeaponRecord, String> ACTION1 = createField(DSL.name("action1"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.magic_weapon.action1desc</code>.
     */
    public final TableField<MagicWeaponRecord, String> ACTION1DESC = createField(DSL.name("action1desc"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.magic_weapon.description</code>.
     */
    public final TableField<MagicWeaponRecord, String> DESCRIPTION = createField(DSL.name("description"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.magic_weapon.src</code>.
     */
    public final TableField<MagicWeaponRecord, String> SRC = createField(DSL.name("src"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.magic_weapon.url</code>.
     */
    public final TableField<MagicWeaponRecord, String> URL = createField(DSL.name("url"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * Create a <code>public.magic_weapon</code> table reference
     */
    public MagicWeapon() {
        this(DSL.name("magic_weapon"), null);
    }

    /**
     * Create an aliased <code>public.magic_weapon</code> table reference
     */
    public MagicWeapon(String alias) {
        this(DSL.name(alias), MAGIC_WEAPON);
    }

    /**
     * Create an aliased <code>public.magic_weapon</code> table reference
     */
    public MagicWeapon(Name alias) {
        this(alias, MAGIC_WEAPON);
    }

    private MagicWeapon(Name alias, Table<MagicWeaponRecord> aliased) {
        this(alias, aliased, null);
    }

    private MagicWeapon(Name alias, Table<MagicWeaponRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> MagicWeapon(Table<O> child, ForeignKey<O, MagicWeaponRecord> key) {
        super(child, key, MAGIC_WEAPON);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<MagicWeaponRecord> getPrimaryKey() {
        return Keys.MAGIC_WEAPON_PKEY;
    }

    @Override
    public List<UniqueKey<MagicWeaponRecord>> getKeys() {
        return Arrays.<UniqueKey<MagicWeaponRecord>>asList(Keys.MAGIC_WEAPON_PKEY);
    }

    @Override
    public List<ForeignKey<MagicWeaponRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<MagicWeaponRecord, ?>>asList(Keys.MAGIC_WEAPON__MAGIC_WEAPON_SRC_FKEY);
    }

    public RulesSource rulesSource() {
        return new RulesSource(this, Keys.MAGIC_WEAPON__MAGIC_WEAPON_SRC_FKEY);
    }

    @Override
    public MagicWeapon as(String alias) {
        return new MagicWeapon(DSL.name(alias), this);
    }

    @Override
    public MagicWeapon as(Name alias) {
        return new MagicWeapon(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public MagicWeapon rename(String name) {
        return new MagicWeapon(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public MagicWeapon rename(Name name) {
        return new MagicWeapon(name, null);
    }

    // -------------------------------------------------------------------------
    // Row14 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row14<String, String, Integer, Integer, String, Integer, Integer, String, String, String, String, String, String, String> fieldsRow() {
        return (Row14) super.fieldsRow();
    }
}
