package Ejercicio_Entregable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Gestion_Datos {
	
		private String url;
		
		private String user;
		
		private String pwd;
		
		private Connection conexion;
		
		Gestion_Datos(String url, String user, String pwd){
			
			this.url = url;
			
			this.user = user;
			
			this.pwd = pwd;
			
		}
		
		//Metodo de conexion
		void conectar () {
			try {
				conexion = DriverManager.getConnection(url,user,pwd);			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//Metodo para crear tablas
		void QuerysTool (String tabla) {
			try {
				Statement s = conexion.createStatement();
				s.execute(tabla);
				System.out.println("Tablas Creadas");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//Metodo para insertar o borrar datos
		void EditTool (String insdel) {
			try {
				Statement s = conexion.createStatement();
				if (insdel.contains("INSERT")) {
					int nFil = s.executeUpdate(insdel);
					System.out.println("Se han insertado los datos");
				}
				if (insdel.contains("DELETE")) {
					try {
						int nFil = s.executeUpdate(insdel);
						System.out.println("Se ha borrado los datos");
					}catch(Exception e) {
						System.out.println("No se han podido borrar los datos, llame a asistencia");
					}
					
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//Metodo para hacer consultas
		void SelectTool (String select) {
			try {
				Statement s = conexion.createStatement();
				ResultSet rs = s.executeQuery(select);
				while(rs.next()) {
					if (select.contains("FROM conductores")) {
						System.out.println(" " + rs.getString(1));
					}
					if (select.contains("FROM usuario")) {
						System.out.println(" " + rs.getString(1) + " " + rs.getString(2));
					}
					if (select.contains("GROUP BY Semana")) {
						System.out.println(" " + rs.getString(1) + " " + rs.getString(2));
					}
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

}


				

