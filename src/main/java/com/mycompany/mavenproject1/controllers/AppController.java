package com.mycompany.mavenproject1.controllers;

import com.mycompany.mavenproject1.Dashboard;
import com.mycompany.mavenproject1.DashboardAdmin;
import com.mycompany.mavenproject1.DashboardUsuario;
import com.mycompany.mavenproject1.models.Admin;
import com.mycompany.mavenproject1.models.Reserva;
import com.mycompany.mavenproject1.models.Usuario;
import com.mycompany.mavenproject1.views.AñadirUsuario;
import com.mycompany.mavenproject1.views.EditarUsuario;
import com.mycompany.mavenproject1.views.GestionPistas;
import com.mycompany.mavenproject1.views.GestionReservasAdmin;
import com.mycompany.mavenproject1.views.GestionUsuarios;
import com.mycompany.mavenproject1.views.LoginAdmin;
import com.mycompany.mavenproject1.views.LoginUsuario;
import com.mycompany.mavenproject1.views.MisReservas;
import com.mycompany.mavenproject1.views.PerfilUsuario;
import com.mycompany.mavenproject1.views.ReservarPista;
import com.mycompany.mavenproject1.views.UsuariosDesactivados;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AppController {
    
    public static EditarUsuario editUser = new EditarUsuario();
    public static AñadirUsuario añadirUsuario = new AñadirUsuario();
    public static GestionUsuarios gestionUsuarios = new GestionUsuarios();
    public static UsuariosDesactivados usuariosDesactivados = new UsuariosDesactivados();
    public static PerfilUsuario perfil;
    public static ReservarPista reservarPista;
    public static MisReservas misReservas = new MisReservas(); 
    public static DashboardAdmin dashA = new DashboardAdmin();
    public static Dashboard dashBoard = new Dashboard();
    public static String email;
    public static DashboardUsuario dashU;
    public static Usuario usuario = new Usuario();
    public static Admin admin = new Admin();
    
    private static final GestionReservasAdmin viewReservasAdmin = new GestionReservasAdmin();

    /* ------------------ Adminastrador --------------------- */
    
    public void verificarLogin(String email,String password){
        dashU = new DashboardUsuario(email);
        if(admin.esAdmin(email,password)){
            dashA.setVisible(true);
        } else if(usuario.esUsuario(email, password)){
            Usuario user = new Usuario();
            user.setEmail(email);
            String nombre = user.obtenerNombre();
            String mensaje = dashU.msg.getText()+" "+nombre;
            dashU.msg.setText(mensaje);
            dashU.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Datos incorerctos, intenta otra vez!");
            dashBoard.setVisible(true);
        }   
    }
    /* ----------------------------Manejo de paneles en la app------------------*/
    public void showJPanelDashboardAdmin(JPanel p){
        p.setSize(926, 540);
        p.setLocation(0,0);
        
        dashA.content.removeAll();
        dashA.content.setLayout(new BorderLayout()); // Asegúrate de establecer un BorderLayout si aún no lo has hecho
        dashA.content.add(p, BorderLayout.CENTER);
        dashA.content.revalidate();
        dashA.content.repaint();
    }
    /* ------------------ Usuario --------------------- */
    public void comprobarCredencialesUsuario(String email, String contraseña){
        Usuario user = new Usuario();
        user.setEmail(email);
        user.setContrasena(contraseña);
        if(user.comprobarDatosUsuario()){
            this.email = email;
            dashU.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "¡Datos incorerctos o usuario no registrado en el sistema, intenta otra vez!");
        }
    }
    
    public void mostrarUsuarios(){
        Usuario usuario = new Usuario();

        // Llamar al método obtenerUsuarios
        List<Usuario> usuarios = usuario.obtenerUsuarios();
        gestionUsuarios.cargarUsuariosEnTabla();

        if (usuarios.isEmpty()) {
            gestionUsuarios.panelTable.setVisible(false);
            // Crear y configurar el JTextField para mostrar el mensaje
            JTextField mensajeTextField = new JTextField("No hay ningún usuario registrado en el sistema.");
            mensajeTextField.setEditable(false);
            mensajeTextField.setBorder(null);
            mensajeTextField.setBackground(gestionUsuarios.getBackground());  // Asigna el color de fondo del contenedor
            mensajeTextField.setBounds(300, 250, 500, 50);  // Ajusta las coordenadas y tamaño según tu interfaz
            mensajeTextField.setFont(new java.awt.Font("Segoe UI", 1, 16));
            mensajeTextField.setForeground(Color.red);
            // Agregar el JTextField al contenedor
            gestionUsuarios.add(mensajeTextField);
        } else {
            gestionUsuarios.cargarUsuariosEnTabla();
        }
        // Mostrar la ventana de GestionUsuarios
        dashA.showJPanel(new GestionUsuarios());
    }
    public void datosUsurios(){
        // Llamar al método obtenerUsuarios
        List<Usuario> usuarios = usuario.obtenerUsuarios();
        gestionUsuarios.cargarUsuariosEnTabla();
    }
    public void añadirUsuario(String nombre, String apellido, String dni, String email, String telef, String socio, Date fecha){
        
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setDni(dni);
        usuario.setEmail(email);
        usuario.setTelefono(telef);
        usuario.setFoto("De momento no hay");
        
        //Cambiar el formato de la fecha a "yyyy-MM-dd"
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String birth = simpleDateFormat.format(fecha);
        
        //Cambiar la fecha de String a objeto Date
        try{
            
            Date fechaNacimiento = simpleDateFormat.parse(birth);
            // Convertir java.util.Date a java.sql.Date
            java.sql.Date fechaNacimientoSQL = new java.sql.Date(fechaNacimiento.getTime());
            usuario.setFecha_nacimiento(fechaNacimientoSQL);
            //ALGOOOOOs
            
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(socio.equals("Sí")) {
            usuario.setSocio(Boolean.TRUE);
        } else {
            usuario.setSocio(Boolean.FALSE);
        }
        
        //Generar contraseña aleatoria
        String randomString = generarRandomString();
        String contraseña = nombre.toLowerCase()+randomString;
        usuario.setContrasena(contraseña);
        
        if(usuario.existeUsuario() || admin.existeMailAdmin(email)){
            JOptionPane.showMessageDialog(null, "Este email o Dni ya estan registrados en el sistema, intenta otra vez!");
        }
        else{
            usuario.insertarUsuario();
            actualizarYMostrarUsuarios();
            showJPanelDashboardAdmin(new GestionUsuarios());
            // Actualiza y muestra la ventana de gestión de usuarios
        }
    }
    
    public boolean validarDNI_NIE(String dni_nie) {
        // Expresión regular para validar DNI (8 dígitos seguidos de una letra) o NIE (letra seguida de 7 dígitos y una letra)
        String regexDNI = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKET]{1}$";
        String regexNIE = "^[XYZ][0-9]{7}[TRWAGMYFPDXBNJZSQVHLCKET]{1}$";

        // Comprobar si cumple con el formato de DNI o NIE
        return dni_nie.matches(regexDNI) || dni_nie.matches(regexNIE);
    }

    public static String generarRandomString() {
        // Lista de caracteres que queremos considerar
        List<Character> characters = new ArrayList<>();
        for (char ch = 'a'; ch <= 'z' || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9'); ch++) {
            characters.add(ch);
        }
        // Generar la cadena aleatoria
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(characters.size());
            randomString.append(characters.get(randomIndex));
        }
        return randomString.toString();
    }
    
    public void mostrarDatosUsuario(String dni){
        Usuario user = usuario.datosUsuarioConDni(dni);
        String contraseña = "";
        // Imprime los datos de los usuarios
        System.out.println(user.getNombre());
        editUser.fieldNombre.setText(user.getNombre());
        editUser.fieldApellido.setText(user.getApellido());
        editUser.fieldDni.setText(user.getDni());
        editUser.fieldTelefono.setText(user.getTelefono());
        editUser.fieldEmail.setText(user.getEmail());
        editUser.fieldFecha.setDate(user.getFecha_nacimiento());
        contraseña = user.getContrasena();
        // Establecer selección del JComboBox basado en user.getSocio()
        if (user.getSocio()) {
            editUser.boxSocio.setSelectedItem("Sí");
        } else {
            editUser.boxSocio.setSelectedItem("No");
        }
        editUser.setContraseña(contraseña);
        showJPanelDashboardAdmin(editUser);
    }
    
    public void editarUsuario(String nombre, String apellido, String dni, String email, String telef, String socio, Date fecha, String contraseña){
        Usuario user = new Usuario();
        user.setNombre(nombre);
        user.setApellido(apellido);
        user.setTelefono(telef);
        user.setDni(dni);
        user.setEmail(email);
        user.setContrasena(contraseña);
        
        java.sql.Date fechaNacimientoSQL = new java.sql.Date(fecha.getTime());
        user.setFecha_nacimiento(fechaNacimientoSQL);  
        
        if(socio.equals("Sí")) {
            user.setSocio(Boolean.TRUE);
        } else {
            user.setSocio(Boolean.FALSE);
        }
        
        try {
            user.editarUsuario();
            JOptionPane.showMessageDialog(null, "Usuario modificado correctamente!");
            actualizarYMostrarUsuarios();
            showJPanelDashboardAdmin(new GestionUsuarios());
            // Actualiza y muestra la ventana de gestión de usuarios
        } catch (Exception e) {
            // Si hay un error, muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "Error al editar el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizarYMostrarUsuarios(){

        // Llamar al método obtenerUsuarios para obtener los datos actualizados
        List<Usuario> usuarios = usuario.obtenerUsuarios();

        // Cerrar la ventana anterior de GestionUsuarios si está abierta
        if (gestionUsuarios != null && gestionUsuarios.isVisible()) {
            dashA.showJPanel(new GestionUsuarios());
        }

        gestionUsuarios.cargarUsuariosEnTabla();

        // Mostrar la ventana de GestionUsuarios
        showJPanelDashboardAdmin(new GestionUsuarios());
    }
    public void desactivarUsuario(String dni, GestionUsuarios gestionUsuarios){
        Usuario user = new Usuario();
        user.setDni(dni);
        user.desactivar();
        JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente!");
        gestionUsuarios.setVisible(false);
        actualizarYMostrarUsuarios();
    }
    
    public void mostrarUsuariosDesactivados(){

        // Llamar al método obtenerUsuarios
        List<Usuario> usuarios = usuario.obtenerUsuariosDesactivados();
        UsuariosDesactivados usuariosDesactivados = new UsuariosDesactivados();

        if (usuarios.isEmpty()) {
            usuariosDesactivados.panelTable.setVisible(false);
            // Crear y configurar el JTextField para mostrar el mensaje
            JTextField mensajeTextField = new JTextField("No hay ningún usuario desactivado del sistema");
            mensajeTextField.setEditable(false);
            mensajeTextField.setBorder(null);
            mensajeTextField.setBackground(usuariosDesactivados.getBackground());  // Asigna el color de fondo del contenedor
            mensajeTextField.setBounds(300, 250, 500, 50);  // Ajusta las coordenadas y tamaño según tu interfaz
            mensajeTextField.setFont(new java.awt.Font("Segoe UI", 1, 16));
            mensajeTextField.setForeground(Color.red);
            // Agregar el JTextField al contenedor
            usuariosDesactivados.add(mensajeTextField);
        } else {
            usuariosDesactivados.mostrarTabla();
        }
        
        showJPanelDashboardAdmin(new UsuariosDesactivados());
    }
    
    public void activarUsuario(String dni, UsuariosDesactivados usuariosDesactivados){
        Usuario user = new Usuario();
        user.setDni(dni);
        user.activarUsuario();
        JOptionPane.showMessageDialog(null, "El usuario con DNI "+dni+" se ha activado correctamente!");
        mostrarUsuariosDesactivados();
        
    }

    public void mostrarPerfilUsuario(String email){        
        Usuario user = new Usuario();
        perfil = new PerfilUsuario();
        user.setEmail(email);

        List<Usuario> infoUser = user.datosUsuarioLogeado();
        for (Usuario usuario : infoUser) {
            perfil.labelNombre.setText(usuario.getNombre()+" "+usuario.getApellido());
            perfil.labelDni.setText(usuario.getDni());
            
            // Convertir la fecha al formato dd-MM-yyyy
            String fechaFormateada = convertirFormatoFecha(usuario.getFecha_nacimiento());
            perfil.labelFechaN.setText(fechaFormateada);
            perfil.labelEmail.setText(usuario.getEmail());
            perfil.labelTelefono.setText(usuario.getTelefono());
            
            //Mostrar la imagen del usuario
            String nombreImagen = usuario.getFoto();
            String rutaImagen = "/imagenes_usua/" + nombreImagen;
            // Cargar la imagen desde el archivo en la ruta proporcionada
            ImageIcon imagenIcon = new ImageIcon(getClass().getResource(rutaImagen));
            perfil.fotoUser.setIcon(imagenIcon);
            
            //Font
            Font fuentePersonalizada = new Font("Arial", Font.PLAIN, 14);
            perfil.labelEmail.setFont(fuentePersonalizada);
            perfil.labelDni.setFont(fuentePersonalizada);
            perfil.labelTelefono.setFont(fuentePersonalizada);
            perfil.labelFechaN.setFont(fuentePersonalizada);
        }
        dashU.showJPanel(perfil);
    }
    
    public String convertirFormatoFecha(Date fecha) {
        try {
            // Crear un formato para la fecha en formato dd-MM-yyyy
            SimpleDateFormat formatoDestino = new SimpleDateFormat("dd-MM-yyyy");

            // Formatear la fecha al nuevo formato
            return formatoDestino.format(fecha);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void mostrarMisReservas(String email){
        misReservas = new MisReservas();
        Reserva reserva = new Reserva();
        reserva.setEmail_usuario(email);
        misReservas.setUserEmail(email);
        List<Reserva> mevasReservas = reserva.reservasUsuarioLogeado();
        misReservas.cargarReservasEnTabla(mevasReservas);
        misReservas.setVisible(true);
        dashU.showJPanel(misReservas);
    }

    public void avisarUsuario(String emailUsuarioLogeado) {

    }

    /* ------------------ Login --------------------- */
    
        
    /* ------------------ Reservas --------------------- */
    public void mostrarPistas(String email){
        reservarPista = new ReservarPista(email);
        dashU.showJPanel(reservarPista);
    }
    public static void llenarPrimeraColumnaConHoras(DefaultTableModel modelo) {
    modelo.setRowCount(0);
    // Llena la primera columna con las horas desde las 8:00 hasta las 21:00
    for (int hora = 9; hora <= 21; hora++) {
        modelo.addRow(new Object[]{String.format("%02d:00", hora)});
        }
    }
    public void buscarFecha(Date fechaSeleccionada){
        Reserva reserva = new Reserva();
        java.sql.Date fechaSQL = new java.sql.Date(fechaSeleccionada.getTime()); // Convertir a java.sql.Date
        reserva.setFecha(fechaSQL);
        
        List<Reserva> resultados = reserva.existeFecha();
        List<Integer> pistasMantenimiento = reserva.pistasMantenimiento();
        
        // Limpiar las listas para evitar duplicados
        reservarPista.getHoras().clear();
        reservarPista.getPistas().clear();

        // Iterar a través de la lista de resultados
        for (Reserva datosReserva : resultados) {
            String hora = datosReserva.getHora();
            int idPista = datosReserva.getId_pista();

            // Agregar la hora y la pista a las listas
            reservarPista.getHoras().add(hora);
            reservarPista.getPistas().add(idPista);
        }
        reservarPista.showPistasMantenimiento(pistasMantenimiento);
    }
    
    public void hacerLaReserva(String hora, int pista, Date fecha, String email){
        //Obtener fecha actual
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        // Formatea la fecha en el formato deseado
        String fechaFormateada = fechaActual.format(formatterFecha);
       //Obtener hora actual
        LocalTime horaActual = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String horaActualFormateada = horaActual.format(formatter);
        Reserva reserva = new Reserva();
        reserva.setEmail_usuario(email);
        
        java.sql.Date fechaSeleccionada = new java.sql.Date(fecha.getTime());
        reserva.setFecha(fechaSeleccionada);
        reserva.setId_pista(pista);
        reserva.setHora(hora);
        LocalTime horaParaComparar = LocalTime.parse(hora, formatter);
        
        // Convierte la cadena "fechaFormateada" en un objeto Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaFormateadaDate = null;
        try {
            fechaFormateadaDate = dateFormat.parse(fechaFormateada);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    
        if(reserva.comprobarReserva()){
            JOptionPane.showMessageDialog(null, "No puedes reservar diferentes pistas en la misma hora y fecha!");
        }
        else if(horaParaComparar.isBefore(horaActual) && fechaFormateadaDate.equals(fecha)){
            JOptionPane.showMessageDialog(null, "No puedes reservar en una hora que ya ha pasado!");
        }
        else{
            reserva.reservar();
        }
    }
     
    public void userReservas(String fecha){
        Reserva reserva = new Reserva();
        //Convertir fecha de String a Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(fecha);
            java.sql.Date fechaSQL = new java.sql.Date(date.getTime());
            reserva.setEmail_usuario(reservarPista.userEmail);
            reserva.setFecha(fechaSQL);            
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Reserva> reservasUsuario = reserva.obtenerReservasUsuario();

        // Limpiar las listas para evitar duplicados
        reservarPista.getHorasUsuario().clear();
        reservarPista.getPistasUsuario().clear();
        
        for (Reserva reserva1 : reservasUsuario) {
            String hora = reserva1.getHora();
            int idPista = reserva1.getId_pista();
            // Agregar la hora y la pista a las listas
            reservarPista.getHorasUsuario().add(hora);
            reservarPista.getPistasUsuario().add(idPista);
        }
    }
    
    public void eliminarReserva(int idReserva, MisReservas misReservas, String email, int numPista, String hora, String fecha){
        Reserva reserva = new Reserva();
        ReservarPista reservarPista = new ReservarPista(email);
        reserva.setId_reserva(idReserva);
        reserva.eliminarReserva();
        //----------No olvidar poner un mensaje de confirmacion antes de borrar la reserva
        JOptionPane.showMessageDialog(null, "Tu reserva con numero "+idReserva+" se eliminó correctamente!");
        mostrarMisReservas(email);

        //Buscar el id de la reserva eliminada en la tabla reservasseleccionadas y comprobar si la fecha de la reserva es superior a la fecha actual
        if(reserva.reservaSeleccionadaEliminada()){
            String usu = reserva.usuarioReservaSelecionada();
            if(reserva.fechaEsSuperior()){
                reservarPista.createEmail(usu, numPista, hora, fecha);
                reservarPista.sendEmail();
            }
            else{
                JOptionPane.showMessageDialog(null, "La fecha no es superior");
            }
        }
    }
    
    
    public void guardarImagenEnCarpetaResources(String sourcePath, String destinationPath) {
        File sourceFile = new File(sourcePath);
        File destinationFile = new File(destinationPath);

        // Copiar el archivo desde la fuente al destino
        try {
            Path source = sourceFile.toPath();
            Path destination = destinationFile.toPath();
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void buscarReservaSeleccionada(Date fecha, String hora, int pista){
       Reserva reserva = new Reserva();
       
       java.sql.Date fechaSeleccionada = new java.sql.Date(fecha.getTime());
       reserva.setFecha(fechaSeleccionada);
       reserva.setHora(hora);
       reserva.setId_pista(pista);
       if(reserva.reservaSeleccionada()){
           System.out.println("Esta desactivada");
        }
    }
    
    public void guardarPistaSeleccionada(String email, Date fecha, String hora, int pista){
        Reserva reserva = new Reserva();
        java.sql.Date fechaSeleccionada = new java.sql.Date(fecha.getTime());
        reserva.setFecha(fechaSeleccionada);
        reserva.setHora(hora);
        reserva.setId_pista(pista);
        int idReserva = reserva.buscarIdReserva();
        guardarReserva(idReserva,email);
    }
    
    public void guardarReserva(int idReserva, String email){
        Reserva reserva = new Reserva();
        reserva.setEmail_usuario(email);
        reserva.setId_reserva(idReserva);
        reserva.guardarReservaSeleccionada();
    }
    
    public void desactivarReservasPasadas(){
        Reserva reserva = new Reserva();
        // Obtener la fecha y hora actual
        Calendar calendario = Calendar.getInstance();
        Date fechaActual = calendario.getTime();
        java.sql.Date fechaSql = new java.sql.Date(fechaActual.getTime());
        reserva.setFecha(fechaSql);
        reserva.desactivarReservasPasadas();
    }
    
    
}
