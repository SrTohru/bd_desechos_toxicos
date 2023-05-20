/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.itson.presentacion;

import com.itson.desechostoxicosnegocio.fachada.FachadaNegocio;
import com.itson.dominio.Cuenta;
import com.itson.dominio.EmpresaTransportista;
import com.itson.dominio.Residuos;
import com.itson.dominio.Traslado;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TrasladosAsignadosForm extends javax.swing.JFrame {

    private Cuenta cuenta;
    FachadaNegocio fachadaNegocio;

    public TrasladosAsignadosForm(Cuenta cuenta) throws Exception {
        initComponents();
        fachadaNegocio = new FachadaNegocio();
        this.cuenta = cuenta;
        this.añadirTodasLasEmpresasALaLista();

    }

 private void añadirTodasLasEmpresasALaLista() {
    try {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaTrasladosAsignados.getModel();
        modeloTabla.setRowCount(0);

        List<Traslado> listaTraslados = fachadaNegocio.consultarTraslados();

        for (Traslado traslado : listaTraslados) {
            // Obtener la fecha, el residuo, la cantidad y el productor del traslado
            Date fecha = traslado.getFecha();
            List<Residuos> residuos = traslado.getResiduos();
            float cantidad = traslado.getKilos() + traslado.getLitros();
            String productor = "asd"; // Debes obtener el nombre del productor aquí

            // Crear una nueva fila con los valores del traslado
            Object[] fila = {
                fecha,
                "asd",
                cantidad,
                productor
            };

            // Agregar la fila a la tabla
            modeloTabla.addRow(fila);
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage());
        
    }
}

private String obtenerNombresResiduos(List<Residuos> residuos) {
    StringBuilder nombres = new StringBuilder();
    for (Residuos residuo : residuos) {
        nombres.append(residuo.getNombre()).append(", ");
    }
    if (nombres.length() > 0) {
        nombres.delete(nombres.length() - 2, nombres.length());
    }
    return nombres.toString();
}
    private void irRegistrarTrasladoForm() {
        RegistrarTrasladoForm rt = new RegistrarTrasladoForm(this.cuenta);
        rt.setVisible(true);
        this.dispose();
    }

    private void irMenuPrincipal() {
        new MenuPrincipalForm(this.cuenta).setVisible(true);
        this.dispose();
    }

    public List<EmpresaTransportista> consultarTodasLasEmpresas() throws Exception {
        return fachadaNegocio.consultarTodasLasEmpresas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTrasladosAsignados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Traslados Asignados");

        tablaTrasladosAsignados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha Solicitada", "Residuo", "Cantidad", "Productor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaTrasladosAsignados);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Traslados asignados");

        btnRegresar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRegresar.setText("<");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnRegistrar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresar))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnRegresar)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(btnRegistrar)
                .addGap(29, 29, 29))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        this.irRegistrarTrasladoForm();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
      añadirTodasLasEmpresasALaLista();
      //  this.irMenuPrincipal();
    }//GEN-LAST:event_btnRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTrasladosAsignados;
    // End of variables declaration//GEN-END:variables
}
