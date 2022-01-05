package com.hdv.ddd.HojaDeVida.commands;

import co.com.sofka.domain.generic.Command;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;

public class CrearHojaDeVida extends Command {

    private final HojaDeVidaId hojaDeVidaId;

    public CrearHojaDeVida(HojaDeVidaId hojaDeVidaId) {
        this.hojaDeVidaId = hojaDeVidaId;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }
}
