/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.desechostoxicospersistencia.interfaces;

import com.itson.dominio.Cuenta;
import com.itson.dominio.utilities.tiposDeCuenta;

public interface ICuenta {

    Cuenta insertarCuenta(Cuenta cuenta) throws Exception;

    Cuenta iniciarSesion(Cuenta cuenta) throws Exception;

    
}
