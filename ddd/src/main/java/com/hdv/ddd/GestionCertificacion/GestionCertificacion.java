package com.hdv.ddd.GestionCertificacion;

import co.com.sofka.domain.generic.AggregateEvent;
import com.hdv.ddd.GestionCertificacion.events.*;
import com.hdv.ddd.GestionCertificacion.values.CertificacionId;
import com.hdv.ddd.GestionCertificacion.values.GestionCertificacionId;
import com.hdv.ddd.GestionCertificacion.values.Nombre;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;
import com.hdv.ddd.valuesGenerics.Institucion;
import com.hdv.ddd.valuesGenerics.Periodo;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class GestionCertificacion extends AggregateEvent<GestionCertificacionId> {

    protected HojaDeVidaId hojaDeVidaId;
    protected List<Certificacion> certificaciones;

    public GestionCertificacion(GestionCertificacionId entityId, HojaDeVidaId hojaDeVidaId, CertificacionId certificacionId) {
        super(entityId);
        appendChange(new GestionCertificacionCreada(hojaDeVidaId, certificacionId)).apply();
    }

    private GestionCertificacion(GestionCertificacionId gestionCertificacionId){
        super(gestionCertificacionId);
        subscribe(new GestionCertificacionChange(this));
    }

    public void agregarCertificacion(CertificacionId entityId, Nombre nombre, Institucion institucion, Periodo periodo){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(institucion);
        Objects.requireNonNull(periodo);
        appendChange(new CertificacionAgregada(entityId, nombre, institucion, periodo)).apply();
    }

    public void actualizarNombreCertificacion(CertificacionId certificacionId, Nombre nombre){
        Objects.requireNonNull(certificacionId);
        Objects.requireNonNull(nombre);
        appendChange(new NombreCertificacionActualizado(certificacionId, nombre)).apply();
    }

    public void actualizarInstitucionCertificacion(CertificacionId certificacionId, Institucion institucion){
        Objects.requireNonNull(certificacionId);
        Objects.requireNonNull(institucion);
        appendChange(new InstitucionCertificacionActualizada(certificacionId, institucion)).apply();
    }

    public void actualizarPeriodo(CertificacionId certificacionId, Periodo periodo){
        Objects.requireNonNull(certificacionId);
        Objects.requireNonNull(periodo);
        appendChange(new PeriodoCertificacionActualizado(certificacionId, periodo)).apply();
    }

    public Optional<Certificacion> getCertificacionPorId(CertificacionId certificacionId){
        return certificaciones.stream()
                .filter((certificacion -> certificacion.identity().equals(certificacionId)))
                .findFirst();
    }

    public HojaDeVidaId hojaDeVidaId() {
        return hojaDeVidaId;
    }

    public List<Certificacion> certificaciones() {
        return certificaciones;
    }
}
