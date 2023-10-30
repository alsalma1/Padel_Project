package com.mycompany.mavenproject1.views;

import com.mycompany.mavenproject1.controllers.AppController;
import com.mycompany.mavenproject1.models.Usuario;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GestionUsuarios extends javax.swing.JPanel {
    private AppController appController;

    public void setAppController(AppController appController) {
        this.appController = appController;
    }

    public GestionUsuarios() {
        initComponents();
        cargarUsuariosEnTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        btnDesactivados = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panelTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsuarios = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(926, 540));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setToolTipText("");
        bg.setPreferredSize(new java.awt.Dimension(926, 540));

        addBtn.setBackground(new java.awt.Color(0, 102, 255));
        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("ADD");
        addBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        btnDesactivados.setBackground(new java.awt.Color(0, 102, 255));
        btnDesactivados.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDesactivados.setForeground(new java.awt.Color(255, 255, 255));
        btnDesactivados.setText("Usuarios desactivados");
        btnDesactivados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDesactivados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivadosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Listado usuarios");

        panelTable.setBackground(new java.awt.Color(255, 255, 255));
        panelTable.setPreferredSize(new java.awt.Dimension(864, 417));

        tableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Email", "Nombre", "Apellido", "Contraseña", "Fecha nacimiento", "Teléfono", "DNI", "Socio", "Editar", "Eliminar", "kkkkk"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableUsuarios);
        if (tableUsuarios.getColumnModel().getColumnCount() > 0) {
            tableUsuarios.getColumnModel().getColumn(0).setResizable(false);
            tableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(150);
            tableUsuarios.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        javax.swing.GroupLayout panelTableLayout = new javax.swing.GroupLayout(panelTable);
        panelTable.setLayout(panelTableLayout);
        panelTableLayout.setHorizontalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelTableLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 903, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelTableLayout.setVerticalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
            .addGroup(panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelTableLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                                .addGap(565, 565, 565)
                                .addComponent(btnDesactivados, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                            .addComponent(panelTable, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTable, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesactivados, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDesactivadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivadosActionPerformed
        AppController appController = new AppController();
        appController.showJPanelController(new UsuariosDesactivados());
    }//GEN-LAST:event_btnDesactivadosActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        AppController appController = new AppController();
        appController.showJPanelController(new AñadirUsuario());
    }//GEN-LAST:event_addBtnActionPerformed

    public void cargarUsuariosEnTabla() {
        List<Usuario> usuarios = null;
        
        usuarios = Usuario.obtenerUsuarios();
        
        DefaultTableModel model = (DefaultTableModel) tableUsuarios.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de cargar los datos
      
        ButtonRenderer buttonRendererEdit = new ButtonRenderer();
        ButtonRenderer buttonRendererDelete = new ButtonRenderer();
        ButtonRenderer buttonRendererIcono = new ButtonRenderer();

        // Crea un icono que deseas mostrar en la celda
        Icon icono = new ImageIcon(getClass().getResource("/com/mycompany/mavenproject1/img/edit.png"));
        Icon icono1 = new ImageIcon(getClass().getResource("/com/mycompany/mavenproject1/img/profile.png"));
        // Asigna el renderizador personalizado a la columna
        tableUsuarios.getColumnModel().getColumn(8).setCellRenderer(new IconRenderer(icono));
        
        //tableUsuarios.getColumnModel().getColumn(8).setCellRenderer(buttonRendererEdit);
        tableUsuarios.getColumnModel().getColumn(9).setCellRenderer(new IconRenderer(icono1));
        //tableUsuarios.getColumnModel().getColumn(10).setCellRenderer(buttonRendererIcono);
        //tableUsuarios.getColumnModel().getColumn(8).setCellEditor(new NonEditableEditor(new JTextField()));
        
        for (Usuario usuario : usuarios) {
            buttonRendererEdit.setAction("editar");
            String esSocio = usuario.getSocio() ? "Sí" : "No";
            Object[] row = {
                    usuario.getEmail(),
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getContrasena(),
                    usuario.getFecha_nacimiento(),
                    usuario.getTelefono(),
                    usuario.getDni(),
                    esSocio,
                    "Editar",
                    "Eliminar",
            };
            model.addRow(row);
        }
        tableUsuarios.setRowHeight(40);
        // Asignar MouseListener al botón para manejar el clic
        tableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            //@Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int column = tableUsuarios.getColumnModel().getColumnIndexAtX(evt.getX());
                int row = evt.getY() / tableUsuarios.getRowHeight();

                if (row < tableUsuarios.getRowCount() && column == 8) {
                    String dni = tableUsuarios.getValueAt(row, 6).toString();
                    buttonRendererEdit.buttonEditAction(dni);
                } else if (row < tableUsuarios.getRowCount() && column == 9) {
                    String dni = tableUsuarios.getValueAt(row, 6).toString();
                    buttonRendererDelete.buttonDeleteAction(dni, GestionUsuarios.this);
                }
            }
        });       
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnDesactivados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JPanel panelTable;
    public javax.swing.JTable tableUsuarios;
    // End of variables declaration//GEN-END:variables
}
