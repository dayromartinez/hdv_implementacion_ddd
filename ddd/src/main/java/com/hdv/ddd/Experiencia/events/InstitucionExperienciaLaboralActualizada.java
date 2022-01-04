package com.hdv.ddd.Experiencia.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.Experiencia.values.ExperienciaLaboralId;
import com.hdv.ddd.valuesGenerics.Institucion;

public class InstitucionExperienciaLaboralActualizada extends DomainEvent {

    private final ExperienciaLaboralId experienciaLaboralId;
    private final Institucion institucion;

    public InstitucionExperienciaLaboralActualizada(ExperienciaLaboralId experienciaLaboralId, Institucion institucion) {
        super("sofka.hojadevida.experiencia.institucionexperiencialaboralactualizada");
        this.experienciaLaboralId = experienciaLaboralId;
        this.institucion = institucion;
    }

    public ExperienciaLaboralId getExperienciaLaboralId() {
        return experienciaLaboralId;
    }

    public Institucion getInstitucion() {
        return institucion;
    }
}
