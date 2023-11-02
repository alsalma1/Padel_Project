package com.mycompany.mavenproject1.models;

import com.mycompany.mavenproject1.config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

public class Reserva {
    
    private int id_reserva;
    private String email_usuario;
    private int id_pista;
    private Date fecha;
    private String hora;
    
    //Getters and Setters
    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public int getId_pista() {
        return id_pista;
    }

    public void setId_pista(int id_pista) {
        this.id_pista = id_pista;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    //Metodos
    public List<Reserva> existeFecha() {        
        List<Reserva> datosReserva = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {            
            // Establecer conexión a la base de datos
            Conexion conn = new Conexion();
            connection = conn.establecerConexion();

            // Consulta SQL para obtener la cuenta de registros
            String sqlCount = "SELECT COUNT(*) AS count FROM reservas WHERE fecha = ?";
            preparedStatement = connection.prepareStatement(sqlCount);

            // Establecer los valores para los parámetros
            preparedStatement.setDate(1, getFecha());

            // Ejecutar la consulta
            resultSet = preparedStatement.executeQuery();
            // Verificar si hay al menos un registro
            if (resultSet != null && resultSet.next()) {
                int count = resultSet.getInt("count");
                if (count > 0) {
                    // Si count es mayor que 0, realizar otra consulta para obtener la hora y el id_pista
                    String sqlSelect = "SELECT hora, id_pista FROM reservas WHERE fecha = ?";
                    preparedStatement = connection.prepareStatement(sqlSelect);
                    preparedStatement.setDate(1, getFecha());

                    resultSet = preparedStatement.executeQuery();

                    // Verificar si hay resultados
                    while (resultSet != null && resultSet.next()) {
                        String hora = resultSet.getString("hora");
                        int idPista = resultSet.getInt("id_pista");

                        // Crear un objeto datosReserva para cada resultado y agregarlo a la lista
                        Reserva reserva = new Reserva();
                        reserva.setHora(hora);
                        reserva.setId_pista(idPista);

                        datosReserva.add(reserva);
                    }
                }
            }
            return datosReserva; // Devolver la lista de resultados
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList(); // Devolver una lista vacía en caso de error
        } finally {
            // Cerrar recursos
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }  
    
        public List<Integer> pistasMantenimiento() {
        
        List<Integer> pistas = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {            
            // Establecer conexión a la base de datos
            Conexion conn = new Conexion();
            connection = conn.establecerConexion();

            // Consulta SQL para obtener la cuenta de registros
            String sql = "SELECT id_pista FROM pistas WHERE estado = 'Mantenimiento'";
            preparedStatement = connection.prepareStatement(sql);

            // Ejecutar la consulta
            resultSet = preparedStatement.executeQuery();
            
            // Procesa los resultados
            while (resultSet.next()) {
                int idPista = resultSet.getInt("id_pista");
                pistas.add(idPista);
            }
            return pistas; // Devolver la lista de resultados
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList(); // Devolver una lista vacía en caso de error
        } finally {
            // Cerrar recursos
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }  
        
    public void reservar(){
                
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {            
            // Establecer conexión a la base de datos
            Conexion conn = new Conexion();
            connection = conn.establecerConexion();

            // Consulta SQL para obtener usuarios
            String sql = "INSERT INTO reservas (email_usuario, id_pista, fecha, hora, activa) VALUES (?, ?, ?, ?, 1)";
            preparedStatement = connection.prepareStatement(sql);

            // Establecer los valores para los parámetros
            preparedStatement.setString(1, getEmail_usuario());
            preparedStatement.setInt(2, getId_pista());
            preparedStatement.setDate(3, getFecha());
            preparedStatement.setString(4, getHora());
            
            // Ejecutar la consulta de inserción
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Has reservado la pista "+getId_pista()+", el dia "+getFecha()+" a las "+getHora());
        } catch (SQLException e) {
            //
        } finally {
            // Cerrar recursos
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                 // Manejo de errores: imprime el error en la consola
            }
        }
    }

    public List<Reserva> obtenerReservasUsuario(){
        List<Reserva> reservasUsuario = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {            
            // Establecer conexión a la base de datos
            Conexion conn = new Conexion();
            connection = conn.establecerConexion();

            String sqlCount = "SELECT * FROM reservas WHERE email_usuario = ? AND fecha = ?";
            preparedStatement = connection.prepareStatement(sqlCount);
            preparedStatement.setString(1, getEmail_usuario());
            preparedStatement.setDate(2, getFecha());
            resultSet = preparedStatement.executeQuery();
            int rowCount = 0;
            while (resultSet != null && resultSet.next()) {
                String hora = resultSet.getString("hora");
                int idPista = resultSet.getInt("id_pista");

                // Crear un objeto datosReserva para cada resultado y agregarlo a la lista
                Reserva reserva = new Reserva();
                reserva.setHora(hora);
                reserva.setId_pista(idPista);
                reservasUsuario.add(reserva);
                rowCount++;
            }
            
            return reservasUsuario; // Devolver la lista de resultados
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList(); // Devolver una lista vacía en caso de error
        } finally {
            // Cerrar recursos
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Reserva> reservasUsuarioLogeado(){
        List<Reserva> misReservas = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {            
            // Establecer conexión a la base de datos
            Conexion conn = new Conexion();
            connection = conn.establecerConexion();

            String sqlCount = "SELECT * FROM reservas WHERE email_usuario = ? AND activa = 1";
            preparedStatement = connection.prepareStatement(sqlCount);
            preparedStatement.setString(1, getEmail_usuario());
            resultSet = preparedStatement.executeQuery();
            int rowCount = 0;
            while (resultSet != null && resultSet.next()) {
                int numReserva = resultSet.getInt("id_reserva");
                Date fecha = resultSet.getDate("fecha");
                String hora = resultSet.getString("hora");
                int idPista = resultSet.getInt("id_pista");

                // Crear un objeto datosReserva para cada resultado y agregarlo a la lista
                Reserva reserva = new Reserva();
                reserva.setId_reserva(numReserva);
                reserva.setHora(hora);
                reserva.setId_pista(idPista);
                reserva.setFecha(fecha);
                misReservas.add(reserva);
                rowCount++;
            }
            
            return misReservas; // Devolver la lista de resultados
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList(); // Devolver una lista vacía en caso de error
        } finally {
            // Cerrar recursos
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void eliminarReserva(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Establecer conexión a la base de datos
            Conexion conn = new Conexion();
            connection = conn.establecerConexion();

            // Crear la consulta SQL con un PreparedStatement y parámetros
            String sql = "UPDATE reservas SET activa = 0 WHERE id_reserva = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, getId_reserva());

            // Ejecutar la consulta
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    //Este metodo tiene que comprobar si existe una reserva del mismo usuario en la misma fecha y hora pero diferentes pistas
    public boolean comprobarReserva(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {            
            // Establecer conexión a la base de datos
            Conexion conn = new Conexion();
            connection = conn.establecerConexion();

            // Consulta SQL para obtener usuarios
            String sql = "SELECT COUNT(*) AS count FROM reservas WHERE email_usuario = ? AND fecha = ? AND hora = ? AND id_pista != ?";
            preparedStatement = connection.prepareStatement(sql);

            // Establecer los valores para los parámetros
            preparedStatement.setString(1, getEmail_usuario());
            preparedStatement.setDate(2, getFecha());
            preparedStatement.setString(3, getHora());
            preparedStatement.setInt(4, getId_pista());
            
            // Ejecutar la consulta de inserción
            resultSet = preparedStatement.executeQuery();
            
            // Verificar si hay al menos un registro
            if (resultSet != null && resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0;
            }
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Cerrar recursos
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
