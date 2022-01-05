package com.hdv.ddd.Perfil.commands;

import co.com.sofka.domain.generic.Command;
import com.hdv.ddd.Perfil.values.InformacionContacto;
import com.hdv.ddd.Perfil.values.PerfilId;
import com.hdv.ddd.Perfil.values.ReferenciaId;

public class ActualizarInformacionContactoReferencia extends Command {

    private final PerfilId perfilId;
    private final ReferenciaId referenciaId;
    private final InformacionContacto informacionContacto;

    public ActualizarInformacionContactoReferencia(PerfilId perfilId, ReferenciaId referenciaId, InformacionContacto informacionContacto) {
        this.perfilId = perfilId;
        this.referenciaId = referenciaId;
        this.informacionContacto = informacionContacto;
    }

    public PerfilId getPerfilId() {
        return perfilId;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public InformacionContacto getInformacionContacto() {
        return informacionContacto;
    }
}
