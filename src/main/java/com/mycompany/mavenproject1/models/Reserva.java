package com.mycompany.mavenproject1.models;

import java.sql.Date;

public class Reserva {
    
    private int id_reserva;
    private String email_usuario;
    private int id_pista;
    private Date fecha;
    private String hora;

    // Constructor
    public Reserva(int id_reserva, String email_usuario, int id_pista, Date fecha, String hora) {
        this.id_reserva = id_reserva;
        this.email_usuario = email_usuario;
        this.id_pista = id_pista;
        this.fecha = fecha;
        this.hora = hora;
    }
    
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
    
}
