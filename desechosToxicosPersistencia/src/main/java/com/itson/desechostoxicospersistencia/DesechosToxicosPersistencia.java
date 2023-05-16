/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.itson.desechostoxicospersistencia;

import com.itson.desechostoxicospersistencia.dao.EmpresaTransportistaDAO;
import com.itson.desechostoxicospersistencia.dao.QuimicosDAO;
import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.Quimicos;
import com.itson.dominio.Vehiculo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bson.types.ObjectId;

public class DesechosToxicosPersistencia {

    public static void main(String[] args) {
    
    //Aqui van las dao CRUD
    
    
    //Registrar residuo
    //Solicitar traslado de residuos
    //Registrar traslado
    //El administrador asignar traslados a empresas
        System.out.println("Hello World!");
        
        List<Vehiculo> stringList  = new LinkedList<>(); // Using Diamond operator from Java 1.7
        Quimicos q1 = new Quimicos("test");
        Quimicos q2 = new Quimicos("test2");
        Quimicos q3 = new Quimicos("test3");
        QuimicosDAO emps = new QuimicosDAO();
        
      emps.insertarQuimicos(q3);
      emps.insertarQuimicos(q2);
      emps.insertarQuimicos(q1);
        
//      emps.consultarQuimicosGenerales();
       
    }
}
