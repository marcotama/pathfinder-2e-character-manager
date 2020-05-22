/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables.records;


import ai.ragu.charactermanager.jooq.tables.WeaponTrait;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class WeaponTraitRecord extends UpdatableRecordImpl<WeaponTraitRecord> implements Record2<String, String> {

    private static final long serialVersionUID = -599720192;

    /**
     * Setter for <code>public.weapon_trait.weapon_id</code>.
     */
    public void setWeaponId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.weapon_trait.weapon_id</code>.
     */
    public String getWeaponId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.weapon_trait.trait</code>.
     */
    public void setTrait(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.weapon_trait.trait</code>.
     */
    public String getTrait() {
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
        return WeaponTrait.WEAPON_TRAIT.WEAPON_ID;
    }

    @Override
    public Field<String> field2() {
        return WeaponTrait.WEAPON_TRAIT.TRAIT;
    }

    @Override
    public String component1() {
        return getWeaponId();
    }

    @Override
    public String component2() {
        return getTrait();
    }

    @Override
    public String value1() {
        return getWeaponId();
    }

    @Override
    public String value2() {
        return getTrait();
    }

    @Override
    public WeaponTraitRecord value1(String value) {
        setWeaponId(value);
        return this;
    }

    @Override
    public WeaponTraitRecord value2(String value) {
        setTrait(value);
        return this;
    }

    @Override
    public WeaponTraitRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached WeaponTraitRecord
     */
    public WeaponTraitRecord() {
        super(WeaponTrait.WEAPON_TRAIT);
    }

    /**
     * Create a detached, initialised WeaponTraitRecord
     */
    public WeaponTraitRecord(String weaponId, String trait) {
        super(WeaponTrait.WEAPON_TRAIT);

        set(0, weaponId);
        set(1, trait);
    }
}