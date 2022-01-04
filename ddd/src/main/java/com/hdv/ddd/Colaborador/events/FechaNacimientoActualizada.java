package com.hdv.ddd.Colaborador.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.Colaborador.values.FechaNacimiento;

public class FechaNacimientoActualizada extends DomainEvent {

    private final FechaNacimiento fechaNacimiento;

    public FechaNacimientoActualizada(FechaNacimiento fechaNacimiento) {
        super("sofka.hojadevida.colaborador.fechanacimientoactualizada");
        this.fechaNacimiento = fechaNacimiento;
    }

    public FechaNacimiento getFechaNacimiento() {
        return fechaNacimiento;
    }
}
