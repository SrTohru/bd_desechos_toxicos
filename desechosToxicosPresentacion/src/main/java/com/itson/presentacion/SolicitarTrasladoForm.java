/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.itson.presentacion;

import com.itson.desechostoxicosnegocio.fachada.FachadaNegocio;
import com.itson.desechostoxicospersistencia.dao.ResiduosDAO;
import com.itson.desechostoxicospersistencia.interfaces.IResiduos;
import com.itson.desechostoxicospersistencia.utilities.ConfiguracionDePaginado;
import com.itson.dominio.Cuenta;
import com.itson.dominio.Quimicos;
import com.itson.dominio.RegistroTraslado;
import com.itson.dominio.Residuos;
import com.itson.dominio.Traslado;
import java.util.ArrayList;
import java.util.LinkedList;
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
public class SolicitarTrasladoForm extends javax.swing.JFrame {

    private static final Logger LOG = Logger.getLogger(SolicitarTrasladoForm.class.getName());
    private ConfiguracionDePaginado configuracionDePaginado;
    private FachadaNegocio fachadaNegocio;
    private Cuenta cuenta;
    private List<Residuos> residuosSeleccionados;
    
    /**
     * Creates new form SolicitarTrasladoForm
     */
    public SolicitarTrasladoForm(Cuenta cuenta) {
        this.configuracionDePaginado = new ConfiguracionDePaginado(0, 5);
        initComponents();
        this.cuenta = cuenta;
        this.deshabilitarCamposLitros();
        this.deshabilitarCamposKilos();
        fachadaNegocio = new FachadaNegocio();
        this.residuosSeleccionados = new LinkedList<>();
        this.llenarTablaResiduosDisponibles();
    }

    public void solicitarTraslado() throws Exception {
        List<Residuos> listaResiduosSeleccionados = new LinkedList<>();
        for (int i = 0; i < tableResiduosSeleccionados.getRowCount(); i++) {
            String idResiduo = tableResiduosSeleccionados.getValueAt(i, 0).toString();
            String nombreResiduo = (String) tableResiduosSeleccionados.getValueAt(i, 1).toString(); 

            Residuos residuo = new Residuos();
            residuo.setId(new ObjectId(idResiduo));
            residuo.setNombre(nombreResiduo);

            residuo = fachadaNegocio.consultarResiduo(residuo);

            listaResiduosSeleccionados.add(residuo);
        }

        if (dateChooser.getDate() == null || listaResiduosSeleccionados.isEmpty()
                || (checkKilos.isSelected() && (txtKilos.getText().isEmpty() || txtKilos.getText().isBlank()))
                || checkLitros.isSelected() && (txtLitros.getText().isEmpty() || txtLitros.getText().isBlank())) {

            throw new Exception("Porfavor llene los campos correspondientes");
        }

        Traslado traslado = new Traslado(cuenta.getId(), dateChooser.getDate(), listaResiduosSeleccionados);

        setUnidadMedida(traslado);

        fachadaNegocio.insertarTraslado(traslado);

    }

      private float obtenerUnidadDeMedida() {
        if (checkKilos.isSelected() && !checkLitros.isSelected()) {
            return (Float.parseFloat(txtKilos.getText()));
        } else if (checkLitros.isSelected() && !checkKilos.isSelected()) {
            return (Float.parseFloat(txtLitros.getText()));
        }
        
        return 0;
    }
    
    private void setUnidadMedida(Traslado traslado) {
        if (checkKilos.isSelected() && !checkLitros.isSelected()) {
            traslado.setKilos(Float.parseFloat(txtKilos.getText()));
        } else if (checkLitros.isSelected() && !checkKilos.isSelected()) {
            traslado.setLitros(Float.parseFloat(txtLitros.getText()));
        }
    }

    private void deshabilitarCamposLitros() {
        if (checkLitros.isSelected()) {
            checkKilos.setSelected(false);
            txtKilos.setEnabled(false);
            txtLitros.setEnabled(true);
        } else {
            txtLitros.setEnabled(false);
        }
    }

    private void deshabilitarCamposKilos() {
        if (checkKilos.isSelected()) {
            checkLitros.setSelected(false);
            txtLitros.setEnabled(false);
            txtKilos.setEnabled(true);
        } else {
            txtKilos.setEnabled(false);

        }
    }

    private void irMenuPrincipal() {
        MenuPrincipalForm menu = new MenuPrincipalForm(this.cuenta);
        menu.setVisible(true);
        this.dispose();
    }

    private void llenarTablaResiduosDisponibles() {
        try {
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tableResiduosDisponibles.getModel();
            List<Residuos> listaResiduos = fachadaNegocio.consultarResiduos(this.configuracionDePaginado);
            modeloTabla.setRowCount(0);

            // Obtener los IDs de los residuos seleccionados
            List<ObjectId> residuosSeleccionados = new ArrayList<>();
            for (int i = 0; i < tableResiduosSeleccionados.getRowCount(); i++) {
                ObjectId idResiduo = (ObjectId) tableResiduosSeleccionados.getValueAt(i, 0);
                residuosSeleccionados.add(idResiduo);
            }

            for (Residuos r : listaResiduos) {
                // Verificar si el residuo ya está seleccionado
                if (!residuosSeleccionados.contains(r.getId())) {
                    Object[] fila = {
                        r.getId(),
                        r.getNombre(),};
                    modeloTabla.addRow(fila);
                }
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

            // Agregar el residuo seleccionado a la lista de residuos seleccionados
            String idResiduo = fila[0].toString();
            String nombreResiduo = fila[1].toString();
        
            Residuos residuo = new Residuos();
            residuo.setId(new ObjectId(idResiduo));
            residuo.setNombre(nombreResiduo);
            
            residuosSeleccionados.add(residuo);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableResiduosSeleccionados = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnElegir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableResiduosDisponibles = new javax.swing.JTable();
        btnQuitar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        checkKilos = new javax.swing.JCheckBox();
        checkLitros = new javax.swing.JCheckBox();
        btnSolicitarTraslado = new javax.swing.JButton();
        btnRetrocederDisponibles = new javax.swing.JButton();
        btnAvanzarDisponible = new javax.swing.JButton();
        btnRetrocederSeleccionado = new javax.swing.JButton();
        btnAvanzarSeleccionado = new javax.swing.JButton();
        dateChooser = new com.toedter.calendar.JDateChooser();
        txtLitros = new javax.swing.JFormattedTextField();
        txtKilos = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Solicitar Traslado");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Fecha del Traslado");

        tableResiduosSeleccionados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Residuo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
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
                "Id", "Residuo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
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
        btnSolicitarTraslado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarTrasladoActionPerformed(evt);
            }
        });

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
        btnRetrocederSeleccionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetrocederSeleccionadoActionPerformed(evt);
            }
        });

        btnAvanzarSeleccionado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAvanzarSeleccionado.setText(">");
        btnAvanzarSeleccionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanzarSeleccionadoActionPerformed(evt);
            }
        });

        dateChooser.setMinSelectableDate(new java.util.Date(1684310507000L));

        try {
            txtLitros.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtKilos.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtKilos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKilosActionPerformed(evt);
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
                        .addComponent(btnRegresar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRetrocederDisponibles)
                                .addGap(74, 74, 74)
                                .addComponent(btnAvanzarDisponible))
                            .addComponent(btnElegir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(364, 516, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(66, 66, 66))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnQuitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnRetrocederSeleccionado)
                                        .addGap(74, 74, 74)
                                        .addComponent(btnAvanzarSeleccionado)))
                                .addGap(35, 35, 35)
                                .addComponent(btnSolicitarTraslado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(checkLitros)
                            .addComponent(checkKilos)
                            .addComponent(txtLitros)
                            .addComponent(txtKilos, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)))
                        .addGap(83, 83, 83))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresar)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRetrocederDisponibles)
                    .addComponent(btnAvanzarDisponible))
                .addGap(18, 18, 18)
                .addComponent(btnElegir, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkLitros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLitros, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(checkKilos)
                        .addGap(28, 28, 28)
                        .addComponent(txtKilos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRetrocederSeleccionado)
                            .addComponent(btnAvanzarSeleccionado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQuitar)
                            .addComponent(btnSolicitarTraslado))))
                .addContainerGap(22, Short.MAX_VALUE))
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
        this.avanzarPagina();
    }//GEN-LAST:event_btnAvanzarDisponibleActionPerformed

    private void btnElegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirActionPerformed
        
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

    private void btnSolicitarTrasladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarTrasladoActionPerformed
        try {
            solicitarTraslado();
            JOptionPane.showMessageDialog(null, "Se realizo exitosamente la solicitud del traslado");
            dispose();

            new MenuPrincipalForm(cuenta).setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnSolicitarTrasladoActionPerformed

    private void btnRetrocederSeleccionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocederSeleccionadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRetrocederSeleccionadoActionPerformed

    private void btnAvanzarSeleccionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarSeleccionadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAvanzarSeleccionadoActionPerformed

    private void txtKilosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKilosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKilosActionPerformed

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
    private com.toedter.calendar.JDateChooser dateChooser;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableResiduosDisponibles;
    private javax.swing.JTable tableResiduosSeleccionados;
    private javax.swing.JFormattedTextField txtKilos;
    private javax.swing.JFormattedTextField txtLitros;
    // End of variables declaration//GEN-END:variables
}
