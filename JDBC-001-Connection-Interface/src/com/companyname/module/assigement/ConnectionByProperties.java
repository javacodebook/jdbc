/*
 * This program explains the both how to get the connection from properties file and connection object auto close .
 */

package com.companyname.module.assigement;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionByProperties {

	public static void main(String[] args) {
		/*
		 * public interface Connection  extends Wrapper, AutoCloseable
		 * 
		 * AutoCloseable interface had only close method . it will close automatically once program is completed .
		 * 
		 */
		
		try (Connection connection = DBUtil.getConnection();){
			
		
			
		} catch (SQLException sqlException) {
			
			sqlException.printStackTrace();
		}
		

	}

}
