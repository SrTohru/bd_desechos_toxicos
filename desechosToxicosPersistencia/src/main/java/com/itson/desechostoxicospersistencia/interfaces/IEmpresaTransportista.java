package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.EmpresaTransportista;

public interface IEmpresaTransportista {
    
    EmpresaTransportista insertarElemento(EmpresaTransportista e, DatabaseFormats collectionName);

    EmpresaTransportista consultarElemento(EmpresaTransportista elemento, DatabaseFormats collectionName);

    EmpresaTransportista eliminarElemento(EmpresaTransportista elemento, DatabaseFormats collectionName);

    EmpresaTransportista actualizarElemento(EmpresaTransportista elemento, DatabaseFormats collectionName);
}
