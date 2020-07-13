/*
 * 
 * Its always better to have only one connection object of entire small application and that should be available when application ready .
 * 
 * So make that connection into static block or static method .
 * 
 */

package com.companyname.module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample6 {

	static Connection connection = null;

	static {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:student/password1@localhost:1521:orcl1");
			
			if (!connection.isClosed()) {
				System.out.println(" Yes...!!! Got The Connection to Datbase. Connection is established ");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	

	}

	public static void main(String[] args) {

		try {
			if (connection != null) {
				connection.close();

			}

			System.out.println("Connection closed sucessfully...");
		} catch (SQLException sQLException) {

			sQLException.printStackTrace();
		}
	
		
	
	}

}
