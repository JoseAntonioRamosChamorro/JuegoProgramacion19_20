package juego;

import java.awt.Label;
import java.awt.TextArea;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModeloJuego {
	 static Connection conectar()
	{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/juego19_20?autoReconnect=true&useSSL=false";
		String user = "root2";
		String password = "12345678A";
		Connection con = null;
		try {
			// Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			// Establecer la conexión con la BD empresa
			con = DriverManager.getConnection(url, user, password);
			if (con != null) {
				System.out.println("Conectado a la base de datos");
			}
		} catch (SQLException ex) {
			System.out.println("ERROR:La dirección no es válida o el usuario y clave");
			ex.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error 1-" + cnfe.getMessage());
		}
		return con;
	}
	public static void desconectar(Connection con)
	{
		try
		{
			con.close();
		}
		catch(Exception e) {}
	}
	public int jugador1(Connection con,  String ply1) {
		int respuesta = 0;
		try 
		{

			Statement sta = con.createStatement();
			String cadenaSQL = "INSERT INTO `juego19_20`.`jugador1` (`NombreJ1`) "
					+ "VALUES ('"+ply1+"');";
			System.out.println(cadenaSQL);
			sta.executeUpdate(cadenaSQL);
			sta.close();
		} 
		catch (SQLException ex) 
		{
			System.out.println("ERROR:al hacer un Insert1");
			ex.printStackTrace();
			respuesta = 1;
		}
		return respuesta;
	}
	//Insertar jugado2
	public int jugador2(Connection con,  String ply2) {
		int respuesta = 0;
		try 
		{

			Statement sta = con.createStatement();
			String cadenaSQL = "INSERT INTO  `juego19_20`.`jugador2` (`NombreJ2`) "
					+ "VALUES ('"+ply2+"');";
			System.out.println(cadenaSQL);
			sta.executeUpdate(cadenaSQL);
			sta.close();
		} 
		catch (SQLException ex) 
		{
			System.out.println("ERROR:al hacer un Insert2");
			ex.printStackTrace();
			respuesta = 1;
		}
		return respuesta;
}
	public static void rellenarTextArea(Connection con1, TextArea t) {
	
		String sqlSelect = "SELECT * FROM ganadores ORDER BY idJuegadores DESC LIMIT 10;";

		try {
			Connection con = conectar();
			Statement stmt = con1.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);
			while (rs.next()) 
			{
				if(t.getText().length()==0)
				{
					t.setText(rs.getString("NombreJugador"));
				}
				else
				{
					t.setText(t.getText() + "\n" +
							rs.getString("NombreJugador"));
				}
			}
			rs.close();
			stmt.close();
			desconectar(con);
		} catch (SQLException ex) {
			System.out.println("ERROR:al consultar");
			ex.printStackTrace();
		}}
	public void InsertarP1(Connection con, String j1) {
		try 
		{
		Statement sta = con.createStatement();
		String cadenaSQL ="INSERT INTO `juego19_20`.`ganadores` (`NombreJugador`) VALUES ('"+j1+"');";
		System.out.println(cadenaSQL);
		sta.executeUpdate(cadenaSQL);
		sta.close();
	} 
	catch (SQLException ex) 
	{
		System.out.println("ERROR:al hacer un Insert");
		ex.printStackTrace();
	
	}
		
	}
	public void InsertarP2(Connection con, String j2)  {
		try 
		{
		Statement sta = con.createStatement();
		String cadenaSQL ="INSERT INTO `juego19_20`.`ganadores` (`NombreJugador`) VALUES ('"+j2+"');";
		System.out.println(cadenaSQL);
		sta.executeUpdate(cadenaSQL);
		sta.close();
	} 
	catch (SQLException ex) 
	{
		System.out.println("ERROR:al hacer un Insert");
		ex.printStackTrace();
	
	}}
	public void BorrarP2(Connection con, Label lbpj2) {
		String sql = "DELETE FROM `juego19_20`.`jugador2` order by idJugador2 desc limit 1;";
		try 
		{
			// Creamos un STATEMENT para una consulta SQL INSERT.
			Statement sta = con.createStatement();
			sta.executeUpdate(sql);
			sta.close();
		} 
		catch (SQLException ex) 
		{
			System.out.println("ERROR:al hacer un Delete");
			ex.printStackTrace();

		}

	}
	public void BorrarP1(Connection con, Label lbpj1) {
		String sql = "DELETE FROM `juego19_20`.`jugador1` order by idJugador1 desc limit 1;";
		try 
		{
			// Creamos un STATEMENT para una consulta SQL INSERT.
			Statement sta = con.createStatement();
			sta.executeUpdate(sql);
			sta.close();
		} 
		catch (SQLException ex) 
		{
			System.out.println("ERROR:al hacer un Delete");
			ex.printStackTrace();

		}
	}
	static void rellenarLabelj2(Connection con, Label lbpj22) {
		String sqlSelect = "SELECT * FROM juego19_20.jugador2 order by idJugador2 desc limit 1;";
		try {
			// CREAR UN STATEMENT PARA UNA CONSULTA SELECT
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);
			while (rs.next()) 
			{
				if(lbpj22.getText().length()==0)
				{
					lbpj22.setText(rs.getString("NombreJ2"));
				}
				else
				{
					lbpj22.setText(lbpj22.getText() + "\n" +
							rs.getString("NombreJ2"));
				}
			}
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("ERROR:al consultar");
			ex.printStackTrace();
		}

	}


	public static void rellenarLabelj1(Connection con, Label lbpj12) {

		String sqlSelect = "SELECT * FROM juego19_20.jugador1 order by idJugador1 desc limit 1;";
		try {
			// CREAR UN STATEMENT PARA UNA CONSULTA SELECT
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlSelect);
			while (rs.next()) 
			{
				if(lbpj12.getText().length()==0)
				{
					
					lbpj12.setText(rs.getString("NombreJ1"));
					System.out.println(lbpj12);
				}
				else
				{
					lbpj12.setText(lbpj12.getText() + "\n" +
							rs.getString("NombreJ1"));
				}
			}
			rs.close();
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("ERROR:al consultar");
			ex.printStackTrace();
		}
	}
	}
