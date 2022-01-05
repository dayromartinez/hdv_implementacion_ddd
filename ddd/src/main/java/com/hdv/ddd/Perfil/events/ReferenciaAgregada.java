package com.hdv.ddd.Perfil.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.Perfil.values.InformacionContacto;
import com.hdv.ddd.Perfil.values.ReferenciaId;
import com.hdv.ddd.valuesGenerics.NombreCompleto;

public class ReferenciaAgregada extends DomainEvent {

    private final ReferenciaId entityId;
    private final InformacionContacto informacionContacto;
    private final NombreCompleto nombreCompleto;

    public ReferenciaAgregada(ReferenciaId entityId, InformacionContacto informacionContacto, NombreCompleto nombreCompleto) {
        super("sofka.hojadevida.perfil.referenciaagregada");
        this.entityId = entityId;
        this.informacionContacto = informacionContacto;
        this.nombreCompleto = nombreCompleto;
    }

    public ReferenciaId getEntityId() {
        return entityId;
    }

    public InformacionContacto getInformacionContacto() {
        return informacionContacto;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
