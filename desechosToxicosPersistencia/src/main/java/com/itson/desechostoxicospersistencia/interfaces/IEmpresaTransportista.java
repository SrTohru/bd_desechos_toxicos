package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.desechostoxicospersistencia.utilities.ConfiguracionDePaginado;
import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.Quimicos;
import java.util.List;

public interface IEmpresaTransportista {

    EmpresaTransportista insertarEmpresaConAutos(EmpresaTransportista e);

    EmpresaTransportista insertarEmpresa(EmpresaTransportista e);

    EmpresaTransportista consultarEmpresa(EmpresaTransportista elemento);

    void eliminarEmpresa(EmpresaTransportista elemento);

    EmpresaTransportista actualizarEmpresa(EmpresaTransportista elemento);
    
     List<EmpresaTransportista> consultarTodasLasEmpresas();
}
