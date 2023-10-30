package com.mycompany.mavenproject1.views;


import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JFrame;
import com.mycompany.mavenproject1.views.*;
import com.mycompany.mavenproject1.controllers.*;
import com.mycompany.mavenproject1.models.Pista;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.DefaultCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;
public class GestionPistas extends javax.swing.JPanel {

    public GestionPistas() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        bAddPista = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePistas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(926, 540));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(926, 540));

        bAddPista.setText("Añadir");
        bAddPista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddPistaActionPerformed(evt);
            }
        });

        tablePistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        // Crear la tabla con dos columnas: ID de pista y Estado
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Hacer que la columna de ID de pista no sea editable (suponiendo que es la primera columna)
                return column != 0; // Establecer a true si quieres que otras columnas sean editables
            }
        };
        modelo.addColumn("ID de Pista");
        modelo.addColumn("Estado");

        // Configurar la tabla
        JTable tablePistas = new JTable(modelo);
        JScrollPane jScrollPane1 = new JScrollPane(tablePistas);

        // Obtener las pistas de la base de datos y agregarlas a la tabla
        ArrayList<Pista> pistas = null;
        try {
            pistas = Pista.obtenerPistasDB();
        } catch (SQLException ex) {
            // Manejo de excepciones
        }

        for (Pista pista : pistas) {
            Object[] newRow = {pista.getId_pista(), pista.getEstado()};
            modelo.addRow(newRow);
        }

        // Configurar JComboBox como editor de celda en la columna de Estado
        String[] estados = {"Available", "Ocupada", "Mantenimiento"};
        TableColumn col = tablePistas.getColumnModel().getColumn(1);
        JComboBox<String> comboBox = new JComboBox<>(estados);
        col.setCellEditor(new DefaultCellEditor(comboBox));

        modelo.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int fila = e.getFirstRow();
                    int columna = e.getColumn();
                    if (columna == 1) { // Si la columna es la de Estado
                        int idPista = (int) modelo.getValueAt(fila, 0);
                        System.out.print(idPista);
                        String nuevoEstado = (String) modelo.getValueAt(fila, columna);
                        System.out.print(nuevoEstado);
                        Pista.actualizarPista(idPista, nuevoEstado);
                    }
                }
            }
        });
        // Agregar la tabla a un contenedor
        bg.add(jScrollPane1);
        tablePistas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablePistas);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion de pistas");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bAddPista, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bAddPista, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void bAddPistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddPistaActionPerformed
       Pista.addPista(GestionPistas.this);
    }//GEN-LAST:event_bAddPistaActionPerformed
    public static void actualizarTablaPistas() {
        DefaultTableModel modelo = (DefaultTableModel) tablePistas.getModel();
        modelo.setRowCount(0);
        ArrayList<Pista> pistas = null;
        try {
            pistas = Pista.obtenerPistasDB();
        } catch (SQLException ex) {
            // Manejo de excepciones
        }
        for (Pista pista : pistas) {
            Object[] newRow = {pista.getId_pista(), pista.getEstado()};
            modelo.addRow(newRow);
        }
        modelo.fireTableDataChanged();
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddPista;
    public static javax.swing.JPanel bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablePistas;
    // End of variables declaration//GEN-END:variables
}
