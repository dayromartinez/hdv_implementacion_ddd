package com.hdv.ddd.GestionCertificacion.values;

import co.com.sofka.domain.generic.Identity;

public class CertificacionId extends Identity {

    public CertificacionId() {
    }

    private CertificacionId(String id) {
        super(id);
    }

    public static CertificacionId of(String id){
        return new CertificacionId(id);
    }
}
