package com.hdv.ddd.Experiencia.commands;

import co.com.sofka.domain.generic.Command;
import com.hdv.ddd.Experiencia.values.ExperienciaId;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;

public class CrearExperiencia extends Command {

    private final ExperienciaId entityId;
    private final HojaDeVidaId hojaDeVidaId;

    public CrearExperiencia(ExperienciaId entityId, HojaDeVidaId hojaDeVidaId) {
        this.entityId = entityId;
        this.hojaDeVidaId = hojaDeVidaId;
    }

    public ExperienciaId getEntityId() {
        return entityId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }
}
