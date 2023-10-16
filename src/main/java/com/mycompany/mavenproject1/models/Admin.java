package com.mycompany.mavenproject1.models;

import com.mycompany.mavenproject1.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {
    
    private String nombre_usuario;
    private String contrasena;
    
    // Constructor
    public Admin(String nombre_usuario, String contrasena) {
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    //Metodos
    public boolean comprobarDatos(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establece la conexión
            Conexion conexion = new Conexion();
            connection = conexion.establecerConexion();

            // Consulta SQL para verificar las credenciales
            String consultaSQL = "SELECT * FROM administrador WHERE nombre_usuario = ? AND contrasena = ?";
            preparedStatement = connection.prepareStatement(consultaSQL);
            preparedStatement.setString(1, getNombre_usuario());
            preparedStatement.setString(2, getContrasena());

            resultSet = preparedStatement.executeQuery();

            // Si hay al menos una fila, las credenciales son válidas
            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
  
