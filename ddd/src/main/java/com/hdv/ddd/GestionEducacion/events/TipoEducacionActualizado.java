package com.hdv.ddd.GestionEducacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.GestionEducacion.values.EducacionId;
import com.hdv.ddd.GestionEducacion.values.Tipo;

public class TipoEducacionActualizado extends DomainEvent {

    private final EducacionId educacionId;
    private final Tipo tipo;

    public TipoEducacionActualizado(EducacionId educacionId, Tipo tipo) {
        super("sofka.hojadevida.gestioneducacion.tipoeducacionactualizado");
        this.educacionId = educacionId;
        this.tipo = tipo;
    }

    public EducacionId getEducacionId() {
        return educacionId;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
