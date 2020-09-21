package conexao_Banco;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conecta {
	
	private static String url="jdbc:mysql://localhost/controle_estoque";
	private static String user="root";
	private static String password="";
	
	
	public static Connection getConection(){
		Connection conection=null;
		try {
			conection=DriverManager.getConnection(url, user, password);
			if (conection!=null) {
				System.out.println("Conectado com Sucesso");
				
				
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao Conectar com a Base de Dados"+e);
		}
		return conection;
		
		
	}
	
	
	

}
