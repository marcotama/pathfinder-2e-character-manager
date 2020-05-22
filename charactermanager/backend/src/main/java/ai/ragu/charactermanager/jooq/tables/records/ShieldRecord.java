/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables.records;


import ai.ragu.charactermanager.jooq.tables.Shield;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record17;
import org.jooq.Row17;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ShieldRecord extends UpdatableRecordImpl<ShieldRecord> implements Record17<String, String, Integer, String, Integer, String, String, String, Integer, String, Integer, Integer, String, String, String, String, String> {

    private static final long serialVersionUID = 863171942;

    /**
     * Setter for <code>public.shield.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.shield.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.shield.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.shield.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.shield.level</code>.
     */
    public void setLevel(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.shield.level</code>.
     */
    public Integer getLevel() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>public.shield.actions</code>.
     */
    public void setActions(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.shield.actions</code>.
     */
    public String getActions() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.shield.price</code>.
     */
    public void setPrice(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.shield.price</code>.
     */
    public Integer getPrice() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>public.shield.hands</code>.
     */
    public void setHands(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.shield.hands</code>.
     */
    public String getHands() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.shield.bulk</code>.
     */
    public void setBulk(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.shield.bulk</code>.
     */
    public String getBulk() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.shield.usage</code>.
     */
    public void setUsage(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.shield.usage</code>.
     */
    public String getUsage() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.shield.ac</code>.
     */
    public void setAc(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.shield.ac</code>.
     */
    public Integer getAc() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>public.shield.speed</code>.
     */
    public void setSpeed(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.shield.speed</code>.
     */
    public String getSpeed() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.shield.hardness</code>.
     */
    public void setHardness(Integer value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.shield.hardness</code>.
     */
    public Integer getHardness() {
        return (Integer) get(10);
    }

    /**
     * Setter for <code>public.shield.hp</code>.
     */
    public void setHp(Integer value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.shield.hp</code>.
     */
    public Integer getHp() {
        return (Integer) get(11);
    }

    /**
     * Setter for <code>public.shield.action0</code>.
     */
    public void setAction0(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.shield.action0</code>.
     */
    public String getAction0() {
        return (String) get(12);
    }

    /**
     * Setter for <code>public.shield.action0desc</code>.
     */
    public void setAction0desc(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.shield.action0desc</code>.
     */
    public String getAction0desc() {
        return (String) get(13);
    }

    /**
     * Setter for <code>public.shield.description</code>.
     */
    public void setDescription(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.shield.description</code>.
     */
    public String getDescription() {
        return (String) get(14);
    }

    /**
     * Setter for <code>public.shield.src</code>.
     */
    public void setSrc(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>public.shield.src</code>.
     */
    public String getSrc() {
        return (String) get(15);
    }

    /**
     * Setter for <code>public.shield.url</code>.
     */
    public void setUrl(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>public.shield.url</code>.
     */
    public String getUrl() {
        return (String) get(16);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record17 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row17<String, String, Integer, String, Integer, String, String, String, Integer, String, Integer, Integer, String, String, String, String, String> fieldsRow() {
        return (Row17) super.fieldsRow();
    }

    @Override
    public Row17<String, String, Integer, String, Integer, String, String, String, Integer, String, Integer, Integer, String, String, String, String, String> valuesRow() {
        return (Row17) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Shield.SHIELD.ID;
    }

    @Override
    public Field<String> field2() {
        return Shield.SHIELD.NAME;
    }

    @Override
    public Field<Integer> field3() {
        return Shield.SHIELD.LEVEL;
    }

    @Override
    public Field<String> field4() {
        return Shield.SHIELD.ACTIONS;
    }

    @Override
    public Field<Integer> field5() {
        return Shield.SHIELD.PRICE;
    }

    @Override
    public Field<String> field6() {
        return Shield.SHIELD.HANDS;
    }

    @Override
    public Field<String> field7() {
        return Shield.SHIELD.BULK;
    }

    @Override
    public Field<String> field8() {
        return Shield.SHIELD.USAGE;
    }

    @Override
    public Field<Integer> field9() {
        return Shield.SHIELD.AC;
    }

    @Override
    public Field<String> field10() {
        return Shield.SHIELD.SPEED;
    }

    @Override
    public Field<Integer> field11() {
        return Shield.SHIELD.HARDNESS;
    }

    @Override
    public Field<Integer> field12() {
        return Shield.SHIELD.HP;
    }

    @Override
    public Field<String> field13() {
        return Shield.SHIELD.ACTION0;
    }

    @Override
    public Field<String> field14() {
        return Shield.SHIELD.ACTION0DESC;
    }

    @Override
    public Field<String> field15() {
        return Shield.SHIELD.DESCRIPTION;
    }

    @Override
    public Field<String> field16() {
        return Shield.SHIELD.SRC;
    }

    @Override
    public Field<String> field17() {
        return Shield.SHIELD.URL;
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
    public Integer component3() {
        return getLevel();
    }

    @Override
    public String component4() {
        return getActions();
    }

    @Override
    public Integer component5() {
        return getPrice();
    }

    @Override
    public String component6() {
        return getHands();
    }

    @Override
    public String component7() {
        return getBulk();
    }

    @Override
    public String component8() {
        return getUsage();
    }

    @Override
    public Integer component9() {
        return getAc();
    }

    @Override
    public String component10() {
        return getSpeed();
    }

    @Override
    public Integer component11() {
        return getHardness();
    }

    @Override
    public Integer component12() {
        return getHp();
    }

    @Override
    public String component13() {
        return getAction0();
    }

    @Override
    public String component14() {
        return getAction0desc();
    }

    @Override
    public String component15() {
        return getDescription();
    }

    @Override
    public String component16() {
        return getSrc();
    }

    @Override
    public String component17() {
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
    public Integer value3() {
        return getLevel();
    }

    @Override
    public String value4() {
        return getActions();
    }

    @Override
    public Integer value5() {
        return getPrice();
    }

    @Override
    public String value6() {
        return getHands();
    }

    @Override
    public String value7() {
        return getBulk();
    }

    @Override
    public String value8() {
        return getUsage();
    }

    @Override
    public Integer value9() {
        return getAc();
    }

    @Override
    public String value10() {
        return getSpeed();
    }

    @Override
    public Integer value11() {
        return getHardness();
    }

    @Override
    public Integer value12() {
        return getHp();
    }

    @Override
    public String value13() {
        return getAction0();
    }

    @Override
    public String value14() {
        return getAction0desc();
    }

    @Override
    public String value15() {
        return getDescription();
    }

    @Override
    public String value16() {
        return getSrc();
    }

    @Override
    public String value17() {
        return getUrl();
    }

    @Override
    public ShieldRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public ShieldRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public ShieldRecord value3(Integer value) {
        setLevel(value);
        return this;
    }

    @Override
    public ShieldRecord value4(String value) {
        setActions(value);
        return this;
    }

    @Override
    public ShieldRecord value5(Integer value) {
        setPrice(value);
        return this;
    }

    @Override
    public ShieldRecord value6(String value) {
        setHands(value);
        return this;
    }

    @Override
    public ShieldRecord value7(String value) {
        setBulk(value);
        return this;
    }

    @Override
    public ShieldRecord value8(String value) {
        setUsage(value);
        return this;
    }

    @Override
    public ShieldRecord value9(Integer value) {
        setAc(value);
        return this;
    }

    @Override
    public ShieldRecord value10(String value) {
        setSpeed(value);
        return this;
    }

    @Override
    public ShieldRecord value11(Integer value) {
        setHardness(value);
        return this;
    }

    @Override
    public ShieldRecord value12(Integer value) {
        setHp(value);
        return this;
    }

    @Override
    public ShieldRecord value13(String value) {
        setAction0(value);
        return this;
    }

    @Override
    public ShieldRecord value14(String value) {
        setAction0desc(value);
        return this;
    }

    @Override
    public ShieldRecord value15(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public ShieldRecord value16(String value) {
        setSrc(value);
        return this;
    }

    @Override
    public ShieldRecord value17(String value) {
        setUrl(value);
        return this;
    }

    @Override
    public ShieldRecord values(String value1, String value2, Integer value3, String value4, Integer value5, String value6, String value7, String value8, Integer value9, String value10, Integer value11, Integer value12, String value13, String value14, String value15, String value16, String value17) {
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
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ShieldRecord
     */
    public ShieldRecord() {
        super(Shield.SHIELD);
    }

    /**
     * Create a detached, initialised ShieldRecord
     */
    public ShieldRecord(String id, String name, Integer level, String actions, Integer price, String hands, String bulk, String usage, Integer ac, String speed, Integer hardness, Integer hp, String action0, String action0desc, String description, String src, String url) {
        super(Shield.SHIELD);

        set(0, id);
        set(1, name);
        set(2, level);
        set(3, actions);
        set(4, price);
        set(5, hands);
        set(6, bulk);
        set(7, usage);
        set(8, ac);
        set(9, speed);
        set(10, hardness);
        set(11, hp);
        set(12, action0);
        set(13, action0desc);
        set(14, description);
        set(15, src);
        set(16, url);
    }
}
