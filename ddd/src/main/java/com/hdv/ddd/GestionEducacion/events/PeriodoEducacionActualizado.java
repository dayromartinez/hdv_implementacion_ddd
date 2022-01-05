package com.hdv.ddd.GestionEducacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.GestionEducacion.values.EducacionId;
import com.hdv.ddd.valuesGenerics.Periodo;

public class PeriodoEducacionActualizado extends DomainEvent {

    private final EducacionId educacionId;
    private final Periodo periodo;

    public PeriodoEducacionActualizado(EducacionId educacionId, Periodo periodo) {
        super("sofka.hojadevida.gestioneducacion.periodoeducacionactualizado");
        this.educacionId = educacionId;
        this.periodo = periodo;
    }

    public EducacionId getEducacionId() {
        return educacionId;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
