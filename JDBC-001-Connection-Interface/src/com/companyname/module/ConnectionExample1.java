/*
 * This example shows how to register driver with driver manager ,establish the connection with database .
 */
package com.companyname.module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample1 {

	public static void main(String[] args) {
		 
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//  Driver registration with DriverManager 
			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl1","student","password1"); // creating the connection 			
			
			
			if(!connection.isClosed()){
				System.out.println(" Yes...!!! Got The Connection to Datbase. Connection is established ");
			}
			
		} catch (ClassNotFoundException exception) {
			
			exception.printStackTrace();
		} catch (SQLException sQLException) {
			
			sQLException.printStackTrace();
		} 

	}

}
