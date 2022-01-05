package com.hdv.ddd.Perfil.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.Perfil.values.InformacionContacto;
import com.hdv.ddd.Perfil.values.ReferenciaId;

public class InformacionContactoReferenciaActualizada extends DomainEvent {

    private final ReferenciaId referenciaId;
    private final InformacionContacto informacionContacto;

    public InformacionContactoReferenciaActualizada(ReferenciaId referenciaId, InformacionContacto informacionContacto) {
        super("sofka.hojadevida.perfil.informacioncontactoreferenciaactualizada");
        this.referenciaId = referenciaId;
        this.informacionContacto = informacionContacto;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public InformacionContacto getInformacionContacto() {
        return informacionContacto;
    }
}
