package com.itson.dominio;

import java.util.List;
import org.bson.types.ObjectId;

public class Residuos {

    private ObjectId id;
    private Productores productor;
    private String nombre;
    private int codigo;
    private boolean peligroso;
    private List<Quimicos> quimico;

    public Residuos() {
    }

    public Residuos(Productores productor, String nombre, int codigo, boolean peligroso, List<Quimicos> quimico) {
        this.productor = productor;
        this.nombre = nombre;
        this.codigo = codigo;
        this.peligroso = peligroso;
        this.quimico = quimico;
    }

    public Residuos(ObjectId id, Productores productor, String nombre, int codigo, boolean peligroso, List<Quimicos> quimico) {
        this.id = id;
        this.productor = productor;
        this.nombre = nombre;
        this.codigo = codigo;
        this.peligroso = peligroso;
        this.quimico = quimico;
    }

    public Productores getProductor() {
        return productor;
    }

    public void setProductor(Productores productor) {
        this.productor = productor;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isPeligroso() {
        return peligroso;
    }

    public void setPeligroso(boolean peligroso) {
        this.peligroso = peligroso;
    }

    public List<Quimicos> getQuimico() {
        return quimico;
    }

    public void setQuimico(List<Quimicos> quimico) {
        this.quimico = quimico;
    }

}
