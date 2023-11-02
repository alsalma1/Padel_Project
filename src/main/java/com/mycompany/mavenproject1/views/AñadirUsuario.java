package com.mycompany.mavenproject1.views;

import com.mycompany.mavenproject1.controllers.AppController;
import com.mycompany.mavenproject1.models.Usuario;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class AñadirUsuario extends javax.swing.JPanel {

    private AppController appController = new AppController();
    private String filePath;
    private String fileName;
    
    public void setAppController(AppController appController) {
        this.appController = appController;
    }
    
    public AñadirUsuario() {
        initComponents();

    }
    
    private void limpiarCampos() {
        fieldNombre.setText("");
        fieldApellido.setText("");
        fieldDni.setText("");
        fieldEmail.setText("");
        fieldTelefono.setText("");
        boxSocio.setSelectedIndex(0);
        fieldFecha.setDate(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        fieldFecha = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        btnFile = new javax.swing.JButton();
        fieldEmail = new javax.swing.JTextField();
        returnIcon = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fieldDni = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAñadir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        fieldTelefono = new javax.swing.JTextField();
        fieldApellido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        boxSocio = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(926, 540));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(926, 540));

        fieldFecha.setDateFormatString("yyyy-MM-dd");

        jLabel5.setText("Fecha nacimiento");

        btnFile.setBackground(new java.awt.Color(204, 204, 204));
        btnFile.setText("Seleccionar archivo");
        btnFile.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileActionPerformed(evt);
            }
        });

        jLabel4.setText("Email");

        fieldDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldDniActionPerformed(evt);
            }
        });
        fieldDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldDniKeyTyped(evt);
            }
        });

        jLabel9.setText("Imagen");

        jLabel2.setText("Apellido");

        jLabel6.setText("Teléfono");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Añadir nuevo usuario");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAñadir.setText("Añadir");
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });

        jLabel7.setText("Socio");

        fieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNombreActionPerformed(evt);
            }
        });
        fieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNombreKeyTyped(evt);
            }
        });

        fieldTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTelefonoActionPerformed(evt);
            }
        });
        fieldTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldTelefonoKeyTyped(evt);
            }
        });

        fieldApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldApellidoKeyTyped(evt);
            }
        });

        jLabel1.setText("Nombre");

        boxSocio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        boxSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSocioActionPerformed(evt);
            }
        });

        jLabel3.setText("DNI");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(68, 68, 68)
                                .addComponent(btnFile, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(48, 48, 48)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addComponent(fieldTelefono)
                                        .addGap(31, 31, 31))
                                    .addComponent(fieldEmail)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addComponent(boxSocio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(68, 68, 68))))))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(btnAñadir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(102, 102, 102)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)))
                .addGap(483, 483, 483))
            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bgLayout.createSequentialGroup()
                    .addGap(146, 146, 146)
                    .addComponent(returnIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bgLayout.createSequentialGroup()
                            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgLayout.createSequentialGroup()
                                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(bgLayout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(2, 2, 2)))
                                    .addGap(68, 68, 68)
                                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(fieldNombre)
                                        .addComponent(fieldApellido)
                                        .addComponent(fieldDni)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(fieldFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGap(40, 40, 40))
                        .addGroup(bgLayout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(452, 452, 452)))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addContainerGap(257, Short.MAX_VALUE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(btnFile))
                .addGap(18, 18, 18)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(boxSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAñadir)
                    .addComponent(btnCancelar))
                .addGap(98, 98, 98))
            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bgLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bgLayout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(bgLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel1))
                                .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(22, 22, 22)
                            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(fieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(25, 25, 25)
                            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(fieldDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(26, 26, 26)
                            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(fieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(bgLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(returnIcon)))
                    .addContainerGap()))
        );

        Calendar calendar = Calendar.getInstance();
        Date fechaActual = calendar.getTime();

        // Establecer la fecha actual como el límite máximo para la selección
        fieldFecha.setMaxSelectableDate(fechaActual);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void boxSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSocioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxSocioActionPerformed

    private void fieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNombreActionPerformed

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        //El boton para añadir el usuario
        String nombre, apellido, dni, email, telef, socio;
        Date fecha;
        
        nombre = fieldNombre.getText();
        apellido = fieldApellido.getText();
        dni = fieldDni.getText().toUpperCase();
        email = fieldEmail.getText();
        telef = fieldTelefono.getText();
        socio = boxSocio.getSelectedItem().toString();
        fecha = fieldFecha.getDate();

            // Verificar que los campos no estén vacíos
        if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || email.isEmpty() ||
                telef.isEmpty() || socio.isEmpty() || fecha == null) {
            // Mostrar un mensaje indicando que todos los campos deben estar llenos
            if(fecha == null){
                JOptionPane.showMessageDialog(null, "Por favor, selecciona una fecha válida");
            }
            else{
                // Mostrar un mensaje indicando que todos los campos deben estar llenos
                JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
            }        
        } else {
            // Llamar a la función para añadir el usuario solo si todos los campos están llenos
            
            if(!appController.validarDNI_NIE(dni)){
                JOptionPane.showMessageDialog(this, "El DNI o NIE no tiene un formato válido", "Formato Inválido", JOptionPane.WARNING_MESSAGE);
            }
            else{
                // Guardar la ruta de la imagen en la base de datos
                Usuario user = new Usuario();
                user.setDni(dni);
                user.setFoto(fileName);
                // Generar el nombre de archivo de destino con la extensión
                String extension = getExtension(new File(fileName));
                String nombreArchivoDestino = dni + extension;

                // Copiar la imagen al directorio "sources"
                String destinoEnResources = "src/main/resources/imagenes_usua/" + fileName;
                appController.guardarImagenEnCarpetaResources(filePath, destinoEnResources);

                //appController.copiarImagen(filePath, destinationPath);
                //appController.copiarImagen(filePath, destinationPath);
                appController.añadirUsuario(nombre, apellido, dni, email, telef, socio, fecha);
                user.guardarImagen();

                limpiarCampos();
            }
        }
    }//GEN-LAST:event_btnAñadirActionPerformed

    private void fieldTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTelefonoActionPerformed

    private void fieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNombreKeyTyped
        // Verificar si la tecla presionada es una letra o un carácter especial permitido
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && c != ' ' && c != '\'') {
            // Si no es una letra o un carácter especial permitido, consumir el evento para ignorarlo
            evt.consume();
        }
    }//GEN-LAST:event_fieldNombreKeyTyped

    private void fieldTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTelefonoKeyTyped
        // Obtener el texto actual en el campo de teléfono
        String telefono = fieldTelefono.getText();

        // Verificar si la tecla presionada es un número y si no excede la longitud de 9 caracteres
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || telefono.length() >= 9) {
            // Si no es un número o excede la longitud, consumir el evento para ignorarlo
            evt.consume();
        }
    }//GEN-LAST:event_fieldTelefonoKeyTyped

    private void fieldDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldDniActionPerformed

    }//GEN-LAST:event_fieldDniActionPerformed

    private void fieldApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldApellidoKeyTyped
        // Verificar si la tecla presionada es una letra o un carácter especial permitido
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && c != ' ' && c != '\'') {
            // Si no es una letra o un carácter especial permitido, consumir el evento para ignorarlo
            evt.consume();
        }
    }//GEN-LAST:event_fieldApellidoKeyTyped

    private void fieldDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldDniKeyTyped
        String dni = fieldDni.getText();
        if (dni.length() >= 9) {
            // Si ya hay 9 dígitos, consumir el evento para evitar más ingreso
            evt.consume();
        }
    }//GEN-LAST:event_fieldDniKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        appController.showJPanelDashboardAdmin(new GestionUsuarios());
    }//GEN-LAST:event_btnCancelarActionPerformed

    private String getExtension(File file){
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return null; // No se encontró una extensión
        }
        return name.substring(lastIndexOf);
    }
    private void btnFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileActionPerformed
        JFileChooser jFileChooser = new JFileChooser();
        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("Imágenes (JPG, PNG)", "jpg", "png");
        jFileChooser.setFileFilter(filtrado);
        int respuesta = jFileChooser.showOpenDialog(this);

        if (respuesta == JFileChooser.APPROVE_OPTION) {
            // El usuario ha seleccionado un archivo
            File selectedFile = jFileChooser.getSelectedFile();
            filePath = selectedFile.getAbsolutePath(); // Guarda la ruta del archivo
            fileName = selectedFile.getName();
            // Obtener la extensión del archivo
            String extension = getExtension(selectedFile);
            if (extension != null) {

            }
        } 
    }//GEN-LAST:event_btnFileActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JComboBox<String> boxSocio;
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFile;
    private javax.swing.JTextField fieldApellido;
    private javax.swing.JTextField fieldDni;
    private javax.swing.JTextField fieldEmail;
    private com.toedter.calendar.JDateChooser fieldFecha;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JTextField fieldTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel returnIcon;
    // End of variables declaration//GEN-END:variables
}
