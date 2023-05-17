/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.desechostoxicosnegocio.interfaces;

import com.itson.dominio.EmpresaTransportista;
import java.util.List;

public interface IEmpresaTransportista {

    EmpresaTransportista insertarEmpresaConAutos(EmpresaTransportista empresa) throws Exception;

    EmpresaTransportista consultarEmpresa(EmpresaTransportista elemento) throws Exception;

    void eliminarEmpresa(EmpresaTransportista elemento) throws Exception;

    EmpresaTransportista actualizarEmpresa(EmpresaTransportista elemento) throws Exception;

    EmpresaTransportista insertarEmpresa(EmpresaTransportista empresa) throws Exception;

    List<EmpresaTransportista> consultarTodasLasEmpresas() throws Exception;
}
