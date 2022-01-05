package com.hdv.ddd.GestionEducacion.commands;

import co.com.sofka.domain.generic.Command;
import com.hdv.ddd.GestionEducacion.values.GestionEducacionId;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;

public class CrearGestionEducacion extends Command {

    private final GestionEducacionId entityId;
    private final HojaDeVidaId hojaDeVidaId;

    public CrearGestionEducacion(GestionEducacionId entityId, HojaDeVidaId hojaDeVidaId) {
        this.entityId = entityId;
        this.hojaDeVidaId = hojaDeVidaId;
    }

    public GestionEducacionId getEntityId() {
        return entityId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }
}
