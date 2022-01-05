package com.hdv.ddd.Experiencia.values;

import co.com.sofka.domain.generic.Identity;

public class ExperienciaLaboralId extends Identity {

    public ExperienciaLaboralId() {
    }

    private ExperienciaLaboralId(String id) {
        super(id);
    }

    public static ExperienciaLaboralId of(String id){
        return new ExperienciaLaboralId(id);
    }
}
