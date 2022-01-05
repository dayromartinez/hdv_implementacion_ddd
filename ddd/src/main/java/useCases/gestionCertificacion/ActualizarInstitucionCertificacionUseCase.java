package useCases.gestionCertificacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hdv.ddd.GestionCertificacion.GestionCertificacion;
import com.hdv.ddd.GestionCertificacion.commands.ActualizarInstitucionCertificacion;

public class ActualizarInstitucionCertificacionUseCase extends UseCase<RequestCommand<ActualizarInstitucionCertificacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarInstitucionCertificacion> actualizarInstitucionCertificacion) {

        var command = actualizarInstitucionCertificacion.getCommand();
        var gestionCertificacion = GestionCertificacion.from(command.getGestionCertificacionId(), retrieveEvents());

        gestionCertificacion.actualizarInstitucionCertificacion(command.getCertificacionId(), command.getInstitucion());

        emit().onResponse(new ResponseEvents(gestionCertificacion.getUncommittedChanges()));
    }
}
