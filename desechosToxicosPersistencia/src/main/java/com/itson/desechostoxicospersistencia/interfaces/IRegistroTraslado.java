package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.RegistroTraslado;
import java.util.List;

public interface IRegistroTraslado {

    RegistroTraslado insertarTraslado(RegistroTraslado e);

    RegistroTraslado consultarTraslado(RegistroTraslado elemento);

    void eliminarTraslado(RegistroTraslado elemento);

    RegistroTraslado actualizarTraslado(RegistroTraslado elemento);

    List<RegistroTraslado> consultarTodosLosTrasladosExistentes();

}
