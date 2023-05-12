package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.Traslado;

public interface ITraslado {
    Traslado insertarElemento(Traslado e, DatabaseFormats collectionName);

    Traslado consultarElemento(Traslado elemento, DatabaseFormats collectionName);

    Traslado eliminarElemento(Traslado elemento, DatabaseFormats collectionName);

    Traslado actualizarElemento(Traslado elemento, DatabaseFormats collectionName);
}
