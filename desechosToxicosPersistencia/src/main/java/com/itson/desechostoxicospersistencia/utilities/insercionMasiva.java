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

        for (int i = 1; i < 20; i++) {
            List<Vehiculo> stringList = new LinkedList<>();
            Vehiculo v = new Vehiculo("Marca " + i, "Modelo " + i, 2000 + i);
            Vehiculo v2 = new Vehiculo("SMarca " + i, "SModelo " + i, 3000 + i);

            stringList.add(v);
            stringList.add(v2);

            EmpresaTransportista empresaTransportista = new EmpresaTransportista("Empresa " + (i + 1), stringList);

            eDAO.insertarEmpresaConAutos(empresaTransportista);

        }

    }

    public void insercioResiduos() throws Exception{
        MongoCollection<Document> residuosCollection = baseDatos.getCollection(databaseFormats.getRESIDUOS());
        Document residuo = new Document();
        residuo.append("codigo", 412411);
        residuo.append("nombre", "Residuo3");

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
//        for (int i = 0; i < 5; i++) {
//            boolean test;
//            if (i % 2 == 0) {
//                test = true;
//            } else {
//                test = false;
//            }
//            Cuenta cuenta = new Cuenta("Administrador" + i, "Administrador" + i, tiposDeCuenta.Administrador.toString());
//            
//            cDAO.insertarCuenta(cuenta);
//            
//            List<Residuos> stringList = new LinkedList<>();
//            
//            Residuos residuo1 = new Residuos("Residuo" + i, "3" + i + "2" + i + "9" + i, test, qDAO.consultarQuimicosGenerales(null).get(i));
//            Residuos residuo2 = new Residuos("Residuo" + i, "1" + i + "3" + i + "4" + i, test, qDAO.consultarQuimicosGenerales(null).get(i));
//            
//            stringList.add(residuo1);
//            stringList.add(residuo2);
//            
//            Productores p = new Productores("Productor " + i,  stringList, cuenta);
//        
//            pDAO.insertarProductor(p);
//        }

            // Obtener las colecciones
            
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
        productor.append("contrasenia", "123456");
        productor.append("cuenta", cuenta);
        
        Document productor2 = new Document();
        productor2.append("nombre", "productor2");
        productor2.append("contrasenia", "2341");
        productor2.append("cuenta", cuenta2);
        
        List<Document> listaInsertarDocumentos = new LinkedList<>();
        listaInsertarDocumentos.add(productor);
        listaInsertarDocumentos.add(productor2);
        
        residuosCollection.insertMany(listaInsertarDocumentos);
        
        
        
    }
    
    public void relacionarProductoresResiduos() throws Exception{
         // Obtener las colecciones
//        MongoCollection<Document> residuosCollection = baseDatos.getCollection(databaseFormats.getRESIDUOS());
//        
//        Document productor = new Document();
//        
//        residuosCollection.updateOne(productor,  );
        
    }

}
