/*
 *	ResultSet.TYPE_SCROLL_INSENSITIVE come move forward as well as back ward .
 *
 *	After ResultSet is opened if any change are happened in the database externally . those changes will not reflected .
 * 
 */

package com.companyname.module1.resultset;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSet_Ex_003_Scroll_insensitive {

	public static void main(String[] args) {
		
		//connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY) says the move forward  and back ward and records are read only .
		
		try (Connection connection = DBUtil.getConnection(); Statement createStatement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); ){
			
			
			ResultSet resultSet=createStatement.executeQuery("SELECT * FROM STUDENT ");  
			
			System.out.println("Iteration 1 started ......");
			
			while(resultSet.next()){ // Moving the cursor to next row , its will move next row till it finds row else return false
				
				System.out.println("FIRST_NAME :- "+resultSet.getString("FIRST_NAME")+"  MIDDLE_NAME :- "+resultSet.getString("MIDLLE_NAME")+" EMAIL :- "+resultSet.getString("EMAIL")+" LAST_NAME :- "+resultSet.getString("LAST_NAME"));	
				
			}
			
			//Setting result set cursor or pointer to first row .
			
			resultSet.absolute(1);
			
			
			System.out.println("\n\n Iteration 2 started ......\n");

			// this result set will not printed because the result set is pointing to after last row after completion first iteration. 
			while(resultSet.next()){ 				
				System.out.println("FIRST_NAME :- "+resultSet.getString("FIRST_NAME")+"  MIDDLE_NAME :- "+resultSet.getString("MIDLLE_NAME")+" EMAIL :- "+resultSet.getString("EMAIL")+" LAST_NAME :- "+resultSet.getString("LAST_NAME"));	
			}
			
			
			//Setting result set cursor or pointer to third  row .
			resultSet.absolute(3);
			
			System.out.println("\n\n Iteration 3 started ......\n");

			// this result set will not printed because the result set is pointing to after last row after completion first iteration. 
			while(resultSet.next()){ 				
				System.out.println("FIRST_NAME :- "+resultSet.getString("FIRST_NAME")+"  MIDDLE_NAME :- "+resultSet.getString("MIDLLE_NAME")+" EMAIL :- "+resultSet.getString("EMAIL")+" LAST_NAME :- "+resultSet.getString("LAST_NAME"));	
			}
			resultSet.close();
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
