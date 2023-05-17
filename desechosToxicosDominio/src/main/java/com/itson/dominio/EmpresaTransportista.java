/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Usuario
 */
public class EmpresaTransportista {

    private ObjectId id;
    private String nombre;
    private boolean disponibilidad;
    private Cuenta cuenta;
    private List<Vehiculo> vehiculos;

    public EmpresaTransportista() {
    }

    public EmpresaTransportista(String nombre, List<Vehiculo> vehiculos) {
        this.nombre = nombre;
        this.vehiculos = vehiculos;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public EmpresaTransportista(ObjectId id, String nombre, List<Vehiculo> vehiculos) {
        this.id = id;
        this.nombre = nombre;
        this.vehiculos = vehiculos;
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

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "EmpresaTransportista{" + "id=" + id + ", nombre=" + nombre + ", vehiculos=" + vehiculos + '}';
    }

}
