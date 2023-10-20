package com.mycompany.mavenproject1.views;

import com.mycompany.mavenproject1.controllers.AppController;

public class LoginUsuario extends javax.swing.JFrame {

    public LoginUsuario() {
        initComponents();
        setTitle("Login usuario");
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fieldEmailUsu = new javax.swing.JTextField();
        fieldPasswordUsu = new javax.swing.JPasswordField();
        btnLoginUsu = new javax.swing.JButton();
        btnCancelar1 = new javax.swing.JButton();

        btnCancelar.setText("Cancelar");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Iniciar sesión usuario");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Email");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Contraseña");

        fieldPasswordUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPasswordUsuActionPerformed(evt);
            }
        });

        btnLoginUsu.setText("Iniciar sesión");
        btnLoginUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginUsuActionPerformed(evt);
            }
        });

        btnCancelar1.setText("Cancelar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(103, 103, 103))
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLoginUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(fieldEmailUsu, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                        .addComponent(fieldPasswordUsu))
                    .addComponent(btnCancelar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(132, 132, 132))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldEmailUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldPasswordUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLoginUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldPasswordUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPasswordUsuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPasswordUsuActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        setVisible(false);
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void btnLoginUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginUsuActionPerformed
        String email = fieldEmailUsu.getText();
        String contrasena = String.valueOf(fieldPasswordUsu.getPassword());

        // Llamar al método comprobarCredenciales
        AppController appController = new AppController();
        appController.comprobarCredencialesUsuario(email, contrasena, this);
    }//GEN-LAST:event_btnLoginUsuActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnLoginUsu;
    private javax.swing.JTextField fieldEmailUsu;
    private javax.swing.JPasswordField fieldPasswordUsu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
