package com.hdv.ddd.GestionEducacion.values;

import co.com.sofka.domain.generic.Identity;

public class GestionEducacionId extends Identity {

    public GestionEducacionId() {
    }

    private GestionEducacionId(String id) {
        super(id);
    }

    public static GestionEducacionId of(String id){
        return new GestionEducacionId(id);
    }
}
