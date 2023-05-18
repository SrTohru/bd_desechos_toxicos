package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.desechostoxicospersistencia.utilities.ConfiguracionDePaginado;
import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.Productores;
import com.itson.dominio.Quimicos;
import com.itson.dominio.Residuos;
import java.util.List;

public interface IResiduos {

    Residuos insertarResiduo(Residuos elemento) throws Exception;

    Residuos consultarResiduo(Residuos elemento) throws Exception;
        
    List<Residuos> consultarResiduos(List<Residuos> residuos) throws Exception;
    
    List<Residuos> consultarResiduo(ConfiguracionDePaginado configuracionDePaginado) throws Exception;
    
    List<Residuos> consultarResiduosPorProductor(Productores productor) throws Exception; 
            
    Residuos eliminarResiduo(Residuos elemento) throws Exception;

    Residuos actualizarResiduo(Residuos elemento) throws Exception;
}
