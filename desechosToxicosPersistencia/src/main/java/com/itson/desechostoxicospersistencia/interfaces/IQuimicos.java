package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.desechostoxicospersistencia.utilities.ConfiguracionDePaginado;
import com.itson.dominio.Quimicos;
import java.util.List;

public interface IQuimicos {

    List<Quimicos> consultarQuimicosGenerales(ConfiguracionDePaginado configuracionDePaginado);
    
    Quimicos consultarQuimico(Quimicos quimico);
    
    Quimicos insertarQuimico(Quimicos quimico);
    
    void eliminarQuimico(Quimicos elemento);

}
