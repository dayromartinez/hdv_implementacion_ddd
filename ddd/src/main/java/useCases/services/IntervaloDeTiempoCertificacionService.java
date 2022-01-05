package useCases.services;

import com.hdv.ddd.GestionCertificacion.values.CertificacionId;
import com.hdv.ddd.valuesGenerics.Periodo;

public interface IntervaloDeTiempoCertificacionService {
    Integer calcularPeriodo(CertificacionId certificacionId, Periodo periodo);
}
