/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.desechostoxicosnegocio.interfaces;

import com.itson.dominio.EmpresaTransportista;
import java.util.List;

public interface IEmpresaTransportista {

    EmpresaTransportista insertarEmpresaConAutos(EmpresaTransportista empresa);

    EmpresaTransportista consultarEmpresa(EmpresaTransportista elemento);

    void eliminarEmpresa(EmpresaTransportista elemento);

    EmpresaTransportista actualizarEmpresa(EmpresaTransportista elemento);

    EmpresaTransportista insertarEmpresa(EmpresaTransportista empresa);

    List<EmpresaTransportista> consultarTodasLasEmpresas();
}
