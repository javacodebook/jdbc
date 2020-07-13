/*
 *	
 * Lets say i have requirement of processing few record as together .If any of the query is failed in middle , Previous queries  need to roll back. By using simple JDBC we can not
 * do , Because its by default auto commit true .each DML will be committed as soon as its executed  .
 * 
 * We can avoid this problem by using batch ...After sucess full execution of all queries then only commit takes place .
 *
 */

package com.companyname.module1.resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Batch_Ex_002_Introduction {

	public static void main(String[] args) {
		
		Connection connection = DBUtil.getConnection();
		try ( Statement createStatement = connection.createStatement(); ){
			
			PreparedStatement prepareStatement= null;
			
			/*String createSQL = "CREATE TABLE STUDENT (FIRST_NAME VARCHAR2(20),MIDLLE_NAME VARCHAR2(20),EMAIL VARCHAR2(20),LAST_NAME VARCHAR2(1))"; //DROP TABLE STUDENT
			
			prepareStatement = connection.prepareStatement(createSQL); // Creating the prepared statement from the connection object .
			
			prepareStatement.execute();
			*/
			
			
			
			
			
			System.out.println("Table Creation Sucessfully ");		
			
			prepareStatement = connection.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?)");
			 
			prepareStatement.setString(1, "Vijay"); 
			prepareStatement.setString(2, "Kumar");  
			prepareStatement.setString(3, "VijayKumar@gmail.com"); 
			prepareStatement.setString(4, "K"); 
		//	prepareStatement.setString(5, "300"); 
			// Step 1:- adding to the batch first insert record 
			prepareStatement.addBatch();
			
	
			prepareStatement.setString(1, "Vijay1");
			prepareStatement.setString(2, "Kumar1");
			prepareStatement.setString(3, "VijayKuma1@gmail.com");
			prepareStatement.setString(4, "K");
			//prepareStatement.setString(5, "301");
			// Step 1:- adding to the batch second insert record 
			prepareStatement.addBatch();
						
			prepareStatement.setString(1, "Ajay");
			prepareStatement.setString(2, "Kumar");
			prepareStatement.setString(3, "AjayKumar@gmail.com");
			prepareStatement.setString(4, "A");
			//prepareStatement.setString(5, "302");
			
			// Step 1:- adding to the batch third insert record 
			prepareStatement.addBatch();
			
			// Step 2:- execute the batch 
			prepareStatement.executeBatch();
			
			
			
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
