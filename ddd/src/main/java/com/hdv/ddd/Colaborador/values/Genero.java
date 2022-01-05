package com.hdv.ddd.Colaborador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Genero implements ValueObject<String> {

    private final String value;

    public Genero(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El género del colaborador no puede ser vacío");
        }
        if(!this.value.equals("Otro") && !this.value.equals("Femenino") && !this.value.equals("Masculino")){
            throw new IllegalArgumentException("El género solo puede ser o 'Femenino', 'Masculino' o 'Otro'.");
        }
    }

    public String value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genero genero = (Genero) o;
        return Objects.equals(value, genero.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
