package com.hdv.ddd.Colaborador.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.Colaborador.values.Genero;

public class GeneroActualizado extends DomainEvent {

    private final Genero genero;

    public GeneroActualizado(Genero genero) {
        super("sofka.hojadevida.colaborador.generoactualizado");
        this.genero = genero;
    }

    public Genero getGenero() {
        return genero;
    }
}
