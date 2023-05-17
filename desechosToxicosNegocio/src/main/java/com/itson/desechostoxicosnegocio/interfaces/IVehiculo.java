/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.desechostoxicosnegocio.interfaces;

import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.Vehiculo;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IVehiculo {

    Vehiculo insertarElemento(Vehiculo e) throws Exception;

    List<Vehiculo> insertarElementoEnLista(List<Vehiculo> e) throws Exception;

    Vehiculo consultarAutoPorEmpresa(EmpresaTransportista emp) throws Exception;

    List<Vehiculo> consultarAutosPorEmpresa(EmpresaTransportista emp) throws Exception;

}
