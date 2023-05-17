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
    public List<Quimicos> consultarQuimicosGenerales(ConfiguracionDePaginado configuracionDePaginado) {
        try {
            return quimicosCollection.find().into(new ArrayList<>());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al consultar los químicos generales");
            return null;
        }
    }

    @Override
    public Quimicos consultarQuimico(Quimicos quimico) {
        try {
            Document quimicoQuery = new Document("_id", quimico.getId());
            Quimicos quimicoDocument = quimicosCollection.find(quimicoQuery).first();

            return quimicoDocument;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al consultar el químico");
            return null;
        }
    }

    @Override
    public Quimicos insertarQuimico(Quimicos quimico) {
        try {
            quimicosCollection.insertOne(quimico);

            JOptionPane.showMessageDialog(null, "El químico ha sido insertado correctamente.");

            return quimico;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar el químico");
            return null;
        }
    }

    @Override
    public void eliminarQuimico(Quimicos elemento) {
        try {
            quimicosCollection.findOneAndDelete(new Document("_id", elemento.getId()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al eliminar el químico");
        }
    }

}
