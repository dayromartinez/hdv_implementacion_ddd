package com.hdv.ddd.GestionEducacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Tipo implements ValueObject<String> {

    private final String value;

    public Tipo(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El campo de tipo de estudio no puede ser vacío");
        }
        if(!this.value.equals("Técnico") && !this.value.equals("Pregrado") && !this.value.equals("Maestría") && !this.value.equals("Doctorado")){
            throw new IllegalArgumentException("El tipo de estudios descrito es incorrecto. Las opciones disponibles son: 'Técnico', 'Pregrado', 'Maestría' o 'Doctorado'.");
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
        Tipo tipo = (Tipo) o;
        return Objects.equals(value, tipo.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
