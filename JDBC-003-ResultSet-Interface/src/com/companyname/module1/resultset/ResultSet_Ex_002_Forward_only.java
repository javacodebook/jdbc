/*
 *	Forward-only result moves only in forward direction it cannot come back .
 * 
 */

package com.companyname.module1.resultset;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSet_Ex_002_Forward_only {

	public static void main(String[] args) {
		
		//connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY) says the move forward and records are read only .
		
		try (Connection connection = DBUtil.getConnection(); Statement createStatement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY); ){
			
			
			ResultSet resultSet=createStatement.executeQuery("SELECT * FROM STUDENT ");  
			
			System.out.println("Iteration 1 started ......");
			
			while(resultSet.next()){ // Moving the cursor to next row , its will move next row till it finds row else return false
				
				System.out.println("FIRST_NAME :- "+resultSet.getString("FIRST_NAME"));
				System.out.println("MIDDLE_NAME :- "+resultSet.getString("MIDLLE_NAME"));
				System.out.println("EMAIL :- "+resultSet.getString("EMAIL"));
				System.out.println("LAST_NAME :- "+resultSet.getString("LAST_NAME"));	
				
			}
			resultSet.absolute(1); // absolute is method which points to result set to any location in case of bi directional 		
			System.out.println("Iteration 2 started ......");

			// this result set will not printed because the result set is pointing to after last row after completion first iteration. 
			while(resultSet.next()){ 
				
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
