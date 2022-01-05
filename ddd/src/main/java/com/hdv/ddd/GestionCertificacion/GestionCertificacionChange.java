package com.hdv.ddd.GestionCertificacion;

import co.com.sofka.domain.generic.EventChange;
import com.hdv.ddd.GestionCertificacion.events.*;

import java.util.ArrayList;

public class GestionCertificacionChange extends EventChange {
    public GestionCertificacionChange(GestionCertificacion gestionCertificacion) {

        apply((CertificacionAgregada event) -> {
            gestionCertificacion.certificaciones().add(new Certificacion(event.getEntityId(), event.getNombre(), event.getInstitucion(), event.getPeriodo()));
        });

        apply((GestionCertificacionCreada event) -> {
            gestionCertificacion.hojaDeVidaId = event.getHojaDeVidaId();
            gestionCertificacion.certificaciones = new ArrayList<Certificacion>();
        });

        apply((InstitucionCertificacionActualizada event) -> {
            var certificacion = gestionCertificacion
                    .getCertificacionPorId(event.getCertificacionId())
                    .orElseThrow(()-> new IllegalArgumentException("El id no corresponde a ninguna certificación registrada."));
            certificacion.actualizarInstitucion(event.getInstitucion());
        });

        apply((NombreCertificacionActualizado event) -> {
            var certificacion = gestionCertificacion
                    .getCertificacionPorId(event.getCertificacionId())
                    .orElseThrow(()-> new IllegalArgumentException("El id no corresponde a ninguna certificación registrada."));
            certificacion.actualizarNombre(event.getNombre());
        });

        apply((PeriodoCertificacionActualizado event) -> {
            var certificacion = gestionCertificacion
                    .getCertificacionPorId(event.getCertificacionId())
                    .orElseThrow(()-> new IllegalArgumentException("El id no corresponde a ninguna certificación registrada."));
            certificacion.actualizarPeriodo(event.getPeriodo());
        });
    }
}
