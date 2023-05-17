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
    public List<RegistroTraslado> consultarTodosLosTrasladosExistentes() {
        try {
            return this.registroTrasladoDAO.consultarTodosLosTrasladosExistentes();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al consultar todos los traslados existentes");
            return null;
        }
    }

    @Override
    public RegistroTraslado consultarTraslado(RegistroTraslado quimico) {
        try {
            return this.registroTrasladoDAO.consultarTraslado(quimico);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al consultar el traslado");
            return null;
        }
    }

    @Override
    public RegistroTraslado insertarTraslado(RegistroTraslado quimico) {
        try {
            return this.registroTrasladoDAO.insertarTraslado(quimico);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar el traslado");
            return null;
        }
    }

    @Override
    public void eliminarTraslado(RegistroTraslado elemento) {
        try {
            this.registroTrasladoDAO.eliminarTraslado(elemento);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al eliminar el traslado");
        }
    }

    @Override
    public RegistroTraslado actualizarTraslado(RegistroTraslado elemento) {
        try {
            return this.registroTrasladoDAO.actualizarTraslado(elemento);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al actualizar el traslado");
            return null;
        }
    }
}
