/*
 * Prepared statement Example for create table .
 * 
 *  Prepared statement are useful when query needs to be executed for more than once .
 *  
 *  In case of DDL statements the their is not much change when compared with statement .
 */

package com.companyname.module2.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatement_Ex_001_Execute_Create {

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection();){
			
			String createSQL = "CREATE TABLE DEMO_TEMP (NAME VARCHAR2(20))"; //DROP TABLE DEMO_TEMP
			
			PreparedStatement prepareStatement = connection.prepareStatement(createSQL); // Creating the prepared statement from the connection object .
			
			prepareStatement.execute();
			
			System.out.println("Table Creation Sucessfully ");			
			
			String dropSQL = "DROP TABLE DEMO_TEMP";
			
			prepareStatement  =connection.prepareStatement(dropSQL);
			
			prepareStatement.execute();

			System.out.println("table dropped sucessfully ");
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
