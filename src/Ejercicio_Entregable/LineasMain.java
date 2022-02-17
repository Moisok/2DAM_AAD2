package Ejercicio_Entregable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LineasMain {

	public static void main(String[] args) {
		
		//Donde se localiza la BD
		
		String url="jdbc:postgresql://localhost:5432/lineas";
		
		//Credenciales de la BD
		
		String user = "postgres";
				
		String pwd = "admin";
		
		Gestion_Datos BBDD = new Gestion_Datos(url,user,pwd);
		
		Querys querys = new Querys();
		
		//Conexion a la tabla
		
		BBDD.conectar();
		
		//Creamos el dominio
		
		//BBDD.QuerysTool(querys.Gen_Dominio);
		
		//Crear tablas
		
		//BBDD.QuerysTool(querys.tabla_bonos);
		
		//BBDD.QuerysTool(querys.tabla_usuarios);
		
		//BBDD.QuerysTool(querys.tabla_bonos_activos);
		
		//Insertar datos en tablas
		
		//BBDD.EditTool(querys.ins_bonos);
		
		//BBDD.EditTool(querys.ins_users);
		
		//BBDD.EditTool(querys.ins_bActivos);
		
		//Consultas
		
		/*System.out.println("Conductores con bonos activos");
		BBDD.SelectTool(querys.cosultaUno);
		System.out.println("\n Nombre y edad con bonos de un dia de duracion");
		BBDD.SelectTool(querys.consultaDos);
		System.out.println("\n Bonos activos y cuantos caducan por semana (Izquierda cantidad, derecha semanas)");
		BBDD.SelectTool(querys.consultaTres);*/
		
		//Borrados (o modificaciones)
		
		//BBDD.EditTool(querys.deleteUno);
		
		//BBDD.EditTool(querys.deleteUno_B);
		
		//BBDD.EditTool(querys.consultaDos);
		
	}

}
