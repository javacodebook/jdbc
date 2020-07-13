/*
 * get connection  method one arguments 
 */

package com.companyname.module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample4 {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
						
			connection = DriverManager.getConnection("jdbc:oracle:thin:student/password1@localhost:1521:orcl1"); 		
			
		
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
