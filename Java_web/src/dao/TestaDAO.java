package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import modelo.Usuario;

public class TestaDAO {

	public static void main(String[] args) throws SQLException {

buscarTodos();
	
	}
	
	
	
	public static  void testeInsere() throws SQLException{
	
		Usuario user=new Usuario();
		user.setNome("Maria da silva");
		user.setEndereco("AVENIDA MARANHÃO 593");
		user.setTelefone("31989509397");
		 UsuarioDAO usuario=new UsuarioDAO();
		
		 
        usuario.insere(user);
	}

	public static  void testeAltera() throws SQLException{
		int id=2;
		Usuario user=new Usuario();
		user.setNome("Joao da Silva Rocha");
		user.setEndereco("rua maria azevedo  593");
		user.setTelefone("31989509397");
		user.setId(id);
		 UsuarioDAO usuario=new UsuarioDAO();
		
        usuario.alterar(user);
        
	}
	
	public static  void testeExclui() throws SQLException{
		int id=2;
		Usuario user=new Usuario();
		user.setId(id);
		 UsuarioDAO usuario=new UsuarioDAO();
		
        usuario.excluir(user);
        
	}
	
	
	
	public static  void buscarTodos() throws SQLException{
		
		 UsuarioDAO usuario= new UsuarioDAO();
		List<Usuario>list=usuario.BuscaUsuario();
		
for (Usuario userLista : list) {
	System.out.println(" O id é:"+userLista.getId());
	System.out.println(" O Nome  é:"+userLista.getNome());
	System.out.println(" O Endereço é:"+userLista.getEndereco());
	System.out.println(" O Telefone é:"+userLista.getTelefone());
	
}

	}
	  // testa metodo de buscar todos usuários por ID
	
	public  static void testesBuscarPorId(){
		Usuario user=new Usuario();
		
		List<Usuario>listanomes=new ArrayList<Usuario>();
		
		for (Usuario usuario : listanomes) {
			System.out.println(" Id :"+usuario.getId());
			System.out.println("Nome :"+usuario.getNome());
		System.out.println("Endereço :"+usuario.getEndereco());
		System.out.println("Telefone :"+usuario.getTelefone());
			
		
		}
		
		
		
	
			}
		
		
		
	
	
	
	
	
	
	
}

