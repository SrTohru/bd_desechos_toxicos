package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.desechostoxicospersistencia.utilities.ConfiguracionDePaginado;
import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.Productores;
import com.itson.dominio.Quimicos;
import com.itson.dominio.Residuos;
import java.util.List;

public interface IResiduos {

    Residuos insertarElemento(Residuos elemento) throws Exception;

    List<Residuos> consultarElemento(ConfiguracionDePaginado configuracionDePaginado) throws Exception;
    
    List<Residuos> consultarElementosPorProductor(Productores productor) throws Exception; 
            
    Residuos eliminarElemento(Residuos elemento) throws Exception;

    Residuos actualizarElemento(Residuos elemento) throws Exception;
}
