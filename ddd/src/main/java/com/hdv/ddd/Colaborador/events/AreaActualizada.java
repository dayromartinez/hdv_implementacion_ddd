package com.hdv.ddd.Colaborador.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.Colaborador.values.Area;

public class AreaActualizada extends DomainEvent {

    private final Area area;

    public AreaActualizada(Area area) {
        super("sofka.hojadevida.colaborador.areaactualizada");
        this.area = area;
    }

    public Area getArea() {
        return area;
    }
}
