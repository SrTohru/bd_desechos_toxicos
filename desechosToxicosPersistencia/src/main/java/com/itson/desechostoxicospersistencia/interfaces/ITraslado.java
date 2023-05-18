package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.Traslado;

public interface ITraslado {

    Traslado insertarTraslado(Traslado e) throws Exception;

    Traslado consultarTraslado(Traslado elemento) throws Exception;

    Traslado actualizarTraslado(Traslado elemento) throws Exception;
}
