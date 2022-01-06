package com.hdv.ddd.gestionCertificacion;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.GestionCertificacion.GestionCertificacion;
import com.hdv.ddd.GestionCertificacion.events.CertificacionAgregada;
import com.hdv.ddd.GestionCertificacion.events.GestionCertificacionCreada;
import com.hdv.ddd.GestionCertificacion.values.CertificacionId;
import com.hdv.ddd.GestionCertificacion.values.GestionCertificacionId;
import com.hdv.ddd.GestionCertificacion.values.Nombre;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;
import com.hdv.ddd.valuesGenerics.Institucion;
import com.hdv.ddd.valuesGenerics.Periodo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import useCases.gestionCertificacion.CalcularPeriodoCertificacionUseCaseEvent;
import useCases.services.IntervaloDeTiempoCertificacionService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalcularPeriodoCertificacionUseCaseEventTest {

    @Mock
    IntervaloDeTiempoCertificacionService intervaloDeTiempoCertificacionService;

    @Mock
    DomainEventRepository repository;

    @Test
    void calcularPeriodoCertificacion(){

        List<String> fechas = new ArrayList<String>();
        fechas.add("01/01/1960");
        fechas.add("31/12/2000");

        GestionCertificacionId gestionCertificacionId = GestionCertificacionId.of("12345");
        CertificacionId certificacionId = CertificacionId.of("67890");
        Nombre nombre = new Nombre("Los 14 cañonazos bailables");
        Institucion institucion = new Institucion("Tarimas de Colombia");
        Periodo periodo = new Periodo(fechas);

        var event = new CertificacionAgregada(certificacionId, nombre, institucion, periodo);
        event.setAggregateRootId(gestionCertificacionId.value());

        var useCase = new CalcularPeriodoCertificacionUseCaseEvent();

        when(intervaloDeTiempoCertificacionService.calcularPeriodo(
                certificacionId,
                periodo
        )).thenReturn(40);

        Mockito.lenient().when(repository.getEventsBy("12345")).thenReturn(getEvent());
        useCase.addRepository(repository);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(intervaloDeTiempoCertificacionService);
        useCase.addServiceBuilder(builder);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(gestionCertificacionId.value())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow();

        verify(intervaloDeTiempoCertificacionService).calcularPeriodo(
                certificacionId,
                periodo
        );
    }

    @Test
    void calcularPeriodoCertificacionError(){

        List<String> fechas = new ArrayList<String>();
        fechas.add("01/01/1960");
        fechas.add("31/12/2000");

        GestionCertificacionId gestionCertificacionId = GestionCertificacionId.of("12345");
        CertificacionId certificacionId = CertificacionId.of("67890");
        Nombre nombre = new Nombre("Los 14 cañonazos bailables");
        Institucion institucion = new Institucion("Tarimas de Colombia");
        Periodo periodo = new Periodo(fechas);

        var event = new CertificacionAgregada(certificacionId, nombre, institucion, periodo);
        event.setAggregateRootId(gestionCertificacionId.value());

        var useCase = new CalcularPeriodoCertificacionUseCaseEvent();

        when(intervaloDeTiempoCertificacionService.calcularPeriodo(
                certificacionId,
                periodo
        )).thenReturn(-40);

        Mockito.lenient().when(repository.getEventsBy("12345")).thenReturn(getEvent());
        useCase.addRepository(repository);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(intervaloDeTiempoCertificacionService);
        useCase.addServiceBuilder(builder);

        Assertions.assertThrows(BusinessException.class, () -> {
            UseCaseHandler.getInstance()
                    .setIdentifyExecutor(gestionCertificacionId.value())
                    .syncExecutor(useCase, new TriggeredEvent<>(event))
                    .orElseThrow();
        });
    }

    private List<DomainEvent> getEvent(){
        return List.of(new GestionCertificacionCreada(
                HojaDeVidaId.of("1234567890"),
                CertificacionId.of("67890")
        ));
    }
}
