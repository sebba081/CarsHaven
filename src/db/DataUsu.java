/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
