package com.hdv.ddd.Perfil.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.Perfil.values.ReferenciaId;
import com.hdv.ddd.valuesGenerics.NombreCompleto;

public class NombreCompletoReferenciaActualizado extends DomainEvent {

    private final ReferenciaId referenciaId;
    private final NombreCompleto nombreCompleto;

    public NombreCompletoReferenciaActualizado(ReferenciaId referenciaId, NombreCompleto nombreCompleto) {
        super("sofka.hojadevida.perfil.nombrecompletoreferenciaactualizado");
        this.referenciaId = referenciaId;
        this.nombreCompleto = nombreCompleto;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
