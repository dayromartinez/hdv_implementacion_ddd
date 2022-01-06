package useCases.experiencia;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hdv.ddd.Experiencia.Experiencia;
import com.hdv.ddd.Experiencia.commands.AgregarExperienciaLaboral;

public class AgregarExperienciaLaboralUseCase extends UseCase<RequestCommand<AgregarExperienciaLaboral>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarExperienciaLaboral> agregarExperienciaLaboral) {

        var command = agregarExperienciaLaboral.getCommand();
        var experiencia = Experiencia.from(command.getExperienciaId(), retrieveEvents());

        if(experiencia.experiencias().size() >= 5){
            throw new BusinessException(command.getExperienciaId().value(), "No es posible registrar más de 5 experiencias laborales");
        }

        experiencia.agregarExperienciaLaboral(
                command.getEntityId(),
                command.getInstitucion(),
                command.getPeriodo(),
                command.getConocimientosAdquiridos()
        );

        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));
    }
}
