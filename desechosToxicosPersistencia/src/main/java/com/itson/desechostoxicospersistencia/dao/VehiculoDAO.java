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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author PC
 */
public class VehiculoDAO implements IVehiculo {
    
    DatabaseFormats dFormats;
    MongoDatabase baseDatos = ConnectionDataBase.getBaseDatos();
    MongoCollection<Vehiculo> vehiculoCollection = baseDatos.getCollection(dFormats.getVEHICULO(), Vehiculo.class);

    @Override
    public Vehiculo insertarElemento(Vehiculo e) {
        try {
            vehiculoCollection.insertOne(e);

            JOptionPane.showMessageDialog(null, "El vehículo ha sido insertado correctamente.");

            return e;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar el vehículo");
            return null;
        }
    }

    @Override
    public List<Vehiculo> insertarElementoEnLista(List<Vehiculo> e) {
        try {
            vehiculoCollection.insertMany(e);

            JOptionPane.showMessageDialog(null, "Los vehículos han sido insertados correctamente.");

            return e;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar los vehículos");
            return null;
        }
    }

    @Override
    public Vehiculo consultarAutoPorEmpresa(EmpresaTransportista emp) {
        try {
            Document vehiculoQuery = new Document("empresaTransportista", emp);
            Vehiculo vehiculoDocument = vehiculoCollection.find(vehiculoQuery).first();

            return vehiculoDocument;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al consultar el vehículo");
            return null;
        }
    }

    @Override
    public List<Vehiculo> consultarAutosPorEmpresa(EmpresaTransportista emp) {
        try {
            Document vehiculoQuery = new Document("empresaTransportista", emp);
            List<Vehiculo> vehiculos = vehiculoCollection.find(vehiculoQuery).into(new ArrayList<>());

            return vehiculos;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al consultar los vehículos");
            return null;
        }
    }
}
