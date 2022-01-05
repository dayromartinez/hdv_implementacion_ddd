package com.hdv.ddd.GestionEducacion.commands;

import co.com.sofka.domain.generic.Command;
import com.hdv.ddd.GestionEducacion.values.EducacionId;
import com.hdv.ddd.GestionEducacion.values.GestionEducacionId;
import com.hdv.ddd.GestionEducacion.values.Tipo;

public class ActualizarTipoEducacion extends Command {

    private final GestionEducacionId gestionEducacionId;
    private final EducacionId educacionId;
    private final Tipo tipo;

    public ActualizarTipoEducacion(GestionEducacionId gestionEducacionId, EducacionId educacionId, Tipo tipo) {
        this.gestionEducacionId = gestionEducacionId;
        this.educacionId = educacionId;
        this.tipo = tipo;
    }

    public GestionEducacionId getGestionEducacionId() {
        return gestionEducacionId;
    }

    public EducacionId getEducacionId() {
        return educacionId;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
