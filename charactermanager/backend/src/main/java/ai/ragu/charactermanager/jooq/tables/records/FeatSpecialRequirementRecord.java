/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables.records;


import ai.ragu.charactermanager.jooq.tables.FeatSpecialRequirement;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FeatSpecialRequirementRecord extends UpdatableRecordImpl<FeatSpecialRequirementRecord> implements Record3<Integer, String, String> {

    private static final long serialVersionUID = -1130579457;

    /**
     * Setter for <code>public.feat_special_requirement.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.feat_special_requirement.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.feat_special_requirement.feat_id</code>.
     */
    public void setFeatId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.feat_special_requirement.feat_id</code>.
     */
    public String getFeatId() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.feat_special_requirement.special_id</code>.
     */
    public void setSpecialId(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.feat_special_requirement.special_id</code>.
     */
    public String getSpecialId() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Integer, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return FeatSpecialRequirement.FEAT_SPECIAL_REQUIREMENT.ID;
    }

    @Override
    public Field<String> field2() {
        return FeatSpecialRequirement.FEAT_SPECIAL_REQUIREMENT.FEAT_ID;
    }

    @Override
    public Field<String> field3() {
        return FeatSpecialRequirement.FEAT_SPECIAL_REQUIREMENT.SPECIAL_ID;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getFeatId();
    }

    @Override
    public String component3() {
        return getSpecialId();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getFeatId();
    }

    @Override
    public String value3() {
        return getSpecialId();
    }

    @Override
    public FeatSpecialRequirementRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public FeatSpecialRequirementRecord value2(String value) {
        setFeatId(value);
        return this;
    }

    @Override
    public FeatSpecialRequirementRecord value3(String value) {
        setSpecialId(value);
        return this;
    }

    @Override
    public FeatSpecialRequirementRecord values(Integer value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached FeatSpecialRequirementRecord
     */
    public FeatSpecialRequirementRecord() {
        super(FeatSpecialRequirement.FEAT_SPECIAL_REQUIREMENT);
    }

    /**
     * Create a detached, initialised FeatSpecialRequirementRecord
     */
    public FeatSpecialRequirementRecord(Integer id, String featId, String specialId) {
        super(FeatSpecialRequirement.FEAT_SPECIAL_REQUIREMENT);

        set(0, id);
        set(1, featId);
        set(2, specialId);
    }
}
