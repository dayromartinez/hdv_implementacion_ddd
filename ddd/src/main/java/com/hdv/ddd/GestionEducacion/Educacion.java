package com.hdv.ddd.GestionEducacion;

import co.com.sofka.domain.generic.Entity;
import com.hdv.ddd.GestionEducacion.values.EducacionId;
import com.hdv.ddd.GestionEducacion.values.Estudio;
import com.hdv.ddd.GestionEducacion.values.Tipo;
import com.hdv.ddd.valuesGenerics.Institucion;
import com.hdv.ddd.valuesGenerics.Periodo;

import java.util.Objects;

public class Educacion extends Entity<EducacionId> {

    private Tipo tipo;
    private Estudio estudio;
    private Institucion institucion;
    private Periodo periodo;

    public Educacion(EducacionId entityId, Tipo tipo, Estudio estudio, Institucion institucion, Periodo periodo) {
        super(entityId);
        this.tipo = tipo;
        this.estudio = estudio;
        this.institucion = institucion;
        this.periodo = periodo;
    }

    public void actualizarTipo(Tipo tipo){
        this.tipo = Objects.requireNonNull(tipo);
    }

    public void actualizarEstudio(Estudio estudio){
        this.estudio = Objects.requireNonNull(estudio);
    }

    public void actualizarInstitucion(Institucion institucion){
        this.institucion = Objects.requireNonNull(institucion);
    }

    public void actualizarPeriodo(Periodo periodo){
        this.periodo = Objects.requireNonNull(periodo);
    }

    public Tipo tipo() {
        return tipo;
    }

    public Estudio estudio() {
        return estudio;
    }

    public Institucion institucion() {
        return institucion;
    }

    public Periodo periodo() {
        return periodo;
    }
}
