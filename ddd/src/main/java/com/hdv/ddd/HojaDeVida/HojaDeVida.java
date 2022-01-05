package com.hdv.ddd.HojaDeVida;

import co.com.sofka.domain.generic.AggregateEvent;
import com.hdv.ddd.HojaDeVida.events.HojaDeVidaCreada;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;

public class HojaDeVida extends AggregateEvent<HojaDeVidaId> {

    public HojaDeVida(HojaDeVidaId entityId) {
        super(entityId);
        appendChange(new HojaDeVidaCreada(entityId)).apply();
    }

}
