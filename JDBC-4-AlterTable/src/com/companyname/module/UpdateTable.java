package com.companyname.module;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTable {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection con ;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl1","system","admin");
		Statement st =con.createStatement();
		st.execute("ALTER TABLE std ADD middlename VARCHAR(20)");

	}

}
