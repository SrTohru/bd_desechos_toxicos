/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.itson.presentacion;

import com.itson.desechostoxicospersistencia.dao.QuimicosDAO;
import com.itson.desechostoxicospersistencia.interfaces.IQuimicos;
import com.itson.desechostoxicospersistencia.utilities.ConfiguracionDePaginado;
import com.itson.dominio.Quimicos;
import com.itson.negocio.validadores.Validaciones;
import static com.itson.negocio.validadores.Validaciones.validarNumero;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class RegistrarResiduoForm extends javax.swing.JFrame {

    private static final Logger LOG = Logger.getLogger(RegistrarResiduoForm.class.getName());
    private QuimicosDAO quimicosDAO;
    private ConfiguracionDePaginado configuracionDePaginado;
    private Validaciones v;
    
    /**
     * Creates new form RegistrarResiduoForm
     */
    public RegistrarResiduoForm() {
        this.configuracionDePaginado = new ConfiguracionDePaginado(0, 2);
        initComponents();
        quimicosDAO = new QuimicosDAO();       
        this.llenarTablaQuimicosDisponibles();
    }

    private void irMenuPrincipal() {
        new MenuPrincipalForm().setVisible(true);
        this.dispose();
    }
    
    private void llenarTablaQuimicosDisponibles() {
        try {
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tableQuimicosDisponibles.getModel();
            List<Quimicos> listaQuimicos = quimicosDAO.consultarQuimicosGenerales(this.configuracionDePaginado);
            modeloTabla.setRowCount(0);
            for (Quimicos q : listaQuimicos) {
                Object[] fila = {
                    q.getNombre(),};
                modeloTabla.addRow(fila);
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
    }

    private void llenarTablaQuimicosNuevoResiduo() {
        try {
            // Obtener el modelo de la tabla de origen y de destino
            DefaultTableModel modeloOrigen = (DefaultTableModel) tableQuimicosDisponibles.getModel();
            DefaultTableModel modeloDestino = (DefaultTableModel) tableQuimicosNuevoResiduo.getModel();

            // Obtener el índice de la fila seleccionada en la tabla de origen
            int filaSeleccionada = tableQuimicosDisponibles.getSelectedRow();

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
            tableQuimicosDisponibles.repaint();
            tableQuimicosNuevoResiduo.repaint();
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
    }
    
    private void regresarQuimicoSeleccionado() {
        try {
            // Obtener el modelo de la tabla de origen y de destino
            DefaultTableModel modeloOrigen = (DefaultTableModel) tableQuimicosNuevoResiduo.getModel();
            DefaultTableModel modeloDestino = (DefaultTableModel) tableQuimicosDisponibles.getModel();

            // Obtener el índice de la fila seleccionada en la tabla de origen
            int filaSeleccionada = tableQuimicosNuevoResiduo.getSelectedRow();

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
            tableQuimicosNuevoResiduo.repaint();
            tableQuimicosDisponibles.repaint();
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage());
        }
    }
    
    /**
     * Metodo para avanzar de pagina en la tabla de la consulta de personas
     */
    public void avanzarPagina() {
        this.configuracionDePaginado.avanzarPagina();
        this.llenarTablaQuimicosDisponibles();
    }

    /**
     * Metodo para retroceder de pagina en la tabla de la consulta de personas
     */
    public void retrocederPagina() {
        this.configuracionDePaginado.retrocederPagina();
        this.llenarTablaQuimicosDisponibles();
    }

    private void validarCampoCodigo(){
        if (txtCodigo.toString().isBlank() || txtCodigo.toString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo codigo esta vacio","Error Campo Invalido",JOptionPane.ERROR_MESSAGE);
        }
        if (validarNumero(txtCodigo.toString())) {
            JOptionPane.showMessageDialog(null, "Solo acepta numeros de maximo 6 digitos","Error Campo Invalido",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCodigo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        lblQuimicos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableQuimicosDisponibles = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        lblQuimicos1 = new javax.swing.JLabel();
        btnAgregarQuimico = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableQuimicosNuevoResiduo = new javax.swing.JTable();
        btnEliminarQuimico = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnCrearResiduo = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnRetroceder = new javax.swing.JButton();
        btnAvanzar = new javax.swing.JButton();
        btnRetrocederNuevoResiduo = new javax.swing.JButton();
        btnAvanzarNuevoResiduo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar Residuo Peligroso");
        setResizable(false);

        lblCodigo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCodigo.setText("Codigo");

        lblNombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNombre.setText("Nombre");

        txtCodigo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        lblQuimicos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblQuimicos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuimicos.setText("Crear Nuevo Residuo Peligroso ");

        tableQuimicosDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
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
        jScrollPane1.setViewportView(tableQuimicosDisponibles);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblQuimicos1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblQuimicos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuimicos1.setText("Lista de Quimicos Disponibles");

        btnAgregarQuimico.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAgregarQuimico.setText("Agregar Quimico al Nuevo Residuo");
        btnAgregarQuimico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarQuimicoActionPerformed(evt);
            }
        });

        tableQuimicosNuevoResiduo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
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
        jScrollPane3.setViewportView(tableQuimicosNuevoResiduo);

        btnEliminarQuimico.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEliminarQuimico.setText("Eliminar Quimico del Nuevo Residuo");
        btnEliminarQuimico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarQuimicoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista de Quimicos del Nuevo Residuo");

        btnCrearResiduo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCrearResiduo.setText("Guardar");
        btnCrearResiduo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearResiduoActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRegresar.setText("<");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnRetroceder.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRetroceder.setText("<");
        btnRetroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederActionPerformed(evt);
            }
        });

        btnAvanzar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAvanzar.setText(">");
        btnAvanzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarActionPerformed(evt);
            }
        });

        btnRetrocederNuevoResiduo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRetrocederNuevoResiduo.setText("<");
        btnRetrocederNuevoResiduo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederNuevoResiduoActionPerformed(evt);
            }
        });

        btnAvanzarNuevoResiduo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAvanzarNuevoResiduo.setText(">");
        btnAvanzarNuevoResiduo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarNuevoResiduoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresar)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCodigo)
                                    .addComponent(lblNombre))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodigo)
                                    .addComponent(txtNombre)))
                            .addComponent(lblQuimicos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE))
                        .addGap(54, 54, 54))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(184, 184, 184)
                                .addComponent(btnCrearResiduo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnRetrocederNuevoResiduo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAvanzarNuevoResiduo))
                                    .addComponent(btnEliminarQuimico))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(lblQuimicos1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRetroceder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAvanzar))
                            .addComponent(btnAgregarQuimico))))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblQuimicos))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresar)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblCodigo))
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRetrocederNuevoResiduo)
                    .addComponent(btnAvanzarNuevoResiduo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminarQuimico)
                .addGap(43, 43, 43)
                .addComponent(btnCrearResiduo)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(lblQuimicos1)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRetroceder)
                    .addComponent(btnAvanzar))
                .addGap(26, 26, 26)
                .addComponent(btnAgregarQuimico)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        this.irMenuPrincipal();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAgregarQuimicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarQuimicoActionPerformed
        // TODO add your handling code here:
        this.llenarTablaQuimicosNuevoResiduo();
    }//GEN-LAST:event_btnAgregarQuimicoActionPerformed

    private void btnAvanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarActionPerformed
        // TODO add your handling code here:
        this.avanzarPagina();
    }//GEN-LAST:event_btnAvanzarActionPerformed

    private void btnRetrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederActionPerformed
        // TODO add your handling code here:
        this.retrocederPagina();
    }//GEN-LAST:event_btnRetrocederActionPerformed

    private void btnRetrocederNuevoResiduoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederNuevoResiduoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRetrocederNuevoResiduoActionPerformed

    private void btnAvanzarNuevoResiduoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarNuevoResiduoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAvanzarNuevoResiduoActionPerformed

    private void btnEliminarQuimicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarQuimicoActionPerformed
        // TODO add your handling code here:
        this.regresarQuimicoSeleccionado();
    }//GEN-LAST:event_btnEliminarQuimicoActionPerformed

    private void btnCrearResiduoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearResiduoActionPerformed
        // TODO add your handling code here:
        this.validarCampoCodigo();
    }//GEN-LAST:event_btnCrearResiduoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarQuimico;
    private javax.swing.JButton btnAvanzar;
    private javax.swing.JButton btnAvanzarNuevoResiduo;
    private javax.swing.JButton btnCrearResiduo;
    private javax.swing.JButton btnEliminarQuimico;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRetroceder;
    private javax.swing.JButton btnRetrocederNuevoResiduo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblQuimicos;
    private javax.swing.JLabel lblQuimicos1;
    private javax.swing.JTable tableQuimicosDisponibles;
    private javax.swing.JTable tableQuimicosNuevoResiduo;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
