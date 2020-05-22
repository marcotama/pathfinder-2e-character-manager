/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables;


import ai.ragu.charactermanager.jooq.Keys;
import ai.ragu.charactermanager.jooq.Public;
import ai.ragu.charactermanager.jooq.tables.records.FeatFamiliarRequirementRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row1;
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
public class FeatFamiliarRequirement extends TableImpl<FeatFamiliarRequirementRecord> {

    private static final long serialVersionUID = 1952256385;

    /**
     * The reference instance of <code>public.feat_familiar_requirement</code>
     */
    public static final FeatFamiliarRequirement FEAT_FAMILIAR_REQUIREMENT = new FeatFamiliarRequirement();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FeatFamiliarRequirementRecord> getRecordType() {
        return FeatFamiliarRequirementRecord.class;
    }

    /**
     * The column <code>public.feat_familiar_requirement.feat_id</code>.
     */
    public final TableField<FeatFamiliarRequirementRecord, String> FEAT_ID = createField(DSL.name("feat_id"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * Create a <code>public.feat_familiar_requirement</code> table reference
     */
    public FeatFamiliarRequirement() {
        this(DSL.name("feat_familiar_requirement"), null);
    }

    /**
     * Create an aliased <code>public.feat_familiar_requirement</code> table reference
     */
    public FeatFamiliarRequirement(String alias) {
        this(DSL.name(alias), FEAT_FAMILIAR_REQUIREMENT);
    }

    /**
     * Create an aliased <code>public.feat_familiar_requirement</code> table reference
     */
    public FeatFamiliarRequirement(Name alias) {
        this(alias, FEAT_FAMILIAR_REQUIREMENT);
    }

    private FeatFamiliarRequirement(Name alias, Table<FeatFamiliarRequirementRecord> aliased) {
        this(alias, aliased, null);
    }

    private FeatFamiliarRequirement(Name alias, Table<FeatFamiliarRequirementRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> FeatFamiliarRequirement(Table<O> child, ForeignKey<O, FeatFamiliarRequirementRecord> key) {
        super(child, key, FEAT_FAMILIAR_REQUIREMENT);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<FeatFamiliarRequirementRecord> getPrimaryKey() {
        return Keys.FEAT_FAMILIAR_REQUIREMENT_PKEY;
    }

    @Override
    public List<UniqueKey<FeatFamiliarRequirementRecord>> getKeys() {
        return Arrays.<UniqueKey<FeatFamiliarRequirementRecord>>asList(Keys.FEAT_FAMILIAR_REQUIREMENT_PKEY);
    }

    @Override
    public List<ForeignKey<FeatFamiliarRequirementRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<FeatFamiliarRequirementRecord, ?>>asList(Keys.FEAT_FAMILIAR_REQUIREMENT__FEAT_FAMILIAR_REQUIREMENT_FEAT_ID_FKEY);
    }

    public Feat feat() {
        return new Feat(this, Keys.FEAT_FAMILIAR_REQUIREMENT__FEAT_FAMILIAR_REQUIREMENT_FEAT_ID_FKEY);
    }

    @Override
    public FeatFamiliarRequirement as(String alias) {
        return new FeatFamiliarRequirement(DSL.name(alias), this);
    }

    @Override
    public FeatFamiliarRequirement as(Name alias) {
        return new FeatFamiliarRequirement(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public FeatFamiliarRequirement rename(String name) {
        return new FeatFamiliarRequirement(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public FeatFamiliarRequirement rename(Name name) {
        return new FeatFamiliarRequirement(name, null);
    }

    // -------------------------------------------------------------------------
    // Row1 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row1<String> fieldsRow() {
        return (Row1) super.fieldsRow();
    }
}
