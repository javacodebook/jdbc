/*
 * How to alter a table by using the execute method .which is used to for DDL queries .
 * 
 * Statement takes only static query
 * Statement query plan will be all the times  . 
 */

package com.companyname.module2.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatement_Ex_003_Execute_Alter {

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection();){
			
						
			String createSQL = "CREATE TABLE DEMO_TEMP (NAME VARCHAR2(20))"; //DROP TABLE DEMO_TEMP
			
			PreparedStatement prepareStatement = connection.prepareStatement(createSQL); // Creating the prepared statement from the connection object .
			
			prepareStatement.execute();
			
			System.out.println("Table Creation Sucessfully ");			
			
			String alterSQL = "ALTER TABLE DEMO_TEMP  ADD testColumn VARCHAR(20)";
			
			prepareStatement  =connection.prepareStatement(alterSQL);
			
			prepareStatement.execute();

			System.out.println("Table Altered Sucessfully ");
			
					
			
			
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
