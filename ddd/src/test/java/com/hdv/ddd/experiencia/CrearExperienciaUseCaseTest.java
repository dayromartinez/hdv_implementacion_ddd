package com.hdv.ddd.experiencia;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.hdv.ddd.Experiencia.commands.CrearExperiencia;
import com.hdv.ddd.Experiencia.events.ExperienciaCreada;
import com.hdv.ddd.Experiencia.values.ExperienciaId;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import useCases.experiencia.CrearExperienciaUseCase;

public class CrearExperienciaUseCaseTest {

    @Test
    void crearExperiencia(){

        ExperienciaId experienciaId = ExperienciaId.of("12345");
        HojaDeVidaId hojaDeVidaId = HojaDeVidaId.of("123581321");

        var command = new CrearExperiencia(experienciaId, hojaDeVidaId);
        var useCase = new CrearExperienciaUseCase();

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        ExperienciaCreada event = (ExperienciaCreada) events.getDomainEvents().get(0);
        Assertions.assertEquals("12345", event.aggregateRootId());
        Assertions.assertEquals(hojaDeVidaId, event.getHojaDeVidaId());

    }
}
