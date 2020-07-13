/*
 * Updating the data by using the prepared statement .
 * 
 * prepared Statement can handle the dynamic  content .
 *  
 * We need to use "executeUpdate" method to do DML operations .
 * 
 * executeUpdate Returns the no of effected by executing that DML
 * 
 * 
 */

package com.companyname.module2.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatement_Ex_005_ExecuteUpdate_Update {

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection();){
			
			String updateSQL = "UPDATE STUDENT SET LAST_NAME=? WHERE FIRST_NAME=?";
			
			PreparedStatement  preparedStatement = connection.prepareStatement(updateSQL);
			
			preparedStatement.setString(1, "R");
			preparedStatement.setString(2, "Vijay"); // Second ? Value 
			
			int executeUpdate = preparedStatement.executeUpdate();
			
			// For the first record execution it takes :- Query -> Parse -> Optimize -> compile -> execute -> result
			
			System.out.println(" No Of rows updated : "+executeUpdate);
			
			preparedStatement.setString(1, "R"); // First ? Value 
			preparedStatement.setString(2, "Ajay"); // Second ? Value 
			
			executeUpdate = preparedStatement.executeUpdate();
			
			System.out.println(" No Of rows updated : "+executeUpdate);
			
			// For the second record execution it takes :- execute -> result
						
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
