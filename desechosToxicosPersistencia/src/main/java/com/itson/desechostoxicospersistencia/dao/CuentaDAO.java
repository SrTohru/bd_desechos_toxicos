package com.itson.desechostoxicospersistencia.dao;

import com.itson.desechostoxicospersistencia.database.ConnectionDataBase;
import com.itson.desechostoxicospersistencia.interfaces.ICuenta;
import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.Cuenta;
import com.itson.dominio.utilities.tiposDeCuenta;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.types.ObjectId;

public class CuentaDAO implements ICuenta {

    MongoDatabase baseDatos = ConnectionDataBase.getBaseDatos();
    DatabaseFormats databaseFormats = new DatabaseFormats();
    MongoCollection<Cuenta> cuentaCollection = baseDatos.getCollection(databaseFormats.getCUENTA(), Cuenta.class);

    @Override
    public Cuenta insertarCuenta(Cuenta cuenta) throws Exception {

        try {
            cuentaCollection.insertOne(cuenta);
      
            return cuenta;
        } catch (Exception e) {
            throw new Exception("Hubo un error al registrar la cuenta");
        }
    }

    @Override
    public Cuenta iniciarSesion(Cuenta cuenta) throws Exception {
        BasicDBObject query = new BasicDBObject();
        query.put("usuario", cuenta.getUsuario());
        query.put("contrasena", cuenta.getContrasena());
        query.put("tipoCuenta", cuenta.getTipoCuenta());

        Cuenta result = cuentaCollection.find(query).first();
        if (result != null) {
            return result;
        }
        throw new Exception("Hubo un error al iniciar sesion en la cuenta");
    }
}
