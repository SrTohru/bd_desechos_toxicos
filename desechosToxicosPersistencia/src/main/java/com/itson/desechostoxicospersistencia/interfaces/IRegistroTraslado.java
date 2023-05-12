package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.RegistroTraslado;

public interface IRegistroTraslado {

    RegistroTraslado insertarElemento(RegistroTraslado e, DatabaseFormats collectionName);

    RegistroTraslado consultarElemento(RegistroTraslado elemento, DatabaseFormats collectionName);

    RegistroTraslado eliminarElemento(RegistroTraslado elemento, DatabaseFormats collectionName);

    RegistroTraslado actualizarElemento(RegistroTraslado elemento, DatabaseFormats collectionName);
}
