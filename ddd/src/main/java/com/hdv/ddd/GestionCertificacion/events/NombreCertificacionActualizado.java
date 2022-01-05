package com.hdv.ddd.GestionCertificacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.GestionCertificacion.values.CertificacionId;
import com.hdv.ddd.GestionCertificacion.values.Nombre;

public class NombreCertificacionActualizado extends DomainEvent {

    private final CertificacionId certificacionId;
    private final Nombre nombre;

    public NombreCertificacionActualizado(CertificacionId certificacionId, Nombre nombre) {
        super("sofka.hojadevida.gestioncertificacion.nombrecertificacionactualizado");
        this.certificacionId = certificacionId;
        this.nombre = nombre;
    }

    public CertificacionId getCertificacionId() {
        return certificacionId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
