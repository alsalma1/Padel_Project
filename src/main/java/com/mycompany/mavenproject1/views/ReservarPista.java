package com.mycompany.mavenproject1.views;

import com.mycompany.mavenproject1.controllers.AppController;
import com.mycompany.mavenproject1.models.Reserva;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class ReservarPista extends javax.swing.JFrame {
    private static AppController appController = new AppController();
        
    private List<String> horas = new ArrayList<>();
    private List<Integer> pistas = new ArrayList<>();
    //Para guardar las horas y pistas de las reservas del usuario
    private List<String> horasUsuario = new ArrayList<>();
    private List<Integer> pistasUsuario = new ArrayList<>();
    
    private List<Integer> pistasEnMantenimiento = new ArrayList<>();
    private Date fechaSeleccionada;
    private String userEmail;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public List<String> getHoras() {
        return horas;
    }

    public List<Integer> getPistas() {
        return pistas;
    }
    //
     public List<String> getHorasUsuario() {
        return horasUsuario;
    }

    public List<Integer> getPistasUsuario() {
        return pistasUsuario;
    }
    //
    public List<Integer> getPistasMantenimiento() {
        return pistasEnMantenimiento;
    }
    
    public ReservarPista() {
        initComponents();
        setTitle("Reservar pista");
        setLocationRelativeTo(null);
        // Cambiar el tamaño de la columna 0
        TableColumn column = tablePistas.getColumnModel().getColumn(0);
        column.setPreferredWidth(12);
        tablePistas.setRowHeight(30);

        configurarFechaPistaListener();
        llenarPrimeraColumnaConHoras();
        //cambiarColorPrimeraFila();
        
        tablePistas.setEnabled(true);
        usuarioReservaPista();
        // Agregar un MouseListener a la tabla
    }
    
    public void showPistasMantenimiento(List<Integer> lista){
        for (int idPista : lista) {
            // Obtén el número de columna basado en el ID de Pista
            int colIndex = idPista;

            // Verifica si el índice de la columna es válido
            if (colIndex >= 1 && colIndex < tablePistas.getColumnCount()) {
                // Obtén el modelo de la tabla
                DefaultTableModel model = (DefaultTableModel) tablePistas.getModel();
                     
                // Itera a través de todas las filas de la tabla
                for (int row = 0; row < model.getRowCount(); row++) {
                    // Cambia el valor de la celda en la columna especificada a "Mantenimiento"
                    model.setValueAt("Mantenimiento", row, colIndex);
                }
                
                CustomCellRenderer customRenderer = new CustomCellRenderer();
                for (int i = 1; i < tablePistas.getColumnCount(); i++) {
                    tablePistas.getColumnModel().getColumn(i).setCellRenderer(customRenderer);
                }
            }
        }
    }

    private void configurarFechaPistaListener() {
        if(fechaPista.getDate()==null){
            btnActualizar.setVisible(false);
        }
        
        fechaPista.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    obtenerFechaSeleccionada();
                }
            }
        });
        
        // Obtén la fecha actual
        Date fechaActual = new Date();

        // Crea un calendario y agrega 7 días a la fecha actual
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaActual);
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        Date fechaMaxima = calendar.getTime();

        // Establece los límites mínimo y máximo para el JDateChooser
        fechaPista.setMinSelectableDate(fechaActual);
        fechaPista.setMaxSelectableDate(fechaMaxima);
    }
 
    private void obtenerFechaSeleccionada() {
        fechaSeleccionada = fechaPista.getDate();
        if (fechaSeleccionada != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Formato de fecha
            String fechaFormateada = sdf.format(fechaSeleccionada);
            //Crear una nueva fecha con el formato deseado
            btnActualizar.setVisible(true);
            try {
                fechaSeleccionada = sdf.parse(fechaFormateada);
                System.out.println("fecha :" +fechaSeleccionada);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            appController.buscarFecha(fechaSeleccionada);
            // Obtén el modelo de la tabla, que es necesario para actualizar las celdas.
            DefaultTableModel model = (DefaultTableModel) tablePistas.getModel();

            // Recorre la tabla y borra las celdas reservadas
            for (int row = 0; row < model.getRowCount(); row++) {
                for (int col = 1; col < model.getColumnCount(); col++) {
                    if ("Reservado".equals(model.getValueAt(row, col))) {
                        model.setValueAt("", row, col);
                    }
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
            mostrarReservasUsuario(fechaFormateada);
        }
        else{
            btnActualizar.setVisible(false);
        }
    }
    
    public void mostrarReservasUsuario(String fecha){
        appController.userReservas(fecha);
        // Obtén el modelo de la tabla, que es necesario para actualizar las celdas.
        DefaultTableModel model = (DefaultTableModel) tablePistas.getModel();

        // Recorre la tabla y borra las celdas reservadas
        for (int row = 0; row < model.getRowCount(); row++) {
            for (int col = 1; col < model.getColumnCount(); col++) {
                if ("reservaUsuario".equals(model.getValueAt(row, col))) {
                    model.setValueAt("", row, col);
                }
            }
        }

        // Llenar las celdas correspondientes en la tabla
        for (int i = 0; i < horasUsuario.size(); i++) {
            String hora = horasUsuario.get(i);
            int pista = pistasUsuario.get(i);
            // Encontrar la fila correspondiente a la hora
            int rowIndex = Integer.parseInt(hora.substring(0, 2)) - 9;

            // Encontrar la columna correspondiente a la pista
            int colIndex = pista;

            // Actualizar el valor de la celda en la tabla
            model.setValueAt("reservaUsuario", rowIndex, colIndex);
        }

        // Obtén el modelo de la tabla y establece el renderizador personalizado en la columna 1 y siguientes
        CustomCellRenderer customRenderer = new CustomCellRenderer();
        for (int i = 1; i < tablePistas.getColumnCount(); i++) {
            tablePistas.getColumnModel().getColumn(i).setCellRenderer(customRenderer);
        } 
    }   

    private void llenarPrimeraColumnaConHoras() {
        // Crea una instancia del renderizador personalizado
        ColorPrimeraColumna firstColumnRenderer = new ColorPrimeraColumna(); // Cambia Color.RED al color que desees

        // Establece el renderizador en la primera columna
        tablePistas.getColumnModel().getColumn(0).setCellRenderer(firstColumnRenderer);
        DefaultTableModel model = (DefaultTableModel) tablePistas.getModel();
        model.setRowCount(0);
        // Llena la primera columna con las horas desde las 8:00 hasta las 21:00
        for (int hora = 9; hora <= 21; hora++) {
            model.addRow(new Object[]{String.format("%02d:00", hora)});
        }
    }
    
    private void cambiarColorPrimeraFila(){
        // Establece el fondo verde para el encabezado de la tabla
        JTableHeader header = tablePistas.getTableHeader();
        header.setBackground(Color.decode("#6aa9e9")); // Establece el fondo del encabezado
        TableCellRenderer headerRenderer = header.getDefaultRenderer();
        if (headerRenderer instanceof DefaultTableCellRenderer) {
            ((DefaultTableCellRenderer) headerRenderer).setHorizontalAlignment(SwingConstants.CENTER);
            Font headerFont = new Font(((DefaultTableCellRenderer) headerRenderer).getFont().getName(), Font.BOLD, ((DefaultTableCellRenderer) headerRenderer).getFont().getSize());
            ((DefaultTableCellRenderer) headerRenderer).setFont(headerFont);
        }
    }
        
    public void usuarioReservaPista(){
        tablePistas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (fechaPista.getDate() != null) {
                    int row = tablePistas.getSelectedRow();
                    int col = tablePistas.getSelectedColumn();

                    // Verificar si la celda está vacía (sin texto)
                    DefaultTableModel model = (DefaultTableModel) tablePistas.getModel();
                    Object cellValue = model.getValueAt(row, col);
                    if (row >= 0 && col >= 1 && model.getValueAt(row, col) == null) {
                        tablePistas.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        String hora = (String) model.getValueAt(row, 0);
                        int pista = col;
                        String emailUsuarioLogeado = getUserEmail();
                        appController.hacerLaReserva(hora, pista, fechaSeleccionada, emailUsuarioLogeado);
                        //actualizarTabla(fechaSeleccionada);
                        //obtenerFechaSeleccionada();
                    } else {
                        appController.avisarUsuario(getUserEmail());
                        tablePistas.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Restablecer el cursor
                    }
                }else {
                    // Aviso al usuario para seleccionar una fecha primero
                    JOptionPane.showMessageDialog(null, "Selecciona una fecha antes de hacer una reserva.");
                }
            }
        });
    }
    
    public void actualizarTabla(Date fecha){
        // Establecer la fecha en el JDateChooser
        fechaPista.setDate(fecha);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

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
        jLabel2.setText("Mantenimiento");

        jPanel3.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Ocupada");

        btnActualizar.setText("Actualizar tabla");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnVolver.setText("Panel usuario");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(40, 152, 238));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Mis reservas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(btnActualizar)
                        .addGap(24, 24, 24)
                        .addComponent(btnVolver)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fechaPistaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaPistaKeyTyped
    }//GEN-LAST:event_fechaPistaKeyTyped

    private void fechaPistaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fechaPistaPropertyChange

    }//GEN-LAST:event_fechaPistaPropertyChange

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        obtenerFechaSeleccionada();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        AppController appController = new AppController();
        appController.volverAtras(this);
    }//GEN-LAST:event_btnVolverActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservarPista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnVolver;
    private com.toedter.calendar.JDateChooser fechaPista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePistas;
    // End of variables declaration//GEN-END:variables
}
