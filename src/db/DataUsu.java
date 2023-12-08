/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Usuario;
import modelo.Vehiculo;

/**
 *
 * @author sebba
 */
public class DataUsu {

    private Conexion conn;
    private ArrayList<Object> listaUsu;

    /**
     *
     * @param conexion
     */
    public DataUsu(Conexion conexion) {
        this.conn = conexion;
    }

    public DataUsu(String db) throws SQLException {
        conn = new Conexion(db);
        this.listaUsu = new ArrayList<>();
    }

    public void insertarUsuario(Usuario u) throws SQLException {
        String query = "INSERT INTO usuarios VALUES('"
                + u.getCorreo() + "','"
                + u.getContreseña() + "','"
                + u.getTipoUsuario() + ")";
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
        String query = "SELECT tipo_usuario FROM usuarios u "
                + "INNER JOIN tipo_usuario tu ON u.id_tipo_usuario = tu.id "
                + "WHERE u.email = ?";

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

    public ArrayList<Vehiculo> getUsuario() throws SQLException {
        String sql = "SELECT * FROM vehiculos;";
        ResultSet rs = conn.ejecutarSelect(sql);
        ArrayList<Vehiculo> autoList = new ArrayList<>();

        while (rs.next()) {
            Vehiculo a = new Vehiculo();
            a.setId(rs.getInt("rut"));
            a.setMarca(rs.getString("nombre"));
            a.setModelo(rs.getString("email"));
            autoList.add(a);
        }
        return autoList;
    }
}
