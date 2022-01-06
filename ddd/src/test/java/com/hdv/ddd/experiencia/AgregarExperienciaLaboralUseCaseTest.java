package com.hdv.ddd.experiencia;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.Experiencia.commands.AgregarExperienciaLaboral;
import com.hdv.ddd.Experiencia.events.ExperienciaCreada;
import com.hdv.ddd.Experiencia.events.ExperienciaLaboralAgregada;
import com.hdv.ddd.Experiencia.values.ConocimientosAdquiridos;
import com.hdv.ddd.Experiencia.values.ExperienciaId;
import com.hdv.ddd.Experiencia.values.ExperienciaLaboralId;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;
import com.hdv.ddd.valuesGenerics.Institucion;
import com.hdv.ddd.valuesGenerics.Periodo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import useCases.experiencia.AgregarExperienciaLaboralUseCase;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)

public class AgregarExperienciaLaboralUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void agregarExperienciaLaboral(){

        List<String> fechas = new ArrayList<String>();
        fechas.add("01/01/1960");
        fechas.add("31/12/2000");

        ExperienciaId experienciaId = ExperienciaId.of("12345");
        ExperienciaLaboralId experienciaLaboralId = ExperienciaLaboralId.of("67890");
        Institucion institucion = new Institucion("Codiscos");
        Periodo periodo = new Periodo(fechas);
        ConocimientosAdquiridos conocimientosAdquiridos = new ConocimientosAdquiridos("Poner a parrandear a toda Colombia en los diciembres");

        var command = new AgregarExperienciaLaboral(experienciaId, experienciaLaboralId, institucion, periodo, conocimientosAdquiridos);
        var useCase = new AgregarExperienciaLaboralUseCase();

        when(repository.getEventsBy("12345")).thenReturn(getEvent());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(experienciaId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (ExperienciaLaboralAgregada) events.get(0);

        Assertions.assertEquals("12345", event.aggregateRootId());
        Assertions.assertEquals(experienciaLaboralId, event.getEntityId());
        Assertions.assertEquals(institucion, event.getInstitucion());
        Assertions.assertEquals(periodo, event.getPeriodo());
        Assertions.assertEquals(conocimientosAdquiridos, event.getConocimientosAdquiridos());
        Mockito.verify(repository).getEventsBy("12345");
    }

    @Test
    void agregarExperienciaLaboral_ErrorExcesoRegistros(){

        List<String> fechas = new ArrayList<String>();
        fechas.add("01/01/1960");
        fechas.add("31/12/2000");

        ExperienciaId experienciaId = ExperienciaId.of("12345");
        ExperienciaLaboralId experienciaLaboralId = ExperienciaLaboralId.of("67890");
        Institucion institucion = new Institucion("Codiscos");
        Periodo periodo = new Periodo(fechas);
        ConocimientosAdquiridos conocimientosAdquiridos = new ConocimientosAdquiridos("Poner a parrandear a toda Colombia en los diciembres");

        var command = new AgregarExperienciaLaboral(experienciaId, experienciaLaboralId, institucion, periodo, conocimientosAdquiridos);
        var useCase = new AgregarExperienciaLaboralUseCase();

        when(repository.getEventsBy("12345")).thenReturn(getEvents());
        useCase.addRepository(repository);

        Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(experienciaId.value())
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow();
        });
    }

    private List<DomainEvent> getEvent(){
        return List.of(
                new ExperienciaCreada(HojaDeVidaId.of("123581321"))
        );
    }

    private List<DomainEvent> getEvents(){

        List<String> fechas = new ArrayList<String>();
        fechas.add("01/01/1960");
        fechas.add("31/12/2000");

        return List.of(
                new ExperienciaCreada(HojaDeVidaId.of("123581321")),
                new ExperienciaLaboralAgregada(
                        ExperienciaLaboralId.of("11111"),
                        new Institucion("Codiscos"),
                        new Periodo(fechas),
                        new ConocimientosAdquiridos("Poner a parrandear a toda Colombia en los diciembres")
                ),
                new ExperienciaLaboralAgregada(
                        ExperienciaLaboralId.of("22222"),
                        new Institucion("Codiscos"),
                        new Periodo(fechas),
                        new ConocimientosAdquiridos("Poner a parrandear a toda Colombia en los diciembres")
                ),
                new ExperienciaLaboralAgregada(
                        ExperienciaLaboralId.of("33333"),
                        new Institucion("Codiscos"),
                        new Periodo(fechas),
                        new ConocimientosAdquiridos("Poner a parrandear a toda Colombia en los diciembres")
                ),
                new ExperienciaLaboralAgregada(
                        ExperienciaLaboralId.of("44444"),
                        new Institucion("Codiscos"),
                        new Periodo(fechas),
                        new ConocimientosAdquiridos("Poner a parrandear a toda Colombia en los diciembres")
                ),
                new ExperienciaLaboralAgregada(
                        ExperienciaLaboralId.of("55555"),
                        new Institucion("Codiscos"),
                        new Periodo(fechas),
                        new ConocimientosAdquiridos("Poner a parrandear a toda Colombia en los diciembres")
                )
        );
    }
}
