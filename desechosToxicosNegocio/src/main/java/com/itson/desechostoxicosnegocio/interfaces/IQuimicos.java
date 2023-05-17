/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.desechostoxicosnegocio.interfaces;

import com.itson.desechostoxicospersistencia.utilities.ConfiguracionDePaginado;
import com.itson.dominio.Quimicos;
import java.util.List;

/**
 *
 * @author PC
 */
public interface IQuimicos {

    List<Quimicos> consultarQuimicosGenerales(ConfiguracionDePaginado configuracionDePaginado)  throws Exception;

    Quimicos consultarQuimico(Quimicos quimico)  throws Exception;

    Quimicos insertarQuimico(Quimicos quimico)  throws Exception;

    void eliminarQuimico(Quimicos elemento)  throws Exception;
}
