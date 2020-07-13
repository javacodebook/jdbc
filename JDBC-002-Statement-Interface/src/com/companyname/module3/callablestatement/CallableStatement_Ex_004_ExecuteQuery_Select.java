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
import java.sql.Types;

public class CallableStatement_Ex_004_ExecuteQuery_Select {

	

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection();){
			
			CallableStatement preparecall= null;
			
		/*
		 * CREATE OR REPLACE PROCEDURE SP_GET_EMAIL_BY_ID 
(
  IN_ST_ID IN VARCHAR2 
, OUT_EMAIL OUT VARCHAR2 
) AS 
BEGIN
  SELECT EMAIL INTO  OUT_EMAIL FROM STUDENT WHERE ST_ID=IN_ST_ID;
END SP_GET_EMAIL_BY_ID;
		 */
			
			
			preparecall = connection.prepareCall("{call SP_GET_EMAIL_BY_ID(?,?)}");
			 
			preparecall.setInt(1, 200); // First ? INPUT PARAMETER Value 
			preparecall.registerOutParameter(2, Types.VARCHAR);
			preparecall.execute();
			
			System.out.println("Email id is "+preparecall.getString(2));
			
		
			
			
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
