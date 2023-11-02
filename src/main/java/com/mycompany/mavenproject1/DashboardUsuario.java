package com.mycompany.mavenproject1;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import com.mycompany.mavenproject1.controllers.AppController;
import com.mycompany.mavenproject1.views.BienvenidoUsuario;
import com.mycompany.mavenproject1.views.MisReservas;
import com.mycompany.mavenproject1.views.PerfilUsuario;
import com.mycompany.mavenproject1.views.ReservarPista;
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
public class DashboardUsuario extends javax.swing.JFrame {
    private String emailLogeado;
    private AppController appController = new AppController();
    
    public DashboardUsuario(String email) {
        this.emailLogeado = email;
        setTitle("Panel usuario");
        initComponents();
        initStyles();
        initContent();
        setDate();
    }
    private void initStyles(){
        msg.putClientProperty( "FlatLaf.styleClass", "h1" );
    }
    private void initContent(){
        showJPanel(new BienvenidoUsuario(emailLogeado));
    }
    public void showJPanel(JPanel p){
        p.setSize(930, 560);
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

    public void obtenerEmail(){
        String texto = msg.getText();
        //msg.setText(texto+" "+getEmailLogeado());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        content = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        msg = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        titlePadel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        perfilBtn = new javax.swing.JButton();
        reservasPistasBtn = new javax.swing.JButton();
        PrincipalBtn = new javax.swing.JButton();
        misReservasBtn = new javax.swing.JButton();
        cerrarSesionBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1150, 680));

        background.setPreferredSize(new java.awt.Dimension(1150, 680));

        content.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        header.setBackground(new java.awt.Color(0, 153, 255));

        msg.setBackground(new java.awt.Color(0, 0, 0));
        msg.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        msg.setForeground(new java.awt.Color(255, 255, 255));
        msg.setText("Bienvenido ");

        date.setBackground(new java.awt.Color(51, 204, 255));
        date.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setText("Hoy es {dayname} {day} de {month} de {year}");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date)))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        menu.setBackground(new java.awt.Color(0, 102, 255));

        titlePadel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titlePadel.setForeground(new java.awt.Color(255, 255, 255));
        titlePadel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titlePadel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/raqueta-de-padel.png"))); // NOI18N
        titlePadel.setText("Padel");

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        perfilBtn.setBackground(new java.awt.Color(51, 153, 255));
        perfilBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        perfilBtn.setForeground(new java.awt.Color(255, 255, 255));
        perfilBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/account-multiple.png"))); // NOI18N
        perfilBtn.setText("Mi perfil");
        perfilBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        perfilBtn.setBorderPainted(false);
        perfilBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        perfilBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        perfilBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfilBtnActionPerformed(evt);
            }
        });

        reservasPistasBtn.setBackground(new java.awt.Color(51, 153, 255));
        reservasPistasBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        reservasPistasBtn.setForeground(new java.awt.Color(255, 255, 255));
        reservasPistasBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/baseline_calendar_month_white_24dp.png"))); // NOI18N
        reservasPistasBtn.setText("Reservar pista");
        reservasPistasBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        reservasPistasBtn.setBorderPainted(false);
        reservasPistasBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reservasPistasBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reservasPistasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservasPistasBtnActionPerformed(evt);
            }
        });

        PrincipalBtn.setBackground(new java.awt.Color(51, 153, 255));
        PrincipalBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PrincipalBtn.setForeground(new java.awt.Color(255, 255, 255));
        PrincipalBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home-outline.png"))); // NOI18N
        PrincipalBtn.setText("Principal");
        PrincipalBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        PrincipalBtn.setBorderPainted(false);
        PrincipalBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PrincipalBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PrincipalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrincipalBtnActionPerformed(evt);
            }
        });

        misReservasBtn.setBackground(new java.awt.Color(51, 153, 255));
        misReservasBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        misReservasBtn.setForeground(new java.awt.Color(255, 255, 255));
        misReservasBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calendar-multiple-check.png"))); // NOI18N
        misReservasBtn.setText("Mis reservas");
        misReservasBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(0, 0, 0)));
        misReservasBtn.setBorderPainted(false);
        misReservasBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        misReservasBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        misReservasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                misReservasBtnActionPerformed(evt);
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

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PrincipalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(perfilBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reservasPistasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(misReservasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titlePadel, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(cerrarSesionBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(titlePadel)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PrincipalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(perfilBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(reservasPistasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(misReservasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addComponent(cerrarSesionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(233, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
            .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void perfilBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariosBtnActionPerformed
        appController.mostrarPerfilUsuario(emailLogeado);
    }//GEN-LAST:event_usuariosBtnActionPerformed

    private void reservasPistasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pistasBtnActionPerformed
        appController.mostrarPistas(emailLogeado);
        //showJPanel(new ReservarPista());
    }//GEN-LAST:event_pistasBtnActionPerformed

    private void PrincipalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrincipalBtnActionPerformed
        showJPanel(new BienvenidoUsuario(emailLogeado));
    }//GEN-LAST:event_PrincipalBtnActionPerformed

    private void misReservasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservasBtnActionPerformed
        appController.mostrarMisReservas(emailLogeado);
        //showJPanel(new MisReservas());
    }//GEN-LAST:event_reservasBtnActionPerformed

    private void cerrarSesionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionBtnActionPerformed
        this.setVisible(false);
        Dashboard dash = new Dashboard();
        dash.setVisible(true);
    }//GEN-LAST:event_cerrarSesionBtnActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PrincipalBtn;
    private javax.swing.JPanel background;
    private javax.swing.JButton cerrarSesionBtn;
    public javax.swing.JPanel content;
    private javax.swing.JLabel date;
    private javax.swing.JPanel header;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel menu;
    private javax.swing.JButton misReservasBtn;
    private javax.swing.JLabel msg;
    private javax.swing.JButton perfilBtn;
    private javax.swing.JButton reservasPistasBtn;
    private javax.swing.JLabel titlePadel;
    // End of variables declaration//GEN-END:variables
}
