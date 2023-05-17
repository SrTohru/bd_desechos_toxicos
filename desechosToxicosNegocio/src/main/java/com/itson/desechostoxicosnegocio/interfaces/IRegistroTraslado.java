/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.desechostoxicosnegocio.interfaces;

import com.itson.dominio.RegistroTraslado;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IRegistroTraslado {

    List<RegistroTraslado> consultarTodosLosTrasladosExistentes();

    RegistroTraslado consultarTraslado(RegistroTraslado elemento);

    RegistroTraslado insertarTraslado(RegistroTraslado e);

    void eliminarTraslado(RegistroTraslado elemento);

    RegistroTraslado actualizarTraslado(RegistroTraslado elemento);
}
