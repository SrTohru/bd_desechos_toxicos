/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import com.itson.dominio.utilities.estadoTraslado;
import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author PC
 */
public class RegistroTraslado {

    private ObjectId id;
    private Traslado taslado;
    private Vehiculo vehiculo;
    private int kilometrosRecorridos;
    private double costo;
    private Date fechaLlegada;
    private String tratamiento;
    private String estadoTraslado;
            
            
    public RegistroTraslado() {
    }

    public RegistroTraslado(Traslado taslado, int kilometrosRecorridos, double costo, Date fechaLlegada, String tratamiento, String estadoTraslado) {
        this.taslado = taslado;
        this.kilometrosRecorridos = kilometrosRecorridos;
        this.costo = costo;
        this.fechaLlegada = fechaLlegada;
        this.tratamiento = tratamiento;
        this.estadoTraslado = estadoTraslado;
    }

    
    
    public RegistroTraslado(Traslado taslado, Vehiculo vehiculo, int kilometrosRecorridos, double costo, Date fechaLlegada, String tratamiento, String estadoTraslado) {
        this.taslado = taslado;
        this.vehiculo = vehiculo;
        this.kilometrosRecorridos = kilometrosRecorridos;
        this.costo = costo;
        this.fechaLlegada = fechaLlegada;
        this.tratamiento = tratamiento;
        this.estadoTraslado = estadoTraslado;
    }

    public RegistroTraslado(ObjectId id, Traslado taslado, Vehiculo vehiculo, int kilometrosRecorridos, double costo, Date fechaLlegada, String tratamiento, String estadoTraslado) {
        this.id = id;
        this.taslado = taslado;
        this.vehiculo = vehiculo;
        this.kilometrosRecorridos = kilometrosRecorridos;
        this.costo = costo;
        this.fechaLlegada = fechaLlegada;
        this.tratamiento = tratamiento;
        this.estadoTraslado = estadoTraslado;
    }

    public String getEstadoTraslado() {
        return estadoTraslado;
    }

    public void setEstadoTraslado(String estadoTraslado) {
        this.estadoTraslado = estadoTraslado;
    }



    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Traslado getTaslado() {
        return taslado;
    }

    public void setTaslado(Traslado taslado) {
        this.taslado = taslado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }

    public void setKilometrosRecorridos(int kilometrosRecorridos) {
        this.kilometrosRecorridos = kilometrosRecorridos;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

}
