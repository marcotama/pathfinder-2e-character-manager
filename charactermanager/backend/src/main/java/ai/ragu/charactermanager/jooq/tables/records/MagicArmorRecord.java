/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables.records;


import ai.ragu.charactermanager.jooq.tables.MagicArmor;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record15;
import org.jooq.Row15;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MagicArmorRecord extends UpdatableRecordImpl<MagicArmorRecord> implements Record15<String, String, Integer, Integer, String, Integer, Integer, String, String, String, String, String, String, String, String> {

    private static final long serialVersionUID = 1442631958;

    /**
     * Setter for <code>public.magic_armor.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.magic_armor.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.magic_armor.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.magic_armor.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.magic_armor.level</code>.
     */
    public void setLevel(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.magic_armor.level</code>.
     */
    public Integer getLevel() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>public.magic_armor.price</code>.
     */
    public void setPrice(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.magic_armor.price</code>.
     */
    public Integer getPrice() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.magic_armor.identity</code>.
     */
    public void setIdentity(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.magic_armor.identity</code>.
     */
    public String getIdentity() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.magic_armor.potency</code>.
     */
    public void setPotency(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.magic_armor.potency</code>.
     */
    public Integer getPotency() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>public.magic_armor.resilient</code>.
     */
    public void setResilient(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.magic_armor.resilient</code>.
     */
    public Integer getResilient() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>public.magic_armor.action0</code>.
     */
    public void setAction0(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.magic_armor.action0</code>.
     */
    public String getAction0() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.magic_armor.action0desc</code>.
     */
    public void setAction0desc(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.magic_armor.action0desc</code>.
     */
    public String getAction0desc() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.magic_armor.action1</code>.
     */
    public void setAction1(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.magic_armor.action1</code>.
     */
    public String getAction1() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.magic_armor.action1desc</code>.
     */
    public void setAction1desc(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.magic_armor.action1desc</code>.
     */
    public String getAction1desc() {
        return (String) get(10);
    }

    /**
     * Setter for <code>public.magic_armor.rune</code>.
     */
    public void setRune(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.magic_armor.rune</code>.
     */
    public String getRune() {
        return (String) get(11);
    }

    /**
     * Setter for <code>public.magic_armor.description</code>.
     */
    public void setDescription(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.magic_armor.description</code>.
     */
    public String getDescription() {
        return (String) get(12);
    }

    /**
     * Setter for <code>public.magic_armor.src</code>.
     */
    public void setSrc(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.magic_armor.src</code>.
     */
    public String getSrc() {
        return (String) get(13);
    }

    /**
     * Setter for <code>public.magic_armor.url</code>.
     */
    public void setUrl(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.magic_armor.url</code>.
     */
    public String getUrl() {
        return (String) get(14);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record15 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row15<String, String, Integer, Integer, String, Integer, Integer, String, String, String, String, String, String, String, String> fieldsRow() {
        return (Row15) super.fieldsRow();
    }

    @Override
    public Row15<String, String, Integer, Integer, String, Integer, Integer, String, String, String, String, String, String, String, String> valuesRow() {
        return (Row15) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return MagicArmor.MAGIC_ARMOR.ID;
    }

    @Override
    public Field<String> field2() {
        return MagicArmor.MAGIC_ARMOR.NAME;
    }

    @Override
    public Field<Integer> field3() {
        return MagicArmor.MAGIC_ARMOR.LEVEL;
    }

    @Override
    public Field<Integer> field4() {
        return MagicArmor.MAGIC_ARMOR.PRICE;
    }

    @Override
    public Field<String> field5() {
        return MagicArmor.MAGIC_ARMOR.IDENTITY;
    }

    @Override
    public Field<Integer> field6() {
        return MagicArmor.MAGIC_ARMOR.POTENCY;
    }

    @Override
    public Field<Integer> field7() {
        return MagicArmor.MAGIC_ARMOR.RESILIENT;
    }

    @Override
    public Field<String> field8() {
        return MagicArmor.MAGIC_ARMOR.ACTION0;
    }

    @Override
    public Field<String> field9() {
        return MagicArmor.MAGIC_ARMOR.ACTION0DESC;
    }

    @Override
    public Field<String> field10() {
        return MagicArmor.MAGIC_ARMOR.ACTION1;
    }

    @Override
    public Field<String> field11() {
        return MagicArmor.MAGIC_ARMOR.ACTION1DESC;
    }

    @Override
    public Field<String> field12() {
        return MagicArmor.MAGIC_ARMOR.RUNE;
    }

    @Override
    public Field<String> field13() {
        return MagicArmor.MAGIC_ARMOR.DESCRIPTION;
    }

    @Override
    public Field<String> field14() {
        return MagicArmor.MAGIC_ARMOR.SRC;
    }

    @Override
    public Field<String> field15() {
        return MagicArmor.MAGIC_ARMOR.URL;
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
    public Integer component4() {
        return getPrice();
    }

    @Override
    public String component5() {
        return getIdentity();
    }

    @Override
    public Integer component6() {
        return getPotency();
    }

    @Override
    public Integer component7() {
        return getResilient();
    }

    @Override
    public String component8() {
        return getAction0();
    }

    @Override
    public String component9() {
        return getAction0desc();
    }

    @Override
    public String component10() {
        return getAction1();
    }

    @Override
    public String component11() {
        return getAction1desc();
    }

    @Override
    public String component12() {
        return getRune();
    }

    @Override
    public String component13() {
        return getDescription();
    }

    @Override
    public String component14() {
        return getSrc();
    }

    @Override
    public String component15() {
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
    public Integer value4() {
        return getPrice();
    }

    @Override
    public String value5() {
        return getIdentity();
    }

    @Override
    public Integer value6() {
        return getPotency();
    }

    @Override
    public Integer value7() {
        return getResilient();
    }

    @Override
    public String value8() {
        return getAction0();
    }

    @Override
    public String value9() {
        return getAction0desc();
    }

    @Override
    public String value10() {
        return getAction1();
    }

    @Override
    public String value11() {
        return getAction1desc();
    }

    @Override
    public String value12() {
        return getRune();
    }

    @Override
    public String value13() {
        return getDescription();
    }

    @Override
    public String value14() {
        return getSrc();
    }

    @Override
    public String value15() {
        return getUrl();
    }

    @Override
    public MagicArmorRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public MagicArmorRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public MagicArmorRecord value3(Integer value) {
        setLevel(value);
        return this;
    }

    @Override
    public MagicArmorRecord value4(Integer value) {
        setPrice(value);
        return this;
    }

    @Override
    public MagicArmorRecord value5(String value) {
        setIdentity(value);
        return this;
    }

    @Override
    public MagicArmorRecord value6(Integer value) {
        setPotency(value);
        return this;
    }

    @Override
    public MagicArmorRecord value7(Integer value) {
        setResilient(value);
        return this;
    }

    @Override
    public MagicArmorRecord value8(String value) {
        setAction0(value);
        return this;
    }

    @Override
    public MagicArmorRecord value9(String value) {
        setAction0desc(value);
        return this;
    }

    @Override
    public MagicArmorRecord value10(String value) {
        setAction1(value);
        return this;
    }

    @Override
    public MagicArmorRecord value11(String value) {
        setAction1desc(value);
        return this;
    }

    @Override
    public MagicArmorRecord value12(String value) {
        setRune(value);
        return this;
    }

    @Override
    public MagicArmorRecord value13(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public MagicArmorRecord value14(String value) {
        setSrc(value);
        return this;
    }

    @Override
    public MagicArmorRecord value15(String value) {
        setUrl(value);
        return this;
    }

    @Override
    public MagicArmorRecord values(String value1, String value2, Integer value3, Integer value4, String value5, Integer value6, Integer value7, String value8, String value9, String value10, String value11, String value12, String value13, String value14, String value15) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MagicArmorRecord
     */
    public MagicArmorRecord() {
        super(MagicArmor.MAGIC_ARMOR);
    }

    /**
     * Create a detached, initialised MagicArmorRecord
     */
    public MagicArmorRecord(String id, String name, Integer level, Integer price, String identity, Integer potency, Integer resilient, String action0, String action0desc, String action1, String action1desc, String rune, String description, String src, String url) {
        super(MagicArmor.MAGIC_ARMOR);

        set(0, id);
        set(1, name);
        set(2, level);
        set(3, price);
        set(4, identity);
        set(5, potency);
        set(6, resilient);
        set(7, action0);
        set(8, action0desc);
        set(9, action1);
        set(10, action1desc);
        set(11, rune);
        set(12, description);
        set(13, src);
        set(14, url);
    }
}
