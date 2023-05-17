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

public class EmpresaTransportistaDAO implements IEmpresaTransportista {

    MongoDatabase baseDatos = ConnectionDataBase.getBaseDatos();
    DatabaseFormats databaseFormats = new DatabaseFormats();

    MongoCollection<EmpresaTransportista> empresaCollection = baseDatos.getCollection(databaseFormats.getEMPRESA_TRANSPORTISTA_COLLECTION(), EmpresaTransportista.class);

    public void insertarEmpresaConAutos(EmpresaTransportista nombreEmpresa) {

        // Crear el documento de la empresa

        // Insertar el documento de la empresa en la colección
        VehiculoDAO v = new VehiculoDAO();
        v.insertarElementoEnLista(nombreEmpresa.getVehiculos());
        empresaCollection.insertOne(nombreEmpresa);

        System.out.println("La empresa y los vehículos han sido insertados correctamente.");

    }

    public void agregarVehiculosAEmpresa(ObjectId empresaId, List<Vehiculo> nuevosVehiculos) {
//        
//        // Consultar la empresa por su ObjectId
//        Document empresaQuery = new Document("_id", empresaId);
//        EmpresaTransportista empresaDocument = empresaCollection.find(empresaQuery).first();
//
//        if (empresaDocument != null) {
//            // Obtener la lista actual de vehículos de la empresa
//            List<Document> vehiculosDocuments = (List<Document>) empresaDocument.get("vehiculos");
//            List<Vehiculo> vehiculosActuales = new ArrayList<>();
//
//            for (Document vehiculoDocument : vehiculosDocuments) {
//                String marca = vehiculoDocument.getString("marca");
//                String modelo = vehiculoDocument.getString("modelo");
//                int año = 2222;
//
//                Vehiculo vehiculo = new Vehiculo(marca, modelo, año);
//                vehiculosActuales.add(vehiculo);
//            }
//
//            // Agregar los nuevos vehículos a la lista actual
//            vehiculosActuales.addAll(nuevosVehiculos);
//
//            // Actualizar la lista de vehículos en el documento de la empresa
//            List<Document> nuevosVehiculosDocuments = new ArrayList<>();
//            for (Vehiculo vehiculo : vehiculosActuales) {
//                Document vehiculoDocument = new Document("marca", vehiculo.getMarca())
//                        .append("modelo", vehiculo.getModelo())
//                        .append("año", vehiculo.getAño());
//                nuevosVehiculosDocuments.add(vehiculoDocument);
//            }
//
//            empresaDocument.put("vehiculos", nuevosVehiculosDocuments);
//
//            // Actualizar el documento de la empresa en la colección
//            empresaCollection.replaceOne(empresaQuery, empresaDocument);
//
//            System.out.println("Los nuevos vehículos han sido agregados a la empresa correctamente.");
//        } else {
//            System.out.println("No se encontró la empresa con el ObjectId especificado.");
//        }

    }

    @Override
    public EmpresaTransportista insertarElemento(EmpresaTransportista e) {
        Document empresaDocument = new Document("nombre", e.getNombre());

        List<Document> vehiculosDocuments = new ArrayList<>();
        for (Vehiculo vehiculo : e.getVehiculos()) {
            Document vehiculoDocument = new Document("marca", vehiculo.getMarca())
                    .append("modelo", vehiculo.getModelo())
                    .append("año", vehiculo.getAño());
            vehiculosDocuments.add(vehiculoDocument);
        }

        empresaDocument.append("vehiculos", vehiculosDocuments);

        empresaCollection.insertOne(e);

        if (e.getId() != null) {
            System.out.println("retorno id");
        } else {
            System.out.println("no lo retorno");
        }

        System.out.println("La empresa y los vehículos han sido insertados correctamente.");
        return e;
    }

    @Override
    public EmpresaTransportista consultarElemento(EmpresaTransportista elemento) {
        MongoCollection<Document> empresaCollection = baseDatos.getCollection(databaseFormats.getEMPRESA_TRANSPORTISTA_COLLECTION());

        Document empresaQuery = new Document("_id", elemento.getId());
        Document empresaDocument = empresaCollection.find(empresaQuery).first();

        if (empresaDocument != null) {
            String nombreEmpresa = empresaDocument.getString("nombre");
            List<Document> vehiculosDocuments = (List<Document>) empresaDocument.get("vehiculos");
            List<Vehiculo> vehiculos = new ArrayList<>();

            for (Document vehiculoDocument : vehiculosDocuments) {
                String marca = vehiculoDocument.getString("marca");
                String modelo = vehiculoDocument.getString("modelo");
                int año = vehiculoDocument.getInteger("año");

                Vehiculo vehiculo = new Vehiculo(marca, modelo, año);
                vehiculos.add(vehiculo);
            }

            EmpresaTransportista empresa = new EmpresaTransportista(nombreEmpresa, vehiculos);
            empresa.setId(elemento.getId());
            return empresa;
        } else {
            return null;
        }
    }

    @Override
    public EmpresaTransportista eliminarElemento(EmpresaTransportista elemento) {
        MongoCollection<Document> empresaCollection = baseDatos.getCollection(databaseFormats.getEMPRESA_TRANSPORTISTA_COLLECTION());

        Document empresaQuery = new Document("_id", elemento.getId());
        Document empresaDocument = empresaCollection.findOneAndDelete(empresaQuery);

        if (empresaDocument != null) {
            String nombreEmpresa = empresaDocument.getString("nombre");
            List<Document> vehiculosDocuments = (List<Document>) empresaDocument.get("vehiculos");
            List<Vehiculo> vehiculos = new ArrayList<>();

            for (Document vehiculoDocument : vehiculosDocuments) {
                String marca = vehiculoDocument.getString("marca");
                String modelo = vehiculoDocument.getString("modelo");
                int año = vehiculoDocument.getInteger("año");

                Vehiculo vehiculo = new Vehiculo(marca, modelo, año);
                vehiculos.add(vehiculo);
            }

            EmpresaTransportista empresa = new EmpresaTransportista(nombreEmpresa, vehiculos);
            empresa.setId(elemento.getId());
            return empresa;
        } else {
            return null;
        }
    }

    @Override
    public EmpresaTransportista actualizarElemento(EmpresaTransportista elemento) {
        MongoCollection<Document> empresaCollection = baseDatos.getCollection(databaseFormats.getEMPRESA_TRANSPORTISTA_COLLECTION());

        Document empresaQuery = new Document("_id", elemento.getId());
        Document empresaDocument = empresaCollection.find(empresaQuery).first();

        if (empresaDocument != null) {
            // Actualizar los datos de la empresa en el documento
            empresaDocument.put("nombre", elemento.getNombre());

            // Crear una lista de documentos para los vehículos
            List<Document> vehiculosDocuments = new ArrayList<>();
            for (Vehiculo vehiculo : elemento.getVehiculos()) {
                Document vehiculoDocument = new Document("marca", vehiculo.getMarca())
                        .append("modelo", vehiculo.getModelo())
                        .append("año", vehiculo.getAño());
                vehiculosDocuments.add(vehiculoDocument);
            }
            empresaDocument.put("vehiculos", vehiculosDocuments);

            // Actualizar el documento de la empresa en la colección
            empresaCollection.replaceOne(empresaQuery, empresaDocument);

            return elemento;
        } else {
            return null;
        }
    }

}
