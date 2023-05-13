package com.itson.dominio;
import org.bson.types.ObjectId;

public class Residuos {

    private ObjectId id;
    private String nombre;
    private boolean peligroso;

    public Residuos() {
    }

    public Residuos(String nombre, boolean peligroso) {
        this.nombre = nombre;
        this.peligroso = peligroso;
    }

    public Residuos(ObjectId id, String nombre, boolean peligroso) {
        this.id = id;
        this.nombre = nombre;
        this.peligroso = peligroso;
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

    public boolean isPeligroso() {
        return peligroso;
    }

    public void setPeligroso(boolean peligroso) {
        this.peligroso = peligroso;
    }

    
    
}