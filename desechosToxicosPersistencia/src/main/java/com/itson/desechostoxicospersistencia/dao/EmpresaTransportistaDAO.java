/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.desechostoxicospersistencia.dao;

import com.itson.desechostoxicospersistencia.database.ConnectionDataBase;
import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.Vehiculo;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author PC
 */
public class EmpresaTransportistaDAO {

      MongoDatabase baseDatos = ConnectionDataBase.getBaseDatos();
    DatabaseFormats databaseFormats;
    public void actualizarEmpresaTransportista(ObjectId id, String nuevoNombre, List<Vehiculo> nuevosVehiculos) {
        Document filter = new Document("_id", id);
        Document update = new Document("$set", new Document("nombre", nuevoNombre).append("vehiculos", nuevosVehiculosToDocuments(nuevosVehiculos)));
        baseDatos.getCollection(databaseFormats.getEMPRESA_TRANSPORTISTA_COLLECTION()).updateOne(filter, update);
    }

    public void eliminarEmpresaTransportista(ObjectId id) {
        Document filter = new Document("_id", id);
         baseDatos.getCollection(databaseFormats.getEMPRESA_TRANSPORTISTA_COLLECTION()).deleteOne(filter);
    }

    public EmpresaTransportista consultarEmpresaTransportista(ObjectId id) {
        Document filter = new Document("_id", id);
        Document result =  baseDatos.getCollection(databaseFormats.getEMPRESA_TRANSPORTISTA_COLLECTION()).find(filter).first();
        if (result != null) {
            return documentToEmpresaTransportista(result);
        }
        return null;
    }

    public void agregarEmpresaTransportista(String nombre, List<Vehiculo> vehiculos) {
        Document document = new Document("nombre", nombre).append("vehiculos", vehiculosToDocuments(vehiculos));
         baseDatos.getCollection(databaseFormats.getEMPRESA_TRANSPORTISTA_COLLECTION()).insertOne(document);
    }

    private List<Document> vehiculosToDocuments(List<Vehiculo> vehiculos) {
        List<Document> documents = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculos) {
            documents.add(new Document("id_", vehiculo.getId()));
    
        }
        return documents;
    }

    private List<Vehiculo> documentsToVehiculos(List<Document> documents) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        for (Document document : documents) {
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setId(new ObjectId(document.getString("id_")));
       
            vehiculos.add(vehiculo);
        }
        return vehiculos;
    }

    private Document vehiculosToDocumentss(List<Vehiculo> vehiculos) {
        Document document = new Document();
        List<Document> vehiculosDocuments = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculos) {
            vehiculosDocuments.add(new Document("atributoVehiculo", vehiculo.getId()));
          
        }
        document.append("$each", vehiculosDocuments);
        return document;
    }

    private EmpresaTransportista documentToEmpresaTransportista(Document document) {
        EmpresaTransportista empresaTransportista = new EmpresaTransportista();
        empresaTransportista.setId(document.getObjectId("_id"));
        empresaTransportista.setNombre(document.getString("nombre"));
           List<Document> vehiculosDocuments = (List<Document>) document.get("vehiculos");
        empresaTransportista.setVehiculos(documentsToVehiculos(vehiculosDocuments));

        return empresaTransportista;
    }

    private List<Document> nuevosVehiculosToDocuments(List<Vehiculo> nuevosVehiculos) {
        List<Document> documents = new ArrayList<>();
        for (Vehiculo vehiculo : nuevosVehiculos) {
            documents.add(new Document("atributoVehiculo", vehiculo.getId()));
           
        }
        return documents;
    }
}
