package com.hdv.ddd.Perfil.commands;

import co.com.sofka.domain.generic.Command;
import com.hdv.ddd.GestionEducacion.values.GestionEducacionId;
import com.hdv.ddd.Perfil.values.ReferenciaId;
import com.hdv.ddd.valuesGenerics.NombreCompleto;

public class ActualizarNombreCompletoReferencia extends Command {

    private final GestionEducacionId gestionEducacionId;
    private final ReferenciaId referenciaId;
    private final NombreCompleto nombreCompleto;

    public ActualizarNombreCompletoReferencia(GestionEducacionId gestionEducacionId, ReferenciaId referenciaId, NombreCompleto nombreCompleto) {
        this.gestionEducacionId = gestionEducacionId;
        this.referenciaId = referenciaId;
        this.nombreCompleto = nombreCompleto;
    }

    public GestionEducacionId getGestionEducacionId() {
        return gestionEducacionId;
    }

    public ReferenciaId getReferenciaId() {
        return referenciaId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
