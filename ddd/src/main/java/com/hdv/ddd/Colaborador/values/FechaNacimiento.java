package com.hdv.ddd.Colaborador.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FechaNacimiento implements ValueObject<String> {

    private final String value;

    public FechaNacimiento(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("La fecha de nacimiento del colaborador no puede ser vacía, ni que fuera Amparo Grisales.");
        }

        Pattern pattern = Pattern.compile("^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$");
        Matcher matcher = pattern.matcher(this.value);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Estructura de la fecha inválida. Ej: dd/mm/yyyy");
        }
    }

    public String value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FechaNacimiento that = (FechaNacimiento) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
