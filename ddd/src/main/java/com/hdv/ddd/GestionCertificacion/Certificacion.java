package com.hdv.ddd.GestionCertificacion;

import co.com.sofka.domain.generic.Entity;
import com.hdv.ddd.GestionCertificacion.values.CertificacionId;
import com.hdv.ddd.GestionCertificacion.values.Nombre;
import com.hdv.ddd.valuesGenerics.Institucion;
import com.hdv.ddd.valuesGenerics.Periodo;

public class Certificacion extends Entity<CertificacionId> {

    protected Nombre nombre;
    protected Institucion institucion;
    protected Periodo periodo;

    public Certificacion(CertificacionId entityId, Nombre nombre, Institucion institucion, Periodo periodo) {
        super(entityId);
        this.nombre = nombre;
        this.institucion = institucion;
        this.periodo = periodo;
    }
}
