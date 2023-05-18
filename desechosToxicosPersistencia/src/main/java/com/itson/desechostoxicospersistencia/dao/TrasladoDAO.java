/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.desechostoxicospersistencia.dao;

import com.itson.desechostoxicospersistencia.database.ConnectionDataBase;
import com.itson.desechostoxicospersistencia.interfaces.ITraslado;
import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.Traslado;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author PC
 */
public class TrasladoDAO implements ITraslado {

    DatabaseFormats dFormats = new DatabaseFormats();
    MongoDatabase baseDatos = ConnectionDataBase.getBaseDatos();
    MongoCollection<Traslado> trasladoCollection = baseDatos.getCollection(dFormats.getTRASLADOS(), Traslado.class);

    @Override
    public Traslado insertarTraslado(Traslado e) throws Exception{
        try {
            trasladoCollection.insertOne(e);

            JOptionPane.showMessageDialog(null, "El traslado ha sido insertado correctamente.");

            return e;
        } catch (Exception ex) {
         throw new Exception("Hubo un error al insertar el traslado");
        }
    }

    @Override
    public Traslado consultarTraslado(Traslado elemento) throws Exception{
        try {
            Document trasladoQuery = new Document("_id", elemento.getId());
            Traslado trasladoDocument = trasladoCollection.find(trasladoQuery).first();

            return trasladoDocument;
        } catch (Exception e) {
           throw new Exception("Hubo un error al consultar el traslado");
        }
    }

    @Override
    public Traslado actualizarTraslado(Traslado elemento) throws Exception{
        try {
            Document trasladoQuery = new Document("_id", elemento.getId());
            Traslado trasladoDocument = trasladoCollection.find(trasladoQuery).first();

            trasladoDocument.setProductorId(elemento.getProductorId());
            trasladoDocument.setFecha(elemento.getFecha());
            trasladoDocument.setResiduos(elemento.getResiduos());
            trasladoDocument.setEmpresaTransportista(elemento.getEmpresaTransportista());

            trasladoCollection.replaceOne(trasladoQuery, trasladoDocument);

            return trasladoDocument;
        } catch (Exception e) {
            throw new Exception("Hubo un error al actualizar el traslado");
        }
    }

}
