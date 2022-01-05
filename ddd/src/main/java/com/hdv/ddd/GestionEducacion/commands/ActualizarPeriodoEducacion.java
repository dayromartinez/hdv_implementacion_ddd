package com.hdv.ddd.GestionEducacion.commands;

import co.com.sofka.domain.generic.Command;
import com.hdv.ddd.GestionEducacion.values.EducacionId;
import com.hdv.ddd.GestionEducacion.values.GestionEducacionId;
import com.hdv.ddd.valuesGenerics.Periodo;

public class ActualizarPeriodoEducacion extends Command {

    private final GestionEducacionId gestionEducacionId;
    private final EducacionId educacionId;
    private final Periodo periodo;

    public ActualizarPeriodoEducacion(GestionEducacionId gestionEducacionId, EducacionId educacionId, Periodo periodo) {
        this.gestionEducacionId = gestionEducacionId;
        this.educacionId = educacionId;
        this.periodo = periodo;
    }

    public GestionEducacionId getGestionEducacionId() {
        return gestionEducacionId;
    }

    public EducacionId getEducacionId() {
        return educacionId;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
