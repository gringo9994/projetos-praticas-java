
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<% 
 try{
	 Class.forName("com.mysql.jdbc.Driver"); //Descobrindo o driver
	 Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/agenda", "root", ""); //conectando com o banco
	 out.print("conexão realizada");
	 }catch (ClassNotFoundException erroClass){
	 out.print("Class Driver não foi localizado, erro = "+erroClass);
	 }catch (SQLException e){
	 System.out.println("Erro na conexão ao banco de dados. erro = "+e);
	 }
		   
		    		
 
		%>











</html>
    
   