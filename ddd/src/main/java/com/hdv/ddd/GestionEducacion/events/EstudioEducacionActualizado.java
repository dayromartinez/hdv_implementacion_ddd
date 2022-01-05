package com.hdv.ddd.GestionEducacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.GestionEducacion.values.EducacionId;
import com.hdv.ddd.GestionEducacion.values.Estudio;

public class EstudioEducacionActualizado extends DomainEvent {

    private final EducacionId educacionId;
    private final Estudio estudio;

    public EstudioEducacionActualizado(EducacionId educacionId, Estudio estudio) {
        super("sofka.hojadevida.gestioneducacion.estudioeducacionactualizado");
        this.educacionId = educacionId;
        this.estudio = estudio;
    }

    public EducacionId getEducacionId() {
        return educacionId;
    }

    public Estudio getEstudio() {
        return estudio;
    }
}
