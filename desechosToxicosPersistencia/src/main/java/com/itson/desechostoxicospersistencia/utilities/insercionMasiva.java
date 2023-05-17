package com.itson.desechostoxicospersistencia.utilities;

import com.itson.desechostoxicospersistencia.dao.CuentaDAO;
import com.itson.desechostoxicospersistencia.dao.EmpresaTransportistaDAO;
import com.itson.desechostoxicospersistencia.dao.ProductoresDAO;
import com.itson.desechostoxicospersistencia.dao.QuimicosDAO;
import com.itson.desechostoxicospersistencia.dao.VehiculoDAO;
import com.itson.desechostoxicospersistencia.database.ConnectionDataBase;
import com.itson.dominio.Cuenta;
import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.Productores;
import com.itson.dominio.Quimicos;
import com.itson.dominio.Residuos;
import com.itson.dominio.Vehiculo;
import com.itson.dominio.utilities.tiposDeCuenta;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.LinkedList;
import java.util.List;

public class insercionMasiva {

//Quimicos
    //Productores
    //Adminisitradores
    MongoDatabase baseDatos = ConnectionDataBase.getBaseDatos();
    DatabaseFormats databaseFormats = new DatabaseFormats();

    EmpresaTransportistaDAO eDAO = new EmpresaTransportistaDAO();
    QuimicosDAO qDAO = new QuimicosDAO();
    ProductoresDAO pDAO = new ProductoresDAO();
    CuentaDAO cDAO = new CuentaDAO();
    public void insercionMasivaDeVehiculosYEmpresas() throws Exception {

        for (int i = 1; i < 20; i++) {
            List<Vehiculo> stringList = new LinkedList<>();
            Vehiculo v = new Vehiculo("Marca " + i, "Modelo " + i, 2000 + i);
            Vehiculo v2 = new Vehiculo("SMarca " + i, "SModelo " + i, 3000 + i);

            stringList.add(v);
            stringList.add(v2);

            EmpresaTransportista empresaTransportista = new EmpresaTransportista("Empresa " + (i + 1), stringList);

            eDAO.insertarEmpresaConAutos(empresaTransportista);

        }

    }

    public void insercionMasivaDeQuimicos() throws Exception {
        for (int i = 0; i < 5; i++) {
            Quimicos quimico = new Quimicos("Quimico " + i);

            qDAO.insertarQuimico(quimico);
        }
    }

    public void insercionMasivaProductores() throws Exception {
        for (int i = 0; i < 5; i++) {
            boolean test;
            if (i % 2 == 0) {
                test = true;
            } else {
                test = false;
            }
            Cuenta cuenta = new Cuenta("Administrador" + i, "Administrador" + i, tiposDeCuenta.Administrador.toString());
            
            cDAO.insertarCuenta(cuenta);
            
            List<Residuos> stringList = new LinkedList<>();
            
            Residuos residuo1 = new Residuos("Residuo" + i, "3" + i + "2" + i + "9" + i, test, qDAO.consultarQuimicosGenerales(null).get(i));
            Residuos residuo2 = new Residuos("Residuo" + i, "1" + i + "3" + i + "4" + i, test, qDAO.consultarQuimicosGenerales(null).get(i));
            
            stringList.add(residuo1);
            stringList.add(residuo2);
            
            Productores p = new Productores("Productor " + i,  stringList, cuenta);
        
            pDAO.insertarProductor(p);
        }
    }

}
