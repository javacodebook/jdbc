/*
 * This program explains the both how to get the connection from properties file and statement example .
 */

package com.companyname.module.statement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Statement_Ex_001_Execute_Create {

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection();){
			
			Statement createStatement = connection.createStatement(); // Creating the statement from the connection object .
			
			
			
			//createStatement.execute(" CREATE TABLE Student_Demo ( NAME VARCHAR2(20))"); //executing the statement 
			
			//System.out.println("table creation sucessfully... ");
			
			createStatement.execute(" DROP TABLE Student_Demo"); // Execute method should be used only for the DDL queries 

			System.out.println("table dropped sucessfully ");
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
