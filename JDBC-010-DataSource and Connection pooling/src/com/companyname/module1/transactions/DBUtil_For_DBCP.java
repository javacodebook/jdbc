package com.companyname.module1.transactions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBUtil_For_DBCP {

	private static String url = "oracle.database.URL";
	private static String username = "oracle.database.username";
	private static String password = "oracle.database.password";
	private static Properties properties = new Properties();
	private static BasicDataSource dataSource = null;

	static {
		try {
			properties.load(new FileReader("src/database.properties"));
			// connection
			// =DriverManager.getConnection(properties.getProperty(url),properties.getProperty(username),properties.getProperty(password));

			// Defining data source here
			dataSource = new BasicDataSource();
			dataSource.setUrl(properties.getProperty(url));
			dataSource.setUsername(properties.getProperty(username));
			dataSource.setPassword(properties.getProperty(password));
			dataSource.setInitialSize(1); // initial size 
			dataSource.setMaxIdle(20); // max connections
			dataSource.setMinIdle(10); // min connections	
			
			
			
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static DataSource getDataSource() {
		return dataSource;
	}

}
