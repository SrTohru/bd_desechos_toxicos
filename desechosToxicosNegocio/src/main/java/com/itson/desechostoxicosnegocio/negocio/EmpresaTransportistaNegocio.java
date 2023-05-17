/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.desechostoxicosnegocio.negocio;

import com.itson.desechostoxicosnegocio.interfaces.IEmpresaTransportista;
import com.itson.desechostoxicospersistencia.dao.EmpresaTransportistaDAO;
import com.itson.dominio.EmpresaTransportista;
import java.util.List;

public class EmpresaTransportistaNegocio implements IEmpresaTransportista {

    //Crear la misma cantidad de metodos ademas de
    //Validar cada dato que sea necesario, despues de eso llamar el metodo en DAO
    
    //This is negocio
    private final EmpresaTransportistaDAO empresaTransportistaDAO;

    public EmpresaTransportistaNegocio() {
        this.empresaTransportistaDAO = new EmpresaTransportistaDAO();
    }

    public EmpresaTransportista insertarEmpresaConAutos(EmpresaTransportista empresa) {
        return empresaTransportistaDAO.insertarEmpresaConAutos(empresa);
    }

    public EmpresaTransportista consultarEmpresa(EmpresaTransportista elemento) {
        return empresaTransportistaDAO.consultarEmpresa(elemento);
    }

    public void eliminarEmpresa(EmpresaTransportista elemento) {
        empresaTransportistaDAO.eliminarEmpresa(elemento);
    }

    public EmpresaTransportista actualizarEmpresa(EmpresaTransportista elemento) {
        return empresaTransportistaDAO.actualizarEmpresa(elemento);
    }

    public EmpresaTransportista insertarEmpresa(EmpresaTransportista empresa) {
        return empresaTransportistaDAO.insertarEmpresa(empresa);
    }

    public List<EmpresaTransportista> consultarTodasLasEmpresas() {
        return empresaTransportistaDAO.consultarTodasLasEmpresas();
    }

}