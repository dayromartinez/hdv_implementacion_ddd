package com.hdv.ddd.Experiencia.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.List;
import java.util.Objects;

public class ConocimientosAdquiridos implements ValueObject<String> {

    private final String value;

    public ConocimientosAdquiridos(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El campo de conocimientos adquiridios no puede ser vacío.");
        }
        if(this.value.length() < 50 || this.value.length() > 1000){
            throw new IllegalArgumentException("El campo de conocimientos adquiridos no puede tener menos de 100 ni más de 1000 carácteres con espacios incluidos");
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
        ConocimientosAdquiridos that = (ConocimientosAdquiridos) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
