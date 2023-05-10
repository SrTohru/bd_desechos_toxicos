/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

/**
 *
 * @author Usuario
 */
public class Productores {
    
    private Productos producto;
    private Residuos residuo;
    private String nombre;

    public Productores() {
    }

    public Productores(String nombre) {
        this.nombre = nombre;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public Residuos getResiduo() {
        return residuo;
    }

    public void setResiduo(Residuos residuo) {
        this.residuo = residuo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
