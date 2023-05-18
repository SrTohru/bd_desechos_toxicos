/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.desechostoxicosnegocio.interfaces;

import com.itson.dominio.Cuenta;
import com.itson.dominio.Productores;
import java.util.List;

public interface IProductores {

    Productores insertarProductor(Productores e) throws Exception;

    Productores consultarProductor(Productores elemento) throws Exception;

    void eliminarProductor(Productores elemento) throws Exception;

    Productores actualizarProductor(Productores elemento) throws Exception;

    List<Productores> consultarProductores() throws Exception;

    List<Productores> consultarProductoresConSolicitudTraslado() throws Exception;

    Productores obtenerCuenta(Cuenta cuenta) throws Exception;
}
