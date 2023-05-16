/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.itson.desechostoxicospersistencia;

import com.itson.desechostoxicospersistencia.dao.EmpresaTransportistaDAO;
import com.itson.dominio.EmpresaTransportista;
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
        stringList.add(new Vehiculo("test asd", "test asd", 2222));
     stringList.add(new Vehiculo("tes2t3 asd", "test asd", 20202));
     stringList.add(new Vehiculo("test2 asd", "test asd", 20022));
     stringList.add(new Vehiculo("test3 4", "test asd", 20022));
        EmpresaTransportistaDAO emps = new EmpresaTransportistaDAO();
        EmpresaTransportista em = new EmpresaTransportista("Be Dickx2", stringList);
        emps.insertarEmpresaConAutos(em);
        
       
    }
}
