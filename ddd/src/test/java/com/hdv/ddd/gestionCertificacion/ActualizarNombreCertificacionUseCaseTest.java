package com.hdv.ddd.gestionCertificacion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.GestionCertificacion.commands.ActualizarNombreCertificacion;
import com.hdv.ddd.GestionCertificacion.events.CertificacionAgregada;
import com.hdv.ddd.GestionCertificacion.events.GestionCertificacionCreada;
import com.hdv.ddd.GestionCertificacion.events.NombreCertificacionActualizado;
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
import useCases.gestionCertificacion.ActualizarNombreCertificacionUseCase;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ActualizarNombreCertificacionUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarNombre(){

        GestionCertificacionId gestionCertificacionId = GestionCertificacionId.of("67890");
        CertificacionId certificacionId = CertificacionId.of("12345");
        Nombre nombre = new Nombre("Tucu Tucu navideño");

        var command = new ActualizarNombreCertificacion(gestionCertificacionId, certificacionId, nombre);
        var useCase = new ActualizarNombreCertificacionUseCase();

        when(repository.getEventsBy("12345")).thenReturn(getEvent());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(certificacionId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (NombreCertificacionActualizado) events.get(0);

        Assertions.assertEquals(nombre, event.getNombre());
        Mockito.verify(repository).getEventsBy("12345");
    }

    private List<DomainEvent> getEvent(){

        List<String> fechas = new ArrayList<String>();
        fechas.add("01/01/1960");
        fechas.add("31/12/2000");

        return List.of(
                new GestionCertificacionCreada(
                        HojaDeVidaId.of("12345678"),
                        CertificacionId.of("2222")
                ),
                new CertificacionAgregada(
                        CertificacionId.of("12345"),
                        new Nombre("14 Cañonazos Bailables"),
                        new Institucion("Ninguna"),
                        new Periodo(fechas)
                )
        );
    }
}
