package com.hdv.ddd.Colaborador;

import co.com.sofka.domain.generic.EventChange;
import com.hdv.ddd.Colaborador.events.*;

public class ColaboradorChange extends EventChange {
    public ColaboradorChange(Colaborador colaborador) {

        apply((AreaActualizada event) -> {
            colaborador.area = event.getArea();
        });

        apply((ColaboradorCreado event) -> {
            colaborador.hojaDeVidaId = event.getHojaDeVidaId();
            colaborador.nombreCompleto = event.getNombreCompleto();
            colaborador.fechaNacimiento = event.getFechaNacimiento();
            colaborador.genero = event.getGenero();
            colaborador.area = event.getArea();
        });

        apply((FechaNacimientoActualizada event) -> {
            colaborador.fechaNacimiento = event.getFechaNacimiento();
        });

        apply((GeneroActualizado event) -> {
            colaborador.genero = event.getGenero();
        });

        apply((NombreCompletoActualizado event) -> {
            colaborador.nombreCompleto = event.getNombreCompleto();
        });

        apply((PerfilAgregado event) -> {
            colaborador.perfilId = colaborador.perfilId();
        });
    }
}
