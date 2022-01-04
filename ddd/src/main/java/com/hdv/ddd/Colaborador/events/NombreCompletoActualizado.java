package com.hdv.ddd.Colaborador.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.valuesGenerics.NombreCompleto;

public class NombreCompletoActualizado extends DomainEvent {

    private final NombreCompleto nombreCompleto;

    public NombreCompletoActualizado(NombreCompleto nombreCompleto) {
        super("sofka.hojadevida.colaborador.nombrecompletoactualizado");
        this.nombreCompleto = nombreCompleto;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
