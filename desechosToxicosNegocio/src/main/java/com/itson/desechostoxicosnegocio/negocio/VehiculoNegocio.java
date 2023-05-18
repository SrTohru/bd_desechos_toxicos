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
    public Vehiculo consultarAutoPorEmpresa(EmpresaTransportista emp) throws Exception {

        return this.vehiculoDAO.consultarAutoPorEmpresa(emp);

    }

    @Override
    public List<Vehiculo> consultarAutosPorEmpresa(EmpresaTransportista emp) throws Exception {

        return this.vehiculoDAO.consultarAutosPorEmpresa(emp);

    }
    
    
    

}
