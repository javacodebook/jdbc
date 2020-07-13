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
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

public class CallableStatement_Ex_005_ExecuteQuery_SelectRecord {



	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection();){
			
			CallableStatement preparecall= null;
			
	/*
	 * CREATE OR REPLACE PROCEDURE SP_GET_ALL_STUDENT_RECORDS(c_dbuser OUT SYS_REFCURSOR) AS 
BEGIN
OPEN c_dbuser FOR
  Select * from student;
END SP_GET_ALL_STUDENT_RECORDS;
	 */
			
			
			preparecall = connection.prepareCall("{call SP_GET_ALL_STUDENT_RECORDS(?)}");
			 
			
			preparecall.registerOutParameter(1, OracleTypes.CURSOR);
			
			
			preparecall.executeQuery();
			
			ResultSet executeQueryResult = (ResultSet) preparecall.getObject(1);
				
				// For the first record execution it takes :- Query -> Parse -> Optimize -> compile -> execute -> result
				

					while(executeQueryResult.next()){
						
						System.out.println("FIRST_NAME :- "+executeQueryResult.getString("FIRST_NAME"));
						System.out.println("MIDDLE_NAME :- "+executeQueryResult.getString("MIDLLE_NAME"));
						System.out.println("EMAIL :- "+executeQueryResult.getString("EMAIL"));
						System.out.println("LAST_NAME :- "+executeQueryResult.getString("LAST_NAME"));				
					}
					
					executeQueryResult.close();
			
			
			
			
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
