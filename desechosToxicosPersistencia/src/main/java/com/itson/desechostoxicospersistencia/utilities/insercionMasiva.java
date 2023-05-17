package com.itson.desechostoxicospersistencia.utilities;

import com.itson.desechostoxicospersistencia.dao.EmpresaTransportistaDAO;
import com.itson.desechostoxicospersistencia.dao.VehiculoDAO;
import com.itson.desechostoxicospersistencia.database.ConnectionDataBase;
import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.Vehiculo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.LinkedList;
import java.util.List;

public class insercionMasiva {

    MongoDatabase baseDatos = ConnectionDataBase.getBaseDatos();
    DatabaseFormats databaseFormats = new DatabaseFormats();

    EmpresaTransportistaDAO eDAO = new EmpresaTransportistaDAO();
    MongoCollection<EmpresaTransportista> empresaCollection = baseDatos.getCollection(databaseFormats.getEMPRESA_TRANSPORTISTA_COLLECTION(), EmpresaTransportista.class);

    public void insercionMasivaDeVehiculosYEmpresas() {

        MongoCollection<EmpresaTransportista> empresasTransportistasCollection = empresaCollection;

        for (int i = 0; i < 20; i++) {
            List<Vehiculo> stringList = new LinkedList<>();
            Vehiculo v = new Vehiculo("Marca " + i, "Modelo " + i, 2000 + i);
            Vehiculo v2 = new Vehiculo("SMarca " + i, "SModelo " + i, 3000 + i);

            stringList.add(v);
            stringList.add(v2);

            EmpresaTransportista empresaTransportista = new EmpresaTransportista("Empresa " + (i + 1), stringList);
            
            eDAO.actualizarEmpresa(empresaTransportista);
            

        }

    }
}
