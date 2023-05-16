/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.desechostoxicospersistencia.dao;

import com.itson.desechostoxicospersistencia.database.ConnectionDataBase;
import com.itson.desechostoxicospersistencia.interfaces.IVehiculo;
import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.Vehiculo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.List;

/**
 *
 * @author PC
 */
public class VehiculoDAO implements IVehiculo {

    MongoDatabase baseDatos = ConnectionDataBase.getBaseDatos();
    DatabaseFormats databaseFormats = new DatabaseFormats();

    MongoCollection<Vehiculo> vehiculoCollection = baseDatos.getCollection(databaseFormats.getVEHICULO(), Vehiculo.class);

    @Override
    public Vehiculo insertarElemento(Vehiculo e) {
return null;       
// vehiculoCollection.insertMany(list);
    }

    @Override
    public Vehiculo consultarElemento(Vehiculo elemento, DatabaseFormats collectionName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vehiculo eliminarElemento(Vehiculo elemento, DatabaseFormats collectionName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vehiculo actualizarElemento(Vehiculo elemento, DatabaseFormats collectionName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Vehiculo> insertarElementoEnLista(List<Vehiculo> e) {
        vehiculoCollection.insertMany(e);
        
     return e;   
    }

}
