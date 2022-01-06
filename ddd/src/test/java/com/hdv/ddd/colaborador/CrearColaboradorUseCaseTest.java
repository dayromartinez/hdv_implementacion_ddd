package com.hdv.ddd.colaborador;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.hdv.ddd.Colaborador.commands.CrearColaborador;
import com.hdv.ddd.Colaborador.events.ColaboradorCreado;
import com.hdv.ddd.Colaborador.values.Area;
import com.hdv.ddd.Colaborador.values.Cedula;
import com.hdv.ddd.Colaborador.values.FechaNacimiento;
import com.hdv.ddd.Colaborador.values.Genero;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;
import com.hdv.ddd.valuesGenerics.NombreCompleto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import useCases.colaborador.CrearColaboradorUseCase;

public class CrearColaboradorUseCaseTest {

    @Test
    void crearColaborador(){

        Cedula cedula = Cedula.of("1234567890");
        HojaDeVidaId hojaDeVidaId = HojaDeVidaId.of("123581321");
        NombreCompleto nombreCompleto = new NombreCompleto("Rodolfo Aicardi");
        FechaNacimiento fechaNacimiento = new FechaNacimiento("23/05/1946");
        Genero genero = new Genero("Masculino");
        Area area = new Area("Música y Parrandas Decembrinas");

        var command = new CrearColaborador(cedula, hojaDeVidaId, nombreCompleto, fechaNacimiento, genero, area);
        var useCase = new CrearColaboradorUseCase();


        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();


        ColaboradorCreado event = (ColaboradorCreado) events.getDomainEvents().get(0);
        Assertions.assertEquals("1234567890", event.aggregateRootId());
        Assertions.assertEquals(hojaDeVidaId, event.getHojaDeVidaId());
        Assertions.assertEquals(nombreCompleto, event.getNombreCompleto());
        Assertions.assertEquals(fechaNacimiento, event.getFechaNacimiento());
        Assertions.assertEquals(genero, event.getGenero());
        Assertions.assertEquals(area, event.getArea());
    }
}
