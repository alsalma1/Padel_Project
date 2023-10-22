package com.mycompany.mavenproject1.views;

import com.mycompany.mavenproject1.controllers.AppController;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ReservarPista extends javax.swing.JFrame {
    private static AppController appController = new AppController();
    
    private String hora;
    private int id_pista;
    
    public int getId_pista() {
        return id_pista;
    }

    public void setId_pista(int id_pista) {
        this.id_pista = id_pista;
    }
    
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    private List<String> horas = new ArrayList<>();
    private List<Integer> pistas = new ArrayList<>();
    
    public List<String> getHoras() {
        return horas;
    }

    public List<Integer> getPistas() {
        return pistas;
    }
    
    public ReservarPista() {
        initComponents();
        // Cambiar el tamaño de la columna 0
        TableColumn column = tablePistas.getColumnModel().getColumn(0);
        column.setPreferredWidth(12);
        tablePistas.setRowHeight(30);

        configurarFechaPistaListener();
        llenarPrimeraColumnaConHoras();
    }
    
    private void configurarFechaPistaListener() {
        fechaPista.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    obtenerFechaSeleccionada();
                }
            }
        });
    }
        
    /*private void obtenerFechaSeleccionada() {
        Date fechaSeleccionada = fechaPista.getDate();
        if (fechaSeleccionada != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Formato de fecha
            String fechaFormateada = sdf.format(fechaSeleccionada);

            // Crear una nueva fecha con el formato deseado
            try {
                fechaSeleccionada = sdf.parse(fechaFormateada);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            appController.buscarFecha(fechaSeleccionada);
            StringBuilder labelTextText = new StringBuilder();

            // Recorrer las listas de horas y pistas
            for (int i = 0; i < horas.size(); i++) {
                labelTextText.append("Hora: ").append(horas.get(i)).append(" Pista: ").append(pistas.get(i)).append("\n");
                System.out.println("Hora: "+horas.get(i)+" - Pista: "+pistas.get(i));
            }
            labelText.setText(labelTextText.toString());
            
            // Obtén el modelo de la tabla y establece el renderizador personalizado en la columna 1 y siguientes
            CustomCellRenderer customRenderer = new CustomCellRenderer(horas, pistas);
            for (int i = 1; i < tablePistas.getColumnCount(); i++) {
                tablePistas.getColumnModel().getColumn(i).setCellRenderer(customRenderer);
            }
        }    
    }*/
    private void obtenerFechaSeleccionada() {
        Date fechaSeleccionada = fechaPista.getDate();
        if (fechaSeleccionada != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Formato de fecha
            String fechaFormateada = sdf.format(fechaSeleccionada);

            // Crear una nueva fecha con el formato deseado
            try {
                fechaSeleccionada = sdf.parse(fechaFormateada);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            appController.buscarFecha(fechaSeleccionada);
            //Obtiene el modelo de la tabla, que es necesario para actualizar las celdas.
            DefaultTableModel model = (DefaultTableModel) tablePistas.getModel();

            // Limpiar todas las celdas de la tabla (Garantizar que la tabla se actualice correctamente al seleccionar una nueva fecha)
            for (int row = 0; row < model.getRowCount(); row++) {
                for (int col = 1; col < model.getColumnCount(); col++) {
                    model.setValueAt("", row, col);
                }
            }

            // Llenar las celdas correspondientes en la tabla
            for (int i = 0; i < horas.size(); i++) {
                String hora = horas.get(i);
                int pista = pistas.get(i);

                // Encontrar la fila correspondiente a la hora
                int rowIndex = Integer.parseInt(hora.substring(0, 2)) - 9;

                // Encontrar la columna correspondiente a la pista
                int colIndex = pista;

                // Actualizar el valor de la celda en la tabla
                model.setValueAt("Reservado", rowIndex, colIndex);
            }
            // Obtén el modelo de la tabla y establece el renderizador personalizado en la columna 1 y siguientes
            CustomCellRenderer customRenderer = new CustomCellRenderer();
            for (int i = 1; i < tablePistas.getColumnCount(); i++) {
                tablePistas.getColumnModel().getColumn(i).setCellRenderer(customRenderer);
            }
        }
    }

    private void llenarPrimeraColumnaConHoras() {
        DefaultTableModel model = (DefaultTableModel) tablePistas.getModel();
        model.setRowCount(0);
        // Llena la primera columna con las horas desde las 8:00 hasta las 21:00
        for (int hora = 9; hora <= 21; hora++) {
            model.addRow(new Object[]{String.format("%02d:00", hora)});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        fechaPista = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePistas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        fechaPista.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fechaPistaPropertyChange(evt);
            }
        });
        fechaPista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fechaPistaKeyTyped(evt);
            }
        });

        jLabel1.setText("Elige una fecha:  ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fechaPista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fechaPista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tablePistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "", "Pista 1", "Pista 2", "Pista 3", "Pista 4", "Pista 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablePistas);
        if (tablePistas.getColumnModel().getColumnCount() > 0) {
            tablePistas.getColumnModel().getColumn(1).setResizable(false);
            tablePistas.getColumnModel().getColumn(2).setResizable(false);
            tablePistas.getColumnModel().getColumn(3).setResizable(false);
            tablePistas.getColumnModel().getColumn(4).setResizable(false);
            tablePistas.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel2.setBackground(new java.awt.Color(255, 6, 6));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Ocupada");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fechaPistaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaPistaKeyTyped
    }//GEN-LAST:event_fechaPistaKeyTyped

    private void fechaPistaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fechaPistaPropertyChange

    }//GEN-LAST:event_fechaPistaPropertyChange

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservarPista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser fechaPista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePistas;
    // End of variables declaration//GEN-END:variables
}
