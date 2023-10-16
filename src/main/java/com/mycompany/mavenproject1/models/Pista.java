package com.mycompany.mavenproject1.models;
import java.util.ArrayList;
import java.sql.*;
import com.mycompany.mavenproject1.config.Conexion;
import java.sql.Connection;
import javax.swing.SwingWorker;
import com.mycompany.mavenproject1.views.ConfirmarInsercionDatos;
import com.mycompany.mavenproject1.views.GestionPistas;
public class Pista {
    private int id_pista;
    private String estado;
    // Constructor
    public Pista(int id_pista, String estado) {
        this.id_pista = id_pista;
        this.estado = estado;
    }
    
    //Getters and Setters

    public int getId_pista() {
        return id_pista;
    }

    public void setId_pista(int id_pista) {
        this.id_pista = id_pista;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    //METODOS
    public static ArrayList<Pista> obtenerPistasDB() throws SQLException{
        PreparedStatement preparedStatement;
        ArrayList<Pista> pistas;
        ResultSet datos;
        Connection connection = null;
        Conexion conexion = new Conexion();
        connection = conexion.establecerConexion();
            pistas = new ArrayList<>();
            // Consulta SQL para coger todos los datos de todas las pistas que hay
            String consultaSQL = "SELECT * FROM pistas;";
            preparedStatement = connection.prepareStatement(consultaSQL);
            //Ejecutar SQL
            datos = preparedStatement.executeQuery();
            //Recorrer todos los registros de la tabla pistas
            while (datos.next()) {
                int idPista = datos.getInt("id_pista");
                String estado = datos.getString("estado");
                Pista pista = new Pista(idPista,estado);
                pistas.add(pista);
            }
            preparedStatement.close();
            datos.close();
            return pistas;
        }
        public static void actualizarPista(int idPista, String nuevoEstado){
            try {
                Conexion conexion = new Conexion();
                Connection connection = conexion.establecerConexion();

                String consultaSQL = "UPDATE pistas SET estado = ? WHERE id_pista = ?;";
                PreparedStatement preparedStatement = connection.prepareStatement(consultaSQL);
                preparedStatement.setString(1, nuevoEstado);
                preparedStatement.setInt(2, idPista);
                // Ejecutar la actualización
                preparedStatement.executeUpdate();

                // Cerrar recursos
                preparedStatement.close();
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        
    public static void addPista(GestionPistas gestionPistas) {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    Conexion conexion = new Conexion();
                    Connection connection = conexion.establecerConexion();

                    String consultaSQL = "INSERT INTO pistas(estado) VALUES (?);";
                    PreparedStatement preparedStatement = connection.prepareStatement(consultaSQL);
                    preparedStatement.setString(1, "Available");

                    int filasAfectadas = preparedStatement.executeUpdate();

                    //Cerrar recursos
                    preparedStatement.close();
                    connection.close();
                    ConfirmarInsercionDatos viewConfirmarDatos = new ConfirmarInsercionDatos();
                    if (filasAfectadas > 0) {
                        gestionPistas.setVisible(false);
                        viewConfirmarDatos.setVisible(true);
                        ConfirmarInsercionDatos.labelConfirmar.setText("Se ha insertado la pista correctamente!");
                    } else {
                        viewConfirmarDatos.setVisible(true);
                        ConfirmarInsercionDatos.labelConfirmar.setText("ERROR");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
            }


        };
        worker.execute();


    }
    }  

