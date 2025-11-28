package com.bancolombia.cuentas.domain;

import com.bancolombia.cuentas.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public class Domain {

    private UUID id;
    private String idAsString;

    protected Domain(final UUID id) {
        setId(id);
    }

    protected Domain(final String id) {
        setId(id);
    }

    public void generateId(){
        this.id = UUIDHelper.generate();
    }

    public final UUID getId() {
        return UUIDHelper.isDefault(id) ? UUIDHelper.convertToUUID(idAsString) : id;
    }

    private void setId(final UUID id) {
        this.id = id;
    }

    private void setId(final String id) {
        this.idAsString = id;
    }
}
