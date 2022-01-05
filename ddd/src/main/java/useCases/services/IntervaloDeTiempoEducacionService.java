package useCases.services;

import com.hdv.ddd.GestionEducacion.values.EducacionId;
import com.hdv.ddd.valuesGenerics.Periodo;

public interface IntervaloDeTiempoEducacionService {
    Integer calcularPeriodo(EducacionId educacionId, Periodo periodo);
}
