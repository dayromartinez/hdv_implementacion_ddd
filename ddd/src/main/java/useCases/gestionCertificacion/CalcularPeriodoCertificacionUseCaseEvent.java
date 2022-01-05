package useCases.gestionCertificacion;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.hdv.ddd.GestionCertificacion.events.CertificacionAgregada;
import useCases.services.IntervaloDeTiempoCertificacionService;

import java.util.List;

public class CalcularPeriodoCertificacionUseCaseEvent extends UseCase<TriggeredEvent<CertificacionAgregada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<CertificacionAgregada> certificacionAgregada) {

        var event = certificacionAgregada.getDomainEvent();
        var service = getService(IntervaloDeTiempoCertificacionService.class).orElseThrow();

        Integer intervaloTiempo = service.calcularPeriodo(event.getEntityId(), event.getPeriodo());

        if(intervaloTiempo <= 0){
            throw new BusinessException(event.aggregateRootId(), "Error al calcular el período de la certificación," +
                    "debido a que el intervalo en días es menor o igual a 0");
        }

        emit().onResponse(new ResponseEvents(List.of()));
    }
}
