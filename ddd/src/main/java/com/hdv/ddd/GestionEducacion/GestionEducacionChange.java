package com.hdv.ddd.GestionEducacion;

import co.com.sofka.domain.generic.EventChange;
import com.hdv.ddd.GestionCertificacion.events.GestionCertificacionCreada;
import com.hdv.ddd.GestionEducacion.events.*;

import java.util.ArrayList;

public class GestionEducacionChange extends EventChange {
    public GestionEducacionChange(GestionEducacion gestionEducacion) {

        apply((EducacionAgregada event) -> {
            gestionEducacion.educaciones.add(new Educacion(event.getEntityId(), event.getTipo(), event.getEstudio(), event.getInstitucion(), event.getPeriodo()));
        });

        apply((EstudioEducacionActualizado event) -> {
            var educacion = gestionEducacion
                    .getEducacionPorId(event.getEducacionId())
                    .orElseThrow(()-> new IllegalArgumentException("El id no corresponde a ninguna educación registrada."));
            educacion.actualizarEstudio(event.getEstudio());
        });

        apply((GestionCertificacionCreada event) -> {
            gestionEducacion.hojaDeVidaId = event.getHojaDeVidaId();
            gestionEducacion.educaciones = new ArrayList<Educacion>();
        });

        apply((InstitucionEducacionActualizada event) -> {
            var educacion = gestionEducacion
                    .getEducacionPorId(event.getEducacionId())
                    .orElseThrow(()-> new IllegalArgumentException("El id no corresponde a ninguna educación registrada."));
            educacion.actualizarInstitucion(event.getInstitucion());
        });

        apply((PeriodoEducacionActualizado event) -> {
            var educacion = gestionEducacion
                    .getEducacionPorId(event.getEducacionId())
                    .orElseThrow(()-> new IllegalArgumentException("El id no corresponde a ninguna educación registrada."));
            educacion.actualizarPeriodo(event.getPeriodo());
        });

        apply((TipoEducacionActualizado event) -> {
            var educacion = gestionEducacion
                    .getEducacionPorId(event.getEducacionId())
                    .orElseThrow(()-> new IllegalArgumentException("El id no corresponde a ninguna educación registrada."));
            educacion.actualizarTipo(event.getTipo());
        });
    }
}
