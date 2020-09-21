package conexao_tomcat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conecta {

	
	
	
	public static Connection getConnection() throws SQLException{
		
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/aluno","root","");
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getException());
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}
