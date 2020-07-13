/*
 *Statement will be auto closed.
 * 
 */

package com.companyname.module.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Statement_Ex_010_CRUD_Operations {

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection(); Statement createStatement = connection.createStatement(); ){
			

			// 1) Creating  Table by using execute method 
			
			createStatement.execute("Create table USERS(USERNAME VARCHAR(20),PASSWORD VARCHAR(20),EMAIL VARCHAR(20))");
			
			System.out.println("Table Created.....");

			// 2) Creating Records into Table by using execute Update method 
			
			
			System.out.println("Inserting the Records into table....");
			createStatement.executeUpdate("insert into  USERS values('User1','User1@123','User1@gmail.com')");
			createStatement.executeUpdate("insert into  USERS values('User2','User2@123','User2@gmail.com')");
			createStatement.executeUpdate("insert into  USERS values('User3','User3@123','User3@gmail.com')");
			createStatement.executeUpdate("insert into  USERS values('User4','User4@123','User4@gmail.com')");
			createStatement.executeUpdate("insert into  USERS values('User5','User5@123','User5@gmail.com')");

			// 3) Retrieving the Records from Table .Fetching all users by using executeQuery method 
			
			System.out.println("Retriving  records the DataBase .....");
			ResultSet resultSet = createStatement.executeQuery("select * from USERS");

			while (resultSet.next()) {
				System.out.println("User Name :- " + resultSet.getString("USERNAME") + " PassWord " + resultSet.getString("PASSWORD")
				+ " EMAIL :- " + resultSet.getString("EMAIL"));
			}

			// 4) Updating the particular User password
			
			System.out.println("Updating records the DataBase ....");
			createStatement.executeUpdate(" update USERS set PASSWORD='ABC@123' where USERNAME='User1' ");

			ResultSet newResultSet = createStatement.executeQuery("select * from USERS  ");

			while (newResultSet.next()) {
				System.out.println("User Name :- " + newResultSet.getString("USERNAME") + " PassWord " + newResultSet.getString("PASSWORD")
						+ " EMAIL :- " + newResultSet.getString("EMAIL"));
			}
			
			// 5) Deleting a record from Table 
			
			System.out.println("Deleting records the DataBase.... ");
			createStatement.executeUpdate("delete from USERS where USERNAME='User1'");

			ResultSet updatedResultSet = createStatement.executeQuery("select * from USERS  ");

			while (updatedResultSet.next()) {
				System.out.println("User Name :- " + updatedResultSet.getString("USERNAME") + " PassWord " + updatedResultSet.getString("PASSWORD")
						+ " EMAIL :- " + updatedResultSet.getString("EMAIL"));
			}
			
			// 6) Dropping the table
			
			createStatement.execute("drop table USERS");
			
			System.out.println("Table Dropped");
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
