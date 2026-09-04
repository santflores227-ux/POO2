public class CreadorConsulta{
	public String consultaInsert(
		String nombreTabla,
		String campo1, String campo2, String campo3, String campo4,
		String valor1, String valor2, String valor3, String valor4
	){
		String consultaSql = "INSERT INTO " + nombreTabla + "(" +campo1+","+campo2+","+campo3+","+campo4 +") VALUES ('"+valor1+"','"+valor2+"','"+valor3+"','"+valor4+"')";
		return consultaSql;
	}
	public String consultaCrear(
		String nombreTabla,
		String campo1, String tipo1, 
		String campo2, String tipo2,
		String campo3, String tipo3, 
		String campo4, String tipo4
	){
		String consultasql = "CREATE TABLE IF NOT EXISTS " + nombreTabla+" ( "
			+ campo1 +" "+tipo1+","
			+ campo2 +" "+tipo2+","
			+ campo3 +" "+tipo3+","
			+ campo4 +" "+tipo4
			+");";
		return consultasql;
	}
	public String consultaMostrar(
		String nombreTabla
	){
		String consultaSQL = "SELECT * FROM "+ nombreTabla;
		return consultaSQL;
	}
	public String consultaEliminar(String nombreTabla){
		String consultaqlS = "DROP TABLE " + nombreTabla;
		return consultaqlS;
	}
	public String consultaED(
		String nombreTabla,
		String campo1,String valor1
	){
		String consultaQSLL = "DELETE FROM "+nombreTabla+" WHERE "+campo1 +" = '"+valor1+"'";
		return consultaQSLL;
	}
}