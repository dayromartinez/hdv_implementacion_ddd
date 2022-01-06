package com.hdv.ddd.experiencia;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
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
import useCases.experiencia.CalcularPeriodoExperienciaLaboralUseCaseEvent;
import useCases.services.IntervaloDeTiempoExperienciaLaboralService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalcularPeriodoExperienciaLaboralUseCaseEventTest {

    @Mock
    IntervaloDeTiempoExperienciaLaboralService intervaloDeTiempoExperienciaLaboralService;

    @Mock
    DomainEventRepository repository;

    @Test
    void calcularPeriodoExperienciaLaboral(){

        List<String> fechas = new ArrayList<String>();
        fechas.add("01/01/1960");
        fechas.add("31/12/2000");

        ExperienciaId experienciaId = ExperienciaId.of("12345");
        ExperienciaLaboralId experienciaLaboralId = ExperienciaLaboralId.of("6789");
        Institucion institucion = new Institucion("Codiscos");
        Periodo periodo = new Periodo(fechas);
        ConocimientosAdquiridos conocimientosAdquiridos = new ConocimientosAdquiridos("Poner a parrandear a toda Colombia en los diciembres");

        var event = new ExperienciaLaboralAgregada(experienciaLaboralId, institucion, periodo, conocimientosAdquiridos);
        event.setAggregateRootId(experienciaId.value());

        var useCase = new CalcularPeriodoExperienciaLaboralUseCaseEvent();

        when(intervaloDeTiempoExperienciaLaboralService.calcularPeriodo(
                experienciaLaboralId,
                periodo
        )).thenReturn(40);

        Mockito.lenient().when(repository.getEventsBy("12345")).thenReturn(getEvent());
        useCase.addRepository(repository);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(intervaloDeTiempoExperienciaLaboralService);
        useCase.addServiceBuilder(builder);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(experienciaId.value())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow();

        verify(intervaloDeTiempoExperienciaLaboralService).calcularPeriodo(
                experienciaLaboralId,
                periodo
        );
    }

    @Test
    void calcularPeriodoExperienciaLaboralError(){

        List<String> fechas = new ArrayList<String>();
        fechas.add("01/01/1960");
        fechas.add("31/12/2000");

        ExperienciaId experienciaId = ExperienciaId.of("12345");
        ExperienciaLaboralId experienciaLaboralId = ExperienciaLaboralId.of("6789");
        Institucion institucion = new Institucion("Codiscos");
        Periodo periodo = new Periodo(fechas);
        ConocimientosAdquiridos conocimientosAdquiridos = new ConocimientosAdquiridos("Poner a parrandear a toda Colombia en los diciembres");

        var event = new ExperienciaLaboralAgregada(experienciaLaboralId, institucion, periodo, conocimientosAdquiridos);
        event.setAggregateRootId(experienciaId.value());

        var useCase = new CalcularPeriodoExperienciaLaboralUseCaseEvent();

        when(intervaloDeTiempoExperienciaLaboralService.calcularPeriodo(
                experienciaLaboralId,
                periodo
        )).thenReturn(-40);

        Mockito.lenient().when(repository.getEventsBy("12345")).thenReturn(getEvent());
        useCase.addRepository(repository);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(intervaloDeTiempoExperienciaLaboralService);
        useCase.addServiceBuilder(builder);

        Assertions.assertThrows(BusinessException.class, () -> {
           UseCaseHandler.getInstance()
                   .setIdentifyExecutor(experienciaId.value())
                   .syncExecutor(useCase, new TriggeredEvent<>(event))
                   .orElseThrow();
        });
    }

    private List<DomainEvent> getEvent(){
        return List.of(new ExperienciaCreada(HojaDeVidaId.of("12345")));
    }
}
