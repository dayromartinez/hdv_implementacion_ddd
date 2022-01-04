package com.hdv.ddd.GestionEducacion;

import co.com.sofka.domain.generic.AggregateEvent;
import com.hdv.ddd.GestionEducacion.values.GestionEducacionId;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;

import java.util.List;

public class GestionEducacion extends AggregateEvent<GestionEducacionId> {

    protected HojaDeVidaId hojaDeVidaId;
    protected List<Educacion> educaciones;

    public GestionEducacion(GestionEducacionId entityId, HojaDeVidaId hojaDeVidaId) {
        super(entityId);
        this.hojaDeVidaId = hojaDeVidaId;
    }
}
