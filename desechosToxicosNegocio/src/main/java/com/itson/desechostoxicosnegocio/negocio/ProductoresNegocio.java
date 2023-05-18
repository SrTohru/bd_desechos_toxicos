/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.desechostoxicosnegocio.negocio;

import com.itson.desechostoxicosnegocio.interfaces.IProductores;
import com.itson.desechostoxicospersistencia.dao.ProductoresDAO;
import com.itson.dominio.Cuenta;
import com.itson.dominio.Productores;
import java.util.List;

/**
 *
 * @author PC
 */
public class ProductoresNegocio implements IProductores{
    
    //Añadir verificaciones de cada dato :)
    
    private ProductoresDAO productoresDAO;

    public ProductoresNegocio() {
        this.productoresDAO = new ProductoresDAO();
    }

    @Override
    public Productores insertarProductor(Productores e) throws Exception {
        validarProductor(e);
        return productoresDAO.insertarProductor(e);
    }

    @Override
    public Productores consultarProductor(Productores elemento) throws Exception {
        validarProductor(elemento);
        return productoresDAO.consultarProductor(elemento);
    }

    @Override
    public void eliminarProductor(Productores elemento) throws Exception {
        validarProductor(elemento);
        productoresDAO.eliminarProductor(elemento);
    }

    @Override
    public Productores actualizarProductor(Productores elemento) throws Exception {
        validarProductor(elemento);
        return productoresDAO.actualizarProductor(elemento);
    }

    @Override
    public List<Productores> consultarProductores() throws Exception {
        return productoresDAO.consultarProductores();
    }

    @Override
    public List<Productores> consultarProductoresConSolicitudTraslado() {
        //Falta por terminar
        return null;
    }

    private void validarProductor(Productores productor) throws Exception {
        if (productor == null) {
            throw new Exception("El productor no puede ser nulo");
        }
        if (productor.getNombre() == null || productor.getNombre().isEmpty()) {
            throw new Exception("El nombre del productor es requerido");
        }
        if (productor.getResiduos() == null || productor.getResiduos().isEmpty()) {
            throw new Exception("La lista de residuos del productor es requerida");
        }
        validarCuenta(productor.getCuenta());
        // Otras validaciones específicas del productor
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
