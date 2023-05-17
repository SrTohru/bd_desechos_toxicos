/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.desechostoxicospersistencia.dao;

import com.itson.desechostoxicospersistencia.database.ConnectionDataBase;
import com.itson.desechostoxicospersistencia.interfaces.IProductores;
import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.Productores;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
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
public class ProductoresDAO implements IProductores {

    DatabaseFormats dFormats = new DatabaseFormats();
    MongoDatabase baseDatos = ConnectionDataBase.getBaseDatos();
    MongoCollection<Productores> productoresCollection = baseDatos.getCollection(dFormats.getPRODUCTORES_COLLECTION(), Productores.class);

    @Override
    public Productores insertarProductor(Productores e) throws Exception{
        try {
            productoresCollection.insertOne(e);
            return e;
        } catch (Exception ex) {
          throw new Exception("Hubo un error al insertar al productor");
        }
    }

    @Override
    public Productores consultarProductor(Productores elemento) throws Exception{
        try {
            Document productorQuery = new Document("_id", elemento.getId());
            Productores productorDocument = productoresCollection.find(productorQuery).first();

            return productorDocument;
        } catch (Exception e) {
         throw new Exception("Hubo un error al consultar el productor");
        }
    }

    @Override
    public void eliminarProductor(Productores elemento) throws Exception{
        try {
            productoresCollection.findOneAndDelete(new Document("_id", elemento.getId()));
            
        } catch (MongoException e) {
            throw new Exception("Hubo un error al eliminar el productor");
        }
    }

    @Override
    public Productores actualizarProductor(Productores elemento) throws Exception{
        try {
            Document productorQuery = new Document("_id", elemento.getId());
            Productores productorDocument = productoresCollection.find(productorQuery).first();

            productorDocument.setNombre(elemento.getNombre());
            productorDocument.setResiduos(elemento.getResiduos());

            productoresCollection.replaceOne(productorQuery, productorDocument);

            return productorDocument;
        } catch (Exception e) {
            throw new Exception("Hubo un error al actualizar el productor");
        }
    }

    @Override
    public List<Productores> consultarProductores() throws Exception{
        try {
            return productoresCollection.find().into(new ArrayList<>());
        } catch (Exception e) {
          throw new Exception("Hubo un error al consultar a todos los productores");
        }
    }

    @Override
    public List<Productores> consultarProductoresConSolicitudTraslado() throws Exception{
        try {
            //Falta por terminar
            return null;
        } catch (Exception e) {
           throw new Exception("Hubo un error al consultar productores con solicitud de traslado");
        }
    }
    
    @Override
    public Productores iniciarSesion(Productores productores) throws Exception {
        BasicDBObject query = new BasicDBObject();
        query.put("cuenta.usuario", productores.getCuenta().getUsuario());
        query.put("cuenta.contrasena", productores.getCuenta().getContrasena());
        query.put("cuenta.tipoCuenta", productores.getCuenta().getTipoCuenta());

        Productores result = productoresCollection.find(query).first();
        if (result != null) {
            return result;
        }
        throw new Exception("Hubo un error al iniciar sesion en la cuenta");
    }
}
