package viewTxt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import DAO.ProdutoDAO;
import conexao_Banco.Conecta;
import model.Produto;

import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JList;

public class SistemaPincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtCategoria;
	private JTextField txtNome;
	private JTextField txtQuantidade;
	private JTextField txtFabricante;
	private JTextField txtDescricao;
	private JTextField txtValor;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SistemaPincipal frame = new SistemaPincipal();
					frame.setVisible(true);
					frame.setTitle("Controle de Estoque");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SistemaPincipal() {
		setFont(new Font("Arial Black", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBorder(UIManager.getBorder("InternalFrame.border"));
		desktopPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Categoria  :");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNewLabel.setForeground(new Color(0, 0, 51));
		lblNewLabel.setBounds(10, 53, 101, 23);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNome.setForeground(new Color(0, 0, 51));
		lblNome.setBounds(10, 87, 101, 21);
		desktopPane.add(lblNome);
		
		JLabel lblValor = new JLabel("Valor :");
		lblValor.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblValor.setForeground(new Color(0, 0, 51));
		lblValor.setBounds(10, 119, 101, 22);
		desktopPane.add(lblValor);
		
		JLabel lblQuantidade = new JLabel("Quantidade :");
		lblQuantidade.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblQuantidade.setForeground(new Color(0, 0, 51));
		lblQuantidade.setBounds(10, 152, 155, 22);
		desktopPane.add(lblQuantidade);
		
		JLabel lblFabricante = new JLabel("Fabricante :");
		lblFabricante.setForeground(new Color(0, 0, 51));
		lblFabricante.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblFabricante.setBounds(10, 185, 112, 23);
		desktopPane.add(lblFabricante);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o :");
		lblDescrio.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblDescrio.setForeground(new Color(0, 0, 51));
		lblDescrio.setBounds(10, 219, 132, 23);
		desktopPane.add(lblDescrio);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(135, 56, 197, 20);
		desktopPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(135, 89, 197, 20);
		desktopPane.add(txtNome);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(135, 155, 197, 20);
		desktopPane.add(txtQuantidade);
		
		txtFabricante = new JTextField();
		txtFabricante.setColumns(10);
		txtFabricante.setBounds(135, 185, 197, 20);
		desktopPane.add(txtFabricante);
		
		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(135, 222, 197, 20);
		desktopPane.add(txtDescricao);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(135, 122, 197, 20);
		desktopPane.add(txtValor);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					
					
					
					// MÉTODO PARA INSERIR AS INFORMAÇÕES NO BANCO DE DADOS
					ProdutoDAO produto=new ProdutoDAO();
					Connection con=conexao_Banco.Conecta.getConection();
					
					
					String sql="INSERT INTO produto(categoria,nome,valor,quantidade,fabricante,descricao)values(?,?,?,?,?,?)";
					PreparedStatement stmt=con.prepareStatement(sql);
					stmt.setString(1, txtCategoria.getText());
					stmt.setString(2, txtNome.getText());
					stmt.setString(3, txtValor.getText());
					stmt.setString(4, txtQuantidade.getText());
					stmt.setString(5, txtFabricante.getText());
					stmt.setString(6, txtDescricao.getText());
					stmt.execute();
				
					stmt.close();
					JOptionPane.showMessageDialog(null, "Dados Cadastrados Com Sucesso");
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				} catch (Exception e) {
					
				}
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(10, 253, 89, 23);
		desktopPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
try {
	
	//MÉTODO PARA ATUALIZAR AS INFORMAÇÕES NO BANCO DE DADOS
					
					ProdutoDAO contato=new ProdutoDAO();
					Connection con=conexao_Banco.Conecta.getConection();
					
					String sql="UPDATE produto set categoria=?, nome=?,valor=?,quantidade=?,fabricante=?,descricao=? where id=?";
					PreparedStatement stmt=con.prepareStatement(sql);
					stmt.setString(1, txtCategoria.getText());
					stmt.setString(2, txtNome.getText());
					stmt.setString(3, txtValor.getText());
					stmt.setString(4, txtQuantidade.getText());
					stmt.setString(5, txtFabricante.getText());
					stmt.setString(6, txtDescricao.getText());
					stmt.setString(7,txtId.getText());
					stmt.execute();
					
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso");
					
				} catch (Exception e2) {
					
				}
				
				
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(129, 253, 89, 23);
		desktopPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Buscar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//  MÉTODO PARA BUSCAR AS INFORMAÇÕES NO BANCO DE DADOS
				try {
					Connection con=Conecta.getConection();
					ProdutoDAO produto=new ProdutoDAO();
					List<Produto> list=produto.getLista();
					for (Produto produto2 : list) {
						JOptionPane.showMessageDialog(null,produto2.toString());
						
					}
					

				
					
					
					
					
					
				} catch (Exception e2) {
					
	
					
				}
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnNewButton_2.setBounds(247, 253, 89, 23);
		desktopPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Excluir");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//MÉTODO PARA EXCLUIR AS INFORMAÇÕES NO BANCO DE DADOS
				
				
				try {
					ProdutoDAO contato=new ProdutoDAO();
					Connection con=conexao_Banco.Conecta.getConection();
					
					String sql="DELETE FROM produto where id=?";
					PreparedStatement stmt=con.prepareStatement(sql);
					stmt.setString(1, txtId.getText());
					JOptionPane.showConfirmDialog(null, "Deseja Realmente Excluir");
					stmt.execute();
			        stmt.close();
					JOptionPane.showMessageDialog(null, "Dados Excluídos Com Sucesso");
					
					
					
					
					
					
					
					
					
					
					
				} catch (Exception e2) {
				
				}
				
				
				
				
				
			}
		});
		btnNewButton_3.setBounds(359, 253, 89, 23);
		desktopPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setBounds(342, 54, 112, 188);
		desktopPane.add(btnNewButton_4);
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\IVAN KAISER\\Pictures\\java2.jpg"));
		btnNewButton_4.setForeground(new Color(153, 153, 255));
		
		JLabel lblNewLabel_1 = new JLabel("ID :");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 28, 46, 14);
		desktopPane.add(lblNewLabel_1);
		
		txtId = new JTextField();
		txtId.setBounds(66, 25, 67, 20);
		desktopPane.add(txtId);
		txtId.setColumns(10);
	}
}
