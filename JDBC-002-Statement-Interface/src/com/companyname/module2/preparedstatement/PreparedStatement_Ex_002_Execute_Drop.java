/*
 * How to drop a table by using the execute method .which is used to for DDL queries .
 */

package com.companyname.module2.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatement_Ex_002_Execute_Drop {

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection();){
			
			String createSQL = "CREATE TABLE DEMO_TEMP (NAME VARCHAR2(20))"; //DROP TABLE DEMO_TEMP
			
			PreparedStatement prepareStatement = connection.prepareStatement(createSQL); // Creating the prepared statement from the connection object .
			
			prepareStatement.execute();
			
			System.out.println("Table Creation Sucessfully ");			
			
			String dropSQL = "DROP TABLE DEMO_TEMP";
			
			prepareStatement  =connection.prepareStatement(dropSQL);
			
			prepareStatement.execute();

			System.out.println("table dropped sucessfully ");
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
