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
    
     List<Residuos> consultarResiduos() throws Exception;

    List<Residuos> consultarResiduos(ConfiguracionDePaginado configuracionDePaginado) throws Exception;

    Residuos insertarResiduo(Residuos residuos) throws Exception;

    void eliminarResiduo(Residuos elemento) throws Exception;

    Residuos actualizarResiduo(Residuos elemento) throws Exception;

    List<Residuos> consultarResiduosPorProductor(Productores productor) throws Exception;
}
