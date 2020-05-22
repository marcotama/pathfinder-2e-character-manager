/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables.records;


import ai.ragu.charactermanager.jooq.tables.AncestryAbilityFlaws;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AncestryAbilityFlawsRecord extends UpdatableRecordImpl<AncestryAbilityFlawsRecord> implements Record2<String, String> {

    private static final long serialVersionUID = -2145057952;

    /**
     * Setter for <code>public.ancestry_ability_flaws.ancestry_id</code>.
     */
    public void setAncestryId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.ancestry_ability_flaws.ancestry_id</code>.
     */
    public String getAncestryId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.ancestry_ability_flaws.ability_score_id</code>.
     */
    public void setAbilityScoreId(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.ancestry_ability_flaws.ability_score_id</code>.
     */
    public String getAbilityScoreId() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return AncestryAbilityFlaws.ANCESTRY_ABILITY_FLAWS.ANCESTRY_ID;
    }

    @Override
    public Field<String> field2() {
        return AncestryAbilityFlaws.ANCESTRY_ABILITY_FLAWS.ABILITY_SCORE_ID;
    }

    @Override
    public String component1() {
        return getAncestryId();
    }

    @Override
    public String component2() {
        return getAbilityScoreId();
    }

    @Override
    public String value1() {
        return getAncestryId();
    }

    @Override
    public String value2() {
        return getAbilityScoreId();
    }

    @Override
    public AncestryAbilityFlawsRecord value1(String value) {
        setAncestryId(value);
        return this;
    }

    @Override
    public AncestryAbilityFlawsRecord value2(String value) {
        setAbilityScoreId(value);
        return this;
    }

    @Override
    public AncestryAbilityFlawsRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AncestryAbilityFlawsRecord
     */
    public AncestryAbilityFlawsRecord() {
        super(AncestryAbilityFlaws.ANCESTRY_ABILITY_FLAWS);
    }

    /**
     * Create a detached, initialised AncestryAbilityFlawsRecord
     */
    public AncestryAbilityFlawsRecord(String ancestryId, String abilityScoreId) {
        super(AncestryAbilityFlaws.ANCESTRY_ABILITY_FLAWS);

        set(0, ancestryId);
        set(1, abilityScoreId);
    }
}
