package useCases.colaborador;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hdv.ddd.Colaborador.Colaborador;
import com.hdv.ddd.Colaborador.commands.ActualizarNombreCompleto;

public class ActualizarNombreCompletoUseCase extends UseCase<RequestCommand<ActualizarNombreCompleto>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreCompleto> actualizarNombreCompleto) {

        var command = actualizarNombreCompleto.getCommand();
        var colaborador = Colaborador.from(command.getCedula(), retrieveEvents());

        colaborador.actualizarNombreCompleto(command.getNombreCompleto());

        emit().onResponse(new ResponseEvents(colaborador.getUncommittedChanges()));
    }
}
