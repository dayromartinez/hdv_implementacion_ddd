package com.hdv.ddd.valuesGenerics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Institucion implements ValueObject<String> {

    private final String value;

    public Institucion(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El campo de la institución educativa no puede ser vacío");
        }
        if(this.value.length() > 200){
            throw new IllegalArgumentException("El nombre de la institución educativa no puede exceder los 200 carácteres con espacios incluidos");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Institucion that = (Institucion) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
