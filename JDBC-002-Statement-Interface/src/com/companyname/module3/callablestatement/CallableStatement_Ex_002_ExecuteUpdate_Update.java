/*
 * How to insert data into tables using prepared statements .
 * 
 * 
 * We need to use "executeUpdate" method to do DML operations .
 * 
 * 
 * Prepared statements are  quick while inserting the values into data base .Because every database request is handled with some process .
 * 1) parse the input query
 * 2) compile the query 
 * 3) Analysis the query , optimize the query and plans the execution 
 * 4) execute and pass on the out put .
 * In case of prepared query first 1-3 steps been already executed ,that the reason they are quick
 * 
 * They are safe (avoid SQL injection and dynamic) 
 * 
 */

package com.companyname.module3.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class CallableStatement_Ex_002_ExecuteUpdate_Update {

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection();){
			
			CallableStatement preparecall= null;
			
			
			/*
			 * 
			 *CREATE OR REPLACE PROCEDURE SP_UPDATE_STUDENT_RECORD (
  				IN_ST_ID IN VARCHAR2 
				, IN_NEW_EMAIL_ID IN VARCHAR2 
			) AS 
			BEGIN
  					UPDATE STUDENT SET  EMAIL=IN_NEW_EMAIL_ID WHERE ST_ID = IN_ST_ID;
			END SP_UPDATE_STUDENT_RECORD;
			 * 
			 * 
			 */
			
			
			preparecall = connection.prepareCall("{call SP_UPDATE_STUDENT_RECORD(?,?)}");
			 
			preparecall.setInt(1, 12); // First ? INPUT PARAMETER Value 
			preparecall.setString(2, "NewVIJAY@gmail.com"); // Second ? INPUT PARAMETER Value 
			
			
			int NoOfRowsEffected =preparecall.executeUpdate();		
			
			System.out.println("No of Rows created :- "+NoOfRowsEffected);
			
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
