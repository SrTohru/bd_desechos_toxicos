package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.desechostoxicospersistencia.utilities.ConfiguracionDePaginado;
import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.Quimicos;
import java.util.List;

public interface IEmpresaTransportista {

    EmpresaTransportista insertarEmpresaConAutos(EmpresaTransportista e) throws Exception;

    EmpresaTransportista insertarEmpresa(EmpresaTransportista e) throws Exception;

    EmpresaTransportista consultarEmpresa(EmpresaTransportista elemento) throws Exception;

    void eliminarEmpresa(EmpresaTransportista elemento) throws Exception;

    EmpresaTransportista actualizarEmpresa(EmpresaTransportista elemento) throws Exception;
    
     List<EmpresaTransportista> consultarTodasLasEmpresas() throws Exception;
}
