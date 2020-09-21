package DAO_contato;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexao.Conecta;

import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		
		JLabel lblNewLabel = new JLabel("New label");
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(75, 75, 350, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(144, 238, 144));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setBounds(31, 30, 62, 14);
		desktopPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setBounds(31, 93, 46, 14);
		desktopPane.add(lblSenha);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Connection con=Conecta.getConection();
					
				String sql="select *from dados where usuario=? and senha=?"	;
				
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setString(1, txtUsuario.getText());
				stmt.setString(2,txtSenha.getText());
					ResultSet rs=stmt.executeQuery();
					if (rs.next()) {
						JOptionPane.showMessageDialog(null,"Usuario Cadastrado");
						SistemaPrincipal tela=new SistemaPrincipal();
						tela.setVisible(true);
						tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
						Login login=new Login();
						login.setVisible(false);
					
					}
					else{
						JOptionPane.showMessageDialog(null, "Usuario Não existe");
					}
					stmt.close();
					con.close();
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Não foi Possível entrar");
					
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnLogin.setBounds(106, 124, 89, 23);
		desktopPane.add(btnLogin);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(93, 27, 138, 20);
		desktopPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(87, 90, 144, 20);
		desktopPane.add(txtSenha);
		txtSenha.setColumns(10);
	}
}
