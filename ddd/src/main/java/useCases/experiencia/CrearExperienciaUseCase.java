package useCases.experiencia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hdv.ddd.Experiencia.Experiencia;
import com.hdv.ddd.Experiencia.commands.CrearExperiencia;

public class CrearExperienciaUseCase extends UseCase<RequestCommand<CrearExperiencia>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearExperiencia> crearExperiencia) {

        var command = crearExperiencia.getCommand();

        var experiencia = new Experiencia(
                command.getEntityId(),
                command.getHojaDeVidaId()
        );

        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));
    }
}
