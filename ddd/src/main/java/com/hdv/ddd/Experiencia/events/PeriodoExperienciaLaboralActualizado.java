package com.hdv.ddd.Experiencia.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.Experiencia.values.ExperienciaLaboralId;
import com.hdv.ddd.valuesGenerics.Periodo;

public class PeriodoExperienciaLaboralActualizado extends DomainEvent {

    private final ExperienciaLaboralId experienciaLaboralId;
    private final Periodo periodo;

    public PeriodoExperienciaLaboralActualizado(ExperienciaLaboralId experienciaLaboralId, Periodo periodo) {
        super("sofka.hojadevida.experiencia.periodoexperiencialaboralactualizado");
        this.experienciaLaboralId = experienciaLaboralId;
        this.periodo = periodo;
    }

    public ExperienciaLaboralId getExperienciaLaboralId() {
        return experienciaLaboralId;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
