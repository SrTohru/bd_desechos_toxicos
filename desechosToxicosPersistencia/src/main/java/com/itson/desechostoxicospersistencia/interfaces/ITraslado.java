package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.Traslado;
import java.util.List;

public interface ITraslado {

    Traslado insertarTraslado(Traslado e) throws Exception;

    Traslado consultarTraslado(Traslado elemento) throws Exception;

    Traslado actualizarTraslado(Traslado elemento) throws Exception;

    List<Traslado> consultarTraslados() throws Exception;
}
