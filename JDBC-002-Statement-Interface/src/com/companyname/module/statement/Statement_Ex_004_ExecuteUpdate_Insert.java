/*
 * How to insert data into tables using statements .
 * 
 * 
 * We need to use "executeUpdate" method to do DML operations .
 * 
 * 
 */

package com.companyname.module.statement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Statement_Ex_004_ExecuteUpdate_Insert {

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection();){
			
			Statement createStatement = connection.createStatement(); // Creating the statement from the connection object .
			
			createStatement.execute(" CREATE TABLE STUDENT (FIRST_NAME VARCHAR2(20),MIDLLE_NAME VARCHAR2(20),EMAIL VARCHAR2(20),LAST_NAME VARCHAR2(1))"); //executing the statement 
			
			int NoOfRowsEffected =createStatement.executeUpdate(" INSERT INTO STUDENT VALUES('vijay','kumar','vijay@gmail.com','k') ");

			System.out.println("No of Rows created :- "+NoOfRowsEffected);
			
			NoOfRowsEffected =createStatement.executeUpdate(" INSERT INTO STUDENT VALUES('Ajay','kumar','Ajay@gmail.com','k') ");

			System.out.println("No of Rows created :- "+NoOfRowsEffected);


		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
