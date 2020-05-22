/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables.records;


import ai.ragu.charactermanager.jooq.tables.CompanionItem;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record18;
import org.jooq.Row18;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CompanionItemRecord extends UpdatableRecordImpl<CompanionItemRecord> implements Record18<String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String> {

    private static final long serialVersionUID = -987986406;

    /**
     * Setter for <code>public.companion_item.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.companion_item.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.companion_item.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.companion_item.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.companion_item.level</code>.
     */
    public void setLevel(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.companion_item.level</code>.
     */
    public String getLevel() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.companion_item.actions</code>.
     */
    public void setActions(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.companion_item.actions</code>.
     */
    public String getActions() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.companion_item.price</code>.
     */
    public void setPrice(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.companion_item.price</code>.
     */
    public String getPrice() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.companion_item.hands</code>.
     */
    public void setHands(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.companion_item.hands</code>.
     */
    public String getHands() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.companion_item.bulk</code>.
     */
    public void setBulk(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.companion_item.bulk</code>.
     */
    public String getBulk() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.companion_item.contains</code>.
     */
    public void setContains(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.companion_item.contains</code>.
     */
    public String getContains() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.companion_item.usage</code>.
     */
    public void setUsage(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.companion_item.usage</code>.
     */
    public String getUsage() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.companion_item.amount</code>.
     */
    public void setAmount(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.companion_item.amount</code>.
     */
    public String getAmount() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.companion_item.action0</code>.
     */
    public void setAction0(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.companion_item.action0</code>.
     */
    public String getAction0() {
        return (String) get(10);
    }

    /**
     * Setter for <code>public.companion_item.action0desc</code>.
     */
    public void setAction0desc(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.companion_item.action0desc</code>.
     */
    public String getAction0desc() {
        return (String) get(11);
    }

    /**
     * Setter for <code>public.companion_item.action1</code>.
     */
    public void setAction1(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.companion_item.action1</code>.
     */
    public String getAction1() {
        return (String) get(12);
    }

    /**
     * Setter for <code>public.companion_item.action1desc</code>.
     */
    public void setAction1desc(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.companion_item.action1desc</code>.
     */
    public String getAction1desc() {
        return (String) get(13);
    }

    /**
     * Setter for <code>public.companion_item.description</code>.
     */
    public void setDescription(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.companion_item.description</code>.
     */
    public String getDescription() {
        return (String) get(14);
    }

    /**
     * Setter for <code>public.companion_item.src</code>.
     */
    public void setSrc(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>public.companion_item.src</code>.
     */
    public String getSrc() {
        return (String) get(15);
    }

    /**
     * Setter for <code>public.companion_item.url</code>.
     */
    public void setUrl(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>public.companion_item.url</code>.
     */
    public String getUrl() {
        return (String) get(16);
    }

    /**
     * Setter for <code>public.companion_item.speed</code>.
     */
    public void setSpeed(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>public.companion_item.speed</code>.
     */
    public String getSpeed() {
        return (String) get(17);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record18 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row18<String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String> fieldsRow() {
        return (Row18) super.fieldsRow();
    }

    @Override
    public Row18<String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String> valuesRow() {
        return (Row18) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return CompanionItem.COMPANION_ITEM.ID;
    }

    @Override
    public Field<String> field2() {
        return CompanionItem.COMPANION_ITEM.NAME;
    }

    @Override
    public Field<String> field3() {
        return CompanionItem.COMPANION_ITEM.LEVEL;
    }

    @Override
    public Field<String> field4() {
        return CompanionItem.COMPANION_ITEM.ACTIONS;
    }

    @Override
    public Field<String> field5() {
        return CompanionItem.COMPANION_ITEM.PRICE;
    }

    @Override
    public Field<String> field6() {
        return CompanionItem.COMPANION_ITEM.HANDS;
    }

    @Override
    public Field<String> field7() {
        return CompanionItem.COMPANION_ITEM.BULK;
    }

    @Override
    public Field<String> field8() {
        return CompanionItem.COMPANION_ITEM.CONTAINS;
    }

    @Override
    public Field<String> field9() {
        return CompanionItem.COMPANION_ITEM.USAGE;
    }

    @Override
    public Field<String> field10() {
        return CompanionItem.COMPANION_ITEM.AMOUNT;
    }

    @Override
    public Field<String> field11() {
        return CompanionItem.COMPANION_ITEM.ACTION0;
    }

    @Override
    public Field<String> field12() {
        return CompanionItem.COMPANION_ITEM.ACTION0DESC;
    }

    @Override
    public Field<String> field13() {
        return CompanionItem.COMPANION_ITEM.ACTION1;
    }

    @Override
    public Field<String> field14() {
        return CompanionItem.COMPANION_ITEM.ACTION1DESC;
    }

    @Override
    public Field<String> field15() {
        return CompanionItem.COMPANION_ITEM.DESCRIPTION;
    }

    @Override
    public Field<String> field16() {
        return CompanionItem.COMPANION_ITEM.SRC;
    }

    @Override
    public Field<String> field17() {
        return CompanionItem.COMPANION_ITEM.URL;
    }

    @Override
    public Field<String> field18() {
        return CompanionItem.COMPANION_ITEM.SPEED;
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
        return getActions();
    }

    @Override
    public String component5() {
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
        return getContains();
    }

    @Override
    public String component9() {
        return getUsage();
    }

    @Override
    public String component10() {
        return getAmount();
    }

    @Override
    public String component11() {
        return getAction0();
    }

    @Override
    public String component12() {
        return getAction0desc();
    }

    @Override
    public String component13() {
        return getAction1();
    }

    @Override
    public String component14() {
        return getAction1desc();
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
    public String component18() {
        return getSpeed();
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
        return getActions();
    }

    @Override
    public String value5() {
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
        return getContains();
    }

    @Override
    public String value9() {
        return getUsage();
    }

    @Override
    public String value10() {
        return getAmount();
    }

    @Override
    public String value11() {
        return getAction0();
    }

    @Override
    public String value12() {
        return getAction0desc();
    }

    @Override
    public String value13() {
        return getAction1();
    }

    @Override
    public String value14() {
        return getAction1desc();
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
    public String value18() {
        return getSpeed();
    }

    @Override
    public CompanionItemRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public CompanionItemRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public CompanionItemRecord value3(String value) {
        setLevel(value);
        return this;
    }

    @Override
    public CompanionItemRecord value4(String value) {
        setActions(value);
        return this;
    }

    @Override
    public CompanionItemRecord value5(String value) {
        setPrice(value);
        return this;
    }

    @Override
    public CompanionItemRecord value6(String value) {
        setHands(value);
        return this;
    }

    @Override
    public CompanionItemRecord value7(String value) {
        setBulk(value);
        return this;
    }

    @Override
    public CompanionItemRecord value8(String value) {
        setContains(value);
        return this;
    }

    @Override
    public CompanionItemRecord value9(String value) {
        setUsage(value);
        return this;
    }

    @Override
    public CompanionItemRecord value10(String value) {
        setAmount(value);
        return this;
    }

    @Override
    public CompanionItemRecord value11(String value) {
        setAction0(value);
        return this;
    }

    @Override
    public CompanionItemRecord value12(String value) {
        setAction0desc(value);
        return this;
    }

    @Override
    public CompanionItemRecord value13(String value) {
        setAction1(value);
        return this;
    }

    @Override
    public CompanionItemRecord value14(String value) {
        setAction1desc(value);
        return this;
    }

    @Override
    public CompanionItemRecord value15(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public CompanionItemRecord value16(String value) {
        setSrc(value);
        return this;
    }

    @Override
    public CompanionItemRecord value17(String value) {
        setUrl(value);
        return this;
    }

    @Override
    public CompanionItemRecord value18(String value) {
        setSpeed(value);
        return this;
    }

    @Override
    public CompanionItemRecord values(String value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9, String value10, String value11, String value12, String value13, String value14, String value15, String value16, String value17, String value18) {
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
        value18(value18);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CompanionItemRecord
     */
    public CompanionItemRecord() {
        super(CompanionItem.COMPANION_ITEM);
    }

    /**
     * Create a detached, initialised CompanionItemRecord
     */
    public CompanionItemRecord(String id, String name, String level, String actions, String price, String hands, String bulk, String contains, String usage, String amount, String action0, String action0desc, String action1, String action1desc, String description, String src, String url, String speed) {
        super(CompanionItem.COMPANION_ITEM);

        set(0, id);
        set(1, name);
        set(2, level);
        set(3, actions);
        set(4, price);
        set(5, hands);
        set(6, bulk);
        set(7, contains);
        set(8, usage);
        set(9, amount);
        set(10, action0);
        set(11, action0desc);
        set(12, action1);
        set(13, action1desc);
        set(14, description);
        set(15, src);
        set(16, url);
        set(17, speed);
    }
}