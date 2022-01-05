package com.hdv.ddd.Experiencia;

import co.com.sofka.domain.generic.AggregateEvent;
import com.hdv.ddd.Experiencia.events.*;
import com.hdv.ddd.Experiencia.values.ConocimientosAdquiridos;
import com.hdv.ddd.Experiencia.values.ExperienciaId;
import com.hdv.ddd.Experiencia.values.ExperienciaLaboralId;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;
import com.hdv.ddd.valuesGenerics.Institucion;
import com.hdv.ddd.valuesGenerics.Periodo;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Experiencia extends AggregateEvent<ExperienciaId> {

    protected HojaDeVidaId hojaDeVidaId;
    protected List<ExperienciaLaboral> experiencias;

    public Experiencia(ExperienciaId entityId, HojaDeVidaId hojaDeVidaId) {
        super(entityId);
        appendChange(new ExperienciaCreada(hojaDeVidaId)).apply();
    }

    private Experiencia(ExperienciaId experienciaId){
        super(experienciaId);
        subscribe(new ExperienciaChange(this));
    }

    public void agregarExperienciaLaboral(ExperienciaLaboralId entityId, Institucion institucion, Periodo periodo, ConocimientosAdquiridos conocimientosAdquiridos){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(institucion);
        Objects.requireNonNull(periodo);
        Objects.requireNonNull(conocimientosAdquiridos);
        appendChange(new ExperienciaLaboralAgregada(entityId, institucion, periodo, conocimientosAdquiridos)).apply();
    }

    public void actualizarInstitucionExperienciaLaboral(ExperienciaLaboralId experienciaLaboralId, Institucion institucion){
        Objects.requireNonNull(experienciaLaboralId);
        Objects.requireNonNull(institucion);
        appendChange(new InstitucionExperienciaLaboralActualizada(experienciaLaboralId, institucion)).apply();
    }

    public void actualizarPeriodoExperienciaLaboral(ExperienciaLaboralId experienciaLaboralId, Periodo periodo){
        Objects.requireNonNull(experienciaLaboralId);
        Objects.requireNonNull(periodo);
        appendChange(new PeriodoExperienciaLaboralActualizado(experienciaLaboralId, periodo)).apply();
    }

    public void actualizarConocimientosExperienciaLaboral(ExperienciaLaboralId experienciaLaboralId, ConocimientosAdquiridos conocimientosAdquiridos){
        Objects.requireNonNull(experienciaLaboralId);
        Objects.requireNonNull(conocimientosAdquiridos);
        appendChange(new ConocimientosAdquiridosActualizados(experienciaLaboralId, conocimientosAdquiridos)).apply();
    }

    public Optional<ExperienciaLaboral> getExperienciaLaboralPorId(ExperienciaLaboralId experienciaLaboralId){
        return experiencias.stream()
                .filter((experienciaLaboral) -> experienciaLaboral.identity().equals(experienciaLaboralId))
                .findFirst();
    }

    public HojaDeVidaId hojaDeVidaId() {
        return hojaDeVidaId;
    }

    public List<ExperienciaLaboral> experiencias() {
        return experiencias;
    }
}
