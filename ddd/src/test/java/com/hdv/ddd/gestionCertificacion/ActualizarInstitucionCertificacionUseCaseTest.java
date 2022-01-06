package com.hdv.ddd.gestionCertificacion;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.GestionCertificacion.commands.ActualizarInstitucionCertificacion;
import com.hdv.ddd.GestionCertificacion.events.CertificacionAgregada;
import com.hdv.ddd.GestionCertificacion.events.GestionCertificacionCreada;
import com.hdv.ddd.GestionCertificacion.events.InstitucionCertificacionActualizada;
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
import useCases.gestionCertificacion.ActualizarInstitucionCertificacionUseCase;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ActualizarInstitucionCertificacionUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarInstitucion(){

        GestionCertificacionId gestionCertificacionId = GestionCertificacionId.of("67890");
        CertificacionId certificacionId = CertificacionId.of("12345");
        Institucion institucion = new Institucion("Tarimas de Colombia");

        var command = new ActualizarInstitucionCertificacion(gestionCertificacionId, certificacionId, institucion);
        var useCase = new ActualizarInstitucionCertificacionUseCase();

        when(repository.getEventsBy("12345")).thenReturn(getEvent());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(certificacionId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (InstitucionCertificacionActualizada) events.get(0);

        Assertions.assertEquals(institucion, event.getInstitucion());
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
