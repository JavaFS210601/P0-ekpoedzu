package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
		public static Connection getConnection() throws SQLException{
			
			//For compatibility with other technologies/frameworks, we will need to register our 
			//This process makes the applicaation aware of what Driver Class (what SQL dialect
			try {
				Class.forName("org.postgresql.Driver");//try to find and return the postgresql
			}catch(ClassNotFoundException e) {
				System.out.println("Class wasn't found : (");
				e.printStackTrace();//prints the exception message to the console
			}
//			//We need to provide our database credentials
//			//We will hardcode them for now but we will see how to hide this username/password in 
			String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=Teddy";
			String username ="postgres";
			String password = "Ewoenam";//this will be whatever password you set in postgres
			
//			String url = System.getenv("url");
//			String username = System.getenv("username");
//			String password = System.getenv("password");
			
			
			
			return DriverManager.getConnection(url, username, password);
			
			
		}

}
