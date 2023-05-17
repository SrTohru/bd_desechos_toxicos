package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.Traslado;

public interface ITraslado {

    Traslado insertarElemento(Traslado e) throws Exception;

    Traslado consultarElemento(Traslado elemento) throws Exception;

    Traslado actualizarElemento(Traslado elemento) throws Exception;
}
