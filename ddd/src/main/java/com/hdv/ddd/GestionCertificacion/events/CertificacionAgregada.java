package com.hdv.ddd.GestionCertificacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.GestionCertificacion.values.CertificacionId;
import com.hdv.ddd.GestionCertificacion.values.Nombre;
import com.hdv.ddd.valuesGenerics.Institucion;
import com.hdv.ddd.valuesGenerics.Periodo;

public class CertificacionAgregada extends DomainEvent {

    private final CertificacionId entityId;
    private final Nombre nombre;
    private final Institucion institucion;
    private final Periodo periodo;

    public CertificacionAgregada(CertificacionId entityId, Nombre nombre, Institucion institucion, Periodo periodo) {
        super("sofka.hojadevida.gestioncertificacion.certificacionagregada");
        this.entityId = entityId;
        this.nombre = nombre;
        this.institucion = institucion;
        this.periodo = periodo;
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
