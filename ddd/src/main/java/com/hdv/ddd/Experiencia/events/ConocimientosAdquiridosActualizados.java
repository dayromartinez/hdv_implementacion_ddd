package com.hdv.ddd.Experiencia.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.Experiencia.values.ConocimientosAdquiridos;
import com.hdv.ddd.Experiencia.values.ExperienciaLaboralId;

public class ConocimientosAdquiridosActualizados extends DomainEvent {

    private final ExperienciaLaboralId experienciaLaboralId;
    private final ConocimientosAdquiridos conocimientosAdquiridos;

    public ConocimientosAdquiridosActualizados(ExperienciaLaboralId experienciaLaboralId, ConocimientosAdquiridos conocimientosAdquiridos) {
        super("sofka.hojadevida.experiencia.conocimientosadquiridosexperiencialaboralactualizados");
        this.experienciaLaboralId = experienciaLaboralId;
        this.conocimientosAdquiridos = conocimientosAdquiridos;
    }

    public ExperienciaLaboralId getExperienciaLaboralId() {
        return experienciaLaboralId;
    }

    public ConocimientosAdquiridos getConocimientosAdquiridos() {
        return conocimientosAdquiridos;
    }
}
