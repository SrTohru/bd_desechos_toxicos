package com.itson.desechostoxicospersistencia.database;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class ConnectionDataBase {

    //private static String BASE_DATOS;
    public static MongoDatabase baseDatos;
    
    private ConnectionDataBase() {
        
    }

    public static MongoDatabase getBaseDatos() {

        if (ConnectionDataBase.baseDatos == null) {
            CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().automatic(true).build()));

            MongoClientSettings configuraciones = MongoClientSettings.builder()
                    .codecRegistry(pojoCodecRegistry)
                    .build();

            MongoClient conexion = MongoClients.create(configuraciones);
            ConnectionDataBase.baseDatos = conexion.getDatabase("desechos_toxicos");
        }

        return ConnectionDataBase.baseDatos;
    }
}
