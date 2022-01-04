package com.hdv.ddd.Experiencia.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.Experiencia.values.ConocimientosAdquiridos;
import com.hdv.ddd.Experiencia.values.ExperienciaLaboralId;
import com.hdv.ddd.valuesGenerics.Institucion;
import com.hdv.ddd.valuesGenerics.Periodo;

public class ExperienciaLaboralAgregada extends DomainEvent {

    private final ExperienciaLaboralId entityId;
    private final Institucion institucion;
    private final Periodo periodo;
    private final ConocimientosAdquiridos conocimientosAdquiridos;

    public ExperienciaLaboralAgregada(ExperienciaLaboralId entityId, Institucion institucion, Periodo periodo, ConocimientosAdquiridos conocimientosAdquiridos) {
        super("sofka.hojadevida.experiencia.experiencialaboralagregada");
        this.entityId = entityId;
        this.institucion = institucion;
        this.periodo = periodo;
        this.conocimientosAdquiridos = conocimientosAdquiridos;
    }

    public ExperienciaLaboralId getEntityId() {
        return entityId;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public ConocimientosAdquiridos getConocimientosAdquiridos() {
        return conocimientosAdquiridos;
    }
}
