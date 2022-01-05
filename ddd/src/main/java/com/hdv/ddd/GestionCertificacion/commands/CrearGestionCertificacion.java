package com.hdv.ddd.GestionCertificacion.commands;

import co.com.sofka.domain.generic.Command;
import com.hdv.ddd.GestionCertificacion.values.CertificacionId;
import com.hdv.ddd.GestionCertificacion.values.GestionCertificacionId;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;

public class CrearGestionCertificacion extends Command {

    private final GestionCertificacionId entityId;
    private final HojaDeVidaId hojaDeVidaId;
    private final CertificacionId certificacionId;

    public CrearGestionCertificacion(GestionCertificacionId entityId, HojaDeVidaId hojaDeVidaId, CertificacionId certificacionId) {
        this.entityId = entityId;
        this.hojaDeVidaId = hojaDeVidaId;
        this.certificacionId = certificacionId;
    }

    public GestionCertificacionId getEntityId() {
        return entityId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

    public CertificacionId getCertificacionId() {
        return certificacionId;
    }
}
