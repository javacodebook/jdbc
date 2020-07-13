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

public class CallableStatement_Ex_001_ExecuteUpdate_Insert {

	public static void main(String[] args) {
		
		
		try (Connection connection = DBUtil.getConnection();){
			
			CallableStatement preparecall= null;
			
			
			/*
			 * 
			 * create or replace procedure sp_insert_student_record ( st_id in varchar2, st_f_name in varchar2, st_email in varchar2, st_m_name in varchar2, st_l_name in varchar2)
			 * as 
			 * begin
			 *  	insert into STUDENT(ST_ID,FIRST_NAME,EMAIL,MIDLLE_NAME,LAST_NAME) values(st_id,st_f_name,st_email,st_m_name,st_l_name);
			 * end sp_insert_student_record;
			 * 
			 * 
			 */
			
			
			preparecall = connection.prepareCall("{call sp_insert_student_record(?,?,?,?,?)}");
			 
			preparecall.setInt(1, 100); // First ? INPUT PARAMETER Value 
			preparecall.setString(2, "Kumar"); // Second ? INPUT PARAMETER Value 
			preparecall.setString(3, "Vijay100@gmail.com"); // Third ? INPUT PARAMETER Value 
			preparecall.setString(4, "KK"); // Fourth ? INPUT PARAMETER Value 
			preparecall.setString(5, "Z"); // fifth ? INPUT PARAMETER Value 
			
			int NoOfRowsEffected =preparecall.executeUpdate();		
			
			System.out.println("No of Rows created :- "+NoOfRowsEffected);
			
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
