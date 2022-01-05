package useCases.services;

import com.hdv.ddd.Experiencia.values.ExperienciaLaboralId;
import com.hdv.ddd.valuesGenerics.Periodo;

public interface IntervaloDeTiempoExperienciaLaboralService {
    Integer calcularPeriodo(ExperienciaLaboralId experienciaLaboralId, Periodo fechasInicioYFinal);
}
