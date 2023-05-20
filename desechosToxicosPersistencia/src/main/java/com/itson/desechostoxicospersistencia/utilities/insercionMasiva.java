package com.itson.desechostoxicospersistencia.utilities;

import com.itson.desechostoxicospersistencia.dao.CuentaDAO;
import com.itson.desechostoxicospersistencia.dao.EmpresaTransportistaDAO;
import com.itson.desechostoxicospersistencia.dao.ProductoresDAO;
import com.itson.desechostoxicospersistencia.dao.QuimicosDAO;
import com.itson.desechostoxicospersistencia.dao.ResiduosDAO;
import com.itson.desechostoxicospersistencia.dao.VehiculoDAO;
import com.itson.desechostoxicospersistencia.database.ConnectionDataBase;
import com.itson.dominio.Cuenta;
import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.Productores;
import com.itson.dominio.Quimicos;
import com.itson.dominio.Residuos;
import com.itson.dominio.Vehiculo;
import com.itson.dominio.utilities.tiposDeCuenta;
import com.mongodb.DBRef;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

public class insercionMasiva {

//Quimicos
    //Productores
    //Adminisitradores
    MongoDatabase baseDatos = ConnectionDataBase.getBaseDatos();
    DatabaseFormats databaseFormats = new DatabaseFormats();

    ResiduosDAO rDAO = new ResiduosDAO();
    EmpresaTransportistaDAO eDAO = new EmpresaTransportistaDAO();
    QuimicosDAO qDAO = new QuimicosDAO();
    ProductoresDAO pDAO = new ProductoresDAO();
    CuentaDAO cDAO = new CuentaDAO();

    public void insercionMasivaDeVehiculosYEmpresas() throws Exception {
        MongoCollection<Document> residuosCollection = baseDatos.getCollection(databaseFormats.getEMPRESA_TRANSPORTISTA_COLLECTION());
        Document cuenta = new Document();
        cuenta.append("usuario", "DHL")
                .append("contrasena", "dhl22")
                .append("tipoCuenta", tiposDeCuenta.EmpresaTransportista.toString());

        Document cuenta2 = new Document();
        cuenta2.append("usuario", "Fedex")
                .append("contrasena", "fedex124")
                .append("tipoCuenta", tiposDeCuenta.EmpresaTransportista.toString());

        List<Document> vehiculos1 = new LinkedList<>();

        Document vehiculo1 = new Document();
        vehiculo1.append("marca", "toyota");
        vehiculo1.append("modelo", "corolla");
        vehiculo1.append("ano", 2022);

        Document vehiculo2 = new Document();
        vehiculo2.append("marca", "Chevrolet");
        vehiculo2.append("modelo", "Cheyenne");
        vehiculo2.append("ano", 2021);

        vehiculos1.add(vehiculo1);
        vehiculos1.add(vehiculo2);

        Document empresa1 = new Document();
        empresa1.append("nombre", "Fedex");
        empresa1.append("cuenta", cuenta);
        empresa1.append("vehiculos", vehiculos1);

        List<Document> vehiculos2 = new LinkedList<>();

        Document vehiculo11 = new Document();
        vehiculo11.append("marca", "Nissan");
        vehiculo11.append("modelo", "Frontier");
        vehiculo11.append("ano", 2022);

        Document vehiculo22 = new Document();
        vehiculo22.append("marca", "Chevrolet");
        vehiculo22.append("modelo", "Cheyenne");
        vehiculo22.append("ano", 2020);

        vehiculos2.add(vehiculo11);
        vehiculos2.add(vehiculo22);

        Document empresa2 = new Document();
        empresa2.append("nombre", "productor2");
        empresa2.append("cuenta", cuenta2);
        empresa2.append("vehiculos", vehiculos2);

        List<Document> listaInsertarDocumentos = new LinkedList<>();
        listaInsertarDocumentos.add(empresa1);
        listaInsertarDocumentos.add(empresa2);

        residuosCollection.insertMany(listaInsertarDocumentos);

    }

    public void insercionQuimicos() throws Exception {
        MongoCollection<Document> quimicosCollection = baseDatos.getCollection(databaseFormats.getQUIMICOS());
        List<Document> listaQuimicos = new LinkedList<>();

        Document quimicos1 = new Document();
        quimicos1.append("nombre", "Quimico1");

        Document quimicos2 = new Document();
        quimicos2.append("nombre", "Quimico2");

        Document quimicos3 = new Document();
        quimicos3.append("nombre", "Quimico3");

        Document quimicos4 = new Document();
        quimicos4.append("nombre", "Quimico4");

        Document quimicos5 = new Document();
        quimicos5.append("nombre", "Quimico5");

        Document quimicos6 = new Document();
        quimicos5.append("nombre", "Random test quimic");
        listaQuimicos.add(quimicos1);
        listaQuimicos.add(quimicos2);
        listaQuimicos.add(quimicos3);
        listaQuimicos.add(quimicos4);
        listaQuimicos.add(quimicos5);
        listaQuimicos.add(quimicos6);

        quimicosCollection.insertMany(listaQuimicos);
    }

    public void insercioResiduos() throws Exception {
        MongoCollection<Document> residuosCollection = baseDatos.getCollection(databaseFormats.getRESIDUOS());
        Document residuo = new Document();
        residuo.append("codigo", 412411);
        residuo.append("nombre", "Residuo3");
        residuo.append("peligroso", false);
        List<Document> listaQuimicos = new LinkedList<>();

        Document quimicos1 = new Document();
        quimicos1.append("nombre", "Quimico1");

        Document quimicos2 = new Document();
        quimicos2.append("nombre", "Quimico4");

        listaQuimicos.add(quimicos1);
        listaQuimicos.add(quimicos2);

        residuo.append("Quimicos", listaQuimicos);

        Document residuo2 = new Document();
        residuo2.append("codigo", 321132);
        residuo2.append("nombre", "Residuo2");
        residuo2.append("peligroso", true);
        List<Document> listaQuimicos2 = new LinkedList<>();

        Document quimicos11 = new Document();
        quimicos11.append("nombre", "Quimico2");

        Document quimicos22 = new Document();
        quimicos22.append("nombre", "Quimico3");

        listaQuimicos2.add(quimicos11);
        listaQuimicos2.add(quimicos22);

        residuo2.append("Quimicos", listaQuimicos2);

        List<Document> listaInsertarDocumentos = new LinkedList<>();
        listaInsertarDocumentos.add(residuo);
        listaInsertarDocumentos.add(residuo2);

        residuosCollection.insertMany(listaInsertarDocumentos);
    }

    public void insercionMasivaProductores() throws Exception {
        MongoCollection<Document> residuosCollection = baseDatos.getCollection(databaseFormats.getPRODUCTORES_COLLECTION());
        Document cuenta = new Document();
        cuenta.append("usuario", "pepe")
                .append("contrasena", "1234")
                .append("tipoCuenta", tiposDeCuenta.Productor.toString());

        Document cuenta2 = new Document();
        cuenta2.append("usuario", "pablo")
                .append("contrasena", "1132")
                .append("tipoCuenta", tiposDeCuenta.Productor.toString());

        Document productor = new Document();
        productor.append("nombre", "mejor productor");
        productor.append("cuenta", cuenta);

        Document productor2 = new Document();
        productor2.append("nombre", "productor2");
        productor2.append("cuenta", cuenta2);

        List<Document> listaInsertarDocumentos = new LinkedList<>();
        listaInsertarDocumentos.add(productor);
        listaInsertarDocumentos.add(productor2);

        residuosCollection.insertMany(listaInsertarDocumentos);
    }

    public void insercionAdministrador() throws Exception {
        MongoCollection<Document> residuosCollection = baseDatos.getCollection(databaseFormats.getADMINISTRADOR());
        Document cuenta = new Document();
        cuenta.append("usuario", "admin")
                .append("contrasena", "admin123")
                .append("tipoCuenta", tiposDeCuenta.Administrador.toString());

        Document admin = new Document();
        admin.append("nombre", "mejor productor");
        admin.append("cuenta", cuenta);

        residuosCollection.insertOne(admin);
    }


}
