package com.mycompany.mavenproject1.views;

import com.mycompany.mavenproject1.controllers.AppController;
import com.mycompany.mavenproject1.models.Reserva;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class MisReservas extends javax.swing.JPanel {
    private String userEmail;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public MisReservas() {
        initComponents();
        // Configurar el alineamiento de las celdas en el centro
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tableMisReservas.setDefaultRenderer(String.class, centerRenderer);
    }

    public void cargarReservasEnTabla(List<Reserva> lista) {
        // Establecer el ancho de la segunda columna (índice 1) a 100 píxeles
        TableColumn column = tableMisReservas.getColumnModel().getColumn(4);
        column.setPreferredWidth(20);
        
        DefaultTableModel model = (DefaultTableModel) tableMisReservas.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de cargar los datos

        SimpleDateFormat formatoFechaNuevo = new SimpleDateFormat("dd-MM-yyyy");
        ButtonRenderer buttonRendererDelete = new ButtonRenderer();
        ButtonRenderer buttonRendererIcono = new ButtonRenderer();
        
        Icon icono = new ImageIcon(getClass().getResource("/eliminar.png"));
        tableMisReservas.getColumnModel().getColumn(4).setCellRenderer(new IconRenderer(icono));
        //tableMisReservas.getColumnModel().getColumn(4).setCellRenderer(buttonRendererDelete);
        
        for (Reserva re : lista) {
            String fechaFormateada = formatoFechaNuevo.format(re.getFecha());

            Object[] row = {
                re.getId_reserva(),
                fechaFormateada, // Fecha formateada en "dd-MM-yyyy"
                re.getHora(),
                re.getId_pista(),
                ""
            };
            model.addRow(row);
        }
        tableMisReservas.setRowHeight(50);
        tableMisReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                int column = tableMisReservas.getColumnModel().getColumnIndexAtX(evt.getX());
                if(column == 4){
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setCursor(Cursor.getDefaultCursor());
            }
        });
        tableMisReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar esta reserva?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    int column = tableMisReservas.getColumnModel().getColumnIndexAtX(evt.getX());
                    int row = evt.getY() / tableMisReservas.getRowHeight();
                    if (row < tableMisReservas.getRowCount() && column == 4) {
                        Object idReservaObj = tableMisReservas.getValueAt(row, 0); // Obtén el valor de la columna "Numero reserva"
                        if (idReservaObj != null) {
                            int idReserva = Integer.parseInt(idReservaObj.toString()); // Convierte el valor a un entero si es necesario
                            buttonRendererDelete.buttonDeleteAction(idReserva, MisReservas.this);
                        }
                    }
                }
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMisReservas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(930, 560));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(930, 560));

        tableMisReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Numero reserva", "Fecha", "Hora", "Numero pista", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableMisReservas);
        if (tableMisReservas.getColumnModel().getColumnCount() > 0) {
            tableMisReservas.getColumnModel().getColumn(0).setResizable(false);
            tableMisReservas.getColumnModel().getColumn(1).setResizable(false);
            tableMisReservas.getColumnModel().getColumn(2).setResizable(false);
            tableMisReservas.getColumnModel().getColumn(3).setResizable(false);
            tableMisReservas.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Mis reservas");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tableMisReservas;
    // End of variables declaration//GEN-END:variables
}
