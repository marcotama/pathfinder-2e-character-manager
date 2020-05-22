/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables;


import ai.ragu.charactermanager.jooq.Keys;
import ai.ragu.charactermanager.jooq.Public;
import ai.ragu.charactermanager.jooq.tables.records.SkillRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
public class Skill extends TableImpl<SkillRecord> {

    private static final long serialVersionUID = -2128056917;

    /**
     * The reference instance of <code>public.skill</code>
     */
    public static final Skill SKILL = new Skill();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SkillRecord> getRecordType() {
        return SkillRecord.class;
    }

    /**
     * The column <code>public.skill.id</code>.
     */
    public final TableField<SkillRecord, String> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.skill.name</code>.
     */
    public final TableField<SkillRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.skill.ability_score_id</code>.
     */
    public final TableField<SkillRecord, String> ABILITY_SCORE_ID = createField(DSL.name("ability_score_id"), org.jooq.impl.SQLDataType.VARCHAR, this, "");

    /**
     * Create a <code>public.skill</code> table reference
     */
    public Skill() {
        this(DSL.name("skill"), null);
    }

    /**
     * Create an aliased <code>public.skill</code> table reference
     */
    public Skill(String alias) {
        this(DSL.name(alias), SKILL);
    }

    /**
     * Create an aliased <code>public.skill</code> table reference
     */
    public Skill(Name alias) {
        this(alias, SKILL);
    }

    private Skill(Name alias, Table<SkillRecord> aliased) {
        this(alias, aliased, null);
    }

    private Skill(Name alias, Table<SkillRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Skill(Table<O> child, ForeignKey<O, SkillRecord> key) {
        super(child, key, SKILL);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public UniqueKey<SkillRecord> getPrimaryKey() {
        return Keys.SKILL_PKEY;
    }

    @Override
    public List<UniqueKey<SkillRecord>> getKeys() {
        return Arrays.<UniqueKey<SkillRecord>>asList(Keys.SKILL_PKEY);
    }

    @Override
    public List<ForeignKey<SkillRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<SkillRecord, ?>>asList(Keys.SKILL__SKILL_ABILITY_SCORE_ID_FKEY);
    }

    public AbilityScore abilityScore() {
        return new AbilityScore(this, Keys.SKILL__SKILL_ABILITY_SCORE_ID_FKEY);
    }

    @Override
    public Skill as(String alias) {
        return new Skill(DSL.name(alias), this);
    }

    @Override
    public Skill as(Name alias) {
        return new Skill(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Skill rename(String name) {
        return new Skill(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Skill rename(Name name) {
        return new Skill(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}