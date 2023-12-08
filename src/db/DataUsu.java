/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Usuario;

/**
 *
 * @author sebba
 */
public class DataUsu {

    private Conexion conn;

    /**
     *
     * @param conexion
     */
    public DataUsu(Conexion conexion) {
        this.conn = conexion;
    }
    
    public void insertarUsuario(Usuario u) throws SQLException {
        String query = "INSERT INTO usuarios VALUES('"
                + u.getCorreo() + "','"
                + u.getContreseña() + "','"
                + u.getTipoUsuario()+  ")";
        conn.ejecutarQuery(query);
    }

    // Método para autenticar un usuario
    public boolean autenticarUsuario(String email, String password) throws SQLException {

        String query = "SELECT * FROM usuarios WHERE email = ? AND contraseña = ?";

        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); // Retorna true si hay al menos una fila
            }

        } catch (SQLException e) {
            return false;
        }
    }

    public boolean iniciarSesion(String email, String contraseña) {
        try {
            // Aquí puedes realizar la lógica de autenticación
            return autenticarUsuario(email, contraseña);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getUserTipo(String email) throws SQLException {
        String query = "SELECT tipo_usuario FROM usuarios u " +
                       "INNER JOIN tipo_usuario tu ON u.id_tipo_usuario = tu.id " +
                       "WHERE u.email = ?";
        
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("tipo_usuario");
                } else {
                    return null;  // User not found
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error retrieving user role.", e);
        }
    }

}
