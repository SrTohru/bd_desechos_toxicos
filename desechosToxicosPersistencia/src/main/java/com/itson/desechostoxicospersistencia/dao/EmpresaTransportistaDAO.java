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
import com.mongodb.BasicDBObject;
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
    GeneralMethods gMethods = new GeneralMethods();
    MongoCollection<EmpresaTransportista> empresaCollection = baseDatos.getCollection(databaseFormats.getEMPRESA_TRANSPORTISTA_COLLECTION(), EmpresaTransportista.class);

    @Override
    public EmpresaTransportista insertarEmpresaConAutos(EmpresaTransportista empresa) throws Exception {
        try {
            gMethods.generacionDeIdParaVehiculos(empresa);

            empresaCollection.insertOne(empresa);

            return empresa;
        } catch (HeadlessException e) {
            throw new Exception("Hubo un error al insertar la empresa con autos");
        }
    }

    @Override
    public EmpresaTransportista consultarEmpresa(EmpresaTransportista elemento) throws Exception {
        try {
            Document empresaQuery = new Document("_id", elemento.getId());
            EmpresaTransportista empresaDocument = empresaCollection.find(empresaQuery).first();

            return empresaDocument;
        } catch (Exception e) {
            throw new Exception("Hubo un error al consultar la empresa");
        }
    }

    @Override
    public void eliminarEmpresa(EmpresaTransportista elemento) throws Exception {

        try {
            empresaCollection.findOneAndDelete(new Document("_id", elemento.getId()));
        } catch (Exception e) {
            throw new Exception("Hubo un error al eliminar la empresa");
        }
    }

    @Override
    public EmpresaTransportista actualizarEmpresa(EmpresaTransportista elemento) throws Exception {

        try {
            Document empresaQuery = new Document("_id", elemento.getId());
            EmpresaTransportista empresaDocument = empresaCollection.find(empresaQuery).first();

            empresaDocument.setNombre(elemento.getNombre());
            empresaDocument.setVehiculos(elemento.getVehiculos());

            empresaCollection.replaceOne(empresaQuery, empresaDocument);

            return empresaDocument;

        } catch (Exception e) {
            throw new Exception("Hubo un error al actualizar la empresa");
        }

    }

    @Override
    public EmpresaTransportista insertarEmpresa(EmpresaTransportista empresa) throws Exception {
        try {

            empresaCollection.insertOne(empresa);

            return empresa;
        } catch (HeadlessException e) {
            throw new Exception("Hubo un error al insertar la empresa");
        }
    }

    @Override
    public List<EmpresaTransportista> consultarTodasLasEmpresas() throws Exception {

        try {
            return empresaCollection.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new Exception("Hubo un error al consultar todas las empresas");
        }

    }
    
    @Override
    public EmpresaTransportista iniciarSesion(EmpresaTransportista empresa) throws Exception {
        BasicDBObject query = new BasicDBObject();
        query.put("cuenta.usuario", empresa.getCuenta().getUsuario());
        query.put("cuenta.contrasena", empresa.getCuenta().getContrasena());
        query.put("cuenta.tipoCuenta", empresa.getCuenta().getTipoCuenta());

        EmpresaTransportista result = empresaCollection.find(query).first();
        if (result != null) {
            return result;
        }
        throw new Exception("Hubo un error al iniciar sesion en la cuenta");
    }
}
