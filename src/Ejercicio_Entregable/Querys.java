package Ejercicio_Entregable;

public class Querys {
	
	//Tabla bonos activos
	public String tabla_bonos_activos = "CREATE TABLE Bonos_Activos "
			+ "("
			+ "ID_Bono Dom_Id,"
			+ "DNI_usuario Dom_dni,"
			+ "ID_linea dom_Id,"
			+ "Caducidad Date,"
			+ "PRIMARY KEY (ID_Bono, DNI_Usuario, ID_linea),"
			+ "CONSTRAINT FK_ID_Linea FOREIGN KEY (ID_linea) REFERENCES "
			+ "lineas ON UPDATE CASCADE ON DELETE CASCADE,"
			+ "CONSTRAINT FK_ID_DNI FOREIGN KEY (DNI_usuario) REFERENCES "
			+ "Usuarios ON UPDATE CASCADE ON DELETE CASCADE);"; 
	
	//Tabla bonos
	public String tabla_bonos = "CREATE TABLE Bonos("
			+ "ID_Bono Dom_Id PRIMARY KEY,"
			+ "Tipo varchar (20),"
			+ "Duracion smallint);";
	
	//Tabla usuarios
	public String tabla_usuarios = "CREATE TABLE Usuarios( "
			+ "DNI_usuario Dom_dni PRIMARY KEY,"
			+ "Nombre varchar (20),"
			+ "F_nacimiento date,"
			+ "ciudad varchar (15) );";
	
	//Generar dominio
	public String Gen_Dominio = "CREATE DOMAIN Dom_dni AS TEXT CHECK (VALUE ~ '^[0-9]{8}[A-Z]$');";
	
	//Inserts
	
	//Bonos
	public String ins_bonos = "INSERT INTO Bonos (ID_Bono, Tipo, Duracion)"
			+ "VALUES (1,'todo incluido',1),"
			+ "(2,'todo incluido',7),	"
			+ "(3,'todo incluido',30),"
			+ "(4,'50%',1),"
			+ "(5,'50%',7),"
			+ "(6,'50%',30);";
	
	//Usuarios
	public String ins_users = "INSERT INTO Usuarios (DNI_usuario,Nombre,F_nacimiento,ciudad)"
			+ "VALUES ('11222333A', 'Patricia Perez', '10/12/1990', 'Burriana'), "
			+"('22333444B', 'Lia Lorca', '31/01/2002', 'Castellon'), "
			+"('33444555C', 'Nela Nunez', '28/03/2008', 'Almazora'), "
			+"('44555666D', 'Jose Jimenez', '15/12/2001', 'Nules'), "
			+"('55666777E', 'Antonio Aranda', '09/09/1989', 'Mascarell');";
	
	//Bonos Activos
	public String ins_bActivos = "INSERT INTO Bonos_Activos (ID_bono,DNI_usuario,ID_linea,Caducidad)"
			+ "VALUES (2, '11222333A', 11, '22/02/22')," + 
			"(5, '11222333A', 31, '17/02/22')," + 
			"(1, '22333444B', 41, '16/02/22')," + 
			"(4, '33444555C', 21, '16/02/22')," + 
			"(6, '44555666D', 51, '15/03/22')," + 
			"(3, '44555666D', 21, '01/03/22');";
	
	//Consultas
	
	//Primera consulta 
	public String cosultaUno = "SELECT nombre \n" + 
			"FROM conductores \n" + 
			"WHERE id_conductor IN (SELECT id_conductor \n" + 
			"						FROM lineas WHERE id_linea in (SELECT id_linea  \n" + 
			"						FROM lineas\n" + 
			"						WHERE id_linea IN (SELECT id_linea from bonos_activos)));";
	
	//Segunda consulta
	public String consultaDos = "SELECT nombre, EXTRACT(YEAR FROM AGE(f_nacimiento))\n" + 
			"FROM usuarios  \n" + 
			"WHERE dni_usuario in (SELECT dni_usuario \n" + 
			"						FROM bonos_activos\n" + 
			"					 	WHERE id_bono IN (SELECT id_bono\n" + 
			"										  FROM bonos\n" + 
			"										  WHERE duracion =1));\n" + 
			"						";
	
	//Tercera consulta
	public String consultaTres = "SELECT COUNT(id_bono) AS catidad, DATE_TRUNC ('week',caducidad)::Date as Semana\n" + 
			"FROM bonos_activos\n" + 
			"GROUP BY Semana;";
	
	//Modificacion de datos
	
	//Primera modificacion
	public String deleteUno = "DELETE\n" + 
			"FROM usuarios\n" + 
			"WHERE EXTRACT(YEAR FROM AGE(f_nacimiento)) <= 18;";
	
	public String deleteUno_B = "DELETE "
			+ "FROM bonos_activos"
			+ "WHERE dni_usuario = '33444555C'";
	
	//Segunda modificacion
	public String deleteDos = "DELETE\n" + 
			"FROM bonos\n" + 
			"WHERE duracion = 30 AND tipo LIKE '50%';";
	
}




