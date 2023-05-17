/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Usuario
 */
public class Productores {

    private ObjectId id;
    private String nombre;
    private List<Residuos> residuos;
    private Cuenta cuenta;
    
    public Productores() {
    }

    public Productores(String nombre, List<Residuos> residuos, Cuenta cuenta) {
        this.nombre = nombre;
        this.residuos = residuos;
        this.cuenta = cuenta;
    }

    public Productores(ObjectId id, String nombre, List<Residuos> residuos, Cuenta cuenta) {
        this.id = id;
        this.nombre = nombre;
        this.residuos = residuos;
        this.cuenta = cuenta;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Residuos> getResiduos() {
        return residuos;
    }

    public void setResiduos(List<Residuos> residuos) {
        this.residuos = residuos;
    }

}
