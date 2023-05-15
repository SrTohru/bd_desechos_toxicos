package com.itson.desechostoxicospersistencia.validators;

import com.itson.desechostoxicospersistencia.database.ConnectionDataBase;
import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.Productores;
import com.itson.dominio.Quimicos;
import com.itson.dominio.RegistroTraslado;
import com.itson.dominio.Residuos;
import com.itson.dominio.Traslado;
import com.itson.dominio.Vehiculo;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

public class GeneralValidator {

    MongoDatabase baseDatos = ConnectionDataBase.getBaseDatos();
    DatabaseFormats formatos;

    private EmpresaTransportista verificarExistenciaEmpresa(EmpresaTransportista empresa) {
        if (baseDatos.getCollection(formatos.getEMPRESA_TRANSPORTISTA_COLLECTION()).find(new Document("id_", empresa.getId().toString())) != null
                || baseDatos.getCollection(formatos.getEMPRESA_TRANSPORTISTA_COLLECTION()).find(new Document("nombre", empresa.getNombre())) != null) {
            return empresa;
        } else {
            return null;
        }
    }

    private Productores verificarExisstenciaProductor(Productores productores) {
        if (baseDatos.getCollection(formatos.getEMPRESA_TRANSPORTISTA_COLLECTION()).find(new Document("id_", productores.getId().toString())) != null
                || baseDatos.getCollection(formatos.getEMPRESA_TRANSPORTISTA_COLLECTION()).find(new Document("nombre", productores.getNombre())) != null) {
            return productores;
        } else {
            return null;
        }
    }

//    private Quimicos verificarExistenciaEmpresa(Quimicos empresa) {
//    
//    }
    private RegistroTraslado verificarExistenciaRegistroTraslado(RegistroTraslado registroTraslado) {
        if (baseDatos.getCollection(formatos.getREGISTRO_TRASLADO()).find(new Document("id_", registroTraslado.getId().toString())) != null
                || baseDatos.getCollection(formatos.getREGISTRO_TRASLADO()).find(new Document("trasladoId", registroTraslado.getTrasladoId())) != null) {
            return registroTraslado;
        } else {
            return null;
        }
    }

    private Residuos verificarExistenciaResiduo(Residuos residuos) {
        if (baseDatos.getCollection(formatos.getRESIDUOS()).find(new Document("id_", residuos.getId().toString())) != null
                || baseDatos.getCollection(formatos.getRESIDUOS()).find(new Document("nombre", residuos.getNombre())) != null) {
            return residuos;
        } else {
            return null;
        }
    }

    private Traslado verificarExistenciaTraslado(Traslado traslado) {
        if (baseDatos.getCollection(formatos.getTRASLADOS()).find(new Document("id_", traslado.getId().toString())) != null
                || baseDatos.getCollection(formatos.getTRASLADOS()).find(new Document("productorId", traslado.getProductorId())) != null) {
            return traslado;
        } else {
            return null;
        }
    }

    private Vehiculo verificarExistenciaVehiculo(Vehiculo vehiculo) {
        if (baseDatos.getCollection(formatos.getVEHICULO()).find(new Document("id_", vehiculo.getId().toString())) != null) {
            return vehiculo;
        } else {
            return null;
        }
    }

}
