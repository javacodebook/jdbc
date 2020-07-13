/*
 * How to drop a table by using the execute method .which is used to for DDL queries .
 */

package com.companyname.module.statement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Statement_Ex_002_Execute_Drop {

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection();){
			
			Statement createStatement = connection.createStatement(); // Creating the statement from the connection object .
			
			//createStatement.execute(" CREATE TABLE DEMO_TEMP ( NAME VARCHAR2(20))"); //executing the statement 
			
			//System.out.println("table creation sucessful ");
			
			createStatement.execute(" DROP TABLE Student_Demo");

			System.out.println("table dropped sucessfully ");
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
