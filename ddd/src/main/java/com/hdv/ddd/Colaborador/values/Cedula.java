package com.hdv.ddd.Colaborador.values;

import co.com.sofka.domain.generic.Identity;

public class Cedula extends Identity {

    public Cedula() {
    }

    private Cedula(String cedula) {
        super(cedula);
    }

    public static Cedula of(String id){
        return new Cedula(id);
    }
}
