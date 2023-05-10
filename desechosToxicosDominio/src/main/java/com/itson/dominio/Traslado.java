/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.dominio;

/**
 *
 * @author Usuario
 */
public class Traslado {
    
    private EmpresaTransportista empresa;
    private String destino;
    private String medioDeTransporte;
    private int numVehiculos;
    private float kilometrosRealizados;
    private float coste;
    private String fechaLlegada;

    public Traslado() {
    }

    public Traslado(String destino, String medioDeTransporte, int numVehiculos, float kilometrosRealizados, float coste, String fechaLlegada) {
        this.destino = destino;
        this.medioDeTransporte = medioDeTransporte;
        this.numVehiculos = numVehiculos;
        this.kilometrosRealizados = kilometrosRealizados;
        this.coste = coste;
        this.fechaLlegada = fechaLlegada;
    }

    public EmpresaTransportista getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaTransportista empresa) {
        this.empresa = empresa;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getMedioDeTransporte() {
        return medioDeTransporte;
    }

    public void setMedioDeTransporte(String medioDeTransporte) {
        this.medioDeTransporte = medioDeTransporte;
    }

    public int getNumVehiculos() {
        return numVehiculos;
    }

    public void setNumVehiculos(int numVehiculos) {
        this.numVehiculos = numVehiculos;
    }

    public float getKilometrosRealizados() {
        return kilometrosRealizados;
    }

    public void setKilometrosRealizados(float kilometrosRealizados) {
        this.kilometrosRealizados = kilometrosRealizados;
    }

    public float getCoste() {
        return coste;
    }

    public void setCoste(float coste) {
        this.coste = coste;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }
    
}
