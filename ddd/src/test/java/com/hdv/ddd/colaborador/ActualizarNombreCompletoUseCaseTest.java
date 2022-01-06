package com.hdv.ddd.colaborador;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.Colaborador.commands.ActualizarNombreCompleto;
import com.hdv.ddd.Colaborador.events.ColaboradorCreado;
import com.hdv.ddd.Colaborador.events.NombreCompletoActualizado;
import com.hdv.ddd.Colaborador.values.Area;
import com.hdv.ddd.Colaborador.values.Cedula;
import com.hdv.ddd.Colaborador.values.FechaNacimiento;
import com.hdv.ddd.Colaborador.values.Genero;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;
import com.hdv.ddd.valuesGenerics.NombreCompleto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import useCases.colaborador.ActualizarNombreCompletoUseCase;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ActualizarNombreCompletoUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void actualizarNombreCompleto(){

        Cedula cedula = Cedula.of("1234567890");
        NombreCompleto nombreCompleto = new NombreCompleto("Pastor López");

        var command = new ActualizarNombreCompleto(cedula, nombreCompleto);
        var useCase = new ActualizarNombreCompletoUseCase();

        when(repository.getEventsBy("1234567890")).thenReturn(getEvent());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(cedula.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (NombreCompletoActualizado) events.get(0);

        Assertions.assertEquals(nombreCompleto, event.getNombreCompleto());
        Mockito.verify(repository).getEventsBy("1234567890");
    }

    private List<DomainEvent> getEvent(){
        return List.of(
                new ColaboradorCreado(
                        HojaDeVidaId.of("123581321"),
                        new NombreCompleto("Rodolfo Aicardi"),
                        new FechaNacimiento("23/05/1946"),
                        new Genero("Masculino"),
                        new Area("Música y Parrandas Decembrinas")
                )
        );
    }
}
