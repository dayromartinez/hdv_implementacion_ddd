package com.hdv.ddd.valuesGenerics;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.Identity;

public class HojaDeVidaId extends Identity {

    public HojaDeVidaId() {
    }

    private HojaDeVidaId(String id) {
        super(id);
    }

    public static HojaDeVidaId of(String id){
        return new HojaDeVidaId(id);
    }
}
