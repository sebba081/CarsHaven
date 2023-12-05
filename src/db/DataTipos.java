package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Tipos;

/**
 *
 * @author antho
 */
public class DataTipos {

    private Conexion con;

    public DataTipos(String db) throws SQLException {
        con = new Conexion(db);
    }

    public void insertarTipos(Tipos t) throws SQLException {
        String query = "INSERT INTO tipos VALUES('"
                + t.getId_tipo() + "','"
                + t.getTipo() + ")";
        con.ejecutar(query);
    }

    public void actualizarTipo(Tipos t) throws SQLException {
        String query = "UPDATE tipos SET "
                + "id = '" + t.getId_tipo() + "' , "
                + "tipo = '" + t.getTipo() + "',"
                + "WHERE patente = '" + t.getId_tipo() + "'";
        con.ejecutar(query);
    }

    public void EliminarTipo(String id_tipos) throws SQLException {
        String query = "DELETE FROM tipos "
                + "WHERE "
                + "id = '" + id_tipos + "'";
        con.ejecutar(query);
    }

    public ArrayList<Tipos> getTipos() throws SQLException {

        String sql = "SELECT * FROM tipos;";
        ResultSet rs = con.select(sql);
        ArrayList<Tipos> tiposList = new ArrayList<>();

        while (rs.next()) {
            Tipos t = new Tipos();
            t.setId_tipo(Integer.parseInt("ID"));
            t.setTipo(rs.getString("rut"));
            tiposList.add(t);
        }
        return null;
    }
    
    public Tipos getTiposByid(String id_tipo) throws SQLException {
        String query = "SELECT * FROM tipos WHERE id = '" + id_tipo + "'";
        ResultSet rs = con.select(query);

        if (rs.next()) {
            Tipos t = new Tipos();
            t.setId_tipo(Integer.parseInt("id"));
            t.setTipo(rs.getString("tipo"));
            con.cerrarStatement();
            return t;
        } else {
            con.cerrarStatement();
            return null;
        }
    }
}
