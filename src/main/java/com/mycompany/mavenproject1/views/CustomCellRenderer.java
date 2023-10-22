package com.mycompany.mavenproject1.views;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Comprueba si el valor de la celda es igual a "Reservado" y establece el fondo rojo si es así
        if ("Reservado".equals(value)) {
            component.setBackground(Color.RED);
            component.setForeground(Color.RED);
        } else {
            // Establece el fondo predeterminado en caso contrario
            component.setBackground(table.getBackground());
        }

        return component;
    }
}
