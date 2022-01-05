package com.hdv.ddd.GestionCertificacion.commands;

import co.com.sofka.domain.generic.Command;
import com.hdv.ddd.GestionCertificacion.values.CertificacionId;
import com.hdv.ddd.GestionCertificacion.values.GestionCertificacionId;
import com.hdv.ddd.GestionCertificacion.values.Nombre;
import com.hdv.ddd.valuesGenerics.Institucion;
import com.hdv.ddd.valuesGenerics.Periodo;

public class AgregarCertificacion extends Command {

    private final GestionCertificacionId gestionCertificacionId;
    private final CertificacionId entityId;
    private final Nombre nombre;
    private final Institucion institucion;
    private final Periodo periodo;

    public AgregarCertificacion(GestionCertificacionId gestionCertificacionId, CertificacionId entityId, Nombre nombre, Institucion institucion, Periodo periodo) {
        this.gestionCertificacionId = gestionCertificacionId;
        this.entityId = entityId;
        this.nombre = nombre;
        this.institucion = institucion;
        this.periodo = periodo;
    }

    public GestionCertificacionId getGestionCertificacionId() {
        return gestionCertificacionId;
    }

    public CertificacionId getEntityId() {
        return entityId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
