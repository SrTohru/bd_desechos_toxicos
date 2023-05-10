/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

/**
 *
 * @author Usuario
 */
class EmpresaTransportista {
    
    private Traslado traslado;
    private String nombre;

    public EmpresaTransportista() {
    }

    public EmpresaTransportista(String nombre) {
        this.nombre = nombre;
    }

    public Traslado getTraslado() {
        return traslado;
    }

    public void setTraslado(Traslado traslado) {
        this.traslado = traslado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    } 
}
