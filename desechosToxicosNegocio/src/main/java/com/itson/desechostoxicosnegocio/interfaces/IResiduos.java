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
    
     List<Residuos> consultarElementos() throws Exception;

    List<Residuos> consultarElementos(ConfiguracionDePaginado configuracionDePaginado) throws Exception;

    Residuos insertarElemento(Residuos residuos) throws Exception;

    void eliminarElemento(Residuos elemento) throws Exception;

    Residuos actualizarElemento(Residuos elemento) throws Exception;

    List<Residuos> consultarElementosPorProductor(Productores productor) throws Exception;
}
