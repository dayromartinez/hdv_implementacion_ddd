package com.hdv.ddd.Colaborador.commands;

import co.com.sofka.domain.generic.Command;
import com.hdv.ddd.Colaborador.values.Cedula;
import com.hdv.ddd.Perfil.values.PerfilId;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;

public class AgregarPerfil extends Command {

    private final Cedula cedula;
    private final HojaDeVidaId hojaDeVidaId;
    private final PerfilId perfilId;

    public AgregarPerfil(Cedula cedula, HojaDeVidaId hojaDeVidaId, PerfilId perfilId) {
        this.cedula = cedula;
        this.hojaDeVidaId = hojaDeVidaId;
        this.perfilId = perfilId;
    }

    public Cedula getCedula() {
        return cedula;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

    public PerfilId getPerfilId() {
        return perfilId;
    }
}
