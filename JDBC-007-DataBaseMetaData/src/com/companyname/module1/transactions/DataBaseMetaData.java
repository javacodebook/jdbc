/*
 * Lets say ..in Real time your getting the connection object from some where and you want to know which kind of the Data base url ,user name and other connection information.
 */

package com.companyname.module1.transactions;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class DataBaseMetaData {

	static Connection connection = DBUtil.getConnection();
	static private DatabaseMetaData datbaseMetaData = null; // Gives the information about  database

		public static void main(String[] args) {

		try {
			
			datbaseMetaData = connection.getMetaData();
			
			System.out.println("DataBase URL :- "+datbaseMetaData.getURL());
			System.out.println("DataBase ProductName  :- "+datbaseMetaData.getDatabaseProductName());
			System.out.println("DataBase driver Name  :- "+datbaseMetaData.getDriverName());
			System.out.println("DataBase Username  :- "+datbaseMetaData.getUserName());
			System.out.println("DataBase keywords :- "+datbaseMetaData.getSQLKeywords());
			
			
			
			if(connection!=null){
				connection.close();

			}

			System.out.println("Connection closed sucessfully...");
		} catch (SQLException sQLException) {

			sQLException.printStackTrace();
		}
	}

}
