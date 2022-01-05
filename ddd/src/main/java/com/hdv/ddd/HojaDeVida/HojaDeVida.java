package com.hdv.ddd.HojaDeVida;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.HojaDeVida.events.HojaDeVidaCreada;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;

import java.util.List;

public class HojaDeVida extends AggregateEvent<HojaDeVidaId> {

    public HojaDeVida(HojaDeVidaId entityId) {
        super(entityId);
        appendChange(new HojaDeVidaCreada(entityId)).apply();
    }

    /*private HojaDeVida(HojaDeVidaId hojaDeVidaId){
        super(hojaDeVidaId);
        subscribe(new HojaDeVidaChange(this));
    }*/

    /*public static HojaDeVida(HojaDeVidaId hojaDeVidaId, List<DomainEvent> events){
        var hojaDeVida = new HojaDeVida(hojaDeVidaId);
        events.forEach(hojaDeVida::applyEvent);
        return hojaDeVida;
    }*/
}
