/*
 * Updating the data by using the statement .
 * 
 * Statement always deals with the static content .
 *  
 * We need to use "executeUpdate" method to do DML operations .
 * 
 * executeUpdate Returns the no of effected by executing that DML
 * 
 * 
 */

package com.companyname.module.statement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Statement_Ex_005_ExecuteUpdate_Update {

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection();){
			
			Statement createStatement = connection.createStatement(); // Creating the statement from the connection object .
			
			//createStatement.execute(" CREATE TABLE STUDENT (FIRST_NAME VARCHAR2(20),MIDLLE_NAME VARCHAR2(20),EMAIL VARCHAR2(20),LAST_NAME VARCHAR2(1))"); //executing the statement 
			
			int NoOfRowsEffected =createStatement.executeUpdate(" UPDATE STUDENT  SET EMAIL ='vijaynew@gmail.com'  ");

			System.out.println("No of Rows Updated :- "+NoOfRowsEffected);
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
