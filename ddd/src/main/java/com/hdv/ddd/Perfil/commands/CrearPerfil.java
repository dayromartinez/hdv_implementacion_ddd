package com.hdv.ddd.Perfil.commands;

import co.com.sofka.domain.generic.Command;
import com.hdv.ddd.Perfil.values.FotoPerfil;
import com.hdv.ddd.Perfil.values.InformacionContacto;
import com.hdv.ddd.Perfil.values.PerfilId;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;

public class CrearPerfil extends Command {

    private final PerfilId entityId;
    private final HojaDeVidaId hojaDeVidaId;
    private final InformacionContacto informacionContacto;
    private final FotoPerfil fotoPerfil;

    public CrearPerfil(PerfilId entityId, HojaDeVidaId hojaDeVidaId, InformacionContacto informacionContacto, FotoPerfil fotoPerfil) {
        this.entityId = entityId;
        this.hojaDeVidaId = hojaDeVidaId;
        this.informacionContacto = informacionContacto;
        this.fotoPerfil = fotoPerfil;
    }

    public PerfilId getEntityId() {
        return entityId;
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
