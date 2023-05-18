/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.desechostoxicosnegocio.negocio;

import com.itson.desechostoxicosnegocio.interfaces.IEmpresaTransportista;
import com.itson.desechostoxicospersistencia.dao.EmpresaTransportistaDAO;
import com.itson.dominio.Cuenta;
import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.Vehiculo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpresaTransportistaNegocio implements IEmpresaTransportista {

    //Crear la misma cantidad de metodos ademas de
    //Validar cada dato que sea necesario, despues de eso llamar el metodo en DAO
    //This is negocio
    private final EmpresaTransportistaDAO empresaTransportistaDAO;

    public EmpresaTransportistaNegocio() {
        this.empresaTransportistaDAO = new EmpresaTransportistaDAO();
    }

    @Override
    public EmpresaTransportista insertarEmpresaConAutos(EmpresaTransportista empresa) throws Exception {
        validarEmpresa(empresa);
        return empresaTransportistaDAO.insertarEmpresaConAutos(empresa);
    }

    @Override
    public EmpresaTransportista consultarEmpresa(EmpresaTransportista elemento) throws Exception {
        validarEmpresa(elemento);
        return empresaTransportistaDAO.consultarEmpresa(elemento);
    }

    @Override
    public void eliminarEmpresa(EmpresaTransportista elemento) throws Exception {
        validarEmpresa(elemento);
        empresaTransportistaDAO.eliminarEmpresa(elemento);
    }

    @Override
    public EmpresaTransportista actualizarEmpresa(EmpresaTransportista elemento) throws Exception {
        validarEmpresa(elemento);
        return empresaTransportistaDAO.actualizarEmpresa(elemento);
    }

    @Override
    public EmpresaTransportista insertarEmpresa(EmpresaTransportista empresa) throws Exception {
        validarEmpresa(empresa);
        return empresaTransportistaDAO.insertarEmpresa(empresa);
    }

    @Override
    public List<EmpresaTransportista> consultarTodasLasEmpresas() throws Exception {
        return empresaTransportistaDAO.consultarTodasLasEmpresas();
    }

    private void validarEmpresa(EmpresaTransportista empresa) throws Exception {
        if (empresa == null) {
            throw new Exception("La empresa no puede ser nula");
        }
        if (empresa.getNombre() == null || empresa.getNombre().isEmpty()) {
            throw new Exception("El nombre de la empresa es requerido");
        }
        if (empresa.getVehiculos() == null || empresa.getVehiculos().isEmpty()) {
            throw new Exception("La lista de vehículos de la empresa es requerida");
        }
        for (Vehiculo vehiculo : empresa.getVehiculos()) {
            validarVehiculo(vehiculo);
        }
        validarCuenta(empresa.getCuenta());
    }

    private void validarVehiculo(Vehiculo vehiculo) throws Exception {
        if (vehiculo == null) {
            throw new Exception("El vehículo no puede ser nulo");
        }
        if (vehiculo.getMarca() == null || vehiculo.getMarca().isEmpty()) {
            throw new Exception("La marca del vehículo es requerida");
        }
        if (vehiculo.getModelo() == null || vehiculo.getModelo().isEmpty()) {
            throw new Exception("El modelo del vehículo es requerido");
        }
        // Otras validaciones específicas del vehículo
    }

    private void validarCuenta(Cuenta cuenta) throws Exception {
        if (cuenta == null) {
            throw new Exception("La cuenta no puede ser nula");
        }
        if (cuenta.getUsuario() == null || cuenta.getUsuario().isEmpty()) {
            throw new Exception("El usuario de la cuenta es requerido");
        }
        if (cuenta.getContrasena() == null || cuenta.getContrasena().isEmpty()) {
            throw new Exception("La contraseña de la cuenta es requerida");
        }
        if (cuenta.getTipoCuenta() == null || cuenta.getTipoCuenta().isEmpty()) {
            throw new Exception("El tipo de cuenta es requerido");
        }
    }
}
