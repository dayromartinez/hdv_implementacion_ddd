package com.hdv.ddd.Colaborador.commands;

import co.com.sofka.domain.generic.Command;
import com.hdv.ddd.Colaborador.values.Area;
import com.hdv.ddd.Colaborador.values.Cedula;

public class ActualizarArea extends Command {

    private final Cedula cedula;
    private final Area area;

    public ActualizarArea(Cedula cedula, Area area) {
        this.cedula = cedula;
        this.area = area;
    }

    public Cedula getCedula() {
        return cedula;
    }

    public Area getArea() {
        return area;
    }
}
