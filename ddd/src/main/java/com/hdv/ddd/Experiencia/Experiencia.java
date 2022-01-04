package com.hdv.ddd.Experiencia;

import co.com.sofka.domain.generic.AggregateEvent;
import com.hdv.ddd.Experiencia.values.ExperienciaId;
import com.hdv.ddd.Experiencia.values.ExperienciaLaboralId;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;

public class Experiencia extends AggregateEvent<ExperienciaId> {

    protected HojaDeVidaId hojaDeVidaId;
    protected ExperienciaLaboralId experienciaLaboralId;

    public Experiencia(ExperienciaId entityId, HojaDeVidaId hojaDeVidaId) {
        super(entityId);
        this.hojaDeVidaId = hojaDeVidaId;
    }
}
