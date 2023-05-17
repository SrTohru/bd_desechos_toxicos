/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.desechostoxicospersistencia.dao;

import com.itson.desechostoxicospersistencia.database.ConnectionDataBase;
import com.itson.desechostoxicospersistencia.interfaces.IProductores;
import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.Productores;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author PC
 */
public class ProductoresDAO implements IProductores{
    DatabaseFormats dFormats;
     MongoDatabase baseDatos = ConnectionDataBase.getBaseDatos();
    MongoCollection<Productores> productoresCollection = baseDatos.getCollection(dFormats.getPRODUCTORES_COLLECTION(), Productores.class);

    @Override
    public Productores insertarProductor(Productores e) {
        try {
            productoresCollection.insertOne(e);

            JOptionPane.showMessageDialog(null, "El productor ha sido insertado correctamente.");

            return e;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar el productor");
            return null;
        }
    }

    @Override
    public Productores consultarProductor(Productores elemento) {
        try {
            Document productorQuery = new Document("_id", elemento.getId());
            Productores productorDocument = productoresCollection.find(productorQuery).first();

            return productorDocument;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al consultar el productor");
            return null;
        }
    }

    @Override
    public void eliminarProductor(Productores elemento) {
        try {
            productoresCollection.findOneAndDelete(new Document("_id", elemento.getId()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al eliminar el productor");
        }
    }

    @Override
    public Productores actualizarProductor(Productores elemento) {
        try {
            Document productorQuery = new Document("_id", elemento.getId());
            Productores productorDocument = productoresCollection.find(productorQuery).first();

            productorDocument.setNombre(elemento.getNombre());
            productorDocument.setResiduos(elemento.getResiduos());

            productoresCollection.replaceOne(productorQuery, productorDocument);

            return productorDocument;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al actualizar el productor");
            return null;
        }
    }

    @Override
    public List<Productores> consultarProductores() {
        try {
            return productoresCollection.find().into(new ArrayList<>());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al consultar todos los productores");
            return null;
        }
    }

    @Override
    public List<Productores> consultarProductoresConSolicitudTraslado() {
        try {
            //Falta por terminar
            return null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al consultar los productores con solicitud de traslado");
            return null;
        }
    }
}
