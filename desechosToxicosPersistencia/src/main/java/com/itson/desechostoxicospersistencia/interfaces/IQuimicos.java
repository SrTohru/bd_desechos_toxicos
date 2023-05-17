package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.desechostoxicospersistencia.utilities.ConfiguracionDePaginado;
import com.itson.dominio.Quimicos;
import java.util.List;

public interface IQuimicos {

    List<Quimicos> consultarQuimicosGenerales(ConfiguracionDePaginado configuracionDePaginado) throws Exception;
    
    Quimicos consultarQuimico(Quimicos quimico) throws Exception;
     
    Quimicos insertarQuimico(Quimicos quimico) throws Exception;
     
    void eliminarQuimico(Quimicos elemento) throws Exception;

}
