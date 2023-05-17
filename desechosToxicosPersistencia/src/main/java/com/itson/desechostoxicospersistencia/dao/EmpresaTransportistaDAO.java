/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.desechostoxicospersistencia.dao;

import com.itson.desechostoxicospersistencia.database.ConnectionDataBase;
import com.itson.desechostoxicospersistencia.interfaces.IEmpresaTransportista;
import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.desechostoxicospersistencia.validators.GeneralMethods;
import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.Vehiculo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.types.ObjectId;

public class EmpresaTransportistaDAO implements IEmpresaTransportista {

    MongoDatabase baseDatos = ConnectionDataBase.getBaseDatos();
    DatabaseFormats databaseFormats = new DatabaseFormats();
    GeneralMethods gMethods;
    MongoCollection<EmpresaTransportista> empresaCollection = baseDatos.getCollection(databaseFormats.getEMPRESA_TRANSPORTISTA_COLLECTION(), EmpresaTransportista.class);

    @Override
    public EmpresaTransportista insertarEmpresaConAutos(EmpresaTransportista empresa) {
        try {
            gMethods.generacionDeIdParaVehiculos(empresa);

            empresaCollection.insertOne(empresa);

            JOptionPane.showMessageDialog(null, "La empresa y los vehículos han sido insertados correctamente.");

            return empresa;
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar una empresa");
            return null;
        }
    }

    @Override
    public EmpresaTransportista consultarEmpresa(EmpresaTransportista elemento) {
        try {
            Document empresaQuery = new Document("_id", elemento.getId());
            EmpresaTransportista empresaDocument = empresaCollection.find(empresaQuery).first();

            return empresaDocument;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al consultar una empresa");
            return null;
        }
    }

    @Override
    public void eliminarEmpresa(EmpresaTransportista elemento) {

        try {
            empresaCollection.findOneAndDelete(new Document("_id", elemento.getId()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al eliminar la empresa");
        }
    }

    @Override
    public EmpresaTransportista actualizarEmpresa(EmpresaTransportista elemento) {

        try {
            Document empresaQuery = new Document("_id", elemento.getId());
            EmpresaTransportista empresaDocument = empresaCollection.find(empresaQuery).first();

            empresaDocument.setNombre(elemento.getNombre());
            empresaDocument.setVehiculos(elemento.getVehiculos());

            empresaCollection.replaceOne(empresaQuery, empresaDocument);

            return empresaDocument;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al actualizar la empresa");
            return null;
        }

    }

    @Override
    public EmpresaTransportista insertarEmpresa(EmpresaTransportista empresa) {
        try {

            empresaCollection.insertOne(empresa);

            JOptionPane.showMessageDialog(null, "La empresa ha sido insertada correctamente.");

            return empresa;
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar una empresa");
            return null;
        }
    }

    @Override
    public List<EmpresaTransportista> consultarTodasLasEmpresas() {

       
        try {
            return empresaCollection.find().into(new ArrayList<>());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al consultar todas las empresas exsistentes");
            return null;
        }

    }
}


