package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSql {
 private static final String url = "jdbc:mysql://localhost:3306/crud_mv";
 private static final String user = "root";
 private static final String password = "root";
 
 
 public static Connection createConnection() { 
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 System.out.println("Driver Found");
	 }
	 catch(ClassNotFoundException e){
		 System.out.println("Driver not Found" + e.getMessage());
	 }
	 
	 
	 try {
		 Connection connection = DriverManager.getConnection(url, user, password);
		 System.out.println("Conectado a database");
		 return connection;
	 }
	 catch(SQLException e){
		 System.out.println("Falha ao conectar a database" + e.getMessage()	);
		 return null;
	 }
	
 }
 
 
 
 
 }
