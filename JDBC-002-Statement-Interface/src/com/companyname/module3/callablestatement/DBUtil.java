package com.companyname.module3.callablestatement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	
	private static Connection connection = null;
	private static String url ="oracle.database.URL";
	private static String username ="oracle.database.username";
	private static String password = "oracle.database.password";
	private static Properties properties = new Properties( );
	
	static{
		try {
			properties.load(new FileReader("src/database.properties"));
			connection =DriverManager.getConnection(properties.getProperty(url),properties.getProperty(username),properties.getProperty(password));

			if(!connection.isClosed()){
				System.out.println("Connection established ...");
			}
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
	
	public static Connection getConnection(){
		return connection; 
	}

}
