package com.itson.dominio;

import org.bson.types.ObjectId;

public class Vehiculo {
    
    private ObjectId id;
    private String marca;
    private String modelo;
    private int año;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, int año) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }

    public Vehiculo(ObjectId id, String marca, String modelo, int año) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
    
    
    

}
