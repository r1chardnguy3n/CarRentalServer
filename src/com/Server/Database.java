package com.Server;
import java.sql.*;
public class Database {
	
	public static void main(String[] args) {
		
		try {
			//connection to database
			Class.forName("com.mysql.jdbc.Driver");
			String usr = "root";
			String psw = "";
			String url = "jdbc:mysql://localhost:3306/douglas_car_rental_server";
			Connection myConn = DriverManager.getConnection(url, usr, psw);
			
			//statement
			Statement myState = myConn.createStatement();
			
			//Execute SQL query
			ResultSet myResult = myState.executeQuery("select * from vehicle");
			
			//Process results
			while (myResult.next()) {
				System.out.println(myResult.getString("make") + ", " + myResult.getString("model"));
			}
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}

		
	}
	

}
