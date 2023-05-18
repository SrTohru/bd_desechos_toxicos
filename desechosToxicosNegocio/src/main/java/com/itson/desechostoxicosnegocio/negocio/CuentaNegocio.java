package com.itson.desechostoxicosnegocio.negocio;

import com.itson.desechostoxicosnegocio.interfaces.ICuenta;
import com.itson.desechostoxicospersistencia.dao.CuentaDAO;
import com.itson.dominio.Cuenta;

public class CuentaNegocio implements ICuenta {

    private final CuentaDAO cuentaDAO;

    public CuentaNegocio() {
        this.cuentaDAO = new CuentaDAO();
    }

    @Override
    public Cuenta insertarCuenta(Cuenta cuenta) throws Exception {
        validarCuenta(cuenta);
        return cuentaDAO.insertarCuenta(cuenta);
    }

    @Override
    public Cuenta iniciarSesion(Cuenta cuenta) throws Exception {
        validarCuenta(cuenta);
        return cuentaDAO.iniciarSesion(cuenta);
    }

    private void validarCuenta(Cuenta cuenta) throws Exception {
        if (cuenta == null) {
            throw new Exception("La cuenta no puede ser nula");
        }
        if (cuenta.getUsuario() == null || cuenta.getUsuario().isEmpty()) {
            throw new Exception("El usuario de la cuenta es requerido");
        }
        if (cuenta.getContrasena() == null || cuenta.getContrasena().isEmpty()) {
            throw new Exception("La contraseña de la cuenta es requerida");
        }
        if (cuenta.getTipoCuenta() == null || cuenta.getTipoCuenta().isEmpty()) {
            throw new Exception("El tipo de cuenta es requerido");
        }
    }

}
