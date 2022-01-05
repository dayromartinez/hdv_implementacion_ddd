package com.hdv.ddd.GestionEducacion.values;

import co.com.sofka.domain.generic.Identity;

public class EducacionId extends Identity {

    public EducacionId() {
    }

    private EducacionId(String id) {
        super(id);
    }

    public static EducacionId of(String id){
        return new EducacionId(id);
    }
}
