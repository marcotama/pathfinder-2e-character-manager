/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables;


import ai.ragu.charactermanager.jooq.Keys;
import ai.ragu.charactermanager.jooq.Public;
import ai.ragu.charactermanager.jooq.tables.records.FeatSpecialRequirementRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
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
public class FeatSpecialRequirement extends TableImpl<FeatSpecialRequirementRecord> {

    private static final long serialVersionUID = 1072454357;

    /**
     * The reference instance of <code>public.feat_special_requirement</code>
     */
    public static final FeatSpecialRequirement FEAT_SPECIAL_REQUIREMENT = new FeatSpecialRequirement();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FeatSpecialRequirementRecord> getRecordType() {
        return FeatSpecialRequirementRecord.class;
    }

    /**
     * The column <code>public.feat_special_requirement.id</code>.
     */
    public final TableField<FeatSpecialRequirementRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('feat_special_requirement_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.feat_special_requirement.feat_id</code>.
     */
    public final TableField<FeatSpecialRequirementRecord, String> FEAT_ID = createField(DSL.name("feat_id"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * The column <code>public.feat_special_requirement.special_id</code>.
     */
    public final TableField<FeatSpecialRequirementRecord, String> SPECIAL_ID = createField(DSL.name("special_id"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * Create a <code>public.feat_special_requirement</code> table reference
     */
    public FeatSpecialRequirement() {
        this(DSL.name("feat_special_requirement"), null);
    }

    /**
     * Create an aliased <code>public.feat_special_requirement</code> table reference
     */
    public FeatSpecialRequirement(String alias) {
        this(DSL.name(alias), FEAT_SPECIAL_REQUIREMENT);
    }

    /**
     * Create an aliased <code>public.feat_special_requirement</code> table reference
     */
    public FeatSpecialRequirement(Name alias) {
        this(alias, FEAT_SPECIAL_REQUIREMENT);
    }

    private FeatSpecialRequirement(Name alias, Table<FeatSpecialRequirementRecord> aliased) {
        this(alias, aliased, null);
    }

    private FeatSpecialRequirement(Name alias, Table<FeatSpecialRequirementRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> FeatSpecialRequirement(Table<O> child, ForeignKey<O, FeatSpecialRequirementRecord> key) {
        super(child, key, FEAT_SPECIAL_REQUIREMENT);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<FeatSpecialRequirementRecord, Integer> getIdentity() {
        return Keys.IDENTITY_FEAT_SPECIAL_REQUIREMENT;
    }

    @Override
    public UniqueKey<FeatSpecialRequirementRecord> getPrimaryKey() {
        return Keys.FEAT_SPECIAL_REQUIREMENT_PKEY;
    }

    @Override
    public List<UniqueKey<FeatSpecialRequirementRecord>> getKeys() {
        return Arrays.<UniqueKey<FeatSpecialRequirementRecord>>asList(Keys.FEAT_SPECIAL_REQUIREMENT_PKEY);
    }

    @Override
    public List<ForeignKey<FeatSpecialRequirementRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<FeatSpecialRequirementRecord, ?>>asList(Keys.FEAT_SPECIAL_REQUIREMENT__FEAT_SPECIAL_REQUIREMENT_FEAT_ID_FKEY, Keys.FEAT_SPECIAL_REQUIREMENT__FEAT_SPECIAL_REQUIREMENT_SPECIAL_ID_FKEY);
    }

    public Feat feat() {
        return new Feat(this, Keys.FEAT_SPECIAL_REQUIREMENT__FEAT_SPECIAL_REQUIREMENT_FEAT_ID_FKEY);
    }

    public Special special() {
        return new Special(this, Keys.FEAT_SPECIAL_REQUIREMENT__FEAT_SPECIAL_REQUIREMENT_SPECIAL_ID_FKEY);
    }

    @Override
    public FeatSpecialRequirement as(String alias) {
        return new FeatSpecialRequirement(DSL.name(alias), this);
    }

    @Override
    public FeatSpecialRequirement as(Name alias) {
        return new FeatSpecialRequirement(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public FeatSpecialRequirement rename(String name) {
        return new FeatSpecialRequirement(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public FeatSpecialRequirement rename(Name name) {
        return new FeatSpecialRequirement(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}