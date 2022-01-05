package com.hdv.ddd.GestionEducacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Estudio implements ValueObject<String> {

    private final String value;

    public Estudio(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El campo del nombre del estudio no puede ser vacío.");
        }
        if(this.value.length() > 200){
            throw new IllegalArgumentException("El campo del nombre del estudio no puede exceder los 200 carácteres con espacios incluidos");
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
        Estudio estudio = (Estudio) o;
        return Objects.equals(value, estudio.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
