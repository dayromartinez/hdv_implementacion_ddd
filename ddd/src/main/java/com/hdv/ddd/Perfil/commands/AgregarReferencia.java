package com.hdv.ddd.Perfil.commands;

import co.com.sofka.domain.generic.Command;
import com.hdv.ddd.Perfil.values.InformacionContacto;
import com.hdv.ddd.Perfil.values.PerfilId;
import com.hdv.ddd.Perfil.values.ReferenciaId;
import com.hdv.ddd.valuesGenerics.NombreCompleto;

public class AgregarReferencia extends Command {

    private final PerfilId perfilId;
    private final ReferenciaId entityId;
    private final InformacionContacto informacionContacto;
    private final NombreCompleto nombreCompleto;

    public AgregarReferencia(PerfilId perfilId, ReferenciaId entityId, InformacionContacto informacionContacto, NombreCompleto nombreCompleto) {
        this.perfilId = perfilId;
        this.entityId = entityId;
        this.informacionContacto = informacionContacto;
        this.nombreCompleto = nombreCompleto;
    }

    public PerfilId getPerfilId() {
        return perfilId;
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
