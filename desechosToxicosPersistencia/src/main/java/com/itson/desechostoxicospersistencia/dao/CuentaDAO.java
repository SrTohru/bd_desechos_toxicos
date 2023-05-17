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
    public Cuenta insertarCuenta(Cuenta cuenta) {

        try {
            cuentaCollection.insertOne(cuenta);
            JOptionPane.showMessageDialog(null, "Se registro la cuenta correctamente");
            return cuenta;
        } catch (Exception e) {
         
            JOptionPane.showMessageDialog(null, "Hubo un error al registrar la cuenta");
            return null;
        }
    }

    @Override
    public Cuenta iniciarSesion(Cuenta cuenta) {
        BasicDBObject query = new BasicDBObject();
        query.put("usuario", cuenta.getUsuario());
        query.put("contrasena", cuenta.getContrasena());
        query.put("tipoCuenta", cuenta.getTipoCuenta());
        Cuenta result = cuentaCollection.find(query).first();
        if (result != null) {
            return result;
        }

        return null;
    }
}
