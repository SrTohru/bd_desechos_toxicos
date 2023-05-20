package com.itson.desechostoxicosnegocio.fachada;

import com.itson.desechostoxicosnegocio.interfaces.ICuenta;
import com.itson.desechostoxicosnegocio.interfaces.IEmpresaTransportista;
import com.itson.desechostoxicosnegocio.interfaces.IProductores;
import com.itson.desechostoxicosnegocio.interfaces.IQuimicos;
import com.itson.desechostoxicosnegocio.interfaces.IRegistroTraslado;
import com.itson.desechostoxicosnegocio.interfaces.IResiduos;
import com.itson.desechostoxicosnegocio.interfaces.ITraslados;
import com.itson.desechostoxicosnegocio.interfaces.IVehiculo;
import com.itson.desechostoxicosnegocio.negocio.CuentaNegocio;
import com.itson.desechostoxicosnegocio.negocio.EmpresaTransportistaNegocio;
import com.itson.desechostoxicosnegocio.negocio.ProductoresNegocio;
import com.itson.desechostoxicosnegocio.negocio.QuimicosNegocio;
import com.itson.desechostoxicosnegocio.negocio.RegistroTrasladoNegocio;
import com.itson.desechostoxicosnegocio.negocio.ResiduosNegocio;
import com.itson.desechostoxicosnegocio.negocio.TrasladosNegocio;
import com.itson.desechostoxicosnegocio.negocio.VehiculoNegocio;
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

public class FachadaNegocio implements INegocio {

    private ICuenta cuentaN;
    private IEmpresaTransportista empresaN;
    private IProductores productoresN;
    private IQuimicos quimicosN;
    private IRegistroTraslado registroTrasladoN;
    private IResiduos residuosN;
    private ITraslados trasladosN;
    private IVehiculo vehiculoN;

    public FachadaNegocio() {
        cuentaN = new CuentaNegocio();
        empresaN = new EmpresaTransportistaNegocio();
        productoresN = new ProductoresNegocio();
        quimicosN = new QuimicosNegocio();
        registroTrasladoN = new RegistroTrasladoNegocio();
        residuosN = new ResiduosNegocio();
        trasladosN = new TrasladosNegocio();
        vehiculoN = new VehiculoNegocio();
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
    public List<Residuos> consultarResiduos() throws Exception {
        try {
            return residuosN.consultarResiduos();
        } catch (Exception ex) {
            throw new Exception("Hubo un error al consultar los elementos en fachada");
        }
    }

    @Override
    public List<Residuos> consultarResiduos(ConfiguracionDePaginado configuracionDePaginado) throws Exception {
        try {
            return residuosN.consultarResiduos(configuracionDePaginado);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al consultar los elementos en fachada");
        }
    }

    @Override
    public Residuos insertarResiduo(Residuos residuos) throws Exception {
        try {
            return residuosN.insertarResiduo(residuos);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al insertar el elemento en fachada");
        }
    }

    @Override
    public void eliminarResiduo(Residuos elemento) throws Exception {
        try {
            residuosN.eliminarResiduo(elemento);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al eliminar el elemento en fachada");
        }
    }

    @Override
    public Residuos actualizarResiduo(Residuos elemento) throws Exception {
        try {
            return residuosN.actualizarResiduo(elemento);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al actualizar el elemento en fachada");
        }
    }

    @Override
    public List<Residuos> consultarResiduosPorProductor(Productores productor) throws Exception {
        try {
            return residuosN.consultarResiduosPorProductor(productor);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al consultar los elementos por productor en fachada");
        }
    }

    @Override
    public Traslado insertarTraslado(Traslado e) throws Exception {
        try {
            return trasladosN.insertarElemento(e);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al insertar el elemento en fachada");
        }
    }

    @Override
    public List<Traslado> consultarTraslados() throws Exception {
        try {
            return trasladosN.consultarTraslados();
        } catch (Exception e) {
            throw new Exception("Hubo un error al consultar todos los traslados");
        }
    }

    @Override
    public Traslado consultarTraslado(Traslado elemento) throws Exception {
        try {
            return trasladosN.consultarElemento(elemento);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al consultar el elemento en fachada");
        }
    }

    @Override
    public Traslado actualizarTraslado(Traslado elemento) throws Exception {
        try {
            return trasladosN.actualizarElemento(elemento);
        } catch (Exception ex) {
            throw new Exception("Hubo un error al actualizar el elemento en fachada");
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

}
