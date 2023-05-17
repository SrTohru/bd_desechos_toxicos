package com.itson.dominio;

import org.bson.types.ObjectId;

public class Residuos {

    private ObjectId id;
    private String nombre;
    private boolean peligroso;
    private Quimicos quimico;

    public Residuos() {
    }

    public Residuos(String nombre, boolean peligroso, Quimicos quimico) {
        this.nombre = nombre;
        this.peligroso = peligroso;
        this.quimico = quimico;
    }

    public Residuos(ObjectId id, String nombre, boolean peligroso, Quimicos quimico) {
        this.id = id;
        this.nombre = nombre;
        this.quimico = quimico;
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

    public Quimicos getQuimico() {
        return quimico;
    }

    public void setQuimico(Quimicos quimico) {
        this.quimico = quimico;
    }

}
