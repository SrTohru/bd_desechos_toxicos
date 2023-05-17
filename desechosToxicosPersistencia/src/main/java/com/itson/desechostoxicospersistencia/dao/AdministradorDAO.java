/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.desechostoxicospersistencia.dao;

import com.itson.desechostoxicospersistencia.database.ConnectionDataBase;
import com.itson.desechostoxicospersistencia.interfaces.IAdministrador;
import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.Administrador;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Usuario
 */
public class AdministradorDAO implements IAdministrador{
    
    DatabaseFormats dFormats = new DatabaseFormats();
    MongoDatabase baseDatos = ConnectionDataBase.getBaseDatos();
    MongoCollection<Administrador> admin = baseDatos.getCollection(dFormats.getADMINISTRADOR(), Administrador.class);
    
    @Override
    public Administrador iniciarSesion(Administrador administrador) throws Exception {
        BasicDBObject query = new BasicDBObject();
        query.put("cuenta.usuario", administrador.getCuenta().getUsuario());
        query.put("cuenta.contrasena", administrador.getCuenta().getContrasena());
        query.put("cuenta.tipoCuenta", administrador.getCuenta().getTipoCuenta());

        Administrador result = admin.find(query).first();
        if (result != null) {
            return result;
        }
        throw new Exception("Hubo un error al iniciar sesion en la cuenta");
    }
    
}
