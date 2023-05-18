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

    public void validarTraslado(Traslado traslado) throws Exception {

        if (traslado.getProductorId() == null) {
            throw new Exception("El campo 'productorId' del objeto Traslado es nulo.");
        }

        if (traslado.getFecha() == null) {
            throw new Exception("El campo 'fecha' del objeto Traslado es nulo.");
        }

        if (traslado.getResiduos() == null || traslado.getResiduos().isEmpty()) {
            throw new Exception("El campo 'residuos' del objeto Traslado es nulo o está vacío.");
        }

        if (traslado.getEmpresaTransportista() == null || traslado.getEmpresaTransportista().isEmpty()) {
            throw new Exception("El campo 'EmpresaTransportista' del objeto Traslado es nulo o está vacío.");
        } else {
            for (EmpresaTransportista transportista : traslado.getEmpresaTransportista()) {
                validarEmpresaTransportista(transportista);
            }
        }
    }

    private void validarEmpresaTransportista(EmpresaTransportista transportista) throws Exception {
        if (transportista == null) {
            throw new Exception("Se encontró una empresa transportista nula en la lista de empresas transportistas.");
        }

        // Validar los atributos de la empresa transportista si es necesario
    }

}
