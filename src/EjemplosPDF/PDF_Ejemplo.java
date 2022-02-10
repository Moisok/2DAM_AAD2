package EjemplosPDF;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PDF_Ejemplo {
	
	public static void main(String[]args) {
		//Donde se localiza la BD
		
		String url="jdbc:postgresql://localhost:5432/lineas";
		//Credenciales de la BD
		String user = "postgres";
		
		String pwd = "admin";
		
		try {
		// Establece la conexión con la BD
		Connection conexion = DriverManager.getConnection(url,user,pwd);
		
			/*try {
			Statement s = conexion.createStatement();
			s.execute( "CREATE TABLE Ciudades ( ID_Ciudad smallint not null primary key,Nombre varchar(20) not null )" );
			} catch(SQLException e) {
			System.err.println( e.getMessage() );
			}*/
		
		/*try {
			Statement s = conexion.createStatement();
			int nFil = s.executeUpdate("INSERT INTO Ciudades (ID_Ciudad, Nombre) VALUES  (1, 'Castello'),  (2, 'Vila Real'), (3, 'Borriana') " );
			System.out.println(nFil + " filas insertadas en Ciudades.");
			} catch(SQLException e) {
			System.err.println( e.getMessage() );
			}*/
		
			/*try {
				
				Statement s = conexion.createStatement();
				
				ResultSet rs = s.executeQuery("SELECT * FROM Ciudades");
				
				while(rs.next()){
					
				System.out.println("ID:" + rs.getInt(1) + " Nombre: "+ rs.getString(2));
				
					}
				} catch(SQLException e) {
				System.err.println( e.getMessage());
				}*/
		
		String[] nuevasCiudades = {"Sevilla","Madrid", "Barcelona"};
		int id = 4; // en ejemplos se añadieron 3 ciudades
		String nombre;
		try {
			PreparedStatement ps = conexion.prepareStatement(
															"INSERT INTO Ciudades "
															+ "(ID_Ciudad, Nombre) "
															+ "VALUES (?, ?)" );
			for(int i=0; i<nuevasCiudades.length; i++){
				nombre = nuevasCiudades[i];
				ps.setInt(1, id);
				ps.setString(2, nombre);
				ps.executeUpdate();
				System.out.println("Insertada ciudad: " + nombre);
				id = id + 1;
			}
		} catch(SQLException e) {
		System.err.println( e.getMessage() );
		}
		// Cierra la conexión con la BD
		conexion.close();
		}
		
		catch (Exception e){
		System.err.println( e.getMessage() );
		}
		
		
	}
}
