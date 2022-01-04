package com.hdv.ddd.Colaborador;

import co.com.sofka.domain.generic.AggregateEvent;
import com.hdv.ddd.Colaborador.values.Area;
import com.hdv.ddd.Colaborador.values.Cedula;
import com.hdv.ddd.Colaborador.values.FechaNacimiento;
import com.hdv.ddd.Colaborador.values.Genero;
import com.hdv.ddd.Perfil.values.PerfilId;
import com.hdv.ddd.valuesGenerics.HojaDeVidaId;
import com.hdv.ddd.valuesGenerics.NombreCompleto;

public class Colaborador extends AggregateEvent<Cedula> {

    protected HojaDeVidaId hojaDeVidaId;
    protected NombreCompleto nombreCompleto;
    protected FechaNacimiento fechaNacimiento;
    protected Genero genero;
    protected Area area;
    protected PerfilId perfilId;

    public Colaborador(Cedula cedula, HojaDeVidaId hojaDeVidaId, NombreCompleto nombreCompleto, FechaNacimiento fechaNacimiento, Genero genero, Area area, PerfilId perfilId) {
        super(cedula);
        this.hojaDeVidaId = hojaDeVidaId;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.area = area;
        this.perfilId = perfilId;
    }
}
