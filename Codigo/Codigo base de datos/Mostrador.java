import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Mostrador{
	public void mostrarTabla(String consulta,String[] nombres){
		try {
            Class.forName("org.sqlite.JDBC");

            String url = "jdbc:sqlite:trabajadores.db";

            try (Connection conn = DriverManager.getConnection(url);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(consulta)) {

                System.out.println("Registros de la tabla :");
                while (rs.next()) {
                    String campo1 = rs.getString(nombres[0]);
                    String campo2 = rs.getString(nombres[1]);
                    String campo3 = rs.getString(nombres[2]);
                    String campo4 = rs.getString(nombres[3]);

                    System.out.println(campo1 + " | " + campo2 + " | " + campo3 + " | " + campo4);
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Driver SQLite no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de base de datos: " + e.getMessage());
        }
	}
    public void mostrarTablas(String consulta){
        try {
            Class.forName("org.sqlite.JDBC");

            String url = "jdbc:sqlite:trabajadores.db";

            try (Connection conn = DriverManager.getConnection(url);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(consulta)) {

                System.out.println("Registros de la tablas :");
                while (rs.next()) {
                    String nombreT = rs.getString("NombreTabla");
                    System.out.println("| Nombre de la Tabla: "+ nombreT + " | ");
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Driver SQLite no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de base de datos: " + e.getMessage());
        }
    }
}