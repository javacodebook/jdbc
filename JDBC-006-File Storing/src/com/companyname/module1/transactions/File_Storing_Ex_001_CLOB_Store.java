/*

 * 
 */

package com.companyname.module1.transactions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class File_Storing_Ex_001_CLOB_Store {

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection(); Statement createStatement = connection.createStatement(); ){
			
			PreparedStatement prepareStatement= null;
			
			
			String insertSQL = "INSERT INTO USER_RESUME_TABLE VALUES(?,?)";
			
			
			
			prepareStatement = connection.prepareStatement(insertSQL);
			
			prepareStatement.setInt(1, 200); 
			
			prepareStatement.setClob(2, new FileReader("E:\\Java Training\\03_JDBC Training\\JDBC Notes\\resume1.txt"));
			
			int noOfRecordEffected = prepareStatement.executeUpdate();
			
			System.out.println("No Of Record Effected :-"+noOfRecordEffected);

				/*while(executeQueryResult.next()){
					
					System.out.println("ACCOUNT_NO :- "+executeQueryResult.getInt("ACCOUNT_NO"));
					System.out.println("NAME :- "+executeQueryResult.getString("NAME"));
					existingBalance = executeQueryResult.getInt("BALANCE");
					System.out.println("BALANCE :- "+existingBalance);
								
				}
			*/
			System.out.println("File inserted Sucessfully ");		
			
				
			
			
			

			
			
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
