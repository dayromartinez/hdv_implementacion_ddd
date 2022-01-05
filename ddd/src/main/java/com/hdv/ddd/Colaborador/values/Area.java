package com.hdv.ddd.Colaborador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Area implements ValueObject<String> {

    private final String value;

    public Area(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El área de desempeño del colaborador no puede ser un campo vacío");
        }
    }

    public String value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return Objects.equals(value, area.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
