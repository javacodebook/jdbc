/*

 * 
 */

package com.companyname.module1.transactions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class File_Storing_Ex_003_BLOB_Store {

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection(); Statement createStatement = connection.createStatement(); ){
			
			PreparedStatement prepareStatement= null;
			
			
			String insertSQL = "INSERT INTO USER_PHOTO_TABLE VALUES(?,?)";
			
			
			
			prepareStatement = connection.prepareStatement(insertSQL);
			
			prepareStatement.setInt(1, 400); 
			
			prepareStatement.setBlob(2, new FileInputStream("E:\\Java Training\\03_JDBC Training\\JDBC Notes\\indian-flag.jpg"));
			
			int noOfRecordEffected = prepareStatement.executeUpdate();
			
			System.out.println("No Of Record Effected :-"+noOfRecordEffected);

			
			System.out.println("File inserted Sucessfully ");		
			
				
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
