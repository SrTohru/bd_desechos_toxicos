/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.itson.presentacion;

import com.itson.desechostoxicosnegocio.fachada.FachadaNegocio;
import com.itson.dominio.Cuenta;
import com.itson.dominio.Productores;
import com.itson.dominio.Residuos;
import com.itson.dominio.Traslado;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.types.ObjectId;

/**
 *
 * @author Usuario
 */
public class AsignarTrasladosForm extends javax.swing.JFrame {

    private Cuenta cuenta;
    FachadaNegocio fachadaNegocio;
    private Residuos residuoSeleccionado;

    public AsignarTrasladosForm(Cuenta cuenta) {
        initComponents();
        this.fachadaNegocio = new FachadaNegocio();
        this.cuenta = cuenta;
        añadirTodasLasEmpresasALaLista();
     
    }


    

    private void añadirTodasLasEmpresasALaLista() {
        try {
            DefaultTableModel modeloTabla = (DefaultTableModel) tableDeProducotresConResiduos.getModel();
            modeloTabla.setRowCount(0);

            List<Traslado> listaTraslados = fachadaNegocio.consultarTraslados();

            for (Traslado traslado : listaTraslados) {
                // Obtener el productor, la fecha de solicitud y los residuos del traslado

                String productor = obtenerNombreProductor(traslado.getProductorId());

                Date fechaSolicitud = traslado.getFecha();
                List<Residuos> residuos = traslado.getResiduos();

                // Crear una nueva fila con los valores del traslado
                Object[] fila = {
                    productor,
                    fechaSolicitud,
                    obtenerNombresResiduos(residuos)
                };

                // Agregar la fila a la tabla
                modeloTabla.addRow(fila);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private String obtenerNombreProductor(ObjectId productorId) throws Exception {
        Productores consultaProductor = new Productores();
        consultaProductor.setId(productorId);
        Productores productor = fachadaNegocio.consultarProductor(consultaProductor);
        if (productor != null) {
            return productor.getNombre();
        } else {
            throw new Exception("No se encontró el productor con ID: " + productorId);
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

    private void irMenuPrincipal() {
        new MenuPrincipalForm(this.cuenta).setVisible(true);
        this.dispose();
    }

    private void irAsignarEmpresaTraslado(Residuos residuo) {
        new AsignarEmpresaTrasladosForm(this.cuenta, residuo).setVisible(true);
        this.dispose();
    }

    private void obtenerResiduoSeleccionado() {
        if (residuoSeleccionado != null) {
            // Enviar el residuo seleccionado a otro formulario
           irAsignarEmpresaTraslado(residuoSeleccionado);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún residuo.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableDeProducotresConResiduos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAsignarEmpresa = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asignar Traslados");

        tableDeProducotresConResiduos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Productor", "Fecha Solicitada", "Residuos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableDeProducotresConResiduos);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Solicitudes de Traslado");

        btnAsignarEmpresa.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAsignarEmpresa.setText("Asignar Empresa");
        btnAsignarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarEmpresaActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRegresar.setText("<");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(btnRegresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAsignarEmpresa)
                .addGap(344, 344, 344))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnAsignarEmpresa)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        this.irMenuPrincipal();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAsignarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarEmpresaActionPerformed
        // TODO add your handling code here:
        obtenerResiduoSeleccionado();
    }//GEN-LAST:event_btnAsignarEmpresaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignarEmpresa;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDeProducotresConResiduos;
    // End of variables declaration//GEN-END:variables
}
