package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.Traslado;

public interface ITraslado {

    Traslado insertarElemento(Traslado e);

    Traslado consultarElemento(Traslado elemento);

    Traslado actualizarElemento(Traslado elemento);
}
