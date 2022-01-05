package com.hdv.ddd.Colaborador.commands;

import co.com.sofka.domain.generic.Command;
import com.hdv.ddd.Colaborador.values.Cedula;
import com.hdv.ddd.Colaborador.values.FechaNacimiento;

public class ActualizarFechaDeNacimiento extends Command {

    private final Cedula cedula;
    private final FechaNacimiento fechaNacimiento;

    public ActualizarFechaDeNacimiento(Cedula cedula, FechaNacimiento fechaNacimiento) {
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cedula getCedula() {
        return cedula;
    }

    public FechaNacimiento getFechaNacimiento() {
        return fechaNacimiento;
    }
}
