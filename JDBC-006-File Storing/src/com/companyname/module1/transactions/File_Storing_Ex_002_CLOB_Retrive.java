/*

 * 
 */

package com.companyname.module1.transactions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class File_Storing_Ex_002_CLOB_Retrive {

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection(); Statement createStatement = connection.createStatement(); ){
			
			PreparedStatement prepareStatement= null;
			
				
			String selectSQL = "select * from USER_RESUME_TABLE";
			
			prepareStatement = connection.prepareStatement(selectSQL);
			
			ResultSet executeQuery = prepareStatement.executeQuery();
			
			while(executeQuery.next()){
				 Clob clob = executeQuery.getClob(2);
				 InputStream asciiStream = clob.getAsciiStream();
				 
				 Files.copy(asciiStream, Paths.get("E:\\Java Training\\03_JDBC Training\\JDBC Notes\\outputResumenew.txt"));				 
			}
			
			System.out.println("Out File Saved ...");
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	

}
