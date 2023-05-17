/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import com.itson.dominio.utilities.tiposDeCuenta;
import org.bson.types.ObjectId;

public class Cuenta {

    private ObjectId id;
    private String usuario;
    private String contrasena;
    private tiposDeCuenta tipoCuenta;

    public Cuenta() {
    }

    public Cuenta(String contrasena, String usuario, tiposDeCuenta tipoCuenta) {
        this.contrasena = contrasena;
        this.usuario = usuario;
        this.tipoCuenta = tipoCuenta;
    }

    public Cuenta(ObjectId id, String contrasena, String usuario, tiposDeCuenta tipoCuenta) {
        this.id = id;
        this.contrasena = contrasena;
        this.usuario = usuario;
        this.tipoCuenta = tipoCuenta;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public tiposDeCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(tiposDeCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

}
