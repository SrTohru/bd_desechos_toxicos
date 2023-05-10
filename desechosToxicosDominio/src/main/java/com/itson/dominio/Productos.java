/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

/**
 *
 * @author Usuario
 */
public class Productos {
    
    private Productores productores;
    private Residuos residuo;
    private String nombre;
    private float precio;

    public Productos() {
    }

    public Productos(Residuos residuo, String nombre, float precio) {
        this.residuo = residuo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Productores getProductores() {
        return productores;
    }

    public void setProductores(Productores productores) {
        this.productores = productores;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
}
