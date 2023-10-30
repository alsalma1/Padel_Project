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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableMisReservas = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();

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

        btnVolver.setText("Volver atras");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.setVisible(false);
        AppController appController = new AppController();
        appController.volverAtras(MisReservas.this);
    }//GEN-LAST:event_btnVolverActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MisReservas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tableMisReservas;
    // End of variables declaration//GEN-END:variables
}
