/*
 * 
 * We should close the connection . once database operation is over .As connection operation is too costly operation .When say costly its take resources ,memory and time .
 * 
 */

package com.companyname.module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample5 {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
						
			connection = DriverManager.getConnection("jdbc:oracle:thin:student/password1@192.168.0.16:1521:orcl1"); 		
			
			if(!connection.isClosed()){
				System.out.println(" Yes...!!! Got The Connection to Datbase. Connection is established ");
			}
			
		//System.exit(0);
		System.out.println("hello");
			
		} catch (ClassNotFoundException exception) {
			
			exception.printStackTrace();
		} catch (SQLException sQLException) {
			
			sQLException.printStackTrace();
		} finally{
			
			try {
				
				
				if(connection!=null){
					connection.close();
	
				}
								System.out.println("Connection closed sucessfully...");
			} catch (SQLException sQLException) {
				
				sQLException.printStackTrace();
			}
		}
		

	}

}
