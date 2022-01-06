package com.hdv.ddd.gestionEducacion;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.GestionCertificacion.values.CertificacionId;
import com.hdv.ddd.GestionEducacion.GestionEducacion;
import com.hdv.ddd.GestionEducacion.events.EducacionAgregada;
import com.hdv.ddd.GestionEducacion.events.GestionEducacionCreada;
import com.hdv.ddd.GestionEducacion.values.EducacionId;
import com.hdv.ddd.GestionEducacion.values.Estudio;
import com.hdv.ddd.GestionEducacion.values.GestionEducacionId;
import com.hdv.ddd.GestionEducacion.values.Tipo;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;
import com.hdv.ddd.valuesGenerics.Institucion;
import com.hdv.ddd.valuesGenerics.Periodo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import useCases.gestionEducacion.CalcularPeriodoEducacionUseCaseEvent;
import useCases.services.IntervaloDeTiempoEducacionService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalcularPeriodoEducacionUseCaseTest {

    @Mock
    IntervaloDeTiempoEducacionService intervaloDeTiempoEducacionService;

    @Mock
    DomainEventRepository repository;

    @Test
    void calcularPeriodoEducacion(){

        List<String> fechas = new ArrayList<String>();
        fechas.add("01/01/1960");
        fechas.add("31/12/2000");

        GestionEducacionId gestionEducacionId = GestionEducacionId.of("12345");
        EducacionId educacionId = EducacionId.of("67890");
        Tipo tipo = new Tipo("Doctorado");
        Estudio estudio = new Estudio("Influencia del tucu tucu y de Adonay en las fiestas decembrinas");
        Institucion institucion = new Institucion("Tarimas de Colombia");
        Periodo periodo = new Periodo(fechas);

        var event = new EducacionAgregada(educacionId, tipo, estudio, institucion, periodo);
        event.setAggregateRootId(gestionEducacionId.value());

        var useCase = new CalcularPeriodoEducacionUseCaseEvent();

        when(intervaloDeTiempoEducacionService.calcularPeriodo(
                educacionId,
                periodo
        )).thenReturn(40);

        Mockito.lenient().when(repository.getEventsBy("12345")).thenReturn(getEvent());
        useCase.addRepository(repository);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(intervaloDeTiempoEducacionService);
        useCase.addServiceBuilder(builder);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(gestionEducacionId.value())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow();

        verify(intervaloDeTiempoEducacionService).calcularPeriodo(
                educacionId,
                periodo
        );
    }

    @Test
    void calcularPeriodoEducacionError(){

        List<String> fechas = new ArrayList<String>();
        fechas.add("01/01/1960");
        fechas.add("31/12/2000");

        GestionEducacionId gestionEducacionId = GestionEducacionId.of("12345");
        EducacionId educacionId = EducacionId.of("67890");
        Tipo tipo = new Tipo("Doctorado");
        Estudio estudio = new Estudio("Influencia del tucu tucu y de Adonay en las fiestas decembrinas");
        Institucion institucion = new Institucion("Tarimas de Colombia");
        Periodo periodo = new Periodo(fechas);

        var event = new EducacionAgregada(educacionId, tipo, estudio, institucion, periodo);
        event.setAggregateRootId(gestionEducacionId.value());

        var useCase = new CalcularPeriodoEducacionUseCaseEvent();

        when(intervaloDeTiempoEducacionService.calcularPeriodo(
                educacionId,
                periodo
        )).thenReturn(-40);

        Mockito.lenient().when(repository.getEventsBy("12345")).thenReturn(getEvent());
        useCase.addRepository(repository);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(intervaloDeTiempoEducacionService);
        useCase.addServiceBuilder(builder);

        Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(gestionEducacionId.value())
                    .syncExecutor(useCase, new TriggeredEvent<>(event))
                    .orElseThrow();
        });
    }

    private List<DomainEvent> getEvent(){
        return List.of(
                new GestionEducacionCreada(HojaDeVidaId.of("12345678"))
        );
    }
}
