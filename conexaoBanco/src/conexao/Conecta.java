package conexao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Conecta {
      
	
	
	
	
	

	public static Connection getConnection()throws SQLException {
		Connection connection=null;
		
		
		try {
			
			String url="jdbc:mysql://localhost/cadastro";
			String user="root";
			String password="";
			connection=DriverManager.getConnection(url,user,password);
			if (connection!=null) {
				System.out.println("Conectado com Sucesso");
				
			}else {
				System.out.println("Não Conectou");
			}
				return connection;
			
		} catch (SQLException e) {
			System.out.println("Não Conectou ao Banco de Dados");
			
			return null;
		}
	}
}
	
	