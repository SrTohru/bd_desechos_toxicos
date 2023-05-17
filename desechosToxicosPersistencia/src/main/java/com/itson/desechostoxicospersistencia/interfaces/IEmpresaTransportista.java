package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.EmpresaTransportista;

public interface IEmpresaTransportista {
    
    EmpresaTransportista insertarElemento(EmpresaTransportista e);

    EmpresaTransportista consultarElemento(EmpresaTransportista elemento);

    EmpresaTransportista eliminarElemento(EmpresaTransportista elemento);

    EmpresaTransportista actualizarElemento(EmpresaTransportista elemento);
}
