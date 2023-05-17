/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.itson.presentacion;

import com.itson.desechostoxicospersistencia.dao.ResiduosDAO;
import com.itson.desechostoxicospersistencia.interfaces.IResiduos;
import com.itson.desechostoxicospersistencia.utilities.ConfiguracionDePaginado;
import com.itson.dominio.Cuenta;
import com.itson.dominio.Residuos;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class SolicitarTrasladoForm extends javax.swing.JFrame {

    private static final Logger LOG = Logger.getLogger(SolicitarTrasladoForm.class.getName());
    private ConfiguracionDePaginado configuracionDePaginado;
    private IResiduos residuosDAO;
    private Cuenta cuenta;
    
    /**
     * Creates new form SolicitarTrasladoForm
     */
    public SolicitarTrasladoForm(Cuenta cuenta) {
        this.configuracionDePaginado = new ConfiguracionDePaginado(0, 5);      
        initComponents();
        this.cuenta = cuenta;
        this.deshabilitarCamposLitros();
        this.deshabilitarCamposKilos();
        this.residuosDAO = new ResiduosDAO();
        this.llenarTablaResiduosDisponibles();
    }

    private void deshabilitarCamposLitros(){
        if (checkLitros.isSelected()) {
            txtLitros.setEnabled(true);
        } else {          
            txtLitros.setEnabled(false);
        }
    }
    
    private void deshabilitarCamposKilos(){
        if (checkKilos.isSelected()) {
            txtKilos.setEnabled(true);
        } else {          
            txtKilos.setEnabled(false);
        }
    }

    
    private void irMenuPrincipal(){
        MenuPrincipalForm menu = new MenuPrincipalForm(this.cuenta);
        menu.setVisible(true);
        this.dispose();
    }
    
    private void llenarTablaResiduosDisponibles(){
        try {
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tableResiduosDisponibles.getModel();
            List<Residuos> listaResiduos = residuosDAO.consultarElemento(this.configuracionDePaginado);
            modeloTabla.setRowCount(0);
            for (Residuos r : listaResiduos) {
                Object[] fila = {
                    r.getNombre(),};
                modeloTabla.addRow(fila);
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
    }
    
    private void llenarTablaResiduoSeleccionado() {
        try {
            // Obtener el modelo de la tabla de origen y de destino
            DefaultTableModel modeloOrigen = (DefaultTableModel) tableResiduosDisponibles.getModel();
            DefaultTableModel modeloDestino = (DefaultTableModel) tableResiduosSeleccionados.getModel();

            // Obtener el índice de la fila seleccionada en la tabla de origen
            int filaSeleccionada = tableResiduosDisponibles.getSelectedRow();

            // Obtener la instancia de la fila seleccionada en la tabla de origen
            Object[] fila = new Object[modeloOrigen.getColumnCount()];
            for (int i = 0; i < modeloOrigen.getColumnCount(); i++) {
                fila[i] = modeloOrigen.getValueAt(filaSeleccionada, i);
            }

            // Agregar la fila a la tabla de destino
            modeloDestino.addRow(fila);

            // Eliminar la fila de la tabla de origen
            modeloOrigen.removeRow(filaSeleccionada);

            // Actualizar las vistas de las tablas
            tableResiduosDisponibles.repaint();
            tableResiduosSeleccionados.repaint();
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
    }
    
    private void regresarResiduoSeleccionado() {
        try {
            // Obtener el modelo de la tabla de origen y de destino
            DefaultTableModel modeloOrigen = (DefaultTableModel) tableResiduosSeleccionados.getModel();
            DefaultTableModel modeloDestino = (DefaultTableModel) tableResiduosDisponibles.getModel();

            // Obtener el índice de la fila seleccionada en la tabla de origen
            int filaSeleccionada = tableResiduosSeleccionados.getSelectedRow();

            // Obtener la instancia de la fila seleccionada en la tabla de origen
            Object[] fila = new Object[modeloOrigen.getColumnCount()];
            for (int i = 0; i < modeloOrigen.getColumnCount(); i++) {
                fila[i] = modeloOrigen.getValueAt(filaSeleccionada, i);
            }

            // Agregar la fila a la tabla de destino
            modeloDestino.addRow(fila);

            // Eliminar la fila de la tabla de origen
            modeloOrigen.removeRow(filaSeleccionada);

            // Actualizar las vistas de las tablas
            tableResiduosSeleccionados.repaint();
            tableResiduosDisponibles.repaint();
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
    }
    
    /**
     * Metodo para avanzar de pagina en la tabla de la consulta de personas
     */
    public void avanzarPagina() {
        this.configuracionDePaginado.avanzarPagina();
        this.llenarTablaResiduosDisponibles();
    }

    /**
     * Metodo para retroceder de pagina en la tabla de la consulta de personas
     */
    public void retrocederPagina() {
        this.configuracionDePaginado.retrocederPagina();
        this.llenarTablaResiduosDisponibles();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableResiduosSeleccionados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnElegir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableResiduosDisponibles = new javax.swing.JTable();
        btnQuitar = new javax.swing.JButton();
        txtKilos = new javax.swing.JTextField();
        txtLitros = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        checkKilos = new javax.swing.JCheckBox();
        checkLitros = new javax.swing.JCheckBox();
        btnSolicitarTraslado = new javax.swing.JButton();
        btnRetrocederDisponibles = new javax.swing.JButton();
        btnAvanzarDisponible = new javax.swing.JButton();
        btnRetrocederSeleccionado = new javax.swing.JButton();
        btnAvanzarSeleccionado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Solicitar Traslado");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Fecha del Traslado");

        tableResiduosSeleccionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Residuo", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableResiduosSeleccionados);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lista de residuos seleccionados");

        btnElegir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnElegir.setText("Elegir");
        btnElegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Lista de residuos disponibles");

        tableResiduosDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Residuo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableResiduosDisponibles);

        btnQuitar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        txtKilos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtLitros.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        btnRegresar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRegresar.setText("<");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        checkKilos.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        checkKilos.setText("Kilos");
        checkKilos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkKilosActionPerformed(evt);
            }
        });

        checkLitros.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        checkLitros.setText("Litros");
        checkLitros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkLitrosActionPerformed(evt);
            }
        });

        btnSolicitarTraslado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnSolicitarTraslado.setText("Solicitar Traslado");

        btnRetrocederDisponibles.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRetrocederDisponibles.setText("<");
        btnRetrocederDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederDisponiblesActionPerformed(evt);
            }
        });

        btnAvanzarDisponible.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAvanzarDisponible.setText(">");
        btnAvanzarDisponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarDisponibleActionPerformed(evt);
            }
        });

        btnRetrocederSeleccionado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRetrocederSeleccionado.setText("<");

        btnAvanzarSeleccionado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAvanzarSeleccionado.setText(">");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addComponent(btnSolicitarTraslado)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkKilos)
                            .addComponent(checkLitros)
                            .addComponent(txtLitros)
                            .addComponent(txtKilos)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90)
                        .addComponent(jLabel1)))
                .addGap(83, 83, 83))
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnQuitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRetrocederSeleccionado)
                        .addGap(74, 74, 74)
                        .addComponent(btnAvanzarSeleccionado))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRetrocederDisponibles)
                        .addGap(74, 74, 74)
                        .addComponent(btnAvanzarDisponible))
                    .addComponent(btnElegir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresar)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRetrocederDisponibles)
                    .addComponent(btnAvanzarDisponible))
                .addGap(18, 18, 18)
                .addComponent(btnElegir, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkLitros)
                        .addGap(18, 18, 18)
                        .addComponent(txtLitros, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkKilos)
                        .addGap(18, 18, 18)
                        .addComponent(txtKilos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRetrocederSeleccionado)
                    .addComponent(btnAvanzarSeleccionado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnQuitar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnSolicitarTraslado)
                .addGap(45, 45, 45))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        this.irMenuPrincipal();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRetrocederDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederDisponiblesActionPerformed
        // TODO add your handling code here:
        this.retrocederPagina();
    }//GEN-LAST:event_btnRetrocederDisponiblesActionPerformed

    private void btnAvanzarDisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarDisponibleActionPerformed
        // TODO add your handling code here:
        this.retrocederPagina();
    }//GEN-LAST:event_btnAvanzarDisponibleActionPerformed

    private void btnElegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirActionPerformed
        // TODO add your handling code here:
        this.llenarTablaResiduoSeleccionado();
    }//GEN-LAST:event_btnElegirActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        // TODO add your handling code here:
        this.regresarResiduoSeleccionado();
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void checkLitrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkLitrosActionPerformed
        // TODO add your handling code here:
        this.deshabilitarCamposLitros();
    }//GEN-LAST:event_checkLitrosActionPerformed

    private void checkKilosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkKilosActionPerformed
        // TODO add your handling code here:
        this.deshabilitarCamposKilos();
    }//GEN-LAST:event_checkKilosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvanzarDisponible;
    private javax.swing.JButton btnAvanzarSeleccionado;
    private javax.swing.JButton btnElegir;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRetrocederDisponibles;
    private javax.swing.JButton btnRetrocederSeleccionado;
    private javax.swing.JButton btnSolicitarTraslado;
    private javax.swing.JCheckBox checkKilos;
    private javax.swing.JCheckBox checkLitros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableResiduosDisponibles;
    private javax.swing.JTable tableResiduosSeleccionados;
    private javax.swing.JTextField txtKilos;
    private javax.swing.JTextField txtLitros;
    // End of variables declaration//GEN-END:variables
}
