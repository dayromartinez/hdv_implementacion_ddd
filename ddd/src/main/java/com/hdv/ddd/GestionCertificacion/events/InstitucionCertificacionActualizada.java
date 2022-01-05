package com.hdv.ddd.GestionCertificacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.GestionCertificacion.values.CertificacionId;
import com.hdv.ddd.valuesGenerics.Institucion;

public class InstitucionCertificacionActualizada extends DomainEvent {

    private final CertificacionId certificacionId;
    private final Institucion institucion;

    public InstitucionCertificacionActualizada(CertificacionId certificacionId, Institucion institucion) {
        super("sofka.hojadevida.gestioncertificacion.institucioncertificacionactualizada");
        this.certificacionId = certificacionId;
        this.institucion = institucion;
    }

    public CertificacionId getCertificacionId() {
        return certificacionId;
    }

    public Institucion getInstitucion() {
        return institucion;
    }
}
