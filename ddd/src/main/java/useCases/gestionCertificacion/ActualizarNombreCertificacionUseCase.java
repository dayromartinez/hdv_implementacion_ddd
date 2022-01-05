package useCases.gestionCertificacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.hdv.ddd.GestionCertificacion.GestionCertificacion;
import com.hdv.ddd.GestionCertificacion.commands.ActualizarNombreCertificacion;

public class ActualizarNombreCertificacionUseCase extends UseCase<RequestCommand<ActualizarNombreCertificacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreCertificacion> actualizarNombreCertificacion) {

        var command = actualizarNombreCertificacion.getCommand();

        var gestionCertificacion = GestionCertificacion.from(command.getGestionCertificacionId(), retrieveEvents());

        gestionCertificacion.actualizarNombreCertificacion(command.getCertificacionId(), command.getNombre());

        emit().onResponse(new ResponseEvents(gestionCertificacion.getUncommittedChanges()));
    }
}
