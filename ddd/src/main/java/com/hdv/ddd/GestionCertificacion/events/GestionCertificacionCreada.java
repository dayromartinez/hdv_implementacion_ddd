package com.hdv.ddd.GestionCertificacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.GestionCertificacion.values.CertificacionId;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;

public class GestionCertificacionCreada extends DomainEvent {

    private final HojaDeVidaId hojaDeVidaId;
    private final CertificacionId certificacionId;

    public GestionCertificacionCreada(HojaDeVidaId hojaDeVidaId, CertificacionId certificacionId) {
        super("sofka.hojadevida.gestioncertificacion.gestioncertificacioncreada");
        this.hojaDeVidaId = hojaDeVidaId;
        this.certificacionId = certificacionId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

    public CertificacionId getCertificacionId() {
        return certificacionId;
    }
}
