/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.desechostoxicospersistencia.fachada;

import com.itson.desechostoxicospersistencia.dao.AdministradorDAO;
import com.itson.desechostoxicospersistencia.dao.CuentaDAO;
import com.itson.desechostoxicospersistencia.dao.EmpresaTransportistaDAO;
import com.itson.desechostoxicospersistencia.dao.ProductoresDAO;
import com.itson.desechostoxicospersistencia.dao.QuimicosDAO;
import com.itson.desechostoxicospersistencia.dao.RegistroTrasladoDAO;
import com.itson.desechostoxicospersistencia.dao.ResiduosDAO;
import com.itson.desechostoxicospersistencia.dao.TrasladoDAO;
import com.itson.desechostoxicospersistencia.dao.VehiculoDAO;
import com.itson.desechostoxicospersistencia.interfaces.IAdministrador;
import com.itson.desechostoxicospersistencia.interfaces.ICuenta;
import com.itson.desechostoxicospersistencia.interfaces.IEmpresaTransportista;
import com.itson.desechostoxicospersistencia.interfaces.IProductores;
import com.itson.desechostoxicospersistencia.interfaces.IQuimicos;
import com.itson.desechostoxicospersistencia.interfaces.IRegistroTraslado;
import com.itson.desechostoxicospersistencia.interfaces.IResiduos;
import com.itson.desechostoxicospersistencia.interfaces.ITraslado;
import com.itson.desechostoxicospersistencia.interfaces.IVehiculo;
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
public class FachadaPersistencia implements INegocio {

    private ICuenta cuentaN;
    private IEmpresaTransportista empresaN;
    private IProductores productoresN;
    private IQuimicos quimicosN;
    private IRegistroTraslado registroTrasladoN;
    private IResiduos residuosN;
    private ITraslado trasladosN;
    private IVehiculo vehiculoN;
    private IAdministrador administradorN;

    public FachadaPersistencia() {
        cuentaN = new CuentaDAO();
        empresaN = new EmpresaTransportistaDAO();
        productoresN = new ProductoresDAO();
        quimicosN = new QuimicosDAO();
        registroTrasladoN = new RegistroTrasladoDAO();
        residuosN = new ResiduosDAO();
        trasladosN = new TrasladoDAO();
        vehiculoN = new VehiculoDAO();
        administradorN = new AdministradorDAO();
    }

    @Override
    public Cuenta insertarCuenta(Cuenta cuenta) throws Exception {
        try {
            return cuentaN.insertarCuenta(cuenta);
        } catch (Exception e) {
            throw new Exception("Hubo un error al insertar la cuenta en fachada");
        }
    }

    @Override
    public Cuenta iniciarSesion(Cuenta cuenta) throws Exception {
        try {
            return cuentaN.iniciarSesion(cuenta);
        } catch (Exception e) {
            throw new Exception("Hubo un error al iniciar sesión en fachada");
        }
    }

    @Override
    public EmpresaTransportista insertarEmpresaConAutos(EmpresaTransportista empresas) throws Exception {
        try {
            return empresaN.insertarEmpresaConAutos(empresas);
        } catch (Exception e) {
            throw new Exception("Hubo un error al insertar una empresa con autos en fachada");
        }
    }

    @Override
    public EmpresaTransportista consultarEmpresa(EmpresaTransportista elemento) throws Exception {
        try {
            return empresaN.consultarEmpresa(elemento);
        } catch (Exception e) {
            throw new Exception("Hubo un error al consultar una empresa en fachada");
        }
    }

    @Override
    public void eliminarEmpresa(EmpresaTransportista elemento) throws Exception {
        try {
            empresaN.eliminarEmpresa(elemento);
        } catch (Exception e) {
            throw new Exception("Hubo un error al eliminar la empresa en fachada");
        }
    }

    @Override
    public EmpresaTransportista actualizarEmpresa(EmpresaTransportista elemento) throws Exception {
        try {
            return empresaN.actualizarEmpresa(elemento);
        } catch (Exception e) {
            throw new Exception("Hubo un error al actualizar una empresa en fachada");
        }
    }

    @Override
    public EmpresaTransportista insertarEmpresa(EmpresaTransportista empresa) throws Exception {
        try {
            return empresaN.insertarEmpresa(empresa);
        } catch (Exception e) {
            throw new Exception("Hubo un error al insertar una empresa en fachada");
        }
    }

    @Override
    public List<EmpresaTransportista> consultarTodasLasEmpresas() throws Exception {
        try {
            return empresaN.consultarTodasLasEmpresas();
        } catch (Exception e) {
            throw new Exception("Hubo un error al consultar todas las empresas existentes en fachada");
        }
    }

    @Override
    public Productores insertarProductor(Productores e) throws Exception {
        try {
            return productoresN.insertarProductor(e);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al insertar un productor en fachada");
        }
    }

    @Override
    public Productores consultarProductor(Productores elemento) throws Exception {
        try {
            return productoresN.consultarProductor(elemento);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al consultar el productor en fachada");
        }
    }

    @Override
    public void eliminarProductor(Productores elemento) throws Exception {
        try {
            productoresN.eliminarProductor(elemento);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al eliminar el productor en fachada");
        }
    }

    @Override
    public Productores actualizarProductor(Productores elemento) throws Exception {
        try {
            return productoresN.actualizarProductor(elemento);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al actualizar el productor en fachada");
        }
    }

    @Override
    public List<Productores> consultarProductores() throws Exception {
        try {
            return productoresN.consultarProductores();
        } catch (Exception ex) {
            throw new Exception("Hubo un error al consultar los productores en fachada");
        }
    }

    @Override
    public List<Productores> consultarProductoresConSolicitudTraslado() throws Exception {
        try {
            return productoresN.consultarProductoresConSolicitudTraslado();
        } catch (Exception ex) {
            throw new Exception("Hubo un error al consultar los productores con solicitud de traslado en fachada");
        }
    }

    @Override
    public List<Quimicos> consultarQuimicosGenerales(ConfiguracionDePaginado configuracionDePaginado) throws Exception {
        try {
            return quimicosN.consultarQuimicosGenerales(configuracionDePaginado);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al consultar los químicos generales en fachada");
        }
    }

    @Override
    public Quimicos consultarQuimico(Quimicos quimico) throws Exception {
        try {
            return quimicosN.consultarQuimico(quimico);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al consultar el químico en fachada");
        }
    }

    @Override
    public Quimicos insertarQuimico(Quimicos quimico) throws Exception {
        try {
            return quimicosN.insertarQuimico(quimico);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al insertar el químico en fachada");
        }
    }

    @Override
    public void eliminarQuimico(Quimicos elemento) throws Exception {
        try {
            quimicosN.eliminarQuimico(elemento);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al eliminar el químico en fachada");
        }
    }

    @Override
    public List<RegistroTraslado> consultarTodosLosTrasladosExistentes() throws Exception {
        try {
            return registroTrasladoN.consultarTodosLosTrasladosExistentes();
        } catch (Exception ex) {
            throw new Exception("Hubo un error al consultar todos los traslados existentes en fachada");
        }
    }

    @Override
    public RegistroTraslado consultarTraslado(RegistroTraslado elemento) throws Exception {
        try {
            return registroTrasladoN.consultarTraslado(elemento);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al consultar el traslado en fachada");
        }
    }

    @Override
    public RegistroTraslado insertarTraslado(RegistroTraslado e) throws Exception {
        try {
            return registroTrasladoN.insertarTraslado(e);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al insertar el traslado en fachada");
        }
    }

    @Override
    public void eliminarTraslado(RegistroTraslado elemento) throws Exception {
        try {
            registroTrasladoN.eliminarTraslado(elemento);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al eliminar el traslado en fachada");
        }
    }

    @Override
    public RegistroTraslado actualizarTraslado(RegistroTraslado elemento) throws Exception {
        try {
            return registroTrasladoN.actualizarTraslado(elemento);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al actualizar el traslado en fachada");
        }
    }

    @Override
    public Residuos insertarResiduo(Residuos residuos) throws Exception {
        try {
            return residuosN.insertarResiduo(residuos);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al insertar el productor en fachada");
        }
    }

    @Override
    public Residuos actualizarResiduo(Residuos elemento) throws Exception {
        try {
            return residuosN.actualizarResiduo(elemento);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al actualizar el productor en fachada");
        }
    }

    @Override
    public List<Residuos> consultarResiduosPorProductor(Productores productor) throws Exception {
        try {
            return residuosN.consultarResiduosPorProductor(productor);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al consultar los residuos por productor en fachada");
        }
    }

    @Override
    public Traslado insertarTraslado(Traslado e) throws Exception {
        try {
            return trasladosN.insertarTraslado(e);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al insertar el traslado en fachada");
        }
    }

    @Override
    public Traslado consultarTraslado(Traslado elemento) throws Exception {
        try {
            return trasladosN.consultarTraslado(elemento);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al consultar el traslado en fachada");
        }
    }

    @Override
    public Traslado actualizarTraslado(Traslado elemento) throws Exception {
        try {
            return trasladosN.actualizarTraslado(elemento);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al actualizar el traslado en fachada");
        }
    }

    @Override
    public Vehiculo consultarAutoPorEmpresa(EmpresaTransportista emp) throws Exception {
        try {
            return vehiculoN.consultarAutoPorEmpresa(emp);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al consultar el auto por empresa en fachada");
        }
    }

    @Override
    public List<Vehiculo> consultarAutosPorEmpresa(EmpresaTransportista emp) throws Exception {
        try {
            return vehiculoN.consultarAutosPorEmpresa(emp);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al consultar los autos por empresa en fachada");
        }
    }

    @Override
    public Productores obtenerCuenta(Cuenta cuenta) throws Exception {
        try {
            return productoresN.obtenerCuenta(cuenta);
        } catch (Exception e) {
            throw new Exception("Hubo un error al consultar la cuenta del productor en fachada");
        }
    }

    @Override
    public Residuos consultarResiduo(Residuos elemento) throws Exception {
        try {
            return residuosN.consultarResiduo(elemento);
        } catch (Exception e) {
            throw new Exception("Hubo un error al consultar el residuo en fachada");
        }
    }

    @Override
    public List<Residuos> consultarResiduos(List<Residuos> residuos) throws Exception {
        try {
            return residuosN.consultarResiduos(residuos);
        } catch (Exception e) {
            throw new Exception("Hubo un error al consultar los residuos en fachada");
        }
    }

    @Override
    public Administrador iniciarSesion(Administrador administrador) throws Exception {
        try {
            return administradorN.iniciarSesion(administrador);
        } catch (Exception e) {
            throw new Exception("Hubo un error al iniciar sesion como administrador");
        }
    }

    @Override
    public EmpresaTransportista iniciarSesion(EmpresaTransportista empresa) throws Exception {
        try {
            return empresaN.iniciarSesion(empresa);
        } catch (Exception e) {
            throw new Exception("Hubo un error al iniciar sesion como empresa");
        }
    }

    @Override
    public Productores iniciarSesion(Productores productores) throws Exception {
        try {
            return productoresN.iniciarSesion(productores);
        } catch (Exception e) {
            throw new Exception("Hubo un error al iniciar sesion como productor");
        }
    }

    @Override
    public List<Residuos> consultarResiduo(ConfiguracionDePaginado configuracionDePaginado) throws Exception {
        try {
            return residuosN.consultarResiduo(configuracionDePaginado);
        } catch (Exception e) {
            throw new Exception("Hubo un error al consultar los residuos");
        }
    }

    @Override
    public Residuos eliminarResiduo(Residuos elemento) throws Exception {
        try {
            return residuosN.eliminarResiduo(elemento);
        } catch (Exception e) {
            throw new Exception("Hubo un error al eliminar el residuo");
        }
    }

}
