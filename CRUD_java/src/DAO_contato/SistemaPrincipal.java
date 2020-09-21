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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import java.awt.ScrollPane;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import java.awt.Font;

public class SistemaPrincipal extends JFrame {
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtSexo;
	private JTextField txtId;
	private  static  JLabel txtdata;
	private  static JLabel txthora;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SistemaPrincipal frame = new SistemaPrincipal();
				
					
				
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
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
		desktopPane.setDragMode(10);
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
			public void actionPerformed(ActionEvent e) {}});
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
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(SistemaPrincipal.class.getResource("/imagens/images.jpg")));
		button.setBounds(400, 8, 215, 161);
		desktopPane.add(button);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBackground(new Color(255, 228, 181));
		desktopPane_1.setBounds(499, 171, 126, 80);
		desktopPane.add(desktopPane_1);
		
		txtdata = new JLabel("");
		txtdata.setForeground(new Color(0, 0, 255));
		txtdata.setFont(new Font("Arial Black", Font.PLAIN, 14));
		txtdata.setBounds(24, 11, 92, 22);
		desktopPane_1.add(txtdata);
		
		txthora = new JLabel("");
		txthora.setForeground(new Color(0, 0, 205));
		txthora.setFont(new Font("Arial Black", Font.PLAIN, 14));
		txthora.setBounds(24, 44, 92, 25);
		desktopPane_1.add(txthora);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 300);
	}
}
