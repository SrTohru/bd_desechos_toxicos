package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.Residuos;

public interface IResiduos {

    Residuos insertarElemento(Residuos e, DatabaseFormats collectionName);

    Residuos consultarElemento(Residuos elemento, DatabaseFormats collectionName);

    Residuos eliminarElemento(Residuos elemento, DatabaseFormats collectionName);

    Residuos actualizarElemento(Residuos elemento, DatabaseFormats collectionName);
}
