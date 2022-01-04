package com.hdv.ddd.GestionEducacion;

import co.com.sofka.domain.generic.Entity;
import com.hdv.ddd.GestionEducacion.values.EducacionId;
import com.hdv.ddd.GestionEducacion.values.Estudio;
import com.hdv.ddd.GestionEducacion.values.Tipo;
import com.hdv.ddd.valuesGenerics.Institucion;
import com.hdv.ddd.valuesGenerics.Periodo;

public class Educacion extends Entity<EducacionId> {

    protected Tipo tipo;
    protected Estudio estudio;
    protected Institucion institucion;
    protected Periodo periodo;

    public Educacion(EducacionId entityId, Tipo tipo, Estudio estudio, Institucion institucion, Periodo periodo) {
        super(entityId);
        this.tipo = tipo;
        this.estudio = estudio;
        this.institucion = institucion;
        this.periodo = periodo;
    }
}
