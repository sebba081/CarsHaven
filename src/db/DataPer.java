package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Persona;

/**
 *
 * @author antho
 */
public class DataPer {

    private Conexion conn;

    public DataPer(String db) throws SQLException {
        conn = new Conexion(db);
    }

    public void insertarPersona(Persona p) throws SQLException {
        String query = "INSERT INTO personas VALUES('"
                + p.getId() + "','"
                + p.getRut() + "','"
                + p.getNombre() + "','"
                + p.getCorreo() + ")";
        conn.ejecutar(query);
    }

    public ArrayList<Persona> getPersonas() throws SQLException {

        String sql = "SELECT * FROM personas;";
        ResultSet rs = conn.select(sql);
        ArrayList<Persona> personaList = new ArrayList<>();

        while (rs.next()) {
            Persona p = new Persona();
            p.setId(Integer.parseInt("id"));
            p.setRut(rs.getString("rut"));
            p.setNombre(rs.getString("nombre"));
            p.setCorreo(rs.getString("email"));
            personaList.add(p);
        }
        return null;
    }
    
    public Persona getPersonaByid(String id_personas) throws SQLException {
        String query = "SELECT * FROM personas WHERE id = '" + id_personas + "'";
        ResultSet rs = conn.select(query);

        if (rs.next()) {
            Persona p = new Persona();
            p.setId(Integer.parseInt("id"));
            p.setRut(rs.getString("rut"));
            p.setNombre(rs.getString("nombre"));
            p.setCorreo(rs.getString("email"));
            conn.cerrarStatement();
            return p;
        } else {
            conn.cerrarStatement();
            return null;
        }
    }
    public static boolean verificarLogin(String rut, String contraseña) throws SQLException {
        String sql = "SELECT * FROM personas WHERE rut = ? AND contraseña = ?";
    
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, rut);
            statement.setString(2, contraseña);
        
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // Si hay al menos una fila, el login es exitoso
            }
        } catch (SQLException e) {
        // Considera lanzar una excepción personalizada o manejar de manera adecuada
            e.printStackTrace();
            throw e;
        }
    }
}
