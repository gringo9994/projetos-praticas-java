package DAO_contato;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logica.Contato;

public class Main_ContatoDAO {

	public static void main(String[] args) throws SQLException {

		/*Contato contatos = new Contato();
		contatos.setNome("Ivan kaiser");
		contatos.setEndereco("Avenida Maranhão 593");
		contatos.setEmail("gringokaiser@hotmail.com");
		contatos.setTelefone("31988875567");
		contatos.setSexo("M");

		ContatoDAO dao = new ContatoDAO();
		dao.adiciona(contatos);
		System.out.println("DADOS GRAVADOS NO BANCO");
      */
			/***************************************************************************************/
		
		
		/*
		ContatoDAO dao =new ContatoDAO();
		List<Contato>minhaLista=dao.getLista();
		
		for (Contato contato : minhaLista) {
			System.out.println("Nome: " +contato.getNome());
			System.out.println("Endereço: " +contato.getEndereco());
			System.out.println("Email: " +contato.getEmail());
			System.out.println("Telefone: "+contato.getTelefone()); 
			System.out.println("Sexo: "+contato.getSexo());
		}
		*/
		
	/***************************************************************************************/
		Contato contato=new Contato();
		//pega o contato com determinado id e altera
		contato.setId(Long.valueOf(2));
		contato.setNome("Emanuelly De Jesus Kaiser");
		contato.setEndereco("Rua Trinta Lagoa 461");
		contato.setEmail("emanuelykaiser@hotmail.com");
		contato.setTelefone("31988875567");
		contato.setSexo("F");
       ContatoDAO dao=new ContatoDAO();
     dao.altera(contato);
       
		
		/***************************************************************************************/
		
		
		/*Contato contato=new Contato();
		contato.setId(Long.valueOf(1));
		ContatoDAO dao=new ContatoDAO();
		dao.remove(contato);
		
		*/
		
		
	}

}
