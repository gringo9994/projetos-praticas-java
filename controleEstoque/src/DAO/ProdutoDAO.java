package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao_Banco.Conecta;

import model.Produto;

public class ProdutoDAO {
	
	private Connection conexao;
	
	public ProdutoDAO() throws SQLException {
		this.conexao = Conecta.getConection();
	}
     
	//  METODO DE INSERIR DADOS NO BANCO
	public void inserir(Produto produto) throws SQLException{
		String sql = "INSERT INTO produto(categoria,nome,valor,quantidade,fabricante,descricao)values(?,?,?,?,?,?)";
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		stmt.setString(1, produto.getCategoria());
		stmt.setString(2, produto.getNome());
		stmt.setString(3,produto.getValor());
		stmt.setString(4, produto.getQuantidade());
		stmt.setString(5, produto.getFabricante());
		stmt.setString(6, produto.getDescricao());
		stmt.execute();
		stmt.close();
		JOptionPane.showMessageDialog(null, "Dados Cadastrados com sucesso");
	}
	
	
	//  METODO DE BUSCA NO BANCO DE DADOS
	
	public List<Produto> getLista() throws SQLException {
		String sql = "SELECT * from produto ";
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		// GUARDAR ESSES DADOS DE BUSCA EM OUTRA LISTA

		List<Produto> listaProduto = new ArrayList<Produto>();
		// ENQUANTO EXISTIR DADOS NO BANCO LOOP

		while (rs.next()) {
			Produto prod = new Produto();
			prod.setId(rs.getLong("id"));
			prod.setCategoria(rs.getString("categoria"));
			prod.setNome(rs.getString("nome"));
			prod.setValor(rs.getString("valor"));
			prod.setQuantidade(rs.getString("quantidade"));
			prod.setFabricante(rs.getString("fabricante"));
			prod.setDescricao(rs.getString("descricao"));
			listaProduto.add(prod);
		}
		rs.close();
		stmt.close();
		JOptionPane.showMessageDialog(null, "Dados Buscados Com sucesso");
		return listaProduto;
		
	}
	
	// METODO PARA ALTERAR
		public void altera(Produto produto) throws SQLException {
			String sql = "UPDATE produto set  categoria=? ,nome=?,valor=?,quantidade=?,fabricante=?,descricao=? where id=?";

			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, produto.getCategoria());
			stmt.setString(2, produto.getNome());
			stmt.setString(3, produto.getValor());
			stmt.setString(4, produto.getQuantidade());
			stmt.setString(5, produto.getFabricante());
			stmt.setString(6, produto.getDescricao());
			// update atraves do ID
			stmt.setLong(7, produto.getId());
			stmt.execute();
			stmt.close();
           
		}
	
	// METODO DE EXCLUSÃO 
	
		public void remove(Produto produto) throws SQLException {
			
			
			String sql="DELETE FROM produto where id=?";
			
			PreparedStatement stmt=conexao.prepareStatement(sql);
			stmt.setLong(1, produto.getId());
			stmt.execute();
	        stmt.close();
		}
	
	
	
	
	
	
	
	
	
	
	
	
}


		
		
	
	



