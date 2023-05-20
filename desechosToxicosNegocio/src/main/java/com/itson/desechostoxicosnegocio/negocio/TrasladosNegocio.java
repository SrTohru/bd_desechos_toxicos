/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.desechostoxicosnegocio.negocio;

import com.itson.desechostoxicosnegocio.interfaces.ITraslados;
import com.itson.desechostoxicospersistencia.dao.TrasladoDAO;
import com.itson.desechostoxicospersistencia.utilities.ConfiguracionDePaginado;
import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.RegistroTraslado;
import com.itson.dominio.Residuos;
import com.itson.dominio.Traslado;
import java.util.ArrayList;
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
        validarTraslado(traslado);
        return this.trasladoDAO.insertarTraslado(traslado);

    }

    @Override
    public Traslado actualizarElemento(Traslado elemento) throws Exception {
        validarTraslado(elemento);
        return this.trasladoDAO.actualizarTraslado(elemento);

    }

    @Override
    public Traslado consultarElemento(Traslado elemento) throws Exception {
        validarTraslado(elemento);
        return this.trasladoDAO.consultarTraslado(elemento);

    }

    @Override
    public List<Traslado> consultarTraslados() throws Exception {
        try {
            return this.trasladoDAO.consultarTraslados();
        } catch (Exception e) {
            throw new Exception("Hubo un error al consultar todos los traslados");
        }
    }

    public void validarTraslado(Traslado traslado) throws Exception {

        if (traslado.getFecha() == null) {
            throw new Exception("El campo 'fecha' del objeto Traslado es nulo.");
        }

        if (traslado.getResiduos() == null || traslado.getResiduos().isEmpty()) {
            throw new Exception("El campo 'residuos' del objeto Traslado es nulo o está vacío.");
        }
    }

}
