/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.desechostoxicospersistencia.dao;

import com.itson.desechostoxicospersistencia.database.ConnectionDataBase;
import com.itson.desechostoxicospersistencia.interfaces.IEmpresaTransportista;
import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.Vehiculo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author PC
 */
public class EmpresaTransportistaDAO implements IEmpresaTransportista{

    MongoDatabase baseDatos = ConnectionDataBase.getBaseDatos();
    DatabaseFormats databaseFormats = new DatabaseFormats();

    public void insertarEmpresaConAutos(EmpresaTransportista nombreEmpresa) {
    
        MongoCollection<Document> empresaCollection = baseDatos.getCollection(databaseFormats.getEMPRESA_TRANSPORTISTA_COLLECTION());

        // Crear el documento de la empresa
        Document empresaDocument = new Document("nombre", nombreEmpresa.getNombre());

        // Crear una lista de documentos para los vehículos
        List<Document> vehiculosDocuments = new ArrayList<>();
        for (Vehiculo vehiculo : nombreEmpresa.getVehiculos()) {
            Document vehiculoDocument = new Document("marca", vehiculo.getMarca())
                    .append("modelo", vehiculo.getModelo())
                    .append("año", vehiculo.getAño());
            vehiculosDocuments.add(vehiculoDocument);
        }

        empresaDocument.append("vehiculos", vehiculosDocuments);

        // Insertar el documento de la empresa en la colección
        empresaCollection.insertOne(empresaDocument);

        System.out.println("La empresa y los vehículos han sido insertados correctamente.");
    
}

    public void agregarVehiculosAEmpresa(ObjectId empresaId, List<Vehiculo> nuevosVehiculos) {
            MongoCollection<Document> empresaCollection = baseDatos.getCollection(databaseFormats.getEMPRESA_TRANSPORTISTA_COLLECTION());

        // Consultar la empresa por su ObjectId
        Document empresaQuery = new Document("_id", empresaId);
        Document empresaDocument = empresaCollection.find(empresaQuery).first();

        if (empresaDocument != null) {
            // Obtener la lista actual de vehículos de la empresa
            List<Document> vehiculosDocuments = (List<Document>) empresaDocument.get("vehiculos");
            List<Vehiculo> vehiculosActuales = new ArrayList<>();

            for (Document vehiculoDocument : vehiculosDocuments) {
                String marca = vehiculoDocument.getString("marca");
                String modelo = vehiculoDocument.getString("modelo");
                int año = 2222;

                Vehiculo vehiculo = new Vehiculo(marca, modelo, año);
                vehiculosActuales.add(vehiculo);
            }

            // Agregar los nuevos vehículos a la lista actual
            vehiculosActuales.addAll(nuevosVehiculos);

            // Actualizar la lista de vehículos en el documento de la empresa
            List<Document> nuevosVehiculosDocuments = new ArrayList<>();
            for (Vehiculo vehiculo : vehiculosActuales) {
                Document vehiculoDocument = new Document("marca", vehiculo.getMarca())
                        .append("modelo", vehiculo.getModelo())
                        .append("año", vehiculo.getAño());
                nuevosVehiculosDocuments.add(vehiculoDocument);
            }

            empresaDocument.put("vehiculos", nuevosVehiculosDocuments);

            // Actualizar el documento de la empresa en la colección
            empresaCollection.replaceOne(empresaQuery, empresaDocument);

            System.out.println("Los nuevos vehículos han sido agregados a la empresa correctamente.");
        } else {
            System.out.println("No se encontró la empresa con el ObjectId especificado.");
        }
    
}

    @Override
    public EmpresaTransportista insertarElemento(EmpresaTransportista e) {
    
        MongoCollection<Document> empresaCollection = baseDatos.getCollection(databaseFormats.getEMPRESA_TRANSPORTISTA_COLLECTION());

        // Crear el documento de la empresa
        Document empresaDocument = new Document("nombre", e.getNombre());

        // Crear una lista de documentos para los vehículos
        List<Document> vehiculosDocuments = new ArrayList<>();
        for (Vehiculo vehiculo : e.getVehiculos()) {
            Document vehiculoDocument = new Document("marca", vehiculo.getMarca())
                    .append("modelo", vehiculo.getModelo())
                    .append("año", vehiculo.getAño());
            vehiculosDocuments.add(vehiculoDocument);
        }

        empresaDocument.append("vehiculos", vehiculosDocuments);

        // Insertar el documento de la empresa en la colección
        empresaCollection.insertOne(empresaDocument);

            e.setId(empresaDocument.getObjectId("_id"));
        if(e.getId() != null){
            System.out.println("retorno id");
        }else{
            System.out.println("no lo retorno");
        }
        
        System.out.println("La empresa y los vehículos han sido insertados correctamente.");
    return e;
    }

    @Override
    public EmpresaTransportista consultarElemento(EmpresaTransportista elemento, DatabaseFormats collectionName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EmpresaTransportista eliminarElemento(EmpresaTransportista elemento, DatabaseFormats collectionName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public EmpresaTransportista actualizarElemento(EmpresaTransportista elemento, DatabaseFormats collectionName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
