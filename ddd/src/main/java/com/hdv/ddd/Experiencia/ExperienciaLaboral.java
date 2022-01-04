package com.hdv.ddd.Experiencia;

import co.com.sofka.domain.generic.Entity;
import com.hdv.ddd.Experiencia.values.ConocimientosAdquiridos;
import com.hdv.ddd.Experiencia.values.ExperienciaLaboralId;
import com.hdv.ddd.valuesGenerics.Institucion;
import com.hdv.ddd.valuesGenerics.Periodo;

public class ExperienciaLaboral extends Entity<ExperienciaLaboralId> {

    protected Institucion institucion;
    protected Periodo periodo;
    protected ConocimientosAdquiridos conocimientosAdquiridos;

    public ExperienciaLaboral(ExperienciaLaboralId entityId, Institucion institucion, Periodo periodo, ConocimientosAdquiridos conocimientosAdquiridos) {
        super(entityId);
        this.institucion = institucion;
        this.periodo = periodo;
        this.conocimientosAdquiridos = conocimientosAdquiridos;
    }
}
