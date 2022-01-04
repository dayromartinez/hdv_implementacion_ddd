package com.hdv.ddd.Perfil;

import co.com.sofka.domain.generic.AggregateEvent;
import com.hdv.ddd.Perfil.values.FotoPerfil;
import com.hdv.ddd.Perfil.values.InformacionContacto;
import com.hdv.ddd.Perfil.values.PerfilId;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;

import java.util.List;

public class Perfil extends AggregateEvent<PerfilId> {

    protected HojaDeVidaId hojaDeVidaId;
    protected InformacionContacto informacionContacto;
    protected FotoPerfil fotoPerfil;
    protected List<Referencia> referencias;

    public Perfil(PerfilId entityId, HojaDeVidaId hojaDeVidaId, InformacionContacto informacionContacto, FotoPerfil fotoPerfil) {
        super(entityId);
        this.hojaDeVidaId = hojaDeVidaId;
        this.informacionContacto = informacionContacto;
        this.fotoPerfil = fotoPerfil;
    }
}
