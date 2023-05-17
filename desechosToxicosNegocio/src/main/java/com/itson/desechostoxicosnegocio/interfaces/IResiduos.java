/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.desechostoxicosnegocio.interfaces;

import com.itson.desechostoxicospersistencia.utilities.ConfiguracionDePaginado;
import com.itson.dominio.Productores;
import com.itson.dominio.Residuos;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IResiduos {
    
     List<Residuos> consultarElementos();

    List<Residuos> consultarElementos(ConfiguracionDePaginado configuracionDePaginado);

    Residuos insertarElemento(Residuos residuos);

    void eliminarElemento(Residuos elemento);

    Residuos actualizarElemento(Residuos elemento);

    List<Residuos> consultarElementosPorProductor(Productores productor);
}
