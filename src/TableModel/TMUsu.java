/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelo.Usuario;

/**
 *
 * @author sebba
 */
public class TMUsu extends AbstractTableModel {

    private final ArrayList<Usuario> listaDeUsuarios;

    public TMUsu(ArrayList<Usuario> listaUsuarios) {
        this.listaDeUsuarios = listaUsuarios;
    }

    @Override
    public int getRowCount() {
        return listaDeUsuarios.size();
    }

    @Override
    public int getColumnCount() {
        // Ajusta el número de columnas según la estructura de tu tabla de usuarios
        return 6;  // Supongamos que tienes seis propiedades: id, nombre, rut, correo, contraseña, tipoUsuario
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usuario = listaDeUsuarios.get(rowIndex);
        // Accede a la información de la clase Persona asociada al usuario
        // (asumiendo que Usuario extiende de Persona)
        return switch (columnIndex) {
            case 0 -> usuario.getId();
            case 1 -> usuario.getNombre();
            case 2 -> usuario.getRut() != null ? usuario.getRut() : "N/A";
            case 3 -> usuario.getCorreo() != null ? usuario.getCorreo() : "N/A";
            case 4 -> usuario.getTipoUsuario() != null ? usuario.getTipoUsuario() : "N/A";
            default -> "N/A";
        };
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nombre";
            case 2:
                return "RUT";
            case 3:
                return "Correo";
            case 4:
                return "Tipo de Usuario";
            default:
                return "";
        }
    }

    public void clear() {
        // Eliminar todas las filas
        listaDeUsuarios.clear();
        fireTableDataChanged();
    }
}
