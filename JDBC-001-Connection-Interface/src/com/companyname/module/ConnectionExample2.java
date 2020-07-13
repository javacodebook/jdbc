/*
 * Connection URL with IP address.
 */

package com.companyname.module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample2 {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// 1) Driver registration 
			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.7:1521:orcl1","student","password1"); // creating the connection
			
			
			System.out.println(" Connection status :-  "+!connection.isClosed());
			
			
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
