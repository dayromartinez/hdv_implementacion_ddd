package com.hdv.ddd.Perfil.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class InformacionContacto implements ValueObject<String> {

    private final String value;

    public InformacionContacto(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El campo de información de contacto no puede ser vacío");
        }
        if(this.value.length() < 200 || this.value.length() > 1000){
            throw new IllegalArgumentException("El campo de información de contacto no puede tener menos de 200 ni más de 1000 carácteres con espacios incluidos");
        }
    }

    public String value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InformacionContacto that = (InformacionContacto) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
