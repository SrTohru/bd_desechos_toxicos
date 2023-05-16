package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.dominio.Quimicos;
import java.util.List;

public interface IQuimicos {
    
    
    List<Quimicos> consultarQuimicosGenerales();
    Quimicos insertarQuimicos(Quimicos quimicos);
}
