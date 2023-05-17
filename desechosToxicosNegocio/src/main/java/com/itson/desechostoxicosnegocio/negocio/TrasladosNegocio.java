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
    public Traslado insertarElemento(Traslado traslado) {
        try {
            return this.trasladoDAO.insertarElemento(traslado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar el traslado");
            return null;
        }
    }

    @Override
    public Traslado actualizarElemento(Traslado elemento) {
        try {
            return this.trasladoDAO.actualizarElemento(elemento);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al actualizar el traslado");
            return null;
        }
    }

    @Override
    public Traslado consultarElemento(Traslado elemento) {
        try {
            return this.trasladoDAO.consultarElemento(elemento);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al consultar el traslado");
            return null;
        }
    }
}
