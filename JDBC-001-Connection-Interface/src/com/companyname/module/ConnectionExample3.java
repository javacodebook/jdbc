/*
 * get connection  method two arguments .Here key should be user,password.
 */

package com.companyname.module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionExample3 {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Properties properties = new Properties();
			properties.setProperty("user", "student");
			properties.setProperty("password","password1");			
			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl1",properties); 
			
			
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
