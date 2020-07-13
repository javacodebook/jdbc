/*
 * 
 * 	Few methods in result set 
 * beforeFirst()	:- Moves the cursor to before First row .
 * first() 			:- Moves the cursor to first 
 * last () 			:- Moves the cursor to last
 * afterLast() 		:- Moves the cursor after last row 
 * 
 * 
 *	ResultSet.TYPE_SCROLL_INSENSITIVE come move forward as well as back ward .
 *
 *	After ResultSet is opened if any change are happened in the database externally . those changes will not reflected .
 * 
 */

package com.companyname.module1.resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSet_Ex_005_Scroll_sensitive_with_CONCUR_UPDATABLE {

	public static void main(String[] args)  {
		
		
		/*
		 * Impotent Point Table should be have primary key 
		 * 
		 */
		//connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE) says the move forward  and back ward 
		
		try (Connection connection = DBUtil.getConnection();  ){
			
			PreparedStatement createStatement = connection.prepareStatement("SELECT FIRST_NAME,MIDLLE_NAME,EMAIL,LAST_NAME,ST_ID FROM STUDENT ",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			ResultSet resultSet=createStatement.executeQuery();  
			
			System.out.println("Iteration 1 started .........");
			
			while(resultSet.next()){ // Moving the cursor to next row , its will move next row till it finds row else return false
				
				System.out.println("FIRST_NAME :- "+resultSet.getString("FIRST_NAME")+"  MIDDLE_NAME :- "+resultSet.getString("MIDLLE_NAME")+" EMAIL :- "+resultSet.getString("EMAIL")+" LAST_NAME :- "+resultSet.getString("LAST_NAME"));	
				
			}
			
			//Setting result set cursor or pointer to first row .
			
			
			 // Inserting the new row to the table .
			 
			resultSet.moveToInsertRow();
			
			resultSet.updateString(1, "Jhon");
			resultSet.updateString(2, "Millor");
			resultSet.updateString(3, "Millor@gamil.com");
			resultSet.updateString(4, "M");
			resultSet.updateInt(5, 7);
			resultSet.insertRow();
			
			
			resultSet.beforeFirst();
			
			System.out.println("\n\n Iteration 2 started ......\n");

			// this result set will not printed because the result set is pointing to after last row after completion first iteration. 
			while(resultSet.next()){ 				
				System.out.println("FIRST_NAME :- "+resultSet.getString("FIRST_NAME")+"  MIDDLE_NAME :- "+resultSet.getString("MIDLLE_NAME")+" EMAIL :- "+resultSet.getString("EMAIL")+" LAST_NAME :- "+resultSet.getString("LAST_NAME"));	
			}
			
			
			/*//deleting row ...
			resultSet.last();
			resultSet.deleteRow();
			resultSet.beforeFirst();
			System.out.println("\n\n Iteration 3 started ......\n");

			// this result set will not printed because the result set is pointing to after last row after completion first iteration. 
			while(resultSet.next()){ 				
				System.out.println("FIRST_NAME :- "+resultSet.getString("FIRST_NAME")+"  MIDDLE_NAME :- "+resultSet.getString("MIDLLE_NAME")+" EMAIL :- "+resultSet.getString("EMAIL")+" LAST_NAME :- "+resultSet.getString("LAST_NAME"));	
			}
			
			
			// updating the row .
			resultSet.first();
			resultSet.updateString(1, "Jhon");
			resultSet.updateString(2, "Millor");
			resultSet.updateString(3, "Millor@gamil.com");
			resultSet.updateString(4, "M");
			
			resultSet.updateRow();
			
			
			System.out.println("\n\n Iteration 3 started ......\n");

			// this result set will not printed because the result set is pointing to after last row after completion first iteration. 
			while(resultSet.next()){ 				
				System.out.println("FIRST_NAME :- "+resultSet.getString("FIRST_NAME")+"  MIDDLE_NAME :- "+resultSet.getString("MIDLLE_NAME")+" EMAIL :- "+resultSet.getString("EMAIL")+" LAST_NAME :- "+resultSet.getString("LAST_NAME"));	
			}*/
			
			createStatement.close();
			resultSet.close();
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
