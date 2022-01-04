package com.hdv.ddd.Colaborador.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.Perfil.values.PerfilId;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;

public class PerfilAgregado extends DomainEvent {

    private final HojaDeVidaId hojaDeVidaId;
    private final PerfilId perfilId;

    public PerfilAgregado(HojaDeVidaId hojaDeVidaId, PerfilId perfilId) {
        super("sofka.hojadevida.colaborador.perfilagregado");
        this.hojaDeVidaId = hojaDeVidaId;
        this.perfilId = perfilId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

    public PerfilId getPerfilId() {
        return perfilId;
    }
}
