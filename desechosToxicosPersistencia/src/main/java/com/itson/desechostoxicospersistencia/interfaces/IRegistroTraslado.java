package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.RegistroTraslado;
import java.util.List;

public interface IRegistroTraslado {

    RegistroTraslado insertarTraslado(RegistroTraslado e) throws Exception;

    RegistroTraslado consultarTraslado(RegistroTraslado elemento) throws Exception;

    void eliminarTraslado(RegistroTraslado elemento) throws Exception;

    RegistroTraslado actualizarTraslado(RegistroTraslado elemento) throws Exception;

    List<RegistroTraslado> consultarTodosLosTrasladosExistentes() throws Exception;

}
