/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.itson.presentacion;

import com.itson.desechostoxicospersistencia.dao.ResiduosDAO;
import com.itson.dominio.Residuos;

/**
 *
 * @author PC
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Residuos q1 = new Residuos();
        q1.setNombre("test");
        Residuos q2 = new Residuos();
        q2.setNombre("test");
        Residuos q3 = new Residuos();
        q3.setNombre("test");
        
        ResiduosDAO residuosDAO = new ResiduosDAO();
        
      residuosDAO.insertarElemento(q3);
      residuosDAO.insertarElemento(q2);
      residuosDAO.insertarElemento(q1);
    }
    
}
