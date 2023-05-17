package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.desechostoxicospersistencia.utilities.ConfiguracionDePaginado;
import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.Productores;
import com.itson.dominio.Residuos;
import java.util.List;

public interface IResiduos {

    Residuos insertarElemento(Residuos elemento);

    List<Residuos> consultarElemento(ConfiguracionDePaginado configuracionDePaginado);
    
    List<Residuos> consultarElementosPorProductor(Productores productor); 
            
    Residuos eliminarElemento(Residuos elemento);

    Residuos actualizarElemento(Residuos elemento);
}
