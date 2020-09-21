package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.sun.corba.se.impl.transport.ReadTCPTimeoutsImpl;

public class Conecta {
	
	public static String url="jdbc:mysql://localhost/sistema_web";
	public static String user="root";
	public static String password="";
	
	
	public static Connection getConnection() throws SQLException{
		Connection connection=null;
		
		
		try {
			
			connection= DriverManager.getConnection(url,user,password);
			
			if (connection!=null) {
				System.out.println("Conectado com Sucesso");
				
			}else {
				System.out.println("Erro Ao Conectar Com Banco");
			}
			
			
			
			
		} catch (Exception e) {
			
		}
		
		
		return connection;
		
		
	}
	
	public static void main(String[] args) throws SQLException {

		Conecta con=new Conecta();
		con.getConnection();
		
		
		
	
	}
}
