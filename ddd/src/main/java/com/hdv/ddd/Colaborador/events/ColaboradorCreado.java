package com.hdv.ddd.Colaborador.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.hdv.ddd.Colaborador.values.Area;
import com.hdv.ddd.Colaborador.values.FechaNacimiento;
import com.hdv.ddd.Colaborador.values.Genero;
import com.hdv.ddd.Perfil.values.PerfilId;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;
import com.hdv.ddd.valuesGenerics.NombreCompleto;

public class ColaboradorCreado extends DomainEvent {

    private final HojaDeVidaId hojaDeVidaId;
    private final NombreCompleto nombreCompleto;
    private final FechaNacimiento fechaNacimiento;
    private final Genero genero;
    private final Area area;

    public ColaboradorCreado(HojaDeVidaId hojaDeVidaId, NombreCompleto nombreCompleto, FechaNacimiento fechaNacimiento, Genero genero, Area area) {
        super("sofka.hojadevida.colaborador.colaboradorcreado");
        this.hojaDeVidaId = hojaDeVidaId;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.area = area;
    }

    public HojaDeVidaId getHojaDeVidaId() {
        return hojaDeVidaId;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public FechaNacimiento getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Genero getGenero() {
        return genero;
    }

    public Area getArea() {
        return area;
    }
}
