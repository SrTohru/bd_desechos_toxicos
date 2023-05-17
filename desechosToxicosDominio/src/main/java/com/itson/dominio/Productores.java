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

    public Productores() {
    }

    public Productores(String nombre, List<Residuos> residuos) {
        this.nombre = nombre;
        this.residuos = residuos;
    }
    
    public Productores(ObjectId id, String nombre , List<Residuos> residuos) {
        this.id = id;
        this.nombre = nombre;
        this.residuos = residuos;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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
