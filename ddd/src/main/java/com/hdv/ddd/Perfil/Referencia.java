package com.hdv.ddd.Perfil;

import co.com.sofka.domain.generic.Entity;
import com.hdv.ddd.Perfil.values.InformacionContacto;
import com.hdv.ddd.Perfil.values.ReferenciaId;
import com.hdv.ddd.valuesGenerics.NombreCompleto;

import java.util.Objects;

public class Referencia extends Entity<ReferenciaId> {

    private InformacionContacto informacionContacto;
    private NombreCompleto nombreCompleto;

    public Referencia(ReferenciaId entityId, InformacionContacto informacionContacto, NombreCompleto nombreCompleto) {
        super(entityId);
        this.informacionContacto = informacionContacto;
        this.nombreCompleto = nombreCompleto;
    }

    public void actualizarInformacionContacto(InformacionContacto informacionContacto){
        this.informacionContacto = Objects.requireNonNull(informacionContacto);
    }

    public void actualizarNombreCompleto(NombreCompleto nombreCompleto){
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
    }

    public InformacionContacto informacionContacto() {
        return informacionContacto;
    }

    public NombreCompleto nombreCompleto() {
        return nombreCompleto;
    }
}
