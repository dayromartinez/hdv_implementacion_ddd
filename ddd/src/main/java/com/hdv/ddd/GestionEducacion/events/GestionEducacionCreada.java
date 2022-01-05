package com.hdv.ddd.GestionEducacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;

public class GestionEducacionCreada extends DomainEvent {

    private final HojaDeVidaId hojaDeVidaId;

    public GestionEducacionCreada(HojaDeVidaId hojaDeVidaId) {
        super("sofka.hojadevida.gestioneducacion.gestioneducacioncreada");
        this.hojaDeVidaId = hojaDeVidaId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }
}
