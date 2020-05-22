/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables;


import ai.ragu.charactermanager.jooq.Keys;
import ai.ragu.charactermanager.jooq.Public;
import ai.ragu.charactermanager.jooq.tables.records.BackgroundRecord;

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
public class Background extends TableImpl<BackgroundRecord> {

    private static final long serialVersionUID = 635423689;

    /**
     * The reference instance of <code>public.background</code>
     */
    public static final Background BACKGROUND = new Background();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BackgroundRecord> getRecordType() {
        return BackgroundRecord.class;
    }

    /**
     * The column <code>public.background.id</code>.
     */
    public final TableField<BackgroundRecord, String> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.background.name</code>.
     */
    public final TableField<BackgroundRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.background.boost_ref_1</code>.
     */
    public final TableField<BackgroundRecord, String> BOOST_REF_1 = createField(DSL.name("boost_ref_1"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.background.boost_ref_2</code>.
     */
    public final TableField<BackgroundRecord, String> BOOST_REF_2 = createField(DSL.name("boost_ref_2"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.background.free_feat_id</code>.
     */
    public final TableField<BackgroundRecord, String> FREE_FEAT_ID = createField(DSL.name("free_feat_id"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.background.free_feat_detail</code>.
     */
    public final TableField<BackgroundRecord, String> FREE_FEAT_DETAIL = createField(DSL.name("free_feat_detail"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.background.lore</code>.
     */
    public final TableField<BackgroundRecord, String> LORE = createField(DSL.name("lore"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.background.skill</code>.
     */
    public final TableField<BackgroundRecord, String> SKILL = createField(DSL.name("skill"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.background.description</code>.
     */
    public final TableField<BackgroundRecord, String> DESCRIPTION = createField(DSL.name("description"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.background.src</code>.
     */
    public final TableField<BackgroundRecord, String> SRC = createField(DSL.name("src"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.background.url</code>.
     */
    public final TableField<BackgroundRecord, String> URL = createField(DSL.name("url"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * Create a <code>public.background</code> table reference
     */
    public Background() {
        this(DSL.name("background"), null);
    }

    /**
     * Create an aliased <code>public.background</code> table reference
     */
    public Background(String alias) {
        this(DSL.name(alias), BACKGROUND);
    }

    /**
     * Create an aliased <code>public.background</code> table reference
     */
    public Background(Name alias) {
        this(alias, BACKGROUND);
    }

    private Background(Name alias, Table<BackgroundRecord> aliased) {
        this(alias, aliased, null);
    }

    private Background(Name alias, Table<BackgroundRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Background(Table<O> child, ForeignKey<O, BackgroundRecord> key) {
        super(child, key, BACKGROUND);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<BackgroundRecord> getPrimaryKey() {
        return Keys.BACKGROUND_PKEY;
    }

    @Override
    public List<UniqueKey<BackgroundRecord>> getKeys() {
        return Arrays.<UniqueKey<BackgroundRecord>>asList(Keys.BACKGROUND_PKEY);
    }

    @Override
    public List<ForeignKey<BackgroundRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<BackgroundRecord, ?>>asList(Keys.BACKGROUND__BACKGROUND_BOOST_REF_1_FKEY, Keys.BACKGROUND__BACKGROUND_BOOST_REF_2_FKEY, Keys.BACKGROUND__BACKGROUND_FREE_FEAT_ID_FKEY, Keys.BACKGROUND__BACKGROUND_SRC_FKEY);
    }

    public AbilityScore backgroundBoostRef_1Fkey() {
        return new AbilityScore(this, Keys.BACKGROUND__BACKGROUND_BOOST_REF_1_FKEY);
    }

    public AbilityScore backgroundBoostRef_2Fkey() {
        return new AbilityScore(this, Keys.BACKGROUND__BACKGROUND_BOOST_REF_2_FKEY);
    }

    public Feat feat() {
        return new Feat(this, Keys.BACKGROUND__BACKGROUND_FREE_FEAT_ID_FKEY);
    }

    public RulesSource rulesSource() {
        return new RulesSource(this, Keys.BACKGROUND__BACKGROUND_SRC_FKEY);
    }

    @Override
    public Background as(String alias) {
        return new Background(DSL.name(alias), this);
    }

    @Override
    public Background as(Name alias) {
        return new Background(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Background rename(String name) {
        return new Background(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Background rename(Name name) {
        return new Background(name, null);
    }

    // -------------------------------------------------------------------------
    // Row11 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row11<String, String, String, String, String, String, String, String, String, String, String> fieldsRow() {
        return (Row11) super.fieldsRow();
    }
}