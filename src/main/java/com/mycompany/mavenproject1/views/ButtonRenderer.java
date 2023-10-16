package com.mycompany.mavenproject1.views;

import com.mycompany.mavenproject1.controllers.AppController;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

class ButtonRenderer extends DefaultTableCellRenderer {
    private JButton buttonEdit;
    private JButton buttonDelete;
    private JButton buttonActivar;
    
    private boolean editActionExecuted = false;
    private boolean deleteActionExecuted = false;
    private boolean activarActionExecuted = false;
    
    private String action = "";  // Nueva variable para almacenar la acción

    public void setAction(String action) {
        this.action = action;
    }

    public ButtonRenderer() {
        buttonEdit = new JButton("Editar");
        buttonDelete = new JButton("Eliminar");
        buttonActivar = new JButton("Activar");
        
        buttonEdit.setBackground(Color.decode("#00CC66"));
        buttonDelete.setBackground(Color.decode("#E32525"));
        buttonActivar.setBackground(Color.decode("#3399FF"));
    }

    public void buttonEditAction(String dni, GestionUsuarios gestionarUsuarios) {
        // Verificar si la acción ya se ejecutó para no cada vez que se clica en el boton llamar al metodo mostrarDatosUusario
        if (!editActionExecuted) {
            // Acción específica para el botón
            AppController appController = new AppController();
            appController.mostrarDatosUsuario(dni, gestionarUsuarios);
            editActionExecuted = true;  // Marcar que la acción se ejecutó
        }
    }

    public void buttonDeleteAction(String dni, GestionUsuarios gestionUsuarios) {
        if (!deleteActionExecuted) {
            AppController appController = new AppController();
            appController.desactivarUsuario(dni, gestionUsuarios);
            deleteActionExecuted = true;
        }
    }
    
    public void buttonActivarAction(String dni, UsuariosDesactivados usuariosDesactivados){
        if (!activarActionExecuted) {
            AppController appController = new AppController();
            appController.activarUsuario(dni, usuariosDesactivados);
            activarActionExecuted = true;
        }
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (column == 8) {
            if (action.equals("activar")) {
                return buttonActivar;  // Devolver el botón de activación para la columna 8
            } else if (action.equals("editar")) {
                return buttonEdit;  // Devolver el botón de edición para la columna 8
            }
        } else if (column == 9) {
            return buttonDelete;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}


