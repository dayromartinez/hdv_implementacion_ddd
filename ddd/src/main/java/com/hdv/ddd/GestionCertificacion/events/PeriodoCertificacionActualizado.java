package com.hdv.ddd.GestionCertificacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.GestionCertificacion.values.CertificacionId;
import com.hdv.ddd.valuesGenerics.Periodo;

public class PeriodoCertificacionActualizado extends DomainEvent {

    private final CertificacionId certificacionId;
    private final Periodo periodo;

    public PeriodoCertificacionActualizado(CertificacionId certificacionId, Periodo periodo) {
        super("sofka.hojadevida.gestioncertificacion.periodocertificacionactualizado");
        this.certificacionId = certificacionId;
        this.periodo = periodo;
    }

    public CertificacionId getCertificacionId() {
        return certificacionId;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
