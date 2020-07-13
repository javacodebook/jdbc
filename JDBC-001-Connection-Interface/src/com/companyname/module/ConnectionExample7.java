/*
 * 
 * From JDBC 4.0 driver .If driver jar is finds the lib .it will pick and registers automatically .
 * 
 */

package com.companyname.module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample7 {

	static Connection connection = null;

	static {

		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");// commenting this line
			connection = DriverManager.getConnection("jdbc:oracle:thin:student/password1@localhost:1521:orcl1");

			if (!connection.isClosed()) {
				System.out.println(" Yes...!!! Got The Connection to Datbase. Connection is established ");
			}

		} catch (SQLException sQLException) {

			sQLException.printStackTrace();
		}
	}

	public static void main(String[] args) {

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
