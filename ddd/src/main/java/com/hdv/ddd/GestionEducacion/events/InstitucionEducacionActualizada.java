package com.hdv.ddd.GestionEducacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.GestionEducacion.values.EducacionId;
import com.hdv.ddd.valuesGenerics.Institucion;

public class InstitucionEducacionActualizada extends DomainEvent {

    private final EducacionId educacionId;
    private final Institucion institucion;

    public InstitucionEducacionActualizada(EducacionId educacionId, Institucion institucion) {
        super("sofka.hojadevida.gestioneducacion.institucioneducacionactualizada");
        this.educacionId = educacionId;
        this.institucion = institucion;
    }

    public EducacionId getEducacionId() {
        return educacionId;
    }

    public Institucion getInstitucion() {
        return institucion;
    }
}
