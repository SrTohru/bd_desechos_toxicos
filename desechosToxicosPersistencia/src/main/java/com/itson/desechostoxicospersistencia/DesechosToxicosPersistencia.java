/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.itson.desechostoxicospersistencia;

import com.itson.desechostoxicospersistencia.dao.EmpresaTransportistaDAO;
import com.itson.desechostoxicospersistencia.utilities.insercionMasiva;
import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.Vehiculo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bson.types.ObjectId;

public class DesechosToxicosPersistencia {

    public static void main(String[] args) throws Exception {
    
        insercionMasiva in = new insercionMasiva();
        
//        in.insercioResiduos();
//        in.insercionMasivaProductores();
        in.insercioResiduos();
        in.insercionMasivaProductores();
        
    }
}
