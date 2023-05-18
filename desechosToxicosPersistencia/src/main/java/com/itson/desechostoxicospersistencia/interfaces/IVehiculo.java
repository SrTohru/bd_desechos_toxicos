package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.Vehiculo;
import java.util.List;

public interface IVehiculo {

    Vehiculo consultarAutoPorEmpresa(EmpresaTransportista emp) throws Exception;

    List<Vehiculo> consultarAutosPorEmpresa(EmpresaTransportista emp) throws Exception;
 
}
