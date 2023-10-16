package com.mycompany.mavenproject1.views;

import com.mycompany.mavenproject1.controllers.AppController;
import com.mycompany.mavenproject1.models.Usuario;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GestionUsuarios extends javax.swing.JFrame {
    private AppController appController;

    public void setAppController(AppController appController) {
        this.appController = appController;
    }

    public GestionUsuarios() {
        initComponents();
        setTitle("Gestión usuarios");
        setLocationRelativeTo(null);
        
        ImageIcon iconReturn = new ImageIcon("C:\\Users\\alami\\OneDrive\\Bureau\\padel_salma\\src\\main\\java\\com\\mycompany\\mavenproject1\\img\\returnIcon.png");
        ImageIcon iconPlus = new ImageIcon("C:\\Users\\alami\\OneDrive\\Bureau\\padel_salma\\src\\main\\java\\com\\mycompany\\mavenproject1\\img\\plusIcon.png");

        returnIcon.setIcon(iconReturn);
        addIcon.setIcon(iconPlus);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelUsuarios = new javax.swing.JLabel();
        returnIcon = new javax.swing.JLabel();
        addIcon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panelTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsuarios = new javax.swing.JTable();
        btnDesactivados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        returnIcon.setText("  Atrás");
        returnIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        returnIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                returnIconMouseEntered(evt);
            }
        });

        addIcon.setBackground(new java.awt.Color(153, 153, 255));
        addIcon.setText("  Añadir");
        addIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addIconMouseEntered(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Listado usuarios");

        tableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Email", "Nombre", "Apellido", "Contraseña", "Fecha nacimiento", "Teléfono", "DNI", "Socio", "Editar", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
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
            .addGroup(panelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTableLayout.setVerticalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTableLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnDesactivados.setBackground(new java.awt.Color(231, 226, 226));
        btnDesactivados.setText("Usuarios desactivados");
        btnDesactivados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDesactivados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(panelTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(741, 741, 741)
                                .addComponent(addIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(returnIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDesactivados)
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(labelUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDesactivados, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(returnIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(panelTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnIconMouseEntered
        // TODO add your handling code here:
        this.returnIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        returnIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Lógica para manejar el evento de clic en el icono
                setVisible(false);
                AppController appController = new AppController();
                appController.volverAtras(GestionUsuarios.this);
            }
        });
    }//GEN-LAST:event_returnIconMouseEntered

    private void addIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addIconMouseEntered
        // TODO add your handling code here:
        this.addIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                AppController appController = new AppController();
                appController.mostrarVentanaAñadirUsuario(GestionUsuarios.this);
            }
        });
    }//GEN-LAST:event_addIconMouseEntered

    private void btnDesactivadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivadosActionPerformed
        AppController appController = new AppController();
        appController.mostrarUsuariosDesactivados(this);
    }//GEN-LAST:event_btnDesactivadosActionPerformed

    public void cargarUsuariosEnTabla(List<Usuario> usuarios) {
        DefaultTableModel model = (DefaultTableModel) tableUsuarios.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de cargar los datos
      
        ButtonRenderer buttonRendererEdit = new ButtonRenderer();
        ButtonRenderer buttonRendererDelete = new ButtonRenderer();

        tableUsuarios.getColumnModel().getColumn(8).setCellRenderer(buttonRendererEdit);
        tableUsuarios.getColumnModel().getColumn(9).setCellRenderer(buttonRendererDelete);
        tableUsuarios.getColumnModel().getColumn(8).setCellEditor(new NonEditableEditor(new JTextField()));
        
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
                    "Eliminar"
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
                    buttonRendererEdit.buttonEditAction(dni, GestionUsuarios.this);
                } else if (row < tableUsuarios.getRowCount() && column == 9) {
                    String dni = tableUsuarios.getValueAt(row, 6).toString();
                    buttonRendererDelete.buttonDeleteAction(dni, GestionUsuarios.this);
                }
            }
        });       
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addIcon;
    private javax.swing.JButton btnDesactivados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel labelUsuarios;
    public javax.swing.JPanel panelTable;
    private javax.swing.JLabel returnIcon;
    public javax.swing.JTable tableUsuarios;
    // End of variables declaration//GEN-END:variables
}
