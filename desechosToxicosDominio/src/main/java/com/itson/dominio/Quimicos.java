package com.itson.dominio;

import org.bson.types.ObjectId;

public class Quimicos {

    private ObjectId id;
    private String nombre;

    public Quimicos() {
    }

    public Quimicos(ObjectId id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Quimicos(String nombre) {
        this.nombre = nombre;
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
        

    

}
