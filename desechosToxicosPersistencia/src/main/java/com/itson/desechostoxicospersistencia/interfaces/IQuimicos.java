package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.desechostoxicospersistencia.utilities.ConfiguracionDePaginado;
import com.itson.dominio.Quimicos;
import java.util.List;

public interface IQuimicos {
    
    
    List<Quimicos> consultarQuimicosGenerales(ConfiguracionDePaginado configuracionDePaginado);
    Quimicos insertarQuimicos(Quimicos quimicos);
}
