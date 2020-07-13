/*
 *Statement will be auto closed.
 * 
 */

package com.companyname.module.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Statement_Ex_009_SatementClose {

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection(); Statement createStatement = connection.createStatement(); ){
			
			
			ResultSet resultSet=createStatement.executeQuery("SELECT * FROM STUDENT1 "); // For select 
			
			while(resultSet.next()){
				
				System.out.println("FIRST_NAME :- "+resultSet.getString("FIRST_NAME"));
				System.out.println("MIDDLE_NAME :- "+resultSet.getString("MIDLLE_NAME"));
				System.out.println("EMAIL :- "+resultSet.getString("EMAIL"));
				System.out.println("LAST_NAME :- "+resultSet.getString("LAST_NAME"));	
				System.out.println("AGE :- "+resultSet.getInt("AGE"));
			}
			
			
			
			resultSet.close();
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
