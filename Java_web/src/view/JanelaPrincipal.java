package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import conexao.Conecta;
import dao.UsuarioDAO;
import modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTable txtTable;
	private JLabel txtId;
	private JLabel txtNome;
	private JLabel txtEndereco;
	private JLabel txtTelefone;
	private JTextField txtId1;
	private JTextField txtNome_1;
	private JTextField txtEndereco1;
	private JTextField txtTelefone1;
	private JButton txtSalvar;
	private JButton txtBuscar;
	private JButton txtEditar;
	private JButton txtExcluir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal frame = new JanelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public JanelaPrincipal() throws SQLException {
		setBackground(new Color(102, 204, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(102, 204, 204));
		desktopPane.setBorder(UIManager.getBorder("FormattedTextField.border"));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(UIManager.getBorder("Spinner.border"));
		scrollPane.setBounds(10, 140, 671, 101);
		desktopPane.add(scrollPane);
		
		txtTable = new JTable();
		txtTable.setFont(new Font("Arial Black", Font.PLAIN, 12));
		txtTable.setBackground(Color.GREEN);
		txtTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome", "Endere\u00E7o", "Telefone"
			}
		));
		txtTable.getColumnModel().getColumn(0).setPreferredWidth(80);
		txtTable.getColumnModel().getColumn(1).setPreferredWidth(200);
		txtTable.getColumnModel().getColumn(2).setPreferredWidth(260);
		txtTable.getColumnModel().getColumn(3).setPreferredWidth(150);
		scrollPane.setViewportView(txtTable);
		
		txtId = new JLabel("ID");
		txtId.setBounds(33, 11, 46, 14);
		desktopPane.add(txtId);
		
		txtNome = new JLabel("NOME");
		txtNome.setBounds(153, 11, 46, 14);
		desktopPane.add(txtNome);
		
		txtEndereco = new JLabel("ENDERE\u00C7O");
		txtEndereco.setBounds(306, 11, 73, 14);
		desktopPane.add(txtEndereco);
		
		txtTelefone = new JLabel("TELEFONE");
		txtTelefone.setBounds(472, 11, 85, 14);
		desktopPane.add(txtTelefone);
		
		txtId1 = new JTextField();
		txtId1.setBounds(10, 47, 58, 20);
		desktopPane.add(txtId1);
		txtId1.setColumns(10);
		
		txtNome_1 = new JTextField();
		txtNome_1.setColumns(10);
		txtNome_1.setBounds(94, 47, 154, 20);
		desktopPane.add(txtNome_1);
		
		txtEndereco1 = new JTextField();
		txtEndereco1.setColumns(10);
		txtEndereco1.setBounds(269, 47, 191, 20);
		desktopPane.add(txtEndereco1);
		
		txtTelefone1 = new JTextField();
		txtTelefone1.setColumns(10);
		txtTelefone1.setBounds(472, 47, 105, 20);
		desktopPane.add(txtTelefone1);
		
		txtSalvar = new JButton("SALVAR");
		txtSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql="INSERT INTO usuario(nome,endereco,telefone)values(?,?,?)";
				try {
					
				Connection con=Conecta.getConnection();
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setString(1,txtNome_1.getText());
					stmt.setString(2, txtEndereco1.getText());
					stmt.setString(3, txtTelefone1.getText());
					stmt.execute();
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Dados Cadastrados com Sucesso");
				txtNome_1.setText("");
				txtEndereco1.setText("");
				txtTelefone1.setText("");
				
	
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				
				
				
			}
		});
		txtSalvar.setBounds(10, 96, 89, 23);
		desktopPane.add(txtSalvar);
		
		txtBuscar = new JButton("BUSCAR");
		txtBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					readJtable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		txtBuscar.setBounds(141, 96, 89, 23);
		desktopPane.add(txtBuscar);
		
		txtEditar = new JButton("EDITAR");
		txtEditar.setBounds(263, 96, 89, 23);
		desktopPane.add(txtEditar);
		
		txtExcluir = new JButton("EXCLUIR");
		txtExcluir.setBounds(378, 96, 89, 23);
		desktopPane.add(txtExcluir);
	
		// MÉTODO PARA BUSCAR E IMPRIMIR NA NA JTABLE
	}
    public void readJtable() throws SQLException{
    	DefaultTableModel model=(DefaultTableModel) txtTable.getModel();
    	txtTable.getColumnModel().getColumn(0).setPreferredWidth(80);
		txtTable.getColumnModel().getColumn(1).setPreferredWidth(200);
		txtTable.getColumnModel().getColumn(2).setPreferredWidth(260);
		txtTable.getColumnModel().getColumn(3).setPreferredWidth(150);
    	UsuarioDAO userdao=new UsuarioDAO();
    	 
   for(Usuario user:userdao.BuscaUsuario()){
	   
	   // Cria um Objeto array de colunas
	   
	  model.addRow(new Object[]{
			  
			  user.getId(),
			  user.getNome(),
			  user.getEndereco(),
			  user.getTelefone()
			  
	  });
	  
	   
   }
    	
    	
    }
}
