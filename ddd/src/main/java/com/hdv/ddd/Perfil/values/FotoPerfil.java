package com.hdv.ddd.Perfil.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FotoPerfil implements ValueObject<String> {

    private final String value;

    public FotoPerfil(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("La url de la foto del perfil no puede ser vacía");
        }
        Pattern pattern = Pattern.compile("^https?:\\/\\/[\\w\\-]+(\\.[\\w\\-]+)+[/#?]?.*$");
        Matcher matcher = pattern.matcher(this.value);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Estructura de la url de la imagen inválida. Ej: https://www.urlimagen.com");
        }
    }

    public String value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FotoPerfil that = (FotoPerfil) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
