package com.mycompany.mavenproject1;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import com.mycompany.mavenproject1.views.GestionPistas;
import com.mycompany.mavenproject1.views.GestionReservasAdmin;
import com.mycompany.mavenproject1.views.GestionUsuarios;
import com.mycompany.mavenproject1.views.LoginAdmin;
import com.mycompany.mavenproject1.views.bienvenidoAdmin;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author Alex
 */
public class DashboardAdmin extends javax.swing.JFrame {

    public DashboardAdmin() {
        initComponents();
        initStyles();
        initContent();
        setDate();
    }
    private void initStyles(){
        msg.putClientProperty( "FlatLaf.styleClass", "h1" );
    }
    private void initContent(){
        showJPanel(new bienvenidoAdmin());
    }
    public void showJPanel(JPanel p){
        p.setSize(926, 540);
        p.setLocation(0,0);
        
        content.removeAll();
        content.setLayout(new BorderLayout()); // Asegúrate de establecer un BorderLayout si aún no lo has hecho
        content.add(p, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }
    private void setDate(){
        LocalDate now = LocalDate.now();
        Locale spanishLocale = new Locale("es", "ES");
        date.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMMM 'de' yyyy", spanishLocale)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        titlePadel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        usuariosBtn = new javax.swing.JButton();
        pistasBtn = new javax.swing.JButton();
        cerrarSesionBtn = new javax.swing.JButton();
        reservasBtn = new javax.swing.JButton();
        principalBtn1 = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        msg = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1150, 680));

        background.setBackground(new java.awt.Color(255, 255, 255));

        menu.setBackground(new java.awt.Color(0, 102, 255));

        titlePadel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titlePadel.setForeground(new java.awt.Color(255, 255, 255));
        titlePadel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titlePadel.setText("Padel");

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        usuariosBtn.setBackground(new java.awt.Color(51, 153, 255));
        usuariosBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usuariosBtn.setForeground(new java.awt.Color(255, 255, 255));
        usuariosBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/account-multiple.png"))); // NOI18N
        usuariosBtn.setText("Usuarios");
        usuariosBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        usuariosBtn.setBorderPainted(false);
        usuariosBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usuariosBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        usuariosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosBtnActionPerformed(evt);
            }
        });

        pistasBtn.setBackground(new java.awt.Color(51, 153, 255));
        pistasBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pistasBtn.setForeground(new java.awt.Color(255, 255, 255));
        pistasBtn.setText("Pistas");
        pistasBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        pistasBtn.setBorderPainted(false);
        pistasBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pistasBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pistasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pistasBtnActionPerformed(evt);
            }
        });

        cerrarSesionBtn.setBackground(new java.awt.Color(204, 204, 204));
        cerrarSesionBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cerrarSesionBtn.setText("Cerrar sesión");
        cerrarSesionBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cerrarSesionBtn.setBorderPainted(false);
        cerrarSesionBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrarSesionBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cerrarSesionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionBtnActionPerformed(evt);
            }
        });

        reservasBtn.setBackground(new java.awt.Color(51, 153, 255));
        reservasBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        reservasBtn.setForeground(new java.awt.Color(255, 255, 255));
        reservasBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calendar-multiple-check.png"))); // NOI18N
        reservasBtn.setText("Reservas");
        reservasBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        reservasBtn.setBorderPainted(false);
        reservasBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reservasBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reservasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservasBtnActionPerformed(evt);
            }
        });

        principalBtn1.setBackground(new java.awt.Color(51, 153, 255));
        principalBtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        principalBtn1.setForeground(new java.awt.Color(255, 255, 255));
        principalBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-outline.png"))); // NOI18N
        principalBtn1.setText("Principal");
        principalBtn1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        principalBtn1.setBorderPainted(false);
        principalBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        principalBtn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        principalBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                principalBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(usuariosBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(reservasBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pistasBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menuLayout.createSequentialGroup()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(titlePadel, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(cerrarSesionBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(principalBtn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(titlePadel)
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usuariosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(reservasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(pistasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cerrarSesionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
            .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(menuLayout.createSequentialGroup()
                    .addGap(149, 149, 149)
                    .addComponent(principalBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(470, Short.MAX_VALUE)))
        );

        header.setBackground(new java.awt.Color(0, 153, 255));

        msg.setBackground(new java.awt.Color(0, 0, 0));
        msg.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        msg.setForeground(new java.awt.Color(255, 255, 255));
        msg.setText("Administración");

        date.setBackground(new java.awt.Color(51, 204, 255));
        date.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setText("Hoy es {dayname} {day} de {month} de {year}");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                    .addComponent(msg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(376, 376, 376))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setRequestFocusEnabled(false);

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 557, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usuariosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariosBtnActionPerformed
        showJPanel(new GestionUsuarios());
    }//GEN-LAST:event_usuariosBtnActionPerformed

    private void pistasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pistasBtnActionPerformed
        showJPanel(new GestionPistas());
    }//GEN-LAST:event_pistasBtnActionPerformed

    private void cerrarSesionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionBtnActionPerformed
        this.setVisible(false);
        Dashboard dash = new Dashboard();
        dash.setVisible(true);
    }//GEN-LAST:event_cerrarSesionBtnActionPerformed

    private void reservasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservasBtnActionPerformed
        showJPanel(new GestionReservasAdmin());
    }//GEN-LAST:event_reservasBtnActionPerformed

    private void principalBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_principalBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_principalBtn1ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel background;
    private javax.swing.JButton cerrarSesionBtn;
    public javax.swing.JPanel content;
    private javax.swing.JLabel date;
    private javax.swing.JPanel header;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel msg;
    private javax.swing.JButton pistasBtn;
    private javax.swing.JButton principalBtn1;
    private javax.swing.JButton reservasBtn;
    private javax.swing.JLabel titlePadel;
    private javax.swing.JButton usuariosBtn;
    // End of variables declaration//GEN-END:variables
}
