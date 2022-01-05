package com.hdv.ddd.GestionEducacion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.GestionEducacion.events.*;
import com.hdv.ddd.GestionEducacion.values.EducacionId;
import com.hdv.ddd.GestionEducacion.values.Estudio;
import com.hdv.ddd.GestionEducacion.values.GestionEducacionId;
import com.hdv.ddd.GestionEducacion.values.Tipo;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;
import com.hdv.ddd.valuesGenerics.Institucion;
import com.hdv.ddd.valuesGenerics.Periodo;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class GestionEducacion extends AggregateEvent<GestionEducacionId> {

    protected HojaDeVidaId hojaDeVidaId;
    protected List<Educacion> educaciones;

    public GestionEducacion(GestionEducacionId entityId, HojaDeVidaId hojaDeVidaId) {
        super(entityId);
        appendChange(new GestionEducacionCreada(hojaDeVidaId)).apply();
    }

    private GestionEducacion(GestionEducacionId gestionEducacionId){
        super(gestionEducacionId);
        subscribe(new GestionEducacionChange(this));
    }

    public static GestionEducacion from(GestionEducacionId gestionEducacionId, List<DomainEvent> events){
        var gestionEducacion = new GestionEducacion(gestionEducacionId);
        events.forEach(gestionEducacion::applyEvent);
        return gestionEducacion;
    }

    public void agregarEducacion(EducacionId entityId, Tipo tipo, Estudio estudio, Institucion institucion, Periodo periodo){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(tipo);
        Objects.requireNonNull(estudio);
        Objects.requireNonNull(institucion);
        Objects.requireNonNull(periodo);
        appendChange(new EducacionAgregada(entityId, tipo, estudio, institucion, periodo)).apply();
    }

    public void actualizarTipoEducacion(EducacionId educacionId, Tipo tipo){
        Objects.requireNonNull(educacionId);
        Objects.requireNonNull(tipo);
        appendChange(new TipoEducacionActualizado(educacionId, tipo)).apply();
    }

    public void actualizarEstudioEducacion(EducacionId educacionId, Estudio estudio){
        Objects.requireNonNull(educacionId);
        Objects.requireNonNull(estudio);
        appendChange(new EstudioEducacionActualizado(educacionId, estudio)).apply();
    }

    public void actualizarInstitucionEducacion(EducacionId educacionId, Institucion institucion){
        Objects.requireNonNull(educacionId);
        Objects.requireNonNull(institucion);
        appendChange(new InstitucionEducacionActualizada(educacionId, institucion)).apply();
    }

    public void actualizarPeriodoEducacion(EducacionId educacionId, Periodo periodo){
        Objects.requireNonNull(educacionId);
        Objects.requireNonNull(periodo);
        appendChange(new PeriodoEducacionActualizado(educacionId, periodo)).apply();
    }

    public Optional<Educacion> getEducacionPorId(EducacionId educacionId){
        return educaciones.stream()
                .filter(educacion -> educacion.identity().equals(educacionId))
                .findFirst();
    }

    public HojaDeVidaId hojaDeVidaId() {
        return hojaDeVidaId;
    }

    public List<Educacion> educaciones() {
        return educaciones;
    }
}
