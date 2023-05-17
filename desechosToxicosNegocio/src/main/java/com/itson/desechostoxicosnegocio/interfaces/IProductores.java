/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.desechostoxicosnegocio.interfaces;

import com.itson.dominio.Productores;
import java.util.List;

public interface IProductores {
     Productores insertarProductor(Productores e);

    Productores consultarProductor(Productores elemento);

    void eliminarProductor(Productores elemento);

    Productores actualizarProductor(Productores elemento);

    List<Productores> consultarProductores();

    List<Productores> consultarProductoresConSolicitudTraslado();
}
