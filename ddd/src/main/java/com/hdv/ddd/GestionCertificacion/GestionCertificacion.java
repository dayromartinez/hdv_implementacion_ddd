package com.hdv.ddd.GestionCertificacion;

import co.com.sofka.domain.generic.AggregateEvent;
import com.hdv.ddd.GestionCertificacion.values.CertificacionId;
import com.hdv.ddd.GestionCertificacion.values.GestionCertificacionId;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;

public class GestionCertificacion extends AggregateEvent<GestionCertificacionId> {

    protected HojaDeVidaId hojaDeVidaId;
    protected CertificacionId certificacionId;

    public GestionCertificacion(GestionCertificacionId entityId, HojaDeVidaId hojaDeVidaId, CertificacionId certificacionId) {
        super(entityId);
        this.hojaDeVidaId = hojaDeVidaId;
        this.certificacionId = certificacionId;
    }
}
