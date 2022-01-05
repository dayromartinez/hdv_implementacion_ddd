package com.hdv.ddd.GestionCertificacion.values;

import co.com.sofka.domain.generic.Identity;

public class GestionCertificacionId extends Identity {

    public GestionCertificacionId() {
    }

    private GestionCertificacionId(String id) {
        super(id);
    }

    public static GestionCertificacionId of(String id){
        return new GestionCertificacionId(id);
    }
}
