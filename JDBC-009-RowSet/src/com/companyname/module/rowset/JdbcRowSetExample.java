/*
 * JDBC Row Set is Connected Row Set .
 * JDBC ROw Set is Navigable Row Set .
 */
package com.companyname.module.rowset;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowSetExample {

	private static final String USERNAME = "student";
	private static final String PASSWORD = "password1";
	private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:orcl1";

	public static void main(String[] args) throws SQLException {
		RowSetFactory factory = RowSetProvider.newFactory();
		JdbcRowSet jdbcRowSet = factory.createJdbcRowSet();
		jdbcRowSet.setUrl(DBURL);
		jdbcRowSet.setPassword(PASSWORD);
		jdbcRowSet.setUsername(USERNAME);

		fetchAllInformation(jdbcRowSet);
		fetchAgainAllInformation(jdbcRowSet);
	}

	private static void fetchAgainAllInformation(JdbcRowSet jdbcRowSet) throws SQLException {
		// JDBC ROw Set is Navigable Row Set :- Setting jdbcRowSet to start
		// again

		jdbcRowSet.beforeFirst();
		System.out.println("\n\n****After pointing the row set to start location*****");
		showEmployeeInformation(jdbcRowSet);
	}

	private static void fetchAllInformation(JdbcRowSet jdbcRowSet) throws SQLException {
		jdbcRowSet.setCommand("Select * from Student");
		jdbcRowSet.execute();
		showEmployeeInformation(jdbcRowSet);
	}

	private static void showEmployeeInformation(JdbcRowSet jdbcRowSet) throws SQLException {
		while (jdbcRowSet.next()) {

			System.out.println("--------------------- Row Start-----------------");
			System.out.println("FIRST_NAME :- " + jdbcRowSet.getString("FIRST_NAME"));
			System.out.println("MIDDLE_NAME :- " + jdbcRowSet.getString("MIDLLE_NAME"));
			System.out.println("EMAIL :- " + jdbcRowSet.getString("EMAIL"));
			System.out.println("LAST_NAME :- " + jdbcRowSet.getString("LAST_NAME"));

		}
	}

}
