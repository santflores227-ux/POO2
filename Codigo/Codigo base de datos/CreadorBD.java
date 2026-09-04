import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class CreadorBD {
	CreadorConsulta consulta;
	Mostrador mostrador;
	GeneradorBaseDatos bd;
	Añadidor añadidor;
	static Scanner teclado;
	Eliminador terminator;
	public CreadorBD() {
    mostrador = new Mostrador();
    bd = new GeneradorBaseDatos();
    añadidor = new Añadidor();
    consulta = new CreadorConsulta(); 
    terminator = new Eliminador();
	}
	public static void main(String[] args){
		teclado = new Scanner(System.in);
		CreadorBD dbc = new CreadorBD();
		dbc.crearTablaT();
		dbc.MostrarMenu();
	}
	public void MostrarMenu(){
		boolean ejecutando = true;
		while(ejecutando == true){
			int respuesta;
			System.out.println("Menu");
			System.out.println("Crear tabla:1");
			System.out.println("Mostrar tabla:2");
			System.out.println("Insertar dato en tabla:3");
			System.out.println("Eliminar Tabla:4");
			System.out.println("Eliminar Dato de una tabla:5");
			System.out.println("Mostrar Tablas:6");
			System.out.println("Salir: 7");
			System.out.println("--------------------------------");
			respuesta = teclado.nextInt();
			teclado.nextLine();
			switch(respuesta){
			case 1:
				crearTabla();
				break;
			case 2:
				mostrarTabla();
				break;
			case 3:
				insertarDato();
				break;
			case 4:
				eliminarTabla();
				break;
			case 5:
				eliminarDato();
				break;
			case 6:
				mostrarTablas();
				break;
			default:
				System.out.println("Saliendo del sistema");
				ejecutando = false;
				break;
			}
		}
	}

	public void crearTabla(){
		String nombre;
			System.out.println("Ingrese el nombre de la tabla:");
			nombre = teclado.nextLine();
			String campo1;
			System.out.println("Ingrese el primer campo");
			campo1 = teclado.nextLine();
			String tipo1;
			System.out.println("Ingrese de que tipo es el campo");
			System.out.println("1:TEXT 2:INT");
			tipo1 = teclado.nextLine();
			String campo2;
			System.out.println("Ingrese el segundo campo");
			campo2 = teclado.nextLine();
			String tipo2;
			System.out.println("Ingrese de que tipo es el campo");
			System.out.println("1:TEXT 2:INT");
			tipo2 = teclado.nextLine();
			String campo3;
			System.out.println("Ingrese el tercer campo");
			campo3 = teclado.nextLine();
			String tipo3;
			System.out.println("Ingrese de que tipo es el campo");
			System.out.println("1:TEXT 2:INT");
			tipo3 = teclado.nextLine();
			String campo4;
			System.out.println("Ingrese el cuarto campo");
			campo4 = teclado.nextLine();
			String tipo4;
			System.out.println("Ingrese de que tipo es el campo");
			System.out.println("1:TEXT 2:INT");
			tipo4 = teclado.nextLine();
			String sqlC;
			sqlC = consulta.consultaCrear(
				nombre,
				campo1, tipo1,
				campo2, tipo2,
				campo3, tipo3,
				campo4, tipo4
			);
			bd.generarTabla(sqlC);
			actualizarTT(nombre,
				campo1,
				campo2,
				campo3,
				campo4,
				tipo1,
				tipo2,
				tipo3,
				tipo4
			);
	}
	public void mostrarTabla(){
		String respuesta;
		System.out.println("Ingrese el nombre de la tabla");
		respuesta=teclado.nextLine();
		String sql;
		sql=consulta.consultaMostrar(respuesta);
		mostrador.mostrarTabla(sql,buscarCampos(respuesta));
	}
	public void crearTablaT(){
		String consultasql = "CREATE TABLE IF NOT EXISTS TablaDeTablas ( "
			+ "NombreTabla TEXT,"
			+ "campo1 TEXT,"
			+ "campo2 TEXT,"
			+ "campo3 TEXT,"
			+ "campo4 TEXT,"
			+ "tipoC1 TEXT,"
			+ "tipoC2 TEXT,"
			+ "tipoC3 TEXT,"
			+ "tipoC4 TEXT"
			+");";
		bd.generarTabla(consultasql);
	}
	public void actualizarTT(String nombreTabla,
		String valor1,
		String valor2,
		String valor3,
		String valor4,
		String tipo1,
		String tipo2,
		String tipo3,
		String tipo4
	){
		String consulta = "INSERT INTO TablaDeTablas (NombreTabla, campo1, campo2, campo3, campo4, tipoC1, tipoC2, tipoC3, tipoC4) VALUES ('" + nombreTabla + "', '" + valor1 + "', '" + valor2 + "', '" + valor3 + "', '" + valor4 +"', '" + tipo1 + "', '" + tipo2 + "', '" + tipo3 + "', '" + tipo4 + "')";
		añadidor.añadirDato(consulta);
	}
	public String[] buscarCampos(String nombre){
		String[] campos = new String[4];
        String url = "jdbc:sqlite:trabajadores.db";
        String sql = "SELECT campo1, campo2, campo3, campo4 FROM TablaDeTablas WHERE nombreTabla = ?";

        try {
            Class.forName("org.sqlite.JDBC");

            try (Connection conn = DriverManager.getConnection(url);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nombre);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        campos[0] = rs.getString("campo1");
                        campos[1] = rs.getString("campo2");
                       	campos[2] = rs.getString("campo3");
                        campos[3] = rs.getString("campo4");
                    } else {
                        System.out.println("No se encontró la tabla '" + nombre + "' en TablaDeTablas.");
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Driver SQLite no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de base de datos: " + e.getMessage());
        }

        return campos;
	}
	public String[] buscartipos(String nombre){
		String[] campos = new String[4];
        String url = "jdbc:sqlite:trabajadores.db";
        String sql = "SELECT tipoC1, tipoC2, tipoC3, tipoC4 FROM TablaDeTablas WHERE NombreTabla = ?";

        try {
            Class.forName("org.sqlite.JDBC");

            try (Connection conn = DriverManager.getConnection(url);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nombre);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        campos[0] = rs.getString("tipoC1");
                        campos[1] = rs.getString("tipoC2");
                       	campos[2] = rs.getString("tipoC3");
                        campos[3] = rs.getString("tipoC4");
                    } else {
                        System.out.println("No se encontró la tabla '" + nombre + "' en TablaDeTablas.");
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Driver SQLite no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de base de datos: " + e.getMessage());
        }

        return campos;
	}
	public void insertarDato(){
    System.out.println("Ingrese el nombre de la tabla en la que desea añadir un dato:");
    String nombreTabla = teclado.nextLine();
    String[] campos = buscarCampos(nombreTabla);
    if (campos[0] == null) {
        System.out.println("No es posible insertar datos porque la tabla no existe.");
        return;
    }

    System.out.println("Ingrese el valor para " + campos[0] + ":");
    String valor1 = teclado.nextLine();

    System.out.println("Ingrese el valor para " + campos[1] + ":");
    String valor2 = teclado.nextLine();

    System.out.println("Ingrese el valor para " + campos[2] + ":");
    String valor3 = teclado.nextLine();

    System.out.println("Ingrese el valor para " + campos[3] + ":");
    String valor4 = teclado.nextLine();
    String sqlInsert = consulta.consultaInsert(
        nombreTabla,
        campos[0], campos[1], campos[2], campos[3],
        valor1,valor2,valor3,valor4
    );

    añadidor.añadirDato(sqlInsert);
	}
	public void eliminarTabla(){
		System.out.println("Ingrese el nombre de la tabla que desea eliminar");
		String respuesta = teclado.nextLine();
		System.out.println("Estas seguro de eliminarlas?");
		String respuestaR = teclado.nextLine();
		if(respuestaR.toLowerCase().equals("si")){
			String consultaT =consulta.consultaEliminar(respuesta);
			terminator.eliminar(consultaT);
			eliminarTabladeTT(respuesta);
			System.out.println("Hasta la vista "+respuesta+"...");
		}else{
			System.out.println("Regresando al menu ...");
		}
	}
	public void eliminarTabladeTT(String nombreT){
		String consultaT=consulta.consultaED("TablaDeTablas","NombreTabla",nombreT);
		terminator.eliminarDato(consultaT);
	}
	public void eliminarDato(){
		String[] soyunArreglodecampos;
		System.out.println("Ingrese el nombre de la tabla que desea eliminar el dato");
		String respuesta = teclado.nextLine();
		System.out.println("Ingrese el valor del primer campo que desea eliminar");
		String respuestaC = teclado.nextLine();
		soyunArreglodecampos = buscarCampos(respuesta);
		String consultaT = consulta.consultaED(respuesta,soyunArreglodecampos[0],respuestaC);
		System.out.println(consultaT);
		terminator.eliminarDato(consultaT);
	}
	public void mostrarTablas(){
		String consultat = consulta.consultaMostrar("TablaDeTablas");
		mostrador.mostrarTablas(consultat);
	}
}
