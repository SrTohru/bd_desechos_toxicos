/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.itson.presentacion;

import com.itson.desechostoxicospersistencia.dao.AdministradorDAO;
import com.itson.desechostoxicospersistencia.dao.CuentaDAO;
import com.itson.desechostoxicospersistencia.dao.EmpresaTransportistaDAO;
import com.itson.desechostoxicospersistencia.dao.ProductoresDAO;
import com.itson.desechostoxicospersistencia.utilities.insercionMasiva;
import com.itson.dominio.Administrador;
import com.itson.dominio.Cuenta;
import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.Productores;
import com.itson.dominio.utilities.tiposDeCuenta;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class LoginForm extends javax.swing.JFrame {

    ProductoresDAO pDAO = new ProductoresDAO();
    AdministradorDAO aDAO = new AdministradorDAO();
    EmpresaTransportistaDAO eDAO = new EmpresaTransportistaDAO();

    public LoginForm() {
        initComponents();
    }

    private void verContrasenia() {
        if (btnVerContrasenia.isSelected()) {
            txtContrasenia.setEchoChar((char) 0); // mostrar texto
        } else {
            txtContrasenia.setEchoChar('*'); // ocultar texto
        }
    }
//
//    private void realizarLogin() throws Exception {
//        if (!txtUsuario.getText().isBlank() && !txtContrasenia.getText().isBlank()) {
//            Productores productores = new Productores();
//            Cuenta cuenta = new Cuenta(txtContrasenia.getText(), txtUsuario.getText(), comboboxTipoCuenta.getSelectedItem().toString());
//            productores.setCuenta(cuenta);
//            productores = pDAO.iniciarSesion(productores);
//
//            Administrador admin = new Administrador();
//            Cuenta cuentaAdmin = new Cuenta(txtContrasenia.getText(), txtUsuario.getText(), comboboxTipoCuenta.getSelectedItem().toString());
//            admin.setCuenta(cuentaAdmin);
//            admin = aDAO.iniciarSesion(admin);
//
//            EmpresaTransportista empresa = new EmpresaTransportista();
//            Cuenta cuentaEmpresa = new Cuenta(txtContrasenia.getText(), txtUsuario.getText(), comboboxTipoCuenta.getSelectedItem().toString());
//            empresa.setCuenta(cuentaEmpresa);
//            empresa = eDAO.iniciarSesion(empresa);
//
//            if (productores != null || admin != null || empresa != null) {
//                JOptionPane.showMessageDialog(null, "Se inicio sesion");
//                if (productores != null) {
//                    MenuPrincipalForm menu = new MenuPrincipalForm(cuenta);
//                    menu.setCuenta(cuenta);
//                    menu.setVisible(true);
//                    this.dispose();
//                }
//                if (admin != null) {
//                    MenuPrincipalForm menu = new MenuPrincipalForm(cuentaAdmin);
//                    menu.setCuenta(cuentaAdmin);
//                    menu.setVisible(true);
//                    this.dispose();
//                }
//                if (empresa != null) {
//                    MenuPrincipalForm menu = new MenuPrincipalForm(cuentaEmpresa);
//                    menu.setCuenta(cuentaEmpresa);
//                    menu.setVisible(true);
//                    this.dispose();
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "Datos incorrectos", "Error Campos Invalidos", JOptionPane.ERROR_MESSAGE);
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Campos vacios", "Error Campos Invalidos", JOptionPane.ERROR_MESSAGE);
//        }
//    }

    private void realizarLogin() throws Exception {
        String tipoCuenta = comboboxTipoCuenta.getSelectedItem().toString();
        String usuario = txtUsuario.getText();
        String contrasenia = txtContrasenia.getText();

        if (usuario.isBlank() || contrasenia.isBlank()) {
            JOptionPane.showMessageDialog(null, "Campos vacíos", "Error Campos Inválidos", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (tipoCuenta.equals("Administrador")) {
            Administrador admin = new Administrador();
            Cuenta cuenta = new Cuenta(contrasenia, usuario, tipoCuenta);
            admin.setCuenta(cuenta);
            admin = aDAO.iniciarSesion(admin);

            if (admin != null) {
                JOptionPane.showMessageDialog(null, "Se inició sesión como Administrador");
                MenuPrincipalForm menu = new MenuPrincipalForm(cuenta);
                menu.setCuenta(cuenta);
                menu.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Datos incorrectos", "Error Campos Inválidos", JOptionPane.ERROR_MESSAGE);
            }
        } else if (tipoCuenta.equals("EmpresaTransportista")) {
            EmpresaTransportista admin = new EmpresaTransportista();
            Cuenta cuenta = new Cuenta(contrasenia, usuario, tipoCuenta);
            admin.setCuenta(cuenta);
            admin = eDAO.iniciarSesion(admin);

            if (admin != null) {
                JOptionPane.showMessageDialog(null, "Se inició sesión como EmpresaTransportista");
                MenuPrincipalForm menu = new MenuPrincipalForm(cuenta);
                menu.setCuenta(cuenta);
                menu.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Datos incorrectos", "Error Campos Inválidos", JOptionPane.ERROR_MESSAGE);
            }

        } else if (tipoCuenta.equals("Productor")) {
            Productores admin = new Productores();
            Cuenta cuenta = new Cuenta(contrasenia, usuario, tipoCuenta);
            admin.setCuenta(cuenta);
            admin = pDAO.iniciarSesion(admin);

            if (admin != null) {
                JOptionPane.showMessageDialog(null, "Se inició sesión como Productor");
                MenuPrincipalForm menu = new MenuPrincipalForm(cuenta);

                menu.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Datos incorrectos", "Error Campos Inválidos", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Tipo de cuenta inválido", "Error Campos Inválidos", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void insertarCuentas() throws Exception {
        insercionMasiva in = new insercionMasiva();

        JOptionPane.showMessageDialog(null, "Se realizó inserciones masivas de 'Residuos', 'Productores', 'Administradores', 'Quimicos', y 'EmpresasTransportistas con Vehiculos");

        in.insercioResiduos();
        in.insercionMasivaProductores();
        in.insercionAdministrador();
        in.insercionQuimicos();
        in.insercionMasivaDeVehiculosYEmpresas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsuario = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnVerContrasenia = new javax.swing.JToggleButton();
        comboboxTipoCuenta = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnInsertarCuentas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(51, 153, 255));
        setResizable(false);

        txtUsuario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtContrasenia.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Usuario");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Contraseña");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Bienvenido");

        btnLogin.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnVerContrasenia.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnVerContrasenia.setText("Ver");
        btnVerContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerContraseniaActionPerformed(evt);
            }
        });

        comboboxTipoCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Productor", "EmpresaTransportista", "Administrador" }));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setText("Tipo de cuenta");

        btnInsertarCuentas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnInsertarCuentas.setText("Insercion masiva general");
        btnInsertarCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarCuentasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnInsertarCuentas)
                        .addContainerGap())
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboboxTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerContrasenia)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLogin)
                        .addGap(45, 45, 45)))
                .addGap(0, 85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel3)
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVerContrasenia)
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboboxTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(btnInsertarCuentas)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerContraseniaActionPerformed
        // TODO add your handling code here:
        this.verContrasenia();
    }//GEN-LAST:event_btnVerContraseniaActionPerformed


    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        try {
            // TODO add your handling code here:
            this.realizarLogin();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnInsertarCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarCuentasActionPerformed
        try {
            // TODO add your handling code here:
            this.insertarCuentas();
        } catch (Exception ex) {
         JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnInsertarCuentasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsertarCuentas;
    private javax.swing.JButton btnLogin;
    private javax.swing.JToggleButton btnVerContrasenia;
    private javax.swing.JComboBox<String> comboboxTipoCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
