/*
 * How to alter a table by using the execute method .which is used to for DDL queries .
 * 
 * Statement takes only static query
 * Statement query plan will be all the times  . 
 */

package com.companyname.module.statement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Statement_Ex_003_Execute_Alter {

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection();){
			
			Statement createStatement = connection.createStatement(); // Creating the statement from the connection object .
			
		//	createStatement.execute(" CREATE TABLE Student_Demo ( NAME VARCHAR2(20))"); //executing the statement 
			
			//System.out.println("table creation sucessfully ");
			
			createStatement.execute(" ALTER TABLE Student_Demo  ADD testColumn VARCHAR(20) ");

			//System.out.println("table altered sucessfully ");
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
