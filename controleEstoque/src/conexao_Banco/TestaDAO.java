package conexao_Banco;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import DAO.ProdutoDAO;

import model.Produto;

public class TestaDAO {
	

	public static void main(String[] args) throws SQLException {
		
		/*Connection con=Conecta.getConection();
		Produto produto=new Produto();
		produto.setId(Long.valueOf(1));
		ProdutoDAO dao=new ProdutoDAO();
		dao.remove(produto);
		JOptionPane.showMessageDialog(null, "Dados Excluidos Com Sucesso");
		
		*/
		
		Connection con=Conecta.getConection();
		
		ProdutoDAO dao =new ProdutoDAO();
		List<Produto>minhaLista=dao.getLista();
		
		for (Produto list : minhaLista) {
			JOptionPane.showMessageDialog(null, list.getCategoria()+list.getNome()+list.getValor()+list.getQuantidade()+list.getFabricante()+list.getDescricao());
			
		
		
		
		
		}
		
		
		
		/*Connection con=Conecta.getConection();
		Produto produtos = new Produto();
		produtos.setCategoria("Carro");
		produtos.setNome("Palio");
		produtos.setValor("25.000");
		produtos.setQuantidade("1");
		produtos.setFabricante("Fiat ");
		produtos.setDescricao("5 Lugares");
		
	
		ProdutoDAO dao = new ProdutoDAO();
		dao.inserir(produtos);
		System.out.println("DADOS GRAVADOS NO BANCO");
		
		*/
		
		
		
		
		
		
		
		
		
		
		
	} 
}

	


