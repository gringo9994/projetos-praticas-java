package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexao.Conecta;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserCampo;
	private JPasswordField txtSenhaPass;

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
		setTitle("Login Sistema");
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\IVAN KAISER\\Pictures\\icons java\\Java-icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80, 80, 273, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(204, 255, 204));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel txtUser = new JLabel("USUARIO");
		txtUser.setForeground(new Color(128, 0, 0));
		txtUser.setFont(new Font("Arial Black", Font.PLAIN, 11));
		txtUser.setBounds(79, 11, 69, 14);
		desktopPane.add(txtUser);
		
		txtUserCampo = new JTextField();
		txtUserCampo.setBounds(50, 36, 98, 20);
		desktopPane.add(txtUserCampo);
		txtUserCampo.setColumns(10);
		
		JLabel txtSenha = new JLabel("SENHA");
		txtSenha.setFont(new Font("Arial Black", Font.PLAIN, 11));
		txtSenha.setForeground(new Color(128, 0, 0));
		txtSenha.setBounds(79, 67, 69, 14);
		desktopPane.add(txtSenha);
		
		JButton txtBtn = new JButton("ENTRAR");
		txtBtn.setFont(new Font("Arial Black", Font.PLAIN, 11));
		txtBtn.setForeground(new Color(128, 128, 0));
		txtBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				
				
				try {
					Connection con=Conecta.getConnection();
					String sql="select *from user where nome=? and senha=?";
					
					PreparedStatement stmt=con.prepareStatement(sql);
					stmt.setString(1, txtUserCampo.getText());
					stmt.setString(2, txtSenhaPass.getText());
					ResultSet rs=stmt.executeQuery();
				
				 if (rs.next()) {
					 JOptionPane.showMessageDialog(null,"Usuario Cadastrado");
					 JanelaPrincipal tela=new JanelaPrincipal();
					 //torna tela do sistema visível
					 tela.setVisible(true);
					 // torna a tela de login invisível
						setVisible(false);
					
				}else {
					JOptionPane.showMessageDialog(null, "Usuário Não Cadastrado");
				}
		
						
						
					
					stmt.close();
					con.close();
					
					
					Login login=new Login();
					login.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
					
					
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,"ERRO AO LOGAR"+e);
					e.printStackTrace();
				}
				
				
				
			
			
			}
		});
		txtBtn.setBounds(50, 136, 89, 23);
		desktopPane.add(txtBtn);
		
		txtSenhaPass = new JPasswordField();
		txtSenhaPass.setBounds(50, 92, 98, 20);
		desktopPane.add(txtSenhaPass);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\IVAN KAISER\\Downloads\\images_Easy-Resize.com.jpg"));
		label.setBounds(158, 36, 79, 115);
		desktopPane.add(label);
	}
}
