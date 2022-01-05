package com.hdv.ddd.GestionCertificacion.commands;

import co.com.sofka.domain.generic.Command;
import com.hdv.ddd.GestionCertificacion.values.CertificacionId;
import com.hdv.ddd.GestionCertificacion.values.GestionCertificacionId;
import com.hdv.ddd.valuesGenerics.Periodo;

public class ActualizarPeriodoCertificacion extends Command {

    private final GestionCertificacionId gestionCertificacionId;
    private final CertificacionId certificacionId;
    private final Periodo periodo;

    public ActualizarPeriodoCertificacion(GestionCertificacionId gestionCertificacionId, CertificacionId certificacionId, Periodo periodo) {
        this.gestionCertificacionId = gestionCertificacionId;
        this.certificacionId = certificacionId;
        this.periodo = periodo;
    }

    public GestionCertificacionId getGestionCertificacionId() {
        return gestionCertificacionId;
    }

    public CertificacionId getCertificacionId() {
        return certificacionId;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
