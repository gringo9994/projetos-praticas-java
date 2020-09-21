
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    import="java.sql.*"
    
    
    
    %>
<%@page language="java" import="conexao_tomcat.Conecta"%>





<%


String nome=request.getParameter("nome");


try{
Connection con=Conecta.getConnection();
 String sql="insert into tes(nome) value (?)";
PreparedStatement stmt=con.prepareStatement(sql);
stmt.setString(1, nome);
stmt.execute();
stmt.close();

}catch(Exception e){
	out.print("Erro Ao Inserir os Dados"+e);
	
}



%>




    
    