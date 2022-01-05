package useCases.colaborador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hdv.ddd.Colaborador.Colaborador;
import com.hdv.ddd.Colaborador.commands.CrearColaborador;

public class CrearColaboradorUseCase extends UseCase<RequestCommand<CrearColaborador>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearColaborador> crearColaborador) {
        var command = crearColaborador.getCommand();

        var colaborador = new Colaborador(
                command.getCedula(),
                command.getHojaDeVidaId(),
                command.getNombreCompleto(),
                command.getFechaNacimiento(),
                command.getGenero(),
                command.getArea()
        );

        emit().onResponse(new ResponseEvents(colaborador.getUncommittedChanges()));
    }
}
