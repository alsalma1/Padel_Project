package com.mycompany.mavenproject1.views;


import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.JFrame;
import com.mycompany.mavenproject1.views.*;
import com.mycompany.mavenproject1.controllers.*;
import com.mycompany.mavenproject1.models.Pista;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.DefaultCellEditor;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;
public class GestionPistas extends javax.swing.JFrame {

    public GestionPistas() {
        initComponents();
       
        setTitle("Gestión de Pistas");
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Container = new javax.swing.JPanel();
        bAddPista = new javax.swing.JButton();
        bSalirGestionPistas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePistas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bAddPista.setText("Añadir");
        bAddPista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddPistaActionPerformed(evt);
            }
        });

        bSalirGestionPistas.setText("Salir");
        bSalirGestionPistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirGestionPistasActionPerformed(evt);
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
        Container.add(jScrollPane1);
        tablePistas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablePistas);

        javax.swing.GroupLayout ContainerLayout = new javax.swing.GroupLayout(Container);
        Container.setLayout(ContainerLayout);
        ContainerLayout.setHorizontalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerLayout.createSequentialGroup()
                .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ContainerLayout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(bAddPista, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(207, 207, 207)
                        .addComponent(bSalirGestionPistas, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ContainerLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        ContainerLayout.setVerticalGroup(
            ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainerLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(ContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAddPista, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSalirGestionPistas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAddPistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddPistaActionPerformed
       Pista.addPista(GestionPistas.this);
       DefaultTableModel modelo = new DefaultTableModel();
       ArrayList<Pista> pistas = null;
       try {
           pistas = Pista.obtenerPistasDB();
       } catch (SQLException ex) {
           // Manejo de excepciones
       }
       modelo.setRowCount(0);
       for (Pista pista : pistas) {
            Object[] newRow = {pista.getId_pista(), pista.getEstado()};
            modelo.addRow(newRow); 
        }
       Container.setVisible(false);
       Container.setVisible(true);
    }//GEN-LAST:event_bAddPistaActionPerformed

    private void bSalirGestionPistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirGestionPistasActionPerformed
        AppController appController = new AppController();
        appController.salirGestionPistas(this);
    }//GEN-LAST:event_bSalirGestionPistasActionPerformed
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel Container;
    private javax.swing.JButton bAddPista;
    private javax.swing.JButton bSalirGestionPistas;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablePistas;
    // End of variables declaration//GEN-END:variables
}
