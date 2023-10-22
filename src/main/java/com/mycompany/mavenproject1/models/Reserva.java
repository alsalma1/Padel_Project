package com.mycompany.mavenproject1.models;

import com.mycompany.mavenproject1.config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
}
