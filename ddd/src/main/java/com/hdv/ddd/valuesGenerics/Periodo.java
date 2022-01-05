package com.hdv.ddd.valuesGenerics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Periodo implements ValueObject<List<String>> {

    private final List<String> value;

    public Periodo(List<String> value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.size() == 0 || this.value.size() == 1 || this.value.size() > 2){
            throw new IllegalArgumentException("La lista debe contener dos índices, el primero con la fecha de inicio, y el segundo con la fecha de finalización del período.");
        }

        Pattern pattern = Pattern.compile("^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$");
        Matcher matcherFechaInicio = pattern.matcher(this.value.get(0));
        Matcher matcherFechaFinal = pattern.matcher(this.value.get(1));
        if(!matcherFechaInicio.matches()){
            throw new IllegalArgumentException("Estructura de la fecha de inicio del período inválida. Ej: dd/mm/yyyy");
        }
        if(!matcherFechaFinal.matches()){
            throw new IllegalArgumentException("Estructura de la fecha de finalización del período inválida. Ej: dd/mm/yyyy");
        }
    }

    @Override
    public List<String> value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Periodo periodo = (Periodo) o;
        return Objects.equals(value, periodo.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
