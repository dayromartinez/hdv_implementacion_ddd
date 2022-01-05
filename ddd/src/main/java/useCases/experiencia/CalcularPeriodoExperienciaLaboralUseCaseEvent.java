package useCases.experiencia;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.hdv.ddd.Experiencia.Experiencia;
import com.hdv.ddd.Experiencia.events.ExperienciaLaboralAgregada;
import com.hdv.ddd.Experiencia.values.ExperienciaId;
import useCases.services.IntervaloDeTiempoExperienciaLaboralService;

import java.util.List;

public class CalcularPeriodoExperienciaLaboralUseCaseEvent extends UseCase<TriggeredEvent<ExperienciaLaboralAgregada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<ExperienciaLaboralAgregada> experienciaLaboralAgregada) {

        var event = experienciaLaboralAgregada.getDomainEvent();
        var service = getService(IntervaloDeTiempoExperienciaLaboralService.class).orElseThrow();

        Integer intervaloDeTiempo = service.calcularPeriodo(event.getEntityId(), event.getPeriodo());

        if(intervaloDeTiempo <= 0){
            throw new BusinessException(event.aggregateRootId(), "Error al calcular el período de la experiencia laboral," +
                    "debido a que el intervalo en días es menor o igual a 0");
        }

        emit().onResponse(new ResponseEvents(List.of()));
    }
}
