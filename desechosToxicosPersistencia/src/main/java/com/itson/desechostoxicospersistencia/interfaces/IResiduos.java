package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.desechostoxicospersistencia.utilities.ConfiguracionDePaginado;
import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.Residuos;
import java.util.List;

public interface IResiduos {

    Residuos insertarElemento(Residuos elemento);

    List<Residuos> consultarElemento(ConfiguracionDePaginado configuracionDePaginado);

    Residuos eliminarElemento(Residuos elemento, DatabaseFormats collectionName);

    Residuos actualizarElemento(Residuos elemento);
}
