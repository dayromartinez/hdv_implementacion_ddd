package com.hdv.ddd.GestionEducacion.commands;

import co.com.sofka.domain.generic.Command;
import com.hdv.ddd.GestionEducacion.values.EducacionId;
import com.hdv.ddd.GestionEducacion.values.Estudio;
import com.hdv.ddd.GestionEducacion.values.GestionEducacionId;

public class ActualizarEstudioEducacion extends Command {

    private final GestionEducacionId gestionEducacionId;
    private final EducacionId educacionId;
    private final Estudio estudio;

    public ActualizarEstudioEducacion(GestionEducacionId gestionEducacionId, EducacionId educacionId, Estudio estudio) {
        this.gestionEducacionId = gestionEducacionId;
        this.educacionId = educacionId;
        this.estudio = estudio;
    }

    public GestionEducacionId getGestionEducacionId() {
        return gestionEducacionId;
    }

    public EducacionId getEducacionId() {
        return educacionId;
    }

    public Estudio getEstudio() {
        return estudio;
    }
}
