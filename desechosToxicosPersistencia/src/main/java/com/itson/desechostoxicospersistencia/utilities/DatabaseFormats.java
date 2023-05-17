package com.itson.desechostoxicospersistencia.utilities;

public class DatabaseFormats {
    private final String EMPRESA_TRANSPORTISTA_COLLECTION = "EmpresaTransportista";
    private final String PRODUCTORES_COLLECTION = "Productores";
    private final String REGISTRO_TRASLADO = "RegistroTraslado";
    private final String RESIDUOS = "Residuos";
    private final String TRASLADOS = "Traslados";
    private final String VEHICULO = "Vehiculo";
    private final String QUIMICOS = "Quimicos";
    private final String CUENTA = "Cuentas";

    public String getEMPRESA_TRANSPORTISTA_COLLECTION() {
        return EMPRESA_TRANSPORTISTA_COLLECTION;
    }

    public String getPRODUCTORES_COLLECTION() {
        return PRODUCTORES_COLLECTION;
    }

    public String getREGISTRO_TRASLADO() {
        return REGISTRO_TRASLADO;
    }

    public String getRESIDUOS() {
        return RESIDUOS;
    }

    public String getTRASLADOS() {
        return TRASLADOS;
    }

    public String getVEHICULO() {
        return VEHICULO;
    }

    public String getQUIMICOS() {
        return QUIMICOS;
    }

    public String getCUENTA() {
        return CUENTA;
    }
    
    
    
}
