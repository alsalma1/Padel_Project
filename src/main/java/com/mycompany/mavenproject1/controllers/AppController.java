package com.mycompany.mavenproject1.controllers;

import com.mycompany.mavenproject1.models.Admin;
import com.mycompany.mavenproject1.models.Reserva;
import com.mycompany.mavenproject1.models.Usuario;
import com.mycompany.mavenproject1.views.AñadirUsuario;
import com.mycompany.mavenproject1.views.EditarUsuario;
import com.mycompany.mavenproject1.views.GestionPistas;
import com.mycompany.mavenproject1.views.GestionUsuarios;
import com.mycompany.mavenproject1.views.Inicio;
import com.mycompany.mavenproject1.views.LoginAdmin;
import com.mycompany.mavenproject1.views.LoginUsuario;
import com.mycompany.mavenproject1.views.MisReservas;
import com.mycompany.mavenproject1.views.PaginaPrincipalAdmin;
import com.mycompany.mavenproject1.views.PaginaPrincipalUsuario;
import com.mycompany.mavenproject1.views.PerfilUsuario;
import com.mycompany.mavenproject1.views.ReservarPista;
import com.mycompany.mavenproject1.views.UsuariosDesactivados;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AppController {
    
    public static PaginaPrincipalAdmin paginaPrincipalAdmin = new PaginaPrincipalAdmin();
    public static EditarUsuario editUser = new EditarUsuario();
    public static AñadirUsuario añadirUsuario = new AñadirUsuario();
    public static GestionUsuarios gestionUsuarios;
    public static UsuariosDesactivados usuariosDesactivados = new UsuariosDesactivados();
    public static PaginaPrincipalUsuario paginaPrincipalUsuario = new PaginaPrincipalUsuario();
    public static PerfilUsuario perfilUsuario = new PerfilUsuario();
    public static ReservarPista reservarPista = new ReservarPista();
    public static MisReservas misReservas = new MisReservas();

    private static final GestionPistas viewGestion = new GestionPistas();
    private static final PaginaPrincipalAdmin viewAdminPanel = new PaginaPrincipalAdmin();

    /* ------------------ Adminastrador --------------------- */
    public void mostrarLoginAdmin(Inicio inicio) {
        LoginAdmin loginView = new LoginAdmin();
        loginView.setVisible(true);
        inicio.setVisible(false);
    }
    
    public void comprobarCredenciales(String usuario, String contrasena, LoginAdmin login){
        Admin admin = new Admin(usuario, contrasena);
        if(admin.comprobarDatos()){
            // Las credenciales son válidas, abre la página principal del administrador
            paginaPrincipalAdmin.setVisible(true);
            login.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(null, "Datos incorerctos, intenta otra vez!");
        }
    }
    
    /* ------------------ Usuario --------------------- */
    public void mostrarLoginUsuario(Inicio inicio){
        LoginUsuario loginUser = new LoginUsuario();
        loginUser.setVisible(true);
        inicio.setVisible(false);
    }
    
    public void comprobarCredencialesUsuario(String email, String contraseña, LoginUsuario loginUsu){
        Usuario user = new Usuario();

        user.setEmail(email);
        user.setContrasena(contraseña);
        String nombre = user.obtenerNombre();
        if(user.comprobarDatosUsuario()){
            String texto = paginaPrincipalUsuario.labelUsu.getText()+" "+nombre;
            // Las credenciales son válidas, abre la página principal del usuario
            paginaPrincipalUsuario.setUserEmail(email);
            paginaPrincipalUsuario.labelUsu.setText(texto);
            paginaPrincipalUsuario.setVisible(true);
            loginUsu.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(null, "¡Datos incorerctos o usuario no registrado en el sistema, intenta otra vez!");
        }
    }
    
    public void mostrarUsuarios(PaginaPrincipalAdmin paginaPrincipalAdmin){
        Usuario usuario = new Usuario();

        // Llamar al método obtenerUsuarios
        List<Usuario> usuarios = usuario.obtenerUsuarios();
        GestionUsuarios gestionUsuarios = new GestionUsuarios();
        gestionUsuarios.cargarUsuariosEnTabla(usuarios);

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
            gestionUsuarios.cargarUsuariosEnTabla(usuarios);
        }
        // Mostrar la ventana de GestionUsuarios
        gestionUsuarios.setVisible(true);
        paginaPrincipalAdmin.setVisible(false);
    }
    
    public void mostrarVentanaAñadirUsuario(GestionUsuarios gestionUsuarios){
        añadirUsuario.setVisible(true);
        gestionUsuarios.setVisible(false);
    }
    public void datosUsurios(){
        Usuario usuario = new Usuario();
        // Llamar al método obtenerUsuarios
        List<Usuario> usuarios = usuario.obtenerUsuarios();
        GestionUsuarios gestionUsuarios = new GestionUsuarios();
        gestionUsuarios.cargarUsuariosEnTabla(usuarios);
    }
    public void añadirUsuario(String nombre, String apellido, String dni, String email, String telef, String socio, Date fecha, AñadirUsuario añadirUsuario){
        
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
        
        if(usuario.existeUsuario()){
            JOptionPane.showMessageDialog(null, "Este email o Dni ya estan registrados en el sistema, intenta otra vez!");
        }
        else{
            usuario.insertarUsuario();
            añadirUsuario.setVisible(false);
            // Actualiza y muestra la ventana de gestión de usuarios
            actualizarYMostrarUsuarios();
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
    
    public void mostrarDatosUsuario(String dni, GestionUsuarios gestionUsuarios){
        Usuario usuario = new Usuario();
        usuario.setDni(dni);
        List<Usuario> usuarios = usuario.datosUsuarioConDni();
        String contraseña = "";
        // Imprime los datos de los usuarios
        for (Usuario user : usuarios) {
            
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
        }
        editUser.setContraseña(contraseña);
        gestionUsuarios.setVisible(false);
        editUser.setVisible(true);
    }
    
    public void editarUsuario(String nombre, String apellido, String dni, String email, String telef, String socio, Date fecha, String contraseña, EditarUsuario editarUsuario){
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
            // Intenta editar el usuario
            user.editarUsuario();
            JOptionPane.showMessageDialog(null, "Usuario modificado correctamente!");
            editarUsuario.setVisible(false);
            // Actualiza y muestra la ventana de gestión de usuarios
            actualizarYMostrarUsuarios();
        } catch (Exception e) {
            // Si hay un error, muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "Error al editar el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizarYMostrarUsuarios(){
        Usuario usuario = new Usuario();

        // Llamar al método obtenerUsuarios para obtener los datos actualizados
        List<Usuario> usuarios = usuario.obtenerUsuarios();

        // Cerrar la ventana anterior de GestionUsuarios si está abierta
        if (gestionUsuarios != null && gestionUsuarios.isVisible()) {
            gestionUsuarios.dispose();
        }

        gestionUsuarios = new GestionUsuarios();  // Crear una nueva instancia
        gestionUsuarios.cargarUsuariosEnTabla(usuarios);

        // Mostrar la ventana de GestionUsuarios
        gestionUsuarios.setVisible(true);
    }
    public void desactivarUsuario(String dni, GestionUsuarios gestionUsuarios){
        Usuario user = new Usuario();
        user.setDni(dni);
        user.desactivar();
        JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente!");
        gestionUsuarios.setVisible(false);
        actualizarYMostrarUsuarios();
    }
    
    public void volverAtras(Object object){
        if(object instanceof EditarUsuario){
            editUser.setVisible(false);
            actualizarYMostrarUsuarios();
        }
        else if(object instanceof AñadirUsuario){
            añadirUsuario.setVisible(false);
            actualizarYMostrarUsuarios();
        }
        else if(object instanceof GestionUsuarios ){
            paginaPrincipalAdmin.setVisible(true);
        }
        else if(object instanceof UsuariosDesactivados){
            usuariosDesactivados.setVisible(false);
            actualizarYMostrarUsuarios();
        }
        else if(object instanceof PerfilUsuario){
            perfilUsuario.setVisible(false);
            paginaPrincipalUsuario.setVisible(true);
        }
        else if(object instanceof ReservarPista){
            reservarPista.setVisible(false);
            paginaPrincipalUsuario.setVisible(true);
        }
        else if(object instanceof MisReservas){
            misReservas.setVisible(false);
            JOptionPane.showMessageDialog(null, "TTT: "+perfilUsuario.getUserEmail());
            //mostrarPerfilUsuario(paginaPrincipalUsuario, misReservas.getUserEmail());
        }
    }
    
    public void mostrarUsuariosDesactivados(GestionUsuarios gestionUsuarios){
        Usuario usuario = new Usuario();

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
            usuariosDesactivados.mostrarTabla(usuarios);
        }
        
        gestionUsuarios.setVisible(false);
        usuariosDesactivados.setVisible(true);
    }
    
    public void activarUsuario(String dni, UsuariosDesactivados usuariosDesactivados){
        Usuario user = new Usuario();
        user.setDni(dni);
        user.activarUsuario();
        JOptionPane.showMessageDialog(null, "El usuario con DNI "+dni+" se ha activado correctamente!");
        usuariosDesactivados.setVisible(false);
        actualizarYMostrarUsuarios();
    }

    public void mostrarPerfilUsuario(PaginaPrincipalUsuario paginaPrincipalUsuario, String email){
        paginaPrincipalUsuario.setVisible(false);
        
        Usuario user = new Usuario();
        PerfilUsuario perfil = new PerfilUsuario();
        user.setEmail(email);

        List<Usuario> infoUser = user.datosUsuarioLogeado();

        for (Usuario usuario : infoUser) {
            perfil.labelNombre.setText(usuario.getNombre()+" "+usuario.getApellido());
            perfil.labelDni.setText(usuario.getDni());
            
            // Convertir la fecha al formato dd-MM-yyyy
            String fechaFormateada = convertirFormatoFecha(usuario.getFecha_nacimiento());
            perfil.labelFechaN.setText(fechaFormateada);
            perfil.labelPassw.setText(perfil.labelPassw.getText()+ " "+usuario.getContrasena());
            perfil.labelEmail.setText(usuario.getEmail());
            perfil.labelTelefono.setText(usuario.getTelefono());
        }
        perfil.setUserEmail(email);
        perfil.setVisible(true);
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
    
    public void mostrarMisReservas(PerfilUsuario perfilUsuario, String email){
        perfilUsuario.setVisible(false);
        MisReservas misReservas = new MisReservas();
        Reserva reserva = new Reserva();
        reserva.setEmail_usuario(email);
        misReservas.setUserEmail(email);
        List<Reserva> mevasReservas = reserva.reservasUsuarioLogeado();
        misReservas.cargarReservasEnTabla(mevasReservas);
        misReservas.setVisible(true);
    }

    public void avisarUsuario(String emailUsuarioLogeado) {

    }

    /* ------------------ Pistas --------------------- */
    public static void mostrarGestionPistas(){
        viewGestion.setVisible(true);
    }
    public static void salirGestionPistas(GestionPistas viewGestion){
        viewGestion.setVisible(false);
        viewAdminPanel.setVisible(true);
    }
        
    /* ------------------ Reservas --------------------- */
    public void mostrarPistas(String email){
        paginaPrincipalUsuario.setVisible(false);
        reservarPista.setVisible(true);
        reservarPista.setUserEmail(email);
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
        Reserva reserva = new Reserva();
        reserva.setEmail_usuario(email);
        
        java.sql.Date fechaSeleccionada = new java.sql.Date(fecha.getTime());
        reserva.setFecha(fechaSeleccionada);
        reserva.setId_pista(pista);
        reserva.setHora(hora);
        reserva.reservar();
    }
     
    public void userReservas(String fecha){
        Reserva reserva = new Reserva();
        //Convertir fecha de String a Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(fecha);
            java.sql.Date fechaSQL = new java.sql.Date(date.getTime());
            reserva.setEmail_usuario(reservarPista.getUserEmail());
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
    
    public void eliminarReserva(int idReserva, MisReservas misReservas){
        Reserva reserva = new Reserva();
        reserva.setId_reserva(idReserva);
        reserva.eliminarReserva();
        //----------No olvidar poner un mensaje de confirmacion antes de borrar la reserva
        JOptionPane.showMessageDialog(null, "Tu reserva con numero "+idReserva+"se eliminó correctamente!");
    }
}
