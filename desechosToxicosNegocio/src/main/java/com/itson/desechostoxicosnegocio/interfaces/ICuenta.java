/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.desechostoxicosnegocio.interfaces;

import com.itson.dominio.Cuenta;

public interface ICuenta {
     Cuenta insertarCuenta(Cuenta cuenta) throws Exception;
    
    Cuenta iniciarSesion(Cuenta cuenta) throws Exception; 
    
  
}
