package com.companyname.module1.transactions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class DBUtil {
	
	
	private static String url ="oracle.database.URL";
	private static String username ="oracle.database.username";
	private static String password = "oracle.database.password";
	private static Properties properties = new Properties( );
	private static OracleDataSource dataSource=null;
	
	static{
		try {
			properties.load(new FileReader("src/database.properties"));
			//connection =DriverManager.getConnection(properties.getProperty(url),properties.getProperty(username),properties.getProperty(password));

			// Defining data source here 
			dataSource = new OracleDataSource();
			dataSource.setURL(properties.getProperty(url));
			dataSource.setUser(properties.getProperty(username));
			dataSource.setPassword(properties.getProperty(password));		
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
	
	
	
	public static DataSource getDataSource(){
		return dataSource; 
	}

}
