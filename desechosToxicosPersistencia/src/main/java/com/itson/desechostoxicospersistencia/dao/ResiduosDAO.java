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
import static java.lang.Integer.parseInt;
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

    MongoCollection<Residuos> residuosCollection = baseDatos.getCollection(databaseFormats.getRESIDUOS(), Residuos.class);

    @Override
    public Residuos insertarResiduo(Residuos residuos) throws Exception {

        residuosCollection.insertOne(residuos);

        return residuos;
    }

    @Override
    public List<Residuos> consultarResiduo(ConfiguracionDePaginado configuracionDePaginado) throws Exception {

        List<Residuos> listaResiduos = new ArrayList<>();
        int offset = configuracionDePaginado.getElementoASaltar();
        int limit = configuracionDePaginado.getElementosPorPagina();
        // Consultar todos los documentos en la colección
        FindIterable<Residuos> documents = residuosCollection.find().skip(offset).limit(limit);

        // Iterar sobre los documentos y convertirlos a objetos Quimicos
        try (MongoCursor<Residuos> cursor = documents.iterator()) {
            while (cursor.hasNext()) {
                Residuos document = cursor.next();

                listaResiduos.add(document);

            }
        }

        return listaResiduos;
    }

    @Override
    public Residuos eliminarResiduo(Residuos elemento) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Residuos actualizarResiduo(Residuos elemento) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Residuos> consultarResiduosPorProductor(Productores productor) throws Exception {

        // Obtener la colección "productores"
        MongoCollection<Document> productoresCollection = baseDatos.getCollection("Productores");

        // ID del productor para buscar sus residuos
        ObjectId id = productor.getId();

        // Crear el objeto de consulta con el criterio de búsqueda
        Document query = new Document("id_residuos", id);

        // Realizar la consulta
        FindIterable<Document> result = productoresCollection.find(query);

        // Recorrer los resultados
        for (Document document : result) {
            System.out.println(document);
        }
        return null;
    }
}
