package com.hdv.ddd.Colaborador.commands;

import co.com.sofka.domain.generic.Command;
import com.hdv.ddd.Colaborador.values.Cedula;
import com.hdv.ddd.valuesGenerics.NombreCompleto;

public class ActualizarNombreCompleto extends Command {

    private final Cedula cedula;
    private final NombreCompleto nombreCompleto;

    public ActualizarNombreCompleto(Cedula cedula, NombreCompleto nombreCompleto) {
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
    }

    public Cedula getCedula() {
        return cedula;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
