/*
 * Selecting data by using the statement  by index .
 * 
 * Statement always deals with the static content .
 *  
 * We need to use "executeQuery" method to do DML operations .
 * 
 * executeQuery Returns the ResultSet which contains the  fetched data .
 * 
 * 
 */

package com.companyname.module.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Statement_Ex_008_ExecuteQuery_Select {

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection();){
			
			Statement createStatement = connection.createStatement(); // Creating the statement from the connection object .
			
			//createStatement.execute(" CREATE TABLE STUDENT1 (FIRST_NAME VARCHAR2(20),MIDLLE_NAME VARCHAR2(20),EMAIL VARCHAR2(20),LAST_NAME VARCHAR2(1),AGE INTEGER)"); //executing the statement 
			
			int NoOfRowsEffected =createStatement.executeUpdate(" INSERT INTO STUDENT VALUES('vijay','kumar','vijay@gmail.com','k') ");
			
		//	System.out.println(" No of rows created :-"+NoOfRowsEffected);
			
			ResultSet resultSet=createStatement.executeQuery("SELECT * FROM STUDENT "); // For select 
			
			/*while(resultSet.next()){
				
				System.out.println("FIRST_NAME :- "+resultSet.getString("FIRST_NAME"));
				System.out.println("MIDDLE_NAME :- "+resultSet.getString("MIDLLE_NAME"));
				System.out.println("EMAIL :- "+resultSet.getString("EMAIL"));
				System.out.println("LAST_NAME :- "+resultSet.getString("LAST_NAME"));	
				System.out.println("AGE :- "+resultSet.getInt("AGE"));
			}*/
			
			
			while(resultSet.next()){
				
				System.out.println("FIRST_NAME :- "+resultSet.getString(1));
				System.out.println("MIDDLE_NAME :- "+resultSet.getString(2));
				System.out.println("EMAIL :- "+resultSet.getString(3));
				System.out.println("LAST_NAME :- "+resultSet.getString(4));	
				//System.out.println("AGE :- "+resultSet.getInt(5));
			}
			resultSet.close();
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
