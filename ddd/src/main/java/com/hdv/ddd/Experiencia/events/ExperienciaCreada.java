package com.hdv.ddd.Experiencia.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.Experiencia.values.ExperienciaLaboralId;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;

public class ExperienciaCreada extends DomainEvent {

    private final HojaDeVidaId hojaDeVidaId;

    public ExperienciaCreada(HojaDeVidaId hojaDeVidaId) {
        super("sofka.hojadevida.experiencia.experienciacreada");
        this.hojaDeVidaId = hojaDeVidaId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }
}
