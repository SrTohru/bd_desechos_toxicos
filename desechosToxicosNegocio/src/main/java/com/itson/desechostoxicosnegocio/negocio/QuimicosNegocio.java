/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.desechostoxicosnegocio.negocio;

import com.itson.desechostoxicosnegocio.interfaces.IQuimicos;
import com.itson.desechostoxicospersistencia.dao.QuimicosDAO;
import com.itson.desechostoxicospersistencia.utilities.ConfiguracionDePaginado;
import com.itson.dominio.Quimicos;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class QuimicosNegocio implements IQuimicos {

    private QuimicosDAO quimicosDAO;

    public QuimicosNegocio() {
        this.quimicosDAO = new QuimicosDAO();
    }

    @Override
    public List<Quimicos> consultarQuimicosGenerales(ConfiguracionDePaginado configuracionDePaginado) {
        try {
            return this.quimicosDAO.consultarQuimicosGenerales(configuracionDePaginado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al consultar los químicos generales");
            return null;
        }
    }

    @Override
    public Quimicos consultarQuimico(Quimicos quimico) {
        try {
            return this.quimicosDAO.consultarQuimico(quimico);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al consultar el químico");
            return null;
        }
    }

    @Override
    public Quimicos insertarQuimico(Quimicos quimico) {
        try {
            return this.quimicosDAO.insertarQuimico(quimico);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar el químico");
            return null;
        }
    }

    @Override
    public void eliminarQuimico(Quimicos elemento) {
        try {
            this.quimicosDAO.eliminarQuimico(elemento);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al eliminar el químico");
        }
    }
}
