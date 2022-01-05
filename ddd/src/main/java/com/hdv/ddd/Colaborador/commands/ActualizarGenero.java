package com.hdv.ddd.Colaborador.commands;

import co.com.sofka.domain.generic.Command;
import com.hdv.ddd.Colaborador.values.Cedula;
import com.hdv.ddd.Colaborador.values.Genero;

public class ActualizarGenero extends Command {

    private final Cedula cedula;
    private final Genero genero;

    public ActualizarGenero(Cedula cedula, Genero genero) {
        this.cedula = cedula;
        this.genero = genero;
    }

    public Cedula getCedula() {
        return cedula;
    }

    public Genero getGenero() {
        return genero;
    }
}
