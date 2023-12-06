package db;
/**
 * @author sebba
 */
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    private Connection conn;
    private Statement stat;

    public Conexion(String db) throws SQLException {
        String url = "jdbc:mysql://localhost/" + db + "?user=root&password=";
        System.out.println("[*] " + url);
        conn = DriverManager.getConnection(url);
        System.out.println("funka");
    }

    public void ejecutarQuery(String sql) throws SQLException {
        stat = conn.createStatement();
        stat.executeUpdate(sql);
        stat.close();
    }

    public ResultSet ejecutarSelect(String sql) throws SQLException{
        stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        return rs;
    }
    
    public void CLOSE() throws SQLException{
        stat.close();
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }
}
