package com.hdv.ddd.GestionEducacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.GestionEducacion.values.EducacionId;
import com.hdv.ddd.GestionEducacion.values.Estudio;
import com.hdv.ddd.GestionEducacion.values.Tipo;
import com.hdv.ddd.valuesGenerics.Institucion;
import com.hdv.ddd.valuesGenerics.Periodo;

public class EducacionAgregada extends DomainEvent {

    private final EducacionId entityId;
    private final Tipo tipo;
    private final Estudio estudio;
    private final Institucion institucion;
    private final Periodo periodo;

    public EducacionAgregada(EducacionId entityId, Tipo tipo, Estudio estudio, Institucion institucion, Periodo periodo) {
        super("sofka.hojadevida.gestioneducacion.educacionagregada");
        this.entityId = entityId;
        this.tipo = tipo;
        this.estudio = estudio;
        this.institucion = institucion;
        this.periodo = periodo;
    }

    public EducacionId getEntityId() {
        return entityId;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
