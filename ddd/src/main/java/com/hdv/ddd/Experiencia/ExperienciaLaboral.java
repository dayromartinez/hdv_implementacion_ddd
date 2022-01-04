package com.hdv.ddd.Experiencia;

import co.com.sofka.domain.generic.Entity;
import com.hdv.ddd.Experiencia.values.ConocimientosAdquiridos;
import com.hdv.ddd.Experiencia.values.ExperienciaLaboralId;
import com.hdv.ddd.valuesGenerics.Institucion;
import com.hdv.ddd.valuesGenerics.Periodo;

import java.util.Objects;

public class ExperienciaLaboral extends Entity<ExperienciaLaboralId> {

    private Institucion institucion;
    private Periodo periodo;
    private ConocimientosAdquiridos conocimientosAdquiridos;

    public ExperienciaLaboral(ExperienciaLaboralId entityId, Institucion institucion, Periodo periodo, ConocimientosAdquiridos conocimientosAdquiridos) {
        super(entityId);
        this.institucion = institucion;
        this.periodo = periodo;
        this.conocimientosAdquiridos = conocimientosAdquiridos;
    }

    public void actualizarInstitucion(Institucion institucion){
        this.institucion = Objects.requireNonNull(institucion);
    }

    public void actualizarPeriodo(Periodo periodo){
        this.periodo = Objects.requireNonNull(periodo);
    }

    public void actualizarConocimientosAdquiridos(ConocimientosAdquiridos conocimientosAdquiridos){
        this.conocimientosAdquiridos = Objects.requireNonNull(conocimientosAdquiridos);
    }

    public Institucion institucion() {
        return institucion;
    }

    public Periodo periodo() {
        return periodo;
    }

    public ConocimientosAdquiridos conocimientosAdquiridos() {
        return conocimientosAdquiridos;
    }
}
