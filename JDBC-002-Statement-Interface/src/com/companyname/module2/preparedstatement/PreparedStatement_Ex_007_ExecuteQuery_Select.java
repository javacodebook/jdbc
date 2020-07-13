/*
 * Selecting data by using the  prepared statement .
 *  
 * We need to use "executeQuery" method to do DML operations .
 * 
 * executeQuery Returns the ResultSet which contains the  fetched data .
 * 
 * 
 */

package com.companyname.module2.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatement_Ex_007_ExecuteQuery_Select {

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection();){
			
			
			
			String selectSQL = "SELECT * FROM STUDENT WHERE FIRST_NAME=?";
			
			PreparedStatement  preparedStatement = connection.prepareStatement(selectSQL);
			
			preparedStatement.setString(1, "Ravi"); // First ? Value 
			
			 ResultSet executeQueryResult = preparedStatement.executeQuery();
			
			// For the first record execution it takes :- Query -> Parse -> Optimize -> compile -> execute -> result
			

				while(executeQueryResult.next()){
					
					System.out.println("FIRST_NAME :- "+executeQueryResult.getString("FIRST_NAME"));
					System.out.println("MIDDLE_NAME :- "+executeQueryResult.getString("MIDLLE_NAME"));
					System.out.println("EMAIL :- "+executeQueryResult.getString("EMAIL"));
					System.out.println("LAST_NAME :- "+executeQueryResult.getString("LAST_NAME"));				
				}
				
				executeQueryResult.close();
				
				
			
			
			
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
