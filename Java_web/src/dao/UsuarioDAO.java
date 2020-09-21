package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conecta;

import modelo.Usuario;

public class UsuarioDAO {

	private static Connection connection;

	public UsuarioDAO() throws SQLException {

		this.connection = Conecta.getConnection();

	}

	/******************* METODO DE INSERIR *********************/

	public static void insere(Usuario user) throws SQLException {

		String sql = "INSERT INTO usuario(nome,endereco,telefone)values(?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, user.getNome());
		stmt.setString(2, user.getEndereco());
		stmt.setString(3, user.getTelefone());
		stmt.executeUpdate();
		stmt.close();
		System.out.println("USUARIO INSERIDO COM SUCESSO");
		connection.close();
	}

	/******************* METODO DE ATUALIZAR *********************/

	public static void alterar(Usuario user) throws SQLException {

		String sql = "update usuario set  nome=?,endereco=?,telefone=? where id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, user.getNome());
		stmt.setString(2, user.getEndereco());
		stmt.setString(3, user.getTelefone());
		// ALTERA A PARTIR DA COLUNA 4
		stmt.setLong(4, user.getId());
		stmt.execute();
		stmt.close();
		System.out.println("USUARIO ALTERADO COM SUCESSO");
		connection.close();

	}

	/******************* METODO DE EXCLUIR *********************/

	public static  void excluir(Usuario user) throws SQLException {

		String sql = "delete from usuario  where id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		// EXCLUI A PARTIR DA COLUNA 1
		stmt.setLong(1, user.getId());
		stmt.execute();
		stmt.close();
		System.out.println("USUARIO EXCLUIDO COM SUCESSO");
		connection.close();

	}

	
	
	
	/******************* METODO DE BUSCAR ***********************/
	

	
	// METODO PARA BUSCAR DADOS
		public static List<Usuario> BuscaUsuario() throws SQLException {
			String sql = "SELECT * from usuario";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			// GUARDAR ESSES DADOS DE BUSCA EM OUTRA LISTA

			List<Usuario> listaUsuario = new ArrayList<Usuario>();
			// ENQUANTO EXISTIR DADOS NO BANCO LOOP

			while (rs.next()) {
				Usuario userBusca = new Usuario();
				userBusca.setId(rs.getLong("id"));
				userBusca.setNome(rs.getString("nome"));
				userBusca.setEndereco(rs.getString("endereco"));
				userBusca.setTelefone(rs.getString("telefone"));
				listaUsuario.add(userBusca);
				
				
			}
			rs.close();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Dados Buscados Com sucesso");
			return listaUsuario;
		}
	
	
	
	
	
	
	
	
		public  List<Usuario> buscarPorId(long  id) throws SQLException{
			Connection con=Conecta.getConnection();
			  String sql ="select * from usuario where id=?";
			  //criar uma lista para adicionar as consultas capturados do banco
			List<Usuario> lista=new ArrayList<Usuario>();
			Usuario usua=new Usuario();
			
			try {
				
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setLong(1,usua.getId());
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				Usuario usuario=new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getNString("nome"));
				usuario.setEndereco(rs.getString("endereco"));
				usuario.setTelefone(rs.getString("telefone"));
				lista.add(usuario);
				
			}
				
				
			stmt.close();
			con.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			return lista;
		}
	
	
	
	
		
		
		
		
		//metodo para buscar por ID no banco de dados
		
		public  List<Usuario > buscarPorId1(long  id) throws SQLException{
			Connection con=Conecta.getConnection();
			  String sql ="select * from usuario where id=?";
			  //criar uma lista para adicionar as consultas capturados do banco
			List<Usuario> lista=new ArrayList<Usuario>();
			Usuario usua=new Usuario();
			
			try {
				
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setLong(1,usua.getId());
			ResultSet rs=stmt.executeQuery();
			while (rs.next()) {
				Usuario usuario=new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getNString("nome"));
				usuario.setEndereco(rs.getString("endereco"));
				usuario.setTelefone(rs.getString("telefone"));
				lista.add(usuario);
				
			}
				
				
			stmt.close();
			con.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			return lista;
			
			
			 
			
			
			
		}
		
		
		
		
		
		
		
		// criando um método lista para buscar por nome
		
		public List<Usuario> buscarPorNome(String nome) throws SQLException{
	    
			String sql="select *from usuario where nome like=?";
			Connection con=Conecta.getConnection();
			List<Usuario>listaNomes=new ArrayList<Usuario>();
			try {
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setString(1,"%"+nome+"%");
				ResultSet rs=stmt.executeQuery();
				
				while (rs.next()) {
					Usuario usuario=new Usuario();
					usuario.setId(rs.getLong("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setEndereco(rs.getString("endereco"));
					usuario.setTelefone(rs.getString("telefone"));
					listaNomes.add(usuario);
				}
					
			
				
				
			} catch (Exception e) {
				
			
			
			
		}
			return listaNomes;
			
		
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


