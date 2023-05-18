/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.desechostoxicospersistencia.fachada;

import com.itson.desechostoxicospersistencia.utilities.ConfiguracionDePaginado;
import com.itson.dominio.Administrador;
import com.itson.dominio.Cuenta;
import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.Productores;
import com.itson.dominio.Quimicos;
import com.itson.dominio.RegistroTraslado;
import com.itson.dominio.Residuos;
import com.itson.dominio.Traslado;
import com.itson.dominio.Vehiculo;
import java.util.List;

/**
 *
 * @author PC
 */
public interface INegocio {

    Administrador iniciarSesion(Administrador administrador) throws Exception;

    Cuenta insertarCuenta(Cuenta cuenta) throws Exception;

    Cuenta iniciarSesion(Cuenta cuenta) throws Exception;

    EmpresaTransportista insertarEmpresaConAutos(EmpresaTransportista e) throws Exception;

    EmpresaTransportista insertarEmpresa(EmpresaTransportista e) throws Exception;

    EmpresaTransportista consultarEmpresa(EmpresaTransportista elemento) throws Exception;

    void eliminarEmpresa(EmpresaTransportista elemento) throws Exception;

    EmpresaTransportista actualizarEmpresa(EmpresaTransportista elemento) throws Exception;

    List<EmpresaTransportista> consultarTodasLasEmpresas() throws Exception;

    EmpresaTransportista iniciarSesion(EmpresaTransportista empresa) throws Exception;

    Productores insertarProductor(Productores e) throws Exception;

    Productores consultarProductor(Productores elemento) throws Exception;

    void eliminarProductor(Productores elemento) throws Exception;

    Productores actualizarProductor(Productores elemento) throws Exception;

    List<Productores> consultarProductores() throws Exception;

    List<Productores> consultarProductoresConSolicitudTraslado() throws Exception;

    Productores iniciarSesion(Productores productores) throws Exception;

    Productores obtenerCuenta(Cuenta cuenta) throws Exception;

    List<Quimicos> consultarQuimicosGenerales(ConfiguracionDePaginado configuracionDePaginado) throws Exception;

    Quimicos consultarQuimico(Quimicos quimico) throws Exception;

    Quimicos insertarQuimico(Quimicos quimico) throws Exception;

    void eliminarQuimico(Quimicos elemento) throws Exception;

    RegistroTraslado insertarTraslado(RegistroTraslado e) throws Exception;

    RegistroTraslado consultarTraslado(RegistroTraslado elemento) throws Exception;

    void eliminarTraslado(RegistroTraslado elemento) throws Exception;

    RegistroTraslado actualizarTraslado(RegistroTraslado elemento) throws Exception;

    List<RegistroTraslado> consultarTodosLosTrasladosExistentes() throws Exception;

    Residuos insertarResiduo(Residuos elemento) throws Exception;

    Residuos consultarResiduo(Residuos elemento) throws Exception;

    List<Residuos> consultarResiduos(List<Residuos> residuos) throws Exception;

    List<Residuos> consultarResiduo(ConfiguracionDePaginado configuracionDePaginado) throws Exception;

    List<Residuos> consultarResiduosPorProductor(Productores productor) throws Exception;

    Residuos eliminarResiduo(Residuos elemento) throws Exception;

    Residuos actualizarResiduo(Residuos elemento) throws Exception;

    Traslado insertarTraslado(Traslado e) throws Exception;

    Traslado consultarTraslado(Traslado elemento) throws Exception;

    Traslado actualizarTraslado(Traslado elemento) throws Exception;

    Vehiculo consultarAutoPorEmpresa(EmpresaTransportista emp) throws Exception;

    List<Vehiculo> consultarAutosPorEmpresa(EmpresaTransportista emp) throws Exception;

}
