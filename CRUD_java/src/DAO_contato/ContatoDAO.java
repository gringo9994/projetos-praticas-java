package DAO_contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import conexao.Conecta;
import logica.Contato;

public class ContatoDAO {

	private Connection conexao;
	// criar o construtor para chamar a classe de Conexao

	public ContatoDAO() throws SQLException {
		this.conexao = Conecta.getConection();
	}

	// METODO PARA ADICIONAR
	public void adiciona(Contato c1) throws SQLException {
		String sql = "INSERT INTO contato(nome,endereco,email,telefone,sexo)values(?,?,?,?,?)";
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		stmt.setString(1, c1.getNome());
		stmt.setString(2, c1.getEndereco());
		stmt.setString(3, c1.getEmail());
		stmt.setString(4, c1.getTelefone());
		stmt.setString(5, c1.getSexo());
		stmt.execute();
		stmt.close();
		JOptionPane.showMessageDialog(null, "Dados Cadastrados com sucesso");
	}

	// METODO PARA BUSCAR DADOS
	public List<Contato> getLista() throws SQLException {
		String sql = "SELECT * from contato";
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		// GUARDAR ESSES DADOS DE BUSCA EM OUTRA LISTA

		List<Contato> listaContato = new ArrayList<Contato>();
		// ENQUANTO EXISTIR DADOS NO BANCO LOOP

		while (rs.next()) {
			Contato c1 = new Contato();
			c1.setNome(rs.getString("nome"));
			c1.setEndereco(rs.getString("endereco"));
			c1.setEmail(rs.getString("email"));
			c1.setTelefone(rs.getString("email"));
			c1.setSexo(rs.getString("sexo"));
			listaContato.add(c1);
		}
		rs.close();
		stmt.close();
		JOptionPane.showMessageDialog(null, "Dados Buscados Com sucesso");
		return listaContato;
	}

	// METODO PARA ALTERAR
	public void altera(Contato c1) throws SQLException {
		String sql = "UPDATE contato set nome=?,endereco=?,email=?,telefone=?,sexo=? where id=?";

		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		// seta os valores
		stmt.setString(1, c1.getNome());
		stmt.setString(2, c1.getEndereco());
		stmt.setString(3, c1.getEmail());
		stmt.setString(4, c1.getTelefone());
		stmt.setString(5, c1.getSexo());
		// update atraves do ID
		stmt.setLong(6, c1.getId());
		stmt.execute();
		stmt.close();

	}

	public void remove(Contato c1) throws SQLException {
		
		
		String sql="DELETE FROM contato where id=?";
		
		PreparedStatement stmt=conexao.prepareStatement(sql);
		stmt.setLong(1, c1.getId());
		stmt.execute();
        stmt.close();
	}

}
