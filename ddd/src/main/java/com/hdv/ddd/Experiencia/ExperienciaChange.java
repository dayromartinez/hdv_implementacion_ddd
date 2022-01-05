package com.hdv.ddd.Experiencia;

import co.com.sofka.domain.generic.EventChange;
import com.hdv.ddd.Experiencia.events.*;

import java.util.ArrayList;

public class ExperienciaChange extends EventChange {
    public ExperienciaChange(Experiencia experiencia) {

        apply((ConocimientosAdquiridosActualizados event) -> {
            var experienciaLaboral = experiencia.
                    getExperienciaLaboralPorId(event.getExperienciaLaboralId())
                    .orElseThrow(()-> new IllegalArgumentException("El id no corresponde a ninguna experiencia laboral registrada."));
            experienciaLaboral.actualizarConocimientosAdquiridos(event.getConocimientosAdquiridos());
        });

        apply((ExperienciaCreada event) -> {
            experiencia.hojaDeVidaId = event.getHojaDeVidaId();
            experiencia.experiencias = new ArrayList<ExperienciaLaboral>();
        });

        apply((ExperienciaLaboralAgregada event) -> {
            experiencia.experiencias.add(new ExperienciaLaboral(event.getEntityId(), event.getInstitucion(), event.getPeriodo(), event.getConocimientosAdquiridos()));
        });

        apply((InstitucionExperienciaLaboralActualizada event) -> {
            var experienciaLaboral = experiencia
                    .getExperienciaLaboralPorId(event.getExperienciaLaboralId())
                    .orElseThrow(()-> new IllegalArgumentException("El id no corresponde a ninguna experiencia laboral registrada."));
            experienciaLaboral.actualizarInstitucion(event.getInstitucion());
        });

        apply((PeriodoExperienciaLaboralActualizado event) -> {
            var experienciaLaboral = experiencia
                    .getExperienciaLaboralPorId(event.getExperienciaLaboralId())
                    .orElseThrow(()-> new IllegalArgumentException("El id no corresponde a ninguna experiencia laboral registrada."));
            experienciaLaboral.actualizarPeriodo(event.getPeriodo());
        });
    }
}
