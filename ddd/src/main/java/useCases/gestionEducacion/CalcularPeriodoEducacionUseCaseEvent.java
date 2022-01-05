package useCases.gestionEducacion;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.hdv.ddd.GestionEducacion.events.EducacionAgregada;
import useCases.services.IntervaloDeTiempoEducacionService;

import java.util.List;

public class CalcularPeriodoEducacionUseCaseEvent extends UseCase<TriggeredEvent<EducacionAgregada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<EducacionAgregada> educacionAgregada) {

        var event = educacionAgregada.getDomainEvent();
        var service = getService(IntervaloDeTiempoEducacionService.class).orElseThrow();

        Integer intervaloTiempo = service.calcularPeriodo(event.getEntityId(), event.getPeriodo());

        if(intervaloTiempo <= 0){
            throw new BusinessException(event.aggregateRootId(), "Error al calcular el período de la educación," +
                    "debido a que el intervalo en días es menor o igual a 0");
        }

        emit().onResponse(new ResponseEvents(List.of()));
    }
}
