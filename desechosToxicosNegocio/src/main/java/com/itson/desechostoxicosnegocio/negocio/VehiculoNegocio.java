/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.desechostoxicosnegocio.negocio;

import com.itson.desechostoxicosnegocio.interfaces.IVehiculo;
import com.itson.desechostoxicospersistencia.dao.VehiculoDAO;
import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.Vehiculo;
import java.util.List;
import javax.swing.JOptionPane;

public class VehiculoNegocio implements IVehiculo {

    private VehiculoDAO vehiculoDAO;

    public VehiculoNegocio() {
        this.vehiculoDAO = new VehiculoDAO();
    }

    @Override
    public Vehiculo insertarElemento(Vehiculo v) {
        try {
            return this.vehiculoDAO.insertarElemento(v);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al ingresar el vehiculo");
            return null;
        }
    }

    @Override
    public List<Vehiculo> insertarElementoEnLista(List<Vehiculo> v) {
       try {
            return this.vehiculoDAO.insertarElementoEnLista(v);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al insertar los vehiculo");
            return null;
        }}

    @Override
    public Vehiculo consultarAutoPorEmpresa(EmpresaTransportista emp) {
      try {
            return this.vehiculoDAO.consultarAutoPorEmpresa(emp);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al consultar el vehiculo por empresa");
            return null;
        } }

    @Override
    public List<Vehiculo> consultarAutosPorEmpresa(EmpresaTransportista emp) {
       try {
            return this.vehiculoDAO.consultarAutosPorEmpresa(emp);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al consultar los vehiculos por empresa");
            return null;
        }}

}
