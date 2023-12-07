package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Tipo;

/**
 *
 * @author antho
 */
public class DataTipos {

    private Conexion con;

    public DataTipos(String db) throws SQLException {
        con = new Conexion(db);
    }

    public void insertarTipos(Tipo t) throws SQLException {
        String query = "INSERT INTO tipos VALUES('"
                + t.getId_tipo() + "','"
                + t.getTipo() + ")";
        con.ejecutarQuery(query);
    }

    public void actualizarTipo(Tipo t) throws SQLException {
        String query = "UPDATE tipos SET "
                + "id = '" + t.getId_tipo() + "' , "
                + "tipo = '" + t.getTipo() + "',"
                + "WHERE patente = '" + t.getId_tipo() + "'";
        con.ejecutarQuery(query);
    }

    public void EliminarTipo(String id_tipos) throws SQLException {
        String query = "DELETE FROM tipos "
                + "WHERE "
                + "id = '" + id_tipos + "'";
        con.ejecutarQuery(query);
    }

    public ArrayList<Tipo> getTipos() throws SQLException {

        String sql = "SELECT * FROM tipos;";
        ResultSet rs = con.ejecutarSelect(sql);
        ArrayList<Tipo> tiposList = new ArrayList<>();

        while (rs.next()) {
            Tipo t = new Tipo();
            t.setId_tipo(Integer.parseInt("ID"));
            t.setTipo(rs.getString("rut"));
            tiposList.add(t);
        }
        return null;
    }
    
    public Tipo getTiposByid(String id_tipo) throws SQLException {
        String query = "SELECT * FROM tipos WHERE id = '" + id_tipo + "'";
        ResultSet rs = con.ejecutarSelect(query);

        if (rs.next()) {
            Tipo t = new Tipo();
            t.setId_tipo(Integer.parseInt("id"));
            t.setTipo(rs.getString("tipo"));
            con.CLOSE();
            return t;
        } else {
            con.CLOSE();
            return null;
        }
    }
}
