package com.hdv.ddd.Perfil.values;

import co.com.sofka.domain.generic.Identity;

public class ReferenciaId extends Identity {

    public ReferenciaId() {
    }

    private ReferenciaId(String id) {
        super(id);
    }

    public static ReferenciaId of(String id){
        return new ReferenciaId(id);
    }
}
