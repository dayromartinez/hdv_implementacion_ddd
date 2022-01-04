package com.hdv.ddd.Perfil;

import co.com.sofka.domain.generic.Entity;
import com.hdv.ddd.Perfil.values.InformacionContacto;
import com.hdv.ddd.Perfil.values.ReferenciaId;
import com.hdv.ddd.valuesGenerics.NombreCompleto;

public class Referencia extends Entity<ReferenciaId> {

    protected InformacionContacto informacionContacto;
    protected NombreCompleto nombreCompleto;

    public Referencia(ReferenciaId entityId, InformacionContacto informacionContacto, NombreCompleto nombreCompleto) {
        super(entityId);
        this.informacionContacto = informacionContacto;
        this.nombreCompleto = nombreCompleto;
    }
}
