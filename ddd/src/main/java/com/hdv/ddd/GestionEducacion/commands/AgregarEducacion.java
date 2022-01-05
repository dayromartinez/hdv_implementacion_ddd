package com.hdv.ddd.GestionEducacion.commands;

import co.com.sofka.domain.generic.Command;
import com.hdv.ddd.GestionEducacion.values.EducacionId;
import com.hdv.ddd.GestionEducacion.values.Estudio;
import com.hdv.ddd.GestionEducacion.values.GestionEducacionId;
import com.hdv.ddd.GestionEducacion.values.Tipo;
import com.hdv.ddd.valuesGenerics.Institucion;
import com.hdv.ddd.valuesGenerics.Periodo;

public class AgregarEducacion extends Command {

    private final GestionEducacionId gestionEducacionId;
    private final EducacionId entityId;
    private final Tipo tipo;
    private final Estudio estudio;
    private final Institucion institucion;
    private final Periodo periodo;

    public AgregarEducacion(GestionEducacionId gestionEducacionId, EducacionId entityId, Tipo tipo, Estudio estudio, Institucion institucion, Periodo periodo) {
        this.gestionEducacionId = gestionEducacionId;
        this.entityId = entityId;
        this.tipo = tipo;
        this.estudio = estudio;
        this.institucion = institucion;
        this.periodo = periodo;
    }

    public GestionEducacionId getGestionEducacionId() {
        return gestionEducacionId;
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
