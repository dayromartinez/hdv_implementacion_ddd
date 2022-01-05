package com.hdv.ddd.Experiencia.commands;

import co.com.sofka.domain.generic.Command;
import com.hdv.ddd.Experiencia.values.ExperienciaId;
import com.hdv.ddd.Experiencia.values.ExperienciaLaboralId;
import com.hdv.ddd.valuesGenerics.Institucion;

public class ActualizarInstitucionExperienciaLaboral extends Command {

    private final ExperienciaId experienciaId;
    private final ExperienciaLaboralId experienciaLaboralId;
    private final Institucion institucion;

    public ActualizarInstitucionExperienciaLaboral(ExperienciaId experienciaId, ExperienciaLaboralId experienciaLaboralId, Institucion institucion) {
        this.experienciaId = experienciaId;
        this.experienciaLaboralId = experienciaLaboralId;
        this.institucion = institucion;
    }

    public ExperienciaId getExperienciaId() {
        return experienciaId;
    }

    public ExperienciaLaboralId getExperienciaLaboralId() {
        return experienciaLaboralId;
    }

    public Institucion getInstitucion() {
        return institucion;
    }
}
