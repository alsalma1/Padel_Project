package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.config.Conexion;
import com.mycompany.mavenproject1.controllers.AppController;

public class Mavenproject1 {

    public static void main(String[] args) {
        //Para conectar Java con la bse de datos
        Conexion objetoConexion = new Conexion();
        objetoConexion.establecerConexion();
        
        //Mostar el login del administrador
        AppController appController = new AppController();
        appController.mostrarLogin();
        //appController.mostrarUsuarios();
        
    }
}
