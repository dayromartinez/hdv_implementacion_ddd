package com.hdv.ddd.Colaborador.commands;

import co.com.sofka.domain.generic.Command;
import com.hdv.ddd.Colaborador.values.Area;
import com.hdv.ddd.Colaborador.values.Cedula;
import com.hdv.ddd.Colaborador.values.FechaNacimiento;
import com.hdv.ddd.Colaborador.values.Genero;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;
import com.hdv.ddd.valuesGenerics.NombreCompleto;

public class CrearColaborador extends Command {

    private final Cedula cedula;
    private final HojaDeVidaId hojaDeVidaId;
    private final NombreCompleto nombreCompleto;
    private final FechaNacimiento fechaNacimiento;
    private final Genero genero;
    private final Area area;

    public CrearColaborador(Cedula cedula, HojaDeVidaId hojaDeVidaId, NombreCompleto nombreCompleto, FechaNacimiento fechaNacimiento, Genero genero, Area area) {
        this.cedula = cedula;
        this.hojaDeVidaId = hojaDeVidaId;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.area = area;
    }

    public Cedula getCedula() {
        return cedula;
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
