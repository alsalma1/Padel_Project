package com.mycompany.mavenproject1.views;

import com.mycompany.mavenproject1.controllers.AppController;
import com.mycompany.mavenproject1.models.Reserva;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
    }

    public void cargarReservasEnTabla(List<Reserva> lista) {
        DefaultTableModel model = (DefaultTableModel) tableMisReservas.getModel();
        model.setRowCount(0); // Limpiar la tabla antes de cargar los datos

        SimpleDateFormat formatoFechaNuevo = new SimpleDateFormat("dd-MM-yyyy");
        ButtonRenderer buttonRendererDelete = new ButtonRenderer();
        tableMisReservas.getColumnModel().getColumn(4).setCellRenderer(buttonRendererDelete);
        
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
        tableMisReservas.setRowHeight(40);
        tableMisReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
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
                "Numero reserva", "Fecha", "Hora", "Numero pista", ""
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
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Mis reservas");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 449, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tableMisReservas;
    // End of variables declaration//GEN-END:variables
}
