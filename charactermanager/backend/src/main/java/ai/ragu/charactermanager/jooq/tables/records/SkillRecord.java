/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables.records;


import ai.ragu.charactermanager.jooq.tables.Skill;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SkillRecord extends UpdatableRecordImpl<SkillRecord> implements Record3<String, String, String> {

    private static final long serialVersionUID = 992278989;

    /**
     * Setter for <code>public.skill.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.skill.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.skill.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.skill.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.skill.ability_score_id</code>.
     */
    public void setAbilityScoreId(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.skill.ability_score_id</code>.
     */
    public String getAbilityScoreId() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<String, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Skill.SKILL.ID;
    }

    @Override
    public Field<String> field2() {
        return Skill.SKILL.NAME;
    }

    @Override
    public Field<String> field3() {
        return Skill.SKILL.ABILITY_SCORE_ID;
    }

    @Override
    public String component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getAbilityScoreId();
    }

    @Override
    public String value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getAbilityScoreId();
    }

    @Override
    public SkillRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public SkillRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public SkillRecord value3(String value) {
        setAbilityScoreId(value);
        return this;
    }

    @Override
    public SkillRecord values(String value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SkillRecord
     */
    public SkillRecord() {
        super(Skill.SKILL);
    }

    /**
     * Create a detached, initialised SkillRecord
     */
    public SkillRecord(String id, String name, String abilityScoreId) {
        super(Skill.SKILL);

        set(0, id);
        set(1, name);
        set(2, abilityScoreId);
    }
}