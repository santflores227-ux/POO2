import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Eliminador{
	public void eliminar(String consulta){
		try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:trabajadores.db";
            try (Connection conn = DriverManager.getConnection(url);
                 Statement stmt = conn.createStatement()) {
            	 Scanner teclado = new Scanner(System.in);
            	 stmt.executeUpdate(consulta);
            }
            
        } catch (ClassNotFoundException e) {
            System.err.println("Driver SQLite no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de base de datos: " + e.getMessage());
        }
	}
    public void eliminarDato(String consulta){
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:trabajadores.db";
            try (Connection conn = DriverManager.getConnection(url);
                 Statement stmt = conn.createStatement()) {
                 Scanner teclado = new Scanner(System.in);
                 stmt.executeUpdate(consulta);
            }
            
        } catch (ClassNotFoundException e) {
            System.err.println("Driver SQLite no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de base de datos: " + e.getMessage());
        }
    }
}