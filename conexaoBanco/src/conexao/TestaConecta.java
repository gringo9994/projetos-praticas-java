package conexao;

import java.sql.SQLException;

public class TestaConecta {

	public static void main(String[] args) throws SQLException  {
	
		Conecta con=new Conecta();
		con.getConnection();
	}

}
