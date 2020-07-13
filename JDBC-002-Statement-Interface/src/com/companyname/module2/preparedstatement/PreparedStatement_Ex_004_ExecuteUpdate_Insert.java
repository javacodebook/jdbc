/*
 * How to insert data into tables using prepared statements .
 * 
 * 
 * We need to use "executeUpdate" method to do DML operations .
 * 
 * 
 * Prepared statements are  quick while inserting the values into data base .Because every database request is handled with some process .
 * 1) parse the input query
 * 2) compile the query 
 * 3) Analysis the query , optimize the query and plans the execution 
 * 4) execute and pass on the out put .
 * In case of prepared query first 1-3 steps been already executed ,that the reason they are quick
 * 
 * They are safe (avoid SQL injection and dynamic) 
 * 
 */

package com.companyname.module2.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatement_Ex_004_ExecuteUpdate_Insert {

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection();){
			
			PreparedStatement prepareStatement= null;
			
			String createSQL = "CREATE TABLE STUDENT (FIRST_NAME VARCHAR2(20),MIDLLE_NAME VARCHAR2(20),EMAIL VARCHAR2(20),LAST_NAME VARCHAR2(1),ST_ID INT)"; //DROP TABLE STUDENT
			
			prepareStatement = connection.prepareStatement(createSQL); // Creating the prepared statement from the connection object .
			
			prepareStatement.execute();
			
			System.out.println("Table Creation Sucessfully ");		
			
			prepareStatement = connection.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?,?)");// Place holders
			 
			prepareStatement.setString(1, "Vijay"); // First ? Value 
			prepareStatement.setString(2, "Kumar"); // Second ? Value 
			prepareStatement.setString(3, "VijayKumar@gmail.com"); // Third ? Value 
			prepareStatement.setString(4, "K"); // Fourth ? Value
			prepareStatement.setInt(5, 100); // Fourth ? Value
			
			int NoOfRowsEffected =prepareStatement.executeUpdate();		
			
			// For the first record execution it takes :- Query -> Parse -> Optimize -> compile -> execute -> result

			System.out.println("No of Rows created :- "+NoOfRowsEffected);
			
			prepareStatement.setString(1, "Ravi");
			prepareStatement.setString(2, "Kumar");
			prepareStatement.setString(3, "RaviKuma1@gmail.com");
			prepareStatement.setString(4, "K");
			prepareStatement.setInt(5, 200);
			
			NoOfRowsEffected =prepareStatement.executeUpdate();			

			System.out.println("No of Rows created :- "+NoOfRowsEffected);
			
			
			// For the second record execution it takes :- execute -> result
						
			prepareStatement.setString(1, "Ajay");
			prepareStatement.setString(2, "Kumar");
			prepareStatement.setString(3, "AjayKumar@gmail.com");
			prepareStatement.setString(4, "A");
			prepareStatement.setInt(5, 300);
			
			NoOfRowsEffected =prepareStatement.executeUpdate();		
			
			// For the third record execution it takes :- execute -> result

			System.out.println("No of Rows created :- "+NoOfRowsEffected);
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
