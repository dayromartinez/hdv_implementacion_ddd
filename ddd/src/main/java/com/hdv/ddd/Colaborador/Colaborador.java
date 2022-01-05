package com.hdv.ddd.Colaborador;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.Colaborador.events.*;
import com.hdv.ddd.Colaborador.values.Area;
import com.hdv.ddd.Colaborador.values.Cedula;
import com.hdv.ddd.Colaborador.values.FechaNacimiento;
import com.hdv.ddd.Colaborador.values.Genero;
import com.hdv.ddd.Perfil.values.PerfilId;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;
import com.hdv.ddd.valuesGenerics.NombreCompleto;

import java.util.List;
import java.util.Objects;

public class Colaborador extends AggregateEvent<Cedula> {

    protected HojaDeVidaId hojaDeVidaId;
    protected NombreCompleto nombreCompleto;
    protected FechaNacimiento fechaNacimiento;
    protected Genero genero;
    protected Area area;
    protected PerfilId perfilId;

    public Colaborador(Cedula cedula, HojaDeVidaId hojaDeVidaId, NombreCompleto nombreCompleto, FechaNacimiento fechaNacimiento, Genero genero, Area area) {
        super(cedula);
        appendChange(new ColaboradorCreado(hojaDeVidaId, nombreCompleto, fechaNacimiento, genero, area)).apply();
    }

    private Colaborador(Cedula cedula){
        super(cedula);
        subscribe(new ColaboradorChange(this));
    }

    public static Colaborador from(Cedula cedula, List<DomainEvent> events){
        var colaborador = new Colaborador(cedula);
        events.forEach(colaborador::applyEvent);
        return colaborador;
    }

    public void agregarPerfil(HojaDeVidaId hojaDeVidaId, PerfilId perfilId){
        Objects.requireNonNull(hojaDeVidaId);
        Objects.requireNonNull(perfilId);
        appendChange(new PerfilAgregado(hojaDeVidaId,perfilId)).apply();
    }

    public void actualizarNombreCompleto(NombreCompleto nombreCompleto){
        Objects.requireNonNull(nombreCompleto);
        appendChange(new NombreCompletoActualizado(nombreCompleto)).apply();
    }

    public void actualizarFechaDeNacimiento(FechaNacimiento fechaNacimiento){
        Objects.requireNonNull(fechaNacimiento);
        appendChange(new FechaNacimientoActualizada(fechaNacimiento)).apply();
    }

    public void actualizarGenero(Genero genero){
        Objects.requireNonNull(genero);
        appendChange(new GeneroActualizado(genero)).apply();
    }

    public void actualizarArea(Area area){
        Objects.requireNonNull(area);
        appendChange(new AreaActualizada(area)).apply();
    }

    public HojaDeVidaId hojaDeVidaId() {
        return hojaDeVidaId;
    }

    public NombreCompleto nombreCompleto() {
        return nombreCompleto;
    }

    public FechaNacimiento fechaNacimiento() {
        return fechaNacimiento;
    }

    public Genero genero() {
        return genero;
    }

    public Area area() {
        return area;
    }

    public PerfilId perfilId() {
        return perfilId;
    }
}
