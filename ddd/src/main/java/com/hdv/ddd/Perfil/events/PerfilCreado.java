package com.hdv.ddd.Perfil.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.Perfil.values.FotoPerfil;
import com.hdv.ddd.Perfil.values.InformacionContacto;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;

public class PerfilCreado extends DomainEvent {

    private final HojaDeVidaId hojaDeVidaId;
    private final InformacionContacto informacionContacto;
    private final FotoPerfil fotoPerfil;

    public PerfilCreado(HojaDeVidaId hojaDeVidaId, InformacionContacto informacionContacto, FotoPerfil fotoPerfil) {
        super("sofka.hojadevida.perfil.perfilcreado");
        this.hojaDeVidaId = hojaDeVidaId;
        this.informacionContacto = informacionContacto;
        this.fotoPerfil = fotoPerfil;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

    public InformacionContacto getInformacionContacto() {
        return informacionContacto;
    }

    public FotoPerfil getFotoPerfil() {
        return fotoPerfil;
    }
}
