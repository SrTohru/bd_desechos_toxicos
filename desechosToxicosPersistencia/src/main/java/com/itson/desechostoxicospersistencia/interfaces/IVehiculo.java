package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.Vehiculo;
import java.util.List;

public interface IVehiculo {

    Vehiculo insertarElemento(Vehiculo e);

    List<Vehiculo> insertarElementoEnLista(List<Vehiculo> e);

    Vehiculo consultarAutoPorEmpresa(EmpresaTransportista emp);

    List<Vehiculo> consultarAutosPorEmpresa(EmpresaTransportista emp);

}
