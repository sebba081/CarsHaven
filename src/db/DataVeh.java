package db;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Vehiculo;

/**
 *
 * @author antho
 */
public class DataVeh {
    
//    public static ArrayList<Vehiculo> getlistaVeh;
    private final List<Vehiculo> listaVeh;

    private Conexion con;

    public DataVeh(String db) throws SQLException {
        con = new Conexion(db);
        this.listaVeh = new ArrayList<>();
    }

    public void insertarVehiculo(Vehiculo a) throws SQLException {
        String query = "INSERT INTO vehiculos VALUES('"
                + a.getId()+ "','"
                + a.getMarca() + "','"
                + a.getModelo() + "','"
                + a.getPrecio()+ "',"
                + a.getTipo_id_fk()+ ")";
        con.ejecutarQuery(query);
    }

    public void ActualizarVehiculo(Vehiculo a) throws SQLException {
        String query = "UPDATE vehiculos SET "
                + "ID = '" + a.getId()+ "' , "
                + "marca = '" + a.getMarca() + "',"
                + "modelo = '" + a.getModelo() + "', "
                + "Precio = '" + a.getPrecio()+ "',"
                + "Tipo id = '" + a.getTipo_id_fk()+ "',"
                + "WHERE patente = '" + a.getId()+ "'";
        con.ejecutarQuery(query);
    }

    public void EliminarVehiculo(String id) throws SQLException {
        String query = "DELETE FROM vehiculos "
                + "WHERE "
                + "ID = '" + id + "'";
        con.ejecutarQuery(query);
    }

    public ArrayList<Vehiculo> getVehiculos() throws SQLException {

        String sql = "SELECT * FROM vehiculos;";
        ResultSet rs = con.ejecutarSelect(sql);
        ArrayList<Vehiculo> autoList = new ArrayList<>();

        while (rs.next()) {
            Vehiculo a = new Vehiculo();
            a.setId(Integer.parseInt("ID"));
            a.setMarca(rs.getString("marca"));
            a.setModelo(rs.getString("modelo"));
            a.setPrecio(Integer.parseInt("precio"));
            a.setTipo_id_fk(Integer.parseInt("Tipo id"));
            autoList.add(a);
        }
        return null;
    }

    public Vehiculo getVehiculoByid(String id) throws SQLException {
        String query = "SELECT * FROM vehiculos WHERE id = '" + id + "'";
        ResultSet rs = con.ejecutarSelect(query);

        if (rs.next()) {
            Vehiculo a = new Vehiculo();
            
            a.setId(Integer.parseInt("ID"));
            a.setMarca(rs.getString("marca"));
            a.setModelo(rs.getString("modelo"));
            a.setPrecio(Integer.parseInt("precio"));
            a.setTipo_id_fk(Integer.parseInt("Tipo_id"));
            con.CLOSE();
            return a;
        } else {
            con.CLOSE();
            return null;
        }
    }
}
