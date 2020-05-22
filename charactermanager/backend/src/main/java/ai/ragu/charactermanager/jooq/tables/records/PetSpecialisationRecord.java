/*
 * This file is generated by jOOQ.
 */
package ai.ragu.charactermanager.jooq.tables.records;


import ai.ragu.charactermanager.jooq.tables.PetSpecialisation;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PetSpecialisationRecord extends UpdatableRecordImpl<PetSpecialisationRecord> implements Record4<String, String, String, String> {

    private static final long serialVersionUID = 1509782225;

    /**
     * Setter for <code>public.pet_specialisation.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.pet_specialisation.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.pet_specialisation.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.pet_specialisation.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.pet_specialisation.description</code>.
     */
    public void setDescription(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.pet_specialisation.description</code>.
     */
    public String getDescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.pet_specialisation.src</code>.
     */
    public void setSrc(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.pet_specialisation.src</code>.
     */
    public String getSrc() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<String, String, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return PetSpecialisation.PET_SPECIALISATION.ID;
    }

    @Override
    public Field<String> field2() {
        return PetSpecialisation.PET_SPECIALISATION.NAME;
    }

    @Override
    public Field<String> field3() {
        return PetSpecialisation.PET_SPECIALISATION.DESCRIPTION;
    }

    @Override
    public Field<String> field4() {
        return PetSpecialisation.PET_SPECIALISATION.SRC;
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
        return getDescription();
    }

    @Override
    public String component4() {
        return getSrc();
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
        return getDescription();
    }

    @Override
    public String value4() {
        return getSrc();
    }

    @Override
    public PetSpecialisationRecord value1(String value) {
        setId(value);
        return this;
    }

    @Override
    public PetSpecialisationRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public PetSpecialisationRecord value3(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public PetSpecialisationRecord value4(String value) {
        setSrc(value);
        return this;
    }

    @Override
    public PetSpecialisationRecord values(String value1, String value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PetSpecialisationRecord
     */
    public PetSpecialisationRecord() {
        super(PetSpecialisation.PET_SPECIALISATION);
    }

    /**
     * Create a detached, initialised PetSpecialisationRecord
     */
    public PetSpecialisationRecord(String id, String name, String description, String src) {
        super(PetSpecialisation.PET_SPECIALISATION);

        set(0, id);
        set(1, name);
        set(2, description);
        set(3, src);
    }
}
