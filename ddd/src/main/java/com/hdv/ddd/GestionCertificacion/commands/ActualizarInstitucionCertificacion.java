package com.hdv.ddd.GestionCertificacion.commands;

import co.com.sofka.domain.generic.Command;
import com.hdv.ddd.GestionCertificacion.values.CertificacionId;
import com.hdv.ddd.GestionCertificacion.values.GestionCertificacionId;
import com.hdv.ddd.valuesGenerics.Institucion;

public class ActualizarInstitucionCertificacion extends Command {

    private final GestionCertificacionId gestionCertificacionId;
    private final CertificacionId certificacionId;
    private final Institucion institucion;

    public ActualizarInstitucionCertificacion(GestionCertificacionId gestionCertificacionId, CertificacionId certificacionId, Institucion institucion) {
        this.gestionCertificacionId = gestionCertificacionId;
        this.certificacionId = certificacionId;
        this.institucion = institucion;
    }

    public GestionCertificacionId getGestionCertificacionId() {
        return gestionCertificacionId;
    }

    public CertificacionId getCertificacionId() {
        return certificacionId;
    }

    public Institucion getInstitucion() {
        return institucion;
    }
}
