/*
 *	By default every Query statement execution from JDBC is auto commit is true . It meaning after execute of that query its will be moved to database .
 * 
 */

package com.companyname.module1.resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Batch_Ex_001_Introduction {

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection(); Statement createStatement = connection.createStatement(); ){
			
			PreparedStatement prepareStatement= null;
			
			String createSQL = "CREATE TABLE STUDENT (FIRST_NAME VARCHAR2(20),MIDLLE_NAME VARCHAR2(20),EMAIL VARCHAR2(20),LAST_NAME VARCHAR2(1))"; //DROP TABLE STUDENT
			
			prepareStatement = connection.prepareStatement(createSQL); // Creating the prepared statement from the connection object .
			
			prepareStatement.execute();
			
			
			
			System.out.println("Table Creation Sucessfully ");		
			
			prepareStatement = connection.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?)");
			 
			prepareStatement.setString(1, "Vijay"); 
			prepareStatement.setString(2, "Kumar");  
			prepareStatement.setString(3, "VijayKumar@gmail.com"); 
			prepareStatement.setString(4, "K"); 
			
			int NoOfRowsEffected =prepareStatement.executeUpdate();		
			
			

			System.out.println("No of Rows created :- "+NoOfRowsEffected);
			
			prepareStatement.setString(1, "Vijay1");
			prepareStatement.setString(2, "Kumar1");
			prepareStatement.setString(3, "VijayKuma1@gmail.com");
			prepareStatement.setString(4, "K");
			
			NoOfRowsEffected =prepareStatement.executeUpdate();			

			System.out.println("No of Rows created :- "+NoOfRowsEffected);
			
			
			
						
			prepareStatement.setString(1, "Ajay");
			prepareStatement.setString(2, "Kumar");
			prepareStatement.setString(3, "AjayKumar@gmail.com");
			prepareStatement.setString(4, "A");
			
			NoOfRowsEffected =prepareStatement.executeUpdate();		
			
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
