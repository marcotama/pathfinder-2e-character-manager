/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables.records;


import ai.ragu.charactermanager.jooq.tables.Background;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BackgroundRecord extends UpdatableRecordImpl<BackgroundRecord> implements Record11<String, String, String, String, String, String, String, String, String, String, String> {

    private static final long serialVersionUID = -1724675317;

    /**
     * Setter for <code>public.background.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.background.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.background.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.background.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.background.boost_ref_1</code>.
     */
    public void setBoostRef_1(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.background.boost_ref_1</code>.
     */
    public String getBoostRef_1() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.background.boost_ref_2</code>.
     */
    public void setBoostRef_2(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.background.boost_ref_2</code>.
     */
    public String getBoostRef_2() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.background.free_feat_id</code>.
     */
    public void setFreeFeatId(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.background.free_feat_id</code>.
     */
    public String getFreeFeatId() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.background.free_feat_detail</code>.
     */
    public void setFreeFeatDetail(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.background.free_feat_detail</code>.
     */
    public String getFreeFeatDetail() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.background.lore</code>.
     */
    public void setLore(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.background.lore</code>.
     */
    public String getLore() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.background.skill</code>.
     */
    public void setSkill(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.background.skill</code>.
     */
    public String getSkill() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.background.description</code>.
     */
    public void setDescription(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.background.description</code>.
     */
    public String getDescription() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.background.src</code>.
     */
    public void setSrc(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.background.src</code>.
     */
    public String getSrc() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.background.url</code>.
     */
    public void setUrl(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.background.url</code>.
     */
    public String getUrl() {
        return (String) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row11<String, String, String, String, String, String, String, String, String, String, String> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    @Override
    public Row11<String, String, String, String, String, String, String, String, String, String, String> valuesRow() {
        return (Row11) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Background.BACKGROUND.ID;
    }

    @Override
    public Field<String> field2() {
        return Background.BACKGROUND.NAME;
    }

    @Override
    public Field<String> field3() {
        return Background.BACKGROUND.BOOST_REF_1;
    }

    @Override
    public Field<String> field4() {
        return Background.BACKGROUND.BOOST_REF_2;
    }

    @Override
    public Field<String> field5() {
        return Background.BACKGROUND.FREE_FEAT_ID;
    }

    @Override
    public Field<String> field6() {
        return Background.BACKGROUND.FREE_FEAT_DETAIL;
    }

    @Override
    public Field<String> field7() {
        return Background.BACKGROUND.LORE;
    }

    @Override
    public Field<String> field8() {
        return Background.BACKGROUND.SKILL;
    }

    @Override
    public Field<String> field9() {
        return Background.BACKGROUND.DESCRIPTION;
    }

    @Override
    public Field<String> field10() {
        return Background.BACKGROUND.SRC;
    }

    @Override
    public Field<String> field11() {
        return Background.BACKGROUND.URL;
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
        return getBoostRef_1();
    }

    @Override
    public String component4() {
        return getBoostRef_2();
    }

    @Override
    public String component5() {
        return getFreeFeatId();
    }

    @Override
    public String component6() {
        return getFreeFeatDetail();
    }

    @Override
    public String component7() {
        return getLore();
    }

    @Override
    public String component8() {
        return getSkill();
    }

    @Override
    public String component9() {
        return getDescription();
    }

    @Override
    public String component10() {
        return getSrc();
    }

    @Override
    public String component11() {
        return getUrl();
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
        return getBoostRef_1();
    }

    @Override
    public String value4() {
        return getBoostRef_2();
    }

    @Override
    public String value5() {
        return getFreeFeatId();
    }

    @Override
    public String value6() {
        return getFreeFeatDetail();
    }

    @Override
    public String value7() {
        return getLore();
    }

    @Override
    public String value8() {
        return getSkill();
    }

    @Override
    public String value9() {
        return getDescription();
    }

    @Override
    public String value10() {
        return getSrc();
    }

    @Override
    public String value11() {
        return getUrl();
    }

    @Override
    public BackgroundRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public BackgroundRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public BackgroundRecord value3(String value) {
        setBoostRef_1(value);
        return this;
    }

    @Override
    public BackgroundRecord value4(String value) {
        setBoostRef_2(value);
        return this;
    }

    @Override
    public BackgroundRecord value5(String value) {
        setFreeFeatId(value);
        return this;
    }

    @Override
    public BackgroundRecord value6(String value) {
        setFreeFeatDetail(value);
        return this;
    }

    @Override
    public BackgroundRecord value7(String value) {
        setLore(value);
        return this;
    }

    @Override
    public BackgroundRecord value8(String value) {
        setSkill(value);
        return this;
    }

    @Override
    public BackgroundRecord value9(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public BackgroundRecord value10(String value) {
        setSrc(value);
        return this;
    }

    @Override
    public BackgroundRecord value11(String value) {
        setUrl(value);
        return this;
    }

    @Override
    public BackgroundRecord values(String value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9, String value10, String value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached BackgroundRecord
     */
    public BackgroundRecord() {
        super(Background.BACKGROUND);
    }

    /**
     * Create a detached, initialised BackgroundRecord
     */
    public BackgroundRecord(String id, String name, String boostRef_1, String boostRef_2, String freeFeatId, String freeFeatDetail, String lore, String skill, String description, String src, String url) {
        super(Background.BACKGROUND);

        set(0, id);
        set(1, name);
        set(2, boostRef_1);
        set(3, boostRef_2);
        set(4, freeFeatId);
        set(5, freeFeatDetail);
        set(6, lore);
        set(7, skill);
        set(8, description);
        set(9, src);
        set(10, url);
    }
}