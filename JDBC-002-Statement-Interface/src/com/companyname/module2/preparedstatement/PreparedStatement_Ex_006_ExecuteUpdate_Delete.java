/*
 * Deleting data by using the prepared statement .
 * 
 *
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

public class PreparedStatement_Ex_006_ExecuteUpdate_Delete {

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection();){
			
			
			String updateSQL = "DELETE FROM STUDENT  WHERE  FIRST_NAME= ? ";
			
			PreparedStatement  preparedStatement = connection.prepareStatement(updateSQL);
			
			preparedStatement.setString(1, "Vijay"); // First ? Value 
		
			
			int executeUpdate = preparedStatement.executeUpdate();
			
			// For the first record execution it takes :- Query -> Parse -> Optimize -> compile -> execute -> result
			
			System.out.println(" No Of rows Deleted : "+executeUpdate);
			
			preparedStatement.setString(1, "Ajay"); // First ? Value 
			
			
			executeUpdate = preparedStatement.executeUpdate();
			
			System.out.println(" No Of rows Deleted : "+executeUpdate);
			
			// For the second record execution it takes :- execute -> result
			
			
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
