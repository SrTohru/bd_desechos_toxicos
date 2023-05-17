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
    
    DatabaseFormats dFormats = new DatabaseFormats();
      MongoDatabase baseDatos = ConnectionDataBase.getBaseDatos();
    MongoCollection<RegistroTraslado> registroTrasladoCollection = baseDatos.getCollection(dFormats.getREGISTRO_TRASLADO(), RegistroTraslado.class);

    
    
    @Override
    public RegistroTraslado insertarTraslado(RegistroTraslado e) throws Exception{
        try {
            registroTrasladoCollection.insertOne(e);

            JOptionPane.showMessageDialog(null, "El traslado ha sido insertado correctamente.");

            return e;
        } catch (HeadlessException ex) {
            throw new Exception("Hubo un error al insertar un traslado");
        }
    }

    @Override
    public RegistroTraslado consultarTraslado(RegistroTraslado elemento) throws Exception{
        try {
            Document trasladoQuery = new Document("_id", elemento.getId());
            RegistroTraslado trasladoDocument = registroTrasladoCollection.find(trasladoQuery).first();

            return trasladoDocument;
        } catch (Exception e) {
           throw new Exception("Hubo un error al consultar el traslado");
        }
    }

    @Override
    public void eliminarTraslado(RegistroTraslado elemento) throws Exception{
        try {
            registroTrasladoCollection.findOneAndDelete(new Document("_id", elemento.getId()));
        } catch (Exception e) {
            throw new Exception("Hubo un error al eliminar el traslado");
        }
    }

    @Override
    public RegistroTraslado actualizarTraslado(RegistroTraslado elemento) throws Exception{
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
         throw new Exception("Hubo un error al actualizar el traslado");
        }
    }

    @Override
    public List<RegistroTraslado> consultarTodosLosTrasladosExistentes() throws Exception{
        try {
            return registroTrasladoCollection.find().into(new ArrayList<>());
        } catch (Exception e) {
         throw new Exception("Hubo un error al consultar todos los traslados");
        }
    }

    
}
