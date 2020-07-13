/*
 *	We have seen the executeQuery method returns the ResultSet . It contains the rows of the data returned by the select statement  .
 * 
 */

package com.companyname.module1.resultset;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSet_Ex_001_Introduction {

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection(); Statement createStatement = connection.createStatement(); ){
			
			
			ResultSet resultSet=createStatement.executeQuery("SELECT * FROM STUDENT ");  // All the Selected data will be stored here .
			
			// First cursor points to the before first row.
			while(resultSet.next()){ // Moving the cursor to next row , its will move next row till it finds row else return false
				
				System.out.println("FIRST_NAME :- "+resultSet.getString("FIRST_NAME"));
				System.out.println("MIDDLE_NAME :- "+resultSet.getString("MIDLLE_NAME"));
				System.out.println("EMAIL :- "+resultSet.getString("EMAIL"));
				System.out.println("LAST_NAME :- "+resultSet.getString("LAST_NAME"));	
				
			}
					
			resultSet.close();
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
