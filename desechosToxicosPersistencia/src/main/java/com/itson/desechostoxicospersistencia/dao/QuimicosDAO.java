package com.itson.desechostoxicospersistencia.dao;

import com.itson.desechostoxicospersistencia.database.ConnectionDataBase;
import com.itson.desechostoxicospersistencia.interfaces.IQuimicos;
import com.itson.desechostoxicospersistencia.utilities.ConfiguracionDePaginado;
import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.Quimicos;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.types.ObjectId;

public class QuimicosDAO implements IQuimicos {

    MongoDatabase baseDatos = ConnectionDataBase.getBaseDatos();
    DatabaseFormats databaseFormats = new DatabaseFormats();

    MongoCollection<Document> empresaCollection = baseDatos.getCollection(databaseFormats.getQUIMICOS());

    @Override
    public List<Quimicos> consultarQuimicosGenerales(ConfiguracionDePaginado configuracionDePaginado) {

        List<Quimicos> quimicosList = new ArrayList<>();
        int offset = configuracionDePaginado.getElementoASaltar();
        int limit = configuracionDePaginado.getElementosPorPagina();
        // Consultar todos los documentos en la colección
        FindIterable<Document> documents = empresaCollection.find().skip(offset).limit(limit);

        // Iterar sobre los documentos y convertirlos a objetos Quimicos
        try (MongoCursor<Document> cursor = documents.iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                ObjectId id = document.getObjectId("_id");
                String nombre = document.getString("nombre");
                Quimicos quimico = new Quimicos(id, nombre);
                quimicosList.add(quimico);
                System.out.println(quimico);
            }
        }

        return quimicosList;

    }

    @Override
    public Quimicos insertarQuimicos(Quimicos quimicos) {

        // Crear el documento de la empresa
        try {
            Document empresaDocument = new Document("nombre", quimicos.getNombre());
            
            empresaCollection.insertOne(empresaDocument);

            System.out.println("El quimico se ingreso correctamente");
            return quimicos;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al inserar el quimico");
            return null;
        }

    }

}
