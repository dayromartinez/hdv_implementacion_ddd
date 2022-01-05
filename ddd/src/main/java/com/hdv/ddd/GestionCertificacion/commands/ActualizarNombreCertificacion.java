package com.hdv.ddd.GestionCertificacion.commands;

import co.com.sofka.domain.generic.Command;
import com.hdv.ddd.GestionCertificacion.values.CertificacionId;
import com.hdv.ddd.GestionCertificacion.values.GestionCertificacionId;
import com.hdv.ddd.GestionCertificacion.values.Nombre;

public class ActualizarNombreCertificacion extends Command {

    private final GestionCertificacionId gestionCertificacionId;
    private final CertificacionId certificacionId;
    private final Nombre nombre;

    public ActualizarNombreCertificacion(GestionCertificacionId gestionCertificacionId, CertificacionId certificacionId, Nombre nombre) {
        this.gestionCertificacionId = gestionCertificacionId;
        this.certificacionId = certificacionId;
        this.nombre = nombre;
    }

    public GestionCertificacionId getGestionCertificacionId() {
        return gestionCertificacionId;
    }

    public CertificacionId getCertificacionId() {
        return certificacionId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
