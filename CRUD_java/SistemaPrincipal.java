package DAO_contato;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexao.Conecta;
import logica.Contato;

import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.Frame;
import javax.swing.JTable;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class SistemaPrincipal extends JFrame {
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtSexo;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SistemaPrincipal frame = new SistemaPrincipal();
					frame.setVisible(true);
					private void formWindowOpened(java.awt.event.WindowEvent evt){
					Date datasistema=new Date();
					SimpleDateFormat formato=new SimpleDateFormat("dd/MM/YYYY");
					
					}
					
				} catch (Exception e) }
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SistemaPrincipal() {
		getContentPane().setBackground(new Color(224, 255, 255));
		getContentPane().setForeground(Color.RED);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		
		JDesktopPane desktopPane = new JDesktopPane();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		desktopPane.setBackground(SystemColor.activeCaptionBorder);
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setBounds(10, 11, 52, 14);
		desktopPane.add(lblNome);
		
		JLabel lblNewLabel = new JLabel("ENDERE\u00C7O :");
		lblNewLabel.setBounds(10, 37, 74, 14);
		desktopPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("EMAIL :");
		lblEmail.setBounds(10, 62, 46, 14);
		desktopPane.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("TELEFONE :");
		lblTelefone.setBounds(10, 97, 74, 14);
		desktopPane.add(lblTelefone);
		
		JLabel lblSexo = new JLabel("SEXO :");
		lblSexo.setBounds(10, 130, 46, 14);
		desktopPane.add(lblSexo);
		
		txtNome = new JTextField();
		txtNome.setBounds(72, 8, 304, 20);
		desktopPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(82, 34, 294, 20);
		desktopPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(72, 62, 304, 20);
		desktopPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(97, 94, 279, 20);
		desktopPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtSexo = new JTextField();
		txtSexo.setBounds(66, 122, 86, 20);
		desktopPane.add(txtSexo);
		txtSexo.setColumns(10);
		
		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ContatoDAO contato=new ContatoDAO();
					Connection con=Conecta.getConection();
					String sql="INSERT INTO contato(nome,endereco,email,telefone,sexo)values(?,?,?,?,?)";
					PreparedStatement stmt=con.prepareStatement(sql);
					stmt.setString(1, txtNome.getText());
					stmt.setString(2, txtEndereco.getText());
					stmt.setString(3, txtEmail.getText());
					stmt.setString(4, txtTelefone.getText());
					stmt.setString(5, txtSexo.getText());
					stmt.execute();
					stmt.close();
					JOptionPane.showMessageDialog(null, "Dados Cadastrados Com Sucesso");
					
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(10, 201, 120, 23);
		desktopPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ATUALIZAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					ContatoDAO contato=new ContatoDAO();
					Connection con=Conecta.getConection();
					
					String sql="UPDATE contato set nome=?,endereco=?,email=?,telefone=?,sexo=? where id=?";
					PreparedStatement stmt=con.prepareStatement(sql);
					stmt.setString(1, txtNome.getText());
					stmt.setString(2, txtEndereco.getText());
					stmt.setString(3, txtEmail.getText());
					stmt.setString(4, txtTelefone.getText());
					stmt.setString(5, txtSexo.getText());
					stmt.setNString(6, txtId.getText());
					stmt.execute();
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso");
					
				} catch (Exception e2) {
					
				}
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(140, 201, 110, 23);
		desktopPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("SELECIONAR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					
					
					
			        List<Contato>list=new ArrayList<Contato>();
			        while (rs.next()) {
			        	Contato c1=new Contato();
			        	c1.setNome(rs.getString("nome"));
			        	c1.setEndereco(rs.getString("endereco"));
						c1.setEmail(rs.getString("email"));
						c1.setTelefone(rs.getString("telefone"));
						c1.setSexo(rs.getString("sexo"));
						list.add(c1);
					System.out.println(list);
					}
					
					
					
					
					
					
				} catch (Exception e2) {
					
				}
				
				
				
				
				
			}
		});
		btnNewButton_2.setBounds(265, 201, 125, 23);
		desktopPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("DELETAR");
		btnNewButton_3.setBounds(400, 201, 89, 23);
		desktopPane.add(btnNewButton_3);
		
		JLabel lblId = new JLabel("ID : ");
		lblId.setBounds(10, 155, 46, 14);
		desktopPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(66, 153, 86, 20);
		desktopPane.add(txtId);
		txtId.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 300);
	}
}
