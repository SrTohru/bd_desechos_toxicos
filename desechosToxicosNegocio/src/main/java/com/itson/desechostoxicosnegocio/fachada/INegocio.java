package com.itson.desechostoxicosnegocio.fachada;

import com.itson.desechostoxicospersistencia.utilities.ConfiguracionDePaginado;
import com.itson.dominio.Cuenta;
import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.Productores;
import com.itson.dominio.Quimicos;
import com.itson.dominio.RegistroTraslado;
import com.itson.dominio.Residuos;
import com.itson.dominio.Traslado;
import com.itson.dominio.Vehiculo;
import java.util.List;

public interface INegocio {

    Cuenta insertarCuenta(Cuenta cuenta) throws Exception;

    Cuenta iniciarSesion(Cuenta cuenta) throws Exception;

    EmpresaTransportista insertarEmpresaConAutos(EmpresaTransportista empresa) throws Exception;

    EmpresaTransportista consultarEmpresa(EmpresaTransportista elemento) throws Exception;

    void eliminarEmpresa(EmpresaTransportista elemento) throws Exception;

    EmpresaTransportista actualizarEmpresa(EmpresaTransportista elemento) throws Exception;

    EmpresaTransportista insertarEmpresa(EmpresaTransportista empresa) throws Exception;

    List<EmpresaTransportista> consultarTodasLasEmpresas() throws Exception;

    Productores insertarProductor(Productores e) throws Exception;

    Productores consultarProductor(Productores elemento) throws Exception;

    void eliminarProductor(Productores elemento) throws Exception;

    Productores actualizarProductor(Productores elemento) throws Exception;

    List<Productores> consultarProductores() throws Exception;

    List<Productores> consultarProductoresConSolicitudTraslado() throws Exception;

    List<Quimicos> consultarQuimicosGenerales(ConfiguracionDePaginado configuracionDePaginado) throws Exception;

    Quimicos consultarQuimico(Quimicos quimico) throws Exception;

    Quimicos insertarQuimico(Quimicos quimico) throws Exception;

    void eliminarQuimico(Quimicos elemento) throws Exception;

    List<RegistroTraslado> consultarTodosLosTrasladosExistentes() throws Exception;

    RegistroTraslado consultarTraslado(RegistroTraslado elemento) throws Exception;

    RegistroTraslado insertarTraslado(RegistroTraslado e) throws Exception;

    void eliminarTraslado(RegistroTraslado elemento) throws Exception;

    RegistroTraslado actualizarTraslado(RegistroTraslado elemento) throws Exception;

    List<Residuos> consultarResiduos() throws Exception;

    List<Residuos> consultarResiduos(ConfiguracionDePaginado configuracionDePaginado) throws Exception;

    Residuos insertarResiduo(Residuos residuos) throws Exception;

    void eliminarResiduo(Residuos elemento) throws Exception;

    Residuos actualizarResiduo(Residuos elemento) throws Exception;

    List<Residuos> consultarResiduosPorProductor(Productores productor) throws Exception;

    Traslado insertarTraslado(Traslado e) throws Exception;

    Traslado consultarTraslado(Traslado elemento) throws Exception;

    Traslado actualizarTraslado(Traslado elemento) throws Exception;

    Vehiculo consultarAutoPorEmpresa(EmpresaTransportista emp) throws Exception;

    List<Vehiculo> consultarAutosPorEmpresa(EmpresaTransportista emp) throws Exception;

}
