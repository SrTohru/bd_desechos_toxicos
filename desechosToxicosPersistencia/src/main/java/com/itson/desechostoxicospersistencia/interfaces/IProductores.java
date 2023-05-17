package com.itson.desechostoxicospersistencia.interfaces;

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
