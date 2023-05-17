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

    DatabaseFormats databaseFormats = new DatabaseFormats();
    MongoDatabase baseDatos = ConnectionDataBase.getBaseDatos();
    MongoCollection<Quimicos> quimicosCollection = baseDatos.getCollection(databaseFormats.getQUIMICOS(), Quimicos.class);

    @Override
    public List<Quimicos> consultarQuimicosGenerales(ConfiguracionDePaginado configuracionDePaginado) throws Exception{
        try {
            return quimicosCollection.find().into(new ArrayList<>());
        } catch (Exception e) {
           throw new Exception("Hubo un error al consultar todos los quimicos");
        }
    }

    @Override
    public Quimicos consultarQuimico(Quimicos quimico) throws Exception{
        try {
            Document quimicoQuery = new Document("_id", quimico.getId());
            Quimicos quimicoDocument = quimicosCollection.find(quimicoQuery).first();

            return quimicoDocument;
        } catch (Exception e) {
          throw new Exception("Hubo un error al consultar al quimico");
        }
    }

    @Override
    public Quimicos insertarQuimico(Quimicos quimico) throws Exception{
        try {
            quimicosCollection.insertOne(quimico);

            return quimico;
        } catch (Exception e) {
         throw new Exception("Hubo un error al insertar el quimico");
        }
    }

    @Override
    public void eliminarQuimico(Quimicos elemento) throws Exception{
        try {
            quimicosCollection.findOneAndDelete(new Document("_id", elemento.getId()));
        } catch (Exception e) {
           throw new Exception("Hubo un error al eliminar el quimico");
        }
    }

}
