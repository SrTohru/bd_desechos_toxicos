/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.desechostoxicosnegocio.negocio;

import com.itson.desechostoxicosnegocio.interfaces.ITraslados;
import com.itson.desechostoxicospersistencia.dao.TrasladoDAO;
import com.itson.desechostoxicospersistencia.utilities.ConfiguracionDePaginado;
import com.itson.dominio.Traslado;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class TrasladosNegocio implements ITraslados {

    private TrasladoDAO trasladoDAO;

    public TrasladosNegocio() {
        this.trasladoDAO = new TrasladoDAO();
    }

    @Override
    public Traslado insertarElemento(Traslado traslado) throws Exception {
   
            return this.trasladoDAO.insertarElemento(traslado);
      
    }

    @Override
    public Traslado actualizarElemento(Traslado elemento) throws Exception {
 
            return this.trasladoDAO.actualizarElemento(elemento);
       
    }

    @Override
    public Traslado consultarElemento(Traslado elemento) throws Exception {
   
            return this.trasladoDAO.consultarElemento(elemento);
      
    }
}
