package com.hdv.ddd.HojaDeVida.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;

public class HojaDeVidaCreada extends DomainEvent {

    private final HojaDeVidaId entityId;

    public HojaDeVidaCreada(HojaDeVidaId entityId) {
        super("sofka.hojadevida.hojadevida.hojadevidacreada");
        this.entityId = entityId;
    }

    public HojaDeVidaId getEntityId() {
        return entityId;
    }
}
