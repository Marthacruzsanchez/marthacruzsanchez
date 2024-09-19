package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Servicio {
	void alta(Alumno a) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Define the data source for the driver
			String sourceURL = "jdbc:mysql://localhost/colegio?useSSL=false&serverTimezone=UTC";
			// Create a connection through the DriverManager
			Connection databaseConnection = DriverManager.getConnection(sourceURL, "root", "");
			
			PreparedStatement pstmt = null;
			pstmt = databaseConnection.prepareStatement("INSERT INTO alumnos VALUES (?,?,?)");
			pstmt.setString(1, a.getNombre());
			pstmt.setString(2, a.getDni());
			pstmt.setInt(3, a.getEdat());
			pstmt.executeUpdate();
			pstmt.close();
			
			
			databaseConnection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void baja(Alumno a) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Define the data source for the driver
			String sourceURL = "jdbc:mysql://localhost/colegio?useSSL=false&serverTimezone=UTC";
			// Create a connection through the DriverManager
			Connection databaseConnection = DriverManager.getConnection(sourceURL, "root", "");
			
			PreparedStatement pstmt = null;
			pstmt = databaseConnection.prepareStatement("DELETE FROM alumnos WHERE dni= ? ");
			pstmt.setString(1, a.getDni());
			pstmt.executeUpdate();
			pstmt.close();
			
			databaseConnection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void Modicar(String oldDni, Alumno a) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Define the data source for the driver
			String sourceURL = "jdbc:mysql://localhost/colegio?useSSL=false&serverTimezone=UTC";
			// Create a connection through the DriverManager
			Connection databaseConnection = DriverManager.getConnection(sourceURL, "root", "");
			
			PreparedStatement pstmt = null;
			pstmt = databaseConnection.prepareStatement("SELECT * FROM alumnos WHERE DNI = ? ");
			pstmt.setString(1, oldDni);
			pstmt.execute();
			pstmt.close();
			
			PreparedStatement pstmt1 = null;
			pstmt1 = databaseConnection.prepareStatement("UPDATE alumnos SET DNI = ? WHERE DNI= ? ");
			pstmt1.setString(1, a.getDni());
			pstmt1.setString(2, oldDni);
			pstmt1.executeUpdate();
			pstmt1.close();
			
			databaseConnection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
