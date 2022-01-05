package com.hdv.ddd.valuesGenerics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreCompleto implements ValueObject<String> {

    private final String value;

    public NombreCompleto(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El campo del nombre completo no puede ser vacío");
        }
        if(this.value.length() > 200){
            throw new IllegalArgumentException("El nombre completo de la persona no puede exceder los 200 carácteres con espacios incluidos");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
