package com.hdv.ddd.GestionCertificacion;

import co.com.sofka.domain.generic.Entity;
import com.hdv.ddd.GestionCertificacion.values.CertificacionId;
import com.hdv.ddd.GestionCertificacion.values.Nombre;
import com.hdv.ddd.valuesGenerics.Institucion;
import com.hdv.ddd.valuesGenerics.Periodo;

import java.util.Objects;

public class Certificacion extends Entity<CertificacionId> {

    private Nombre nombre;
    private Institucion institucion;
    private Periodo periodo;

    public Certificacion(CertificacionId entityId, Nombre nombre, Institucion institucion, Periodo periodo) {
        super(entityId);
        this.nombre = nombre;
        this.institucion = institucion;
        this.periodo = periodo;
    }

    public void actualizarNombre(Nombre nombre){
        this.nombre = Objects.requireNonNull(nombre);
    }

    public void actualizarInstitucion(Institucion institucion){
        this.institucion = Objects.requireNonNull(institucion);
    }

    public void actualizarPeriodo(Periodo periodo){
        this.periodo = Objects.requireNonNull(periodo);
    }

    public Nombre nombre() {
        return nombre;
    }

    public Institucion institucion() {
        return institucion;
    }

    public Periodo periodo() {
        return periodo;
    }
}
