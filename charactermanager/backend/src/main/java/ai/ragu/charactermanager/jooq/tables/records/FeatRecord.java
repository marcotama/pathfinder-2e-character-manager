/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables.records;


import ai.ragu.charactermanager.jooq.tables.Feat;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FeatRecord extends UpdatableRecordImpl<FeatRecord> implements Record8<String, String, String, Short, String, String, String, String> {

    private static final long serialVersionUID = -20200891;

    /**
     * Setter for <code>public.feat.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.feat.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.feat.category</code>.
     */
    public void setCategory(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.feat.category</code>.
     */
    public String getCategory() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.feat.name</code>.
     */
    public void setName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.feat.name</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.feat.level</code>.
     */
    public void setLevel(Short value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.feat.level</code>.
     */
    public Short getLevel() {
        return (Short) get(3);
    }

    /**
     * Setter for <code>public.feat.actions</code>.
     */
    public void setActions(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.feat.actions</code>.
     */
    public String getActions() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.feat.description</code>.
     */
    public void setDescription(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.feat.description</code>.
     */
    public String getDescription() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.feat.src</code>.
     */
    public void setSrc(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.feat.src</code>.
     */
    public String getSrc() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.feat.url</code>.
     */
    public void setUrl(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.feat.url</code>.
     */
    public String getUrl() {
        return (String) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<String, String, String, Short, String, String, String, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<String, String, String, Short, String, String, String, String> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Feat.FEAT.ID;
    }

    @Override
    public Field<String> field2() {
        return Feat.FEAT.CATEGORY;
    }

    @Override
    public Field<String> field3() {
        return Feat.FEAT.NAME;
    }

    @Override
    public Field<Short> field4() {
        return Feat.FEAT.LEVEL;
    }

    @Override
    public Field<String> field5() {
        return Feat.FEAT.ACTIONS;
    }

    @Override
    public Field<String> field6() {
        return Feat.FEAT.DESCRIPTION;
    }

    @Override
    public Field<String> field7() {
        return Feat.FEAT.SRC;
    }

    @Override
    public Field<String> field8() {
        return Feat.FEAT.URL;
    }

    @Override
    public String component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getCategory();
    }

    @Override
    public String component3() {
        return getName();
    }

    @Override
    public Short component4() {
        return getLevel();
    }

    @Override
    public String component5() {
        return getActions();
    }

    @Override
    public String component6() {
        return getDescription();
    }

    @Override
    public String component7() {
        return getSrc();
    }

    @Override
    public String component8() {
        return getUrl();
    }

    @Override
    public String value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getCategory();
    }

    @Override
    public String value3() {
        return getName();
    }

    @Override
    public Short value4() {
        return getLevel();
    }

    @Override
    public String value5() {
        return getActions();
    }

    @Override
    public String value6() {
        return getDescription();
    }

    @Override
    public String value7() {
        return getSrc();
    }

    @Override
    public String value8() {
        return getUrl();
    }

    @Override
    public FeatRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public FeatRecord value2(String value) {
        setCategory(value);
        return this;
    }

    @Override
    public FeatRecord value3(String value) {
        setName(value);
        return this;
    }

    @Override
    public FeatRecord value4(Short value) {
        setLevel(value);
        return this;
    }

    @Override
    public FeatRecord value5(String value) {
        setActions(value);
        return this;
    }

    @Override
    public FeatRecord value6(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public FeatRecord value7(String value) {
        setSrc(value);
        return this;
    }

    @Override
    public FeatRecord value8(String value) {
        setUrl(value);
        return this;
    }

    @Override
    public FeatRecord values(String value1, String value2, String value3, Short value4, String value5, String value6, String value7, String value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached FeatRecord
     */
    public FeatRecord() {
        super(Feat.FEAT);
    }

    /**
     * Create a detached, initialised FeatRecord
     */
    public FeatRecord(String id, String category, String name, Short level, String actions, String description, String src, String url) {
        super(Feat.FEAT);

        set(0, id);
        set(1, category);
        set(2, name);
        set(3, level);
        set(4, actions);
        set(5, description);
        set(6, src);
        set(7, url);
    }
}
