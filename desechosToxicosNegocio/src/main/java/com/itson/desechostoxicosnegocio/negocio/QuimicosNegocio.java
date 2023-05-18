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
    public List<Quimicos> consultarQuimicosGenerales(ConfiguracionDePaginado configuracionDePaginado) throws Exception {
        // Validar configuracionDePaginado si es necesario
        return quimicosDAO.consultarQuimicosGenerales(configuracionDePaginado);
    }

    @Override
    public Quimicos consultarQuimico(Quimicos quimico) throws Exception {
        validarQuimico(quimico);
        return quimicosDAO.consultarQuimico(quimico);
    }

    @Override
    public Quimicos insertarQuimico(Quimicos quimico) throws Exception {
        validarQuimico(quimico);
        return quimicosDAO.insertarQuimico(quimico);
    }

    @Override
    public void eliminarQuimico(Quimicos elemento) throws Exception {
        validarQuimico(elemento);
        quimicosDAO.eliminarQuimico(elemento);
    }

    private void validarQuimico(Quimicos quimico) throws Exception {
        if (quimico == null) {
            throw new Exception("El químico no puede ser nulo");
        }
        if (quimico.getNombre() == null || quimico.getNombre().isEmpty()) {
            throw new Exception("El nombre del químico es requerido");
        }
        // Otras validaciones específicas del químico
    }
}
