///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package presentacio;
//
///**
// *
// * @author Usuari
// */
//public class VistaConsultarAssig extends javax.swing.JFrame {
//    private ControladorPresentacio CtrlPresentacio;
//    /**
//     * Creates new form VistaConsultarAssig
//     */
//    public VistaConsultarAssig() {
//        initComponents();
//    }
//
//    public VistaConsultarAssig(ControladorPresentacio CP) {
//        CtrlPresentacio = CP;
//        initComponents();
//        this.setLocationRelativeTo(this);
//    }
//    public void ferVisible() {
//        jButton1.setEnabled(true);
//        jButton2.setEnabled(true);
//        jButton3.setEnabled(true);
//        jButton4.setEnabled(true);
//    }
//
//    public void desactivar() {
//        jButton1.setEnabled(false);
//        jButton2.setEnabled(false);
//        jButton3.setEnabled(false);
//        jButton4.setEnabled(false);
//    }
//
//    /**
//     * This method is called from within the constructor to initialize the form.
//     * WARNING: Do NOT modify this code. The content of this method is always
//     * regenerated by the Form Editor.
//     */
//    @SuppressWarnings("unchecked")
//    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
//    private void initComponents() {
//
//        jButton1 = new javax.swing.JButton();
//        jLabel1 = new javax.swing.JLabel();
//        jScrollPane2 = new javax.swing.JScrollPane();
//        jList1 = new javax.swing.JList<>();
//        jScrollPane3 = new javax.swing.JScrollPane();
//        jTextArea2 = new javax.swing.JTextArea();
//        jTextField4 = new javax.swing.JTextField();
//        jTextField5 = new javax.swing.JTextField();
//        jLabel3 = new javax.swing.JLabel();
//        jButton3 = new javax.swing.JButton();
//        jScrollPane4 = new javax.swing.JScrollPane();
//        jTextArea3 = new javax.swing.JTextArea();
//        jLabel4 = new javax.swing.JLabel();
//        jScrollPane1 = new javax.swing.JScrollPane();
//        jTextArea1 = new javax.swing.JTextArea();
//        jLabel5 = new javax.swing.JLabel();
//        jLabel6 = new javax.swing.JLabel();
//        jLabel7 = new javax.swing.JLabel();
//        jButton2 = new javax.swing.JButton();
//        jLabel2 = new javax.swing.JLabel();
//        jTextField1 = new javax.swing.JTextField();
//        jScrollPane5 = new javax.swing.JScrollPane();
//        jTextArea4 = new javax.swing.JTextArea();
//        jScrollPane6 = new javax.swing.JScrollPane();
//        jTextArea5 = new javax.swing.JTextArea();
//        jLabel8 = new javax.swing.JLabel();
//        jLabel9 = new javax.swing.JLabel();
//        jScrollPane7 = new javax.swing.JScrollPane();
//        jTextArea6 = new javax.swing.JTextArea();
//        jLabel10 = new javax.swing.JLabel();
//        jTextField6 = new javax.swing.JTextField();
//        jTextField7 = new javax.swing.JTextField();
//        jTextField8 = new javax.swing.JTextField();
//        jLabel11 = new javax.swing.JLabel();
//        jLabel12 = new javax.swing.JLabel();
//        jLabel13 = new javax.swing.JLabel();
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//
//        jButton1.setText("Tornar");
//        jButton1.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton1ActionPerformed(evt);
//            }
//        });
//
//        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
//        jLabel1.setText("Selecciona el codi d'alguna de les assignatures:");
//
//        jList1.setModel(new javax.swing.AbstractListModel<String>() {
//            String[] strings = CtrlPresentacio.getNomAules();
//            public int getSize() { return strings.length; }
//            public String getElementAt(int i) { return strings[i]; }
//        });
//        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
//        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                jList1MouseClicked(evt);
//            }
//        });
//        jScrollPane2.setViewportView(jList1);
//
//        jTextArea2.setColumns(20);
//        jTextArea2.setRows(5);
//        jScrollPane3.setViewportView(jTextArea2);
//
//        jTextField4.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jTextField4ActionPerformed(evt);
//            }
//        });
//
//        jTextField5.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jTextField5ActionPerformed(evt);
//            }
//        });
//
//        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
//        jLabel3.setText("Nom");
//
//        jButton3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
//        jButton3.setText("Eliminar Assignatura");
//        jButton3.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton3ActionPerformed(evt);
//            }
//        });
//
//        jTextArea3.setColumns(20);
//        jTextArea3.setRows(5);
//        jScrollPane4.setViewportView(jTextArea3);
//
//        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
//        jLabel4.setText("Crèdits");
//
//        jTextArea1.setColumns(1);
//        jTextArea1.setRows(5);
//        jScrollPane1.setViewportView(jTextArea1);
//
//        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
//        jLabel5.setText("Nou Codi");
//
//        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
//        jLabel6.setText("Nou Nom");
//
//        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
//        jLabel7.setText("Nou Crèdits");
//
//        jButton2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
//        jButton2.setText("Modificar Assignatura");
//        jButton2.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton2ActionPerformed(evt);
//            }
//        });
//
//        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
//        jLabel2.setText("Codi");
//
//        jTextField1.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jTextField1ActionPerformed(evt);
//            }
//        });
//
//        jTextArea4.setColumns(20);
//        jTextArea4.setRows(5);
//        jScrollPane5.setViewportView(jTextArea4);
//
//        jTextArea5.setColumns(20);
//        jTextArea5.setRows(5);
//        jScrollPane6.setViewportView(jTextArea5);
//
//        jLabel8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
//        jLabel8.setText("Nivell");
//
//        jLabel9.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
//        jLabel9.setText("Grups");
//
//        jTextArea6.setColumns(20);
//        jTextArea6.setRows(5);
//        jScrollPane7.setViewportView(jTextArea6);
//
//        jLabel10.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
//        jLabel10.setText("És de laboratori?");
//
//        jTextField6.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jTextField6ActionPerformed(evt);
//            }
//        });
//
//        jTextField7.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jTextField7ActionPerformed(evt);
//            }
//        });
//
//        jTextField8.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jTextField8ActionPerformed(evt);
//            }
//        });
//
//        jLabel11.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
//        jLabel11.setText("Nou Grups");
//
//        jLabel12.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
//        jLabel12.setText("Nou Nivell");
//
//        jLabel13.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
//        jLabel13.setText("Nou És de laboratori?");
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addGroup(layout.createSequentialGroup()
//                        .addContainerGap()
//                        .addComponent(jLabel1))
//                    .addGroup(layout.createSequentialGroup()
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addGroup(layout.createSequentialGroup()
//                                .addGap(22, 22, 22)
//                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
//                            .addGroup(layout.createSequentialGroup()
//                                .addGap(47, 47, 47)
//                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                        .addComponent(jButton2)
//                        .addGap(81, 81, 81)
//                        .addComponent(jButton3)
//                        .addGap(13, 13, 13))
//                    .addGroup(layout.createSequentialGroup()
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addGroup(layout.createSequentialGroup()
//                                .addGap(285, 285, 285)
//                                .addComponent(jLabel2)
//                                .addGap(28, 132, Short.MAX_VALUE))
//                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                                    .addComponent(jLabel10)
//                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                        .addComponent(jLabel4)
//                                        .addComponent(jLabel3)
//                                        .addComponent(jLabel9)
//                                        .addComponent(jLabel8)))
//                                .addGap(41, 41, 41)))
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addGroup(layout.createSequentialGroup()
//                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
//                                .addComponent(jLabel5)
//                                .addGap(87, 87, 87)
//                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
//                            .addGroup(layout.createSequentialGroup()
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                                        .addComponent(jLabel12)
//                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                    .addGroup(layout.createSequentialGroup()
//                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                            .addGroup(layout.createSequentialGroup()
//                                                .addComponent(jLabel13)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                                                .addGap(0, 0, Short.MAX_VALUE)
//                                                .addComponent(jLabel11)
//                                                .addGap(51, 51, 51)))
//                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                            .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                            .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                                            .addComponent(jLabel7)
//                                            .addComponent(jLabel6))
//                                        .addGap(78, 78, 78)
//                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
//                .addGap(33, 33, 33))
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                .addGap(38, 38, 38)
//                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addGroup(layout.createSequentialGroup()
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addGroup(layout.createSequentialGroup()
//                                .addGap(15, 15, 15)
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                    .addComponent(jLabel5)
//                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addGap(6, 6, 6)))
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addGroup(layout.createSequentialGroup()
//                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                            .addGroup(layout.createSequentialGroup()
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                    .addComponent(jLabel6))
//                                .addGap(29, 29, 29)
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                    .addComponent(jLabel7)))))
//                    .addGroup(layout.createSequentialGroup()
//                        .addGap(32, 32, 32)
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                            .addGroup(layout.createSequentialGroup()
//                                .addComponent(jLabel2)
//                                .addGap(65, 65, 65)
//                                .addComponent(jLabel3)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                .addComponent(jLabel4))
//                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addGroup(layout.createSequentialGroup()
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addGroup(layout.createSequentialGroup()
//                                .addGap(43, 43, 43)
//                                .addComponent(jLabel9))
//                            .addGroup(layout.createSequentialGroup()
//                                .addGap(7, 7, 7)
//                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                        .addGap(15, 15, 15))
//                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
//                            .addComponent(jLabel11))
//                        .addGap(48, 48, 48)))
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addGroup(layout.createSequentialGroup()
//                        .addGap(30, 30, 30)
//                        .addComponent(jLabel8)
//                        .addGap(81, 81, 81)
//                        .addComponent(jLabel10))
//                    .addGroup(layout.createSequentialGroup()
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                            .addGroup(layout.createSequentialGroup()
//                                .addGap(15, 15, 15)
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                    .addComponent(jLabel12))))
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addGroup(layout.createSequentialGroup()
//                                .addGap(18, 18, 18)
//                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                            .addGroup(layout.createSequentialGroup()
//                                .addGap(33, 33, 33)
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                    .addComponent(jLabel13))))))
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
//                        .addGap(19, 19, 19))
//                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
//                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
//                        .addGap(22, 22, 22))))
//        );
//
//        pack();
//    }// </editor-fold>//GEN-END:initComponents
//
//    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        CtrlPresentacio.sincronitzacioVistaGestioAssig_a_VistaGestioPE();
//    }//GEN-LAST:event_jButton1ActionPerformed
//
//    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
//        String codi = jList1.getModel().getElementAt(jList1.locationToIndex(evt.getPoint()));
//        String capacitat = CtrlPresentacio.getCapacitat(codi);
//        String lab = CtrlPresentacio.getLab(codi);
//        jTextArea1.setText(codi);
//        jTextArea2.setText(capacitat);
//        jTextArea3.setText(lab);
//    }//GEN-LAST:event_jList1MouseClicked
//
//    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
//        // TODO add your handling code here:
//    }//GEN-LAST:event_jTextField4ActionPerformed
//
//    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
//        // TODO add your handling code here:
//    }//GEN-LAST:event_jTextField5ActionPerformed
//
//    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//        String codi = jTextArea1.getText();
//        try {
//            CtrlPresentacio.eliminarAula(codi);
//        } catch (MyException ex) {
//            Logger.getLogger(VistaConsultarAula.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }//GEN-LAST:event_jButton3ActionPerformed
//
//    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        String codi = jTextArea1.getText();
//        String nom = jTextField1.getText();
//        String capacitat = jTextField4.getText();
//        String laboratori = jTextField5.getText();
//        try {
//            CtrlPresentacio.modificarAula(codi, nom, capacitat, laboratori);
//        } catch (MyException ex) {
//            Logger.getLogger(VistaCrearAula.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        jTextField4.setText("");
//        jTextField1.setText("");
//        jTextField5.setText("");
//
//    }//GEN-LAST:event_jButton2ActionPerformed
//
//    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
//        // TODO add your handling code here:
//    }//GEN-LAST:event_jTextField1ActionPerformed
//
//    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
//        // TODO add your handling code here:
//    }//GEN-LAST:event_jTextField6ActionPerformed
//
//    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
//        // TODO add your handling code here:
//    }//GEN-LAST:event_jTextField7ActionPerformed
//
//    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
//        // TODO add your handling code here:
//    }//GEN-LAST:event_jTextField8ActionPerformed
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VistaConsultarAssig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VistaConsultarAssig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VistaConsultarAssig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VistaConsultarAssig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VistaConsultarAssig().setVisible(true);
//            }
//        });
//    }
//
//    // Variables declaration - do not modify//GEN-BEGIN:variables
//    private javax.swing.JButton jButton1;
//    private javax.swing.JButton jButton2;
//    private javax.swing.JButton jButton3;
//    private javax.swing.JLabel jLabel1;
//    private javax.swing.JLabel jLabel10;
//    private javax.swing.JLabel jLabel11;
//    private javax.swing.JLabel jLabel12;
//    private javax.swing.JLabel jLabel13;
//    private javax.swing.JLabel jLabel2;
//    private javax.swing.JLabel jLabel3;
//    private javax.swing.JLabel jLabel4;
//    private javax.swing.JLabel jLabel5;
//    private javax.swing.JLabel jLabel6;
//    private javax.swing.JLabel jLabel7;
//    private javax.swing.JLabel jLabel8;
//    private javax.swing.JLabel jLabel9;
//    private javax.swing.JList<String> jList1;
//    private javax.swing.JScrollPane jScrollPane1;
//    private javax.swing.JScrollPane jScrollPane2;
//    private javax.swing.JScrollPane jScrollPane3;
//    private javax.swing.JScrollPane jScrollPane4;
//    private javax.swing.JScrollPane jScrollPane5;
//    private javax.swing.JScrollPane jScrollPane6;
//    private javax.swing.JScrollPane jScrollPane7;
//    private javax.swing.JTextArea jTextArea1;
//    private javax.swing.JTextArea jTextArea2;
//    private javax.swing.JTextArea jTextArea3;
//    private javax.swing.JTextArea jTextArea4;
//    private javax.swing.JTextArea jTextArea5;
//    private javax.swing.JTextArea jTextArea6;
//    private javax.swing.JTextField jTextField1;
//    private javax.swing.JTextField jTextField4;
//    private javax.swing.JTextField jTextField5;
//    private javax.swing.JTextField jTextField6;
//    private javax.swing.JTextField jTextField7;
//    private javax.swing.JTextField jTextField8;
//    // End of variables declaration//GEN-END:variables
//}