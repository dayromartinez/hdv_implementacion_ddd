package com.hdv.ddd.Perfil;

import co.com.sofka.domain.generic.EventChange;
import com.hdv.ddd.Perfil.events.InformacionContactoReferenciaActualizada;
import com.hdv.ddd.Perfil.events.NombreCompletoReferenciaActualizado;
import com.hdv.ddd.Perfil.events.PerfilCreado;
import com.hdv.ddd.Perfil.events.ReferenciaAgregada;

import java.util.ArrayList;

public class PerfilChange extends EventChange {
    public PerfilChange(Perfil perfil) {

        apply((InformacionContactoReferenciaActualizada event) -> {
            var referencia = perfil
                    .getReferenciaPorId(event.getReferenciaId())
                    .orElseThrow(()-> new IllegalArgumentException("El id no corresponde a ninguna referencia registrada."));
            referencia.actualizarInformacionContacto(event.getInformacionContacto());
        });

        apply((NombreCompletoReferenciaActualizado event) -> {
            var referencia = perfil
                    .getReferenciaPorId(event.getReferenciaId())
                    .orElseThrow(()-> new IllegalArgumentException("El id no corresponde a ninguna referencia registrada."));
            referencia.actualizarNombreCompleto(event.getNombreCompleto());
        });

        apply((PerfilCreado event) -> {
            perfil.hojaDeVidaId = event.getHojaDeVidaId();
            perfil.informacionContacto = event.getInformacionContacto();
            perfil.fotoPerfil = event.getFotoPerfil();
            perfil.referencias = new ArrayList<Referencia>();
        });

        apply((ReferenciaAgregada event) -> {
            perfil.referencias.add(new Referencia(event.getEntityId(), event.getInformacionContacto(), event.getNombreCompleto()));
        });
    }
}
