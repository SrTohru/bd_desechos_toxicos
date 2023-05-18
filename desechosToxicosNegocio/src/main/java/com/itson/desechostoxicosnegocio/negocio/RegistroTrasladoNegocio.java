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
        try {
            return this.registroTrasladoDAO.consultarTodosLosTrasladosExistentes();
        } catch (Exception e) {
            // Manejar la excepción o relanzarla
            throw e;
        }
    }

    @Override
    public RegistroTraslado consultarTraslado(RegistroTraslado quimico) throws Exception {
        try {
            if (quimico == null) {
                throw new IllegalArgumentException("El objeto RegistroTraslado proporcionado es nulo");
            }
            // Realizar la lógica de consulta del traslado
            return this.registroTrasladoDAO.consultarTraslado(quimico);
        } catch (Exception e) {
            // Manejar la excepción o relanzarla
            throw e;
        }
    }

    @Override
    public RegistroTraslado insertarTraslado(RegistroTraslado quimico) throws Exception {
        try {
            if (quimico == null) {
                throw new IllegalArgumentException("El objeto RegistroTraslado proporcionado es nulo");
            }
            // Realizar la lógica de inserción del traslado
            return this.registroTrasladoDAO.insertarTraslado(quimico);
        } catch (Exception e) {
            // Manejar la excepción o relanzarla
            throw e;
        }
    }

    @Override
    public void eliminarTraslado(RegistroTraslado elemento) throws Exception {
        try {
            if (elemento == null) {
                throw new IllegalArgumentException("El objeto RegistroTraslado proporcionado es nulo");
            }
            // Realizar la lógica de eliminación del traslado
            this.registroTrasladoDAO.eliminarTraslado(elemento);
        } catch (Exception e) {
            // Manejar la excepción o relanzarla
            throw e;
        }
    }

    @Override
    public RegistroTraslado actualizarTraslado(RegistroTraslado elemento) throws Exception {
        try {
            if (elemento == null) {
                throw new IllegalArgumentException("El objeto RegistroTraslado proporcionado es nulo");
            }
            // Realizar la lógica de actualización del traslado
            return this.registroTrasladoDAO.actualizarTraslado(elemento);
        } catch (Exception e) {
            // Manejar la excepción o relanzarla
            throw e;
        }
    }
}
