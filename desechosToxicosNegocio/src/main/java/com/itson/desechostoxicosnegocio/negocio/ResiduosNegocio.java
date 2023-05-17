/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.desechostoxicosnegocio.negocio;

import com.itson.desechostoxicosnegocio.interfaces.IResiduos;
import com.itson.desechostoxicospersistencia.dao.ResiduosDAO;
import com.itson.desechostoxicospersistencia.utilities.ConfiguracionDePaginado;
import com.itson.dominio.Productores;
import com.itson.dominio.Residuos;
import java.util.List;
import javax.swing.JOptionPane;

public class ResiduosNegocio implements IResiduos {

    private ResiduosDAO residuosDAO;

    public ResiduosNegocio() {
        this.residuosDAO = new ResiduosDAO();
    }

 @Override
public List<Residuos> consultarElementos(ConfiguracionDePaginado configuracionDePaginado) {
    try {
        return this.residuosDAO.consultarElemento(configuracionDePaginado);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Hubo un error al consultar los residuos");
        return null;
    }
}

    @Override
    public Residuos insertarElemento(Residuos residuos) {
        try {
            return this.residuosDAO.insertarElemento(residuos);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar el residuo");
            return null;
        }
    }

    @Override
    public void eliminarElemento(Residuos elemento) {
        try {
            this.residuosDAO.eliminarElemento(elemento);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al eliminar el residuo");
        }
    }

    @Override
    public Residuos actualizarElemento(Residuos elemento) {
        try {
            return this.residuosDAO.actualizarElemento(elemento);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al actualizar el residuo");
            return null;
        }
    }

    @Override
    public List<Residuos> consultarElementosPorProductor(Productores productor) {
        try {
            return this.residuosDAO.consultarElementosPorProductor(productor);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al consultar los residuos por productor");
            return null;
        }
    }

    @Override
    public List<Residuos> consultarElementos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
