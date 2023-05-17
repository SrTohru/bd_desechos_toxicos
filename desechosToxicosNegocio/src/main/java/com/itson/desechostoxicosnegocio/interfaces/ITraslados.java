/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.desechostoxicosnegocio.interfaces;

import com.itson.desechostoxicospersistencia.utilities.ConfiguracionDePaginado;
import com.itson.dominio.Traslado;
import java.util.List;

/**
 *
 * @author PC
 */
public interface ITraslados {

    Traslado insertarElemento(Traslado e);

    Traslado consultarElemento(Traslado elemento);

    Traslado actualizarElemento(Traslado elemento);
}
