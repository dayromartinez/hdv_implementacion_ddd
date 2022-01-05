package com.hdv.ddd.GestionEducacion.commands;

import co.com.sofka.domain.generic.Command;
import com.hdv.ddd.GestionEducacion.values.EducacionId;
import com.hdv.ddd.GestionEducacion.values.GestionEducacionId;
import com.hdv.ddd.valuesGenerics.Institucion;

public class ActualizarInstitucionEducacion extends Command {

    private final GestionEducacionId gestionEducacionId;
    private final EducacionId educacionId;
    private final Institucion institucion;

    public ActualizarInstitucionEducacion(GestionEducacionId gestionEducacionId, EducacionId educacionId, Institucion institucion) {
        this.gestionEducacionId = gestionEducacionId;
        this.educacionId = educacionId;
        this.institucion = institucion;
    }

    public GestionEducacionId getGestionEducacionId() {
        return gestionEducacionId;
    }

    public EducacionId getEducacionId() {
        return educacionId;
    }

    public Institucion getInstitucion() {
        return institucion;
    }
}
