/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

/**
 *
 * @author Usuario
 */
public class Residuos {
    
    private Productores productores;
    private Traslado traslado;
    private String codigo;
    private String tratamiento;

    public Residuos() {
    }

    public Residuos(String codigo, String tratamiento) {
        this.codigo = codigo;
        this.tratamiento = tratamiento;
    }

    public Productores getProductores() {
        return productores;
    }

    public void setProductores(Productores productores) {
        this.productores = productores;
    }

    public Traslado getTraslado() {
        return traslado;
    }

    public void setTraslado(Traslado traslado) {
        this.traslado = traslado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    } 
    
}
