/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.desechostoxicosnegocio.negocio;

import com.itson.desechostoxicosnegocio.interfaces.IProductores;
import com.itson.desechostoxicospersistencia.dao.ProductoresDAO;
import com.itson.dominio.Productores;
import java.util.List;

/**
 *
 * @author PC
 */
public class ProductoresNegocio implements IProductores{

    private ProductoresDAO productoresDAO;

    public ProductoresNegocio() {
        this.productoresDAO = new ProductoresDAO();
    }

    @Override
    public Productores insertarProductor(Productores e) throws Exception {
        return this.productoresDAO.insertarProductor(e);
    }

    @Override
    public Productores consultarProductor(Productores elemento) throws Exception {
        return this.productoresDAO.consultarProductor(elemento);
    }

    @Override
    public void eliminarProductor(Productores elemento) throws Exception {
        this.productoresDAO.eliminarProductor(elemento);
    }

    @Override
    public Productores actualizarProductor(Productores elemento) throws Exception {
        return this.productoresDAO.actualizarProductor(elemento);
    }

    @Override
    public List<Productores> consultarProductores() throws Exception {
        return this.productoresDAO.consultarProductores();
    }

    @Override
    public List<Productores> consultarProductoresConSolicitudTraslado() {
        //Falta por terminar
        return null;
    }
}
