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
    public List<Residuos> consultarResiduos(ConfiguracionDePaginado configuracionDePaginado) throws Exception {

        return this.residuosDAO.consultarResiduo(configuracionDePaginado);

    }

    @Override
    public Residuos insertarResiduo(Residuos residuos) throws Exception {
        validarResiduos(residuos);
        return this.residuosDAO.insertarResiduo(residuos);

    }

    @Override
    public void eliminarResiduo(Residuos elemento) throws Exception {
        validarResiduos(elemento);
        this.residuosDAO.eliminarResiduo(elemento);

    }

    @Override
    public Residuos actualizarResiduo(Residuos elemento) throws Exception {
        validarResiduos(elemento);
        return this.residuosDAO.actualizarResiduo(elemento);

    }

    @Override
    public List<Residuos> consultarResiduosPorProductor(Productores productor) throws Exception {

        return this.residuosDAO.consultarResiduosPorProductor(productor);

    }

    @Override
    public List<Residuos> consultarResiduos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void validarResiduos(Residuos residuos) throws IllegalArgumentException {
        if (residuos == null) {
            throw new IllegalArgumentException("El objeto Residuos proporcionado es nulo");
        }

        if (residuos.getNombre() == null || residuos.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El campo 'nombre' de Residuos es nulo o está vacío");
        }

        if (residuos.getCodigo() == null || residuos.getCodigo().isEmpty()) {
            throw new IllegalArgumentException("El campo 'codigo' de Residuos es nulo o está vacío");
        }

        if (residuos.getQuimico() == null || residuos.getQuimico().isEmpty()) {
            throw new IllegalArgumentException("El campo 'quimico' de Residuos es nulo o está vacío");
        }
    }

}
