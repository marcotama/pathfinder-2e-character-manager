/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables.records;


import ai.ragu.charactermanager.jooq.tables.Armor;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record15;
import org.jooq.Row15;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ArmorRecord extends UpdatableRecordImpl<ArmorRecord> implements Record15<String, String, String, String, String, String, String, String, String, String, String, String, String, String, String> {

    private static final long serialVersionUID = -80312107;

    /**
     * Setter for <code>public.armor.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.armor.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.armor.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.armor.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.armor.level</code>.
     */
    public void setLevel(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.armor.level</code>.
     */
    public String getLevel() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.armor.price</code>.
     */
    public void setPrice(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.armor.price</code>.
     */
    public String getPrice() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.armor.proficiency</code>.
     */
    public void setProficiency(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.armor.proficiency</code>.
     */
    public String getProficiency() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.armor.ac_bonus</code>.
     */
    public void setAcBonus(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.armor.ac_bonus</code>.
     */
    public String getAcBonus() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.armor.dex_cap</code>.
     */
    public void setDexCap(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.armor.dex_cap</code>.
     */
    public String getDexCap() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.armor.check_penalty</code>.
     */
    public void setCheckPenalty(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.armor.check_penalty</code>.
     */
    public String getCheckPenalty() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.armor.speed_penalty</code>.
     */
    public void setSpeedPenalty(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.armor.speed_penalty</code>.
     */
    public String getSpeedPenalty() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.armor.strength</code>.
     */
    public void setStrength(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.armor.strength</code>.
     */
    public String getStrength() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.armor.bulk</code>.
     */
    public void setBulk(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.armor.bulk</code>.
     */
    public String getBulk() {
        return (String) get(10);
    }

    /**
     * Setter for <code>public.armor.armor_group</code>.
     */
    public void setArmorGroup(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.armor.armor_group</code>.
     */
    public String getArmorGroup() {
        return (String) get(11);
    }

    /**
     * Setter for <code>public.armor.description</code>.
     */
    public void setDescription(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.armor.description</code>.
     */
    public String getDescription() {
        return (String) get(12);
    }

    /**
     * Setter for <code>public.armor.src</code>.
     */
    public void setSrc(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.armor.src</code>.
     */
    public String getSrc() {
        return (String) get(13);
    }

    /**
     * Setter for <code>public.armor.url</code>.
     */
    public void setUrl(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.armor.url</code>.
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
    public Row15<String, String, String, String, String, String, String, String, String, String, String, String, String, String, String> fieldsRow() {
        return (Row15) super.fieldsRow();
    }

    @Override
    public Row15<String, String, String, String, String, String, String, String, String, String, String, String, String, String, String> valuesRow() {
        return (Row15) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Armor.ARMOR.ID;
    }

    @Override
    public Field<String> field2() {
        return Armor.ARMOR.NAME;
    }

    @Override
    public Field<String> field3() {
        return Armor.ARMOR.LEVEL;
    }

    @Override
    public Field<String> field4() {
        return Armor.ARMOR.PRICE;
    }

    @Override
    public Field<String> field5() {
        return Armor.ARMOR.PROFICIENCY;
    }

    @Override
    public Field<String> field6() {
        return Armor.ARMOR.AC_BONUS;
    }

    @Override
    public Field<String> field7() {
        return Armor.ARMOR.DEX_CAP;
    }

    @Override
    public Field<String> field8() {
        return Armor.ARMOR.CHECK_PENALTY;
    }

    @Override
    public Field<String> field9() {
        return Armor.ARMOR.SPEED_PENALTY;
    }

    @Override
    public Field<String> field10() {
        return Armor.ARMOR.STRENGTH;
    }

    @Override
    public Field<String> field11() {
        return Armor.ARMOR.BULK;
    }

    @Override
    public Field<String> field12() {
        return Armor.ARMOR.ARMOR_GROUP;
    }

    @Override
    public Field<String> field13() {
        return Armor.ARMOR.DESCRIPTION;
    }

    @Override
    public Field<String> field14() {
        return Armor.ARMOR.SRC;
    }

    @Override
    public Field<String> field15() {
        return Armor.ARMOR.URL;
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
        return getLevel();
    }

    @Override
    public String component4() {
        return getPrice();
    }

    @Override
    public String component5() {
        return getProficiency();
    }

    @Override
    public String component6() {
        return getAcBonus();
    }

    @Override
    public String component7() {
        return getDexCap();
    }

    @Override
    public String component8() {
        return getCheckPenalty();
    }

    @Override
    public String component9() {
        return getSpeedPenalty();
    }

    @Override
    public String component10() {
        return getStrength();
    }

    @Override
    public String component11() {
        return getBulk();
    }

    @Override
    public String component12() {
        return getArmorGroup();
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
    public String value3() {
        return getLevel();
    }

    @Override
    public String value4() {
        return getPrice();
    }

    @Override
    public String value5() {
        return getProficiency();
    }

    @Override
    public String value6() {
        return getAcBonus();
    }

    @Override
    public String value7() {
        return getDexCap();
    }

    @Override
    public String value8() {
        return getCheckPenalty();
    }

    @Override
    public String value9() {
        return getSpeedPenalty();
    }

    @Override
    public String value10() {
        return getStrength();
    }

    @Override
    public String value11() {
        return getBulk();
    }

    @Override
    public String value12() {
        return getArmorGroup();
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
    public ArmorRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public ArmorRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public ArmorRecord value3(String value) {
        setLevel(value);
        return this;
    }

    @Override
    public ArmorRecord value4(String value) {
        setPrice(value);
        return this;
    }

    @Override
    public ArmorRecord value5(String value) {
        setProficiency(value);
        return this;
    }

    @Override
    public ArmorRecord value6(String value) {
        setAcBonus(value);
        return this;
    }

    @Override
    public ArmorRecord value7(String value) {
        setDexCap(value);
        return this;
    }

    @Override
    public ArmorRecord value8(String value) {
        setCheckPenalty(value);
        return this;
    }

    @Override
    public ArmorRecord value9(String value) {
        setSpeedPenalty(value);
        return this;
    }

    @Override
    public ArmorRecord value10(String value) {
        setStrength(value);
        return this;
    }

    @Override
    public ArmorRecord value11(String value) {
        setBulk(value);
        return this;
    }

    @Override
    public ArmorRecord value12(String value) {
        setArmorGroup(value);
        return this;
    }

    @Override
    public ArmorRecord value13(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public ArmorRecord value14(String value) {
        setSrc(value);
        return this;
    }

    @Override
    public ArmorRecord value15(String value) {
        setUrl(value);
        return this;
    }

    @Override
    public ArmorRecord values(String value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9, String value10, String value11, String value12, String value13, String value14, String value15) {
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
     * Create a detached ArmorRecord
     */
    public ArmorRecord() {
        super(Armor.ARMOR);
    }

    /**
     * Create a detached, initialised ArmorRecord
     */
    public ArmorRecord(String id, String name, String level, String price, String proficiency, String acBonus, String dexCap, String checkPenalty, String speedPenalty, String strength, String bulk, String armorGroup, String description, String src, String url) {
        super(Armor.ARMOR);

        set(0, id);
        set(1, name);
        set(2, level);
        set(3, price);
        set(4, proficiency);
        set(5, acBonus);
        set(6, dexCap);
        set(7, checkPenalty);
        set(8, speedPenalty);
        set(9, strength);
        set(10, bulk);
        set(11, armorGroup);
        set(12, description);
        set(13, src);
        set(14, url);
    }
}