/*
 *	 
 */

package com.companyname.module1.transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class Ex_01_Datasource {

	public static void main(String[] args) {

		
		// Get the data source from DBUtil Class .
		DataSource dataSource = DBUtil.getDataSource();

		try (Connection connection = dataSource.getConnection();
				Statement createStatement = connection.createStatement();) {

			PreparedStatement prepareStatement = null;

			String selectSQL = "SELECT * FROM WELLS_FAR_GO_ACCOUNTS WHERE ACCOUNT_NO=?";

			prepareStatement = connection.prepareStatement(selectSQL);

			prepareStatement.setInt(1, 100);

			ResultSet executeQueryResult = prepareStatement.executeQuery();

			while (executeQueryResult.next()) {

				System.out.println("ACCOUNT_NO :- " + executeQueryResult.getInt("ACCOUNT_NO"));
				System.out.println("NAME :- " + executeQueryResult.getString("NAME"));
				System.out.println("BALANCE :- " + executeQueryResult.getInt("BALANCE"));

			}

			System.out.println("Balance Retrived Sucessfully ");

		} catch (SQLException sqlException) {

			sqlException.printStackTrace();
		}

	}

}
