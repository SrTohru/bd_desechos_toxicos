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

    List<Quimicos> consultarQuimicosGenerales(ConfiguracionDePaginado configuracionDePaginado);

    Quimicos consultarQuimico(Quimicos quimico);

    Quimicos insertarQuimico(Quimicos quimico);

    void eliminarQuimico(Quimicos elemento);
}