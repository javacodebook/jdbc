/*
 * What if do not know the common names of the table ? then how can i retrieve the data .
 */

package com.companyname.module1.transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSet_Example_1 {

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection();){
			
			
			
			String selectSQL = "SELECT * FROM STUDENT WHERE FIRST_NAME=?";
			
			PreparedStatement  preparedStatement = connection.prepareStatement(selectSQL);
			
			preparedStatement.setString(1, "Vijay1"); // First ? Value 
			
			 ResultSet executeQueryResult = preparedStatement.executeQuery();
			
			// For the first record execution it takes :- Query -> Parse -> Optimize -> compile -> execute -> result
			
			 ResultSetMetaData metaData = executeQueryResult.getMetaData();
			 
			 
			 int columnCount = metaData.getColumnCount();	 
			 
			 
			 System.out.println("Columns Retrived  ");
			 
			 for(int count =1;count<columnCount;count++){
				 System.out.println(metaData.getColumnName(count));
			 }
			 
			 
			 
			 
			 
			 /*
				while(executeQueryResult.next()){
					
					System.out.println("FIRST_NAME :- "+executeQueryResult.getString("FIRST_NAME"));
					System.out.println("MIDDLE_NAME :- "+executeQueryResult.getString("MIDLLE_NAME"));
					System.out.println("EMAIL :- "+executeQueryResult.getString("EMAIL"));
					System.out.println("LAST_NAME :- "+executeQueryResult.getString("LAST_NAME"));				
				}
				
			*/	executeQueryResult.close();
				
				
			
			
			
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
