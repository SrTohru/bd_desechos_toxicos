package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.dominio.Productores;
import java.util.List;

public interface IProductores {

    Productores insertarProductor(Productores e) throws Exception;

    Productores consultarProductor(Productores elemento) throws Exception;

    void eliminarProductor(Productores elemento) throws Exception;

    Productores actualizarProductor(Productores elemento) throws Exception;

    List<Productores> consultarProductores() throws Exception;
    
    List<Productores> consultarProductoresConSolicitudTraslado() throws Exception;
    
    Productores iniciarSesion(Productores productores) throws Exception;
    
}
