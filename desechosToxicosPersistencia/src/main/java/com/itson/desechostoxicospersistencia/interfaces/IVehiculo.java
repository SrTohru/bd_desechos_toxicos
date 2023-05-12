package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.desechostoxicospersistencia.utilities.DatabaseFormats;
import com.itson.dominio.Vehiculo;

public interface IVehiculo {

    Vehiculo insertarElemento(Vehiculo e, DatabaseFormats collectionName);

    Vehiculo consultarElemento(Vehiculo elemento, DatabaseFormats collectionName);

    Vehiculo eliminarElemento(Vehiculo elemento, DatabaseFormats collectionName);

    Vehiculo actualizarElemento(Vehiculo elemento, DatabaseFormats collectionName);
}
