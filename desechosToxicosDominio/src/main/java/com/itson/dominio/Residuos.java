package com.itson.dominio;

import org.bson.types.ObjectId;

public class Residuos {

    private ObjectId id;
    private String nombre;
    private String codigo;
    private boolean peligroso;
    private Quimicos quimico;

    public Residuos() {
    }

    public Residuos(String nombre, String codigo, boolean peligroso, Quimicos quimico) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.peligroso = peligroso;
        this.quimico = quimico;
    }

    public Residuos(ObjectId id, String nombre, String codigo, boolean peligroso, Quimicos quimico) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.peligroso = peligroso;
        this.quimico = quimico;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
