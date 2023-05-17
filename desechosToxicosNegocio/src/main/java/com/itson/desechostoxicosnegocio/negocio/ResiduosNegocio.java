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
public List<Residuos> consultarElementos(ConfiguracionDePaginado configuracionDePaginado) throws Exception {
  
        return this.residuosDAO.consultarElemento(configuracionDePaginado);

}

    @Override
    public Residuos insertarElemento(Residuos residuos) throws Exception {
  
            return this.residuosDAO.insertarElemento(residuos);
     
    }

    @Override
    public void eliminarElemento(Residuos elemento) throws Exception {
   
            this.residuosDAO.eliminarElemento(elemento);
     
    }

    @Override
    public Residuos actualizarElemento(Residuos elemento) throws Exception {
 
            return this.residuosDAO.actualizarElemento(elemento);
       
    }

    @Override
    public List<Residuos> consultarElementosPorProductor(Productores productor) throws Exception {
     
            return this.residuosDAO.consultarElementosPorProductor(productor);
     
    }

    @Override
    public List<Residuos> consultarElementos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
