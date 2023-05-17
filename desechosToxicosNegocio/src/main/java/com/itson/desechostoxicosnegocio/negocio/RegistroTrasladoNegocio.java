/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.desechostoxicosnegocio.negocio;

import com.itson.desechostoxicosnegocio.interfaces.IRegistroTraslado;
import com.itson.desechostoxicospersistencia.dao.RegistroTrasladoDAO;
import com.itson.dominio.RegistroTraslado;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class RegistroTrasladoNegocio implements IRegistroTraslado {

    private RegistroTrasladoDAO registroTrasladoDAO;

    public RegistroTrasladoNegocio() {
        this.registroTrasladoDAO = new RegistroTrasladoDAO();
    }

    @Override
    public List<RegistroTraslado> consultarTodosLosTrasladosExistentes() throws Exception {

        return this.registroTrasladoDAO.consultarTodosLosTrasladosExistentes();

    }

    @Override
    public RegistroTraslado consultarTraslado(RegistroTraslado quimico) throws Exception {

        return this.registroTrasladoDAO.consultarTraslado(quimico);

    }

    @Override
    public RegistroTraslado insertarTraslado(RegistroTraslado quimico) throws Exception {

        return this.registroTrasladoDAO.insertarTraslado(quimico);

    }

    @Override
    public void eliminarTraslado(RegistroTraslado elemento) throws Exception {

        this.registroTrasladoDAO.eliminarTraslado(elemento);

    }

    @Override
    public RegistroTraslado actualizarTraslado(RegistroTraslado elemento) throws Exception {

        return this.registroTrasladoDAO.actualizarTraslado(elemento);

    }
}
