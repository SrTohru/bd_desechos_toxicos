/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.desechostoxicospersistencia.dao;

import com.itson.desechostoxicospersistencia.database.ConnectionDataBase;
import com.itson.desechostoxicospersistencia.interfaces.IResiduos;
import com.itson.desechostoxicospersistencia.utilities.ConfiguracionDePaginado;
import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.Productores;
import com.itson.dominio.Quimicos;
import com.itson.dominio.Residuos;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author PC
 */
public class ResiduosDAO implements IResiduos {

    MongoDatabase baseDatos = ConnectionDataBase.getBaseDatos();
    DatabaseFormats databaseFormats = new DatabaseFormats();

    MongoCollection<Document> residuosCollection = baseDatos.getCollection(databaseFormats.getRESIDUOS());

    @Override
    public Residuos insertarElemento(Residuos residuos) {
        // Crear el documento de la empresa
        Document empresaDocument = new Document("nombre", residuos.getNombre());

        // Insertar el documento de la empresa en la colección
        residuosCollection.insertOne(empresaDocument);

        return residuos;
    }

    @Override
    public List<Residuos> consultarElemento(ConfiguracionDePaginado configuracionDePaginado) {

        List<Residuos> listaResiduos = new ArrayList<>();
        int offset = configuracionDePaginado.getElementoASaltar();
        int limit = configuracionDePaginado.getElementosPorPagina();
        // Consultar todos los documentos en la colección
        FindIterable<Document> documents = residuosCollection.find().skip(offset).limit(limit);

        // Iterar sobre los documentos y convertirlos a objetos Quimicos
        try (MongoCursor<Document> cursor = documents.iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                ObjectId id = document.getObjectId("_id");
                String nombre = document.getString("nombre");
                Residuos residuo = new Residuos();
                residuo.setId(id);
                residuo.setNombre(nombre);
                listaResiduos.add(residuo);
                System.out.println(residuo);
            }
        }

        return listaResiduos;
    }

    @Override
    public Residuos eliminarElemento(Residuos elemento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Residuos actualizarElemento(Residuos elemento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Residuos> consultarElementosPorProductor(Productores productor) {

        Document query = new Document("productor.id", productor.getId());
        FindIterable<Document> result = residuosCollection.find(query);

        List<Residuos> residuosList = new ArrayList<>();

        try (MongoCursor<Document> cursor = result.iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                ObjectId residuoId = document.getObjectId("_id");
                String nombre = document.getString("nombre");
                boolean peligroso = document.getBoolean("peligroso");
                Document quimicoDocument = document.get("quimico", Document.class);
                
                
                Quimicos quimico = new Quimicos(new ObjectId(quimicoDocument.getString("id_")), quimicoDocument.getString("nombreQuimico"));

                Residuos residuo = new Residuos(residuoId, nombre, peligroso, quimico);
                residuosList.add(residuo);
            }
        }

        return residuosList;
    }
}
