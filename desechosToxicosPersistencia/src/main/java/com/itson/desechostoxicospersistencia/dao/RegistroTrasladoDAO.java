/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.desechostoxicospersistencia.dao;


import com.itson.desechostoxicospersistencia.database.ConnectionDataBase;
import com.itson.desechostoxicospersistencia.interfaces.IRegistroTraslado;
import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.RegistroTraslado;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.bson.Document;


/**
 *
 * @author PC
 */
public class RegistroTrasladoDAO implements IRegistroTraslado{
    
    DatabaseFormats dFormats;
      MongoDatabase baseDatos = ConnectionDataBase.getBaseDatos();
    MongoCollection<RegistroTraslado> registroTrasladoCollection = baseDatos.getCollection(dFormats.getREGISTRO_TRASLADO(), RegistroTraslado.class);

    
    
    @Override
    public RegistroTraslado insertarTraslado(RegistroTraslado e) {
        try {
            registroTrasladoCollection.insertOne(e);

            JOptionPane.showMessageDialog(null, "El traslado ha sido insertado correctamente.");

            return e;
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar el traslado");
            return null;
        }
    }

    @Override
    public RegistroTraslado consultarTraslado(RegistroTraslado elemento) {
        try {
            Document trasladoQuery = new Document("_id", elemento.getId());
            RegistroTraslado trasladoDocument = registroTrasladoCollection.find(trasladoQuery).first();

            return trasladoDocument;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al consultar el traslado");
            return null;
        }
    }

    @Override
    public void eliminarTraslado(RegistroTraslado elemento) {
        try {
            registroTrasladoCollection.findOneAndDelete(new Document("_id", elemento.getId()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al eliminar el traslado");
        }
    }

    @Override
    public RegistroTraslado actualizarTraslado(RegistroTraslado elemento) {
        try {
            Document trasladoQuery = new Document("_id", elemento.getId());
            RegistroTraslado trasladoDocument = registroTrasladoCollection.find(trasladoQuery).first();

            trasladoDocument.setTaslado(elemento.getTaslado());
            trasladoDocument.setVehiculo(elemento.getVehiculo());
            trasladoDocument.setKilometrosRecorridos(elemento.getKilometrosRecorridos());
            trasladoDocument.setCosto(elemento.getCosto());
            trasladoDocument.setFechaLlegada(elemento.getFechaLlegada());
            trasladoDocument.setTratamiento(elemento.getTratamiento());

            registroTrasladoCollection.replaceOne(trasladoQuery, trasladoDocument);

            return trasladoDocument;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al actualizar el traslado");
            return null;
        }
    }

    @Override
    public List<RegistroTraslado> consultarTodosLosTrasladosExistentes() {
        try {
            return registroTrasladoCollection.find().into(new ArrayList<>());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al consultar todos los traslados existentes");
            return null;
        }
    }

    
}
