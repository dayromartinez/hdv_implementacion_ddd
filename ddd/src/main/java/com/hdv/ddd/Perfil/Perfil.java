package com.hdv.ddd.Perfil;

import co.com.sofka.domain.generic.AggregateEvent;
import com.hdv.ddd.Perfil.events.InformacionContactoReferenciaActualizada;
import com.hdv.ddd.Perfil.events.NombreCompletoReferenciaActualizado;
import com.hdv.ddd.Perfil.events.PerfilCreado;
import com.hdv.ddd.Perfil.events.ReferenciaAgregada;
import com.hdv.ddd.Perfil.values.FotoPerfil;
import com.hdv.ddd.Perfil.values.InformacionContacto;
import com.hdv.ddd.Perfil.values.PerfilId;
import com.hdv.ddd.Perfil.values.ReferenciaId;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;
import com.hdv.ddd.valuesGenerics.NombreCompleto;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Perfil extends AggregateEvent<PerfilId> {

    protected HojaDeVidaId hojaDeVidaId;
    protected InformacionContacto informacionContacto;
    protected FotoPerfil fotoPerfil;
    protected List<Referencia> referencias;

    public Perfil(PerfilId entityId, HojaDeVidaId hojaDeVidaId, InformacionContacto informacionContacto, FotoPerfil fotoPerfil) {
        super(entityId);
        appendChange(new PerfilCreado(hojaDeVidaId, informacionContacto, fotoPerfil)).apply();
    }

    private Perfil(PerfilId perfilId){
        super(perfilId);
        subscribe(new PerfilChange(this));
    }

    public void agregarReferencia(ReferenciaId entityId, InformacionContacto informacionContacto, NombreCompleto nombreCompleto){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(informacionContacto);
        Objects.requireNonNull(nombreCompleto);
        appendChange(new ReferenciaAgregada(entityId, informacionContacto, nombreCompleto)).apply();
    }

    public void actualizarInformacionContactoReferencia(ReferenciaId referenciaId, InformacionContacto informacionContacto){
        Objects.requireNonNull(referenciaId);
        Objects.requireNonNull(informacionContacto);
        appendChange(new InformacionContactoReferenciaActualizada(referenciaId, informacionContacto)).apply();
    }

    public void actualizarNombreCompleto(ReferenciaId referenciaId, NombreCompleto nombreCompleto){
        Objects.requireNonNull(referenciaId);
        Objects.requireNonNull(nombreCompleto);
        appendChange(new NombreCompletoReferenciaActualizado(referenciaId, nombreCompleto)).apply();
    }

    public Optional<Referencia> getReferenciaPorId(ReferenciaId referenciaId){
        return referencias.stream()
                .filter(referencia -> referencia.identity().equals(referenciaId))
                .findFirst();
    }

    public HojaDeVidaId hojaDeVidaId() {
        return hojaDeVidaId;
    }

    public InformacionContacto informacionContacto() {
        return informacionContacto;
    }

    public FotoPerfil fotoPerfil() {
        return fotoPerfil;
    }

    public List<Referencia> referencias() {
        return referencias;
    }
}
